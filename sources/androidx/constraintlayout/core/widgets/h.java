package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.D2;

/* compiled from: VirtualLayout */
public class h extends Te {
    public int C = 0;
    public int D = 0;
    public int E = 0;
    public int F = 0;
    public int G = 0;
    public int H = 0;
    public int I = 0;
    public int J = 0;
    public final D2.a a = new D2.a();

    /* renamed from: a  reason: collision with other field name */
    public D2.b f1417a = null;
    public boolean l = false;

    public final void W(ConstraintWidget constraintWidget, ConstraintWidget.a aVar, int i, ConstraintWidget.a aVar2, int i2) {
        D2.b bVar;
        boolean z;
        ConstraintWidget constraintWidget2;
        while (true) {
            bVar = this.f1417a;
            if (bVar != null || (constraintWidget2 = this.f1349a) == null) {
                D2.a aVar3 = this.a;
                aVar3.f107a = aVar;
                aVar3.f109b = aVar2;
                aVar3.a = i;
                aVar3.b = i2;
                ((ConstraintLayout.Measurer) bVar).b(constraintWidget, aVar3);
                constraintWidget.R(aVar3.c);
                constraintWidget.O(aVar3.d);
                constraintWidget.f1388h = aVar3.f108a;
                int i3 = aVar3.e;
                constraintWidget.t = i3;
            } else {
                this.f1417a = ((ConstraintWidgetContainer) constraintWidget2).f1393a;
            }
        }
        D2.a aVar32 = this.a;
        aVar32.f107a = aVar;
        aVar32.f109b = aVar2;
        aVar32.a = i;
        aVar32.b = i2;
        ((ConstraintLayout.Measurer) bVar).b(constraintWidget, aVar32);
        constraintWidget.R(aVar32.c);
        constraintWidget.O(aVar32.d);
        constraintWidget.f1388h = aVar32.f108a;
        int i32 = aVar32.e;
        constraintWidget.t = i32;
        if (i32 > 0) {
            z = true;
        } else {
            z = false;
        }
        constraintWidget.f1388h = z;
    }

    public final void b() {
        for (int i = 0; i < this.B; i++) {
            ConstraintWidget constraintWidget = this.c[i];
            if (constraintWidget != null) {
                constraintWidget.f1390j = true;
            }
        }
    }

    public void V(int i, int i2, int i3, int i4) {
    }
}
