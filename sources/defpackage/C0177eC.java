package defpackage;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: eC  reason: default package and case insensitive filesystem */
/* compiled from: VersionedParcel */
public abstract class C0177eC {
    public final ArrayMap<String, Method> a;
    public final ArrayMap<String, Method> b;
    public final ArrayMap<String, Class> c;

    public C0177eC(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.a = arrayMap;
        this.b = arrayMap2;
        this.c = arrayMap3;
    }

    public abstract C0192fC a();

    public final Class b(Class<? extends C0201gC> cls) throws ClassNotFoundException {
        String name = cls.getName();
        ArrayMap<String, Class> arrayMap = this.c;
        Class orDefault = arrayMap.getOrDefault(name, null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        arrayMap.put(cls.getName(), cls2);
        return cls2;
    }

    public final Method c(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        ArrayMap<String, Method> arrayMap = this.a;
        Method orDefault = arrayMap.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        System.currentTimeMillis();
        Class<C0177eC> cls = C0177eC.class;
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        arrayMap.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        ArrayMap<String, Method> arrayMap = this.b;
        Method orDefault = arrayMap.getOrDefault(name, null);
        if (orDefault != null) {
            return orDefault;
        }
        Class b2 = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = b2.getDeclaredMethod("write", new Class[]{cls, C0177eC.class});
        arrayMap.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e();

    public abstract byte[] f();

    public abstract CharSequence g();

    public abstract boolean h(int i);

    public abstract int i();

    public final int j(int i, int i2) {
        if (!h(i2)) {
            return i;
        }
        return i();
    }

    public abstract <T extends Parcelable> T k();

    public final <T extends Parcelable> T l(T t, int i) {
        if (!h(i)) {
            return t;
        }
        return k();
    }

    public abstract String m();

    public final <T extends C0201gC> T n() {
        String m = m();
        if (m == null) {
            return null;
        }
        C0192fC a2 = a();
        try {
            return (C0201gC) c(m).invoke((Object) null, new Object[]{a2});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        }
    }

    public abstract void o(int i);

    public abstract void p(boolean z);

    public abstract void q(byte[] bArr);

    public abstract void r(CharSequence charSequence);

    public abstract void s(int i);

    public final void t(int i, int i2) {
        o(i2);
        s(i);
    }

    public abstract void u(Parcelable parcelable);

    public abstract void v(String str);

    public final void w(C0201gC gCVar) {
        if (gCVar == null) {
            v((String) null);
            return;
        }
        try {
            v(b(gCVar.getClass()).getName());
            C0192fC a2 = a();
            try {
                d(gCVar.getClass()).invoke((Object) null, new Object[]{gCVar, a2});
                a2.x();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
            } catch (InvocationTargetException e2) {
                if (e2.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e2.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(gCVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
