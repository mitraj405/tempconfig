package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* compiled from: Optimizer */
public final class f {
    public static final boolean[] a = new boolean[3];

    public static void a(ConstraintWidgetContainer constraintWidgetContainer, ei eiVar, ConstraintWidget constraintWidget) {
        constraintWidget.f1370c = -1;
        constraintWidget.f1375d = -1;
        ConstraintWidget.a aVar = constraintWidgetContainer.f1358a[0];
        ConstraintWidget.a aVar2 = ConstraintWidget.a.WRAP_CONTENT;
        ConstraintWidget.a aVar3 = ConstraintWidget.a.MATCH_PARENT;
        if (aVar != aVar2 && constraintWidget.f1358a[0] == aVar3) {
            ConstraintAnchor constraintAnchor = constraintWidget.f1348a;
            int i = constraintAnchor.b;
            int u = constraintWidgetContainer.u();
            ConstraintAnchor constraintAnchor2 = constraintWidget.f1371c;
            int i2 = u - constraintAnchor2.b;
            constraintAnchor.f1342a = eiVar.k(constraintAnchor);
            constraintAnchor2.f1342a = eiVar.k(constraintAnchor2);
            eiVar.d(constraintAnchor.f1342a, i);
            eiVar.d(constraintAnchor2.f1342a, i2);
            constraintWidget.f1370c = 2;
            constraintWidget.r = i;
            int i3 = i2 - i;
            constraintWidget.o = i3;
            int i4 = constraintWidget.u;
            if (i3 < i4) {
                constraintWidget.o = i4;
            }
        }
        if (constraintWidgetContainer.f1358a[1] != aVar2 && constraintWidget.f1358a[1] == aVar3) {
            ConstraintAnchor constraintAnchor3 = constraintWidget.f1363b;
            int i5 = constraintAnchor3.b;
            int o = constraintWidgetContainer.o();
            ConstraintAnchor constraintAnchor4 = constraintWidget.f1376d;
            int i6 = o - constraintAnchor4.b;
            constraintAnchor3.f1342a = eiVar.k(constraintAnchor3);
            constraintAnchor4.f1342a = eiVar.k(constraintAnchor4);
            eiVar.d(constraintAnchor3.f1342a, i5);
            eiVar.d(constraintAnchor4.f1342a, i6);
            if (constraintWidget.t > 0 || constraintWidget.w == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.f1379e;
                constraintAnchor5.f1342a = eiVar.k(constraintAnchor5);
                eiVar.d(constraintAnchor5.f1342a, constraintWidget.t + i5);
            }
            constraintWidget.f1375d = 2;
            constraintWidget.s = i5;
            int i7 = i6 - i5;
            constraintWidget.p = i7;
            int i8 = constraintWidget.v;
            if (i7 < i8) {
                constraintWidget.p = i8;
            }
        }
    }

    public static final boolean b(int i, int i2) {
        if ((i & i2) == i2) {
            return true;
        }
        return false;
    }
}
