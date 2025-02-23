package defpackage;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: bx  reason: default package */
/* compiled from: Collect.kt */
public final class bx implements FlowCollector<Rx<Object>> {
    public final /* synthetic */ FlowCollector a;

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
    /* renamed from: bx$a */
    public static final class a extends C1148h7 {
        public final /* synthetic */ bx a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f2749a;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(bx bxVar, Continuation continuation) {
            super(continuation);
            this.a = bxVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f2749a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.a.emit((Object) null, this);
        }
    }

    public bx(FlowCollector flowCollector) {
        this.a = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.bx.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            bx$a r0 = (defpackage.bx.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            bx$a r0 = new bx$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f2749a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            defpackage.r1.R(r6)
            goto L_0x004f
        L_0x0027:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002f:
            defpackage.r1.R(r6)
            Rx r5 = (defpackage.Rx) r5
            boolean r6 = r5 instanceof defpackage.ys
            if (r6 != 0) goto L_0x006d
            boolean r6 = r5 instanceof defpackage.C0248kc
            if (r6 != 0) goto L_0x0068
            boolean r6 = r5 instanceof defpackage.V7
            if (r6 == 0) goto L_0x0052
            V7 r5 = (defpackage.V7) r5
            T r5 = r5.f587a
            r0.c = r3
            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
            java.lang.Object r5 = r6.emit(r5, r0)
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            kotlin.Unit r5 = kotlin.Unit.a
            return r5
        L_0x0052:
            boolean r5 = r5 instanceof defpackage.eB
            if (r5 == 0) goto L_0x0062
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x0062:
            V5 r5 = new V5
            r5.<init>()
            throw r5
        L_0x0068:
            kc r5 = (defpackage.C0248kc) r5
            java.lang.Throwable r5 = r5.a
            throw r5
        L_0x006d:
            ys r5 = (defpackage.ys) r5
            java.lang.Throwable r5 = r5.a
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bx.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
