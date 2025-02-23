package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import javax.inject.Provider;

public final class FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(firebasePerformanceModule);
    }

    public static com.google.firebase.inject.Provider<TransportFactory> providesTransportFactoryProvider(FirebasePerformanceModule firebasePerformanceModule) {
        com.google.firebase.inject.Provider<TransportFactory> providesTransportFactoryProvider = firebasePerformanceModule.providesTransportFactoryProvider();
        C1354qp.s(providesTransportFactoryProvider);
        return providesTransportFactoryProvider;
    }

    public com.google.firebase.inject.Provider<TransportFactory> get() {
        return providesTransportFactoryProvider(this.module);
    }
}
