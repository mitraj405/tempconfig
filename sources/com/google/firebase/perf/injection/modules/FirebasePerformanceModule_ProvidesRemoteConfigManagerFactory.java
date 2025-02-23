package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.RemoteConfigManager;
import javax.inject.Provider;

public final class FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(firebasePerformanceModule);
    }

    public static RemoteConfigManager providesRemoteConfigManager(FirebasePerformanceModule firebasePerformanceModule) {
        RemoteConfigManager providesRemoteConfigManager = firebasePerformanceModule.providesRemoteConfigManager();
        C1354qp.s(providesRemoteConfigManager);
        return providesRemoteConfigManager;
    }

    public RemoteConfigManager get() {
        return providesRemoteConfigManager(this.module);
    }
}
