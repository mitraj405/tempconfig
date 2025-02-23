package defpackage;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a;

/* renamed from: W2  reason: default package and case insensitive filesystem */
/* compiled from: Builders.kt */
public final class C0730W2<T> extends a<T> {
    public final C0765Za a;

    /* renamed from: a  reason: collision with other field name */
    public final Thread f3823a;

    public C0730W2(CoroutineContext coroutineContext, Thread thread, C0765Za za) {
        super(coroutineContext, true);
        this.f3823a = thread;
        this.a = za;
    }

    public final void v(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f3823a;
        if (!C1177ig.a(currentThread, thread)) {
            LockSupport.unpark(thread);
        }
    }
}
