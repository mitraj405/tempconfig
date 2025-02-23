package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    public final Matrix a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f2496a;

    public PatternPathMotion() {
        Path path = new Path();
        this.f2496a = path;
        this.a = new Matrix();
        path.lineTo(1.0f, 0.0f);
    }

    public final void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        Matrix matrix = this.a;
        matrix.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f6 * f6) + (f5 * f5))));
        matrix.postScale(sqrt, sqrt);
        matrix.postRotate((float) Math.toDegrees(-Math.atan2((double) f6, (double) f5)));
        path.transform(matrix, this.f2496a);
    }

    public final Path getPath(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float sqrt = (float) Math.sqrt((double) ((f6 * f6) + (f5 * f5)));
        double atan2 = Math.atan2((double) f6, (double) f5);
        Matrix matrix = this.a;
        matrix.setScale(sqrt, sqrt);
        matrix.postRotate((float) Math.toDegrees(atan2));
        matrix.postTranslate(f, f2);
        Path path = new Path();
        this.f2496a.transform(matrix, path);
        return path;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f2496a = new Path();
        this.a = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.i);
        try {
            String d = SA.d(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (d != null) {
                a(C0219hp.d(d));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        this.f2496a = new Path();
        this.a = new Matrix();
        a(path);
    }
}
