package com.google.firebase.perf.injection.components;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import javax.inject.Provider;

public final class DaggerFirebasePerformanceComponent implements FirebasePerformanceComponent {
    private Provider<FirebasePerformance> firebasePerformanceProvider;
    private Provider<ConfigResolver> providesConfigResolverProvider;
    private Provider<FirebaseApp> providesFirebaseAppProvider;
    private Provider<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
    private Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> providesRemoteConfigComponentProvider;
    private Provider<RemoteConfigManager> providesRemoteConfigManagerProvider;
    private Provider<SessionManager> providesSessionManagerProvider;
    private Provider<com.google.firebase.inject.Provider<TransportFactory>> providesTransportFactoryProvider;

    public static final class Builder {
        private FirebasePerformanceModule firebasePerformanceModule;

        public FirebasePerformanceComponent build() {
            FirebasePerformanceModule firebasePerformanceModule2 = this.firebasePerformanceModule;
            if (firebasePerformanceModule2 != null) {
                return new DaggerFirebasePerformanceComponent(firebasePerformanceModule2);
            }
            throw new IllegalStateException(FirebasePerformanceModule.class.getCanonicalName() + " must be set");
        }

        public Builder firebasePerformanceModule(FirebasePerformanceModule firebasePerformanceModule2) {
            firebasePerformanceModule2.getClass();
            this.firebasePerformanceModule = firebasePerformanceModule2;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [s9] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initialize(com.google.firebase.perf.injection.modules.FirebasePerformanceModule r9) {
        /*
            r8 = this;
            com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory r0 = com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseAppFactory.create(r9)
            r8.providesFirebaseAppProvider = r0
            com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory r0 = com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory.create(r9)
            r8.providesRemoteConfigComponentProvider = r0
            com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory r0 = com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory.create(r9)
            r8.providesFirebaseInstallationsProvider = r0
            com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory r0 = com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory.create(r9)
            r8.providesTransportFactoryProvider = r0
            com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory r0 = com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory.create(r9)
            r8.providesRemoteConfigManagerProvider = r0
            com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory r0 = com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesConfigResolverFactory.create(r9)
            r8.providesConfigResolverProvider = r0
            com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesSessionManagerFactory r7 = com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesSessionManagerFactory.create(r9)
            r8.providesSessionManagerProvider = r7
            javax.inject.Provider<com.google.firebase.FirebaseApp> r1 = r8.providesFirebaseAppProvider
            javax.inject.Provider<com.google.firebase.inject.Provider<com.google.firebase.remoteconfig.RemoteConfigComponent>> r2 = r8.providesRemoteConfigComponentProvider
            javax.inject.Provider<com.google.firebase.installations.FirebaseInstallationsApi> r3 = r8.providesFirebaseInstallationsProvider
            javax.inject.Provider<com.google.firebase.inject.Provider<com.google.android.datatransport.TransportFactory>> r4 = r8.providesTransportFactoryProvider
            javax.inject.Provider<com.google.firebase.perf.config.RemoteConfigManager> r5 = r8.providesRemoteConfigManagerProvider
            javax.inject.Provider<com.google.firebase.perf.config.ConfigResolver> r6 = r8.providesConfigResolverProvider
            com.google.firebase.perf.FirebasePerformance_Factory r9 = com.google.firebase.perf.FirebasePerformance_Factory.create(r1, r2, r3, r4, r5, r6, r7)
            java.lang.Object r0 = defpackage.C1383s9.b
            r9.getClass()
            boolean r0 = r9 instanceof defpackage.C1383s9
            if (r0 == 0) goto L_0x0044
            goto L_0x004a
        L_0x0044:
            s9 r0 = new s9
            r0.<init>(r9)
            r9 = r0
        L_0x004a:
            r8.firebasePerformanceProvider = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent.initialize(com.google.firebase.perf.injection.modules.FirebasePerformanceModule):void");
    }

    public FirebasePerformance getFirebasePerformance() {
        return this.firebasePerformanceProvider.get();
    }

    private DaggerFirebasePerformanceComponent(FirebasePerformanceModule firebasePerformanceModule) {
        initialize(firebasePerformanceModule);
    }
}
