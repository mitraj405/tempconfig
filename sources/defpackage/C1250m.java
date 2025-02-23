package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.b;
import kotlin.jvm.functions.Function1;

/* renamed from: m  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineContextImpl.kt */
public abstract class C1250m<B extends CoroutineContext.b, E extends B> implements CoroutineContext.c<E> {
    public final CoroutineContext.c<?> a;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<CoroutineContext.b, E> f5594a;

    public C1250m(CoroutineContext.c<B> cVar, Function1<? super CoroutineContext.b, ? extends E> function1) {
        C1177ig.f(cVar, "baseKey");
        C1177ig.f(function1, "safeCast");
        this.f5594a = function1;
        this.a = cVar instanceof C1250m ? ((C1250m) cVar).a : cVar;
    }
}
