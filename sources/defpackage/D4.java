package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: D4  reason: default package */
/* compiled from: CanvasUtils */
public final class D4 {
    public static Method a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f112a;
    public static Method b;

    /* renamed from: D4$a */
    /* compiled from: CanvasUtils */
    public static class a {
        public static void a(Canvas canvas) {
            canvas.disableZ();
        }

        public static void b(Canvas canvas) {
            canvas.enableZ();
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a(Canvas canvas, boolean z) {
        Method method;
        Class<Canvas> cls = Canvas.class;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            if (z) {
                a.b(canvas);
            } else {
                a.a(canvas);
            }
        } else if (i != 28) {
            if (!f112a) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    a = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = cls.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    b = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f112a = true;
            }
            if (z) {
                try {
                    Method method2 = a;
                    if (method2 != null) {
                        method2.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
            if (!z && (method = b) != null) {
                method.invoke(canvas, new Object[0]);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}
