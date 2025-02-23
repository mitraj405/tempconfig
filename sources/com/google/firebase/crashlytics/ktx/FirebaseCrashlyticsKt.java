package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.ktx.Firebase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FirebaseCrashlytics.kt */
public final class FirebaseCrashlyticsKt {
    public static final FirebaseCrashlytics getCrashlytics(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        C1177ig.e(instance, "getInstance()");
        return instance;
    }

    public static final void setCustomKeys(FirebaseCrashlytics firebaseCrashlytics, Function1<? super KeyValueBuilder, Unit> function1) {
        C1177ig.f(firebaseCrashlytics, "<this>");
        C1177ig.f(function1, "init");
        function1.invoke(new KeyValueBuilder(firebaseCrashlytics));
    }
}
