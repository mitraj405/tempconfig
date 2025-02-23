package defpackage;

import java.io.Serializable;

/* renamed from: Mh  reason: default package and case insensitive filesystem */
/* compiled from: Lambda.kt */
public abstract class C0595Mh<R> implements C0801be<R>, Serializable {
    private final int arity;

    public C0595Mh(int i) {
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        C0584Ls.a.getClass();
        String a = C0599Ms.a(this);
        C1177ig.e(a, "renderLambdaToString(this)");
        return a;
    }
}
