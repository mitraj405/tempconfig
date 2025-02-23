package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.perf.FirebasePerfRegistrar;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;

/* renamed from: yc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0407yc implements ComponentFactory {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Qualified f3430a;

    public /* synthetic */ C0407yc(Qualified qualified, int i) {
        this.a = i;
        this.f3430a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        int i = this.a;
        Qualified qualified = this.f3430a;
        switch (i) {
            case 0:
                return FirebasePerfRegistrar.lambda$getComponents$0(qualified, componentContainer);
            default:
                return RemoteConfigRegistrar.lambda$getComponents$0(qualified, componentContainer);
        }
    }
}
