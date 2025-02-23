package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;

/* renamed from: a6  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0112a6 implements ComponentFactory {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f788a;

    public /* synthetic */ C0112a6(Object obj, int i) {
        this.a = i;
        this.f788a = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        int i = this.a;
        Object obj = this.f788a;
        switch (i) {
            case 0:
                return Component.lambda$of$2(obj, componentContainer);
            default:
                return ((CrashlyticsRegistrar) obj).buildCrashlytics(componentContainer);
        }
    }
}
