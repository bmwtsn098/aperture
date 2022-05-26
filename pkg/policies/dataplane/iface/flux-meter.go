package iface

import (
	"github.com/prometheus/client_golang/prometheus"

	policylangv1 "aperture.tech/aperture/api/gen/proto/go/aperture/policy/language/v1"
)

//go:generate mockgen -source=flux-meter.go -destination=../../mocks/mock_flux_meter.go -package=mocks

// FluxMeter in an interface for interacting with fluxmeters.
type FluxMeter interface {
	// GetSelector returns the selector
	GetSelector() *policylangv1.Selector

	// GetFluxMeterProto returns the flux meter proto
	GetFluxMeterProto() *policylangv1.FluxMeter

	// GetMetricName returns the metric name
	GetMetricName() string

	// GetMetricID returns the metric ID
	GetMetricID() string

	// GetHistogram returns the histogram
	GetHistogram() prometheus.Histogram

	// GetBuckets returns the buckets
	GetBuckets() []float64
}
