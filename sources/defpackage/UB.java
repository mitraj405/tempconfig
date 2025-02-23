package defpackage;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import java.io.Closeable;

/* renamed from: UB  reason: default package */
/* compiled from: Utils */
public final class UB {
    public static final float a = ((float) (Math.sqrt(2.0d) / 2.0d));

    /* renamed from: a  reason: collision with other field name */
    public static final a f567a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f568a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final c f569a = new c();

    /* renamed from: a  reason: collision with other field name */
    public static final d f570a = new d();

    /* renamed from: UB$a */
    /* compiled from: Utils */
    public class a extends ThreadLocal<PathMeasure> {
        public final Object initialValue() {
            return new PathMeasure();
        }
    }

    /* renamed from: UB$b */
    /* compiled from: Utils */
    public class b extends ThreadLocal<Path> {
        public final Object initialValue() {
            return new Path();
        }
    }

    /* renamed from: UB$c */
    /* compiled from: Utils */
    public class c extends ThreadLocal<Path> {
        public final Object initialValue() {
            return new Path();
        }
    }

    /* renamed from: UB$d */
    /* compiled from: Utils */
    public class d extends ThreadLocal<float[]> {
        public final Object initialValue() {
            return new float[4];
        }
    }

    public static void a(Path path, float f, float f2, float f3) {
        PathMeasure pathMeasure = (PathMeasure) f567a.get();
        Path path2 = (Path) f568a.get();
        Path path3 = (Path) f569a.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            C1354qp.G();
        } else if (length < 1.0f || ((double) Math.abs((f2 - f) - 1.0f)) < 0.01d) {
            C1354qp.G();
        } else {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = (float) C0308ql.c(min, length);
                max = (float) C0308ql.c(max, length);
            }
            if (min < 0.0f) {
                min = (float) C0308ql.c(min, length);
            }
            if (max < 0.0f) {
                max = (float) C0308ql.c(max, length);
            }
            int i = (min > max ? 1 : (min == max ? 0 : -1));
            if (i == 0) {
                path.reset();
                C1354qp.G();
                return;
            }
            if (i >= 0) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            C1354qp.G();
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float d(Matrix matrix) {
        float[] fArr = (float[]) f570a.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = a;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot((double) (fArr[2] - fArr[0]), (double) (fArr[3] - fArr[1]));
    }
}
