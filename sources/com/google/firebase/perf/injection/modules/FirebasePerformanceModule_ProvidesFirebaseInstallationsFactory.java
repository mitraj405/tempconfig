package com.google.firebase.perf.injection.modules;

import com.google.firebase.installations.FirebaseInstallationsApi;
import javax.inject.Provider;

public final class FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(firebasePerformanceModule);
    }

    public static FirebaseInstallationsApi providesFirebaseInstallations(FirebasePerformanceModule firebasePerformanceModule) {
        FirebaseInstallationsApi providesFirebaseInstallations = firebasePerformanceModule.providesFirebaseInstallations();
        C1354qp.s(providesFirebaseInstallations);
        return providesFirebaseInstallations;
    }

    public FirebaseInstallationsApi get() {
        return providesFirebaseInstallations(this.module);
    }
}
