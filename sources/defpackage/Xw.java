package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: Xw  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class Xw extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ Ww<Object> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Xw(Ww<Object> ww) {
        super(1);
        this.a = ww;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        if (th != null) {
            this.a.f641a.a(new C0248kc(th));
        }
        Object obj2 = Ww.a;
        Ww<Object> ww = this.a;
        synchronized (obj2) {
            Ww.f638a.remove(ww.d().getAbsolutePath());
        }
        return Unit.a;
    }
}
