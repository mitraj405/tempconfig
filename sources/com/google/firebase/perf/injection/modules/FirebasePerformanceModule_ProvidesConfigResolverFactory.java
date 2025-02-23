package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.ConfigResolver;
import javax.inject.Provider;

public final class FirebasePerformanceModule_ProvidesConfigResolverFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesConfigResolverFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesConfigResolverFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesConfigResolverFactory(firebasePerformanceModule);
    }

    public static ConfigResolver providesConfigResolver(FirebasePerformanceModule firebasePerformanceModule) {
        ConfigResolver providesConfigResolver = firebasePerformanceModule.providesConfigResolver();
        C1354qp.s(providesConfigResolver);
        return providesConfigResolver;
    }

    public ConfigResolver get() {
        return providesConfigResolver(this.module);
    }
}
