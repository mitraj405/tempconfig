package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.perf.FirebasePerfRegistrar;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;

/* renamed from: xb  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0391xb implements ComponentFactory {
    public final /* synthetic */ int a;

    public /* synthetic */ C0391xb(int i) {
        this.a = i;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.a) {
            case 0:
                return UiExecutor.INSTANCE;
            case 1:
                return FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
            default:
                return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
        }
    }
}
