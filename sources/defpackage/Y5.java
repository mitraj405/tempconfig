package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;

/* renamed from: Y5  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Y5 implements ComponentFactory {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f699a;

    public /* synthetic */ Y5(Object obj, int i) {
        this.a = i;
        this.f699a = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        int i = this.a;
        Object obj = this.f699a;
        switch (i) {
            case 0:
                return Component.lambda$intoSet$3(obj, componentContainer);
            default:
                return DefaultHeartBeatController.lambda$component$3((Qualified) obj, componentContainer);
        }
    }
}
