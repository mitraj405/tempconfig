package defpackage;

import defpackage.Ww;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@C1128g8(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
/* renamed from: ax  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class ax extends Py implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Ww<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f2710a;
    public int c;

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ax$a */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class a extends Py implements Function2<Rx<Object>, Continuation<? super Boolean>, Object> {
        public final /* synthetic */ Rx<Object> a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f2711a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Rx<Object> rx2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = rx2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.a, continuation);
            aVar.f2711a = obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((Rx) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            r1.R(obj);
            Rx<Object> rx2 = (Rx) this.f2711a;
            Rx<Object> rx3 = this.a;
            boolean z = false;
            if (!(rx3 instanceof V7) && !(rx3 instanceof C0248kc) && rx2 == rx3) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ax(Ww<Object> ww, Continuation<? super ax> continuation) {
        super(2, continuation);
        this.a = ww;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ax axVar = new ax(this.a, continuation);
        axVar.f2710a = obj;
        return axVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ax) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            r1.R(obj);
            FlowCollector flowCollector = (FlowCollector) this.f2710a;
            Ww<Object> ww = this.a;
            Rx rx2 = (Rx) ww.f641a.b();
            if (!(rx2 instanceof V7)) {
                ww.f639a.a(new Ww.a.C0000a(rx2));
            }
            a aVar = new a(rx2, (Continuation<? super a>) null);
            this.c = 1;
            if (!(flowCollector instanceof Wz)) {
                Object collect = ww.f641a.collect(new C0607Nc(new C0546Is(), new bx(flowCollector), aVar), this);
                if (collect != v7Var) {
                    collect = Unit.a;
                }
                if (collect != v7Var) {
                    collect = Unit.a;
                }
                if (collect != v7Var) {
                    collect = Unit.a;
                }
                if (collect == v7Var) {
                    return v7Var;
                }
            } else {
                ((Wz) flowCollector).getClass();
                throw null;
            }
        } else if (i == 1) {
            r1.R(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.a;
    }
}
