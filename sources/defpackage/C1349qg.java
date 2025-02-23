package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: qg  reason: default package and case insensitive filesystem */
/* compiled from: CancellableContinuationImpl.kt */
public final class C1349qg extends C0688T3 {
    public final Function1<Throwable, Unit> a;

    public C1349qg(Function1<? super Throwable, Unit> function1) {
        this.a = function1;
    }

    public final void d(Throwable th) {
        this.a.invoke(th);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((Throwable) obj);
        return Unit.a;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.a.getClass().getSimpleName() + '@' + C1149h8.a(this) + ']';
    }
}
