package defpackage;

import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* renamed from: g6  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0200g6 implements Provider {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2961a;

    public /* synthetic */ C0200g6(Object obj, int i) {
        this.a = i;
        this.f2961a = obj;
    }

    public final Object get() {
        int i = this.a;
        Object obj = this.f2961a;
        switch (i) {
            case 0:
                return ComponentDiscovery.instantiate((String) obj);
            default:
                return ComponentRuntime.Builder.lambda$addComponentRegistrar$0((ComponentRegistrar) obj);
        }
    }
}
