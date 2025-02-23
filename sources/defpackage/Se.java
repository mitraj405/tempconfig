package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: Se  reason: default package */
/* compiled from: HelperReferences */
public final class Se extends CD {
    public Se(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    public final void a(J8 j8) {
        a aVar = (a) this.f81a;
        int i = aVar.C;
        N8 n8 = this.f79a;
        Iterator it = n8.f434b.iterator();
        int i2 = 0;
        int i3 = -1;
        while (it.hasNext()) {
            int i4 = ((N8) it.next()).c;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i == 0 || i == 2) {
            n8.d(i3 + aVar.D);
        } else {
            n8.d(i2 + aVar.D);
        }
    }

    public final void d() {
        ConstraintWidget constraintWidget = this.f81a;
        if (constraintWidget instanceof a) {
            N8 n8 = this.f79a;
            n8.f432a = true;
            a aVar = (a) constraintWidget;
            int i = aVar.C;
            boolean z = aVar.l;
            ArrayList arrayList = n8.f434b;
            int i2 = 0;
            if (i == 0) {
                n8.a = 4;
                while (i2 < aVar.B) {
                    ConstraintWidget constraintWidget2 = aVar.c[i2];
                    if (z || constraintWidget2.w != 8) {
                        N8 n82 = constraintWidget2.f1347a.f79a;
                        n82.f431a.add(n8);
                        arrayList.add(n82);
                    }
                    i2++;
                }
                m(this.f81a.f1347a.f79a);
                m(this.f81a.f1347a.f85b);
            } else if (i == 1) {
                n8.a = 5;
                while (i2 < aVar.B) {
                    ConstraintWidget constraintWidget3 = aVar.c[i2];
                    if (z || constraintWidget3.w != 8) {
                        N8 n83 = constraintWidget3.f1347a.f85b;
                        n83.f431a.add(n8);
                        arrayList.add(n83);
                    }
                    i2++;
                }
                m(this.f81a.f1347a.f79a);
                m(this.f81a.f1347a.f85b);
            } else if (i == 2) {
                n8.a = 6;
                while (i2 < aVar.B) {
                    ConstraintWidget constraintWidget4 = aVar.c[i2];
                    if (z || constraintWidget4.w != 8) {
                        N8 n84 = constraintWidget4.f1350a.f79a;
                        n84.f431a.add(n8);
                        arrayList.add(n84);
                    }
                    i2++;
                }
                m(this.f81a.f1350a.f79a);
                m(this.f81a.f1350a.f85b);
            } else if (i == 3) {
                n8.a = 7;
                while (i2 < aVar.B) {
                    ConstraintWidget constraintWidget5 = aVar.c[i2];
                    if (z || constraintWidget5.w != 8) {
                        N8 n85 = constraintWidget5.f1350a.f85b;
                        n85.f431a.add(n8);
                        arrayList.add(n85);
                    }
                    i2++;
                }
                m(this.f81a.f1350a.f79a);
                m(this.f81a.f1350a.f85b);
            }
        }
    }

    public final void e() {
        ConstraintWidget constraintWidget = this.f81a;
        if (constraintWidget instanceof a) {
            int i = ((a) constraintWidget).C;
            N8 n8 = this.f79a;
            if (i == 0 || i == 1) {
                constraintWidget.r = n8.c;
            } else {
                constraintWidget.s = n8.c;
            }
        }
    }

    public final void f() {
        this.f83a = null;
        this.f79a.c();
    }

    public final boolean k() {
        return false;
    }

    public final void m(N8 n8) {
        N8 n82 = this.f79a;
        n82.f431a.add(n8);
        n8.f434b.add(n82);
    }
}
