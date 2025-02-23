package defpackage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* renamed from: Rt  reason: default package */
/* compiled from: ContinuationImpl.kt */
public abstract class Rt extends C1340q2 {
    public Rt(Continuation<Object> continuation) {
        super(continuation);
        boolean z;
        if (continuation != null) {
            if (continuation.getContext() == C1440va.a) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public final CoroutineContext getContext() {
        return C1440va.a;
    }
}
