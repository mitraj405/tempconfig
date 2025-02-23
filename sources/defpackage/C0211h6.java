package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* renamed from: h6  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0211h6 implements Provider {
    public final /* synthetic */ Component a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ComponentRuntime f2986a;

    public /* synthetic */ C0211h6(ComponentRuntime componentRuntime, Component component) {
        this.f2986a = componentRuntime;
        this.a = component;
    }

    public final Object get() {
        return this.f2986a.lambda$discoverComponents$0(this.a);
    }
}
