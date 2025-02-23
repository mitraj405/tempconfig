package defpackage;

import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import java.util.Arrays;

/* renamed from: ei  reason: default package */
/* compiled from: LinearSystem */
public final class ei {
    public static Metrics a = null;
    public static boolean c = false;
    public static int h = 1000;

    /* renamed from: a  reason: collision with other field name */
    public int f2888a;

    /* renamed from: a  reason: collision with other field name */
    public L1 f2889a;

    /* renamed from: a  reason: collision with other field name */
    public final rq f2890a;

    /* renamed from: a  reason: collision with other field name */
    public final y3 f2891a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2892a;

    /* renamed from: a  reason: collision with other field name */
    public L1[] f2893a;

    /* renamed from: a  reason: collision with other field name */
    public C0415yx[] f2894a;

    /* renamed from: a  reason: collision with other field name */
    public boolean[] f2895a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2896b;

    /* renamed from: c  reason: collision with other field name */
    public int f2897c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* renamed from: ei$a */
    /* compiled from: LinearSystem */
    public interface a {
        C0415yx a(boolean[] zArr);
    }

    public ei() {
        this.f2892a = false;
        this.f2888a = 0;
        this.b = 32;
        this.f2897c = 32;
        this.f2893a = null;
        this.f2896b = false;
        this.f2895a = new boolean[32];
        this.d = 1;
        this.e = 0;
        this.f = 32;
        this.f2894a = new C0415yx[h];
        this.g = 0;
        this.f2893a = new L1[32];
        for (int i = 0; i < this.e; i++) {
            L1 l1 = this.f2893a[i];
            if (l1 != null) {
                this.f2891a.a.a(l1);
            }
            this.f2893a[i] = null;
        }
        y3 y3Var = new y3();
        this.f2891a = y3Var;
        this.f2890a = new rq(y3Var);
        this.f2889a = new L1(y3Var);
    }

    public static int n(ConstraintAnchor constraintAnchor) {
        C0415yx yxVar = constraintAnchor.f1342a;
        if (yxVar != null) {
            return (int) (yxVar.a + 0.5f);
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: yx} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C0415yx a(int r6) {
        /*
            r5 = this;
            y3 r0 = r5.f2891a
            Qp r0 = r0.b
            int r1 = r0.b
            r2 = 0
            if (r1 <= 0) goto L_0x0016
            int r1 = r1 + -1
            java.lang.Object r3 = r0.f491a
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r4 = r3[r1]
            r3[r1] = r2
            r0.b = r1
            r2 = r4
        L_0x0016:
            yx r2 = (defpackage.C0415yx) r2
            if (r2 != 0) goto L_0x0022
            yx r2 = new yx
            r2.<init>(r6)
            r2.f = r6
            goto L_0x0027
        L_0x0022:
            r2.h()
            r2.f = r6
        L_0x0027:
            int r6 = r5.g
            int r0 = h
            if (r6 < r0) goto L_0x003b
            int r0 = r0 * 2
            h = r0
            yx[] r6 = r5.f2894a
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r0)
            yx[] r6 = (defpackage.C0415yx[]) r6
            r5.f2894a = r6
        L_0x003b:
            yx[] r6 = r5.f2894a
            int r0 = r5.g
            int r1 = r0 + 1
            r5.g = r1
            r6[r0] = r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ei.a(int):yx");
    }

    public final void b(C0415yx yxVar, C0415yx yxVar2, int i, float f2, C0415yx yxVar3, C0415yx yxVar4, int i2, int i3) {
        L1 l = l();
        if (yxVar2 == yxVar3) {
            l.f377a.j(yxVar, 1.0f);
            l.f377a.j(yxVar4, 1.0f);
            l.f377a.j(yxVar2, -2.0f);
        } else if (f2 == 0.5f) {
            l.f377a.j(yxVar, 1.0f);
            l.f377a.j(yxVar2, -1.0f);
            l.f377a.j(yxVar3, -1.0f);
            l.f377a.j(yxVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                l.a = (float) ((-i) + i2);
            }
        } else if (f2 <= 0.0f) {
            l.f377a.j(yxVar, -1.0f);
            l.f377a.j(yxVar2, 1.0f);
            l.a = (float) i;
        } else if (f2 >= 1.0f) {
            l.f377a.j(yxVar4, -1.0f);
            l.f377a.j(yxVar3, 1.0f);
            l.a = (float) (-i2);
        } else {
            float f3 = 1.0f - f2;
            l.f377a.j(yxVar, f3 * 1.0f);
            l.f377a.j(yxVar2, f3 * -1.0f);
            l.f377a.j(yxVar3, -1.0f * f2);
            l.f377a.j(yxVar4, 1.0f * f2);
            if (i > 0 || i2 > 0) {
                l.a = (((float) i2) * f2) + (((float) (-i)) * f3);
            }
        }
        if (i3 != 8) {
            l.b(this, i3);
        }
        c(l);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bb, code lost:
        if (r4.h <= 1) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
        if (r4.h <= 1) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e2, code lost:
        if (r4.h <= 1) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00eb, code lost:
        if (r4.h <= 1) goto L_0x00fb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(defpackage.L1 r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            androidx.constraintlayout.core.Metrics r2 = a
            int r2 = r0.e
            r3 = 1
            int r2 = r2 + r3
            int r4 = r0.f
            if (r2 >= r4) goto L_0x0015
            int r2 = r0.d
            int r2 = r2 + r3
            int r4 = r0.f2897c
            if (r2 < r4) goto L_0x0018
        L_0x0015:
            r16.o()
        L_0x0018:
            boolean r2 = r1.f380a
            if (r2 != 0) goto L_0x01b2
            L1[] r2 = r0.f2893a
            int r2 = r2.length
            r5 = -1
            if (r2 != 0) goto L_0x0023
            goto L_0x007f
        L_0x0023:
            r2 = 0
        L_0x0024:
            if (r2 != 0) goto L_0x006f
            L1$a r6 = r1.f377a
            int r6 = r6.g()
            r7 = 0
        L_0x002d:
            java.util.ArrayList<yx> r8 = r1.f378a
            if (r7 >= r6) goto L_0x0046
            L1$a r9 = r1.f377a
            yx r9 = r9.a(r7)
            int r10 = r9.d
            if (r10 != r5) goto L_0x0040
            boolean r10 = r9.b
            if (r10 != 0) goto L_0x0040
            goto L_0x0043
        L_0x0040:
            r8.add(r9)
        L_0x0043:
            int r7 = r7 + 1
            goto L_0x002d
        L_0x0046:
            int r6 = r8.size()
            if (r6 <= 0) goto L_0x006d
            r7 = 0
        L_0x004d:
            if (r7 >= r6) goto L_0x0069
            java.lang.Object r9 = r8.get(r7)
            yx r9 = (defpackage.C0415yx) r9
            boolean r10 = r9.b
            if (r10 == 0) goto L_0x005d
            r1.h(r0, r9, r3)
            goto L_0x0066
        L_0x005d:
            L1[] r10 = r0.f2893a
            int r9 = r9.d
            r9 = r10[r9]
            r1.i(r0, r9, r3)
        L_0x0066:
            int r7 = r7 + 1
            goto L_0x004d
        L_0x0069:
            r8.clear()
            goto L_0x0024
        L_0x006d:
            r2 = r3
            goto L_0x0024
        L_0x006f:
            yx r2 = r1.f379a
            if (r2 == 0) goto L_0x007f
            L1$a r2 = r1.f377a
            int r2 = r2.g()
            if (r2 != 0) goto L_0x007f
            r1.f380a = r3
            r0.f2892a = r3
        L_0x007f:
            boolean r2 = r17.e()
            if (r2 == 0) goto L_0x0086
            return
        L_0x0086:
            float r2 = r1.a
            r6 = 0
            int r7 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x0097
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r2 * r7
            r1.a = r2
            L1$a r2 = r1.f377a
            r2.h()
        L_0x0097:
            L1$a r2 = r1.f377a
            int r2 = r2.g()
            r7 = 0
            r11 = r6
            r13 = r11
            r9 = r7
            r10 = r9
            r8 = 0
            r12 = 0
            r14 = 0
        L_0x00a5:
            if (r8 >= r2) goto L_0x0102
            L1$a r15 = r1.f377a
            float r15 = r15.k(r8)
            L1$a r4 = r1.f377a
            yx r4 = r4.a(r8)
            int r5 = r4.f
            if (r5 != r3) goto L_0x00d8
            if (r9 != 0) goto L_0x00be
            int r5 = r4.h
            if (r5 > r3) goto L_0x00c7
            goto L_0x00d4
        L_0x00be:
            int r5 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c9
            int r5 = r4.h
            if (r5 > r3) goto L_0x00c7
            goto L_0x00d4
        L_0x00c7:
            r12 = 0
            goto L_0x00d5
        L_0x00c9:
            if (r12 != 0) goto L_0x00fe
            int r5 = r4.h
            if (r5 > r3) goto L_0x00d1
            r5 = r3
            goto L_0x00d2
        L_0x00d1:
            r5 = 0
        L_0x00d2:
            if (r5 == 0) goto L_0x00fe
        L_0x00d4:
            r12 = r3
        L_0x00d5:
            r9 = r4
            r11 = r15
            goto L_0x00fe
        L_0x00d8:
            if (r9 != 0) goto L_0x00fe
            int r5 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x00fe
            if (r10 != 0) goto L_0x00e5
            int r5 = r4.h
            if (r5 > r3) goto L_0x00ee
            goto L_0x00fb
        L_0x00e5:
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x00f0
            int r5 = r4.h
            if (r5 > r3) goto L_0x00ee
            goto L_0x00fb
        L_0x00ee:
            r14 = 0
            goto L_0x00fc
        L_0x00f0:
            if (r14 != 0) goto L_0x00fe
            int r5 = r4.h
            if (r5 > r3) goto L_0x00f8
            r5 = r3
            goto L_0x00f9
        L_0x00f8:
            r5 = 0
        L_0x00f9:
            if (r5 == 0) goto L_0x00fe
        L_0x00fb:
            r14 = r3
        L_0x00fc:
            r10 = r4
            r13 = r15
        L_0x00fe:
            int r8 = r8 + 1
            r5 = -1
            goto L_0x00a5
        L_0x0102:
            if (r9 == 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r9 = r10
        L_0x0106:
            if (r9 != 0) goto L_0x010a
            r2 = r3
            goto L_0x010e
        L_0x010a:
            r1.g(r9)
            r2 = 0
        L_0x010e:
            L1$a r4 = r1.f377a
            int r4 = r4.g()
            if (r4 != 0) goto L_0x0118
            r1.f380a = r3
        L_0x0118:
            if (r2 == 0) goto L_0x019c
            int r2 = r0.d
            int r2 = r2 + r3
            int r4 = r0.f2897c
            if (r2 < r4) goto L_0x0124
            r16.o()
        L_0x0124:
            r2 = 3
            yx r2 = r0.a(r2)
            int r4 = r0.f2888a
            int r4 = r4 + r3
            r0.f2888a = r4
            int r5 = r0.d
            int r5 = r5 + r3
            r0.d = r5
            r2.c = r4
            y3 r5 = r0.f2891a
            yx[] r8 = r5.f3424a
            r8[r4] = r2
            r1.f379a = r2
            int r4 = r0.e
            r16.h(r17)
            int r8 = r0.e
            int r4 = r4 + r3
            if (r8 != r4) goto L_0x019c
            L1 r4 = r0.f2889a
            r4.getClass()
            r4.f379a = r7
            L1$a r8 = r4.f377a
            r8.clear()
            r8 = 0
        L_0x0154:
            L1$a r9 = r1.f377a
            int r9 = r9.g()
            if (r8 >= r9) goto L_0x0170
            L1$a r9 = r1.f377a
            yx r9 = r9.a(r8)
            L1$a r10 = r1.f377a
            float r10 = r10.k(r8)
            L1$a r11 = r4.f377a
            r11.d(r9, r10, r3)
            int r8 = r8 + 1
            goto L_0x0154
        L_0x0170:
            L1 r4 = r0.f2889a
            r0.r(r4)
            int r4 = r2.d
            r8 = -1
            if (r4 != r8) goto L_0x019a
            yx r4 = r1.f379a
            if (r4 != r2) goto L_0x0187
            yx r2 = r1.f(r7, r2)
            if (r2 == 0) goto L_0x0187
            r1.g(r2)
        L_0x0187:
            boolean r2 = r1.f380a
            if (r2 != 0) goto L_0x0190
            yx r2 = r1.f379a
            r2.j(r0, r1)
        L_0x0190:
            Qp r2 = r5.a
            r2.a(r1)
            int r2 = r0.e
            int r2 = r2 - r3
            r0.e = r2
        L_0x019a:
            r2 = r3
            goto L_0x019d
        L_0x019c:
            r2 = 0
        L_0x019d:
            yx r4 = r1.f379a
            if (r4 == 0) goto L_0x01ac
            int r4 = r4.f
            if (r4 == r3) goto L_0x01ad
            float r4 = r1.a
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x01ac
            goto L_0x01ad
        L_0x01ac:
            r3 = 0
        L_0x01ad:
            if (r3 != 0) goto L_0x01b0
            return
        L_0x01b0:
            r4 = r2
            goto L_0x01b3
        L_0x01b2:
            r4 = 0
        L_0x01b3:
            if (r4 != 0) goto L_0x01b8
            r16.h(r17)
        L_0x01b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ei.c(L1):void");
    }

    public final void d(C0415yx yxVar, int i) {
        int i2 = yxVar.d;
        if (i2 == -1) {
            yxVar.i(this, (float) i);
            for (int i3 = 0; i3 < this.f2888a + 1; i3++) {
                C0415yx yxVar2 = this.f2891a.f3424a[i3];
            }
        } else if (i2 != -1) {
            L1 l1 = this.f2893a[i2];
            if (l1.f380a) {
                l1.a = (float) i;
            } else if (l1.f377a.g() == 0) {
                l1.f380a = true;
                l1.a = (float) i;
            } else {
                L1 l = l();
                if (i < 0) {
                    l.a = (float) (i * -1);
                    l.f377a.j(yxVar, 1.0f);
                } else {
                    l.a = (float) i;
                    l.f377a.j(yxVar, -1.0f);
                }
                c(l);
            }
        } else {
            L1 l2 = l();
            l2.f379a = yxVar;
            float f2 = (float) i;
            yxVar.a = f2;
            l2.a = f2;
            l2.f380a = true;
            c(l2);
        }
    }

    public final void e(C0415yx yxVar, C0415yx yxVar2, int i, int i2) {
        if (i2 == 8 && yxVar2.b && yxVar.d == -1) {
            yxVar.i(this, yxVar2.a + ((float) i));
            return;
        }
        L1 l = l();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            l.a = (float) i;
        }
        if (!z) {
            l.f377a.j(yxVar, -1.0f);
            l.f377a.j(yxVar2, 1.0f);
        } else {
            l.f377a.j(yxVar, 1.0f);
            l.f377a.j(yxVar2, -1.0f);
        }
        if (i2 != 8) {
            l.b(this, i2);
        }
        c(l);
    }

    public final void f(C0415yx yxVar, C0415yx yxVar2, int i, int i2) {
        L1 l = l();
        C0415yx m = m();
        m.e = 0;
        l.c(yxVar, yxVar2, m, i);
        if (i2 != 8) {
            l.f377a.j(j(i2), (float) ((int) (l.f377a.e(m) * -1.0f)));
        }
        c(l);
    }

    public final void g(C0415yx yxVar, C0415yx yxVar2, int i, int i2) {
        L1 l = l();
        C0415yx m = m();
        m.e = 0;
        l.d(yxVar, yxVar2, m, i);
        if (i2 != 8) {
            l.f377a.j(j(i2), (float) ((int) (l.f377a.e(m) * -1.0f)));
        }
        c(l);
    }

    public final void h(L1 l1) {
        int i;
        if (l1.f380a) {
            l1.f379a.i(this, l1.a);
        } else {
            L1[] l1Arr = this.f2893a;
            int i2 = this.e;
            l1Arr[i2] = l1;
            C0415yx yxVar = l1.f379a;
            yxVar.d = i2;
            this.e = i2 + 1;
            yxVar.j(this, l1);
        }
        if (this.f2892a) {
            int i3 = 0;
            while (i3 < this.e) {
                if (this.f2893a[i3] == null) {
                    System.out.println("WTF");
                }
                L1 l12 = this.f2893a[i3];
                if (l12 != null && l12.f380a) {
                    l12.f379a.i(this, l12.a);
                    this.f2891a.a.a(l12);
                    this.f2893a[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.e;
                        if (i4 >= i) {
                            break;
                        }
                        L1[] l1Arr2 = this.f2893a;
                        int i6 = i4 - 1;
                        L1 l13 = l1Arr2[i4];
                        l1Arr2[i6] = l13;
                        C0415yx yxVar2 = l13.f379a;
                        if (yxVar2.d == i4) {
                            yxVar2.d = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.f2893a[i5] = null;
                    }
                    this.e = i - 1;
                    i3--;
                }
                i3++;
            }
            this.f2892a = false;
        }
    }

    public final void i() {
        for (int i = 0; i < this.e; i++) {
            L1 l1 = this.f2893a[i];
            l1.f379a.a = l1.a;
        }
    }

    public final C0415yx j(int i) {
        if (this.d + 1 >= this.f2897c) {
            o();
        }
        C0415yx a2 = a(4);
        int i2 = this.f2888a + 1;
        this.f2888a = i2;
        this.d++;
        a2.c = i2;
        a2.e = i;
        this.f2891a.f3424a[i2] = a2;
        rq rqVar = this.f2890a;
        rqVar.f3227a.f3229a = a2;
        float[] fArr = a2.f3444b;
        Arrays.fill(fArr, 0.0f);
        fArr[a2.e] = 1.0f;
        rqVar.j(a2);
        return a2;
    }

    public final C0415yx k(Object obj) {
        C0415yx yxVar = null;
        if (obj == null) {
            return null;
        }
        if (this.d + 1 >= this.f2897c) {
            o();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            yxVar = constraintAnchor.f1342a;
            if (yxVar == null) {
                constraintAnchor.k();
                yxVar = constraintAnchor.f1342a;
            }
            int i = yxVar.c;
            y3 y3Var = this.f2891a;
            if (i == -1 || i > this.f2888a || y3Var.f3424a[i] == null) {
                if (i != -1) {
                    yxVar.h();
                }
                int i2 = this.f2888a + 1;
                this.f2888a = i2;
                this.d++;
                yxVar.c = i2;
                yxVar.f = 1;
                y3Var.f3424a[i2] = yxVar;
            }
        }
        return yxVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: L1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.L1 l() {
        /*
            r6 = this;
            y3 r0 = r6.f2891a
            Qp r1 = r0.a
            int r2 = r1.b
            r3 = 0
            if (r2 <= 0) goto L_0x0016
            int r2 = r2 + -1
            java.lang.Object r4 = r1.f491a
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            r5 = r4[r2]
            r4[r2] = r3
            r1.b = r2
            goto L_0x0017
        L_0x0016:
            r5 = r3
        L_0x0017:
            L1 r5 = (defpackage.L1) r5
            if (r5 != 0) goto L_0x0021
            L1 r5 = new L1
            r5.<init>(r0)
            goto L_0x002e
        L_0x0021:
            r5.f379a = r3
            L1$a r0 = r5.f377a
            r0.clear()
            r0 = 0
            r5.a = r0
            r0 = 0
            r5.f380a = r0
        L_0x002e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ei.l():L1");
    }

    public final C0415yx m() {
        if (this.d + 1 >= this.f2897c) {
            o();
        }
        C0415yx a2 = a(3);
        int i = this.f2888a + 1;
        this.f2888a = i;
        this.d++;
        a2.c = i;
        this.f2891a.f3424a[i] = a2;
        return a2;
    }

    public final void o() {
        int i = this.b * 2;
        this.b = i;
        this.f2893a = (L1[]) Arrays.copyOf(this.f2893a, i);
        y3 y3Var = this.f2891a;
        y3Var.f3424a = (C0415yx[]) Arrays.copyOf(y3Var.f3424a, this.b);
        int i2 = this.b;
        this.f2895a = new boolean[i2];
        this.f2897c = i2;
        this.f = i2;
        Metrics metrics = a;
        if (metrics != null) {
            metrics.b = Math.max(metrics.b, (long) i2);
            long j = a.b;
        }
    }

    public final void p() throws Exception {
        rq rqVar = this.f2890a;
        if (rqVar.e()) {
            i();
        } else if (this.f2896b) {
            Metrics metrics = a;
            if (metrics != null) {
                metrics.c++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.e) {
                    z = true;
                    break;
                } else if (!this.f2893a[i].f380a) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                q(rqVar);
            } else {
                i();
            }
        } else {
            q(rqVar);
        }
    }

    public final void q(rq rqVar) throws Exception {
        float f2;
        int i;
        boolean z;
        Metrics metrics = a;
        if (metrics != null) {
            metrics.f = Math.max(metrics.f, (long) this.d);
            Metrics metrics2 = a;
            metrics2.g = Math.max(metrics2.g, (long) this.e);
        }
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            i = 1;
            if (i2 >= this.e) {
                z = false;
                break;
            }
            L1 l1 = this.f2893a[i2];
            if (l1.f379a.f != 1 && l1.a < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                i3 += i;
                float f3 = Float.MAX_VALUE;
                int i4 = -1;
                int i5 = -1;
                int i6 = 0;
                int i7 = 0;
                while (i6 < this.e) {
                    L1 l12 = this.f2893a[i6];
                    if (l12.f379a.f != i && !l12.f380a && l12.a < f2) {
                        int g2 = l12.f377a.g();
                        int i8 = 0;
                        while (i8 < g2) {
                            C0415yx a2 = l12.f377a.a(i8);
                            float e2 = l12.f377a.e(a2);
                            if (e2 > f2) {
                                for (int i9 = 0; i9 < 9; i9++) {
                                    float f4 = a2.f3442a[i9] / e2;
                                    if ((f4 < f3 && i9 == i7) || i9 > i7) {
                                        i5 = a2.c;
                                        i7 = i9;
                                        f3 = f4;
                                        i4 = i6;
                                    }
                                }
                            }
                            i8++;
                            f2 = 0.0f;
                        }
                    }
                    i6++;
                    f2 = 0.0f;
                    i = 1;
                }
                if (i4 != -1) {
                    L1 l13 = this.f2893a[i4];
                    l13.f379a.d = -1;
                    l13.g(this.f2891a.f3424a[i5]);
                    C0415yx yxVar = l13.f379a;
                    yxVar.d = i4;
                    yxVar.j(this, l13);
                } else {
                    z2 = true;
                }
                if (i3 > this.d / 2) {
                    z2 = true;
                }
                f2 = 0.0f;
                i = 1;
            }
        }
        r(rqVar);
        i();
    }

    public final void r(L1 l1) {
        for (int i = 0; i < this.d; i++) {
            this.f2895a[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 < this.d * 2) {
                C0415yx yxVar = l1.f379a;
                if (yxVar != null) {
                    this.f2895a[yxVar.c] = true;
                }
                C0415yx a2 = l1.a(this.f2895a);
                if (a2 != null) {
                    boolean[] zArr = this.f2895a;
                    int i3 = a2.c;
                    if (!zArr[i3]) {
                        zArr[i3] = true;
                    } else {
                        return;
                    }
                }
                if (a2 != null) {
                    float f2 = Float.MAX_VALUE;
                    int i4 = -1;
                    for (int i5 = 0; i5 < this.e; i5++) {
                        L1 l12 = this.f2893a[i5];
                        if (l12.f379a.f != 1 && !l12.f380a && l12.f377a.i(a2)) {
                            float e2 = l12.f377a.e(a2);
                            if (e2 < 0.0f) {
                                float f3 = (-l12.a) / e2;
                                if (f3 < f2) {
                                    i4 = i5;
                                    f2 = f3;
                                }
                            }
                        }
                    }
                    if (i4 > -1) {
                        L1 l13 = this.f2893a[i4];
                        l13.f379a.d = -1;
                        l13.g(a2);
                        C0415yx yxVar2 = l13.f379a;
                        yxVar2.d = i4;
                        yxVar2.j(this, l13);
                    }
                } else {
                    z = true;
                }
            } else {
                return;
            }
        }
    }

    public final void s() {
        y3 y3Var;
        int i = 0;
        while (true) {
            y3Var = this.f2891a;
            C0415yx[] yxVarArr = y3Var.f3424a;
            if (i >= yxVarArr.length) {
                break;
            }
            C0415yx yxVar = yxVarArr[i];
            if (yxVar != null) {
                yxVar.h();
            }
            i++;
        }
        C0415yx[] yxVarArr2 = this.f2894a;
        int i2 = this.g;
        Qp qp = y3Var.b;
        qp.getClass();
        if (i2 > yxVarArr2.length) {
            i2 = yxVarArr2.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            C0415yx yxVar2 = yxVarArr2[i3];
            int i4 = qp.b;
            Object[] objArr = (Object[]) qp.f491a;
            if (i4 < objArr.length) {
                objArr[i4] = yxVar2;
                qp.b = i4 + 1;
            }
        }
        this.g = 0;
        Arrays.fill(y3Var.f3424a, (Object) null);
        this.f2888a = 0;
        rq rqVar = this.f2890a;
        rqVar.a = 0;
        rqVar.a = 0.0f;
        this.d = 1;
        for (int i5 = 0; i5 < this.e; i5++) {
            L1 l1 = this.f2893a[i5];
        }
        for (int i6 = 0; i6 < this.e; i6++) {
            L1 l12 = this.f2893a[i6];
            if (l12 != null) {
                y3Var.a.a(l12);
            }
            this.f2893a[i6] = null;
        }
        this.e = 0;
        this.f2889a = new L1(y3Var);
    }
}
