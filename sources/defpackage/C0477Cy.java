package defpackage;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: Cy  reason: default package and case insensitive filesystem */
/* compiled from: SubstituteLoggerFactory */
public final class C0477Cy implements ILoggerFactory {
    public final HashMap a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public final LinkedBlockingQueue<C0490Dy> f3564a = new LinkedBlockingQueue<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f3565a = false;

    public final synchronized Bi b(String str) {
        By by;
        by = (By) this.a.get(str);
        if (by == null) {
            by = new By(str, this.f3564a, this.f3565a);
            this.a.put(str, by);
        }
        return by;
    }
}
