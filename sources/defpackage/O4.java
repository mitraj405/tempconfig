package defpackage;

import defpackage.C1484xq;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a;

/* renamed from: O4  reason: default package */
/* compiled from: ChannelCoroutine.kt */
public class O4<E> extends a<Unit> implements N4<E> {
    public final N4<E> a;

    public O4(CoroutineContext coroutineContext, C1296o3 o3Var) {
        super(coroutineContext, true);
        this.a = o3Var;
    }

    public final void c(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new Kg(D(), (Throwable) null, this);
            }
            y(cancellationException);
        }
    }

    public final Object d(E e) {
        return this.a.d(e);
    }

    public final C0689T4<E> f() {
        return this.a.f();
    }

    public final boolean h(Throwable th) {
        return this.a.h(th);
    }

    public final boolean o() {
        return this.a.o();
    }

    public final void q(C1484xq.b bVar) {
        this.a.q(bVar);
    }

    public final Object s(E e, Continuation<? super Unit> continuation) {
        return this.a.s(e, continuation);
    }

    public final void y(CancellationException cancellationException) {
        this.a.c(cancellationException);
        w(cancellationException);
    }
}
