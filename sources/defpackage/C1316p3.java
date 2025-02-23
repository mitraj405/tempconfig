package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: p3  reason: default package and case insensitive filesystem */
/* compiled from: BufferedChannel.kt */
public final class C1316p3 extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ Tv<?> a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f6884a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1296o3<Object> f6885a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1316p3(Object obj, C1296o3<Object> o3Var, Tv<?> tv) {
        super(1);
        this.f6884a = obj;
        this.f6885a = o3Var;
        this.a = tv;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        C0422zD zDVar = C1361r3.i;
        Object obj2 = this.f6884a;
        if (obj2 != zDVar) {
            r1.h(this.f6885a.f5614a, obj2, this.a.getContext());
        }
        return Unit.a;
    }
}
