package defpackage;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.Executors;

/* renamed from: zb  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0423zb implements Provider {
    public final /* synthetic */ int a;

    public /* synthetic */ C0423zb(int i) {
        this.a = i;
    }

    public final Object get() {
        switch (this.a) {
            case 0:
                return ExecutorsRegistrar.scheduled(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), ExecutorsRegistrar.factory("Firebase Lite", 0, ExecutorsRegistrar.litePolicy())));
            default:
                return FirebaseMessaging.lambda$clearTransportFactoryForTest$12();
        }
    }
}
