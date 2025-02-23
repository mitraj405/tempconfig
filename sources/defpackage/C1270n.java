package defpackage;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: n  reason: default package and case insensitive filesystem */
/* compiled from: Flow.kt */
public abstract class C1270n<T> implements Flow<T> {

    @C1128g8(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: n$a */
    /* compiled from: Flow.kt */
    public static final class a extends C1148h7 {
        public C0559Ju a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f5597a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1270n<T> f5598a;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C1270n<T> nVar, Continuation<? super a> continuation) {
            super(continuation);
            this.f5598a = nVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f5597a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.f5598a.collect((FlowCollector) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof defpackage.C1270n.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            n$a r0 = (defpackage.C1270n.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            n$a r0 = new n$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f5597a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            Ju r6 = r0.a
            defpackage.r1.R(r7)     // Catch:{ all -> 0x0029 }
            goto L_0x0055
        L_0x0029:
            r7 = move-exception
            goto L_0x005f
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            defpackage.r1.R(r7)
            Ju r7 = new Ju
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.a = r7     // Catch:{ all -> 0x005b }
            r0.c = r3     // Catch:{ all -> 0x005b }
            r6 = r5
            Mu r6 = (defpackage.Mu) r6     // Catch:{ all -> 0x005b }
            kotlin.jvm.functions.Function2<kotlinx.coroutines.flow.FlowCollector<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r6.a     // Catch:{ all -> 0x005b }
            java.lang.Object r6 = r6.invoke(r7, r0)     // Catch:{ all -> 0x005b }
            if (r6 != r1) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            kotlin.Unit r6 = kotlin.Unit.a     // Catch:{ all -> 0x005b }
        L_0x0051:
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r6 = r7
        L_0x0055:
            r6.releaseIntercepted()
            kotlin.Unit r6 = kotlin.Unit.a
            return r6
        L_0x005b:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x005f:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1270n.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
