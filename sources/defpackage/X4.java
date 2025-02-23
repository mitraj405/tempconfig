package defpackage;

import defpackage.C0698Tt;
import defpackage.V4;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@C1128g8(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
/* renamed from: X4  reason: default package */
/* compiled from: Channels.kt */
public final class X4 extends Py implements Function2<CoroutineScope, Continuation<? super V4<? extends Unit>>, Object> {
    public final /* synthetic */ C0790aw<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f3828a;
    public final /* synthetic */ Object b;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public X4(C0790aw<Object> awVar, Object obj, Continuation<? super X4> continuation) {
        super(2, continuation);
        this.a = awVar;
        this.b = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        X4 x4 = new X4(this.a, this.b, continuation);
        x4.f3828a = obj;
        return x4;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((X4) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            r1.R(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f3828a;
            C0790aw<Object> awVar = this.a;
            Object obj4 = this.b;
            this.c = 1;
            if (awVar.s(obj4, this) == v7Var) {
                return v7Var;
            }
        } else if (i == 1) {
            try {
                r1.R(obj);
            } catch (Throwable th) {
                obj2 = r1.n(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Unit.a;
        if (!(obj2 instanceof C0698Tt.a)) {
            obj3 = Unit.a;
        } else {
            obj3 = new V4.a(C0698Tt.a(obj2));
        }
        return new V4(obj3);
    }
}
