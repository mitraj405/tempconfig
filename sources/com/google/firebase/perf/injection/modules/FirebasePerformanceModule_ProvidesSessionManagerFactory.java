package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.SessionManager;
import javax.inject.Provider;

public final class FirebasePerformanceModule_ProvidesSessionManagerFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesSessionManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesSessionManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesSessionManagerFactory(firebasePerformanceModule);
    }

    public static SessionManager providesSessionManager(FirebasePerformanceModule firebasePerformanceModule) {
        SessionManager providesSessionManager = firebasePerformanceModule.providesSessionManager();
        C1354qp.s(providesSessionManager);
        return providesSessionManager;
    }

    public SessionManager get() {
        return providesSessionManager(this.module);
    }
}
