package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;

/* renamed from: xc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0392xc implements ComponentFactory {
    public final /* synthetic */ Qualified a;

    public /* synthetic */ C0392xc(Qualified qualified) {
        this.a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        return FirebaseMessagingRegistrar.lambda$getComponents$0(this.a, componentContainer);
    }
}
