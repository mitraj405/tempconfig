package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ut  reason: default package */
/* compiled from: RepeaterContent */
public final class ut implements z9, dp, C0090Ee, C0335t2.a, C0381wh {
    public final Ej a;

    /* renamed from: a  reason: collision with other field name */
    public final C0093Gc f3328a;

    /* renamed from: a  reason: collision with other field name */
    public final HA f3329a;

    /* renamed from: a  reason: collision with other field name */
    public Y6 f3330a;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f3331a = new Matrix();

    /* renamed from: a  reason: collision with other field name */
    public final Path f3332a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final String f3333a;

    /* renamed from: a  reason: collision with other field name */
    public final C0359v2 f3334a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3335a;
    public final C0093Gc b;

    public ut(Ej ej, C0359v2 v2Var, tt ttVar) {
        this.a = ej;
        this.f3334a = v2Var;
        this.f3333a = ttVar.f3304a;
        this.f3335a = ttVar.f3305a;
        C0335t2<Float, Float> b2 = ttVar.a.b();
        this.f3328a = (C0093Gc) b2;
        v2Var.g(b2);
        b2.a(this);
        C0335t2<Float, Float> b3 = ttVar.b.b();
        this.b = (C0093Gc) b3;
        v2Var.g(b3);
        b3.a(this);
        P0 p0 = ttVar.f3303a;
        p0.getClass();
        HA ha = new HA(p0);
        this.f3329a = ha;
        ha.a(v2Var);
        ha.b(this);
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        this.f3330a.a(rectF, matrix, z);
    }

    public final Path b() {
        Path b2 = this.f3330a.b();
        Path path = this.f3332a;
        path.reset();
        float floatValue = ((Float) this.f3328a.f()).floatValue();
        float floatValue2 = ((Float) this.b.f()).floatValue();
        int i = (int) floatValue;
        while (true) {
            i--;
            if (i < 0) {
                return path;
            }
            Matrix matrix = this.f3331a;
            matrix.set(this.f3329a.e(((float) i) + floatValue2));
            path.addPath(b2, matrix);
        }
    }

    public final void c(Canvas canvas, Matrix matrix, int i) {
        float floatValue = ((Float) this.f3328a.f()).floatValue();
        float floatValue2 = ((Float) this.b.f()).floatValue();
        HA ha = this.f3329a;
        float floatValue3 = ha.f.f().floatValue() / 100.0f;
        float floatValue4 = ha.g.f().floatValue() / 100.0f;
        int i2 = (int) floatValue;
        while (true) {
            i2--;
            if (i2 >= 0) {
                Matrix matrix2 = this.f3331a;
                matrix2.set(matrix);
                float f = (float) i2;
                matrix2.preConcat(ha.e(f + floatValue2));
                PointF pointF = C0308ql.a;
                this.f3330a.c(canvas, matrix2, (int) ((((floatValue4 - floatValue3) * (f / floatValue)) + floatValue3) * ((float) i)));
            } else {
                return;
            }
        }
    }

    public final void d(List<V6> list, List<V6> list2) {
        this.f3330a.d(list, list2);
    }

    public final void e(C0344tk tkVar, Object obj) {
        if (!this.f3329a.c(tkVar, obj)) {
            if (obj == Kj.j) {
                this.f3328a.k(tkVar);
            } else if (obj == Kj.k) {
                this.b.k(tkVar);
            }
        }
    }

    public final void f() {
        this.a.invalidateSelf();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.util.ListIterator<defpackage.V6> r9) {
        /*
            r8 = this;
            Y6 r0 = r8.f3330a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r9.previous()
            if (r0 == r8) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0017:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r9.previous()
            V6 r0 = (defpackage.V6) r0
            r6.add(r0)
            r9.remove()
            goto L_0x0017
        L_0x002a:
            java.util.Collections.reverse(r6)
            Y6 r9 = new Y6
            Ej r2 = r8.a
            v2 r3 = r8.f3334a
            java.lang.String r4 = "Repeater"
            boolean r5 = r8.f3335a
            r7 = 0
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f3330a = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ut.g(java.util.ListIterator):void");
    }

    public final String getName() {
        return this.f3333a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0308ql.d(uhVar, i, arrayList, uhVar2, this);
    }
}
