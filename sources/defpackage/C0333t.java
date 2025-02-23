package defpackage;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;

/* renamed from: t  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0333t implements ComponentFactory {
    public final /* synthetic */ int a;

    public /* synthetic */ C0333t(int i) {
        this.a = i;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.a) {
            case 0:
                return AbtRegistrar.lambda$getComponents$0(componentContainer);
            case 1:
                return ExecutorsRegistrar.BG_EXECUTOR.get();
            case 2:
                return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
            case 3:
                return FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
            default:
                return FirebaseSessionsRegistrar.getComponents$lambda$4(componentContainer);
        }
    }
}
