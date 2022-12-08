package com.fluxninja.aperture.instrumentation.spark;

import com.fluxninja.aperture.sdk.ApertureSDK;
import com.fluxninja.aperture.sdk.Flow;
import net.bytebuddy.implementation.bind.annotation.Origin;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SparkApertureInterceptor {
    private ApertureSDK apertureSDK;

    public void intercept(@Origin Method method) {
        Map<String, String> labels = null;
        Flow flow = apertureSDK.startFlow("awesomeFeature", labels);
        if (flow.accepted()) {
            method.i
        }
    }
}
