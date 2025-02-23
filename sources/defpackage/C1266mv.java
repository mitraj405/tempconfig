package defpackage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.a;

/* renamed from: mv  reason: default package and case insensitive filesystem */
/* compiled from: Scopes.kt */
public class C1266mv<T> extends a<T> implements CoroutineStackFrame {
    public final Continuation<T> a;

    public C1266mv(Continuation continuation, CoroutineContext coroutineContext) {
        super(coroutineContext, true);
        this.a = continuation;
    }

    public final boolean Y() {
        return true;
    }

    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public void n0(Object obj) {
        this.a.resumeWith(C1354qp.r0(obj));
    }

    public void v(Object obj) {
        r1.M(r1.B(this.a), C1354qp.r0(obj), (Function1) null);
    }
}
