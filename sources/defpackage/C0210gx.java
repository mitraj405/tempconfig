package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@C1128g8(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
/* renamed from: gx  reason: default package and case insensitive filesystem */
/* compiled from: SingleProcessDataStore.kt */
public final class C0210gx extends Py implements Function2<CoroutineScope, Continuation<Object>, Object> {
    public final /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Function2<Object, Continuation<Object>, Object> f2979a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0210gx(Object obj, Continuation continuation, Function2 function2) {
        super(2, continuation);
        this.f2979a = function2;
        this.a = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0210gx(this.a, continuation, this.f2979a);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C0210gx) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            r1.R(obj);
            this.c = 1;
            obj = this.f2979a.invoke(this.a, this);
            if (obj == v7Var) {
                return v7Var;
            }
        } else if (i == 1) {
            r1.R(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
