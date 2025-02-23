package defpackage;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ProducerScope;

/* renamed from: yq  reason: default package and case insensitive filesystem */
/* compiled from: Produce.kt */
public final class C1501yq<E> extends O4<E> implements ProducerScope<E> {
    public C1501yq(CoroutineContext coroutineContext, C1296o3 o3Var) {
        super(coroutineContext, o3Var);
    }

    public final boolean isActive() {
        return super.isActive();
    }

    public final void o0(boolean z, Throwable th) {
        if (!this.a.h(th) && !z) {
            C1399t7.a(this.a, th);
        }
    }

    public final void p0(Object obj) {
        Unit unit = (Unit) obj;
        this.a.h((Throwable) null);
    }
}
