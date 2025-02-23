package defpackage;

import defpackage.C1364r7;
import kotlin.coroutines.CoroutineContext;

/* renamed from: t7  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineExceptionHandler.kt */
public final class C1399t7 {
    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        try {
            C1364r7 r7Var = (C1364r7) coroutineContext.b(C1364r7.a.a);
            if (r7Var != null) {
                r7Var.n(coroutineContext, th);
            } else {
                C1354qp.Y(coroutineContext, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                C1354qp.g(runtimeException, th);
                th = runtimeException;
            }
            C1354qp.Y(coroutineContext, th);
        }
    }
}
