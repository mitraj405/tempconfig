package defpackage;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: BC  reason: default package */
/* compiled from: ViewOscillator */
public abstract class BC extends qh {

    /* renamed from: BC$a */
    /* compiled from: ViewOscillator */
    public static class a extends BC {
        public final void e(float f, View view) {
            view.setAlpha(a(f));
        }
    }

    /* renamed from: BC$b */
    /* compiled from: ViewOscillator */
    public static class b extends BC {
        public O6 a;

        /* renamed from: a  reason: collision with other field name */
        public final float[] f45a = new float[1];

        public final void c(O6 o6) {
            this.a = o6;
        }

        public final void e(float f, View view) {
            float a2 = a(f);
            float[] fArr = this.f45a;
            fArr[0] = a2;
            r1.P(this.a, view, fArr);
        }
    }

    /* renamed from: BC$c */
    /* compiled from: ViewOscillator */
    public static class c extends BC {
        public final void e(float f, View view) {
            view.setElevation(a(f));
        }
    }

    /* renamed from: BC$e */
    /* compiled from: ViewOscillator */
    public static class e extends BC {
        public boolean a = false;

        public final void e(float f, View view) {
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

    /* renamed from: BC$f */
    /* compiled from: ViewOscillator */
    public static class f extends BC {
        public final void e(float f, View view) {
            view.setRotation(a(f));
        }
    }

    /* renamed from: BC$g */
    /* compiled from: ViewOscillator */
    public static class g extends BC {
        public final void e(float f, View view) {
            view.setRotationX(a(f));
        }
    }

    /* renamed from: BC$h */
    /* compiled from: ViewOscillator */
    public static class h extends BC {
        public final void e(float f, View view) {
            view.setRotationY(a(f));
        }
    }

    /* renamed from: BC$i */
    /* compiled from: ViewOscillator */
    public static class i extends BC {
        public final void e(float f, View view) {
            view.setScaleX(a(f));
        }
    }

    /* renamed from: BC$j */
    /* compiled from: ViewOscillator */
    public static class j extends BC {
        public final void e(float f, View view) {
            view.setScaleY(a(f));
        }
    }

    /* renamed from: BC$k */
    /* compiled from: ViewOscillator */
    public static class k extends BC {
        public final void e(float f, View view) {
            view.setTranslationX(a(f));
        }
    }

    /* renamed from: BC$l */
    /* compiled from: ViewOscillator */
    public static class l extends BC {
        public final void e(float f, View view) {
            view.setTranslationY(a(f));
        }
    }

    /* renamed from: BC$m */
    /* compiled from: ViewOscillator */
    public static class m extends BC {
        public final void e(float f, View view) {
            view.setTranslationZ(a(f));
        }
    }

    public abstract void e(float f2, View view);

    /* renamed from: BC$d */
    /* compiled from: ViewOscillator */
    public static class d extends BC {
        public final void e(float f, View view) {
        }
    }
}
