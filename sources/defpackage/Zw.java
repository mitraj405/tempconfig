package defpackage;

import defpackage.Ww;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@C1128g8(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
/* renamed from: Zw  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class Zw extends Py implements Function2<Ww.a<Object>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Ww<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f784a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Zw(Ww<Object> ww, Continuation<? super Zw> continuation) {
        super(2, continuation);
        this.a = ww;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Zw zw = new Zw(this.a, continuation);
        zw.f784a = obj;
        return zw;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Zw) create((Ww.a) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            v7 r0 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r1 = r5.c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0019
            if (r1 == r3) goto L_0x0015
            if (r1 != r2) goto L_0x000d
            goto L_0x0015
        L_0x000d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0015:
            defpackage.r1.R(r6)
            goto L_0x007f
        L_0x0019:
            defpackage.r1.R(r6)
            java.lang.Object r6 = r5.f784a
            Ww$a r6 = (defpackage.Ww.a) r6
            boolean r1 = r6 instanceof defpackage.Ww.a.C0000a
            Ww<java.lang.Object> r4 = r5.a
            if (r1 == 0) goto L_0x0070
            Ww$a$a r6 = (defpackage.Ww.a.C0000a) r6
            r5.c = r3
            Sx r1 = r4.f641a
            java.lang.Object r1 = r1.b()
            Rx r1 = (defpackage.Rx) r1
            boolean r2 = r1 instanceof defpackage.V7
            if (r2 == 0) goto L_0x0037
            goto L_0x005f
        L_0x0037:
            boolean r2 = r1 instanceof defpackage.ys
            if (r2 == 0) goto L_0x0049
            Rx<T> r6 = r6.a
            if (r1 != r6) goto L_0x005f
            java.lang.Object r6 = r4.g(r5)
            if (r6 != r0) goto L_0x0046
            goto L_0x0061
        L_0x0046:
            kotlin.Unit r6 = kotlin.Unit.a
            goto L_0x0061
        L_0x0049:
            eB r6 = defpackage.eB.a
            boolean r6 = defpackage.C1177ig.a(r1, r6)
            if (r6 == 0) goto L_0x005b
            java.lang.Object r6 = r4.g(r5)
            if (r6 != r0) goto L_0x0058
            goto L_0x0061
        L_0x0058:
            kotlin.Unit r6 = kotlin.Unit.a
            goto L_0x0061
        L_0x005b:
            boolean r6 = r1 instanceof defpackage.C0248kc
            if (r6 != 0) goto L_0x0064
        L_0x005f:
            kotlin.Unit r6 = kotlin.Unit.a
        L_0x0061:
            if (r6 != r0) goto L_0x007f
            return r0
        L_0x0064:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Can't read in final state."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L_0x0070:
            boolean r1 = r6 instanceof defpackage.Ww.a.b
            if (r1 == 0) goto L_0x007f
            Ww$a$b r6 = (defpackage.Ww.a.b) r6
            r5.c = r2
            java.lang.Object r6 = defpackage.Ww.c(r4, r6, r5)
            if (r6 != r0) goto L_0x007f
            return r0
        L_0x007f:
            kotlin.Unit r6 = kotlin.Unit.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Zw.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
