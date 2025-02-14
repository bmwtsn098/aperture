local arithmeticcombinatorins = import './arithmeticcombinatorins.libsonnet';
local arithmeticcombinatorouts = import './arithmeticcombinatorouts.libsonnet';
{
  new():: {
    in_ports: {
      lhs: error 'Port lhs is missing',
      rhs: error 'Port rhs is missing',
    },
    out_ports: {
      output: error 'Port output is missing',
    },
  },
  inPorts:: arithmeticcombinatorins,
  outPorts:: arithmeticcombinatorouts,
  withInPorts(in_ports):: {
    in_ports: in_ports,
  },
  withInPortsMixin(in_ports):: {
    in_ports+: in_ports,
  },
  withOperator(operator):: {
    operator: operator,
  },
  withOperatorMixin(operator):: {
    operator+: operator,
  },
  withOutPorts(out_ports):: {
    out_ports: out_ports,
  },
  withOutPortsMixin(out_ports):: {
    out_ports+: out_ports,
  },
}
