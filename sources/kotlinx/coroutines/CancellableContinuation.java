package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: CancellableContinuation.kt */
public interface CancellableContinuation<T> extends Continuation<T> {
    C0422zD g(Object obj, Function1 function1);

    void i(Function1<? super Throwable, Unit> function1);

    void k(Object obj);

    boolean p(Throwable th);

    void x(T t, Function1<? super Throwable, Unit> function1);
}
