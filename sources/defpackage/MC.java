package defpackage;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: MC  reason: default package */
/* compiled from: ViewSpline */
public abstract class MC extends Ex {

    /* renamed from: MC$a */
    /* compiled from: ViewSpline */
    public static class a extends MC {
        public final void d(float f, View view) {
            view.setAlpha(a(f));
        }
    }

    /* renamed from: MC$b */
    /* compiled from: ViewSpline */
    public static class b extends MC {
        public final SparseArray<O6> a;
        public float[] b;

        public b(String str, SparseArray<O6> sparseArray) {
            String str2 = str.split(",")[1];
            this.a = sparseArray;
        }

        public final void b(float f, int i) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public final void c(int i) {
            SparseArray<O6> sparseArray = this.a;
            int size = sparseArray.size();
            int c = sparseArray.valueAt(0).c();
            double[] dArr = new double[size];
            this.b = new float[c];
            int[] iArr = new int[2];
            iArr[1] = c;
            iArr[0] = size;
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, iArr);
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = ((double) sparseArray.keyAt(i2)) * 0.01d;
                sparseArray.valueAt(i2).b(this.b);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.b;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.f166a = H7.a(i, dArr, dArr2);
        }

        public final void d(float f, View view) {
            this.f166a.d((double) f, this.b);
            r1.P(this.a.valueAt(0), view, this.b);
        }
    }

    /* renamed from: MC$c */
    /* compiled from: ViewSpline */
    public static class c extends MC {
        public final void d(float f, View view) {
            view.setElevation(a(f));
        }
    }

    /* renamed from: MC$e */
    /* compiled from: ViewSpline */
    public static class e extends MC {
        public final void d(float f, View view) {
            view.setPivotX(a(f));
        }
    }

    /* renamed from: MC$f */
    /* compiled from: ViewSpline */
    public static class f extends MC {
        public final void d(float f, View view) {
            view.setPivotY(a(f));
        }
    }

    /* renamed from: MC$g */
    /* compiled from: ViewSpline */
    public static class g extends MC {
        public boolean a = false;

        public final void d(float f, View view) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f));
            } else if (!this.a) {
                try {
                    method = view.getClass().getMethod("setProgress", new Class[]{Float.TYPE});
                } catch (NoSuchMethodException unused) {
                    this.a = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, new Object[]{Float.valueOf(a(f))});
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                }
            }
        }
    }

    /* renamed from: MC$h */
    /* compiled from: ViewSpline */
    public static class h extends MC {
        public final void d(float f, View view) {
            view.setRotation(a(f));
        }
    }

    /* renamed from: MC$i */
    /* compiled from: ViewSpline */
    public static class i extends MC {
        public final void d(float f, View view) {
            view.setRotationX(a(f));
        }
    }

    /* renamed from: MC$j */
    /* compiled from: ViewSpline */
    public static class j extends MC {
        public final void d(float f, View view) {
            view.setRotationY(a(f));
        }
    }

    /* renamed from: MC$k */
    /* compiled from: ViewSpline */
    public static class k extends MC {
        public final void d(float f, View view) {
            view.setScaleX(a(f));
        }
    }

    /* renamed from: MC$l */
    /* compiled from: ViewSpline */
    public static class l extends MC {
        public final void d(float f, View view) {
            view.setScaleY(a(f));
        }
    }

    /* renamed from: MC$m */
    /* compiled from: ViewSpline */
    public static class m extends MC {
        public final void d(float f, View view) {
            view.setTranslationX(a(f));
        }
    }

    /* renamed from: MC$n */
    /* compiled from: ViewSpline */
    public static class n extends MC {
        public final void d(float f, View view) {
            view.setTranslationY(a(f));
        }
    }

    /* renamed from: MC$o */
    /* compiled from: ViewSpline */
    public static class o extends MC {
        public final void d(float f, View view) {
            view.setTranslationZ(a(f));
        }
    }

    public abstract void d(float f2, View view);

    /* renamed from: MC$d */
    /* compiled from: ViewSpline */
    public static class d extends MC {
        public final void d(float f, View view) {
        }
    }
}
