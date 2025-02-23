package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;

/* renamed from: Je  reason: default package and case insensitive filesystem */
/* compiled from: GuidelineReference */
public final class C0098Je extends CD {
    public C0098Je(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f1347a.f();
        constraintWidget.f1350a.f();
        this.b = ((e) constraintWidget).D;
    }

    public final void a(J8 j8) {
        N8 n8 = this.f79a;
        if (n8.f435b && !n8.f436c) {
            n8.d((int) ((((float) ((N8) n8.f434b.get(0)).c) * ((e) this.f81a).h) + 0.5f));
        }
    }

    public final void d() {
        ConstraintWidget constraintWidget = this.f81a;
        e eVar = (e) constraintWidget;
        int i = eVar.B;
        int i2 = eVar.C;
        int i3 = eVar.D;
        N8 n8 = this.f79a;
        if (i3 == 1) {
            if (i != -1) {
                n8.f434b.add(constraintWidget.f1349a.f1347a.f79a);
                this.f81a.f1349a.f1347a.f79a.f431a.add(n8);
                n8.b = i;
            } else if (i2 != -1) {
                n8.f434b.add(constraintWidget.f1349a.f1347a.f85b);
                this.f81a.f1349a.f1347a.f85b.f431a.add(n8);
                n8.b = -i2;
            } else {
                n8.f432a = true;
                n8.f434b.add(constraintWidget.f1349a.f1347a.f85b);
                this.f81a.f1349a.f1347a.f85b.f431a.add(n8);
            }
            m(this.f81a.f1347a.f79a);
            m(this.f81a.f1347a.f85b);
            return;
        }
        if (i != -1) {
            n8.f434b.add(constraintWidget.f1349a.f1350a.f79a);
            this.f81a.f1349a.f1350a.f79a.f431a.add(n8);
            n8.b = i;
        } else if (i2 != -1) {
            n8.f434b.add(constraintWidget.f1349a.f1350a.f85b);
            this.f81a.f1349a.f1350a.f85b.f431a.add(n8);
            n8.b = -i2;
        } else {
            n8.f432a = true;
            n8.f434b.add(constraintWidget.f1349a.f1350a.f85b);
            this.f81a.f1349a.f1350a.f85b.f431a.add(n8);
        }
        m(this.f81a.f1350a.f79a);
        m(this.f81a.f1350a.f85b);
    }

    public final void e() {
        ConstraintWidget constraintWidget = this.f81a;
        int i = ((e) constraintWidget).D;
        N8 n8 = this.f79a;
        if (i == 1) {
            constraintWidget.r = n8.c;
        } else {
            constraintWidget.s = n8.c;
        }
    }

    public final void f() {
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
