package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: t9  reason: default package and case insensitive filesystem */
/* compiled from: SafeCollector.kt */
public final class C1400t9 implements CoroutineContext {
    public final Throwable a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CoroutineContext f6964a;

    public C1400t9(CoroutineContext coroutineContext, Throwable th) {
        this.a = th;
        this.f6964a = coroutineContext;
    }

    public final <R> R C(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        return this.f6964a.C(r, function2);
    }

    public final <E extends CoroutineContext.b> E b(CoroutineContext.c<E> cVar) {
        return this.f6964a.b(cVar);
    }

    public final CoroutineContext j(CoroutineContext coroutineContext) {
        return this.f6964a.j(coroutineContext);
    }

    public final CoroutineContext l(CoroutineContext.c<?> cVar) {
        return this.f6964a.l(cVar);
    }
}
