package defpackage;

import android.animation.TypeEvaluator;

/* renamed from: Fc  reason: default package and case insensitive filesystem */
/* compiled from: FloatArrayEvaluator */
public final class C0091Fc implements TypeEvaluator<float[]> {
    public final float[] a;

    public C0091Fc(float[] fArr) {
        this.a = fArr;
    }

    public final Object evaluate(float f, Object obj, Object obj2) {
        float[] fArr = (float[]) obj;
        float[] fArr2 = (float[]) obj2;
        float[] fArr3 = this.a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i = 0; i < fArr3.length; i++) {
            float f2 = fArr[i];
            fArr3[i] = lf.a(fArr2[i], f2, f, f2);
        }
        return fArr3;
    }
}
