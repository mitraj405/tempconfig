package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: sg  reason: default package and case insensitive filesystem */
/* compiled from: JobSupport.kt */
public final class C1386sg extends C0610Ng {
    public final Function1<Throwable, Unit> a;

    public C1386sg(Function1<? super Throwable, Unit> function1) {
        this.a = function1;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return Unit.a;
    }

    public final void l(Throwable th) {
        this.a.invoke(th);
    }
}
