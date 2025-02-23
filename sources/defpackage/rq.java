package defpackage;

import defpackage.L1;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: rq  reason: default package */
/* compiled from: PriorityGoalRow */
public final class rq extends L1 {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final b f3227a = new b();

    /* renamed from: a  reason: collision with other field name */
    public C0415yx[] f3228a = new C0415yx[128];
    public C0415yx[] b = new C0415yx[128];

    /* renamed from: rq$a */
    /* compiled from: PriorityGoalRow */
    public class a implements Comparator<C0415yx> {
        public final int compare(Object obj, Object obj2) {
            return ((C0415yx) obj).c - ((C0415yx) obj2).c;
        }
    }

    /* renamed from: rq$b */
    /* compiled from: PriorityGoalRow */
    public class b {

        /* renamed from: a  reason: collision with other field name */
        public C0415yx f3229a;

        public b() {
        }

        public final String toString() {
            String str = "[ ";
            if (this.f3229a != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder J = xx.J(str);
                    J.append(this.f3229a.f3444b[i]);
                    J.append(" ");
                    str = J.toString();
                }
            }
            StringBuilder n = lf.n(str, "] ");
            n.append(this.f3229a);
            return n.toString();
        }
    }

    public rq(y3 y3Var) {
        super(y3Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        if (r9 < r8) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C0415yx a(boolean[] r12) {
        /*
            r11 = this;
            r0 = -1
            r1 = 0
            r3 = r0
            r2 = r1
        L_0x0004:
            int r4 = r11.a
            if (r2 >= r4) goto L_0x0057
            yx[] r4 = r11.f3228a
            r5 = r4[r2]
            int r6 = r5.c
            boolean r6 = r12[r6]
            if (r6 == 0) goto L_0x0013
            goto L_0x0054
        L_0x0013:
            rq$b r6 = r11.f3227a
            r6.f3229a = r5
            r5 = 1
            r7 = 8
            if (r3 != r0) goto L_0x0036
        L_0x001c:
            if (r7 < 0) goto L_0x0032
            yx r4 = r6.f3229a
            float[] r4 = r4.f3444b
            r4 = r4[r7]
            r8 = 0
            int r9 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r9 <= 0) goto L_0x002a
            goto L_0x0032
        L_0x002a:
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x002f
            goto L_0x0033
        L_0x002f:
            int r7 = r7 + -1
            goto L_0x001c
        L_0x0032:
            r5 = r1
        L_0x0033:
            if (r5 == 0) goto L_0x0054
            goto L_0x0053
        L_0x0036:
            r4 = r4[r3]
        L_0x0038:
            if (r7 < 0) goto L_0x0050
            float[] r8 = r4.f3444b
            r8 = r8[r7]
            yx r9 = r6.f3229a
            float[] r9 = r9.f3444b
            r9 = r9[r7]
            int r10 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x004b
            int r7 = r7 + -1
            goto L_0x0038
        L_0x004b:
            int r4 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r5 = r1
        L_0x0051:
            if (r5 == 0) goto L_0x0054
        L_0x0053:
            r3 = r2
        L_0x0054:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0057:
            if (r3 != r0) goto L_0x005b
            r12 = 0
            return r12
        L_0x005b:
            yx[] r12 = r11.f3228a
            r12 = r12[r3]
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rq.a(boolean[]):yx");
    }

    public final boolean e() {
        if (this.a == 0) {
            return true;
        }
        return false;
    }

    public final void i(ei eiVar, L1 l1, boolean z) {
        boolean z2;
        L1 l12 = l1;
        C0415yx yxVar = l12.f379a;
        if (yxVar != null) {
            L1.a aVar = l12.f377a;
            int g = aVar.g();
            for (int i = 0; i < g; i++) {
                C0415yx a2 = aVar.a(i);
                float k = aVar.k(i);
                b bVar = this.f3227a;
                bVar.f3229a = a2;
                boolean z3 = a2.f3441a;
                float[] fArr = yxVar.f3444b;
                if (z3) {
                    boolean z4 = true;
                    for (int i2 = 0; i2 < 9; i2++) {
                        float[] fArr2 = bVar.f3229a.f3444b;
                        float f = (fArr[i2] * k) + fArr2[i2];
                        fArr2[i2] = f;
                        if (Math.abs(f) < 1.0E-4f) {
                            bVar.f3229a.f3444b[i2] = 0.0f;
                        } else {
                            z4 = false;
                        }
                    }
                    if (z4) {
                        rq.this.k(bVar.f3229a);
                    }
                    z2 = false;
                } else {
                    for (int i3 = 0; i3 < 9; i3++) {
                        float f2 = fArr[i3];
                        if (f2 != 0.0f) {
                            float f3 = f2 * k;
                            if (Math.abs(f3) < 1.0E-4f) {
                                f3 = 0.0f;
                            }
                            bVar.f3229a.f3444b[i3] = f3;
                        } else {
                            bVar.f3229a.f3444b[i3] = 0.0f;
                        }
                    }
                    z2 = true;
                }
                if (z2) {
                    j(a2);
                }
                this.a = (l12.a * k) + this.a;
            }
            k(yxVar);
        }
    }

    public final void j(C0415yx yxVar) {
        int i;
        int i2 = this.a + 1;
        C0415yx[] yxVarArr = this.f3228a;
        if (i2 > yxVarArr.length) {
            C0415yx[] yxVarArr2 = (C0415yx[]) Arrays.copyOf(yxVarArr, yxVarArr.length * 2);
            this.f3228a = yxVarArr2;
            this.b = (C0415yx[]) Arrays.copyOf(yxVarArr2, yxVarArr2.length * 2);
        }
        C0415yx[] yxVarArr3 = this.f3228a;
        int i3 = this.a;
        yxVarArr3[i3] = yxVar;
        int i4 = i3 + 1;
        this.a = i4;
        if (i4 > 1 && yxVarArr3[i4 - 1].c > yxVar.c) {
            int i5 = 0;
            while (true) {
                i = this.a;
                if (i5 >= i) {
                    break;
                }
                this.b[i5] = this.f3228a[i5];
                i5++;
            }
            Arrays.sort(this.b, 0, i, new a());
            for (int i6 = 0; i6 < this.a; i6++) {
                this.f3228a[i6] = this.b[i6];
            }
        }
        yxVar.f3441a = true;
        yxVar.a(this);
    }

    public final void k(C0415yx yxVar) {
        int i = 0;
        while (i < this.a) {
            if (this.f3228a[i] == yxVar) {
                while (true) {
                    int i2 = this.a;
                    if (i < i2 - 1) {
                        C0415yx[] yxVarArr = this.f3228a;
                        int i3 = i + 1;
                        yxVarArr[i] = yxVarArr[i3];
                        i = i3;
                    } else {
                        this.a = i2 - 1;
                        yxVar.f3441a = false;
                        return;
                    }
                }
            } else {
                i++;
            }
        }
    }

    public final String toString() {
        String str = " goal -> (" + this.a + ") : ";
        for (int i = 0; i < this.a; i++) {
            C0415yx yxVar = this.f3228a[i];
            b bVar = this.f3227a;
            bVar.f3229a = yxVar;
            str = str + bVar + " ";
        }
        return str;
    }
}
