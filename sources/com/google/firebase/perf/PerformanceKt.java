package com.google.firebase.perf;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.Firebase;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Performance.kt */
public final class PerformanceKt {
    public static final FirebasePerformance getPerformance(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        FirebasePerformance instance = FirebasePerformance.getInstance();
        C1177ig.e(instance, "getInstance()");
        return instance;
    }

    public static final void trace(HttpMetric httpMetric, Function1<? super HttpMetric, Unit> function1) {
        C1177ig.f(httpMetric, "<this>");
        C1177ig.f(function1, "block");
        httpMetric.start();
        try {
            function1.invoke(httpMetric);
        } finally {
            httpMetric.stop();
        }
    }

    public static final <T> T trace(Trace trace, Function1<? super Trace, ? extends T> function1) {
        C1177ig.f(trace, "<this>");
        C1177ig.f(function1, "block");
        trace.start();
        try {
            return function1.invoke(trace);
        } finally {
            trace.stop();
        }
    }

    public static final <T> T trace(String str, Function1<? super Trace, ? extends T> function1) {
        C1177ig.f(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        C1177ig.f(function1, "block");
        Trace create = Trace.create(str);
        C1177ig.e(create, "create(name)");
        create.start();
        try {
            return function1.invoke(create);
        } finally {
            create.stop();
        }
    }
}
