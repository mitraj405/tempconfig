package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* renamed from: uy  reason: default package */
/* compiled from: StrokeContent */
public final class uy extends B2 {
    public final Ch a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3336a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3337a;
    public WB b;

    /* renamed from: b  reason: collision with other field name */
    public final C0359v2 f3338b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public uy(defpackage.Ej r14, defpackage.C0359v2 r15, defpackage.C0398xw r16) {
        /*
            r13 = this;
            r10 = r13
            r11 = r15
            r12 = r16
            int r0 = r12.f3416a
            r1 = 0
            if (r0 == 0) goto L_0x005e
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
            int r0 = r12.b
            if (r0 == 0) goto L_0x005d
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
            J0 r6 = r12.f3419a
            H0 r7 = r12.f3423b
            java.util.List<H0> r8 = r12.f3421a
            H0 r9 = r12.f3418a
            r0 = r13
            r1 = r14
            r2 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f3338b = r11
            java.lang.String r0 = r12.f3420a
            r10.f3336a = r0
            boolean r0 = r12.f3422a
            r10.f3337a = r0
            G0 r0 = r12.f3417a
            t2 r0 = r0.b()
            r1 = r0
            Ch r1 = (defpackage.Ch) r1
            r10.a = r1
            r0.a(r13)
            r15.g(r0)
            return
        L_0x005d:
            throw r1
        L_0x005e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uy.<init>(Ej, v2, xw):void");
    }

    public final void c(Canvas canvas, Matrix matrix, int i) {
        if (!this.f3337a) {
            C0400y5 y5Var = (C0400y5) this.a;
            int l = y5Var.l(y5Var.b(), y5Var.d());
            Lh lh = this.f27a;
            lh.setColor(l);
            WB wb = this.b;
            if (wb != null) {
                lh.setColorFilter((ColorFilter) wb.f());
            }
            super.c(canvas, matrix, i);
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        super.e(tkVar, obj);
        Integer num = Kj.f360b;
        Ch ch = this.a;
        if (obj == num) {
            ch.k(tkVar);
        } else if (obj == Kj.f351a) {
            WB wb = this.b;
            C0359v2 v2Var = this.f3338b;
            if (wb != null) {
                v2Var.q(wb);
            }
            if (tkVar == null) {
                this.b = null;
                return;
            }
            WB wb2 = new WB(tkVar, null);
            this.b = wb2;
            wb2.a(this);
            v2Var.g(ch);
        }
    }

    public final String getName() {
        return this.f3336a;
    }
}
