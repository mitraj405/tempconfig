package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.f;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: UC  reason: default package */
/* compiled from: ViewUtils */
public final class UC {
    public static final Method a;

    static {
        Class<Rect> cls = Rect.class;
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{cls, cls});
            a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public static boolean a(View view) {
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if (view.getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
