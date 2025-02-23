package defpackage;

import defpackage.V4;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* renamed from: Jw  reason: default package */
/* compiled from: SimpleActor.kt */
public final class Jw extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ Lw<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Function1<Throwable, Unit> f316a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Function2<Object, Throwable, Unit> f317a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Jw(Xw xw, Lw lw, Yw yw) {
        super(1);
        this.f316a = xw;
        this.a = lw;
        this.f317a = yw;
    }

    public final Object invoke(Object obj) {
        Unit unit;
        Throwable th = (Throwable) obj;
        this.f316a.invoke(th);
        Lw<Object> lw = this.a;
        lw.f390a.h(th);
        do {
            Object E = lw.f390a.E();
            unit = null;
            if (E instanceof V4.b) {
                E = null;
            }
            if (E != null) {
                this.f317a.invoke(E, th);
                unit = Unit.a;
                continue;
            }
        } while (unit != null);
        return Unit.a;
    }
}
