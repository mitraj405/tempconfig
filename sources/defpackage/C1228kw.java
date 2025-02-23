package defpackage;

/* renamed from: kw  reason: default package and case insensitive filesystem */
/* compiled from: SessionStamp */
public final class C1228kw {
    public static C1228kw a;

    /* renamed from: a  reason: collision with other field name */
    public C1131ga f5570a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f5571a = null;
    public C1131ga b = null;

    public static synchronized C1228kw a() {
        C1228kw kwVar;
        synchronized (C1228kw.class) {
            if (a == null) {
                a = new C1228kw();
            }
            kwVar = a;
        }
        return kwVar;
    }
}
