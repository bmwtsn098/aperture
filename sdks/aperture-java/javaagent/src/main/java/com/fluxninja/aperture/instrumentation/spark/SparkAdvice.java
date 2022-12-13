package com.fluxninja.aperture.instrumentation.spark;

import com.fluxninja.aperture.sdk.ApertureSDK;
import net.bytebuddy.asm.Advice;

public class SparkAdvice {

    private ApertureSDK apertureSDK;

    public SparkAdvice(ApertureSDK apertureSDK) {
        this.apertureSDK = apertureSDK;
    }

//    @Advice.OnMethodEnter
//    public static void sparkAdvisor(@Advice.Return())
}
