package defpackage;

/* renamed from: Bp  reason: default package */
/* compiled from: PlatformImplementations.kt */
public final class Bp {
    public static final Ap a;

    static {
        Ap ap;
        Object newInstance;
        C0450Ag newInstance2;
        Object newInstance3;
        C0461Bg newInstance4;
        Class<Ap> cls = Ap.class;
        try {
            newInstance4 = C0461Bg.class.newInstance();
            C1177ig.e(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
            ap = newInstance4;
        } catch (ClassCastException e) {
            ClassLoader classLoader = newInstance4.getClass().getClassLoader();
            ClassLoader classLoader2 = cls.getClassLoader();
            if (!C1177ig.a(classLoader, classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
            }
            throw e;
        } catch (ClassNotFoundException unused) {
            try {
                newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                C1177ig.e(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                ap = (Ap) newInstance3;
            } catch (ClassCastException e2) {
                ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                ClassLoader classLoader4 = cls.getClassLoader();
                if (!C1177ig.a(classLoader3, classLoader4)) {
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
                }
                throw e2;
            } catch (ClassNotFoundException unused2) {
                try {
                    newInstance2 = C0450Ag.class.newInstance();
                    C1177ig.e(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    ap = newInstance2;
                } catch (ClassCastException e3) {
                    ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                    ClassLoader classLoader6 = cls.getClassLoader();
                    if (!C1177ig.a(classLoader5, classLoader6)) {
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                    }
                    throw e3;
                } catch (ClassNotFoundException unused3) {
                    try {
                        newInstance = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        C1177ig.e(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                        ap = (Ap) newInstance;
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader7 = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader8 = cls.getClassLoader();
                        if (!C1177ig.a(classLoader7, classLoader8)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                        }
                        throw e4;
                    } catch (ClassNotFoundException unused4) {
                        ap = new Ap();
                    }
                }
            }
        }
        a = ap;
    }
}
