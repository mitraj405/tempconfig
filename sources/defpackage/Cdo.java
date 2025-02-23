package defpackage;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* renamed from: do  reason: invalid class name and default package */
/* compiled from: OnUndeliveredElement.kt */
public final class Cdo extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CoroutineContext f5448a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Function1<Object, Unit> f5449a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cdo(Function1<Object, Unit> function1, Object obj, CoroutineContext coroutineContext) {
        super(1);
        this.f5449a = function1;
        this.a = obj;
        this.f5448a = coroutineContext;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        r1.h(this.f5449a, this.a, this.f5448a);
        return Unit.a;
    }
}
