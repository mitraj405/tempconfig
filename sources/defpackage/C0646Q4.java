package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

@C1128g8(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
/* renamed from: Q4  reason: default package and case insensitive filesystem */
/* compiled from: ChannelFlow.kt */
public final class C0646Q4 extends Py implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ C0661R4<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f3760a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0646Q4(C0661R4<Object> r4, Continuation<? super C0646Q4> continuation) {
        super(2, continuation);
        this.a = r4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C0646Q4 q4 = new C0646Q4(this.a, continuation);
        q4.f3760a = obj;
        return q4;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C0646Q4) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            r1.R(obj);
            this.c = 1;
            if (this.a.b((ProducerScope) this.f3760a, this) == v7Var) {
                return v7Var;
            }
        } else if (i == 1) {
            r1.R(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.a;
    }
}
