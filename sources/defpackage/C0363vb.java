package defpackage;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;

/* renamed from: vb  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0363vb implements ComponentFactory {
    public final /* synthetic */ int a;

    public /* synthetic */ C0363vb(int i) {
        this.a = i;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.a) {
            case 0:
                return ExecutorsRegistrar.BLOCKING_EXECUTOR.get();
            case 1:
                return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
            case 2:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
            case 3:
                return FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
            default:
                return FirebaseSessionsRegistrar.getComponents$lambda$5(componentContainer);
        }
    }
}
