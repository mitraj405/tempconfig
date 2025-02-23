package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* renamed from: hC  reason: default package and case insensitive filesystem */
/* compiled from: VerticalWidgetRun */
public final class C0213hC extends CD {
    public C2 a = null;
    public final N8 c;

    public C0213hC(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        N8 n8 = new N8(this);
        this.c = n8;
        this.f79a.a = 6;
        this.f85b.a = 7;
        n8.a = 8;
        this.b = 1;
    }

    public final void a(J8 j8) {
        int i;
        float f;
        float f2;
        float f3;
        if (xx.V(this.c) != 3) {
            C0154c9 c9Var = this.f82a;
            boolean z = c9Var.f435b;
            ConstraintWidget.a aVar = ConstraintWidget.a.MATCH_CONSTRAINT;
            if (z && !c9Var.f436c && this.f80a == aVar) {
                ConstraintWidget constraintWidget = this.f81a;
                int i2 = constraintWidget.f1384g;
                if (i2 == 2) {
                    ConstraintWidget constraintWidget2 = constraintWidget.f1349a;
                    if (constraintWidget2 != null) {
                        C0154c9 c9Var2 = constraintWidget2.f1350a.f82a;
                        if (c9Var2.f436c) {
                            c9Var.d((int) ((((float) c9Var2.c) * constraintWidget.b) + 0.5f));
                        }
                    }
                } else if (i2 == 3) {
                    C0154c9 c9Var3 = constraintWidget.f1347a.f82a;
                    if (c9Var3.f436c) {
                        int i3 = constraintWidget.q;
                        if (i3 == -1) {
                            f3 = (float) c9Var3.c;
                            f2 = constraintWidget.e;
                        } else if (i3 == 0) {
                            f = ((float) c9Var3.c) * constraintWidget.e;
                            i = (int) (f + 0.5f);
                            c9Var.d(i);
                        } else if (i3 != 1) {
                            i = 0;
                            c9Var.d(i);
                        } else {
                            f3 = (float) c9Var3.c;
                            f2 = constraintWidget.e;
                        }
                        f = f3 / f2;
                        i = (int) (f + 0.5f);
                        c9Var.d(i);
                    }
                }
            }
            N8 n8 = this.f79a;
            if (n8.f435b) {
                N8 n82 = this.f85b;
                if (n82.f435b) {
                    if (!n8.f436c || !n82.f436c || !c9Var.f436c) {
                        boolean z2 = c9Var.f436c;
                        ArrayList arrayList = n8.f434b;
                        ArrayList arrayList2 = n82.f434b;
                        if (!z2 && this.f80a == aVar) {
                            ConstraintWidget constraintWidget3 = this.f81a;
                            if (constraintWidget3.f1381f == 0 && !constraintWidget3.C()) {
                                int i4 = ((N8) arrayList.get(0)).c + n8.b;
                                int i5 = ((N8) arrayList2.get(0)).c + n82.b;
                                n8.d(i4);
                                n82.d(i5);
                                c9Var.d(i5 - i4);
                                return;
                            }
                        }
                        if (!c9Var.f436c && this.f80a == aVar && this.a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                            int i6 = (((N8) arrayList2.get(0)).c + n82.b) - (((N8) arrayList.get(0)).c + n8.b);
                            int i7 = c9Var.e;
                            if (i6 < i7) {
                                c9Var.d(i6);
                            } else {
                                c9Var.d(i7);
                            }
                        }
                        if (c9Var.f436c && arrayList.size() > 0 && arrayList2.size() > 0) {
                            N8 n83 = (N8) arrayList.get(0);
                            N8 n84 = (N8) arrayList2.get(0);
                            int i8 = n83.c;
                            int i9 = n8.b + i8;
                            int i10 = n84.c;
                            int i11 = n82.b + i10;
                            float f4 = this.f81a.g;
                            if (n83 == n84) {
                                f4 = 0.5f;
                            } else {
                                i8 = i9;
                                i10 = i11;
                            }
                            n8.d((int) ((((float) ((i10 - i8) - c9Var.c)) * f4) + ((float) i8) + 0.5f));
                            n82.d(n8.c + c9Var.c);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        ConstraintWidget constraintWidget4 = this.f81a;
        l(constraintWidget4.f1363b, constraintWidget4.f1376d, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008e, code lost:
        r1 = r0.f81a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
            r16 = this;
            r0 = r16
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r2 = r1.f1354a
            c9 r3 = r0.f82a
            if (r2 == 0) goto L_0x0011
            int r1 = r1.o()
            r3.d(r1)
        L_0x0011:
            boolean r1 = r3.f436c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_PARENT
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.FIXED
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            N8 r6 = r0.f85b
            N8 r7 = r0.f79a
            r8 = 1
            if (r1 != 0) goto L_0x008a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r9 = r1.f1358a
            r9 = r9[r8]
            r0.f80a = r9
            boolean r1 = r1.f1388h
            if (r1 == 0) goto L_0x0033
            C2 r1 = new C2
            r1.<init>(r0)
            r0.a = r1
        L_0x0033:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = r0.f80a
            if (r1 == r5) goto L_0x00b8
            if (r1 != r2) goto L_0x007e
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.f1349a
            if (r2 == 0) goto L_0x007e
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r9 = r2.f1358a
            r9 = r9[r8]
            if (r9 != r4) goto L_0x007e
            int r1 = r2.o()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1363b
            int r4 = r4.e()
            int r1 = r1 - r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1376d
            int r4 = r4.e()
            int r1 = r1 - r4
            hC r4 = r2.f1350a
            N8 r4 = r4.f79a
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1363b
            int r5 = r5.e()
            defpackage.CD.b(r7, r4, r5)
            hC r2 = r2.f1350a
            N8 r2 = r2.f85b
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1376d
            int r4 = r4.e()
            int r4 = -r4
            defpackage.CD.b(r6, r2, r4)
            r3.d(r1)
            return
        L_0x007e:
            if (r1 != r4) goto L_0x00b8
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            int r1 = r1.o()
            r3.d(r1)
            goto L_0x00b8
        L_0x008a:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = r0.f80a
            if (r1 != r2) goto L_0x00b8
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.f1349a
            if (r2 == 0) goto L_0x00b8
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r9 = r2.f1358a
            r9 = r9[r8]
            if (r9 != r4) goto L_0x00b8
            hC r3 = r2.f1350a
            N8 r3 = r3.f79a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1363b
            int r1 = r1.e()
            defpackage.CD.b(r7, r3, r1)
            hC r1 = r2.f1350a
            N8 r1 = r1.f85b
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f1376d
            int r2 = r2.e()
            int r2 = -r2
            defpackage.CD.b(r6, r1, r2)
            return
        L_0x00b8:
            boolean r1 = r3.f436c
            N8 r2 = r0.c
            r4 = 4
            r9 = 0
            r10 = 2
            r11 = 3
            if (r1 == 0) goto L_0x01df
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r0.f81a
            boolean r13 = r12.f1354a
            if (r13 == 0) goto L_0x01df
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.f1357a
            r5 = r1[r10]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r5.f1339a
            if (r13 == 0) goto L_0x013a
            r14 = r1[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r14.f1339a
            if (r14 == 0) goto L_0x013a
            boolean r1 = r12.C()
            if (r1 == 0) goto L_0x00f6
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r10]
            int r1 = r1.e()
            r7.b = r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r11]
            int r1 = r1.e()
            int r1 = -r1
            r6.b = r1
            goto L_0x012d
        L_0x00f6:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r10]
            N8 r1 = defpackage.CD.h(r1)
            if (r1 == 0) goto L_0x010f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r3.f1357a
            r3 = r3[r10]
            int r3 = r3.e()
            defpackage.CD.b(r7, r1, r3)
        L_0x010f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r11]
            N8 r1 = defpackage.CD.h(r1)
            if (r1 == 0) goto L_0x0129
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r3.f1357a
            r3 = r3[r11]
            int r3 = r3.e()
            int r3 = -r3
            defpackage.CD.b(r6, r1, r3)
        L_0x0129:
            r7.f432a = r8
            r6.f432a = r8
        L_0x012d:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r3 = r1.f1388h
            if (r3 == 0) goto L_0x0368
            int r1 = r1.t
            defpackage.CD.b(r2, r7, r1)
            goto L_0x0368
        L_0x013a:
            if (r13 == 0) goto L_0x0161
            N8 r1 = defpackage.CD.h(r5)
            if (r1 == 0) goto L_0x0368
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r4.f1357a
            r4 = r4[r10]
            int r4 = r4.e()
            defpackage.CD.b(r7, r1, r4)
            int r1 = r3.c
            defpackage.CD.b(r6, r7, r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r3 = r1.f1388h
            if (r3 == 0) goto L_0x0368
            int r1 = r1.t
            defpackage.CD.b(r2, r7, r1)
            goto L_0x0368
        L_0x0161:
            r5 = r1[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r5.f1339a
            if (r8 == 0) goto L_0x018e
            N8 r1 = defpackage.CD.h(r5)
            if (r1 == 0) goto L_0x0181
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r4.f1357a
            r4 = r4[r11]
            int r4 = r4.e()
            int r4 = -r4
            defpackage.CD.b(r6, r1, r4)
            int r1 = r3.c
            int r1 = -r1
            defpackage.CD.b(r7, r6, r1)
        L_0x0181:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r3 = r1.f1388h
            if (r3 == 0) goto L_0x0368
            int r1 = r1.t
            defpackage.CD.b(r2, r7, r1)
            goto L_0x0368
        L_0x018e:
            r1 = r1[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f1339a
            if (r4 == 0) goto L_0x01ac
            N8 r1 = defpackage.CD.h(r1)
            if (r1 == 0) goto L_0x0368
            defpackage.CD.b(r2, r1, r9)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            int r1 = r1.t
            int r1 = -r1
            defpackage.CD.b(r7, r2, r1)
            int r1 = r3.c
            defpackage.CD.b(r6, r7, r1)
            goto L_0x0368
        L_0x01ac:
            boolean r1 = r12 instanceof defpackage.Re
            if (r1 != 0) goto L_0x0368
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r12.f1349a
            if (r1 == 0) goto L_0x0368
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r12.m(r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1339a
            if (r1 != 0) goto L_0x0368
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.f1349a
            hC r4 = r4.f1350a
            N8 r4 = r4.f79a
            int r1 = r1.w()
            defpackage.CD.b(r7, r4, r1)
            int r1 = r3.c
            defpackage.CD.b(r6, r7, r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r3 = r1.f1388h
            if (r3 == 0) goto L_0x0368
            int r1 = r1.t
            defpackage.CD.b(r2, r7, r1)
            goto L_0x0368
        L_0x01df:
            java.util.ArrayList r12 = r3.f434b
            if (r1 != 0) goto L_0x022e
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = r0.f80a
            if (r1 != r5) goto L_0x022e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            int r13 = r1.f1384g
            java.util.ArrayList r14 = r3.f431a
            if (r13 == r10) goto L_0x0214
            if (r13 == r11) goto L_0x01f2
            goto L_0x0231
        L_0x01f2:
            boolean r1 = r1.C()
            if (r1 != 0) goto L_0x0231
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            int r13 = r1.f1381f
            if (r13 != r11) goto L_0x01ff
            goto L_0x0231
        L_0x01ff:
            af r1 = r1.f1347a
            c9 r1 = r1.f82a
            r12.add(r1)
            java.util.ArrayList r1 = r1.f431a
            r1.add(r3)
            r3.f432a = r8
            r14.add(r7)
            r14.add(r6)
            goto L_0x0231
        L_0x0214:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f1349a
            if (r1 != 0) goto L_0x0219
            goto L_0x0231
        L_0x0219:
            hC r1 = r1.f1350a
            c9 r1 = r1.f82a
            r12.add(r1)
            java.util.ArrayList r1 = r1.f431a
            r1.add(r3)
            r3.f432a = r8
            r14.add(r7)
            r14.add(r6)
            goto L_0x0231
        L_0x022e:
            r3.b(r0)
        L_0x0231:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r13 = r1.f1357a
            r14 = r13[r10]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r14.f1339a
            if (r15 == 0) goto L_0x028e
            r9 = r13[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.f1339a
            if (r9 == 0) goto L_0x028e
            boolean r1 = r1.C()
            if (r1 == 0) goto L_0x0261
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r10]
            int r1 = r1.e()
            r7.b = r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r11]
            int r1 = r1.e()
            int r1 = -r1
            r6.b = r1
            goto L_0x0281
        L_0x0261:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r1.f1357a
            r1 = r1[r10]
            N8 r1 = defpackage.CD.h(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r5.f1357a
            r5 = r5[r11]
            N8 r5 = defpackage.CD.h(r5)
            if (r1 == 0) goto L_0x027a
            r1.b(r0)
        L_0x027a:
            if (r5 == 0) goto L_0x027f
            r5.b(r0)
        L_0x027f:
            r0.c = r4
        L_0x0281:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r1 = r1.f1388h
            if (r1 == 0) goto L_0x0360
            C2 r1 = r0.a
            r0.c(r2, r7, r8, r1)
            goto L_0x0360
        L_0x028e:
            r9 = 0
            if (r15 == 0) goto L_0x02d8
            N8 r1 = defpackage.CD.h(r14)
            if (r1 == 0) goto L_0x0360
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r4.f1357a
            r4 = r4[r10]
            int r4 = r4.e()
            defpackage.CD.b(r7, r1, r4)
            r0.c(r6, r7, r8, r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r1 = r1.f1388h
            if (r1 == 0) goto L_0x02b2
            C2 r1 = r0.a
            r0.c(r2, r7, r8, r1)
        L_0x02b2:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = r0.f80a
            if (r1 != r5) goto L_0x0360
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            float r2 = r1.e
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0360
            af r1 = r1.f1347a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r2 = r1.f80a
            if (r2 != r5) goto L_0x0360
            c9 r1 = r1.f82a
            java.util.ArrayList r1 = r1.f431a
            r1.add(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            af r1 = r1.f1347a
            c9 r1 = r1.f82a
            r12.add(r1)
            r3.f429a = r0
            goto L_0x0360
        L_0x02d8:
            r10 = r13[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r10.f1339a
            r15 = -1
            if (r14 == 0) goto L_0x0302
            N8 r1 = defpackage.CD.h(r10)
            if (r1 == 0) goto L_0x0360
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r4.f1357a
            r4 = r4[r11]
            int r4 = r4.e()
            int r4 = -r4
            defpackage.CD.b(r6, r1, r4)
            r0.c(r7, r6, r15, r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r1 = r1.f1388h
            if (r1 == 0) goto L_0x0360
            C2 r1 = r0.a
            r0.c(r2, r7, r8, r1)
            goto L_0x0360
        L_0x0302:
            r4 = r13[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r4.f1339a
            if (r10 == 0) goto L_0x031b
            N8 r1 = defpackage.CD.h(r4)
            if (r1 == 0) goto L_0x0360
            r4 = 0
            defpackage.CD.b(r2, r1, r4)
            C2 r1 = r0.a
            r0.c(r7, r2, r15, r1)
            r0.c(r6, r7, r8, r3)
            goto L_0x0360
        L_0x031b:
            boolean r4 = r1 instanceof defpackage.Re
            if (r4 != 0) goto L_0x0360
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.f1349a
            if (r4 == 0) goto L_0x0360
            hC r4 = r4.f1350a
            N8 r4 = r4.f79a
            int r1 = r1.w()
            defpackage.CD.b(r7, r4, r1)
            r0.c(r6, r7, r8, r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            boolean r1 = r1.f1388h
            if (r1 == 0) goto L_0x033c
            C2 r1 = r0.a
            r0.c(r2, r7, r8, r1)
        L_0x033c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = r0.f80a
            if (r1 != r5) goto L_0x0360
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            float r2 = r1.e
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x0360
            af r1 = r1.f1347a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r2 = r1.f80a
            if (r2 != r5) goto L_0x0360
            c9 r1 = r1.f82a
            java.util.ArrayList r1 = r1.f431a
            r1.add(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f81a
            af r1 = r1.f1347a
            c9 r1 = r1.f82a
            r12.add(r1)
            r3.f429a = r0
        L_0x0360:
            int r1 = r12.size()
            if (r1 != 0) goto L_0x0368
            r3.f435b = r8
        L_0x0368:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0213hC.d():void");
    }

    public final void e() {
        N8 n8 = this.f79a;
        if (n8.f436c) {
            this.f81a.s = n8.c;
        }
    }

    public final void f() {
        this.f83a = null;
        this.f79a.c();
        this.f85b.c();
        this.c.c();
        this.f82a.c();
        this.f84a = false;
    }

    public final boolean k() {
        if (this.f80a != ConstraintWidget.a.MATCH_CONSTRAINT || this.f81a.f1384g == 0) {
            return true;
        }
        return false;
    }

    public final void m() {
        this.f84a = false;
        N8 n8 = this.f79a;
        n8.c();
        n8.f436c = false;
        N8 n82 = this.f85b;
        n82.c();
        n82.f436c = false;
        N8 n83 = this.c;
        n83.c();
        n83.f436c = false;
        this.f82a.f436c = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f81a.f1365b;
    }
}
