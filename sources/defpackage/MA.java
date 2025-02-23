package defpackage;

import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: MA  reason: default package */
/* compiled from: TrimPathContent */
public final class MA implements V6, C0335t2.a {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final C0093Gc f401a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f402a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f403a;
    public final C0093Gc b;
    public final C0093Gc c;

    public MA(C0359v2 v2Var, C0430zw zwVar) {
        zwVar.getClass();
        this.f403a = zwVar.f3492a;
        this.a = zwVar.a;
        C0335t2<Float, Float> b2 = zwVar.f3491a.b();
        this.f401a = (C0093Gc) b2;
        C0335t2<Float, Float> b3 = zwVar.b.b();
        this.b = (C0093Gc) b3;
        C0335t2<Float, Float> b4 = zwVar.c.b();
        this.c = (C0093Gc) b4;
        v2Var.g(b2);
        v2Var.g(b3);
        v2Var.g(b4);
        b2.a(this);
        b3.a(this);
        b4.a(this);
    }

    public final void e(C0335t2.a aVar) {
        this.f402a.add(aVar);
    }

    public final void f() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f402a;
            if (i < arrayList.size()) {
                ((C0335t2.a) arrayList.get(i)).f();
                i++;
            } else {
                return;
            }
        }
    }

    public final void d(List<V6> list, List<V6> list2) {
    }
}
