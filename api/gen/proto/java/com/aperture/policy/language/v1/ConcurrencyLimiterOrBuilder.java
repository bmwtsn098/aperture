// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/policy/language/v1/policy.proto

package com.aperture.policy.language.v1;

public interface ConcurrencyLimiterOrBuilder extends
    // @@protoc_insertion_point(interface_extends:aperture.policy.language.v1.ConcurrencyLimiter)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Configuration of Weighted Fair Queuing-based workload scheduler.
   * Contains configuration of per-agent scheduler, and also defines some
   * output signals.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Scheduler scheduler = 1[json_name = "scheduler", (.grpc.gateway.protoc_gen_openapiv2.options.openapiv2_field) = { ... }</code>
   * @return Whether the scheduler field is set.
   */
  boolean hasScheduler();
  /**
   * <pre>
   * Configuration of Weighted Fair Queuing-based workload scheduler.
   * Contains configuration of per-agent scheduler, and also defines some
   * output signals.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Scheduler scheduler = 1[json_name = "scheduler", (.grpc.gateway.protoc_gen_openapiv2.options.openapiv2_field) = { ... }</code>
   * @return The scheduler.
   */
  com.aperture.policy.language.v1.Scheduler getScheduler();
  /**
   * <pre>
   * Configuration of Weighted Fair Queuing-based workload scheduler.
   * Contains configuration of per-agent scheduler, and also defines some
   * output signals.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Scheduler scheduler = 1[json_name = "scheduler", (.grpc.gateway.protoc_gen_openapiv2.options.openapiv2_field) = { ... }</code>
   */
  com.aperture.policy.language.v1.SchedulerOrBuilder getSchedulerOrBuilder();

  /**
   * <pre>
   * Actuator based on load shedding a portion of requests.
   * Actuation strategy defines the input signal that will drive the scheduler.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.LoadShedActuator load_shed_actuator = 2[json_name = "loadShedActuator"];</code>
   * @return Whether the loadShedActuator field is set.
   */
  boolean hasLoadShedActuator();
  /**
   * <pre>
   * Actuator based on load shedding a portion of requests.
   * Actuation strategy defines the input signal that will drive the scheduler.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.LoadShedActuator load_shed_actuator = 2[json_name = "loadShedActuator"];</code>
   * @return The loadShedActuator.
   */
  com.aperture.policy.language.v1.LoadShedActuator getLoadShedActuator();
  /**
   * <pre>
   * Actuator based on load shedding a portion of requests.
   * Actuation strategy defines the input signal that will drive the scheduler.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.LoadShedActuator load_shed_actuator = 2[json_name = "loadShedActuator"];</code>
   */
  com.aperture.policy.language.v1.LoadShedActuatorOrBuilder getLoadShedActuatorOrBuilder();

  public com.aperture.policy.language.v1.ConcurrencyLimiter.ActuationStrategyCase getActuationStrategyCase();
}
