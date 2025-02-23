package defpackage;

/* renamed from: A0  reason: default package */
/* compiled from: Android */
public final class A0 {
    public static final Class<?> a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f0a;

    static {
        Class<?> cls;
        boolean z;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        if (cls2 != null) {
            z = true;
        } else {
            z = false;
        }
        f0a = z;
    }

    public static boolean a() {
        if (a == null || f0a) {
            return false;
        }
        return true;
    }
}
