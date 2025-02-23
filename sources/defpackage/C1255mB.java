package defpackage;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* renamed from: mB  reason: default package and case insensitive filesystem */
/* compiled from: UnsafeAccess */
public final class C1255mB {
    public static final Unsafe a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f5595a;

    static {
        boolean z;
        if (System.getProperty("rx.unsafe-disable") != null) {
            z = true;
        } else {
            z = false;
        }
        f5595a = z;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get((Object) null);
        } catch (Throwable unused) {
        }
        a = unsafe;
    }

    public static long a(Class<?> cls, String str) {
        try {
            return a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }
}
