package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: o7  reason: default package */
/* compiled from: CoroutineAdapter.kt */
public final class o7 extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ C0446A8<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ F3<Object> f3136a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o7(F3<Object> f3, C0446A8<Object> a8) {
        super(1);
        this.f3136a = f3;
        this.a = a8;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        boolean z = false;
        F3<Object> f3 = this.f3136a;
        if (th == null) {
            Object L = this.a.L();
            f3.f189a = true;
            H3<T> h3 = f3.f187a;
            if (h3 != null && h3.a.set(L)) {
                z = true;
            }
            if (z) {
                f3.f188a = null;
                f3.f187a = null;
                f3.a = null;
            }
        } else if (th instanceof CancellationException) {
            f3.f189a = true;
            H3<T> h32 = f3.f187a;
            if (h32 != null && h32.a.cancel(true)) {
                z = true;
            }
            if (z) {
                f3.f188a = null;
                f3.f187a = null;
                f3.a = null;
            }
        } else {
            f3.f189a = true;
            H3<T> h33 = f3.f187a;
            if (h33 != null && h33.a.setException(th)) {
                z = true;
            }
            if (z) {
                f3.f188a = null;
                f3.f187a = null;
                f3.a = null;
            }
        }
        return Unit.a;
    }
}
