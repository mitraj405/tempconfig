package defpackage;

import defpackage.Ww;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* renamed from: Yw  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class Yw extends C0595Mh implements Function2<Ww.a<Object>, Throwable, Unit> {
    public static final Yw a = new Yw();

    public Yw() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        Ww.a aVar = (Ww.a) obj;
        Throwable th = (Throwable) obj2;
        C1177ig.f(aVar, "msg");
        if (aVar instanceof Ww.a.b) {
            Ww.a.b bVar = (Ww.a.b) aVar;
            if (th == null) {
                th = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            bVar.a.f0(th);
        }
        return Unit.a;
    }
}
