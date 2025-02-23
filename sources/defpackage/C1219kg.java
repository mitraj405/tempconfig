package defpackage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: kg  reason: default package and case insensitive filesystem */
/* compiled from: IntrinsicsJvm.kt */
public final class C1219kg extends C1148h7 {
    public final /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Function2 f5549a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1219kg(Continuation continuation, CoroutineContext coroutineContext, Function2 function2, Object obj) {
        super(continuation, coroutineContext);
        this.f5549a = function2;
        this.a = obj;
        C1177ig.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    public final Object invokeSuspend(Object obj) {
        int i = this.c;
        if (i == 0) {
            this.c = 1;
            r1.R(obj);
            Function2 function2 = this.f5549a;
            C1177ig.d(function2, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
            C0648QA.a(2, function2);
            return function2.invoke(this.a, this);
        } else if (i == 1) {
            this.c = 2;
            r1.R(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
