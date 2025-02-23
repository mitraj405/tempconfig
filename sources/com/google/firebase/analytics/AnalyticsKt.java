package com.google.firebase.analytics;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.0.2 */
public final class AnalyticsKt {
    private static volatile FirebaseAnalytics zza;
    private static final Object zzb = new Object();

    public static final FirebaseAnalytics getANALYTICS() {
        return zza;
    }

    public static final FirebaseAnalytics getAnalytics(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        if (zza == null) {
            synchronized (zzb) {
                if (zza == null) {
                    zza = FirebaseAnalytics.getInstance(FirebaseKt.getApp(Firebase.INSTANCE).getApplicationContext());
                }
            }
        }
        FirebaseAnalytics firebaseAnalytics = zza;
        C1177ig.c(firebaseAnalytics);
        return firebaseAnalytics;
    }

    public static final Object getLOCK() {
        return zzb;
    }

    public static final void logEvent(FirebaseAnalytics firebaseAnalytics, String str, Function1<? super ParametersBuilder, Unit> function1) {
        C1177ig.f(firebaseAnalytics, "<this>");
        C1177ig.f(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        C1177ig.f(function1, "block");
        ParametersBuilder parametersBuilder = new ParametersBuilder();
        function1.invoke(parametersBuilder);
        firebaseAnalytics.logEvent(str, parametersBuilder.getBundle());
    }

    public static final void setANALYTICS(FirebaseAnalytics firebaseAnalytics) {
        zza = firebaseAnalytics;
    }

    public static final void setConsent(FirebaseAnalytics firebaseAnalytics, Function1<? super ConsentBuilder, Unit> function1) {
        C1177ig.f(firebaseAnalytics, "<this>");
        C1177ig.f(function1, "block");
        ConsentBuilder consentBuilder = new ConsentBuilder();
        function1.invoke(consentBuilder);
        firebaseAnalytics.setConsent(consentBuilder.asMap());
    }
}
