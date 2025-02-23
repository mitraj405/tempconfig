package defpackage;

import android.annotation.SuppressLint;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: VC  reason: default package */
/* compiled from: ViewUtilsApi19 */
public class VC {
    public static Field a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f589a = true;
    public static boolean b;

    /* renamed from: VC$a */
    /* compiled from: ViewUtilsApi19 */
    public static class a {
        public static float a(View view) {
            return view.getTransitionAlpha();
        }

        public static void b(View view, float f) {
            view.setTransitionAlpha(f);
        }
    }

    @SuppressLint({"NewApi"})
    public float a(View view) {
        if (f589a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f589a = false;
            }
        }
        return view.getAlpha();
    }

    @SuppressLint({"NewApi"})
    public void b(View view, float f) {
        if (f589a) {
            try {
                a.b(view, f);
                return;
            } catch (NoSuchMethodError unused) {
                f589a = false;
            }
        }
        view.setAlpha(f);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void c(View view, int i) {
        if (!b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            b = true;
        }
        Field field = a;
        if (field != null) {
            try {
                a.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
