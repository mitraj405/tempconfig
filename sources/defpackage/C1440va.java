package defpackage;

import in.juspay.hyper.constants.LogCategory;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: va  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineContextImpl.kt */
public final class C1440va implements CoroutineContext, Serializable {
    public static final C1440va a = new C1440va();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return a;
    }

    public final <R> R C(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        C1177ig.f(function2, "operation");
        return r;
    }

    public final <E extends CoroutineContext.b> E b(CoroutineContext.c<E> cVar) {
        C1177ig.f(cVar, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final CoroutineContext j(CoroutineContext coroutineContext) {
        C1177ig.f(coroutineContext, LogCategory.CONTEXT);
        return coroutineContext;
    }

    public final CoroutineContext l(CoroutineContext.c<?> cVar) {
        C1177ig.f(cVar, "key");
        return this;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }
}
