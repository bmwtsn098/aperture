package static

import (
	"encoding/json"

	entitycachev1 "github.com/fluxninja/aperture/api/gen/proto/go/aperture/entitycache/v1"
	"github.com/fluxninja/aperture/pkg/log"
	"github.com/fluxninja/aperture/pkg/notifiers"
)

// StaticDiscovery reads entities from config and writes them to tracker.
type StaticDiscovery struct {
	entityEvents notifiers.EventWriter
	services     []*ServiceConfig
}

func newStaticServiceDiscovery(
	entityEvents notifiers.EventWriter,
	config StaticDiscoveryConfig,
) *StaticDiscovery {
	return &StaticDiscovery{
		entityEvents: entityEvents,
		services:     config.Services,
	}
}

// start loads all configured entities into the tracker.
func (sd *StaticDiscovery) start() error {
	entities := sd.entitiesFromConfig()
	log.Debug().Msgf("Uploading %v pre-configured entities to tracker", len(entities))
	for rawKey, entity := range entities {
		key := notifiers.Key(rawKey)
		value, err := json.Marshal(entity)
		if err != nil {
			log.Error().Msgf("Error marshaling entity: %v", err)
			return err
		}
		sd.entityEvents.WriteEvent(key, value)
	}
	log.Info().Msgf("Uploaded %v pre-configured entities to tracker", len(entities))
	return nil
}

func (sd *StaticDiscovery) stop() error {
	sd.entityEvents.Purge("")
	return nil
}

func (sd *StaticDiscovery) entitiesFromConfig() map[string]*entitycachev1.Entity {
	// entities maps entity tracker key to the entity.
	// We assume that configured entities are consistent, i.e. same Prefix+UID implies equality of other fields
	entities := make(map[string]*entitycachev1.Entity)

	for _, service := range sd.services {
		serviceName := service.Name
		for _, e := range service.Entities {
			key := e.UID

			var entity *entitycachev1.Entity
			var ok bool

			if entity, ok = entities[key]; !ok {
				entity = &entitycachev1.Entity{
					IpAddress: e.IPAddress,
					Prefix:    staticEntityTrackerPrefix,
					Uid:       e.UID,
					Services:  nil,
					Name:      e.Name,
				}
				entities[key] = entity
			}

			entity.Services = append(entity.Services, serviceName)
		}
	}

	return entities
}
