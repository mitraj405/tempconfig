package defpackage;

import defpackage.ei;
import java.util.ArrayList;

/* renamed from: L1  reason: default package */
/* compiled from: ArrayRow */
public class L1 implements ei.a {
    public float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public a f377a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<C0415yx> f378a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public C0415yx f379a = null;

    /* renamed from: a  reason: collision with other field name */
    public boolean f380a = false;

    /* renamed from: L1$a */
    /* compiled from: ArrayRow */
    public interface a {
        C0415yx a(int i);

        void b(float f);

        float c(L1 l1, boolean z);

        void clear();

        void d(C0415yx yxVar, float f, boolean z);

        float e(C0415yx yxVar);

        float f(C0415yx yxVar, boolean z);

        int g();

        void h();

        boolean i(C0415yx yxVar);

        void j(C0415yx yxVar, float f);

        float k(int i);
    }

    public L1() {
    }

    public C0415yx a(boolean[] zArr) {
        return f(zArr, (C0415yx) null);
    }

    public final void b(ei eiVar, int i) {
        this.f377a.j(eiVar.j(i), 1.0f);
        this.f377a.j(eiVar.j(i), -1.0f);
    }

    public final void c(C0415yx yxVar, C0415yx yxVar2, C0415yx yxVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.a = (float) i;
        }
        if (!z) {
            this.f377a.j(yxVar, -1.0f);
            this.f377a.j(yxVar2, 1.0f);
            this.f377a.j(yxVar3, 1.0f);
            return;
        }
        this.f377a.j(yxVar, 1.0f);
        this.f377a.j(yxVar2, -1.0f);
        this.f377a.j(yxVar3, -1.0f);
    }

    public final void d(C0415yx yxVar, C0415yx yxVar2, C0415yx yxVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.a = (float) i;
        }
        if (!z) {
            this.f377a.j(yxVar, -1.0f);
            this.f377a.j(yxVar2, 1.0f);
            this.f377a.j(yxVar3, -1.0f);
            return;
        }
        this.f377a.j(yxVar, 1.0f);
        this.f377a.j(yxVar2, -1.0f);
        this.f377a.j(yxVar3, 1.0f);
    }

    public boolean e() {
        if (this.f379a == null && this.a == 0.0f && this.f377a.g() == 0) {
            return true;
        }
        return false;
    }

    public final C0415yx f(boolean[] zArr, C0415yx yxVar) {
        int i;
        int g = this.f377a.g();
        C0415yx yxVar2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < g; i2++) {
            float k = this.f377a.k(i2);
            if (k < 0.0f) {
                C0415yx a2 = this.f377a.a(i2);
                if ((zArr == null || !zArr[a2.c]) && a2 != yxVar && (((i = a2.f) == 3 || i == 4) && k < f)) {
                    f = k;
                    yxVar2 = a2;
                }
            }
        }
        return yxVar2;
    }

    public final void g(C0415yx yxVar) {
        C0415yx yxVar2 = this.f379a;
        if (yxVar2 != null) {
            this.f377a.j(yxVar2, -1.0f);
            this.f379a.d = -1;
            this.f379a = null;
        }
        float f = this.f377a.f(yxVar, true) * -1.0f;
        this.f379a = yxVar;
        if (f != 1.0f) {
            this.a /= f;
            this.f377a.b(f);
        }
    }

    public final void h(ei eiVar, C0415yx yxVar, boolean z) {
        if (yxVar != null && yxVar.b) {
            float e = this.f377a.e(yxVar);
            this.a = (yxVar.a * e) + this.a;
            this.f377a.f(yxVar, z);
            if (z) {
                yxVar.f(this);
            }
            if (this.f377a.g() == 0) {
                this.f380a = true;
                eiVar.f2892a = true;
            }
        }
    }

    public void i(ei eiVar, L1 l1, boolean z) {
        float c = this.f377a.c(l1, z);
        this.a = (l1.a * c) + this.a;
        if (z) {
            l1.f379a.f(this);
        }
        if (this.f379a != null && this.f377a.g() == 0) {
            this.f380a = true;
            eiVar.f2892a = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r9 = this;
            yx r0 = r9.f379a
            if (r0 != 0) goto L_0x0007
            java.lang.String r0 = "0"
            goto L_0x0017
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            yx r1 = r9.f379a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0017:
            java.lang.String r1 = " = "
            java.lang.String r0 = defpackage.C1058d.z(r0, r1)
            float r1 = r9.a
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0035
            java.lang.StringBuilder r0 = defpackage.xx.J(r0)
            float r1 = r9.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r3
            goto L_0x0036
        L_0x0035:
            r1 = r4
        L_0x0036:
            L1$a r5 = r9.f377a
            int r5 = r5.g()
        L_0x003c:
            if (r4 >= r5) goto L_0x009b
            L1$a r6 = r9.f377a
            yx r6 = r6.a(r4)
            if (r6 != 0) goto L_0x0047
            goto L_0x0098
        L_0x0047:
            L1$a r7 = r9.f377a
            float r7 = r7.k(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0052
            goto L_0x0098
        L_0x0052:
            java.lang.String r6 = r6.toString()
            if (r1 != 0) goto L_0x0063
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0075
            java.lang.String r1 = "- "
            java.lang.String r0 = defpackage.C1058d.z(r0, r1)
            goto L_0x0072
        L_0x0063:
            if (r8 <= 0) goto L_0x006c
            java.lang.String r1 = " + "
            java.lang.String r0 = defpackage.C1058d.z(r0, r1)
            goto L_0x0075
        L_0x006c:
            java.lang.String r1 = " - "
            java.lang.String r0 = defpackage.C1058d.z(r0, r1)
        L_0x0072:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r7 = r7 * r1
        L_0x0075:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0080
            java.lang.String r0 = defpackage.C1058d.z(r0, r6)
            goto L_0x0097
        L_0x0080:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x0097:
            r1 = r3
        L_0x0098:
            int r4 = r4 + 1
            goto L_0x003c
        L_0x009b:
            if (r1 != 0) goto L_0x00a3
            java.lang.String r1 = "0.0"
            java.lang.String r0 = defpackage.C1058d.z(r0, r1)
        L_0x00a3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.L1.toString():java.lang.String");
    }

    public L1(y3 y3Var) {
        this.f377a = new K1(this, y3Var);
    }
}
