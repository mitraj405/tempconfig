package defpackage;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: NC  reason: default package */
/* compiled from: ViewTimeCycle */
public abstract class NC extends Xz {

    /* renamed from: NC$a */
    /* compiled from: ViewTimeCycle */
    public static class a extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setAlpha(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$b */
    /* compiled from: ViewTimeCycle */
    public static class b extends NC {
        public final SparseArray<O6> a;
        public final SparseArray<float[]> b = new SparseArray<>();

        /* renamed from: b  reason: collision with other field name */
        public final String f439b;

        /* renamed from: b  reason: collision with other field name */
        public float[] f440b;
        public float[] c;

        public b(String str, SparseArray<O6> sparseArray) {
            this.f439b = str.split(",")[1];
            this.a = sparseArray;
        }

        public final void b(float f, float f2, float f3, int i, int i2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public final void c(int i) {
            SparseArray<O6> sparseArray = this.a;
            int size = sparseArray.size();
            int c2 = sparseArray.valueAt(0).c();
            double[] dArr = new double[size];
            int i2 = c2 + 2;
            this.f440b = new float[i2];
            this.c = new float[c2];
            int[] iArr = new int[2];
            iArr[1] = i2;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = sparseArray.keyAt(i3);
                float[] valueAt = this.b.valueAt(i3);
                dArr[i3] = ((double) keyAt) * 0.01d;
                sparseArray.valueAt(i3).b(this.f440b);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.f440b;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
                double[] dArr3 = dArr2[i3];
                dArr3[c2] = (double) valueAt[0];
                dArr3[c2 + 1] = (double) valueAt[1];
            }
            this.f692a = H7.a(i, dArr, dArr2);
        }

        public final boolean e(float f, long j, View view, nh nhVar) {
            boolean z;
            this.f692a.d((double) f, this.f440b);
            float[] fArr = this.f440b;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.f691a;
            if (Float.isNaN(this.a)) {
                float f4 = nhVar.f(view, this.f439b);
                this.a = f4;
                if (Float.isNaN(f4)) {
                    this.a = 0.0f;
                }
            }
            float f5 = (float) ((((((double) j2) * 1.0E-9d) * ((double) f2)) + ((double) this.a)) % 1.0d);
            this.a = f5;
            this.f691a = j;
            float a2 = a(f5);
            this.f694a = false;
            int i = 0;
            while (true) {
                float[] fArr2 = this.c;
                if (i >= fArr2.length) {
                    break;
                }
                boolean z2 = this.f694a;
                float f6 = this.f440b[i];
                if (((double) f6) != 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                this.f694a = z2 | z;
                fArr2[i] = (f6 * a2) + f3;
                i++;
            }
            r1.P(this.a.valueAt(0), view, this.c);
            if (f2 != 0.0f) {
                this.f694a = true;
            }
            return this.f694a;
        }
    }

    /* renamed from: NC$c */
    /* compiled from: ViewTimeCycle */
    public static class c extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setElevation(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$d */
    /* compiled from: ViewTimeCycle */
    public static class d extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            return this.f694a;
        }
    }

    /* renamed from: NC$e */
    /* compiled from: ViewTimeCycle */
    public static class e extends NC {
        public boolean b = false;

        public final boolean e(float f, long j, View view, nh nhVar) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(d(f, j, view, nhVar));
            } else if (this.b) {
                return false;
            } else {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.b = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(d(f, j, view, nhVar))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
            return this.f694a;
        }
    }

    /* renamed from: NC$f */
    /* compiled from: ViewTimeCycle */
    public static class f extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setRotation(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$g */
    /* compiled from: ViewTimeCycle */
    public static class g extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setRotationX(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$h */
    /* compiled from: ViewTimeCycle */
    public static class h extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setRotationY(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$i */
    /* compiled from: ViewTimeCycle */
    public static class i extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setScaleX(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$j */
    /* compiled from: ViewTimeCycle */
    public static class j extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setScaleY(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$k */
    /* compiled from: ViewTimeCycle */
    public static class k extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setTranslationX(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$l */
    /* compiled from: ViewTimeCycle */
    public static class l extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setTranslationY(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    /* renamed from: NC$m */
    /* compiled from: ViewTimeCycle */
    public static class m extends NC {
        public final boolean e(float f, long j, View view, nh nhVar) {
            view.setTranslationZ(d(f, j, view, nhVar));
            return this.f694a;
        }
    }

    public final float d(float f2, long j2, View view, nh nhVar) {
        long j3 = j2;
        View view2 = view;
        nh nhVar2 = nhVar;
        float[] fArr = this.f695a;
        this.f692a.d((double) f2, fArr);
        boolean z = true;
        float f3 = fArr[1];
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.f694a = false;
            return fArr[2];
        }
        if (Float.isNaN(this.a)) {
            float f4 = nhVar2.f(view2, this.f693a);
            this.a = f4;
            if (Float.isNaN(f4)) {
                this.a = 0.0f;
            }
        }
        float[] fArr2 = fArr;
        float f5 = (float) ((((((double) (j3 - this.f691a)) * 1.0E-9d) * ((double) f3)) + ((double) this.a)) % 1.0d);
        this.a = f5;
        String str = this.f693a;
        HashMap hashMap = (HashMap) nhVar2.a;
        if (!hashMap.containsKey(view2)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, new float[]{f5});
            hashMap.put(view2, hashMap2);
        } else {
            HashMap hashMap3 = (HashMap) hashMap.get(view2);
            if (hashMap3 == null) {
                hashMap3 = new HashMap();
            }
            if (!hashMap3.containsKey(str)) {
                hashMap3.put(str, new float[]{f5});
                hashMap.put(view2, hashMap3);
            } else {
                float[] fArr3 = (float[]) hashMap3.get(str);
                if (fArr3 == null) {
                    fArr3 = new float[0];
                }
                if (fArr3.length <= 0) {
                    fArr3 = Arrays.copyOf(fArr3, 1);
                }
                fArr3[0] = f5;
                hashMap3.put(str, fArr3);
            }
        }
        this.f691a = j3;
        float f6 = fArr2[0];
        float a2 = (a(this.a) * f6) + fArr2[2];
        if (f6 == 0.0f && i2 == 0) {
            z = false;
        }
        this.f694a = z;
        return a2;
    }

    public abstract boolean e(float f2, long j2, View view, nh nhVar);
}
