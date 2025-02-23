package com.google.firebase.perf.injection.modules;

import com.google.firebase.FirebaseApp;
import javax.inject.Provider;

public final class FirebasePerformanceModule_ProvidesFirebaseAppFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseAppFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesFirebaseAppFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseAppFactory(firebasePerformanceModule);
    }

    public static FirebaseApp providesFirebaseApp(FirebasePerformanceModule firebasePerformanceModule) {
        FirebaseApp providesFirebaseApp = firebasePerformanceModule.providesFirebaseApp();
        C1354qp.s(providesFirebaseApp);
        return providesFirebaseApp;
    }

    public FirebaseApp get() {
        return providesFirebaseApp(this.module);
    }
}
