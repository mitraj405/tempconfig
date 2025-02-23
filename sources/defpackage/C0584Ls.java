package defpackage;

/* renamed from: Ls  reason: default package and case insensitive filesystem */
/* compiled from: Reflection */
public final class C0584Ls {
    public static final C0599Ms a;

    /* renamed from: a  reason: collision with other field name */
    public static final C1198jh[] f3700a = new C1198jh[0];

    static {
        C0599Ms ms = null;
        try {
            ms = (C0599Ms) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (ms == null) {
            ms = new C0599Ms();
        }
        a = ms;
    }

    public static C1318p5 a(Class cls) {
        a.getClass();
        return new C1318p5(cls);
    }
}
