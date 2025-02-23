package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@C1128g8(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
/* renamed from: Kw  reason: default package */
/* compiled from: SimpleActor.kt */
public final class Kw extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Lw<Object> a;

    /* renamed from: a  reason: collision with other field name */
    public Function2 f373a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Kw(Lw<Object> lw, Continuation<? super Kw> continuation) {
        super(2, continuation);
        this.a = lw;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Kw(this.a, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Kw) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            v7 r0 = defpackage.C1438v7.a
            int r1 = r6.c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x0019
            if (r1 != r2) goto L_0x0011
            defpackage.r1.R(r7)
            r7 = r6
            goto L_0x006e
        L_0x0011:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0019:
            kotlin.jvm.functions.Function2 r1 = r6.f373a
            defpackage.r1.R(r7)
            r4 = r1
            r1 = r7
            r7 = r6
            goto L_0x0062
        L_0x0022:
            defpackage.r1.R(r7)
            Lw<java.lang.Object> r7 = r6.a
            java.util.concurrent.atomic.AtomicInteger r7 = r7.a
            int r7 = r7.get()
            if (r7 <= 0) goto L_0x0031
            r7 = r3
            goto L_0x0032
        L_0x0031:
            r7 = 0
        L_0x0032:
            if (r7 == 0) goto L_0x007b
            r7 = r6
        L_0x0035:
            Lw<java.lang.Object> r1 = r7.a
            kotlinx.coroutines.CoroutineScope r4 = r1.f389a
            kotlin.coroutines.CoroutineContext r4 = r4.r()
            kotlinx.coroutines.Job$b r5 = kotlinx.coroutines.Job.b.a
            kotlin.coroutines.CoroutineContext$b r4 = r4.b(r5)
            kotlinx.coroutines.Job r4 = (kotlinx.coroutines.Job) r4
            if (r4 == 0) goto L_0x0053
            boolean r5 = r4.isActive()
            if (r5 == 0) goto L_0x004e
            goto L_0x0053
        L_0x004e:
            java.util.concurrent.CancellationException r7 = r4.e()
            throw r7
        L_0x0053:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r1.f388a
            r7.f373a = r4
            r7.c = r3
            o3 r1 = r1.f390a
            java.lang.Object r1 = r1.C(r7)
            if (r1 != r0) goto L_0x0062
            return r0
        L_0x0062:
            r5 = 0
            r7.f373a = r5
            r7.c = r2
            java.lang.Object r1 = r4.invoke(r1, r7)
            if (r1 != r0) goto L_0x006e
            return r0
        L_0x006e:
            Lw<java.lang.Object> r1 = r7.a
            java.util.concurrent.atomic.AtomicInteger r1 = r1.a
            int r1 = r1.decrementAndGet()
            if (r1 != 0) goto L_0x0035
            kotlin.Unit r7 = kotlin.Unit.a
            return r7
        L_0x007b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Kw.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
