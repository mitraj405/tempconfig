package defpackage;

import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ze  reason: default package */
/* compiled from: GradientFillContent */
public final class ze implements z9, C0335t2.a, C0381wh {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final int f3466a;

    /* renamed from: a  reason: collision with other field name */
    public final Ch f3467a;

    /* renamed from: a  reason: collision with other field name */
    public final D9 f3468a;

    /* renamed from: a  reason: collision with other field name */
    public final Ej f3469a;

    /* renamed from: a  reason: collision with other field name */
    public final Lh f3470a;

    /* renamed from: a  reason: collision with other field name */
    public WB f3471a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f3472a;

    /* renamed from: a  reason: collision with other field name */
    public final RectF f3473a;

    /* renamed from: a  reason: collision with other field name */
    public final LongSparseArray<LinearGradient> f3474a = new LongSparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    public final String f3475a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3476a;

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<Integer, Integer> f3477a;

    /* renamed from: a  reason: collision with other field name */
    public final C0359v2 f3478a;

    /* renamed from: a  reason: collision with other field name */
    public final we f3479a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3480a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final Ch f3481b;

    /* renamed from: b  reason: collision with other field name */
    public WB f3482b;

    /* renamed from: b  reason: collision with other field name */
    public final LongSparseArray<RadialGradient> f3483b = new LongSparseArray<>();

    /* renamed from: b  reason: collision with other field name */
    public C0335t2<Float, Float> f3484b;

    public ze(Ej ej, C0359v2 v2Var, ye yeVar) {
        Path path = new Path();
        this.f3472a = path;
        this.f3470a = new Lh(1);
        this.f3473a = new RectF();
        this.f3476a = new ArrayList();
        this.a = 0.0f;
        this.f3478a = v2Var;
        this.f3475a = yeVar.f3436a;
        this.f3480a = yeVar.f3437a;
        this.f3469a = ej;
        this.f3466a = yeVar.a;
        path.setFillType(yeVar.f3435a);
        this.b = (int) (ej.f145a.b() / 32.0f);
        C0335t2 b2 = yeVar.f3433a.b();
        this.f3479a = (we) b2;
        b2.a(this);
        v2Var.g(b2);
        C0335t2<Integer, Integer> b3 = yeVar.f3434a.b();
        this.f3477a = b3;
        b3.a(this);
        v2Var.g(b3);
        C0335t2 b4 = yeVar.f3432a.b();
        this.f3467a = (Ch) b4;
        b4.a(this);
        v2Var.g(b4);
        C0335t2 b5 = yeVar.b.b();
        this.f3481b = (Ch) b5;
        b5.a(this);
        v2Var.g(b5);
        if (v2Var.m() != null) {
            C0335t2<Float, Float> b6 = ((H0) v2Var.m().a).b();
            this.f3484b = b6;
            b6.a(this);
            v2Var.g(this.f3484b);
        }
        if (v2Var.n() != null) {
            this.f3468a = new D9(this, v2Var, v2Var.n());
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        Path path = this.f3472a;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3476a;
            if (i < arrayList.size()) {
                path.addPath(((dp) arrayList.get(i)).b(), matrix);
                i++;
            } else {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r13v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: type inference failed for: r13v3, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.graphics.Canvas r22, android.graphics.Matrix r23, int r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            boolean r2 = r0.f3480a
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.Path r2 = r0.f3472a
            r2.reset()
            r3 = 0
            r4 = r3
        L_0x0010:
            java.util.ArrayList r5 = r0.f3476a
            int r6 = r5.size()
            if (r4 >= r6) goto L_0x0028
            java.lang.Object r5 = r5.get(r4)
            dp r5 = (defpackage.dp) r5
            android.graphics.Path r5 = r5.b()
            r2.addPath(r5, r1)
            int r4 = r4 + 1
            goto L_0x0010
        L_0x0028:
            android.graphics.RectF r4 = r0.f3473a
            r2.computeBounds(r4, r3)
            int r4 = r0.f3466a
            r5 = 1
            r6 = 0
            we r7 = r0.f3479a
            Ch r8 = r0.f3481b
            Ch r9 = r0.f3467a
            r10 = 0
            if (r4 != r5) goto L_0x007f
            int r4 = r21.j()
            long r4 = (long) r4
            androidx.collection.LongSparseArray<android.graphics.LinearGradient> r11 = r0.f3474a
            java.lang.Object r12 = r11.d(r4, r10)
            android.graphics.LinearGradient r12 = (android.graphics.LinearGradient) r12
            if (r12 == 0) goto L_0x004b
            goto L_0x00d0
        L_0x004b:
            java.lang.Object r9 = r9.f()
            android.graphics.PointF r9 = (android.graphics.PointF) r9
            java.lang.Object r8 = r8.f()
            android.graphics.PointF r8 = (android.graphics.PointF) r8
            java.lang.Object r7 = r7.f()
            ue r7 = (defpackage.ue) r7
            int[] r12 = r7.f3317a
            int[] r18 = r0.g(r12)
            float[] r7 = r7.a
            android.graphics.LinearGradient r12 = new android.graphics.LinearGradient
            float r14 = r9.x
            float r15 = r9.y
            float r9 = r8.x
            float r8 = r8.y
            android.graphics.Shader$TileMode r20 = android.graphics.Shader.TileMode.CLAMP
            r13 = r12
            r16 = r9
            r17 = r8
            r19 = r7
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            r11.e(r4, r12)
            goto L_0x00d0
        L_0x007f:
            int r4 = r21.j()
            long r4 = (long) r4
            androidx.collection.LongSparseArray<android.graphics.RadialGradient> r11 = r0.f3483b
            java.lang.Object r12 = r11.d(r4, r10)
            android.graphics.RadialGradient r12 = (android.graphics.RadialGradient) r12
            if (r12 == 0) goto L_0x008f
            goto L_0x00d0
        L_0x008f:
            java.lang.Object r9 = r9.f()
            android.graphics.PointF r9 = (android.graphics.PointF) r9
            java.lang.Object r8 = r8.f()
            android.graphics.PointF r8 = (android.graphics.PointF) r8
            java.lang.Object r7 = r7.f()
            ue r7 = (defpackage.ue) r7
            int[] r12 = r7.f3317a
            int[] r17 = r0.g(r12)
            float[] r7 = r7.a
            float r14 = r9.x
            float r15 = r9.y
            float r9 = r8.x
            float r8 = r8.y
            float r9 = r9 - r14
            double r12 = (double) r9
            float r8 = r8 - r15
            double r8 = (double) r8
            double r8 = java.lang.Math.hypot(r12, r8)
            float r8 = (float) r8
            int r9 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r9 > 0) goto L_0x00c1
            r8 = 981668463(0x3a83126f, float:0.001)
        L_0x00c1:
            r16 = r8
            android.graphics.RadialGradient r12 = new android.graphics.RadialGradient
            android.graphics.Shader$TileMode r19 = android.graphics.Shader.TileMode.CLAMP
            r13 = r12
            r18 = r7
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r11.e(r4, r12)
        L_0x00d0:
            r12.setLocalMatrix(r1)
            Lh r1 = r0.f3470a
            r1.setShader(r12)
            WB r4 = r0.f3471a
            if (r4 == 0) goto L_0x00e5
            java.lang.Object r4 = r4.f()
            android.graphics.ColorFilter r4 = (android.graphics.ColorFilter) r4
            r1.setColorFilter(r4)
        L_0x00e5:
            t2<java.lang.Float, java.lang.Float> r4 = r0.f3484b
            if (r4 == 0) goto L_0x010d
            java.lang.Object r4 = r4.f()
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            int r5 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x00fb
            r1.setMaskFilter(r10)
            goto L_0x010b
        L_0x00fb:
            float r5 = r0.a
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x010b
            android.graphics.BlurMaskFilter r5 = new android.graphics.BlurMaskFilter
            android.graphics.BlurMaskFilter$Blur r6 = android.graphics.BlurMaskFilter.Blur.NORMAL
            r5.<init>(r4, r6)
            r1.setMaskFilter(r5)
        L_0x010b:
            r0.a = r4
        L_0x010d:
            D9 r4 = r0.f3468a
            if (r4 == 0) goto L_0x0114
            r4.a(r1)
        L_0x0114:
            r4 = r24
            float r4 = (float) r4
            r5 = 1132396544(0x437f0000, float:255.0)
            float r4 = r4 / r5
            t2<java.lang.Integer, java.lang.Integer> r6 = r0.f3477a
            java.lang.Object r6 = r6.f()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            float r6 = (float) r6
            float r4 = r4 * r6
            r6 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 / r6
            float r4 = r4 * r5
            int r4 = (int) r4
            android.graphics.PointF r5 = defpackage.C0308ql.a
            r5 = 255(0xff, float:3.57E-43)
            int r4 = java.lang.Math.min(r5, r4)
            int r3 = java.lang.Math.max(r3, r4)
            r1.setAlpha(r3)
            r3 = r22
            r3.drawPath(r2, r1)
            defpackage.C1354qp.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ze.c(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void d(List<V6> list, List<V6> list2) {
        for (int i = 0; i < list2.size(); i++) {
            V6 v6 = list2.get(i);
            if (v6 instanceof dp) {
                this.f3476a.add((dp) v6);
            }
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        if (obj == Kj.f364d) {
            this.f3477a.k(tkVar);
            return;
        }
        ColorFilter colorFilter = Kj.f351a;
        C0359v2 v2Var = this.f3478a;
        if (obj == colorFilter) {
            WB wb = this.f3471a;
            if (wb != null) {
                v2Var.q(wb);
            }
            if (tkVar == null) {
                this.f3471a = null;
                return;
            }
            WB wb2 = new WB(tkVar, null);
            this.f3471a = wb2;
            wb2.a(this);
            v2Var.g(this.f3471a);
        } else if (obj == Kj.f358a) {
            WB wb3 = this.f3482b;
            if (wb3 != null) {
                v2Var.q(wb3);
            }
            if (tkVar == null) {
                this.f3482b = null;
                return;
            }
            this.f3474a.a();
            this.f3483b.a();
            WB wb4 = new WB(tkVar, null);
            this.f3482b = wb4;
            wb4.a(this);
            v2Var.g(this.f3482b);
        } else if (obj == Kj.f361c) {
            C0335t2<Float, Float> t2Var = this.f3484b;
            if (t2Var != null) {
                t2Var.k(tkVar);
                return;
            }
            WB wb5 = new WB(tkVar, null);
            this.f3484b = wb5;
            wb5.a(this);
            v2Var.g(this.f3484b);
        } else {
            Integer num = Kj.f366e;
            D9 d9 = this.f3468a;
            if (obj == num && d9 != null) {
                d9.a.k(tkVar);
            } else if (obj == Kj.v && d9 != null) {
                d9.b(tkVar);
            } else if (obj == Kj.w && d9 != null) {
                d9.b.k(tkVar);
            } else if (obj == Kj.x && d9 != null) {
                d9.c.k(tkVar);
            } else if (obj == Kj.y && d9 != null) {
                d9.d.k(tkVar);
            }
        }
    }

    public final void f() {
        this.f3469a.invalidateSelf();
    }

    public final int[] g(int[] iArr) {
        WB wb = this.f3482b;
        if (wb != null) {
            Integer[] numArr = (Integer[]) wb.f();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    public final String getName() {
        return this.f3475a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0308ql.d(uhVar, i, arrayList, uhVar2, this);
    }

    public final int j() {
        int i;
        float f = this.f3467a.a;
        float f2 = (float) this.b;
        int round = Math.round(f * f2);
        int round2 = Math.round(this.f3481b.a * f2);
        int round3 = Math.round(this.f3479a.a * f2);
        if (round != 0) {
            i = round * 527;
        } else {
            i = 17;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        if (round3 != 0) {
            return i * 31 * round3;
        }
        return i;
    }
}
