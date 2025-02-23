package defpackage;

import kotlin.coroutines.Continuation;

/* renamed from: St  reason: default package and case insensitive filesystem */
/* compiled from: ContinuationImpl.kt */
public abstract class C0684St extends Rt implements C0801be<Object> {
    public final int c = 2;

    public C0684St(Continuation continuation) {
        super(continuation);
    }

    public final int getArity() {
        return this.c;
    }

    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        C0584Ls.a.getClass();
        String a = C0599Ms.a(this);
        C1177ig.e(a, "renderLambdaToString(this)");
        return a;
    }
}
