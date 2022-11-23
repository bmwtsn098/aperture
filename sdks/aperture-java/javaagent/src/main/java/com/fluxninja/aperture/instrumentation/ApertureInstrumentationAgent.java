package com.fluxninja.aperture.instrumentation;

import com.fluxninja.aperture.instrumentation.spark.SparkClassFileTransformer;
import com.fluxninja.aperture.sdk.ApertureSDK;
import com.fluxninja.aperture.sdk.ApertureSDKException;

import java.lang.instrument.Instrumentation;

public class ApertureInstrumentationAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        ApertureSDK apertureSDK = null;
        try {
            apertureSDK = ApertureSDK.builder()
                    .setPort(8089)
                    .setHost("localhost")
                    .build();
        } catch (ApertureSDKException e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }
        
        inst.addTransformer(new SparkClassFileTransformer(apertureSDK));
    }
}
