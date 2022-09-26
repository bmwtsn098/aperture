// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: aperture/policy/language/v1/policy.proto

package com.aperture.policy.language.v1;

public interface ComponentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:aperture.policy.language.v1.Component)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Gradient controller basically calculates the ratio between the signal and the setpoint to determine the magnitude of the correction that need to be applied.
   * This controller can be used to build AIMD (Additive Increase, Multiplicative Decrease) or MIMD style response.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.GradientController gradient_controller = 1[json_name = "gradientController"];</code>
   * @return Whether the gradientController field is set.
   */
  boolean hasGradientController();
  /**
   * <pre>
   * Gradient controller basically calculates the ratio between the signal and the setpoint to determine the magnitude of the correction that need to be applied.
   * This controller can be used to build AIMD (Additive Increase, Multiplicative Decrease) or MIMD style response.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.GradientController gradient_controller = 1[json_name = "gradientController"];</code>
   * @return The gradientController.
   */
  com.aperture.policy.language.v1.GradientController getGradientController();
  /**
   * <pre>
   * Gradient controller basically calculates the ratio between the signal and the setpoint to determine the magnitude of the correction that need to be applied.
   * This controller can be used to build AIMD (Additive Increase, Multiplicative Decrease) or MIMD style response.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.GradientController gradient_controller = 1[json_name = "gradientController"];</code>
   */
  com.aperture.policy.language.v1.GradientControllerOrBuilder getGradientControllerOrBuilder();

  /**
   * <pre>
   * Exponential Moving Average filter.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.EMA ema = 2[json_name = "ema"];</code>
   * @return Whether the ema field is set.
   */
  boolean hasEma();
  /**
   * <pre>
   * Exponential Moving Average filter.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.EMA ema = 2[json_name = "ema"];</code>
   * @return The ema.
   */
  com.aperture.policy.language.v1.EMA getEma();
  /**
   * <pre>
   * Exponential Moving Average filter.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.EMA ema = 2[json_name = "ema"];</code>
   */
  com.aperture.policy.language.v1.EMAOrBuilder getEmaOrBuilder();

  /**
   * <pre>
   * Applies the given operator on input operands (signals) and emits the result.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.ArithmeticCombinator arithmetic_combinator = 3[json_name = "arithmeticCombinator"];</code>
   * @return Whether the arithmeticCombinator field is set.
   */
  boolean hasArithmeticCombinator();
  /**
   * <pre>
   * Applies the given operator on input operands (signals) and emits the result.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.ArithmeticCombinator arithmetic_combinator = 3[json_name = "arithmeticCombinator"];</code>
   * @return The arithmeticCombinator.
   */
  com.aperture.policy.language.v1.ArithmeticCombinator getArithmeticCombinator();
  /**
   * <pre>
   * Applies the given operator on input operands (signals) and emits the result.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.ArithmeticCombinator arithmetic_combinator = 3[json_name = "arithmeticCombinator"];</code>
   */
  com.aperture.policy.language.v1.ArithmeticCombinatorOrBuilder getArithmeticCombinatorOrBuilder();

  /**
   * <pre>
   * Decider emits the binary result of comparison operator on two operands.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Decider decider = 4[json_name = "decider"];</code>
   * @return Whether the decider field is set.
   */
  boolean hasDecider();
  /**
   * <pre>
   * Decider emits the binary result of comparison operator on two operands.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Decider decider = 4[json_name = "decider"];</code>
   * @return The decider.
   */
  com.aperture.policy.language.v1.Decider getDecider();
  /**
   * <pre>
   * Decider emits the binary result of comparison operator on two operands.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Decider decider = 4[json_name = "decider"];</code>
   */
  com.aperture.policy.language.v1.DeciderOrBuilder getDeciderOrBuilder();

  /**
   * <pre>
   * Switcher acts as a switch that emits one of the two signals based on third signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Switcher switcher = 5[json_name = "switcher"];</code>
   * @return Whether the switcher field is set.
   */
  boolean hasSwitcher();
  /**
   * <pre>
   * Switcher acts as a switch that emits one of the two signals based on third signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Switcher switcher = 5[json_name = "switcher"];</code>
   * @return The switcher.
   */
  com.aperture.policy.language.v1.Switcher getSwitcher();
  /**
   * <pre>
   * Switcher acts as a switch that emits one of the two signals based on third signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Switcher switcher = 5[json_name = "switcher"];</code>
   */
  com.aperture.policy.language.v1.SwitcherOrBuilder getSwitcherOrBuilder();

  /**
   * <pre>
   * Concurrency Limiter provides service protection by applying prioritized load shedding of flows using a network scheduler (e.g. Weighted Fair Queuing).
   * </pre>
   *
   * <code>.aperture.policy.language.v1.ConcurrencyLimiter concurrency_limiter = 6[json_name = "concurrencyLimiter"];</code>
   * @return Whether the concurrencyLimiter field is set.
   */
  boolean hasConcurrencyLimiter();
  /**
   * <pre>
   * Concurrency Limiter provides service protection by applying prioritized load shedding of flows using a network scheduler (e.g. Weighted Fair Queuing).
   * </pre>
   *
   * <code>.aperture.policy.language.v1.ConcurrencyLimiter concurrency_limiter = 6[json_name = "concurrencyLimiter"];</code>
   * @return The concurrencyLimiter.
   */
  com.aperture.policy.language.v1.ConcurrencyLimiter getConcurrencyLimiter();
  /**
   * <pre>
   * Concurrency Limiter provides service protection by applying prioritized load shedding of flows using a network scheduler (e.g. Weighted Fair Queuing).
   * </pre>
   *
   * <code>.aperture.policy.language.v1.ConcurrencyLimiter concurrency_limiter = 6[json_name = "concurrencyLimiter"];</code>
   */
  com.aperture.policy.language.v1.ConcurrencyLimiterOrBuilder getConcurrencyLimiterOrBuilder();

  /**
   * <pre>
   * Rate Limiter provides service protection by applying rate limiter.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.RateLimiter rate_limiter = 7[json_name = "rateLimiter"];</code>
   * @return Whether the rateLimiter field is set.
   */
  boolean hasRateLimiter();
  /**
   * <pre>
   * Rate Limiter provides service protection by applying rate limiter.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.RateLimiter rate_limiter = 7[json_name = "rateLimiter"];</code>
   * @return The rateLimiter.
   */
  com.aperture.policy.language.v1.RateLimiter getRateLimiter();
  /**
   * <pre>
   * Rate Limiter provides service protection by applying rate limiter.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.RateLimiter rate_limiter = 7[json_name = "rateLimiter"];</code>
   */
  com.aperture.policy.language.v1.RateLimiterOrBuilder getRateLimiterOrBuilder();

  /**
   * <pre>
   * Periodically runs a Prometheus query in the background and emits the result.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.PromQL promql = 8[json_name = "promql"];</code>
   * @return Whether the promql field is set.
   */
  boolean hasPromql();
  /**
   * <pre>
   * Periodically runs a Prometheus query in the background and emits the result.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.PromQL promql = 8[json_name = "promql"];</code>
   * @return The promql.
   */
  com.aperture.policy.language.v1.PromQL getPromql();
  /**
   * <pre>
   * Periodically runs a Prometheus query in the background and emits the result.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.PromQL promql = 8[json_name = "promql"];</code>
   */
  com.aperture.policy.language.v1.PromQLOrBuilder getPromqlOrBuilder();

  /**
   * <pre>
   * Emits a constant signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Constant constant = 9[json_name = "constant"];</code>
   * @return Whether the constant field is set.
   */
  boolean hasConstant();
  /**
   * <pre>
   * Emits a constant signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Constant constant = 9[json_name = "constant"];</code>
   * @return The constant.
   */
  com.aperture.policy.language.v1.Constant getConstant();
  /**
   * <pre>
   * Emits a constant signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Constant constant = 9[json_name = "constant"];</code>
   */
  com.aperture.policy.language.v1.ConstantOrBuilder getConstantOrBuilder();

  /**
   * <pre>
   * Takes an input signal and emits the square root of the input signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Sqrt sqrt = 10[json_name = "sqrt"];</code>
   * @return Whether the sqrt field is set.
   */
  boolean hasSqrt();
  /**
   * <pre>
   * Takes an input signal and emits the square root of the input signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Sqrt sqrt = 10[json_name = "sqrt"];</code>
   * @return The sqrt.
   */
  com.aperture.policy.language.v1.Sqrt getSqrt();
  /**
   * <pre>
   * Takes an input signal and emits the square root of the input signal.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Sqrt sqrt = 10[json_name = "sqrt"];</code>
   */
  com.aperture.policy.language.v1.SqrtOrBuilder getSqrtOrBuilder();

  /**
   * <pre>
   * Takes an input signal and emits the extrapolated value; either mirroring the input value or repeating the last known value up to the maximum extrapolation interval.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Extrapolator extrapolator = 11[json_name = "extrapolator"];</code>
   * @return Whether the extrapolator field is set.
   */
  boolean hasExtrapolator();
  /**
   * <pre>
   * Takes an input signal and emits the extrapolated value; either mirroring the input value or repeating the last known value up to the maximum extrapolation interval.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Extrapolator extrapolator = 11[json_name = "extrapolator"];</code>
   * @return The extrapolator.
   */
  com.aperture.policy.language.v1.Extrapolator getExtrapolator();
  /**
   * <pre>
   * Takes an input signal and emits the extrapolated value; either mirroring the input value or repeating the last known value up to the maximum extrapolation interval.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Extrapolator extrapolator = 11[json_name = "extrapolator"];</code>
   */
  com.aperture.policy.language.v1.ExtrapolatorOrBuilder getExtrapolatorOrBuilder();

  /**
   * <pre>
   * Emits the maximum of the input siganls.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Max max = 12[json_name = "max"];</code>
   * @return Whether the max field is set.
   */
  boolean hasMax();
  /**
   * <pre>
   * Emits the maximum of the input siganls.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Max max = 12[json_name = "max"];</code>
   * @return The max.
   */
  com.aperture.policy.language.v1.Max getMax();
  /**
   * <pre>
   * Emits the maximum of the input siganls.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Max max = 12[json_name = "max"];</code>
   */
  com.aperture.policy.language.v1.MaxOrBuilder getMaxOrBuilder();

  /**
   * <pre>
   * Emits the minimum of the input signals.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Min min = 13[json_name = "min"];</code>
   * @return Whether the min field is set.
   */
  boolean hasMin();
  /**
   * <pre>
   * Emits the minimum of the input signals.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Min min = 13[json_name = "min"];</code>
   * @return The min.
   */
  com.aperture.policy.language.v1.Min getMin();
  /**
   * <pre>
   * Emits the minimum of the input signals.
   * </pre>
   *
   * <code>.aperture.policy.language.v1.Min min = 13[json_name = "min"];</code>
   */
  com.aperture.policy.language.v1.MinOrBuilder getMinOrBuilder();

  public com.aperture.policy.language.v1.Component.ComponentCase getComponentCase();
}
