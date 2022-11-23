package com.fluxninja.aperture.instrumentation;

import net.bytebuddy.asm.Advice;

// This could be one way of doing this - insert aperture SDK flow start and end where applicable;
// Might be hard to handle accept/deny though
public class ApertureSDKAdvice {
    @Advice.OnMethodEnter
    static long enter(@Advice.Origin String method) throws Exception {

        long start = System.currentTimeMillis();
        return start;
    }

    @Advice.OnMethodExit
    static void exit(@Advice.Origin String method, @Advice.Enter long start) throws Exception {

        long end = System.currentTimeMillis();
        System.out.println(method + " took " + (end - start) + " milliseconds ");
    }
}
