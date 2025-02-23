package defpackage;

import kotlin.Unit;

/* renamed from: o9  reason: default package and case insensitive filesystem */
/* compiled from: CancellableContinuation.kt */
public final class C1300o9 extends C0688T3 {
    public final C1276n9 a;

    public C1300o9(C1276n9 n9Var) {
        this.a = n9Var;
    }

    public final void d(Throwable th) {
        this.a.h();
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((Throwable) obj);
        return Unit.a;
    }

    public final String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
