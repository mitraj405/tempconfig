package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* renamed from: CD  reason: default package */
/* compiled from: WidgetRun */
public abstract class CD implements J8 {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final N8 f79a = new N8(this);

    /* renamed from: a  reason: collision with other field name */
    public ConstraintWidget.a f80a;

    /* renamed from: a  reason: collision with other field name */
    public ConstraintWidget f81a;

    /* renamed from: a  reason: collision with other field name */
    public final C0154c9 f82a = new C0154c9(this);

    /* renamed from: a  reason: collision with other field name */
    public ou f83a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f84a = false;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public final N8 f85b = new N8(this);
    public int c = 1;

    public CD(ConstraintWidget constraintWidget) {
        this.f81a = constraintWidget;
    }

    public static void b(N8 n8, N8 n82, int i) {
        n8.f434b.add(n82);
        n8.b = i;
        n82.f431a.add(n8);
    }

    public static N8 h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1339a;
        if (constraintAnchor2 == null) {
            return null;
        }
        int ordinal = constraintAnchor2.f1338a.ordinal();
        ConstraintWidget constraintWidget = constraintAnchor2.f1340a;
        if (ordinal == 1) {
            return constraintWidget.f1347a.f79a;
        }
        if (ordinal == 2) {
            return constraintWidget.f1350a.f79a;
        }
        if (ordinal == 3) {
            return constraintWidget.f1347a.f85b;
        }
        if (ordinal == 4) {
            return constraintWidget.f1350a.f85b;
        }
        if (ordinal != 5) {
            return null;
        }
        return constraintWidget.f1350a.c;
    }

    public static N8 i(ConstraintAnchor constraintAnchor, int i) {
        CD cd;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1339a;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1340a;
        if (i == 0) {
            cd = constraintWidget.f1347a;
        } else {
            cd = constraintWidget.f1350a;
        }
        int ordinal = constraintAnchor2.f1338a.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return cd.f79a;
        }
        if (ordinal == 3 || ordinal == 4) {
            return cd.f85b;
        }
        return null;
    }

    public final void c(N8 n8, N8 n82, int i, C0154c9 c9Var) {
        n8.f434b.add(n82);
        n8.f434b.add(this.f82a);
        n8.d = i;
        n8.f430a = c9Var;
        n82.f431a.add(n8);
        c9Var.f431a.add(n8);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        int i3;
        if (i2 == 0) {
            ConstraintWidget constraintWidget = this.f81a;
            int i4 = constraintWidget.i;
            i3 = Math.max(constraintWidget.h, i);
            if (i4 > 0) {
                i3 = Math.min(i4, i);
            }
            if (i3 == i) {
                return i;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f81a;
            int i5 = constraintWidget2.k;
            int max = Math.max(constraintWidget2.j, i);
            if (i5 > 0) {
                max = Math.min(i5, i);
            }
            if (i3 == i) {
                return i;
            }
        }
        return i3;
    }

    public long j() {
        C0154c9 c9Var = this.f82a;
        if (c9Var.f436c) {
            return (long) c9Var.c;
        }
        return 0;
    }

    public abstract boolean k();

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        if (r10.a == 3) goto L_0x00b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(androidx.constraintlayout.core.widgets.ConstraintAnchor r13, androidx.constraintlayout.core.widgets.ConstraintAnchor r14, int r15) {
        /*
            r12 = this;
            N8 r0 = h(r13)
            N8 r1 = h(r14)
            boolean r2 = r0.f436c
            if (r2 == 0) goto L_0x00e9
            boolean r2 = r1.f436c
            if (r2 != 0) goto L_0x0012
            goto L_0x00e9
        L_0x0012:
            int r2 = r0.c
            int r13 = r13.e()
            int r13 = r13 + r2
            int r2 = r1.c
            int r14 = r14.e()
            int r2 = r2 - r14
            int r14 = r2 - r13
            c9 r3 = r12.f82a
            boolean r4 = r3.f436c
            r5 = 1056964608(0x3f000000, float:0.5)
            if (r4 != 0) goto L_0x00b2
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = r12.f80a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            if (r4 != r6) goto L_0x00b2
            int r4 = r12.a
            if (r4 == 0) goto L_0x00ab
            r7 = 1
            if (r4 == r7) goto L_0x009d
            r8 = 2
            if (r4 == r8) goto L_0x0075
            r8 = 3
            if (r4 == r8) goto L_0x003f
            goto L_0x00b2
        L_0x003f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r12.f81a
            af r9 = r4.f1347a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r10 = r9.f80a
            if (r10 != r6) goto L_0x0056
            int r10 = r9.a
            if (r10 != r8) goto L_0x0056
            hC r10 = r4.f1350a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r11 = r10.f80a
            if (r11 != r6) goto L_0x0056
            int r6 = r10.a
            if (r6 != r8) goto L_0x0056
            goto L_0x00b2
        L_0x0056:
            if (r15 != 0) goto L_0x005a
            hC r9 = r4.f1350a
        L_0x005a:
            c9 r6 = r9.f82a
            boolean r8 = r6.f436c
            if (r8 == 0) goto L_0x00b2
            float r4 = r4.e
            if (r15 != r7) goto L_0x006b
            int r6 = r6.c
            float r6 = (float) r6
            float r6 = r6 / r4
            float r6 = r6 + r5
            int r4 = (int) r6
            goto L_0x0071
        L_0x006b:
            int r6 = r6.c
            float r6 = (float) r6
            float r4 = r4 * r6
            float r4 = r4 + r5
            int r4 = (int) r4
        L_0x0071:
            r3.d(r4)
            goto L_0x00b2
        L_0x0075:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r12.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r4.f1349a
            if (r6 == 0) goto L_0x00b2
            if (r15 != 0) goto L_0x0080
            af r6 = r6.f1347a
            goto L_0x0082
        L_0x0080:
            hC r6 = r6.f1350a
        L_0x0082:
            c9 r6 = r6.f82a
            boolean r7 = r6.f436c
            if (r7 == 0) goto L_0x00b2
            if (r15 != 0) goto L_0x008d
            float r4 = r4.a
            goto L_0x008f
        L_0x008d:
            float r4 = r4.b
        L_0x008f:
            int r6 = r6.c
            float r6 = (float) r6
            float r6 = r6 * r4
            float r6 = r6 + r5
            int r4 = (int) r6
            int r4 = r12.g(r4, r15)
            r3.d(r4)
            goto L_0x00b2
        L_0x009d:
            int r4 = r3.e
            int r4 = r12.g(r4, r15)
            int r4 = java.lang.Math.min(r4, r14)
            r3.d(r4)
            goto L_0x00b2
        L_0x00ab:
            int r4 = r12.g(r14, r15)
            r3.d(r4)
        L_0x00b2:
            boolean r4 = r3.f436c
            if (r4 != 0) goto L_0x00b7
            return
        L_0x00b7:
            int r4 = r3.c
            N8 r6 = r12.f85b
            N8 r7 = r12.f79a
            if (r4 != r14) goto L_0x00c6
            r7.d(r13)
            r6.d(r2)
            return
        L_0x00c6:
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r12.f81a
            if (r15 != 0) goto L_0x00cd
            float r14 = r14.f
            goto L_0x00cf
        L_0x00cd:
            float r14 = r14.g
        L_0x00cf:
            if (r0 != r1) goto L_0x00d6
            int r13 = r0.c
            int r2 = r1.c
            r14 = r5
        L_0x00d6:
            int r2 = r2 - r13
            int r2 = r2 - r4
            float r13 = (float) r13
            float r13 = r13 + r5
            float r15 = (float) r2
            float r15 = r15 * r14
            float r15 = r15 + r13
            int r13 = (int) r15
            r7.d(r13)
            int r13 = r7.c
            int r14 = r3.c
            int r13 = r13 + r14
            r6.d(r13)
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.CD.l(androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int):void");
    }

    public void a(J8 j8) {
    }
}
