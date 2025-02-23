package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Sx  reason: default package */
/* compiled from: StateFlow.kt */
public final class Sx<T> extends r<Tx> implements C1116fm<T>, Flow {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(Sx.class, Object.class, "_state");
    private volatile Object _state;
    public int e;

    @C1128g8(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, 401}, m = "collect")
    /* renamed from: Sx$a */
    /* compiled from: StateFlow.kt */
    public static final class a extends C1148h7 {
        public Sx a;

        /* renamed from: a  reason: collision with other field name */
        public Tx f3792a;

        /* renamed from: a  reason: collision with other field name */
        public Object f3793a;

        /* renamed from: a  reason: collision with other field name */
        public Job f3794a;

        /* renamed from: a  reason: collision with other field name */
        public FlowCollector f3795a;
        public final /* synthetic */ Sx<T> b;

        /* renamed from: b  reason: collision with other field name */
        public /* synthetic */ Object f3796b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Sx<T> sx, Continuation<? super a> continuation) {
            super(continuation);
            this.b = sx;
        }

        public final Object invokeSuspend(Object obj) {
            this.f3796b = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.collect((FlowCollector) null, this);
        }
    }

    public Sx(Object obj) {
        this._state = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r1 = (defpackage.Tx[]) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r1 == null) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r2 = r1.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r4 >= r2) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r5 = r1[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        if (r5 == null) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r6 = defpackage.Tx.a;
        r7 = r6.get(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r7 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r8 = defpackage.r1.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r7 != r8) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        r9 = defpackage.r1.l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r7 != r9) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        if (r6.compareAndSet(r5, r7, r8) == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
        if (r6.get(r5) == r7) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r6 == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
        if (r6.compareAndSet(r5, r7, r9) == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        if (r6.get(r5) == r7) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0066, code lost:
        if (r6 == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0068, code lost:
        ((kotlinx.coroutines.c) r7).resumeWith(kotlin.Unit.a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r1 = r11.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0075, code lost:
        if (r1 != r12) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0077, code lost:
        r11.e = r12 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007a, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r12 = r11.a;
        r2 = kotlin.Unit.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0080, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
        r10 = r1;
        r1 = r12;
        r12 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0004
            zD r12 = defpackage.r1.h
        L_0x0004:
            monitor-enter(r11)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a     // Catch:{ all -> 0x008e }
            java.lang.Object r1 = r0.get(r11)     // Catch:{ all -> 0x008e }
            boolean r1 = defpackage.C1177ig.a(r1, r12)     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0014
            monitor-exit(r11)
            goto L_0x008d
        L_0x0014:
            r0.set(r11, r12)     // Catch:{ all -> 0x008e }
            int r12 = r11.e     // Catch:{ all -> 0x008e }
            r0 = r12 & 1
            if (r0 != 0) goto L_0x0088
            r0 = 1
            int r12 = r12 + r0
            r11.e = r12     // Catch:{ all -> 0x008e }
            S[] r1 = r11.a     // Catch:{ all -> 0x008e }
            kotlin.Unit r2 = kotlin.Unit.a     // Catch:{ all -> 0x008e }
            monitor-exit(r11)
        L_0x0026:
            Tx[] r1 = (defpackage.Tx[]) r1
            if (r1 == 0) goto L_0x0072
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L_0x002d:
            if (r4 >= r2) goto L_0x0072
            r5 = r1[r4]
            if (r5 == 0) goto L_0x006f
        L_0x0033:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = defpackage.Tx.a
            java.lang.Object r7 = r6.get(r5)
            if (r7 != 0) goto L_0x003c
            goto L_0x006f
        L_0x003c:
            zD r8 = defpackage.r1.m
            if (r7 != r8) goto L_0x0041
            goto L_0x006f
        L_0x0041:
            zD r9 = defpackage.r1.l
            if (r7 != r9) goto L_0x0057
        L_0x0045:
            boolean r9 = r6.compareAndSet(r5, r7, r8)
            if (r9 == 0) goto L_0x004d
            r6 = r0
            goto L_0x0054
        L_0x004d:
            java.lang.Object r9 = r6.get(r5)
            if (r9 == r7) goto L_0x0045
            r6 = r3
        L_0x0054:
            if (r6 == 0) goto L_0x0033
            goto L_0x006f
        L_0x0057:
            boolean r8 = r6.compareAndSet(r5, r7, r9)
            if (r8 == 0) goto L_0x005f
            r6 = r0
            goto L_0x0066
        L_0x005f:
            java.lang.Object r8 = r6.get(r5)
            if (r8 == r7) goto L_0x0057
            r6 = r3
        L_0x0066:
            if (r6 == 0) goto L_0x0033
            kotlinx.coroutines.c r7 = (kotlinx.coroutines.c) r7
            kotlin.Unit r5 = kotlin.Unit.a
            r7.resumeWith(r5)
        L_0x006f:
            int r4 = r4 + 1
            goto L_0x002d
        L_0x0072:
            monitor-enter(r11)
            int r1 = r11.e     // Catch:{ all -> 0x0085 }
            if (r1 != r12) goto L_0x007c
            int r12 = r12 + r0
            r11.e = r12     // Catch:{ all -> 0x0085 }
            monitor-exit(r11)
            goto L_0x008d
        L_0x007c:
            S[] r12 = r11.a     // Catch:{ all -> 0x0085 }
            kotlin.Unit r2 = kotlin.Unit.a     // Catch:{ all -> 0x0085 }
            monitor-exit(r11)
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x0026
        L_0x0085:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        L_0x0088:
            int r12 = r12 + 2
            r11.e = r12     // Catch:{ all -> 0x008e }
            monitor-exit(r11)
        L_0x008d:
            return
        L_0x008e:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Sx.a(java.lang.Object):void");
    }

    public final T b() {
        T t = r1.h;
        T t2 = a.get(this);
        if (t2 == t) {
            return null;
        }
        return t2;
    }

    /* JADX WARNING: type inference failed for: r2v16, types: [kotlin.coroutines.CoroutineContext$b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d6 A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f1 A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f3 A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0106 A[Catch:{ all -> 0x00e2 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107 A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011a A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011c A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011f A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r18, kotlin.coroutines.Continuation<?> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            boolean r3 = r2 instanceof defpackage.Sx.a
            if (r3 == 0) goto L_0x0019
            r3 = r2
            Sx$a r3 = (defpackage.Sx.a) r3
            int r4 = r3.c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.c = r4
            goto L_0x001e
        L_0x0019:
            Sx$a r3 = new Sx$a
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f3796b
            v7 r4 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r5 = r3.c
            r6 = 2
            r7 = 3
            r8 = 0
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x0061
            if (r5 == r9) goto L_0x0057
            if (r5 == r6) goto L_0x0048
            if (r5 != r7) goto L_0x0040
            java.lang.Object r0 = r3.f3793a
            kotlinx.coroutines.Job r5 = r3.f3794a
            Tx r11 = r3.f3792a
            kotlinx.coroutines.flow.FlowCollector r12 = r3.f3795a
            Sx r13 = r3.a
            defpackage.r1.R(r2)     // Catch:{ all -> 0x00e2 }
            goto L_0x00ce
        L_0x0040:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0048:
            java.lang.Object r0 = r3.f3793a
            kotlinx.coroutines.Job r5 = r3.f3794a
            Tx r11 = r3.f3792a
            kotlinx.coroutines.flow.FlowCollector r12 = r3.f3795a
            Sx r13 = r3.a
            defpackage.r1.R(r2)     // Catch:{ all -> 0x00e2 }
            goto L_0x0108
        L_0x0057:
            Tx r11 = r3.f3792a
            kotlinx.coroutines.flow.FlowCollector r0 = r3.f3795a
            Sx r13 = r3.a
            defpackage.r1.R(r2)     // Catch:{ all -> 0x00e2 }
            goto L_0x00bf
        L_0x0061:
            defpackage.r1.R(r2)
            monitor-enter(r17)
            S[] r2 = r1.a     // Catch:{ all -> 0x0177 }
            if (r2 != 0) goto L_0x006e
            Tx[] r2 = new defpackage.Tx[r6]     // Catch:{ all -> 0x0177 }
            r1.a = r2     // Catch:{ all -> 0x0177 }
            goto L_0x0085
        L_0x006e:
            int r5 = r1.c     // Catch:{ all -> 0x0177 }
            int r11 = r2.length     // Catch:{ all -> 0x0177 }
            if (r5 < r11) goto L_0x0085
            int r5 = r2.length     // Catch:{ all -> 0x0177 }
            int r5 = r5 * r6
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r5)     // Catch:{ all -> 0x0177 }
            java.lang.String r5 = "copyOf(this, newSize)"
            defpackage.C1177ig.e(r2, r5)     // Catch:{ all -> 0x0177 }
            r5 = r2
            s[] r5 = (defpackage.C1378s[]) r5     // Catch:{ all -> 0x0177 }
            r1.a = r5     // Catch:{ all -> 0x0177 }
            s[] r2 = (defpackage.C1378s[]) r2     // Catch:{ all -> 0x0177 }
        L_0x0085:
            int r5 = r1.d     // Catch:{ all -> 0x0177 }
        L_0x0087:
            r11 = r2[r5]     // Catch:{ all -> 0x0177 }
            if (r11 != 0) goto L_0x0092
            Tx r11 = new Tx     // Catch:{ all -> 0x0177 }
            r11.<init>()     // Catch:{ all -> 0x0177 }
            r2[r5] = r11     // Catch:{ all -> 0x0177 }
        L_0x0092:
            int r5 = r5 + 1
            int r12 = r2.length     // Catch:{ all -> 0x0177 }
            if (r5 < r12) goto L_0x0098
            r5 = r10
        L_0x0098:
            boolean r12 = r11.a(r1)     // Catch:{ all -> 0x0177 }
            if (r12 == 0) goto L_0x0087
            r1.d = r5     // Catch:{ all -> 0x0177 }
            int r2 = r1.c     // Catch:{ all -> 0x0177 }
            int r2 = r2 + r9
            r1.c = r2     // Catch:{ all -> 0x0177 }
            monitor-exit(r17)
            Tx r11 = (defpackage.Tx) r11
            boolean r2 = r0 instanceof defpackage.C1523zy     // Catch:{ all -> 0x015d }
            if (r2 == 0) goto L_0x00be
            r2 = r0
            zy r2 = (defpackage.C1523zy) r2     // Catch:{ all -> 0x015d }
            r3.a = r1     // Catch:{ all -> 0x015d }
            r3.f3795a = r0     // Catch:{ all -> 0x015d }
            r3.f3792a = r11     // Catch:{ all -> 0x015d }
            r3.c = r9     // Catch:{ all -> 0x015d }
            kotlin.Unit r2 = r2.b(r3)     // Catch:{ all -> 0x015d }
            if (r2 != r4) goto L_0x00be
            return r4
        L_0x00be:
            r13 = r1
        L_0x00bf:
            kotlin.coroutines.CoroutineContext r2 = r3.getContext()     // Catch:{ all -> 0x00e2 }
            kotlinx.coroutines.Job$b r5 = kotlinx.coroutines.Job.b.a     // Catch:{ all -> 0x00e2 }
            kotlin.coroutines.CoroutineContext$b r2 = r2.b(r5)     // Catch:{ all -> 0x00e2 }
            r5 = r2
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5     // Catch:{ all -> 0x00e2 }
            r12 = r0
            r0 = r8
        L_0x00ce:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = a     // Catch:{ all -> 0x00e2 }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ all -> 0x00e2 }
            if (r5 == 0) goto L_0x00e5
            boolean r14 = r5.isActive()     // Catch:{ all -> 0x00e2 }
            if (r14 == 0) goto L_0x00dd
            goto L_0x00e5
        L_0x00dd:
            java.util.concurrent.CancellationException r0 = r5.e()     // Catch:{ all -> 0x00e2 }
            throw r0     // Catch:{ all -> 0x00e2 }
        L_0x00e2:
            r0 = move-exception
            goto L_0x015f
        L_0x00e5:
            if (r0 == 0) goto L_0x00ed
            boolean r14 = defpackage.C1177ig.a(r0, r2)     // Catch:{ all -> 0x00e2 }
            if (r14 != 0) goto L_0x0108
        L_0x00ed:
            zD r0 = defpackage.r1.h     // Catch:{ all -> 0x00e2 }
            if (r2 != r0) goto L_0x00f3
            r0 = r8
            goto L_0x00f4
        L_0x00f3:
            r0 = r2
        L_0x00f4:
            r3.a = r13     // Catch:{ all -> 0x00e2 }
            r3.f3795a = r12     // Catch:{ all -> 0x00e2 }
            r3.f3792a = r11     // Catch:{ all -> 0x00e2 }
            r3.f3794a = r5     // Catch:{ all -> 0x00e2 }
            r3.f3793a = r2     // Catch:{ all -> 0x00e2 }
            r3.c = r6     // Catch:{ all -> 0x00e2 }
            java.lang.Object r0 = r12.emit(r0, r3)     // Catch:{ all -> 0x00e2 }
            if (r0 != r4) goto L_0x0107
            return r4
        L_0x0107:
            r0 = r2
        L_0x0108:
            r11.getClass()     // Catch:{ all -> 0x00e2 }
            zD r2 = defpackage.r1.l     // Catch:{ all -> 0x00e2 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = defpackage.Tx.a     // Catch:{ all -> 0x00e2 }
            java.lang.Object r14 = r14.getAndSet(r11, r2)     // Catch:{ all -> 0x00e2 }
            defpackage.C1177ig.c(r14)     // Catch:{ all -> 0x00e2 }
            zD r15 = defpackage.r1.m     // Catch:{ all -> 0x00e2 }
            if (r14 != r15) goto L_0x011c
            r14 = r9
            goto L_0x011d
        L_0x011c:
            r14 = r10
        L_0x011d:
            if (r14 != 0) goto L_0x00ce
            r3.a = r13     // Catch:{ all -> 0x00e2 }
            r3.f3795a = r12     // Catch:{ all -> 0x00e2 }
            r3.f3792a = r11     // Catch:{ all -> 0x00e2 }
            r3.f3794a = r5     // Catch:{ all -> 0x00e2 }
            r3.f3793a = r0     // Catch:{ all -> 0x00e2 }
            r3.c = r7     // Catch:{ all -> 0x00e2 }
            kotlinx.coroutines.c r14 = new kotlinx.coroutines.c     // Catch:{ all -> 0x00e2 }
            kotlin.coroutines.Continuation r15 = defpackage.r1.B(r3)     // Catch:{ all -> 0x00e2 }
            r14.<init>(r9, r15)     // Catch:{ all -> 0x00e2 }
            r14.s()     // Catch:{ all -> 0x00e2 }
        L_0x0137:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r15 = defpackage.Tx.a     // Catch:{ all -> 0x00e2 }
            boolean r16 = r15.compareAndSet(r11, r2, r14)     // Catch:{ all -> 0x00e2 }
            if (r16 == 0) goto L_0x0141
            r2 = r9
            goto L_0x0148
        L_0x0141:
            java.lang.Object r15 = r15.get(r11)     // Catch:{ all -> 0x00e2 }
            if (r15 == r2) goto L_0x0137
            r2 = r10
        L_0x0148:
            if (r2 != 0) goto L_0x014f
            kotlin.Unit r2 = kotlin.Unit.a     // Catch:{ all -> 0x00e2 }
            r14.resumeWith(r2)     // Catch:{ all -> 0x00e2 }
        L_0x014f:
            java.lang.Object r2 = r14.r()     // Catch:{ all -> 0x00e2 }
            v7 r14 = defpackage.C1438v7.COROUTINE_SUSPENDED     // Catch:{ all -> 0x00e2 }
            if (r2 != r14) goto L_0x0158
            goto L_0x015a
        L_0x0158:
            kotlin.Unit r2 = kotlin.Unit.a     // Catch:{ all -> 0x00e2 }
        L_0x015a:
            if (r2 != r4) goto L_0x00ce
            return r4
        L_0x015d:
            r0 = move-exception
            r13 = r1
        L_0x015f:
            monitor-enter(r13)
            int r2 = r13.c     // Catch:{ all -> 0x0174 }
            int r2 = r2 + -1
            r13.c = r2     // Catch:{ all -> 0x0174 }
            if (r2 != 0) goto L_0x016a
            r13.d = r10     // Catch:{ all -> 0x0174 }
        L_0x016a:
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>"
            defpackage.C1177ig.d(r11, r2)     // Catch:{ all -> 0x0174 }
            r11.b(r13)     // Catch:{ all -> 0x0174 }
            monitor-exit(r13)
            throw r0
        L_0x0174:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        L_0x0177:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Sx.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object emit(T t, Continuation<? super Unit> continuation) {
        a(t);
        return Unit.a;
    }
}
