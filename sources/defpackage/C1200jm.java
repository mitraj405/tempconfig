package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: jm  reason: default package and case insensitive filesystem */
/* compiled from: Mutex.kt */
public final class C1200jm extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ C1180im a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f5522a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1200jm(C1180im imVar, Object obj) {
        super(1);
        this.a = imVar;
        this.f5522a = obj;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        this.a.b(this.f5522a);
        return Unit.a;
    }
}
