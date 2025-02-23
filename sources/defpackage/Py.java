package defpackage;

import kotlin.coroutines.Continuation;

/* renamed from: Py  reason: default package */
/* compiled from: ContinuationImpl.kt */
public abstract class Py extends C1148h7 implements C0801be<Object> {
    private final int arity;

    public Py(int i, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        C0584Ls.a.getClass();
        String a = C0599Ms.a(this);
        C1177ig.e(a, "renderLambdaToString(this)");
        return a;
    }

    public Py(int i) {
        this(i, (Continuation<Object>) null);
    }
}
