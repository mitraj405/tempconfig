package defpackage;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;

/* renamed from: wb  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0377wb implements ComponentFactory {
    public final /* synthetic */ int a;

    public /* synthetic */ C0377wb(int i) {
        this.a = i;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.a) {
            case 0:
                return ExecutorsRegistrar.LITE_EXECUTOR.get();
            case 1:
                return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
            default:
                return FirebaseSessionsRegistrar.getComponents$lambda$2(componentContainer);
        }
    }
}
