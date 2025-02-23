package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* renamed from: E3  reason: default package */
/* compiled from: Builders.kt */
public final class E3<T> extends C0676S4<T> {
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> b;

    @C1128g8(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {334}, m = "collectTo")
    /* renamed from: E3$a */
    /* compiled from: Builders.kt */
    public static final class a extends C1148h7 {
        public final /* synthetic */ E3<T> a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f3572a;

        /* renamed from: a  reason: collision with other field name */
        public ProducerScope f3573a;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(E3<T> e3, Continuation<? super a> continuation) {
            super(continuation);
            this.a = e3;
        }

        public final Object invokeSuspend(Object obj) {
            this.f3572a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.a.b((ProducerScope) null, this);
        }
    }

    public E3(Function2 function2) {
        super(function2, C1440va.a, -2, 1);
        this.b = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlinx.coroutines.channels.ProducerScope<? super T> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.E3.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            E3$a r0 = (defpackage.E3.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            E3$a r0 = new E3$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f3572a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlinx.coroutines.channels.ProducerScope r5 = r0.f3573a
            defpackage.r1.R(r6)
            goto L_0x0046
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            defpackage.r1.R(r6)
            r0.f3573a = r5
            r0.c = r3
            kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r4.a
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            kotlin.Unit r6 = kotlin.Unit.a
        L_0x0043:
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            boolean r5 = r5.o()
            if (r5 == 0) goto L_0x004f
            kotlin.Unit r5 = kotlin.Unit.a
            return r5
        L_0x004f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.E3.b(kotlinx.coroutines.channels.ProducerScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
