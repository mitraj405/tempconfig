package defpackage;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.session.gauges.GaugeManager;
import java.util.concurrent.Executors;

/* renamed from: yb  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0406yb implements Provider {
    public final /* synthetic */ int a;

    public /* synthetic */ C0406yb(int i) {
        this.a = i;
    }

    public final Object get() {
        switch (this.a) {
            case 0:
                return ExecutorsRegistrar.scheduled(Executors.newFixedThreadPool(4, ExecutorsRegistrar.factory("Firebase Background", 10, ExecutorsRegistrar.bgPolicy())));
            default:
                return GaugeManager.lambda$new$1();
        }
    }
}
