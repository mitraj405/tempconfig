package com.google.firebase.remoteconfig.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

/* compiled from: RemoteConfig.kt */
public final class RemoteConfigKt {
    public static final FirebaseRemoteConfigValue get(FirebaseRemoteConfig firebaseRemoteConfig, String str) {
        C1177ig.f(firebaseRemoteConfig, "<this>");
        C1177ig.f(str, "key");
        FirebaseRemoteConfigValue value = firebaseRemoteConfig.getValue(str);
        C1177ig.e(value, "this.getValue(key)");
        return value;
    }

    public static final Flow<ConfigUpdate> getConfigUpdates(FirebaseRemoteConfig firebaseRemoteConfig) {
        C1177ig.f(firebaseRemoteConfig, "<this>");
        return new E3(new RemoteConfigKt$configUpdates$1(firebaseRemoteConfig, (Continuation<? super RemoteConfigKt$configUpdates$1>) null));
    }

    public static final FirebaseRemoteConfig getRemoteConfig(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
        C1177ig.e(instance, "getInstance()");
        return instance;
    }

    public static final FirebaseRemoteConfig remoteConfig(Firebase firebase, FirebaseApp firebaseApp) {
        C1177ig.f(firebase, "<this>");
        C1177ig.f(firebaseApp, "app");
        FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance(firebaseApp);
        C1177ig.e(instance, "getInstance(app)");
        return instance;
    }

    public static final FirebaseRemoteConfigSettings remoteConfigSettings(Function1<? super FirebaseRemoteConfigSettings.Builder, Unit> function1) {
        C1177ig.f(function1, "init");
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        function1.invoke(builder);
        FirebaseRemoteConfigSettings build = builder.build();
        C1177ig.e(build, "builder.build()");
        return build;
    }

    public static /* synthetic */ void getConfigUpdates$annotations(FirebaseRemoteConfig firebaseRemoteConfig) {
    }
}
