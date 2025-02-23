package defpackage;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.concurrent.Executors;

/* renamed from: Bb  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Bb implements Provider {
    public final /* synthetic */ int a;

    public /* synthetic */ Bb(int i) {
        this.a = i;
    }

    public final Object get() {
        switch (this.a) {
            case 0:
                return Executors.newSingleThreadScheduledExecutor(ExecutorsRegistrar.factory("Firebase Scheduler", 0));
            case 1:
                return FirebaseMessaging.lambda$static$0();
            case 2:
                return GaugeManager.lambda$new$0();
            default:
                return RemoteConfigComponent.lambda$getFetchHandler$0();
        }
    }
}
