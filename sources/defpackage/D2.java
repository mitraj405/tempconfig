package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* renamed from: D2  reason: default package */
/* compiled from: BasicMeasure */
public final class D2 {
    public final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintWidgetContainer f105a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<ConstraintWidget> f106a = new ArrayList<>();

    /* renamed from: D2$a */
    /* compiled from: BasicMeasure */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public ConstraintWidget.a f107a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f108a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public ConstraintWidget.a f109b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f110b;
        public int c;
        public int d;
        public int e;
        public int f;
    }

    /* renamed from: D2$b */
    /* compiled from: BasicMeasure */
    public interface b {
    }

    public D2(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f105a = constraintWidgetContainer;
    }

    public final boolean a(int i, ConstraintWidget constraintWidget, b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget.a[] aVarArr = constraintWidget.f1358a;
        ConstraintWidget.a aVar = aVarArr[0];
        a aVar2 = this.a;
        aVar2.f107a = aVar;
        boolean z5 = true;
        aVar2.f109b = aVarArr[1];
        aVar2.a = constraintWidget.u();
        aVar2.b = constraintWidget.o();
        aVar2.f110b = false;
        aVar2.f = i;
        ConstraintWidget.a aVar3 = aVar2.f107a;
        ConstraintWidget.a aVar4 = ConstraintWidget.a.MATCH_CONSTRAINT;
        if (aVar3 == aVar4) {
            z = true;
        } else {
            z = false;
        }
        if (aVar2.f109b == aVar4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || constraintWidget.e <= 0.0f) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z2 || constraintWidget.e <= 0.0f) {
            z4 = false;
        } else {
            z4 = true;
        }
        ConstraintWidget.a aVar5 = ConstraintWidget.a.FIXED;
        int[] iArr = constraintWidget.f1356a;
        if (z3 && iArr[0] == 4) {
            aVar2.f107a = aVar5;
        }
        if (z4 && iArr[1] == 4) {
            aVar2.f109b = aVar5;
        }
        ((ConstraintLayout.Measurer) bVar).b(constraintWidget, aVar2);
        constraintWidget.R(aVar2.c);
        constraintWidget.O(aVar2.d);
        constraintWidget.f1388h = aVar2.f108a;
        int i2 = aVar2.e;
        constraintWidget.t = i2;
        if (i2 <= 0) {
            z5 = false;
        }
        constraintWidget.f1388h = z5;
        aVar2.f = 0;
        return aVar2.f110b;
    }

    public final void b(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int i4 = constraintWidgetContainer.u;
        int i5 = constraintWidgetContainer.v;
        constraintWidgetContainer.u = 0;
        constraintWidgetContainer.v = 0;
        constraintWidgetContainer.R(i2);
        constraintWidgetContainer.O(i3);
        if (i4 < 0) {
            constraintWidgetContainer.u = 0;
        } else {
            constraintWidgetContainer.u = i4;
        }
        if (i5 < 0) {
            constraintWidgetContainer.v = 0;
        } else {
            constraintWidgetContainer.v = i5;
        }
        ConstraintWidgetContainer constraintWidgetContainer2 = this.f105a;
        constraintWidgetContainer2.B = i;
        constraintWidgetContainer2.U();
    }

    public final void c(ConstraintWidgetContainer constraintWidgetContainer) {
        ArrayList<ConstraintWidget> arrayList = this.f106a;
        arrayList.clear();
        int size = constraintWidgetContainer.b.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.b.get(i);
            ConstraintWidget.a[] aVarArr = constraintWidget.f1358a;
            ConstraintWidget.a aVar = aVarArr[0];
            ConstraintWidget.a aVar2 = ConstraintWidget.a.MATCH_CONSTRAINT;
            if (aVar == aVar2 || aVarArr[1] == aVar2) {
                arrayList.add(constraintWidget);
            }
        }
        constraintWidgetContainer.f1395a.f398a = true;
    }
}
