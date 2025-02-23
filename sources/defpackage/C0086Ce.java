package defpackage;

import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;

/* renamed from: Ce  reason: default package and case insensitive filesystem */
/* compiled from: GradientStrokeContent */
public final class C0086Ce extends B2 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Ch f86a;

    /* renamed from: a  reason: collision with other field name */
    public final LongSparseArray<LinearGradient> f87a;

    /* renamed from: a  reason: collision with other field name */
    public final String f88a;

    /* renamed from: a  reason: collision with other field name */
    public final we f89a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f90a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final Ch f91b;

    /* renamed from: b  reason: collision with other field name */
    public WB f92b;

    /* renamed from: b  reason: collision with other field name */
    public final RectF f93b;

    /* renamed from: b  reason: collision with other field name */
    public final LongSparseArray<RadialGradient> f94b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0086Ce(defpackage.Ej r14, defpackage.C0359v2 r15, defpackage.Be r16) {
        /*
            r13 = this;
            r10 = r13
            r11 = r15
            r12 = r16
            int r0 = r12.b
            r1 = 0
            if (r0 == 0) goto L_0x00a4
            int r0 = r0 + -1
            r2 = 1
            if (r0 == 0) goto L_0x0016
            if (r0 == r2) goto L_0x0013
            android.graphics.Paint$Cap r0 = android.graphics.Paint.Cap.SQUARE
            goto L_0x0018
        L_0x0013:
            android.graphics.Paint$Cap r0 = android.graphics.Paint.Cap.ROUND
            goto L_0x0018
        L_0x0016:
            android.graphics.Paint$Cap r0 = android.graphics.Paint.Cap.BUTT
        L_0x0018:
            r3 = r0
            int r0 = r12.c
            if (r0 == 0) goto L_0x00a3
            int r0 = r0 + -1
            if (r0 == 0) goto L_0x002e
            if (r0 == r2) goto L_0x002b
            r2 = 2
            if (r0 == r2) goto L_0x0028
            r4 = r1
            goto L_0x0031
        L_0x0028:
            android.graphics.Paint$Join r0 = android.graphics.Paint.Join.BEVEL
            goto L_0x0030
        L_0x002b:
            android.graphics.Paint$Join r0 = android.graphics.Paint.Join.ROUND
            goto L_0x0030
        L_0x002e:
            android.graphics.Paint$Join r0 = android.graphics.Paint.Join.MITER
        L_0x0030:
            r4 = r0
        L_0x0031:
            float r5 = r12.a
            J0 r6 = r12.f54a
            H0 r7 = r12.f52a
            java.util.List<H0> r8 = r12.f56a
            H0 r9 = r12.f59b
            r0 = r13
            r1 = r14
            r2 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.collection.LongSparseArray r0 = new androidx.collection.LongSparseArray
            r0.<init>()
            r10.f87a = r0
            androidx.collection.LongSparseArray r0 = new androidx.collection.LongSparseArray
            r0.<init>()
            r10.f94b = r0
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r10.f93b = r0
            java.lang.String r0 = r12.f55a
            r10.f88a = r0
            int r0 = r12.f50a
            r10.a = r0
            boolean r0 = r12.f57a
            r10.f90a = r0
            r0 = r14
            ej r0 = r0.f145a
            float r0 = r0.b()
            r1 = 1107296256(0x42000000, float:32.0)
            float r0 = r0 / r1
            int r0 = (int) r0
            r10.b = r0
            I0 r0 = r12.f53a
            t2 r0 = r0.b()
            r1 = r0
            we r1 = (defpackage.we) r1
            r10.f89a = r1
            r0.a(r13)
            r15.g(r0)
            G0 r0 = r12.f51a
            t2 r0 = r0.b()
            r1 = r0
            Ch r1 = (defpackage.Ch) r1
            r10.f86a = r1
            r0.a(r13)
            r15.g(r0)
            G0 r0 = r12.f58b
            t2 r0 = r0.b()
            r1 = r0
            Ch r1 = (defpackage.Ch) r1
            r10.f91b = r1
            r0.a(r13)
            r15.g(r0)
            return
        L_0x00a3:
            throw r1
        L_0x00a4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0086Ce.<init>(Ej, v2, Be):void");
    }

    /* JADX WARNING: type inference failed for: r7v1, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r9v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r9v3, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.graphics.Canvas r18, android.graphics.Matrix r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r0.f90a
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            android.graphics.RectF r2 = r0.f93b
            r3 = 0
            r0.a(r2, r1, r3)
            int r2 = r0.a
            r3 = 1
            we r4 = r0.f89a
            Ch r5 = r0.f91b
            Ch r6 = r0.f86a
            r7 = 0
            if (r2 != r3) goto L_0x005a
            int r2 = r17.j()
            long r2 = (long) r2
            androidx.collection.LongSparseArray<android.graphics.LinearGradient> r8 = r0.f87a
            java.lang.Object r7 = r8.d(r2, r7)
            android.graphics.LinearGradient r7 = (android.graphics.LinearGradient) r7
            if (r7 == 0) goto L_0x002c
            goto L_0x00a0
        L_0x002c:
            java.lang.Object r6 = r6.f()
            android.graphics.PointF r6 = (android.graphics.PointF) r6
            java.lang.Object r5 = r5.f()
            android.graphics.PointF r5 = (android.graphics.PointF) r5
            java.lang.Object r4 = r4.f()
            ue r4 = (defpackage.ue) r4
            int[] r7 = r4.f3317a
            int[] r14 = r0.g(r7)
            float[] r15 = r4.a
            float r10 = r6.x
            float r11 = r6.y
            float r12 = r5.x
            float r13 = r5.y
            android.graphics.LinearGradient r7 = new android.graphics.LinearGradient
            android.graphics.Shader$TileMode r16 = android.graphics.Shader.TileMode.CLAMP
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)
            r8.e(r2, r7)
            goto L_0x00a0
        L_0x005a:
            int r2 = r17.j()
            long r2 = (long) r2
            androidx.collection.LongSparseArray<android.graphics.RadialGradient> r8 = r0.f94b
            java.lang.Object r7 = r8.d(r2, r7)
            android.graphics.RadialGradient r7 = (android.graphics.RadialGradient) r7
            if (r7 == 0) goto L_0x006a
            goto L_0x00a0
        L_0x006a:
            java.lang.Object r6 = r6.f()
            android.graphics.PointF r6 = (android.graphics.PointF) r6
            java.lang.Object r5 = r5.f()
            android.graphics.PointF r5 = (android.graphics.PointF) r5
            java.lang.Object r4 = r4.f()
            ue r4 = (defpackage.ue) r4
            int[] r7 = r4.f3317a
            int[] r13 = r0.g(r7)
            float[] r14 = r4.a
            float r10 = r6.x
            float r11 = r6.y
            float r4 = r5.x
            float r5 = r5.y
            float r4 = r4 - r10
            double r6 = (double) r4
            float r5 = r5 - r11
            double r4 = (double) r5
            double r4 = java.lang.Math.hypot(r6, r4)
            float r12 = (float) r4
            android.graphics.RadialGradient r7 = new android.graphics.RadialGradient
            android.graphics.Shader$TileMode r15 = android.graphics.Shader.TileMode.CLAMP
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r8.e(r2, r7)
        L_0x00a0:
            r7.setLocalMatrix(r1)
            Lh r2 = r0.f27a
            r2.setShader(r7)
            super.c(r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0086Ce.c(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public final void e(C0344tk tkVar, Object obj) {
        super.e(tkVar, obj);
        if (obj == Kj.f358a) {
            WB wb = this.f92b;
            C0359v2 v2Var = this.f34a;
            if (wb != null) {
                v2Var.q(wb);
            }
            if (tkVar == null) {
                this.f92b = null;
                return;
            }
            WB wb2 = new WB(tkVar, null);
            this.f92b = wb2;
            wb2.a(this);
            v2Var.g(this.f92b);
        }
    }

    public final int[] g(int[] iArr) {
        WB wb = this.f92b;
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
        return this.f88a;
    }

    public final int j() {
        int i;
        float f = this.f86a.a;
        float f2 = (float) this.b;
        int round = Math.round(f * f2);
        int round2 = Math.round(this.f91b.a * f2);
        int round3 = Math.round(this.f89a.a * f2);
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
