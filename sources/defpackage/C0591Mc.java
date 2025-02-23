package defpackage;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Mc  reason: default package and case insensitive filesystem */
/* compiled from: Errors.kt */
public final class C0591Mc<T> implements FlowCollector {
    public final /* synthetic */ C0571Ks<Throwable> a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FlowCollector<T> f3703a;

    @C1128g8(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", l = {158}, m = "emit")
    /* renamed from: Mc$a */
    /* compiled from: Errors.kt */
    public static final class a extends C1148h7 {
        public C0591Mc a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f3704a;
        public final /* synthetic */ C0591Mc<T> b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C0591Mc<? super T> mc, Continuation<? super a> continuation) {
            super(continuation);
            this.b = mc;
        }

        public final Object invokeSuspend(Object obj) {
            this.f3704a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.emit(null, this);
        }
    }

    public C0591Mc(FlowCollector<? super T> flowCollector, C0571Ks<Throwable> ks) {
        this.f3703a = flowCollector;
        this.a = ks;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.C0591Mc.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            Mc$a r0 = (defpackage.C0591Mc.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Mc$a r0 = new Mc$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f3704a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            Mc r5 = r0.a
            defpackage.r1.R(r6)     // Catch:{ all -> 0x0029 }
            goto L_0x0043
        L_0x0029:
            r6 = move-exception
            goto L_0x0049
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            defpackage.r1.R(r6)
            kotlinx.coroutines.flow.FlowCollector<T> r6 = r4.f3703a     // Catch:{ all -> 0x0046 }
            r0.a = r4     // Catch:{ all -> 0x0046 }
            r0.c = r3     // Catch:{ all -> 0x0046 }
            java.lang.Object r5 = r6.emit(r5, r0)     // Catch:{ all -> 0x0046 }
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            kotlin.Unit r5 = kotlin.Unit.a
            return r5
        L_0x0046:
            r5 = move-exception
            r6 = r5
            r5 = r4
        L_0x0049:
            Ks<java.lang.Throwable> r5 = r5.a
            r5.a = r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0591Mc.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
