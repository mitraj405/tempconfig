package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.os.Build;

/* compiled from: TransitionUtils */
public final class f {
    public static final boolean a;

    /* compiled from: TransitionUtils */
    public static class a {
        public static Bitmap a(Picture picture) {
            return Bitmap.createBitmap(picture);
        }
    }

    /* compiled from: TransitionUtils */
    public static class b implements TypeEvaluator<Matrix> {
        public final Matrix a = new Matrix();

        /* renamed from: a  reason: collision with other field name */
        public final float[] f2539a = new float[9];
        public final float[] b = new float[9];

        public final Object evaluate(float f, Object obj, Object obj2) {
            float[] fArr = this.f2539a;
            ((Matrix) obj).getValues(fArr);
            float[] fArr2 = this.b;
            ((Matrix) obj2).getValues(fArr2);
            for (int i = 0; i < 9; i++) {
                float f2 = fArr2[i];
                float f3 = fArr[i];
                fArr2[i] = lf.a(f2, f3, f, f3);
            }
            Matrix matrix = this.a;
            matrix.setValues(fArr2);
            return matrix;
        }
    }

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 28) {
            z = true;
        } else {
            z = false;
        }
        a = z;
    }
}
