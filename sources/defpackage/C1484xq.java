package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.c;
import kotlinx.coroutines.channels.ProducerScope;

/* renamed from: xq  reason: default package and case insensitive filesystem */
/* compiled from: Produce.kt */
public final class C1484xq {

    @C1128g8(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
    /* renamed from: xq$a */
    /* compiled from: Produce.kt */
    public static final class a extends C1148h7 {
        public /* synthetic */ Object a;

        /* renamed from: a  reason: collision with other field name */
        public Function0 f7064a;

        /* renamed from: a  reason: collision with other field name */
        public ProducerScope f7065a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return C1484xq.a((ProducerScope<?>) null, (Function0<Unit>) null, this);
        }
    }

    /* renamed from: xq$b */
    /* compiled from: Produce.kt */
    public static final class b extends C0595Mh implements Function1<Throwable, Unit> {
        public final /* synthetic */ CancellableContinuation<Unit> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar) {
            super(1);
            this.a = cVar;
        }

        public final Object invoke(Object obj) {
            Throwable th = (Throwable) obj;
            Unit unit = Unit.a;
            this.a.resumeWith(unit);
            return unit;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(kotlinx.coroutines.channels.ProducerScope<?> r4, kotlin.jvm.functions.Function0<kotlin.Unit> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof defpackage.C1484xq.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            xq$a r0 = (defpackage.C1484xq.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            xq$a r0 = new xq$a
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.jvm.functions.Function0 r5 = r0.f7064a
            defpackage.r1.R(r6)     // Catch:{ all -> 0x006c }
            goto L_0x0066
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            defpackage.r1.R(r6)
            kotlin.coroutines.CoroutineContext r6 = r0.getContext()
            kotlinx.coroutines.Job$b r2 = kotlinx.coroutines.Job.b.a
            kotlin.coroutines.CoroutineContext$b r6 = r6.b(r2)
            if (r6 != r4) goto L_0x0042
            r6 = r3
            goto L_0x0043
        L_0x0042:
            r6 = 0
        L_0x0043:
            if (r6 == 0) goto L_0x0071
            r0.f7065a = r4     // Catch:{ all -> 0x006c }
            r0.f7064a = r5     // Catch:{ all -> 0x006c }
            r0.c = r3     // Catch:{ all -> 0x006c }
            kotlinx.coroutines.c r6 = new kotlinx.coroutines.c     // Catch:{ all -> 0x006c }
            kotlin.coroutines.Continuation r0 = defpackage.r1.B(r0)     // Catch:{ all -> 0x006c }
            r6.<init>(r3, r0)     // Catch:{ all -> 0x006c }
            r6.s()     // Catch:{ all -> 0x006c }
            xq$b r0 = new xq$b     // Catch:{ all -> 0x006c }
            r0.<init>(r6)     // Catch:{ all -> 0x006c }
            r4.q(r0)     // Catch:{ all -> 0x006c }
            java.lang.Object r4 = r6.r()     // Catch:{ all -> 0x006c }
            if (r4 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r5.invoke()
            kotlin.Unit r4 = kotlin.Unit.a
            return r4
        L_0x006c:
            r4 = move-exception
            r5.invoke()
            throw r4
        L_0x0071:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1484xq.a(kotlinx.coroutines.channels.ProducerScope, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
