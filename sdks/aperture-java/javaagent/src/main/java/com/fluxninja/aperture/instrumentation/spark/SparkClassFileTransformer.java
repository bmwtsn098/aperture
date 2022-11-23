package com.fluxninja.aperture.instrumentation.spark;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class SparkClassFileTransformer {
    static ClassFileTransformer Default(Instrumentation instrumentation) {
        return new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .type((ElementMatchers.any()))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .method(ElementMatchers.any())
                        .intercept(Advice.to(TimerAdvice.class))
                ).installOn(instrumentation);
    }
}

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