package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;
import java.util.ArrayList;

/* renamed from: He  reason: default package and case insensitive filesystem */
/* compiled from: Grouping */
public final class C0096He {
    public static BD a(ConstraintWidget constraintWidget, int i, ArrayList<BD> arrayList, BD bd) {
        int i2;
        boolean z;
        int i3;
        if (i == 0) {
            i2 = constraintWidget.z;
        } else {
            i2 = constraintWidget.A;
        }
        int i4 = 0;
        if (i2 != -1 && (bd == null || i2 != bd.a)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                BD bd2 = arrayList.get(i5);
                if (bd2.a == i2) {
                    if (bd != null) {
                        bd.c(i, bd2);
                        arrayList.remove(bd);
                    }
                    bd = bd2;
                } else {
                    i5++;
                }
            }
        } else if (i2 != -1) {
            return bd;
        }
        if (bd == null) {
            if (constraintWidget instanceof Te) {
                Te te = (Te) constraintWidget;
                int i6 = 0;
                while (true) {
                    if (i6 >= te.B) {
                        i3 = -1;
                        break;
                    }
                    ConstraintWidget constraintWidget2 = te.c[i6];
                    if ((i == 0 && (i3 = constraintWidget2.z) != -1) || (i == 1 && (i3 = constraintWidget2.A) != -1)) {
                        break;
                    }
                    i6++;
                }
                if (i3 != -1) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        BD bd3 = arrayList.get(i7);
                        if (bd3.a == i3) {
                            bd = bd3;
                            break;
                        }
                        i7++;
                    }
                }
            }
            if (bd == null) {
                bd = new BD(i);
            }
            arrayList.add(bd);
        }
        ArrayList<ConstraintWidget> arrayList2 = bd.f46a;
        if (arrayList2.contains(constraintWidget)) {
            z = false;
        } else {
            arrayList2.add(constraintWidget);
            z = true;
        }
        if (z) {
            if (constraintWidget instanceof e) {
                e eVar = (e) constraintWidget;
                ConstraintAnchor constraintAnchor = eVar.i;
                if (eVar.D == 0) {
                    i4 = 1;
                }
                constraintAnchor.c(i4, bd, arrayList);
            }
            int i8 = bd.a;
            if (i == 0) {
                constraintWidget.z = i8;
                constraintWidget.f1348a.c(i, bd, arrayList);
                constraintWidget.f1371c.c(i, bd, arrayList);
            } else {
                constraintWidget.A = i8;
                constraintWidget.f1363b.c(i, bd, arrayList);
                constraintWidget.f1379e.c(i, bd, arrayList);
                constraintWidget.f1376d.c(i, bd, arrayList);
            }
            constraintWidget.f1387h.c(i, bd, arrayList);
        }
        return bd;
    }

    public static boolean b(ConstraintWidget.a aVar, ConstraintWidget.a aVar2, ConstraintWidget.a aVar3, ConstraintWidget.a aVar4) {
        boolean z;
        boolean z2;
        ConstraintWidget.a aVar5 = ConstraintWidget.a.FIXED;
        ConstraintWidget.a aVar6 = ConstraintWidget.a.MATCH_PARENT;
        ConstraintWidget.a aVar7 = ConstraintWidget.a.WRAP_CONTENT;
        if (aVar3 == aVar5 || aVar3 == aVar7 || (aVar3 == aVar6 && aVar != aVar7)) {
            z = true;
        } else {
            z = false;
        }
        if (aVar4 == aVar5 || aVar4 == aVar7 || (aVar4 == aVar6 && aVar2 != aVar7)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || z2) {
            return true;
        }
        return false;
    }
}
