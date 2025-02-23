package com.google.firebase.analytics.ktxtesting;

import com.google.firebase.analytics.AnalyticsKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.0.2 */
public final class TestingKt {
    public static final void withAnalyticsForTest(FirebaseAnalytics firebaseAnalytics, Function0<Unit> function0) {
        C1177ig.f(firebaseAnalytics, "analytics");
        C1177ig.f(function0, "block");
        synchronized (AnalyticsKt.getLOCK()) {
            FirebaseAnalytics analytics = AnalyticsKt.getANALYTICS();
            AnalyticsKt.setANALYTICS(firebaseAnalytics);
            try {
                function0.invoke();
            } finally {
                AnalyticsKt.setANALYTICS(analytics);
            }
        }
    }
}
