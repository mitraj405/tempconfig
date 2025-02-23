package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* compiled from: Barrier */
public final class a extends Te {
    public int C = 0;
    public int D = 0;
    public boolean l = true;
    public boolean m = false;

    public final boolean E() {
        return this.m;
    }

    public final boolean F() {
        return this.m;
    }

    public final boolean V() {
        int i;
        int i2;
        int i3;
        boolean z = true;
        int i4 = 0;
        while (true) {
            i = this.B;
            if (i4 >= i) {
                break;
            }
            ConstraintWidget constraintWidget = this.c[i4];
            if ((this.l || constraintWidget.f()) && ((((i2 = this.C) == 0 || i2 == 1) && !constraintWidget.E()) || (((i3 = this.C) == 2 || i3 == 3) && !constraintWidget.F()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i5 = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.B; i6++) {
            ConstraintWidget constraintWidget2 = this.c[i6];
            if (this.l || constraintWidget2.f()) {
                ConstraintAnchor.Type type = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
                if (!z2) {
                    int i7 = this.C;
                    if (i7 == 0) {
                        i5 = constraintWidget2.m(type4).d();
                    } else if (i7 == 1) {
                        i5 = constraintWidget2.m(type3).d();
                    } else if (i7 == 2) {
                        i5 = constraintWidget2.m(type2).d();
                    } else if (i7 == 3) {
                        i5 = constraintWidget2.m(type).d();
                    }
                    z2 = true;
                }
                int i8 = this.C;
                if (i8 == 0) {
                    i5 = Math.min(i5, constraintWidget2.m(type4).d());
                } else if (i8 == 1) {
                    i5 = Math.max(i5, constraintWidget2.m(type3).d());
                } else if (i8 == 2) {
                    i5 = Math.min(i5, constraintWidget2.m(type2).d());
                } else if (i8 == 3) {
                    i5 = Math.max(i5, constraintWidget2.m(type).d());
                }
            }
        }
        int i9 = i5 + this.D;
        int i10 = this.C;
        if (i10 == 0 || i10 == 1) {
            M(i9, i9);
        } else {
            N(i9, i9);
        }
        this.m = true;
        return true;
    }

    public final int W() {
        int i = this.C;
        if (i == 0 || i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        return -1;
    }

    public final void e(ei eiVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        ei eiVar2 = eiVar;
        ConstraintAnchor[] constraintAnchorArr = this.f1357a;
        ConstraintAnchor constraintAnchor = this.f1348a;
        constraintAnchorArr[0] = constraintAnchor;
        int i4 = 2;
        ConstraintAnchor constraintAnchor2 = this.f1363b;
        constraintAnchorArr[2] = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = this.f1371c;
        constraintAnchorArr[1] = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = this.f1376d;
        constraintAnchorArr[3] = constraintAnchor4;
        for (ConstraintAnchor constraintAnchor5 : constraintAnchorArr) {
            constraintAnchor5.f1342a = eiVar2.k(constraintAnchor5);
        }
        int i5 = this.C;
        if (i5 >= 0 && i5 < 4) {
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr[i5];
            if (!this.m) {
                V();
            }
            if (this.m) {
                this.m = false;
                int i6 = this.C;
                if (i6 == 0 || i6 == 1) {
                    eiVar2.d(constraintAnchor.f1342a, this.r);
                    eiVar2.d(constraintAnchor3.f1342a, this.r);
                } else if (i6 == 2 || i6 == 3) {
                    eiVar2.d(constraintAnchor2.f1342a, this.s);
                    eiVar2.d(constraintAnchor4.f1342a, this.s);
                }
            } else {
                int i7 = 0;
                while (true) {
                    if (i7 >= this.B) {
                        z2 = false;
                        break;
                    }
                    ConstraintWidget constraintWidget = this.c[i7];
                    if (this.l || constraintWidget.f()) {
                        int i8 = this.C;
                        ConstraintWidget.a aVar = ConstraintWidget.a.MATCH_CONSTRAINT;
                        if (((i8 == 0 || i8 == 1) && constraintWidget.f1358a[0] == aVar && constraintWidget.f1348a.f1339a != null && constraintWidget.f1371c.f1339a != null) || ((i8 == 2 || i8 == 3) && constraintWidget.f1358a[1] == aVar && constraintWidget.f1363b.f1339a != null && constraintWidget.f1376d.f1339a != null)) {
                            z2 = true;
                        }
                    }
                    i7++;
                }
                z2 = true;
                if (constraintAnchor.g() || constraintAnchor3.g()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (constraintAnchor2.g() || constraintAnchor4.g()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z2 || (((i3 = this.C) != 0 || !z3) && ((i3 != 2 || !z4) && ((i3 != 1 || !z3) && (i3 != 3 || !z4))))) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (!z5) {
                    i = 4;
                } else {
                    i = 5;
                }
                int i9 = 0;
                while (i9 < this.B) {
                    ConstraintWidget constraintWidget2 = this.c[i9];
                    if (this.l || constraintWidget2.f()) {
                        C0415yx k = eiVar2.k(constraintWidget2.f1357a[this.C]);
                        int i10 = this.C;
                        ConstraintAnchor constraintAnchor7 = constraintWidget2.f1357a[i10];
                        constraintAnchor7.f1342a = k;
                        ConstraintAnchor constraintAnchor8 = constraintAnchor7.f1339a;
                        if (constraintAnchor8 == null || constraintAnchor8.f1340a != this) {
                            i2 = 0;
                        } else {
                            i2 = constraintAnchor7.b + 0;
                        }
                        if (i10 == 0 || i10 == i4) {
                            L1 l2 = eiVar.l();
                            C0415yx m2 = eiVar.m();
                            m2.e = 0;
                            l2.d(constraintAnchor6.f1342a, k, m2, this.D - i2);
                            eiVar2.c(l2);
                        } else {
                            L1 l3 = eiVar.l();
                            C0415yx m3 = eiVar.m();
                            m3.e = 0;
                            l3.c(constraintAnchor6.f1342a, k, m3, this.D + i2);
                            eiVar2.c(l3);
                        }
                        eiVar2.e(constraintAnchor6.f1342a, k, this.D + i2, i);
                    }
                    i9++;
                    i4 = 2;
                }
                int i11 = this.C;
                if (i11 == 0) {
                    eiVar2.e(constraintAnchor3.f1342a, constraintAnchor.f1342a, 0, 8);
                    eiVar2.e(constraintAnchor.f1342a, this.f1349a.f1371c.f1342a, 0, 4);
                    eiVar2.e(constraintAnchor.f1342a, this.f1349a.f1348a.f1342a, 0, 0);
                } else if (i11 == 1) {
                    eiVar2.e(constraintAnchor.f1342a, constraintAnchor3.f1342a, 0, 8);
                    eiVar2.e(constraintAnchor.f1342a, this.f1349a.f1348a.f1342a, 0, 4);
                    eiVar2.e(constraintAnchor.f1342a, this.f1349a.f1371c.f1342a, 0, 0);
                } else if (i11 == 2) {
                    eiVar2.e(constraintAnchor4.f1342a, constraintAnchor2.f1342a, 0, 8);
                    eiVar2.e(constraintAnchor2.f1342a, this.f1349a.f1376d.f1342a, 0, 4);
                    eiVar2.e(constraintAnchor2.f1342a, this.f1349a.f1363b.f1342a, 0, 0);
                } else if (i11 == 3) {
                    eiVar2.e(constraintAnchor2.f1342a, constraintAnchor4.f1342a, 0, 8);
                    eiVar2.e(constraintAnchor2.f1342a, this.f1349a.f1363b.f1342a, 0, 4);
                    eiVar2.e(constraintAnchor2.f1342a, this.f1349a.f1376d.f1342a, 0, 0);
                }
            }
        }
    }

    public final boolean f() {
        return true;
    }

    public final void j(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.j(constraintWidget, hashMap);
        a aVar = (a) constraintWidget;
        this.C = aVar.C;
        this.l = aVar.l;
        this.D = aVar.D;
    }

    public final String toString() {
        String j = C0709Uj.j(new StringBuilder("[Barrier] "), this.f1365b, " {");
        for (int i = 0; i < this.B; i++) {
            ConstraintWidget constraintWidget = this.c[i];
            if (i > 0) {
                j = C1058d.z(j, ", ");
            }
            StringBuilder J = xx.J(j);
            J.append(constraintWidget.f1365b);
            j = J.toString();
        }
        return C1058d.z(j, "}");
    }
}
