package defpackage;

import android.view.animation.Interpolator;

/* renamed from: Xi  reason: default package */
/* compiled from: LookupTableInterpolator */
public abstract class Xi implements Interpolator {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f676a;

    public Xi(float[] fArr) {
        this.f676a = fArr;
        this.a = 1.0f / ((float) (fArr.length - 1));
    }

    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f676a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.a;
        float f3 = fArr[min];
        return lf.a(fArr[min + 1], f3, (f - (((float) min) * f2)) / f2, f3);
    }
}
