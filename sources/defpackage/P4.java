package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@C1128g8(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
/* renamed from: P4  reason: default package */
/* compiled from: ChannelFlow.kt */
public final class P4 extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ C0661R4<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f3748a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FlowCollector<Object> f3749a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public P4(Continuation continuation, FlowCollector flowCollector, C0661R4 r4) {
        super(2, continuation);
        this.f3749a = flowCollector;
        this.a = r4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        P4 p4 = new P4(continuation, this.f3749a, this.a);
        p4.f3748a = obj;
        return p4;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((P4) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            r1.R(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f3748a;
            C0661R4<Object> r4 = this.a;
            int i2 = r4.c;
            if (i2 == -3) {
                i2 = -2;
            }
            C0646Q4 q4 = new C0646Q4(r4, (Continuation<? super C0646Q4>) null);
            C1501yq yqVar = new C1501yq(C1320p7.b(coroutineScope, r4.a), C0703U4.a(i2, r4.d, 4));
            yqVar.q0(3, yqVar, q4);
            this.c = 1;
            Object F = C1354qp.F(this.f3749a, yqVar, true, this);
            if (F != v7Var) {
                F = Unit.a;
            }
            if (F == v7Var) {
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
