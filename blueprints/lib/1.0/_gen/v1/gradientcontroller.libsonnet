local gradientcontrollerins = import './gradientcontrollerins.libsonnet';
local gradientcontrollerouts = import './gradientcontrollerouts.libsonnet';
{
  new():: {
    in_ports: {
      control_variable: error 'Port control_variable is missing',
      max: error 'Port max is missing',
      min: error 'Port min is missing',
      optimize: error 'Port optimize is missing',
      setpoint: error 'Port setpoint is missing',
      signal: error 'Port signal is missing',
    },
    out_ports: {
      output: error 'Port output is missing',
    },
  },
  inPorts:: gradientcontrollerins,
  outPorts:: gradientcontrollerouts,
  withDefaultConfig(default_config):: {
    default_config: default_config,
  },
  withDefaultConfigMixin(default_config):: {
    default_config+: default_config,
  },
  withDynamicConfigKey(dynamic_config_key):: {
    dynamic_config_key: dynamic_config_key,
  },
  withDynamicConfigKeyMixin(dynamic_config_key):: {
    dynamic_config_key+: dynamic_config_key,
  },
  withInPorts(in_ports):: {
    in_ports: in_ports,
  },
  withInPortsMixin(in_ports):: {
    in_ports+: in_ports,
  },
  withMaxGradient(max_gradient):: {
    max_gradient: max_gradient,
  },
  withMaxGradientMixin(max_gradient):: {
    max_gradient+: max_gradient,
  },
  withMinGradient(min_gradient):: {
    min_gradient: min_gradient,
  },
  withMinGradientMixin(min_gradient):: {
    min_gradient+: min_gradient,
  },
  withOutPorts(out_ports):: {
    out_ports: out_ports,
  },
  withOutPortsMixin(out_ports):: {
    out_ports+: out_ports,
  },
  withSlope(slope):: {
    slope: slope,
  },
  withSlopeMixin(slope):: {
    slope+: slope,
  },
}
