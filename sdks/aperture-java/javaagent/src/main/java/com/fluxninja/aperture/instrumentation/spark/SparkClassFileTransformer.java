package com.fluxninja.aperture.instrumentation.spark;

import com.fluxninja.aperture.instrumentation.ApertureInstrumentationAgent;
import com.fluxninja.aperture.sdk.ApertureSDK;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

import java.lang.Object;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class SparkClassFileTransformer implements ClassFileTransformer {
    ApertureSDK apertureSDK;
    private static Logger LOGGER = LoggerFactory.getLogger(ApertureInstrumentationAgent.class);

    public SparkClassFileTransformer(ApertureSDK apertureSDK) {
        this.apertureSDK = apertureSDK;
    }

    public static void premain(String arg, Instrumentation instrumentation) {
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
                ).installOn(instrumentation);
    }
}

// Method changed by opentelemetry instrumentation:
/*
    named("find")
            .and(takesArgument(0, named("spark.route.HttpMethod")))
            .and(returns(named("spark.routematch.RouteMatch")))
            .and(isPublic())
 */
// Methods that we'd like to intercept but not sure how yet
/*
    takesArgument(0, named("spark.Request"))
            .and(takesArgument(1, named("spark.Response")))
            .and(returns(named("java.lang.Object")))
            .and(isPublic())
 */


/*
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

import com.fluxninja.aperture.sdk.ApertureSDK;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;


public class SparkClassFileTransformer implements ClassFileTransformer {

    private ApertureSDK apertureSDK;

    public SparkClassFileTransformer(ApertureSDK apertureSDK) {
        this.apertureSDK = apertureSDK;
    }

    @Override
    public byte[] transform(
            ClassLoader loader,
            String className,
            Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain,
            byte[] classfileBuffer) {
        if (className.equals("spark.route.Routes")) {
            AgentBuilder.Default()
            ByteBuddy bb = new ByteBuddy();
//            try {
//                ClassPool classPool = ClassPool.getDefault();
//                CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(classfileBuffer));
//                CtMethod[] methods = ctClass.getDeclaredMethods();
//                for (CtMethod method : methods) {
//                    method.insertAfter("System.out.println(\"adding end line..\");");
//                }
//                byteCode = ctClass.toBytecode();
//                ctClass.detach();
//            } catch (Throwable ex) {
//                System.out.println("Exception: " + ex);
//                ex.printStackTrace();
//            }
        }
        return null;
    }
}
*/