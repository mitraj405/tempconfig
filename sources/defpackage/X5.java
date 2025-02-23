package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: X5  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class X5 implements ComponentFactory {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f672a;

    public /* synthetic */ X5(Object obj, int i) {
        this.a = i;
        this.f672a = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        int i = this.a;
        Object obj = this.f672a;
        switch (i) {
            case 0:
                return Component.lambda$of$1(obj, componentContainer);
            default:
                return Component.lambda$of$0(obj, componentContainer);
        }
    }
}
