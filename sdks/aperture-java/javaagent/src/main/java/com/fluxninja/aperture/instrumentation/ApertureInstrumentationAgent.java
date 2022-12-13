package com.fluxninja.aperture.instrumentation;

import com.fluxninja.aperture.instrumentation.spark.SparkClassFileTransformer;
import com.fluxninja.aperture.sdk.ApertureSDK;
import com.fluxninja.aperture.sdk.ApertureSDKException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.Instrumentation;

public class ApertureInstrumentationAgent {
    private static Logger LOGGER = LoggerFactory.getLogger(ApertureInstrumentationAgent.class);
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Running agent premain");
        LOGGER.error("RUNNING AGENT PREMAIN");
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
        System.out.println("Still running agent premain");
        LOGGER.error("STILL RUNNING AGENT PREMAIN");
        
        inst.addTransformer(new SparkClassFileTransformer(apertureSDK));
        System.out.println("Finished agent premain");
        LOGGER.error("FINISHED AGENT PREMAIN");
    }
}
