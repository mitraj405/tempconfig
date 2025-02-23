package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: zz  reason: default package and case insensitive filesystem */
/* compiled from: Tasks.kt */
public final class C1524zz {
    public static final int a;

    /* renamed from: a  reason: collision with other field name */
    public static final long f7119a = C1354qp.A0(100000, 1, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");

    /* renamed from: a  reason: collision with other field name */
    public static final String f7120a;

    /* renamed from: a  reason: collision with other field name */
    public static final C1390sm f7121a = C1390sm.a;

    /* renamed from: a  reason: collision with other field name */
    public static final xe f7122a = new xe(0);
    public static final int b = C1354qp.B0("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);

    /* renamed from: b  reason: collision with other field name */
    public static final long f7123b = TimeUnit.SECONDS.toNanos(C1354qp.A0(60, 1, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));

    /* renamed from: b  reason: collision with other field name */
    public static final xe f7124b = new xe(1);

    static {
        String str;
        int i = C1121fz.a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f7120a = str;
        int i2 = C1121fz.a;
        if (i2 < 2) {
            i2 = 2;
        }
        a = C1354qp.B0("kotlinx.coroutines.scheduler.core.pool.size", i2, 1, 0, 8);
    }
}
