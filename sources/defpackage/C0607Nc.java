package defpackage;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Nc  reason: default package and case insensitive filesystem */
/* compiled from: Limit.kt */
public final class C0607Nc<T> implements FlowCollector {
    public final /* synthetic */ C0546Is a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f3709a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FlowCollector<T> f3710a;

    @C1128g8(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {37, 38, 40}, m = "emit")
    /* renamed from: Nc$a */
    /* compiled from: Limit.kt */
    public static final class a extends C1148h7 {
        public C0607Nc a;

        /* renamed from: a  reason: collision with other field name */
        public Object f3711a;
        public final /* synthetic */ C0607Nc<T> b;

        /* renamed from: b  reason: collision with other field name */
        public /* synthetic */ Object f3712b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(C0607Nc<? super T> nc, Continuation<? super a> continuation) {
            super(continuation);
            this.b = nc;
        }

        public final Object invokeSuspend(Object obj) {
            this.f3712b = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.emit(null, this);
        }
    }

    public C0607Nc(C0546Is is, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.a = is;
        this.f3710a = flowCollector;
        this.f3709a = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof defpackage.C0607Nc.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            Nc$a r0 = (defpackage.C0607Nc.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Nc$a r0 = new Nc$a
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f3712b
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            defpackage.r1.R(r8)
            goto L_0x0084
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.f3711a
            Nc r2 = r0.a
            defpackage.r1.R(r8)
            goto L_0x0068
        L_0x003d:
            defpackage.r1.R(r8)
            goto L_0x0055
        L_0x0041:
            defpackage.r1.R(r8)
            Is r8 = r6.a
            boolean r8 = r8.a
            if (r8 == 0) goto L_0x0058
            r0.c = r5
            kotlinx.coroutines.flow.FlowCollector<T> r8 = r6.f3710a
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            kotlin.Unit r7 = kotlin.Unit.a
            return r7
        L_0x0058:
            r0.a = r6
            r0.f3711a = r7
            r0.c = r4
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f3709a
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r6
        L_0x0068:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0087
            Is r8 = r2.a
            r8.a = r5
            r8 = 0
            r0.a = r8
            r0.f3711a = r8
            r0.c = r3
            kotlinx.coroutines.flow.FlowCollector<T> r8 = r2.f3710a
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L_0x0084
            return r1
        L_0x0084:
            kotlin.Unit r7 = kotlin.Unit.a
            return r7
        L_0x0087:
            kotlin.Unit r7 = kotlin.Unit.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0607Nc.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
