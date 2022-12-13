package com.fluxninja.aperture.instrumentation;

import com.fluxninja.aperture.instrumentation.spark.SparkApertureInterceptor;
import com.fluxninja.aperture.instrumentation.spark.SparkClassFileTransformer;
import com.fluxninja.aperture.sdk.ApertureSDK;
import com.fluxninja.aperture.sdk.ApertureSDKException;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class ApertureInstrumentationAgent {
    private static Logger LOGGER = LoggerFactory.getLogger(ApertureInstrumentationAgent.class);
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("CREATING AGENT!");
        LOGGER.error("CREATING AGENT!");
        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager()) // TODO: what does it do
                .type((ElementMatchers.named("spark.route.Routes"))) // TODO: not this class...
                .transform((builder, typeDescription, classLoader, module, protectionDomain) -> builder
                        .method(
                                ElementMatchers.named("find")
                                        .and(takesArgument(0, named("spark.route.HttpMethod")))
                                        .and(returns(named("spark.routematch.RouteMatch")))
                                        .and(isPublic()))
                        .intercept(MethodDelegation.to(SparkApertureInterceptor.class))
                ).installOn(inst);
    }
}
