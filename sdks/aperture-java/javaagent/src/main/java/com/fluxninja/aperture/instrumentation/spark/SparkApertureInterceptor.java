package com.fluxninja.aperture.instrumentation.spark;

import com.fluxninja.aperture.sdk.ApertureSDK;
import com.fluxninja.aperture.sdk.Flow;
import com.fluxninja.aperture.sdk.FlowStatus;
import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class SparkApertureInterceptor {
//    private ApertureSDK apertureSDK;

//    public void intercept(@Origin Method method) {
//        Map<String, String> labels = null;
//        Flow flow = apertureSDK.startFlow("awesomeFeature", labels);
//        if (flow.accepted()) {
//            method.i
//        }
//    }
    @RuntimeType
    public static Object intercept(@AllArguments Object[] allArguments,
                                   @SuperMethod Method superMethod,
                                   @SuperCall Callable<?> callableMethod,
                                   @Super Object superObject) throws Exception {
        System.out.println("INTERCEPTING");
        Map<String, String> labels = null;
        ApertureSDK apertureSDK = getApertureSDKFromSystemVariables();
        Flow flow = apertureSDK.startFlow("awesomeFeature", labels);
        if (flow.accepted()) {
            System.out.println("FLOW ALLOWED");
            flow.end(FlowStatus.OK);
            return callableMethod.call();
        } else {
            System.out.println("FLOW REJECTED");
            flow.end(FlowStatus.Error);
            return null;
        }
    }

    /*
    public static Object intercept(@SuperCall Callable<?> zuper) throws Exception {
        Map<String, String> labels = null;
        ApertureSDK apertureSDK = getApertureSDKFromSystemVariables();
        Flow flow = apertureSDK.startFlow("awesomeFeature", labels);
        if (flow.accepted()) {
            return zuper.call();
        } else {
            postGetHandle();
        }
    }

    private static void preGetHandle() {}
    private static void postGetHandle() {}
    */

    private static ApertureSDK getApertureSDKFromSystemVariables() {
        String host = System.getProperty("aperture.javaagent.hostname");
        String port = System.getProperty("aperture.javaagent.port");
        if (host == null) {
            host = "localhost";
        }
        if (port == null) {
            port = "8089";
        }
        ApertureSDK sdk;
        try {
            sdk = ApertureSDK.builder().setHost(host).setPort(Integer.parseInt(port)).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("fail");
        }
        return sdk;
    }

}

