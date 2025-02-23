package defpackage;

import kotlinx.coroutines.b;

/* renamed from: Sz  reason: default package and case insensitive filesystem */
/* compiled from: EventLoop.common.kt */
public final class C0686Sz {
    public static final ThreadLocal<C0765Za> a = new ThreadLocal<>();

    public static C0765Za a() {
        ThreadLocal<C0765Za> threadLocal = a;
        C0765Za za = threadLocal.get();
        if (za != null) {
            return za;
        }
        b bVar = new b(Thread.currentThread());
        threadLocal.set(bVar);
        return bVar;
    }
}
