# Blueprints Layout

Every blueprint consists of three files: `main.libsonnet` `config.libsonnet` and
`metadata.yaml`

## metadata.yaml

This file specifies some metadata about the blueprint that is current used to
auto generate README.md configuration section.

An example metadata looks like this:

```yaml
blueprint: Latency Gradient Concurrency Limiting Policy
sources:
  Dashboard:
    prefix: dashboard
    path: lib/1.0/blueprints/latency-gradient-concurrency-limiting/dashboard.libsonnet
  Policy:
    prefix: policy
    path: lib/1.0/blueprints/latency-gradient-concurrency-limiting/policy.libsonnet
```

- `blueprint` key is currently unused, but it names this specific bundle
- `sources` provides a list of dashboards and policies that are part of this
  blueprint.

### More on sources

Every blueprint can be built from multiple dashboards and policies, and to
properly generate README.md we need to know some details about what source
libraries are used.

Every item of the `sources` list is a nested object, whose top key becomes a
section of the README.md documentation. `prefix` should match the key under
which policy or dashboard configuration is available in `config.libsonnet` and
`path` is a path to the library, relative to repository root.

## main.libsonnet

An example:

```yaml
local dashboard = import '../../lib/1.0/dashboards/latency-gradient-concurrency-limiting.libsonnet';
local policyResource = import '../../lib/1.0/policies/latency-gradient-concurrency-limiting.libsonnet';

local config = import './config.libsonnet';

{
  policies: {
    [std.format('%s.yaml', $._config.policy.policyName)]: policyResource($._config.policy),
  },
  dashboards: {
    [std.format('%s.json', $._config.common.policyName)]: dashboard($._config.dashboard),
  },
} +
{
  _config:: config
}
```

This file glues together all policies and dashboards that are part of the
blueprint. The object must have two keys: `policies` and `dashboards` - other
keys should be hidden from the generated JSON data. Both keys should be mappings
between file names and rendered dashboards and policies.

This is used by `scripts/aperture-generate.py` to generate JSON files directly
from blueprints.

## config.libsonnet

An example (partial):

```jsonnet
{
  /**
  * @section Latency Gradient Concurrency Limiting Policy
  *
  * @param (policy.policyName: string required) A name of the policy, used within PromQL queries for fluxmeter metrics.
  * @param (policy.evaluationInterval: string) How often should policy be re-evaluated.
  */
  policy: {
    policyName: error 'policyName is not set',
    evaluationInterval: '0.5s',
  }
}
```

`config.libsonnet` provides configuration for the blueprint that has two uses:

- a reference for the user
- source of configuration reference for README.md

This file must be kept in sync with libraries - when adding new defaults to
libraries, all blueprints should be updated to match them.

### Configuration Reference

Configuration reference can be autogenerated from config.libsonnet based on
docblock comments.

Parser knows about the following docblock tags: `@section`, `@subsection` and
`@param`.

`@section` tag is used to match docblock to the README.md configuration section
(See [More on sources][more on sources] from `metadata.yaml` description). This
field is required.

`@subsection` must be unique within single `@section` and it's used to separate
parts of the configuration reference with sub headings.

`@param` can be used to add documentation for specific fields. It's format is as
follow:

```
@param (documented.key: type <optional required>) Documentation
```

`documented.key` must be a full path to the key that is being documented. `type`
is not validated but should be one of:

- string
- number
- boolean
- aperture libsonnet type (e.g. `[]aperture.spec.v1.SchedulerWorkload`)

It's not used for anything else currently, but keeping it consistent is a win
for users.

`<optional required>` is an optional `required` string that marks given variable
as required. Required variables are marked as `(required)` in the Default column
of the generated README.md.

# Updating README.md

README.md generator depends on Python 3.8+ and some extra libraries that can be
installed from `dev-requirements.txt`:

```sh
pip install -r dev-requirements.txt
```

To update README.md from blueprint configuration, use
`scripts/blueprint-readme-generator.py`:

```sh
$ ./scripts/blueprint-readme-generator.py blueprints/latency-gradient-concurrency-limiting
$
```

It will take the existing README.md, look for a configuration marker:
`[configuration]: # Configuration` and replace existing generated docs with new
content.

## Blueprint Visualization

Blueprints can be visualized. A blueprint is saved as a
[DOT](https://graphviz.org/doc/info/lang.html) file and then can be converted
into an image with GraphViz:

```sh
go run -mod=mod scripts/circuit-compiler/main.go -cr blueprints/latency-gradient-concurrency-limiting/example/gen/policies/example.yaml -dot blueprints/latency-gradient-concurrency-limiting/example/gen/graph/graph.dot
dot -Tsvg  blueprints/latency-gradient-concurrency-limiting/example/gen/graph/graph.dot > blueprints/latency-gradient-concurrency-limiting/example/gen/graph/graph.svg
```

Before doing so make sure that generated yamls are up-to-date.

You can now view visualized blueprint.
