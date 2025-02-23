package defpackage;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

/* renamed from: Ab  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0080Ab implements Provider {
    public final /* synthetic */ int a;

    public /* synthetic */ C0080Ab(int i) {
        this.a = i;
    }

    public final Object get() {
        switch (this.a) {
            case 0:
                return ExecutorsRegistrar.scheduled(Executors.newCachedThreadPool(ExecutorsRegistrar.factory("Firebase Blocking", 11)));
            default:
                return Executors.newSingleThreadScheduledExecutor();
        }
    }
}
