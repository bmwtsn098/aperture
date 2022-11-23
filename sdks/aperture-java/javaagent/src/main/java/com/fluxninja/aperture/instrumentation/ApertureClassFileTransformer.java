package com.fluxninja.aperture.instrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

// TODO: remove or use as a base class if applicable
public class ApertureClassFileTransformer implements ClassFileTransformer {

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
