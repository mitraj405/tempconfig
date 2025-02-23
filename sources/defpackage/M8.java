package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.D2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: M8  reason: default package */
/* compiled from: DependencyGraph */
public final class M8 {
    public final D2.a a;

    /* renamed from: a  reason: collision with other field name */
    public D2.b f395a;

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintWidgetContainer f396a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<CD> f397a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f398a = true;
    public final ConstraintWidgetContainer b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<ou> f399b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f400b = true;

    public M8(ConstraintWidgetContainer constraintWidgetContainer) {
        new ArrayList();
        this.f395a = null;
        this.a = new D2.a();
        this.f399b = new ArrayList<>();
        this.f396a = constraintWidgetContainer;
        this.b = constraintWidgetContainer;
    }

    public final void a(N8 n8, int i, int i2, ArrayList arrayList, ou ouVar) {
        CD cd = n8.f433b;
        if (cd.f83a == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f396a;
            if (cd != constraintWidgetContainer.f1347a && cd != constraintWidgetContainer.f1350a) {
                if (ouVar == null) {
                    ouVar = new ou(cd);
                    arrayList.add(ouVar);
                }
                cd.f83a = ouVar;
                ouVar.f3162a.add(cd);
                N8 n82 = cd.f79a;
                Iterator it = n82.f431a.iterator();
                while (it.hasNext()) {
                    J8 j8 = (J8) it.next();
                    if (j8 instanceof N8) {
                        a((N8) j8, i, 0, arrayList, ouVar);
                    }
                }
                N8 n83 = cd.f85b;
                Iterator it2 = n83.f431a.iterator();
                while (it2.hasNext()) {
                    J8 j82 = (J8) it2.next();
                    if (j82 instanceof N8) {
                        a((N8) j82, i, 1, arrayList, ouVar);
                    }
                }
                if (i == 1 && (cd instanceof C0213hC)) {
                    Iterator it3 = ((C0213hC) cd).c.f431a.iterator();
                    while (it3.hasNext()) {
                        J8 j83 = (J8) it3.next();
                        if (j83 instanceof N8) {
                            a((N8) j83, i, 2, arrayList, ouVar);
                        }
                    }
                }
                Iterator it4 = n82.f434b.iterator();
                while (it4.hasNext()) {
                    a((N8) it4.next(), i, 0, arrayList, ouVar);
                }
                Iterator it5 = n83.f434b.iterator();
                while (it5.hasNext()) {
                    a((N8) it5.next(), i, 1, arrayList, ouVar);
                }
                if (i == 1 && (cd instanceof C0213hC)) {
                    Iterator it6 = ((C0213hC) cd).c.f434b.iterator();
                    while (it6.hasNext()) {
                        a((N8) it6.next(), i, 2, arrayList, ouVar);
                    }
                }
            }
        }
    }

    public final void b(ConstraintWidgetContainer constraintWidgetContainer) {
        ConstraintWidget.a aVar;
        int i;
        int i2;
        ConstraintWidget.a aVar2;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        Iterator<ConstraintWidget> it = constraintWidgetContainer2.b.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.a[] aVarArr = next.f1358a;
            ConstraintWidget.a aVar3 = aVarArr[0];
            ConstraintWidget.a aVar4 = aVarArr[1];
            if (next.w == 8) {
                next.f1354a = true;
            } else {
                float f = next.a;
                int i3 = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
                ConstraintWidget.a aVar5 = ConstraintWidget.a.MATCH_CONSTRAINT;
                if (i3 < 0 && aVar3 == aVar5) {
                    next.f1381f = 2;
                }
                float f2 = next.b;
                if (f2 < 1.0f && aVar4 == aVar5) {
                    next.f1384g = 2;
                }
                int i4 = (next.e > 0.0f ? 1 : (next.e == 0.0f ? 0 : -1));
                ConstraintWidget.a aVar6 = ConstraintWidget.a.WRAP_CONTENT;
                ConstraintWidget.a aVar7 = ConstraintWidget.a.FIXED;
                if (i4 > 0) {
                    if (aVar3 == aVar5 && (aVar4 == aVar6 || aVar4 == aVar7)) {
                        next.f1381f = 3;
                    } else if (aVar4 == aVar5 && (aVar3 == aVar6 || aVar3 == aVar7)) {
                        next.f1384g = 3;
                    } else if (aVar3 == aVar5 && aVar4 == aVar5) {
                        if (next.f1381f == 0) {
                            next.f1381f = 3;
                        }
                        if (next.f1384g == 0) {
                            next.f1384g = 3;
                        }
                    }
                }
                ConstraintAnchor constraintAnchor = next.f1371c;
                ConstraintAnchor constraintAnchor2 = next.f1348a;
                if (aVar3 == aVar5 && next.f1381f == 1 && (constraintAnchor2.f1339a == null || constraintAnchor.f1339a == null)) {
                    aVar3 = aVar6;
                }
                ConstraintAnchor constraintAnchor3 = next.f1376d;
                ConstraintAnchor constraintAnchor4 = next.f1363b;
                if (aVar4 == aVar5 && next.f1384g == 1 && (constraintAnchor4.f1339a == null || constraintAnchor3.f1339a == null)) {
                    aVar = aVar6;
                } else {
                    aVar = aVar4;
                }
                af afVar = next.f1347a;
                afVar.f80a = aVar3;
                int i5 = next.f1381f;
                afVar.a = i5;
                C0213hC hCVar = next.f1350a;
                hCVar.f80a = aVar;
                Iterator<ConstraintWidget> it2 = it;
                int i6 = next.f1384g;
                hCVar.a = i6;
                ConstraintWidget.a aVar8 = ConstraintWidget.a.MATCH_PARENT;
                if ((aVar3 == aVar8 || aVar3 == aVar7 || aVar3 == aVar6) && (aVar == aVar8 || aVar == aVar7 || aVar == aVar6)) {
                    int u = next.u();
                    if (aVar3 == aVar8) {
                        i = (constraintWidgetContainer.u() - constraintAnchor2.b) - constraintAnchor.b;
                        aVar3 = aVar7;
                    } else {
                        i = u;
                    }
                    int o = next.o();
                    if (aVar == aVar8) {
                        i2 = (constraintWidgetContainer.o() - constraintAnchor4.b) - constraintAnchor3.b;
                        aVar2 = aVar7;
                    } else {
                        i2 = o;
                        aVar2 = aVar;
                    }
                    f(next, aVar3, i, aVar2, i2);
                    next.f1347a.f82a.d(next.u());
                    next.f1350a.f82a.d(next.o());
                    next.f1354a = true;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = next.f1357a;
                    if (aVar3 == aVar5 && (aVar == aVar6 || aVar == aVar7)) {
                        if (i5 == 3) {
                            if (aVar == aVar6) {
                                f(next, aVar6, 0, aVar6, 0);
                            }
                            int o2 = next.o();
                            f(next, aVar7, (int) ((((float) o2) * next.e) + 0.5f), aVar7, o2);
                            next.f1347a.f82a.d(next.u());
                            next.f1350a.f82a.d(next.o());
                            next.f1354a = true;
                        } else if (i5 == 1) {
                            f(next, aVar6, 0, aVar, 0);
                            next.f1347a.f82a.e = next.u();
                        } else if (i5 == 2) {
                            ConstraintWidget.a aVar9 = constraintWidgetContainer2.f1358a[0];
                            if (aVar9 == aVar7 || aVar9 == aVar8) {
                                f(next, aVar7, (int) ((f * ((float) constraintWidgetContainer.u())) + 0.5f), aVar, next.o());
                                next.f1347a.f82a.d(next.u());
                                next.f1350a.f82a.d(next.o());
                                next.f1354a = true;
                            }
                        } else if (constraintAnchorArr[0].f1339a == null || constraintAnchorArr[1].f1339a == null) {
                            f(next, aVar6, 0, aVar, 0);
                            next.f1347a.f82a.d(next.u());
                            next.f1350a.f82a.d(next.o());
                            next.f1354a = true;
                        }
                    }
                    if (aVar == aVar5 && (aVar3 == aVar6 || aVar3 == aVar7)) {
                        if (i6 == 3) {
                            if (aVar3 == aVar6) {
                                f(next, aVar6, 0, aVar6, 0);
                            }
                            int u2 = next.u();
                            float f3 = next.e;
                            if (next.q == -1) {
                                f3 = 1.0f / f3;
                            }
                            f(next, aVar7, u2, aVar7, (int) ((((float) u2) * f3) + 0.5f));
                            next.f1347a.f82a.d(next.u());
                            next.f1350a.f82a.d(next.o());
                            next.f1354a = true;
                        } else if (i6 == 1) {
                            f(next, aVar3, 0, aVar6, 0);
                            next.f1350a.f82a.e = next.o();
                        } else if (i6 == 2) {
                            ConstraintWidget.a aVar10 = constraintWidgetContainer2.f1358a[1];
                            if (aVar10 == aVar7 || aVar10 == aVar8) {
                                f(next, aVar3, next.u(), aVar7, (int) ((f2 * ((float) constraintWidgetContainer.o())) + 0.5f));
                                next.f1347a.f82a.d(next.u());
                                next.f1350a.f82a.d(next.o());
                                next.f1354a = true;
                            }
                        } else if (constraintAnchorArr[2].f1339a == null || constraintAnchorArr[3].f1339a == null) {
                            f(next, aVar6, 0, aVar, 0);
                            next.f1347a.f82a.d(next.u());
                            next.f1350a.f82a.d(next.o());
                            next.f1354a = true;
                        }
                    }
                    if (aVar3 == aVar5 && aVar == aVar5) {
                        if (i5 == 1 || i6 == 1) {
                            f(next, aVar6, 0, aVar6, 0);
                            next.f1347a.f82a.e = next.u();
                            next.f1350a.f82a.e = next.o();
                        } else if (i6 == 2 && i5 == 2) {
                            ConstraintWidget.a[] aVarArr2 = constraintWidgetContainer2.f1358a;
                            if (aVarArr2[0] == aVar7 && aVarArr2[1] == aVar7) {
                                ConstraintWidget constraintWidget = next;
                                ConstraintWidget.a aVar11 = aVar7;
                                f(constraintWidget, aVar11, (int) ((f * ((float) constraintWidgetContainer.u())) + 0.5f), aVar7, (int) ((f2 * ((float) constraintWidgetContainer.o())) + 0.5f));
                                next.f1347a.f82a.d(next.u());
                                next.f1350a.f82a.d(next.o());
                                next.f1354a = true;
                            }
                        }
                    }
                }
                it = it2;
            }
        }
    }

    public final void c() {
        ArrayList<CD> arrayList = this.f397a;
        arrayList.clear();
        ConstraintWidgetContainer constraintWidgetContainer = this.b;
        constraintWidgetContainer.f1347a.f();
        constraintWidgetContainer.f1350a.f();
        arrayList.add(constraintWidgetContainer.f1347a);
        arrayList.add(constraintWidgetContainer.f1350a);
        Iterator<ConstraintWidget> it = constraintWidgetContainer.b.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof e) {
                arrayList.add(new C0098Je(next));
            } else {
                if (next.B()) {
                    if (next.f1346a == null) {
                        next.f1346a = new M4(0, next);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1346a);
                } else {
                    arrayList.add(next.f1347a);
                }
                if (next.C()) {
                    if (next.f1362b == null) {
                        next.f1362b = new M4(1, next);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1362b);
                } else {
                    arrayList.add(next.f1350a);
                }
                if (next instanceof Te) {
                    arrayList.add(new Se(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<CD> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<CD> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            CD next2 = it3.next();
            if (next2.f81a != constraintWidgetContainer) {
                next2.d();
            }
        }
        ArrayList<ou> arrayList2 = this.f399b;
        arrayList2.clear();
        ConstraintWidgetContainer constraintWidgetContainer2 = this.f396a;
        e(constraintWidgetContainer2.f1347a, 0, arrayList2);
        e(constraintWidgetContainer2.f1350a, 1, arrayList2);
        this.f398a = false;
    }

    public final int d(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        int i2;
        ArrayList<ou> arrayList;
        long j;
        CD cd;
        CD cd2;
        long max;
        float f;
        long j2;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        int i3 = i;
        ArrayList<ou> arrayList2 = this.f399b;
        int size = arrayList2.size();
        int i4 = 0;
        long j3 = 0;
        while (i4 < size) {
            CD cd3 = arrayList2.get(i4).a;
            if (!(cd3 instanceof M4) ? i3 != 0 ? (cd3 instanceof C0213hC) : (cd3 instanceof af) : ((M4) cd3).b == i3) {
                if (i3 == 0) {
                    cd = constraintWidgetContainer2.f1347a;
                } else {
                    cd = constraintWidgetContainer2.f1350a;
                }
                N8 n8 = cd.f79a;
                if (i3 == 0) {
                    cd2 = constraintWidgetContainer2.f1347a;
                } else {
                    cd2 = constraintWidgetContainer2.f1350a;
                }
                N8 n82 = cd2.f85b;
                boolean contains = cd3.f79a.f434b.contains(n8);
                N8 n83 = cd3.f85b;
                boolean contains2 = n83.f434b.contains(n82);
                long j4 = cd3.j();
                N8 n84 = cd3.f79a;
                if (!contains || !contains2) {
                    arrayList = arrayList2;
                    i2 = size;
                    if (contains) {
                        max = Math.max(ou.b(n84, (long) n84.b), ((long) n84.b) + j4);
                    } else if (contains2) {
                        max = Math.max(-ou.a(n83, (long) n83.b), ((long) (-n83.b)) + j4);
                    } else {
                        j = (cd3.j() + ((long) n84.b)) - ((long) n83.b);
                    }
                    j = max;
                } else {
                    long b2 = ou.b(n84, 0);
                    long a2 = ou.a(n83, 0);
                    long j5 = b2 - j4;
                    int i5 = n83.b;
                    arrayList = arrayList2;
                    i2 = size;
                    if (j5 >= ((long) (-i5))) {
                        j5 += (long) i5;
                    }
                    long j6 = j5;
                    long j7 = (long) n84.b;
                    long j8 = ((-a2) - j4) - j7;
                    if (j8 >= j7) {
                        j8 -= j7;
                    }
                    ConstraintWidget constraintWidget = cd3.f81a;
                    if (i3 == 0) {
                        f = constraintWidget.f;
                    } else if (i3 == 1) {
                        f = constraintWidget.g;
                    } else {
                        constraintWidget.getClass();
                        f = -1.0f;
                    }
                    if (f > 0.0f) {
                        j2 = (long) ((((float) j6) / (1.0f - f)) + (((float) j8) / f));
                    } else {
                        j2 = 0;
                    }
                    float f2 = (float) j2;
                    j = (((long) n84.b) + ((((long) ((f2 * f) + 0.5f)) + j4) + ((long) lf.a(1.0f, f, f2, 0.5f)))) - ((long) n83.b);
                }
            } else {
                j = 0;
                arrayList = arrayList2;
                i2 = size;
            }
            j3 = Math.max(j3, j);
            i4++;
            constraintWidgetContainer2 = constraintWidgetContainer;
            i3 = i;
            arrayList2 = arrayList;
            size = i2;
        }
        return (int) j3;
    }

    public final void e(CD cd, int i, ArrayList<ou> arrayList) {
        N8 n8;
        Iterator it = cd.f79a.f431a.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            n8 = cd.f85b;
            if (!hasNext) {
                break;
            }
            J8 j8 = (J8) it.next();
            if (j8 instanceof N8) {
                a((N8) j8, i, 0, arrayList, (ou) null);
            } else if (j8 instanceof CD) {
                a(((CD) j8).f79a, i, 0, arrayList, (ou) null);
            }
        }
        Iterator it2 = n8.f431a.iterator();
        while (it2.hasNext()) {
            J8 j82 = (J8) it2.next();
            if (j82 instanceof N8) {
                a((N8) j82, i, 1, arrayList, (ou) null);
            } else if (j82 instanceof CD) {
                a(((CD) j82).f85b, i, 1, arrayList, (ou) null);
            }
        }
        if (i == 1) {
            Iterator it3 = ((C0213hC) cd).c.f431a.iterator();
            while (it3.hasNext()) {
                J8 j83 = (J8) it3.next();
                if (j83 instanceof N8) {
                    a((N8) j83, i, 2, arrayList, (ou) null);
                }
            }
        }
    }

    public final void f(ConstraintWidget constraintWidget, ConstraintWidget.a aVar, int i, ConstraintWidget.a aVar2, int i2) {
        boolean z;
        D2.a aVar3 = this.a;
        aVar3.f107a = aVar;
        aVar3.f109b = aVar2;
        aVar3.a = i;
        aVar3.b = i2;
        ((ConstraintLayout.Measurer) this.f395a).b(constraintWidget, aVar3);
        constraintWidget.R(aVar3.c);
        constraintWidget.O(aVar3.d);
        constraintWidget.f1388h = aVar3.f108a;
        int i3 = aVar3.e;
        constraintWidget.t = i3;
        if (i3 > 0) {
            z = true;
        } else {
            z = false;
        }
        constraintWidget.f1388h = z;
    }

    public final void g() {
        boolean z;
        C2 c2;
        Iterator<ConstraintWidget> it = this.f396a.b.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.f1354a) {
                ConstraintWidget.a[] aVarArr = next.f1358a;
                boolean z2 = false;
                ConstraintWidget.a aVar = aVarArr[0];
                ConstraintWidget.a aVar2 = aVarArr[1];
                int i = next.f1381f;
                int i2 = next.f1384g;
                ConstraintWidget.a aVar3 = ConstraintWidget.a.WRAP_CONTENT;
                ConstraintWidget.a aVar4 = ConstraintWidget.a.MATCH_CONSTRAINT;
                if (aVar == aVar3 || (aVar == aVar4 && i == 1)) {
                    z = true;
                } else {
                    z = false;
                }
                if (aVar2 == aVar3 || (aVar2 == aVar4 && i2 == 1)) {
                    z2 = true;
                }
                C0154c9 c9Var = next.f1347a.f82a;
                boolean z3 = c9Var.f436c;
                C0154c9 c9Var2 = next.f1350a.f82a;
                boolean z4 = c9Var2.f436c;
                ConstraintWidget.a aVar5 = ConstraintWidget.a.FIXED;
                if (z3 && z4) {
                    f(next, aVar5, c9Var.c, aVar5, c9Var2.c);
                    next.f1354a = true;
                } else if (z3 && z2) {
                    f(next, aVar5, c9Var.c, aVar3, c9Var2.c);
                    if (aVar2 == aVar4) {
                        next.f1350a.f82a.e = next.o();
                    } else {
                        next.f1350a.f82a.d(next.o());
                        next.f1354a = true;
                    }
                } else if (z4 && z) {
                    f(next, aVar3, c9Var.c, aVar5, c9Var2.c);
                    if (aVar == aVar4) {
                        next.f1347a.f82a.e = next.u();
                    } else {
                        next.f1347a.f82a.d(next.u());
                        next.f1354a = true;
                    }
                }
                if (next.f1354a && (c2 = next.f1350a.a) != null) {
                    c2.d(next.t);
                }
            }
        }
    }
}
