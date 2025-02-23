package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Guideline */
public final class e extends ConstraintWidget {
    public int B = -1;
    public int C = -1;
    public int D;
    public float h = -1.0f;
    public ConstraintAnchor i = this.f1363b;
    public boolean l;

    public e() {
        this.D = 0;
        this.f1353a.clear();
        this.f1353a.add(this.i);
        int length = this.f1357a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f1357a[i2] = this.i;
        }
    }

    public final boolean E() {
        return this.l;
    }

    public final boolean F() {
        return this.l;
    }

    public final void T(ei eiVar, boolean z) {
        if (this.f1349a != null) {
            ConstraintAnchor constraintAnchor = this.i;
            eiVar.getClass();
            int n = ei.n(constraintAnchor);
            if (this.D == 1) {
                this.r = n;
                this.s = 0;
                O(this.f1349a.o());
                R(0);
                return;
            }
            this.r = 0;
            this.s = n;
            R(this.f1349a.u());
            O(0);
        }
    }

    public final void U(int i2) {
        this.i.l(i2);
        this.l = true;
    }

    public final void V(int i2) {
        if (this.D != i2) {
            this.D = i2;
            ArrayList<ConstraintAnchor> arrayList = this.f1353a;
            arrayList.clear();
            if (this.D == 1) {
                this.i = this.f1348a;
            } else {
                this.i = this.f1363b;
            }
            arrayList.add(this.i);
            ConstraintAnchor[] constraintAnchorArr = this.f1357a;
            int length = constraintAnchorArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                constraintAnchorArr[i3] = this.i;
            }
        }
    }

    public final void e(ei eiVar, boolean z) {
        boolean z2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.f1349a;
        if (constraintWidgetContainer != null) {
            ConstraintAnchor m = constraintWidgetContainer.m(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor m2 = constraintWidgetContainer.m(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.f1349a;
            ConstraintWidget.a aVar = ConstraintWidget.a.WRAP_CONTENT;
            boolean z3 = true;
            if (constraintWidget == null || constraintWidget.f1358a[0] != aVar) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.D == 0) {
                m = constraintWidgetContainer.m(ConstraintAnchor.Type.TOP);
                m2 = constraintWidgetContainer.m(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.f1349a;
                if (constraintWidget2 == null || constraintWidget2.f1358a[1] != aVar) {
                    z3 = false;
                }
                z2 = z3;
            }
            if (this.l) {
                ConstraintAnchor constraintAnchor = this.i;
                if (constraintAnchor.f1343a) {
                    C0415yx k = eiVar.k(constraintAnchor);
                    eiVar.d(k, this.i.d());
                    if (this.B != -1) {
                        if (z2) {
                            eiVar.f(eiVar.k(m2), k, 0, 5);
                        }
                    } else if (this.C != -1 && z2) {
                        C0415yx k2 = eiVar.k(m2);
                        eiVar.f(k, eiVar.k(m), 0, 5);
                        eiVar.f(k2, k, 0, 5);
                    }
                    this.l = false;
                    return;
                }
            }
            if (this.B != -1) {
                C0415yx k3 = eiVar.k(this.i);
                eiVar.e(k3, eiVar.k(m), this.B, 8);
                if (z2) {
                    eiVar.f(eiVar.k(m2), k3, 0, 5);
                }
            } else if (this.C != -1) {
                C0415yx k4 = eiVar.k(this.i);
                C0415yx k5 = eiVar.k(m2);
                eiVar.e(k4, k5, -this.C, 8);
                if (z2) {
                    eiVar.f(k4, eiVar.k(m), 0, 5);
                    eiVar.f(k5, k4, 0, 5);
                }
            } else if (this.h != -1.0f) {
                C0415yx k6 = eiVar.k(this.i);
                C0415yx k7 = eiVar.k(m2);
                float f = this.h;
                L1 l2 = eiVar.l();
                l2.f377a.j(k6, -1.0f);
                l2.f377a.j(k7, f);
                eiVar.c(l2);
            }
        }
    }

    public final boolean f() {
        return true;
    }

    public final void j(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.j(constraintWidget, hashMap);
        e eVar = (e) constraintWidget;
        this.h = eVar.h;
        this.B = eVar.B;
        this.C = eVar.C;
        V(eVar.D);
    }

    public final ConstraintAnchor m(ConstraintAnchor.Type type) {
        int ordinal = type.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                }
            }
            if (this.D == 0) {
                return this.i;
            }
            return null;
        }
        if (this.D == 1) {
            return this.i;
        }
        return null;
    }
}
