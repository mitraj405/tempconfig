package defpackage;

import kotlin.coroutines.CoroutineContext;

/* renamed from: T8  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineExceptionHandlerImpl.kt */
public final class C0691T8 extends RuntimeException {
    public final transient CoroutineContext a;

    public C0691T8(CoroutineContext coroutineContext) {
        this.a = coroutineContext;
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final String getLocalizedMessage() {
        return this.a.toString();
    }
}
