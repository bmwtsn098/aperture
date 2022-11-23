package com.fluxninja.aperture.instrumentation.armeria;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

// TODO
public class ArmeriaClassFileTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(
            ClassLoader loader,
            String className,
            Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain,
            byte[] classfileBuffer) {
        return null;
    }
}
