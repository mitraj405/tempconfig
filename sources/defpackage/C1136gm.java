package defpackage;

import defpackage.C1180im;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: gm  reason: default package and case insensitive filesystem */
/* compiled from: Mutex.kt */
public final class C1136gm extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ C1180im.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1180im f5468a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1136gm(C1180im imVar, C1180im.a aVar) {
        super(1);
        this.f5468a = imVar;
        this.a = aVar;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        this.f5468a.b(this.a.f5489a);
        return Unit.a;
    }
}
