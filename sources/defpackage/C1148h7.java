package defpackage;

import defpackage.C1171i7;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* renamed from: h7  reason: default package and case insensitive filesystem */
/* compiled from: ContinuationImpl.kt */
public abstract class C1148h7 extends C1340q2 {
    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;

    public C1148h7(Continuation<Object> continuation, CoroutineContext coroutineContext) {
        super(continuation);
        this._context = coroutineContext;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        C1177ig.c(coroutineContext);
        return coroutineContext;
    }

    public final Continuation<Object> intercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (continuation == null) {
            C1171i7 i7Var = (C1171i7) getContext().b(C1171i7.a.a);
            if (i7Var == null || (continuation = i7Var.A(this)) == null) {
                continuation = this;
            }
            this.intercepted = continuation;
        }
        return continuation;
    }

    public void releaseIntercepted() {
        Continuation<Object> continuation = this.intercepted;
        if (!(continuation == null || continuation == this)) {
            CoroutineContext context = getContext();
            int i = C1171i7.a;
            CoroutineContext.b b = context.b(C1171i7.a.a);
            C1177ig.c(b);
            ((C1171i7) b).Q(continuation);
        }
        this.intercepted = R5.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1148h7(Continuation<Object> continuation) {
        this(continuation, continuation != null ? continuation.getContext() : null);
    }
}
