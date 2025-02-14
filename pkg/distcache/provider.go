// +kubebuilder:validation:Optional
package distcache

import (
	"context"
	"errors"
	stdlog "log"
	"net"
	"strconv"
	"sync"

	"github.com/buraksezer/olric"
	olricconfig "github.com/buraksezer/olric/config"
	distcachev1 "github.com/fluxninja/aperture/api/gen/proto/go/aperture/distcache/v1"
	"github.com/prometheus/client_golang/prometheus"
	"go.uber.org/fx"
	"google.golang.org/grpc"
	"google.golang.org/grpc/health"
	"google.golang.org/grpc/health/grpc_health_v1"
	"google.golang.org/protobuf/proto"

	"github.com/fluxninja/aperture/pkg/config"
	"github.com/fluxninja/aperture/pkg/info"
	"github.com/fluxninja/aperture/pkg/jobs"
	"github.com/fluxninja/aperture/pkg/log"
	"github.com/fluxninja/aperture/pkg/metrics"
	"github.com/fluxninja/aperture/pkg/net/grpcgateway"
	"github.com/fluxninja/aperture/pkg/panichandler"
	"github.com/fluxninja/aperture/pkg/peers"
)

const (
	defaultKey                 = "dist_cache"
	olricMemberlistServiceName = "olric-memberlist"
	distCacheMetricsJobName    = "dist-cache-scrape-metrics"
)

// Module provides a new DistCache FX module.
func Module() fx.Option {
	return fx.Options(
		fx.Provide(DistCacheConstructor{ConfigKey: defaultKey}.ProvideDistCache),
		fx.Provide(RegisterDistCacheService),
		grpcgateway.RegisterHandler{Handler: distcachev1.RegisterDistCacheServiceHandlerFromEndpoint}.Annotate(),
		fx.Invoke(Register),
	)
}

// swagger:operation POST /dist_cache common-configuration DistCache
// ---
// x-fn-config-env: true
// parameters:
// - in: body
//   schema:
//     "$ref": "#/definitions/DistCacheConfig"

// DistCacheConfig configures distributed cache that holds per-label counters in distributed rate limiters.
// swagger:model
// +kubebuilder:object:generate=true
type DistCacheConfig struct {
	// BindAddr denotes the address that DistCache will bind to for communication with other peer nodes.
	BindAddr string `json:"bind_addr" default:":3320" validate:"hostname_port"`
	// Address to bind mememberlist server to.
	MemberlistBindAddr string `json:"memberlist_bind_addr" default:":3322" validate:"hostname_port"`
	// Address of memberlist to advertise to other cluster members. Used for nat traversal if provided.
	MemberlistAdvertiseAddr string `json:"memberlist_advertise_addr" validate:"omitempty,hostname_port"`
	// ReplicaCount is 1 by default.
	ReplicaCount int `json:"replica_count" default:"1"`
}

// DistCache is a peer to peer distributed cache.
type DistCache struct {
	sync.Mutex
	Config  *olricconfig.Config
	Olric   *olric.Olric
	Metrics *DistCacheMetrics
}

// AddDMapCustomConfig adds a named DMap config into DistCache's config.
// If a custom config with the name does not exist, it is added. If it already exists, it is overwritten.
func (dc *DistCache) AddDMapCustomConfig(name string, dmapConfig olricconfig.DMap) {
	dc.Config.DMaps.Custom[name] = dmapConfig
}

// RemoveDMapCustomConfig removes a named DMap config from DistCache's config.
func (dc *DistCache) RemoveDMapCustomConfig(name string) {
	delete(dc.Config.DMaps.Custom, name)
}

func (dc *DistCache) scrapeMetrics(context.Context) (proto.Message, error) {
	stats, err := dc.Olric.Stats()
	if err != nil {
		log.Error().Err(err).Msgf("Failed to scrape Olric statistics")
		return nil, err
	}

	memberID := stats.Member.ID
	memberName := stats.Member.Name
	metricLabels := make(prometheus.Labels)
	metricLabels[metrics.DistCacheMemberIDLabel] = strconv.FormatUint(memberID, 10)
	metricLabels[metrics.DistCacheMemberNameLabel] = memberName

	entriesTotalGauge, err := dc.Metrics.EntriesTotal.GetMetricWith(metricLabels)
	if err != nil {
		log.Debug().Msgf("Could not extract entries total gauge metric from olric instance: %v", err)
	} else {
		entriesTotalGauge.Set(float64(stats.DMaps.EntriesTotal))
	}

	deleteHitsGauge, err := dc.Metrics.DeleteHits.GetMetricWith(metricLabels)
	if err != nil {
		log.Debug().Msgf("Could not extract delete hits gauge metric from olric instance: %v", err)
	} else {
		deleteHitsGauge.Set(float64(stats.DMaps.DeleteHits))
	}

	deleteMissesGauge, err := dc.Metrics.DeleteMisses.GetMetricWith(metricLabels)
	if err != nil {
		log.Debug().Msgf("Could not extract delete misses gauge metric from olric instance: %v", err)
	} else {
		deleteMissesGauge.Set(float64(stats.DMaps.DeleteMisses))
	}

	getMissesGauge, err := dc.Metrics.GetMisses.GetMetricWith(metricLabels)
	if err != nil {
		log.Debug().Msgf("Could not extract get misses gauge metric from olric instance: %v", err)
	} else {
		getMissesGauge.Set(float64(stats.DMaps.GetMisses))
	}

	getHitsGauge, err := dc.Metrics.GetHits.GetMetricWith(metricLabels)
	if err != nil {
		log.Debug().Msgf("Could not extract get hits gauge metric from olric instance: %v", err)
	} else {
		getHitsGauge.Set(float64(stats.DMaps.GetHits))
	}

	evictedTotalGauge, err := dc.Metrics.EvictedTotal.GetMetricWith(metricLabels)
	if err != nil {
		log.Debug().Msgf("Could not extract evicted total gauge metric from olric instance: %v", err)
	} else {
		evictedTotalGauge.Set(float64(stats.DMaps.EvictedTotal))
	}
	return nil, nil
}

// DistCacheConstructorIn holds parameters of ProvideDistCache.
type DistCacheConstructorIn struct {
	fx.In
	PeerDiscovery      *peers.PeerDiscovery
	PrometheusRegistry *prometheus.Registry
	LivenessMultiJob   *jobs.MultiJob `name:"liveness.service"`
	Unmarshaller       config.Unmarshaller
	Lifecycle          fx.Lifecycle
	Shutdowner         fx.Shutdowner
	Logger             *log.Logger
}

// DistCacheConstructor holds fields to create an instance of DistCache.
type DistCacheConstructor struct {
	ConfigKey     string
	DefaultConfig DistCacheConfig
}

// ProvideDistCache creates a new instance of distributed cache.
// It also hooks in the service discovery plugin.
func (constructor DistCacheConstructor) ProvideDistCache(in DistCacheConstructorIn) (*DistCache, error) {
	defaultConfig := constructor.DefaultConfig
	if err := in.Unmarshaller.UnmarshalKey(constructor.ConfigKey, &defaultConfig); err != nil {
		log.Error().Err(err).Msg("Unable to deserialize configuration of DistCache")
		return nil, err
	}

	memberlistEnv := "lan"
	oc := olricconfig.New(memberlistEnv)
	oc.ServiceDiscovery = map[string]interface{}{
		"plugin": &ServiceDiscovery{
			discovery: in.PeerDiscovery,
		},
	}
	oc.ReplicaCount = defaultConfig.ReplicaCount
	oc.WriteQuorum = 1
	oc.ReadQuorum = 1
	oc.MemberCountQuorum = 1
	oc.DMaps.Custom = make(map[string]olricconfig.DMap)
	oc.Logger = stdlog.New(&OlricLogWriter{Logger: in.Logger}, "", 0)

	bindAddr, port, err := net.SplitHostPort(defaultConfig.BindAddr)
	if err != nil {
		log.Error().Err(err).Msg("Unable to split bind_addr")
		return nil, err
	}
	bindPort, _ := strconv.Atoi(port)

	if bindAddr == "" {
		bindAddr = info.LocalIP
	}
	oc.BindAddr = bindAddr
	oc.BindPort = bindPort

	memberlistBindAddr, p, err := net.SplitHostPort(defaultConfig.MemberlistBindAddr)
	if err != nil {
		log.Error().Err(err).Msg("Unable to split memberlist bind address")
		return nil, err
	}
	memberlistBindPort, _ := strconv.Atoi(p)

	if memberlistBindAddr == "" {
		memberlistBindAddr = info.LocalIP
	}
	oc.MemberlistConfig.BindAddr = memberlistBindAddr
	oc.MemberlistConfig.BindPort = memberlistBindPort
	memberlistAddr := oc.MemberlistConfig.BindAddr + ":" + strconv.Itoa(oc.MemberlistConfig.BindPort)

	if defaultConfig.MemberlistAdvertiseAddr != "" {
		advertiseAddr, p, e := net.SplitHostPort(defaultConfig.MemberlistAdvertiseAddr)
		if e != nil {
			log.Error().Err(e).Msg("Unable to split memberlist advertise address")
			return nil, e
		}
		advertisePort, _ := strconv.Atoi(p)
		oc.MemberlistConfig.AdvertiseAddr = advertiseAddr
		oc.MemberlistConfig.AdvertisePort = advertisePort
		memberlistAddr = defaultConfig.MemberlistAdvertiseAddr
	}

	in.PeerDiscovery.RegisterService(olricMemberlistServiceName, memberlistAddr)

	startChan := make(chan struct{})
	oc.Started = func() {
		log.Info().Msg("DistCache started")
		startChan <- struct{}{}
	}

	o, err := olric.New(oc)
	if err != nil {
		return nil, err
	}

	dc := &DistCache{
		Config:  oc,
		Olric:   o,
		Metrics: newDistCacheMetrics(),
	}

	job := &jobs.BasicJob{
		JobBase: jobs.JobBase{
			JobName: distCacheMetricsJobName,
		},
		JobFunc: dc.scrapeMetrics,
	}

	in.Lifecycle.Append(fx.Hook{
		OnStart: func(ctx context.Context) error {
			// Register metrics with Prometheus.
			err := dc.Metrics.registerMetrics(in.PrometheusRegistry)
			if err != nil {
				log.Error().Err(err).Msg("Failed to register distcache metrics with Prometheus registry")
				return err
			}

			panichandler.Go(func() {
				startErr := dc.Olric.Start()
				if startErr != nil {
					log.Error().Err(startErr).Msg("Failed to start distcache")
				}
				_ = in.Shutdowner.Shutdown()
			})
			// wait for olric to start by waiting on startChan until ctx is canceled
			select {
			case <-ctx.Done():
				return errors.New("olric failed to start")
			case <-startChan:
			}

			err = in.LivenessMultiJob.RegisterJob(job)
			if err != nil {
				log.Error().Err(err).Msg("Failed to register distcache scrape metrics job with jobGroup")
				return err
			}
			return nil
		},
		OnStop: func(ctx context.Context) error {
			err := in.LivenessMultiJob.DeregisterJob(distCacheMetricsJobName)
			if err != nil {
				log.Error().Err(err).Msg("Failed to deregister distcache scrape metrics job with jobGroup")
				return err
			}

			err = dc.Olric.Shutdown(ctx)
			if err != nil {
				return err
			}

			// Unregister metrics with Prometheus.
			err = dc.Metrics.unregisterMetrics(in.PrometheusRegistry)
			if err != nil {
				log.Error().Err(err).Msg("Failed to unregister distcache metrics with Prometheus registry")
				return err
			}
			return nil
		},
	})

	return dc, nil
}

// Register registers the handler on grpc.Server.
func Register(handler *DistCacheService,
	server *grpc.Server,
	healthsrv *health.Server,
) error {
	distcachev1.RegisterDistCacheServiceServer(server, handler)

	healthsrv.SetServingStatus("aperture.distcache.v1.DistCacheService", grpc_health_v1.HealthCheckResponse_SERVING)
	log.Info().Msg("DistCache Stats handler registered")
	return nil
}
