---
title: Flow Control
description: Setup Flow Control
keywords:
  - install
  - setup
  - agent
  - sidecar
  - daemonset
sidebar_position: 1
---

```mdx-code-block
import DocCardList from '@theme/DocCardList';
```

Flow control in Aperture refers to the mechanism of regulating the flow of
requests in a web-scale application to ensure stability and reliability.
Aperture uses a combination of techniques such as weighted fair queuing,
distributed rate-limiting, and prioritization of critical features to manage the
flow of requests and prevent overloading. It also uses dataflow-driven policies
and a programmable, high-fidelity flow classifier to make decisions about how to
handle requests and prioritize workloads.

## Setup

Aperture can interface with service instances via _Service Meshes_ or _SDKs_:

- Service Meshes: Aperture can be deployed with no changes to application code,
  using [Envoy](https://www.envoyproxy.io/). It latches onto Envoy’s
  [External Authorization API](https://www.envoyproxy.io/docs/envoy/latest/configuration/http/http_filters/ext_authz_filter)
  for control purposes and collects access logs for telemetry purposes. On each
  request, Envoy sends request metadata to the Aperture Agent for a flow control
  decision. Inside the Aperture Agent, the request traverses classifiers,
  rate-limiters, and schedulers, before the decision to accept or drop the
  request is sent back to Envoy. Aperture participates in the
  [OpenTelemetry](https://opentelemetry.io/) tracing protocol as it inserts flow
  classification labels into requests, enabling visualization in tracing tools
  such as [Jaeger](https://www.jaegertracing.io/).
- Aperture SDKs: In addition to service mesh insertion, Aperture provides SDKs
  that can be used by developers to achieve fine-grained flow control at the
  feature level inside service code. For example, an e-commerce app may
  prioritize users in the checkout flow over new sessions when the application
  is experiencing an overload. The Aperture Controller can be programmed to
  degrade features as an escalated recovery action when basic load shedding is
  triggered for several minutes.

<DocCardList />
