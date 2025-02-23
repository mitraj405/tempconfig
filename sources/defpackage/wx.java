package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* renamed from: wx  reason: default package */
/* compiled from: SolidLayer */
public final class wx extends C0359v2 {
    public WB a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f3404a;
    public final Sh b;

    /* renamed from: b  reason: collision with other field name */
    public final Path f3405b;
    public final RectF f = new RectF();
    public final Lh g;

    public wx(Ej ej, Sh sh) {
        super(ej, sh);
        Lh lh = new Lh();
        this.g = lh;
        this.f3404a = new float[8];
        this.f3405b = new Path();
        this.b = sh;
        lh.setAlpha(0);
        lh.setStyle(Paint.Style.FILL);
        lh.setColor(sh.d);
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        RectF rectF2 = this.f;
        Sh sh = this.b;
        rectF2.set(0.0f, 0.0f, (float) sh.f531b, (float) sh.c);
        this.f3359c.mapRect(rectF2);
        rectF.set(rectF2);
    }

    public final void e(C0344tk tkVar, Object obj) {
        super.e(tkVar, obj);
        if (obj != Kj.f351a) {
            return;
        }
        if (tkVar == null) {
            this.a = null;
        } else {
            this.a = new WB(tkVar, null);
        }
    }

    public final void l(Canvas canvas, Matrix matrix, int i) {
        int i2;
        Sh sh = this.b;
        int alpha = Color.alpha(sh.d);
        if (alpha != 0) {
            C0335t2<Integer, Integer> t2Var = this.f3343a.e;
            if (t2Var == null) {
                i2 = 100;
            } else {
                i2 = t2Var.f().intValue();
            }
            int i3 = (int) ((((((float) alpha) / 255.0f) * ((float) i2)) / 100.0f) * (((float) i) / 255.0f) * 255.0f);
            Lh lh = this.g;
            lh.setAlpha(i3);
            WB wb = this.a;
            if (wb != null) {
                lh.setColorFilter((ColorFilter) wb.f());
            }
            if (i3 > 0) {
                float[] fArr = this.f3404a;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                float f2 = (float) sh.f531b;
                fArr[2] = f2;
                fArr[3] = 0.0f;
                fArr[4] = f2;
                float f3 = (float) sh.c;
                fArr[5] = f3;
                fArr[6] = 0.0f;
                fArr[7] = f3;
                matrix.mapPoints(fArr);
                Path path = this.f3405b;
                path.reset();
                path.moveTo(fArr[0], fArr[1]);
                path.lineTo(fArr[2], fArr[3]);
                path.lineTo(fArr[4], fArr[5]);
                path.lineTo(fArr[6], fArr[7]);
                path.lineTo(fArr[0], fArr[1]);
                path.close();
                canvas.drawPath(path, lh);
            }
        }
    }
}
