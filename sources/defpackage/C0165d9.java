package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.e;
import defpackage.D2;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: d9  reason: default package and case insensitive filesystem */
/* compiled from: Direct */
public final class C0165d9 {
    public static final D2.a a = new D2.a();

    public static boolean a(ConstraintWidget constraintWidget) {
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z;
        boolean z2;
        ConstraintWidget.a[] aVarArr = constraintWidget.f1358a;
        ConstraintWidget.a aVar = aVarArr[0];
        ConstraintWidget.a aVar2 = aVarArr[1];
        ConstraintWidget constraintWidget2 = constraintWidget.f1349a;
        if (constraintWidget2 != null) {
            constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
        } else {
            constraintWidgetContainer = null;
        }
        ConstraintWidget.a aVar3 = ConstraintWidget.a.FIXED;
        if (constraintWidgetContainer != null) {
            ConstraintWidget.a aVar4 = constraintWidgetContainer.f1358a[0];
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.a aVar5 = constraintWidgetContainer.f1358a[1];
        }
        ConstraintWidget.a aVar6 = ConstraintWidget.a.MATCH_CONSTRAINT;
        ConstraintWidget.a aVar7 = ConstraintWidget.a.WRAP_CONTENT;
        if (aVar == aVar3 || constraintWidget.E() || aVar == aVar7 || ((aVar == aVar6 && constraintWidget.f1381f == 0 && constraintWidget.e == 0.0f && constraintWidget.x(0)) || (aVar == aVar6 && constraintWidget.f1381f == 1 && constraintWidget.y(0, constraintWidget.u())))) {
            z = true;
        } else {
            z = false;
        }
        if (aVar2 == aVar3 || constraintWidget.F() || aVar2 == aVar7 || ((aVar2 == aVar6 && constraintWidget.f1384g == 0 && constraintWidget.e == 0.0f && constraintWidget.x(1)) || (aVar2 == aVar6 && constraintWidget.f1384g == 1 && constraintWidget.y(1, constraintWidget.o())))) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (constraintWidget.e > 0.0f && (z || z2)) {
            return true;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public static void b(int i, ConstraintWidget constraintWidget, D2.b bVar, boolean z) {
        boolean z2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        Iterator<ConstraintAnchor> it;
        boolean z3;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget2 = constraintWidget;
        D2.b bVar2 = bVar;
        boolean z4 = z;
        if (!constraintWidget2.f1383f) {
            if (!(constraintWidget2 instanceof ConstraintWidgetContainer) && constraintWidget.D() && a(constraintWidget)) {
                ConstraintWidgetContainer.Y(constraintWidget2, bVar2, new D2.a());
            }
            ConstraintAnchor m = constraintWidget2.m(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor m2 = constraintWidget2.m(ConstraintAnchor.Type.RIGHT);
            int d = m.d();
            int d2 = m2.d();
            HashSet<ConstraintAnchor> hashSet = m.f1341a;
            ConstraintWidget.a aVar = ConstraintWidget.a.MATCH_CONSTRAINT;
            if (hashSet != null && m.f1343a) {
                Iterator<ConstraintAnchor> it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ConstraintAnchor next = it2.next();
                    ConstraintWidget constraintWidget3 = next.f1340a;
                    int i2 = i + 1;
                    boolean a2 = a(constraintWidget3);
                    if (constraintWidget3.D() && a2) {
                        ConstraintWidgetContainer.Y(constraintWidget3, bVar2, new D2.a());
                    }
                    ConstraintAnchor constraintAnchor5 = constraintWidget3.f1348a;
                    ConstraintAnchor constraintAnchor6 = constraintWidget3.f1371c;
                    if ((next != constraintAnchor5 || (constraintAnchor4 = constraintAnchor6.f1339a) == null || !constraintAnchor4.f1343a) && (next != constraintAnchor6 || (constraintAnchor3 = constraintAnchor5.f1339a) == null || !constraintAnchor3.f1343a)) {
                        it = it2;
                        z3 = false;
                    } else {
                        it = it2;
                        z3 = true;
                    }
                    ConstraintWidget.a aVar2 = constraintWidget3.f1358a[0];
                    if (aVar2 != aVar || a2) {
                        if (!constraintWidget3.D()) {
                            if (next == constraintAnchor5 && constraintAnchor6.f1339a == null) {
                                int e = constraintAnchor5.e() + d;
                                constraintWidget3.M(e, constraintWidget3.u() + e);
                                b(i2, constraintWidget3, bVar2, z4);
                            } else if (next == constraintAnchor6 && constraintAnchor5.f1339a == null) {
                                int e2 = d - constraintAnchor6.e();
                                constraintWidget3.M(e2 - constraintWidget3.u(), e2);
                                b(i2, constraintWidget3, bVar2, z4);
                            } else if (z3 && !constraintWidget3.B()) {
                                c(i2, constraintWidget3, bVar2, z4);
                            }
                        }
                    } else if (aVar2 == aVar && constraintWidget3.i >= 0 && constraintWidget3.h >= 0 && ((constraintWidget3.w == 8 || (constraintWidget3.f1381f == 0 && constraintWidget3.e == 0.0f)) && !constraintWidget3.B() && !constraintWidget3.f1390j && z3 && !constraintWidget3.B())) {
                        d(i2, constraintWidget2, bVar2, constraintWidget3, z4);
                    }
                    it2 = it;
                }
            }
            if (!(constraintWidget2 instanceof e)) {
                HashSet<ConstraintAnchor> hashSet2 = m2.f1341a;
                if (hashSet2 != null && m2.f1343a) {
                    Iterator<ConstraintAnchor> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        ConstraintAnchor next2 = it3.next();
                        ConstraintWidget constraintWidget4 = next2.f1340a;
                        int i3 = i + 1;
                        boolean a3 = a(constraintWidget4);
                        if (constraintWidget4.D() && a3) {
                            ConstraintWidgetContainer.Y(constraintWidget4, bVar2, new D2.a());
                        }
                        ConstraintAnchor constraintAnchor7 = constraintWidget4.f1348a;
                        ConstraintAnchor constraintAnchor8 = constraintWidget4.f1371c;
                        if ((next2 != constraintAnchor7 || (constraintAnchor2 = constraintAnchor8.f1339a) == null || !constraintAnchor2.f1343a) && (next2 != constraintAnchor8 || (constraintAnchor = constraintAnchor7.f1339a) == null || !constraintAnchor.f1343a)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        ConstraintWidget.a aVar3 = constraintWidget4.f1358a[0];
                        if (aVar3 != aVar || a3) {
                            if (!constraintWidget4.D()) {
                                if (next2 == constraintAnchor7 && constraintAnchor8.f1339a == null) {
                                    int e3 = constraintAnchor7.e() + d2;
                                    constraintWidget4.M(e3, constraintWidget4.u() + e3);
                                    b(i3, constraintWidget4, bVar2, z4);
                                } else if (next2 == constraintAnchor8 && constraintAnchor7.f1339a == null) {
                                    int e4 = d2 - constraintAnchor8.e();
                                    constraintWidget4.M(e4 - constraintWidget4.u(), e4);
                                    b(i3, constraintWidget4, bVar2, z4);
                                } else if (z2 && !constraintWidget4.B()) {
                                    c(i3, constraintWidget4, bVar2, z4);
                                }
                            }
                        } else if (aVar3 == aVar && constraintWidget4.i >= 0 && constraintWidget4.h >= 0) {
                            if (constraintWidget4.w != 8) {
                                if (constraintWidget4.f1381f == 0) {
                                    if (constraintWidget4.e != 0.0f) {
                                    }
                                }
                            }
                            if (!constraintWidget4.B() && !constraintWidget4.f1390j && z2 && !constraintWidget4.B()) {
                                d(i3, constraintWidget2, bVar2, constraintWidget4, z4);
                            }
                        }
                    }
                }
                constraintWidget2.f1383f = true;
            }
        }
    }

    public static void c(int i, ConstraintWidget constraintWidget, D2.b bVar, boolean z) {
        float f;
        float f2 = constraintWidget.f;
        ConstraintAnchor constraintAnchor = constraintWidget.f1348a;
        int d = constraintAnchor.f1339a.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget.f1371c;
        int d2 = constraintAnchor2.f1339a.d();
        int e = constraintAnchor.e() + d;
        int e2 = d2 - constraintAnchor2.e();
        if (d == d2) {
            f2 = 0.5f;
        } else {
            d = e;
            d2 = e2;
        }
        int u = constraintWidget.u();
        int i2 = (d2 - d) - u;
        if (d > d2) {
            i2 = (d - d2) - u;
        }
        if (i2 > 0) {
            f = (f2 * ((float) i2)) + 0.5f;
        } else {
            f = f2 * ((float) i2);
        }
        int i3 = ((int) f) + d;
        int i4 = i3 + u;
        if (d > d2) {
            i4 = i3 - u;
        }
        constraintWidget.M(i3, i4);
        b(i + 1, constraintWidget, bVar, z);
    }

    public static void d(int i, ConstraintWidget constraintWidget, D2.b bVar, ConstraintWidget constraintWidget2, boolean z) {
        int i2;
        float f = constraintWidget2.f;
        ConstraintAnchor constraintAnchor = constraintWidget2.f1348a;
        int e = constraintAnchor.e() + constraintAnchor.f1339a.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.f1371c;
        int d = constraintAnchor2.f1339a.d() - constraintAnchor2.e();
        if (d >= e) {
            int u = constraintWidget2.u();
            if (constraintWidget2.w != 8) {
                int i3 = constraintWidget2.f1381f;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i2 = constraintWidget.u();
                    } else {
                        i2 = constraintWidget.f1349a.u();
                    }
                    u = (int) (constraintWidget2.f * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    u = d - e;
                }
                u = Math.max(constraintWidget2.h, u);
                int i4 = constraintWidget2.i;
                if (i4 > 0) {
                    u = Math.min(i4, u);
                }
            }
            int i5 = e + ((int) ((f * ((float) ((d - e) - u))) + 0.5f));
            constraintWidget2.M(i5, u + i5);
            b(i + 1, constraintWidget2, bVar, z);
        }
    }

    public static void e(int i, ConstraintWidget constraintWidget, D2.b bVar) {
        float f;
        float f2 = constraintWidget.g;
        ConstraintAnchor constraintAnchor = constraintWidget.f1363b;
        int d = constraintAnchor.f1339a.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget.f1376d;
        int d2 = constraintAnchor2.f1339a.d();
        int e = constraintAnchor.e() + d;
        int e2 = d2 - constraintAnchor2.e();
        if (d == d2) {
            f2 = 0.5f;
        } else {
            d = e;
            d2 = e2;
        }
        int o = constraintWidget.o();
        int i2 = (d2 - d) - o;
        if (d > d2) {
            i2 = (d - d2) - o;
        }
        if (i2 > 0) {
            f = (f2 * ((float) i2)) + 0.5f;
        } else {
            f = f2 * ((float) i2);
        }
        int i3 = (int) f;
        int i4 = d + i3;
        int i5 = i4 + o;
        if (d > d2) {
            i4 = d - i3;
            i5 = i4 - o;
        }
        constraintWidget.N(i4, i5);
        g(i + 1, constraintWidget, bVar);
    }

    public static void f(int i, ConstraintWidget constraintWidget, D2.b bVar, ConstraintWidget constraintWidget2) {
        int i2;
        float f = constraintWidget2.g;
        ConstraintAnchor constraintAnchor = constraintWidget2.f1363b;
        int e = constraintAnchor.e() + constraintAnchor.f1339a.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.f1376d;
        int d = constraintAnchor2.f1339a.d() - constraintAnchor2.e();
        if (d >= e) {
            int o = constraintWidget2.o();
            if (constraintWidget2.w != 8) {
                int i3 = constraintWidget2.f1384g;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        i2 = constraintWidget.o();
                    } else {
                        i2 = constraintWidget.f1349a.o();
                    }
                    o = (int) (f * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    o = d - e;
                }
                o = Math.max(constraintWidget2.j, o);
                int i4 = constraintWidget2.k;
                if (i4 > 0) {
                    o = Math.min(i4, o);
                }
            }
            int i5 = e + ((int) ((f * ((float) ((d - e) - o))) + 0.5f));
            constraintWidget2.N(i5, o + i5);
            g(i + 1, constraintWidget2, bVar);
        }
    }

    public static void g(int i, ConstraintWidget constraintWidget, D2.b bVar) {
        ConstraintAnchor constraintAnchor;
        boolean z;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        boolean z2;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        ConstraintWidget constraintWidget2 = constraintWidget;
        D2.b bVar2 = bVar;
        if (!constraintWidget2.f1386g) {
            if (!(constraintWidget2 instanceof ConstraintWidgetContainer) && constraintWidget.D() && a(constraintWidget)) {
                ConstraintWidgetContainer.Y(constraintWidget2, bVar2, new D2.a());
            }
            ConstraintAnchor m = constraintWidget2.m(ConstraintAnchor.Type.TOP);
            ConstraintAnchor m2 = constraintWidget2.m(ConstraintAnchor.Type.BOTTOM);
            int d = m.d();
            int d2 = m2.d();
            HashSet<ConstraintAnchor> hashSet = m.f1341a;
            ConstraintWidget.a aVar = ConstraintWidget.a.MATCH_CONSTRAINT;
            if (hashSet != null && m.f1343a) {
                Iterator<ConstraintAnchor> it = hashSet.iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget3 = next.f1340a;
                    int i2 = i + 1;
                    boolean a2 = a(constraintWidget3);
                    if (constraintWidget3.D() && a2) {
                        ConstraintWidgetContainer.Y(constraintWidget3, bVar2, new D2.a());
                    }
                    ConstraintAnchor constraintAnchor6 = constraintWidget3.f1363b;
                    ConstraintAnchor constraintAnchor7 = constraintWidget3.f1376d;
                    if ((next != constraintAnchor6 || (constraintAnchor5 = constraintAnchor7.f1339a) == null || !constraintAnchor5.f1343a) && (next != constraintAnchor7 || (constraintAnchor4 = constraintAnchor6.f1339a) == null || !constraintAnchor4.f1343a)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    ConstraintWidget.a aVar2 = constraintWidget3.f1358a[1];
                    if (aVar2 != aVar || a2) {
                        if (!constraintWidget3.D()) {
                            if (next == constraintAnchor6 && constraintAnchor7.f1339a == null) {
                                int e = constraintAnchor6.e() + d;
                                constraintWidget3.N(e, constraintWidget3.o() + e);
                                g(i2, constraintWidget3, bVar2);
                            } else if (next == constraintAnchor7 && constraintAnchor6.f1339a == null) {
                                int e2 = d - constraintAnchor7.e();
                                constraintWidget3.N(e2 - constraintWidget3.o(), e2);
                                g(i2, constraintWidget3, bVar2);
                            } else if (z2 && !constraintWidget3.C()) {
                                e(i2, constraintWidget3, bVar2);
                            }
                        }
                    } else if (aVar2 == aVar && constraintWidget3.k >= 0 && constraintWidget3.j >= 0) {
                        if ((constraintWidget3.w == 8 || (constraintWidget3.f1384g == 0 && constraintWidget3.e == 0.0f)) && !constraintWidget3.C() && !constraintWidget3.f1390j && z2 && !constraintWidget3.C()) {
                            f(i2, constraintWidget2, bVar2, constraintWidget3);
                        }
                    }
                }
            }
            if (!(constraintWidget2 instanceof e)) {
                HashSet<ConstraintAnchor> hashSet2 = m2.f1341a;
                if (hashSet2 != null && m2.f1343a) {
                    Iterator<ConstraintAnchor> it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget4 = next2.f1340a;
                        int i3 = i + 1;
                        boolean a3 = a(constraintWidget4);
                        if (constraintWidget4.D() && a3) {
                            ConstraintWidgetContainer.Y(constraintWidget4, bVar2, new D2.a());
                        }
                        ConstraintAnchor constraintAnchor8 = constraintWidget4.f1363b;
                        ConstraintAnchor constraintAnchor9 = constraintWidget4.f1376d;
                        if ((next2 != constraintAnchor8 || (constraintAnchor3 = constraintAnchor9.f1339a) == null || !constraintAnchor3.f1343a) && (next2 != constraintAnchor9 || (constraintAnchor2 = constraintAnchor8.f1339a) == null || !constraintAnchor2.f1343a)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        ConstraintWidget.a aVar3 = constraintWidget4.f1358a[1];
                        if (aVar3 != aVar || a3) {
                            if (!constraintWidget4.D()) {
                                if (next2 == constraintAnchor8 && constraintAnchor9.f1339a == null) {
                                    int e3 = constraintAnchor8.e() + d2;
                                    constraintWidget4.N(e3, constraintWidget4.o() + e3);
                                    g(i3, constraintWidget4, bVar2);
                                } else if (next2 == constraintAnchor9 && constraintAnchor8.f1339a == null) {
                                    int e4 = d2 - constraintAnchor9.e();
                                    constraintWidget4.N(e4 - constraintWidget4.o(), e4);
                                    g(i3, constraintWidget4, bVar2);
                                } else if (z && !constraintWidget4.C()) {
                                    e(i3, constraintWidget4, bVar2);
                                }
                            }
                        } else if (aVar3 == aVar && constraintWidget4.k >= 0 && constraintWidget4.j >= 0) {
                            if (constraintWidget4.w != 8) {
                                if (constraintWidget4.f1384g == 0) {
                                    if (constraintWidget4.e != 0.0f) {
                                    }
                                }
                            }
                            if (!constraintWidget4.C() && !constraintWidget4.f1390j && z && !constraintWidget4.C()) {
                                f(i3, constraintWidget2, bVar2, constraintWidget4);
                            }
                        }
                    }
                }
                ConstraintAnchor m3 = constraintWidget2.m(ConstraintAnchor.Type.BASELINE);
                if (m3.f1341a != null && m3.f1343a) {
                    int d3 = m3.d();
                    Iterator<ConstraintAnchor> it3 = m3.f1341a.iterator();
                    while (it3.hasNext()) {
                        ConstraintAnchor next3 = it3.next();
                        ConstraintWidget constraintWidget5 = next3.f1340a;
                        int i4 = i + 1;
                        boolean a4 = a(constraintWidget5);
                        if (constraintWidget5.D() && a4) {
                            ConstraintWidgetContainer.Y(constraintWidget5, bVar2, new D2.a());
                        }
                        if ((constraintWidget5.f1358a[1] != aVar || a4) && !constraintWidget5.D() && next3 == (constraintAnchor = constraintWidget5.f1379e)) {
                            int e5 = next3.e() + d3;
                            if (constraintWidget5.f1388h) {
                                int i5 = e5 - constraintWidget5.t;
                                int i6 = constraintWidget5.p + i5;
                                constraintWidget5.s = i5;
                                constraintWidget5.f1363b.l(i5);
                                constraintWidget5.f1376d.l(i6);
                                constraintAnchor.l(e5);
                                constraintWidget5.f1380e = true;
                            }
                            g(i4, constraintWidget5, bVar2);
                        }
                    }
                }
                constraintWidget2.f1386g = true;
            }
        }
    }
}
