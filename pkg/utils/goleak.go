package utils

import (
	"runtime"
	"time"

	"go.uber.org/goleak"
)

var ignoreFuncs = []string{
	"github.com/onsi/ginkgo/v2/internal/interrupt_handler.(*InterruptHandler).registerForInterrupts.func2",
	"github.com/onsi/ginkgo/v2/internal.(*Suite).runNode",
	"github.com/onsi/ginkgo/v2/internal.RegisterForProgressSignal.func1",
	"net/http.(*persistConn).readLoop",
	"net/http.(*persistConn).writeLoop",
	"go.opencensus.io/stats/view.(*worker).start",
	"github.com/klauspost/compress/zstd.(*blockDec).startDecoder",
	"k8s.io/klog/v2.(*loggingT).flushDaemon",
	"sync.runtime_notifyListWait",
	"google.golang.org/grpc.(*ccBalancerWrapper).watcher",
	"google.golang.org/grpc.(*addrConn).resetTransport",
	"go.opentelemetry.io/collector/service/internal/telemetry.(*ProcessMetricsViews).StartCollection.func1",
	"time.Sleep",
	// https://github.com/kubernetes/klog/issues/188
	"k8s.io/klog.(*loggingT).flushDaemon",
	// https://github.com/DataDog/dd-trace-go/issues/1469
	"github.com/golang/glog.(*loggingT).flushDaemon",
	// https://github.com/census-instrumentation/opencensus-go/issues/1191
	"go.opencensus.io/stats/view.(*worker).start",
	"github.com/DataDog/datadog-agent/pkg/trace/metrics/timing.(*Set).Autoreport.func1",
	"github.com/SAP/go-hdb/driver.(*metrics).collect",
	"internal/poll.runtime_pollWait",
}

// GoLeakDetector holds options for the goleak detector.
type GoLeakDetector struct {
	goleakOptions []goleak.Option
}

// NewGoLeakDetector creates a new GoLeakDetector with goleakOptions.
func NewGoLeakDetector() *GoLeakDetector {
	options := []goleak.Option{}
	for _, ignoreFunc := range ignoreFuncs {
		options = append(options, goleak.IgnoreTopFunction(ignoreFunc))
	}
	return &GoLeakDetector{
		goleakOptions: options,
	}
}

// AddIgnoreTopFunctions adds functions to ignore in the leak detector.
func (l *GoLeakDetector) AddIgnoreTopFunctions(fs ...string) {
	for _, f := range fs {
		l.goleakOptions = append(l.goleakOptions, goleak.IgnoreTopFunction(f))
	}
}

// FindLeaks finds memory leaks in the current process.
func (l *GoLeakDetector) FindLeaks() error {
	if err := goleak.Find(l.goleakOptions...); err == nil {
		return nil
	}

	// Give them a chance to stop.
	time.Sleep(100 * time.Millisecond)
	if err := goleak.Find(l.goleakOptions...); err == nil {
		return nil
	}

	// Last chance.
	time.Sleep(5 * time.Second)
	// FIXME(krdln/harjotgill) Is this necessary? Can GC affect goroutines?
	runtime.GC()
	return goleak.Find(l.goleakOptions...)
}
