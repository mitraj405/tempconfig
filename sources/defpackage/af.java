package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* renamed from: af  reason: default package */
/* compiled from: HorizontalWidgetRun */
public final class af extends CD {
    public static final int[] a = new int[2];

    public af(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f79a.a = 4;
        this.f85b.a = 5;
        this.b = 0;
    }

    public static void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 == -1) {
            int i8 = (int) ((((float) i7) * f) + 0.5f);
            int i9 = (int) ((((float) i6) / f) + 0.5f);
            if (i8 <= i6) {
                iArr[0] = i8;
                iArr[1] = i7;
            } else if (i9 <= i7) {
                iArr[0] = i6;
                iArr[1] = i9;
            }
        } else if (i5 == 0) {
            iArr[0] = (int) ((((float) i7) * f) + 0.5f);
            iArr[1] = i7;
        } else if (i5 == 1) {
            iArr[0] = i6;
            iArr[1] = (int) ((((float) i6) * f) + 0.5f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0249, code lost:
        if (r8 != 1) goto L_0x02aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(defpackage.J8 r24) {
        /*
            r23 = this;
            r0 = r23
            int r1 = r0.c
            int r1 = defpackage.xx.V(r1)
            r2 = 0
            r3 = 3
            if (r1 == r3) goto L_0x0381
            c9 r1 = r0.f82a
            boolean r4 = r1.f436c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            N8 r6 = r0.f79a
            N8 r7 = r0.f85b
            r8 = 1056964608(0x3f000000, float:0.5)
            r9 = 1
            if (r4 != 0) goto L_0x02aa
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = r0.f80a
            if (r4 != r5) goto L_0x02aa
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            int r10 = r4.f1381f
            r11 = 2
            if (r10 == r11) goto L_0x0291
            if (r10 == r3) goto L_0x002a
            goto L_0x02aa
        L_0x002a:
            int r10 = r4.f1384g
            r11 = -1
            if (r10 == 0) goto L_0x0062
            if (r10 != r3) goto L_0x0032
            goto L_0x0062
        L_0x0032:
            int r3 = r4.q
            if (r3 == r11) goto L_0x0051
            if (r3 == 0) goto L_0x0046
            if (r3 == r9) goto L_0x003c
            r3 = r2
            goto L_0x005d
        L_0x003c:
            hC r3 = r4.f1350a
            c9 r3 = r3.f82a
            int r3 = r3.c
            float r3 = (float) r3
            float r4 = r4.e
            goto L_0x005a
        L_0x0046:
            hC r3 = r4.f1350a
            c9 r3 = r3.f82a
            int r3 = r3.c
            float r3 = (float) r3
            float r4 = r4.e
            float r3 = r3 / r4
            goto L_0x005b
        L_0x0051:
            hC r3 = r4.f1350a
            c9 r3 = r3.f82a
            int r3 = r3.c
            float r3 = (float) r3
            float r4 = r4.e
        L_0x005a:
            float r3 = r3 * r4
        L_0x005b:
            float r3 = r3 + r8
            int r3 = (int) r3
        L_0x005d:
            r1.d(r3)
            goto L_0x02aa
        L_0x0062:
            hC r3 = r4.f1350a
            N8 r10 = r3.f79a
            N8 r3 = r3.f85b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r4.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f1339a
            if (r12 == 0) goto L_0x0070
            r12 = r9
            goto L_0x0071
        L_0x0070:
            r12 = r2
        L_0x0071:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r4.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f1339a
            if (r13 == 0) goto L_0x0079
            r13 = r9
            goto L_0x007a
        L_0x0079:
            r13 = r2
        L_0x007a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r4.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f1339a
            if (r14 == 0) goto L_0x0082
            r14 = r9
            goto L_0x0083
        L_0x0082:
            r14 = r2
        L_0x0083:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r4.f1376d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r15.f1339a
            if (r15 == 0) goto L_0x008b
            r15 = r9
            goto L_0x008c
        L_0x008b:
            r15 = r2
        L_0x008c:
            int r8 = r4.q
            if (r12 == 0) goto L_0x01a4
            if (r13 == 0) goto L_0x01a4
            if (r14 == 0) goto L_0x01a4
            if (r15 == 0) goto L_0x01a4
            float r4 = r4.e
            boolean r11 = r10.f436c
            int[] r12 = a
            if (r11 == 0) goto L_0x00ed
            boolean r11 = r3.f436c
            if (r11 == 0) goto L_0x00ed
            boolean r5 = r6.f435b
            if (r5 == 0) goto L_0x00ec
            boolean r5 = r7.f435b
            if (r5 != 0) goto L_0x00ab
            goto L_0x00ec
        L_0x00ab:
            java.util.ArrayList r5 = r6.f434b
            java.lang.Object r5 = r5.get(r2)
            N8 r5 = (defpackage.N8) r5
            int r5 = r5.c
            int r6 = r6.b
            int r17 = r5 + r6
            java.util.ArrayList r5 = r7.f434b
            java.lang.Object r5 = r5.get(r2)
            N8 r5 = (defpackage.N8) r5
            int r5 = r5.c
            int r6 = r7.b
            int r18 = r5 - r6
            int r5 = r10.c
            int r6 = r10.b
            int r19 = r5 + r6
            int r5 = r3.c
            int r3 = r3.b
            int r20 = r5 - r3
            r16 = r12
            r21 = r4
            r22 = r8
            m(r16, r17, r18, r19, r20, r21, r22)
            r2 = r12[r2]
            r1.d(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            hC r1 = r1.f1350a
            c9 r1 = r1.f82a
            r2 = r12[r9]
            r1.d(r2)
        L_0x00ec:
            return
        L_0x00ed:
            boolean r11 = r6.f436c
            java.util.ArrayList r13 = r10.f434b
            if (r11 == 0) goto L_0x0141
            boolean r11 = r7.f436c
            if (r11 == 0) goto L_0x0141
            boolean r11 = r10.f435b
            if (r11 == 0) goto L_0x0140
            boolean r11 = r3.f435b
            if (r11 != 0) goto L_0x0100
            goto L_0x0140
        L_0x0100:
            int r11 = r6.c
            int r14 = r6.b
            int r17 = r11 + r14
            int r11 = r7.c
            int r14 = r7.b
            int r18 = r11 - r14
            java.lang.Object r11 = r13.get(r2)
            N8 r11 = (defpackage.N8) r11
            int r11 = r11.c
            int r14 = r10.b
            int r19 = r11 + r14
            java.util.ArrayList r11 = r3.f434b
            java.lang.Object r11 = r11.get(r2)
            N8 r11 = (defpackage.N8) r11
            int r11 = r11.c
            int r14 = r3.b
            int r20 = r11 - r14
            r16 = r12
            r21 = r4
            r22 = r8
            m(r16, r17, r18, r19, r20, r21, r22)
            r11 = r12[r2]
            r1.d(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r0.f81a
            hC r11 = r11.f1350a
            c9 r11 = r11.f82a
            r14 = r12[r9]
            r11.d(r14)
            goto L_0x0141
        L_0x0140:
            return
        L_0x0141:
            boolean r11 = r6.f435b
            if (r11 == 0) goto L_0x01a3
            boolean r11 = r7.f435b
            if (r11 == 0) goto L_0x01a3
            boolean r11 = r10.f435b
            if (r11 == 0) goto L_0x01a3
            boolean r11 = r3.f435b
            if (r11 != 0) goto L_0x0152
            goto L_0x01a3
        L_0x0152:
            java.util.ArrayList r11 = r6.f434b
            java.lang.Object r11 = r11.get(r2)
            N8 r11 = (defpackage.N8) r11
            int r11 = r11.c
            int r14 = r6.b
            int r17 = r11 + r14
            java.util.ArrayList r11 = r7.f434b
            java.lang.Object r11 = r11.get(r2)
            N8 r11 = (defpackage.N8) r11
            int r11 = r11.c
            int r14 = r7.b
            int r18 = r11 - r14
            java.lang.Object r11 = r13.get(r2)
            N8 r11 = (defpackage.N8) r11
            int r11 = r11.c
            int r10 = r10.b
            int r19 = r11 + r10
            java.util.ArrayList r10 = r3.f434b
            java.lang.Object r10 = r10.get(r2)
            N8 r10 = (defpackage.N8) r10
            int r10 = r10.c
            int r3 = r3.b
            int r20 = r10 - r3
            r16 = r12
            r21 = r4
            r22 = r8
            m(r16, r17, r18, r19, r20, r21, r22)
            r3 = r12[r2]
            r1.d(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            hC r3 = r3.f1350a
            c9 r3 = r3.f82a
            r4 = r12[r9]
            r3.d(r4)
            goto L_0x02aa
        L_0x01a3:
            return
        L_0x01a4:
            if (r12 == 0) goto L_0x021c
            if (r14 == 0) goto L_0x021c
            boolean r3 = r6.f435b
            if (r3 == 0) goto L_0x021b
            boolean r3 = r7.f435b
            if (r3 != 0) goto L_0x01b1
            goto L_0x021b
        L_0x01b1:
            float r3 = r4.e
            java.util.ArrayList r4 = r6.f434b
            java.lang.Object r4 = r4.get(r2)
            N8 r4 = (defpackage.N8) r4
            int r4 = r4.c
            int r10 = r6.b
            int r4 = r4 + r10
            java.util.ArrayList r10 = r7.f434b
            java.lang.Object r10 = r10.get(r2)
            N8 r10 = (defpackage.N8) r10
            int r10 = r10.c
            int r12 = r7.b
            int r10 = r10 - r12
            if (r8 == r11) goto L_0x01f8
            if (r8 == 0) goto L_0x01f8
            if (r8 == r9) goto L_0x01d5
            goto L_0x02aa
        L_0x01d5:
            int r10 = r10 - r4
            int r4 = r0.g(r10, r2)
            float r8 = (float) r4
            float r8 = r8 / r3
            r10 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r10
            int r8 = (int) r8
            int r11 = r0.g(r8, r9)
            if (r8 == r11) goto L_0x01ea
            float r4 = (float) r11
            float r4 = r4 * r3
            float r4 = r4 + r10
            int r4 = (int) r4
        L_0x01ea:
            r1.d(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            hC r3 = r3.f1350a
            c9 r3 = r3.f82a
            r3.d(r11)
            goto L_0x02aa
        L_0x01f8:
            int r10 = r10 - r4
            int r4 = r0.g(r10, r2)
            float r8 = (float) r4
            float r8 = r8 * r3
            r10 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r10
            int r8 = (int) r8
            int r11 = r0.g(r8, r9)
            if (r8 == r11) goto L_0x020d
            float r4 = (float) r11
            float r4 = r4 / r3
            float r4 = r4 + r10
            int r4 = (int) r4
        L_0x020d:
            r1.d(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            hC r3 = r3.f1350a
            c9 r3 = r3.f82a
            r3.d(r11)
            goto L_0x02aa
        L_0x021b:
            return
        L_0x021c:
            if (r13 == 0) goto L_0x02aa
            if (r15 == 0) goto L_0x02aa
            boolean r12 = r10.f435b
            if (r12 == 0) goto L_0x0290
            boolean r12 = r3.f435b
            if (r12 != 0) goto L_0x0229
            goto L_0x0290
        L_0x0229:
            float r4 = r4.e
            java.util.ArrayList r12 = r10.f434b
            java.lang.Object r12 = r12.get(r2)
            N8 r12 = (defpackage.N8) r12
            int r12 = r12.c
            int r10 = r10.b
            int r12 = r12 + r10
            java.util.ArrayList r10 = r3.f434b
            java.lang.Object r10 = r10.get(r2)
            N8 r10 = (defpackage.N8) r10
            int r10 = r10.c
            int r3 = r3.b
            int r10 = r10 - r3
            if (r8 == r11) goto L_0x026e
            if (r8 == 0) goto L_0x024c
            if (r8 == r9) goto L_0x026e
            goto L_0x02aa
        L_0x024c:
            int r10 = r10 - r12
            int r3 = r0.g(r10, r9)
            float r8 = (float) r3
            float r8 = r8 * r4
            r10 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r10
            int r8 = (int) r8
            int r11 = r0.g(r8, r2)
            if (r8 == r11) goto L_0x0261
            float r3 = (float) r11
            float r3 = r3 / r4
            float r3 = r3 + r10
            int r3 = (int) r3
        L_0x0261:
            r1.d(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            hC r4 = r4.f1350a
            c9 r4 = r4.f82a
            r4.d(r3)
            goto L_0x02aa
        L_0x026e:
            int r10 = r10 - r12
            int r3 = r0.g(r10, r9)
            float r8 = (float) r3
            float r8 = r8 / r4
            r10 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r10
            int r8 = (int) r8
            int r11 = r0.g(r8, r2)
            if (r8 == r11) goto L_0x0283
            float r3 = (float) r11
            float r3 = r3 * r4
            float r3 = r3 + r10
            int r3 = (int) r3
        L_0x0283:
            r1.d(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            hC r4 = r4.f1350a
            c9 r4 = r4.f82a
            r4.d(r3)
            goto L_0x02aa
        L_0x0290:
            return
        L_0x0291:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r4.f1349a
            if (r3 == 0) goto L_0x02aa
            af r3 = r3.f1347a
            c9 r3 = r3.f82a
            boolean r8 = r3.f436c
            if (r8 == 0) goto L_0x02aa
            float r4 = r4.a
            int r3 = r3.c
            float r3 = (float) r3
            float r3 = r3 * r4
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r4
            int r3 = (int) r3
            r1.d(r3)
        L_0x02aa:
            boolean r3 = r6.f435b
            if (r3 == 0) goto L_0x0380
            boolean r3 = r7.f435b
            if (r3 != 0) goto L_0x02b4
            goto L_0x0380
        L_0x02b4:
            boolean r3 = r6.f436c
            if (r3 == 0) goto L_0x02c1
            boolean r3 = r7.f436c
            if (r3 == 0) goto L_0x02c1
            boolean r3 = r1.f436c
            if (r3 == 0) goto L_0x02c1
            return
        L_0x02c1:
            boolean r3 = r1.f436c
            java.util.ArrayList r4 = r6.f434b
            java.util.ArrayList r8 = r7.f434b
            if (r3 != 0) goto L_0x02fb
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r3 = r0.f80a
            if (r3 != r5) goto L_0x02fb
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            int r10 = r3.f1381f
            if (r10 != 0) goto L_0x02fb
            boolean r3 = r3.B()
            if (r3 != 0) goto L_0x02fb
            java.lang.Object r3 = r4.get(r2)
            N8 r3 = (defpackage.N8) r3
            java.lang.Object r2 = r8.get(r2)
            N8 r2 = (defpackage.N8) r2
            int r3 = r3.c
            int r4 = r6.b
            int r3 = r3 + r4
            int r2 = r2.c
            int r4 = r7.b
            int r2 = r2 + r4
            int r4 = r2 - r3
            r6.d(r3)
            r7.d(r2)
            r1.d(r4)
            return
        L_0x02fb:
            boolean r3 = r1.f436c
            if (r3 != 0) goto L_0x0343
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r3 = r0.f80a
            if (r3 != r5) goto L_0x0343
            int r3 = r0.a
            if (r3 != r9) goto L_0x0343
            int r3 = r4.size()
            if (r3 <= 0) goto L_0x0343
            int r3 = r8.size()
            if (r3 <= 0) goto L_0x0343
            java.lang.Object r3 = r4.get(r2)
            N8 r3 = (defpackage.N8) r3
            java.lang.Object r5 = r8.get(r2)
            N8 r5 = (defpackage.N8) r5
            int r3 = r3.c
            int r9 = r6.b
            int r3 = r3 + r9
            int r5 = r5.c
            int r9 = r7.b
            int r5 = r5 + r9
            int r5 = r5 - r3
            int r3 = r1.e
            int r3 = java.lang.Math.min(r5, r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r0.f81a
            int r9 = r5.i
            int r5 = r5.h
            int r3 = java.lang.Math.max(r5, r3)
            if (r9 <= 0) goto L_0x0340
            int r3 = java.lang.Math.min(r9, r3)
        L_0x0340:
            r1.d(r3)
        L_0x0343:
            boolean r3 = r1.f436c
            if (r3 != 0) goto L_0x0348
            return
        L_0x0348:
            java.lang.Object r3 = r4.get(r2)
            N8 r3 = (defpackage.N8) r3
            java.lang.Object r2 = r8.get(r2)
            N8 r2 = (defpackage.N8) r2
            int r4 = r3.c
            int r5 = r6.b
            int r5 = r5 + r4
            int r8 = r2.c
            int r9 = r7.b
            int r9 = r9 + r8
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r0.f81a
            float r10 = r10.f
            if (r3 != r2) goto L_0x0367
            r10 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0369
        L_0x0367:
            r4 = r5
            r8 = r9
        L_0x0369:
            int r8 = r8 - r4
            int r2 = r1.c
            int r8 = r8 - r2
            float r2 = (float) r4
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            float r3 = (float) r8
            float r3 = r3 * r10
            float r3 = r3 + r2
            int r2 = (int) r3
            r6.d(r2)
            int r2 = r6.c
            int r1 = r1.c
            int r2 = r2 + r1
            r7.d(r2)
        L_0x0380:
            return
        L_0x0381:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1371c
            r0.l(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.af.a(J8):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007d, code lost:
        r0 = r11.f81a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r11 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            boolean r1 = r0.f1354a
            c9 r2 = r11.f82a
            if (r1 == 0) goto L_0x000f
            int r0 = r0.u()
            r2.d(r0)
        L_0x000f:
            boolean r0 = r2.f436c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_PARENT
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.FIXED
            N8 r5 = r11.f85b
            N8 r6 = r11.f79a
            r7 = 0
            if (r0 != 0) goto L_0x0079
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r8 = r0.f1358a
            r8 = r8[r7]
            r11.f80a = r8
            if (r8 == r1) goto L_0x00a9
            if (r8 != r3) goto L_0x006f
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r0.f1349a
            if (r9 == 0) goto L_0x006f
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r10 = r9.f1358a
            r10 = r10[r7]
            if (r10 == r4) goto L_0x0036
            if (r10 != r3) goto L_0x006f
        L_0x0036:
            int r0 = r9.u()
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1348a
            int r1 = r1.e()
            int r0 = r0 - r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1371c
            int r1 = r1.e()
            int r0 = r0 - r1
            af r1 = r9.f1347a
            N8 r1 = r1.f79a
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1348a
            int r3 = r3.e()
            defpackage.CD.b(r6, r1, r3)
            af r1 = r9.f1347a
            N8 r1 = r1.f85b
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1371c
            int r3 = r3.e()
            int r3 = -r3
            defpackage.CD.b(r5, r1, r3)
            r2.d(r0)
            return
        L_0x006f:
            if (r8 != r4) goto L_0x00a9
            int r0 = r0.u()
            r2.d(r0)
            goto L_0x00a9
        L_0x0079:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r0 = r11.f80a
            if (r0 != r3) goto L_0x00a9
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r0.f1349a
            if (r8 == 0) goto L_0x00a9
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r9 = r8.f1358a
            r9 = r9[r7]
            if (r9 == r4) goto L_0x008b
            if (r9 != r3) goto L_0x00a9
        L_0x008b:
            af r1 = r8.f1347a
            N8 r1 = r1.f79a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1348a
            int r0 = r0.e()
            defpackage.CD.b(r6, r1, r0)
            af r0 = r8.f1347a
            N8 r0 = r0.f85b
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1371c
            int r1 = r1.e()
            int r1 = -r1
            defpackage.CD.b(r5, r0, r1)
            return
        L_0x00a9:
            boolean r0 = r2.f436c
            r3 = 1
            if (r0 == 0) goto L_0x0182
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            boolean r4 = r0.f1354a
            if (r4 == 0) goto L_0x0182
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r0.f1357a
            r4 = r1[r7]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r4.f1339a
            if (r8 == 0) goto L_0x011c
            r9 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f1339a
            if (r9 == 0) goto L_0x011c
            boolean r0 = r0.B()
            if (r0 == 0) goto L_0x00e3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r7]
            int r0 = r0.e()
            r6.b = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r3]
            int r0 = r0.e()
            int r0 = -r0
            r5.b = r0
            goto L_0x030a
        L_0x00e3:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r7]
            N8 r0 = defpackage.CD.h(r0)
            if (r0 == 0) goto L_0x00fc
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r7]
            int r1 = r1.e()
            defpackage.CD.b(r6, r0, r1)
        L_0x00fc:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r3]
            N8 r0 = defpackage.CD.h(r0)
            if (r0 == 0) goto L_0x0116
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r3]
            int r1 = r1.e()
            int r1 = -r1
            defpackage.CD.b(r5, r0, r1)
        L_0x0116:
            r6.f432a = r3
            r5.f432a = r3
            goto L_0x030a
        L_0x011c:
            if (r8 == 0) goto L_0x0138
            N8 r0 = defpackage.CD.h(r4)
            if (r0 == 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r7]
            int r1 = r1.e()
            defpackage.CD.b(r6, r0, r1)
            int r0 = r2.c
            defpackage.CD.b(r5, r6, r0)
            goto L_0x030a
        L_0x0138:
            r1 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f1339a
            if (r4 == 0) goto L_0x015a
            N8 r0 = defpackage.CD.h(r1)
            if (r0 == 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r3]
            int r1 = r1.e()
            int r1 = -r1
            defpackage.CD.b(r5, r0, r1)
            int r0 = r2.c
            int r0 = -r0
            defpackage.CD.b(r6, r5, r0)
            goto L_0x030a
        L_0x015a:
            boolean r1 = r0 instanceof defpackage.Re
            if (r1 != 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f1349a
            if (r1 == 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.m(r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1339a
            if (r0 != 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f1349a
            af r1 = r1.f1347a
            N8 r1 = r1.f79a
            int r0 = r0.v()
            defpackage.CD.b(r6, r1, r0)
            int r0 = r2.c
            defpackage.CD.b(r5, r6, r0)
            goto L_0x030a
        L_0x0182:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r0 = r11.f80a
            if (r0 != r1) goto L_0x0269
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            int r1 = r0.f1381f
            r4 = 2
            java.util.ArrayList r8 = r2.f431a
            java.util.ArrayList r9 = r2.f434b
            if (r1 == r4) goto L_0x0250
            r4 = 3
            if (r1 == r4) goto L_0x0196
            goto L_0x0269
        L_0x0196:
            int r1 = r0.f1384g
            if (r1 != r4) goto L_0x021b
            r6.f429a = r11
            r5.f429a = r11
            hC r1 = r0.f1350a
            N8 r4 = r1.f79a
            r4.f429a = r11
            N8 r1 = r1.f85b
            r1.f429a = r11
            r2.f429a = r11
            boolean r0 = r0.C()
            if (r0 == 0) goto L_0x01f2
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            c9 r0 = r0.f82a
            r9.add(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            c9 r0 = r0.f82a
            java.util.ArrayList r0 = r0.f431a
            r0.add(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            c9 r1 = r0.f82a
            r1.f429a = r11
            N8 r0 = r0.f79a
            r9.add(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            N8 r0 = r0.f85b
            r9.add(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            N8 r0 = r0.f79a
            java.util.ArrayList r0 = r0.f431a
            r0.add(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            N8 r0 = r0.f85b
            java.util.ArrayList r0 = r0.f431a
            r0.add(r2)
            goto L_0x0269
        L_0x01f2:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            boolean r0 = r0.B()
            if (r0 == 0) goto L_0x020f
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            c9 r0 = r0.f82a
            java.util.ArrayList r0 = r0.f434b
            r0.add(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            c9 r0 = r0.f82a
            r8.add(r0)
            goto L_0x0269
        L_0x020f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            c9 r0 = r0.f82a
            java.util.ArrayList r0 = r0.f434b
            r0.add(r2)
            goto L_0x0269
        L_0x021b:
            hC r0 = r0.f1350a
            c9 r0 = r0.f82a
            r9.add(r0)
            java.util.ArrayList r0 = r0.f431a
            r0.add(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            N8 r0 = r0.f79a
            java.util.ArrayList r0 = r0.f431a
            r0.add(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            hC r0 = r0.f1350a
            N8 r0 = r0.f85b
            java.util.ArrayList r0 = r0.f431a
            r0.add(r2)
            r2.f432a = r3
            r8.add(r6)
            r8.add(r5)
            java.util.ArrayList r0 = r6.f434b
            r0.add(r2)
            java.util.ArrayList r0 = r5.f434b
            r0.add(r2)
            goto L_0x0269
        L_0x0250:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.f1349a
            if (r0 != 0) goto L_0x0255
            goto L_0x0269
        L_0x0255:
            hC r0 = r0.f1350a
            c9 r0 = r0.f82a
            r9.add(r0)
            java.util.ArrayList r0 = r0.f431a
            r0.add(r2)
            r2.f432a = r3
            r8.add(r6)
            r8.add(r5)
        L_0x0269:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r0.f1357a
            r4 = r1[r7]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r4.f1339a
            if (r8 == 0) goto L_0x02bc
            r9 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f1339a
            if (r9 == 0) goto L_0x02bc
            boolean r0 = r0.B()
            if (r0 == 0) goto L_0x029a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r7]
            int r0 = r0.e()
            r6.b = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r3]
            int r0 = r0.e()
            int r0 = -r0
            r5.b = r0
            goto L_0x030a
        L_0x029a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r7]
            N8 r0 = defpackage.CD.h(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r3]
            N8 r1 = defpackage.CD.h(r1)
            if (r0 == 0) goto L_0x02b3
            r0.b(r11)
        L_0x02b3:
            if (r1 == 0) goto L_0x02b8
            r1.b(r11)
        L_0x02b8:
            r0 = 4
            r11.c = r0
            goto L_0x030a
        L_0x02bc:
            if (r8 == 0) goto L_0x02d5
            N8 r0 = defpackage.CD.h(r4)
            if (r0 == 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r7]
            int r1 = r1.e()
            defpackage.CD.b(r6, r0, r1)
            r11.c(r5, r6, r3, r2)
            goto L_0x030a
        L_0x02d5:
            r1 = r1[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f1339a
            if (r4 == 0) goto L_0x02f4
            N8 r0 = defpackage.CD.h(r1)
            if (r0 == 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r11.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r3]
            int r1 = r1.e()
            int r1 = -r1
            defpackage.CD.b(r5, r0, r1)
            r0 = -1
            r11.c(r6, r5, r0, r2)
            goto L_0x030a
        L_0x02f4:
            boolean r1 = r0 instanceof defpackage.Re
            if (r1 != 0) goto L_0x030a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f1349a
            if (r1 == 0) goto L_0x030a
            af r1 = r1.f1347a
            N8 r1 = r1.f79a
            int r0 = r0.v()
            defpackage.CD.b(r6, r1, r0)
            r11.c(r5, r6, r3, r2)
        L_0x030a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.af.d():void");
    }

    public final void e() {
        N8 n8 = this.f79a;
        if (n8.f436c) {
            this.f81a.r = n8.c;
        }
    }

    public final void f() {
        this.f83a = null;
        this.f79a.c();
        this.f85b.c();
        this.f82a.c();
        this.f84a = false;
    }

    public final boolean k() {
        if (this.f80a != ConstraintWidget.a.MATCH_CONSTRAINT || this.f81a.f1381f == 0) {
            return true;
        }
        return false;
    }

    public final void n() {
        this.f84a = false;
        N8 n8 = this.f79a;
        n8.c();
        n8.f436c = false;
        N8 n82 = this.f85b;
        n82.c();
        n82.f436c = false;
        this.f82a.f436c = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f81a.f1365b;
    }
}
