package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: Vv  reason: default package */
/* compiled from: Semaphore.kt */
public final class Vv extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ Xv a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Vv(Xv xv) {
        super(1);
        this.a = xv;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        this.a.e();
        return Unit.a;
    }
}
