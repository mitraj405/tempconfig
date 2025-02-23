package defpackage;

import in.juspay.hyper.constants.LogCategory;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: l  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineContextImpl.kt */
public abstract class C1232l implements CoroutineContext.b {
    public final CoroutineContext.c<?> a;

    public C1232l(CoroutineContext.c<?> cVar) {
        this.a = cVar;
    }

    public final <R> R C(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        C1177ig.f(function2, "operation");
        return function2.invoke(r, this);
    }

    public final CoroutineContext.c<?> Z() {
        return this.a;
    }

    public <E extends CoroutineContext.b> E b(CoroutineContext.c<E> cVar) {
        return CoroutineContext.b.a.a(this, cVar);
    }

    public final CoroutineContext j(CoroutineContext coroutineContext) {
        C1177ig.f(coroutineContext, LogCategory.CONTEXT);
        return CoroutineContext.a.a(this, coroutineContext);
    }

    public CoroutineContext l(CoroutineContext.c<?> cVar) {
        return CoroutineContext.b.a.b(this, cVar);
    }
}
