package com.google.firebase.perf.injection.modules;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import javax.inject.Provider;

public final class FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(firebasePerformanceModule);
    }

    public static com.google.firebase.inject.Provider<RemoteConfigComponent> providesRemoteConfigComponent(FirebasePerformanceModule firebasePerformanceModule) {
        com.google.firebase.inject.Provider<RemoteConfigComponent> providesRemoteConfigComponent = firebasePerformanceModule.providesRemoteConfigComponent();
        C1354qp.s(providesRemoteConfigComponent);
        return providesRemoteConfigComponent;
    }

    public com.google.firebase.inject.Provider<RemoteConfigComponent> get() {
        return providesRemoteConfigComponent(this.module);
    }
}
