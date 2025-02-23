package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import defpackage.C0180ed;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: UA  reason: default package */
/* compiled from: TypefaceCompatApi21Impl */
public class UA extends ZA {
    public static Class<?> a = null;

    /* renamed from: a  reason: collision with other field name */
    public static Constructor<?> f564a = null;

    /* renamed from: a  reason: collision with other field name */
    public static Method f565a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f566a = false;
    public static Method b;

    public static boolean f(boolean z, String str, int i, Object obj) {
        g();
        try {
            return ((Boolean) f565a.invoke(obj, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void g() {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        Method method2;
        if (!f566a) {
            f566a = true;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                constructor = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                cls = null;
                method2 = null;
                constructor = null;
                method = null;
            }
            f564a = constructor;
            a = cls;
            f565a = method;
            b = method2;
        }
    }

    public Typeface a(Context context, C0180ed.c cVar, Resources resources, int i) {
        g();
        try {
            Object newInstance = f564a.newInstance(new Object[0]);
            C0180ed.d[] dVarArr = cVar.a;
            int length = dVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                C0180ed.d dVar = dVarArr[i2];
                File d = C0116aB.d(context);
                if (d == null) {
                    return null;
                }
                try {
                    if (!C0116aB.b(d, resources, dVar.c)) {
                        d.delete();
                        return null;
                    }
                    if (!f(dVar.f2884a, d.getPath(), dVar.a, newInstance)) {
                        return null;
                    }
                    d.delete();
                    i2++;
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    d.delete();
                }
            }
            g();
            try {
                Object newInstance2 = Array.newInstance(a, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) b.invoke((Object) null, new Object[]{newInstance2});
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
