package defpackage;

import android.annotation.SuppressLint;
import android.os.Trace;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: sA  reason: default package and case insensitive filesystem */
/* compiled from: Trace */
public final class C0323sA {
    public static long a;

    /* renamed from: a  reason: collision with other field name */
    public static Method f3251a;

    @SuppressLint({"NewApi"})
    public static boolean a() {
        try {
            if (f3251a == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        Class<Trace> cls = Trace.class;
        try {
            if (f3251a == null) {
                a = cls.getField("TRACE_TAG_APP").getLong((Object) null);
                f3251a = cls.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) f3251a.invoke((Object) null, new Object[]{Long.valueOf(a)})).booleanValue();
        } catch (Exception e) {
            if (!(e instanceof InvocationTargetException)) {
                return false;
            }
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }
}
