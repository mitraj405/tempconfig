package defpackage;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Kc  reason: default package and case insensitive filesystem */
/* compiled from: SafeCollector.common.kt */
public final class C0565Kc implements Flow<Object> {
    public final /* synthetic */ C0694Td a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Flow f3686a;

    @C1128g8(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", l = {113, 114}, m = "collect")
    /* renamed from: Kc$a */
    /* compiled from: SafeCollector.common.kt */
    public static final class a extends C1148h7 {
        public final /* synthetic */ C0565Kc a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f3687a;

        /* renamed from: a  reason: collision with other field name */
        public FlowCollector f3688a;
        public C0565Kc b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C0565Kc kc, Continuation continuation) {
            super(continuation);
            this.a = kc;
        }

        public final Object invokeSuspend(Object obj) {
            this.f3687a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.a.collect((FlowCollector<Object>) null, this);
        }
    }

    public C0565Kc(Flow flow, C0694Td td) {
        this.f3686a = flow;
        this.a = td;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof defpackage.C0565Kc.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            Kc$a r0 = (defpackage.C0565Kc.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Kc$a r0 = new Kc$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f3687a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            defpackage.r1.R(r7)
            goto L_0x0061
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlinx.coroutines.flow.FlowCollector r6 = r0.f3688a
            Kc r2 = r0.b
            defpackage.r1.R(r7)
            goto L_0x004d
        L_0x003a:
            defpackage.r1.R(r7)
            r0.b = r5
            r0.f3688a = r6
            r0.c = r4
            kotlinx.coroutines.flow.Flow r7 = r5.f3686a
            java.io.Serializable r7 = defpackage.r1.j(r0, r7, r6)
            if (r7 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r2 = r5
        L_0x004d:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 == 0) goto L_0x0061
            Td r2 = r2.a
            r4 = 0
            r0.b = r4
            r0.f3688a = r4
            r0.c = r3
            java.lang.Object r6 = r2.invoke(r6, r7, r0)
            if (r6 != r1) goto L_0x0061
            return r1
        L_0x0061:
            kotlin.Unit r6 = kotlin.Unit.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0565Kc.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
