package components

import (
	"go.uber.org/fx"

	policylangv1 "github.com/fluxninja/aperture/api/gen/proto/go/aperture/policy/language/v1"
	"github.com/fluxninja/aperture/pkg/config"
	"github.com/fluxninja/aperture/pkg/notifiers"
	"github.com/fluxninja/aperture/pkg/policies/controlplane/components/tristate"
	"github.com/fluxninja/aperture/pkg/policies/controlplane/iface"
	"github.com/fluxninja/aperture/pkg/policies/controlplane/runtime"
)

// logicalCombinator is n-ary logical combinator used to implement And.
type logicalCombinator struct {
	neutralElement tristate.Bool
	op             func(tristate.Bool, tristate.Bool) tristate.Bool
	name           string
}

// Name implements runtime.Component.
func (c *logicalCombinator) Name() string { return c.name }

// Type implements runtime.Component.
func (c *logicalCombinator) Type() runtime.ComponentType {
	return runtime.ComponentTypeSignalProcessor
}

// Execute implements runtime.Component.
func (c *logicalCombinator) Execute(inPortReadings runtime.PortToValue, tickInfo runtime.TickInfo) (runtime.PortToValue, error) {
	inputs := inPortReadings.ReadRepeatedValuePort("inputs")

	output := c.neutralElement
	for _, input := range inputs {
		output = c.op(output, tristate.FromReading(input))
	}

	return runtime.PortToValue{
		"output": []runtime.Reading{output.ToReading()},
	}, nil
}

// DynamicConfigUpdate is a no-op for logicalCombinator.
func (*logicalCombinator) DynamicConfigUpdate(notifiers.Event, config.Unmarshaller) {}

// NewAndAndOptions creates a new And Component.
func NewAndAndOptions(
	maxProto *policylangv1.And,
	componentIndex int,
	policyReadAPI iface.Policy,
) (runtime.Component, fx.Option, error) {
	return &logicalCombinator{
		neutralElement: tristate.True,
		op:             tristate.Bool.And,
		name:           "And",
	}, fx.Options(), nil
}

// NewOrAndOptions creates a new Or Component.
func NewOrAndOptions(
	maxProto *policylangv1.Or,
	componentIndex int,
	policyReadAPI iface.Policy,
) (runtime.Component, fx.Option, error) {
	return &logicalCombinator{
		neutralElement: tristate.False,
		op:             tristate.Bool.Or,
		name:           "Or",
	}, fx.Options(), nil
}

type inverter struct{}

// Name implements runtime.Component.
func (c *inverter) Name() string { return "Inverter" }

// Type implements runtime.Component.
func (c *inverter) Type() runtime.ComponentType { return runtime.ComponentTypeSignalProcessor }

// Execute implements runtime.Component.
func (c *inverter) Execute(inPortReadings runtime.PortToValue, tickInfo runtime.TickInfo) (runtime.PortToValue, error) {
	input := inPortReadings.ReadSingleValuePort("input")

	return runtime.PortToValue{
		"output": []runtime.Reading{
			tristate.FromReading(input).Not().ToReading(),
		},
	}, nil
}

// DynamicConfigUpdate is a no-op for not component.
func (*inverter) DynamicConfigUpdate(notifiers.Event, config.Unmarshaller) {}

// NewInverterAndOptions creates a new Inverter Component.
func NewInverterAndOptions(
	maxProto *policylangv1.Inverter,
	componentIndex int,
	policyReadAPI iface.Policy,
) (runtime.Component, fx.Option, error) {
	return &inverter{}, fx.Options(), nil
}
