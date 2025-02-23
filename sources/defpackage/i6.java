package defpackage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;

/* renamed from: i6  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class i6 implements Provider {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3002a;

    public /* synthetic */ i6(Object obj, int i) {
        this.a = i;
        this.f3002a = obj;
    }

    public final Object get() {
        int i = this.a;
        Object obj = this.f3002a;
        switch (i) {
            case 0:
                return ComponentRuntime.lambda$toProviders$1((ComponentRegistrar) obj);
            default:
                return FirebaseInstallations.lambda$new$0((FirebaseApp) obj);
        }
    }
}
