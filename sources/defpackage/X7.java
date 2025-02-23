package defpackage;

import defpackage.a8;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@C1128g8(c = "androidx.datastore.core.DataMigrationInitializer$Companion$getInitializer$1", f = "DataMigrationInitializer.kt", l = {33}, m = "invokeSuspend")
/* renamed from: X7  reason: default package */
/* compiled from: DataMigrationInitializer.kt */
public final class X7 extends Py implements Function2<Tf<Object>, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List<W7<Object>> f673a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public X7(List<? extends W7<Object>> list, Continuation<? super X7> continuation) {
        super(2, continuation);
        this.f673a = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        X7 x7 = new X7(this.f673a, continuation);
        x7.a = obj;
        return x7;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((X7) create((Tf) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.c;
        if (i == 0) {
            r1.R(obj);
            a8.a aVar = a8.a;
            this.c = 1;
            if (a8.a.a(aVar, this.f673a, (Tf) this.a, this) == v7Var) {
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
