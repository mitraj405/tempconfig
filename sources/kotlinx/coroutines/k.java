package kotlinx.coroutines;

import defpackage.C1302oi;
import in.juspay.hyper.constants.LogCategory;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

/* compiled from: JobSupport.kt */
public class k implements Job, C0815c5, C0507Fo {
    public static final AtomicReferenceFieldUpdater a;
    public static final AtomicReferenceFieldUpdater b;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* compiled from: JobSupport.kt */
    public static final class a<T> extends c<T> {
        public final k a;

        public a(Continuation continuation, C0617O5 o5) {
            super(1, continuation);
            this.a = o5;
        }

        public final Throwable q(k kVar) {
            Throwable c;
            Object S = this.a.S();
            if ((S instanceof c) && (c = ((c) S).c()) != null) {
                return c;
            }
            if (S instanceof C0677S5) {
                return ((C0677S5) S).f3789a;
            }
            return kVar.e();
        }

        public final String y() {
            return "AwaitContinuation";
        }
    }

    /* compiled from: JobSupport.kt */
    public static final class b extends C0610Ng {
        public final C0796b5 a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f5565a;

        /* renamed from: a  reason: collision with other field name */
        public final c f5566a;
        public final k b;

        public b(k kVar, c cVar, C0796b5 b5Var, Object obj) {
            this.b = kVar;
            this.f5566a = cVar;
            this.a = b5Var;
            this.f5565a = obj;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            l((Throwable) obj);
            return Unit.a;
        }

        public final void l(Throwable th) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k.a;
            k kVar = this.b;
            kVar.getClass();
            C0796b5 c0 = k.c0(this.a);
            c cVar = this.f5566a;
            Object obj = this.f5565a;
            if (c0 == null || !kVar.l0(cVar, c0, obj)) {
                kVar.v(kVar.K(cVar, obj));
            }
        }
    }

    /* compiled from: JobSupport.kt */
    public static final class c implements C0449Af {
        public static final AtomicIntegerFieldUpdater a;

        /* renamed from: a  reason: collision with other field name */
        public static final AtomicReferenceFieldUpdater f5567a;
        public static final AtomicReferenceFieldUpdater b;
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting = 0;
        private volatile Object _rootCause;

        /* renamed from: a  reason: collision with other field name */
        public final Rm f5568a;

        static {
            Class<c> cls = c.class;
            a = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting");
            Class<Object> cls2 = Object.class;
            f5567a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause");
            b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder");
        }

        public c(Rm rm, Throwable th) {
            this.f5568a = rm;
            this._rootCause = th;
        }

        public final void a(Throwable th) {
            Throwable c = c();
            if (c == null) {
                f5567a.set(this, th);
            } else if (th != c) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj == null) {
                    atomicReferenceFieldUpdater.set(this, th);
                } else if (obj instanceof Throwable) {
                    if (th != obj) {
                        ArrayList arrayList = new ArrayList(4);
                        arrayList.add(obj);
                        arrayList.add(th);
                        atomicReferenceFieldUpdater.set(this, arrayList);
                    }
                } else if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
        }

        public final Rm b() {
            return this.f5568a;
        }

        public final Throwable c() {
            return (Throwable) f5567a.get(this);
        }

        public final boolean d() {
            if (c() != null) {
                return true;
            }
            return false;
        }

        public final boolean e() {
            if (a.get(this) != 0) {
                return true;
            }
            return false;
        }

        public final ArrayList f(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else if (obj instanceof ArrayList) {
                arrayList = (ArrayList) obj;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            Throwable c = c();
            if (c != null) {
                arrayList.add(0, c);
            }
            if (th != null && !C1177ig.a(th, c)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, C1354qp.e);
            return arrayList;
        }

        public final boolean isActive() {
            if (c() == null) {
                return true;
            }
            return false;
        }

        public final String toString() {
            return "Finishing[cancelling=" + d() + ", completing=" + e() + ", rootCause=" + c() + ", exceptions=" + b.get(this) + ", list=" + this.f5568a + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    public static final class d extends C1302oi.a {
        public final /* synthetic */ Object a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ k f5569a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(C1302oi oiVar, k kVar, Object obj) {
            super(oiVar);
            this.f5569a = kVar;
            this.a = obj;
        }

        public final C0422zD c(Object obj) {
            boolean z;
            C1302oi oiVar = (C1302oi) obj;
            if (this.f5569a.S() == this.a) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return null;
            }
            return C1354qp.f;
        }
    }

    static {
        Class<k> cls = k.class;
        Class<Object> cls2 = Object.class;
        a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public k(boolean z) {
        C1402ta taVar;
        if (z) {
            taVar = C1354qp.b;
        } else {
            taVar = C1354qp.f6912a;
        }
        this._state = taVar;
    }

    public static C0796b5 c0(C1302oi oiVar) {
        while (oiVar.k()) {
            oiVar = oiVar.j();
        }
        while (true) {
            oiVar = oiVar.i();
            if (!oiVar.k()) {
                if (oiVar instanceof C0796b5) {
                    return (C0796b5) oiVar;
                }
                if (oiVar instanceof Rm) {
                    return null;
                }
            }
        }
    }

    public static String j0(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.d()) {
                return "Cancelling";
            }
            if (cVar.e()) {
                return "Completing";
            }
        } else if (obj instanceof C0449Af) {
            if (((C0449Af) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof C0677S5) {
            return "Cancelled";
        } else {
            return "Completed";
        }
        return "Active";
    }

    public final boolean B(Throwable th) {
        if (Y()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        C0778a5 a5Var = (C0778a5) b.get(this);
        if (a5Var == null || a5Var == Sm.a) {
            return z;
        }
        if (a5Var.f(th) || z) {
            return true;
        }
        return false;
    }

    public final <R> R C(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        C1177ig.f(function2, "operation");
        return function2.invoke(r, this);
    }

    public String D() {
        return "Job was cancelled";
    }

    public boolean F(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!w(th) || !N()) {
            return false;
        }
        return true;
    }

    public final void H(C0449Af af, Object obj) {
        C0677S5 s5;
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        C0778a5 a5Var = (C0778a5) atomicReferenceFieldUpdater.get(this);
        if (a5Var != null) {
            a5Var.h();
            atomicReferenceFieldUpdater.set(this, Sm.a);
        }
        V5 v5 = null;
        if (obj instanceof C0677S5) {
            s5 = (C0677S5) obj;
        } else {
            s5 = null;
        }
        if (s5 != null) {
            th = s5.f3789a;
        } else {
            th = null;
        }
        if (af instanceof C0610Ng) {
            try {
                ((C0610Ng) af).l(th);
            } catch (Throwable th2) {
                U(new V5("Exception in completion handler " + af + " for " + this, th2));
            }
        } else {
            Rm b2 = af.b();
            if (b2 != null) {
                Object g = b2.g();
                C1177ig.d(g, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                for (C1302oi oiVar = (C1302oi) g; !C1177ig.a(oiVar, b2); oiVar = oiVar.i()) {
                    if (oiVar instanceof C0610Ng) {
                        C0610Ng ng = (C0610Ng) oiVar;
                        try {
                            ng.l(th);
                        } catch (Throwable th3) {
                            if (v5 != null) {
                                C1354qp.g(v5, th3);
                            } else {
                                v5 = new V5("Exception in completion handler " + ng + " for " + this, th3);
                                Unit unit = Unit.a;
                            }
                        }
                    }
                }
                if (v5 != null) {
                    U(v5);
                }
            }
        }
    }

    public final Throwable I(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof Throwable;
        }
        if (z) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new Kg(D(), (Throwable) null, this);
            }
            return th;
        }
        C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((C0507Fo) obj).O();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cb A[LOOP:2: B:56:0x00cb->B:59:0x00d6, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object K(kotlinx.coroutines.k.c r9, java.lang.Object r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof defpackage.C0677S5
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r10
            S5 r0 = (defpackage.C0677S5) r0
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 == 0) goto L_0x000f
            java.lang.Throwable r0 = r0.f3789a
            goto L_0x0010
        L_0x000f:
            r0 = r1
        L_0x0010:
            monitor-enter(r9)
            r9.d()     // Catch:{ all -> 0x00dc }
            java.util.ArrayList r2 = r9.f(r0)     // Catch:{ all -> 0x00dc }
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x00dc }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0031
            boolean r3 = r9.d()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x0053
            Kg r3 = new Kg     // Catch:{ all -> 0x00dc }
            java.lang.String r6 = r8.D()     // Catch:{ all -> 0x00dc }
            r3.<init>(r6, r1, r8)     // Catch:{ all -> 0x00dc }
            r1 = r3
            goto L_0x0053
        L_0x0031:
            java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x00dc }
        L_0x0035:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x0048
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x00dc }
            r7 = r6
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ all -> 0x00dc }
            boolean r7 = r7 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x00dc }
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x0035
            r1 = r6
        L_0x0048:
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00dc }
            if (r1 == 0) goto L_0x004d
            goto L_0x0053
        L_0x004d:
            java.lang.Object r1 = r2.get(r5)     // Catch:{ all -> 0x00dc }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00dc }
        L_0x0053:
            if (r1 == 0) goto L_0x008b
            int r3 = r2.size()     // Catch:{ all -> 0x00dc }
            if (r3 > r4) goto L_0x005c
            goto L_0x008b
        L_0x005c:
            int r3 = r2.size()     // Catch:{ all -> 0x00dc }
            java.util.IdentityHashMap r6 = new java.util.IdentityHashMap     // Catch:{ all -> 0x00dc }
            r6.<init>(r3)     // Catch:{ all -> 0x00dc }
            java.util.Set r3 = java.util.Collections.newSetFromMap(r6)     // Catch:{ all -> 0x00dc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00dc }
        L_0x006d:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x008b
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x00dc }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00dc }
            if (r6 == r1) goto L_0x006d
            if (r6 == r1) goto L_0x006d
            boolean r7 = r6 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x00dc }
            if (r7 != 0) goto L_0x006d
            boolean r7 = r3.add(r6)     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x006d
            defpackage.C1354qp.g(r1, r6)     // Catch:{ all -> 0x00dc }
            goto L_0x006d
        L_0x008b:
            monitor-exit(r9)
            if (r1 != 0) goto L_0x008f
            goto L_0x0097
        L_0x008f:
            if (r1 != r0) goto L_0x0092
            goto L_0x0097
        L_0x0092:
            S5 r10 = new S5
            r10.<init>(r5, r1)
        L_0x0097:
            if (r1 == 0) goto L_0x00b8
            boolean r0 = r8.B(r1)
            if (r0 != 0) goto L_0x00a8
            boolean r0 = r8.T(r1)
            if (r0 == 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r0 = r5
            goto L_0x00a9
        L_0x00a8:
            r0 = r4
        L_0x00a9:
            if (r0 == 0) goto L_0x00b8
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally"
            defpackage.C1177ig.d(r10, r0)
            r0 = r10
            S5 r0 = (defpackage.C0677S5) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = defpackage.C0677S5.a
            r1.compareAndSet(r0, r5, r4)
        L_0x00b8:
            r8.e0(r10)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = a
            boolean r1 = r10 instanceof defpackage.C0449Af
            if (r1 == 0) goto L_0x00ca
            Bf r1 = new Bf
            r2 = r10
            Af r2 = (defpackage.C0449Af) r2
            r1.<init>(r2)
            goto L_0x00cb
        L_0x00ca:
            r1 = r10
        L_0x00cb:
            boolean r2 = r0.compareAndSet(r8, r9, r1)
            if (r2 == 0) goto L_0x00d2
            goto L_0x00d8
        L_0x00d2:
            java.lang.Object r2 = r0.get(r8)
            if (r2 == r9) goto L_0x00cb
        L_0x00d8:
            r8.H(r9, r10)
            return r10
        L_0x00dc:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.k.K(kotlinx.coroutines.k$c, java.lang.Object):java.lang.Object");
    }

    public final Object M() {
        Object S = S();
        if (!(!(S instanceof C0449Af))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(S instanceof C0677S5)) {
            return C1354qp.L0(S);
        } else {
            throw ((C0677S5) S).f3789a;
        }
    }

    public boolean N() {
        return true;
    }

    public final CancellationException O() {
        Throwable th;
        Object S = S();
        CancellationException cancellationException = null;
        if (S instanceof c) {
            th = ((c) S).c();
        } else if (S instanceof C0677S5) {
            th = ((C0677S5) S).f3789a;
        } else if (!(S instanceof C0449Af)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + S).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException == null) {
            return new Kg("Parent job is ".concat(j0(S)), th, this);
        }
        return cancellationException;
    }

    public boolean P() {
        return this instanceof C0617O5;
    }

    public final Rm R(C0449Af af) {
        Rm b2 = af.b();
        if (b2 != null) {
            return b2;
        }
        if (af instanceof C1402ta) {
            return new Rm();
        }
        if (af instanceof C0610Ng) {
            h0((C0610Ng) af);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + af).toString());
    }

    public final Object S() {
        while (true) {
            Object obj = a.get(this);
            if (!(obj instanceof C1138go)) {
                return obj;
            }
            ((C1138go) obj).a(this);
        }
    }

    public boolean T(Throwable th) {
        return false;
    }

    public final void V(Job job) {
        Sm sm = Sm.a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, sm);
            return;
        }
        job.start();
        C0778a5 z = job.z(this);
        atomicReferenceFieldUpdater.set(this, z);
        if (!(S() instanceof C0449Af)) {
            z.h();
            atomicReferenceFieldUpdater.set(this, sm);
        }
    }

    public final C1276n9 W(Function1<? super Throwable, Unit> function1) {
        return m0(false, true, function1);
    }

    public boolean Y() {
        return this instanceof C0730W2;
    }

    public final CoroutineContext.c<?> Z() {
        return Job.b.a;
    }

    public final Job a() {
        C0778a5 a5Var = (C0778a5) b.get(this);
        if (a5Var != null) {
            return a5Var.a();
        }
        return null;
    }

    public final Object a0(Object obj) {
        Object k0;
        C0677S5 s5;
        do {
            k0 = k0(S(), obj);
            if (k0 == C1354qp.f6914a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (obj instanceof C0677S5) {
                    s5 = (C0677S5) obj;
                } else {
                    s5 = null;
                }
                if (s5 != null) {
                    th = s5.f3789a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (k0 == C1354qp.c);
        return k0;
    }

    public final <E extends CoroutineContext.b> E b(CoroutineContext.c<E> cVar) {
        return CoroutineContext.b.a.a(this, cVar);
    }

    public String b0() {
        return getClass().getSimpleName();
    }

    public void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new Kg(D(), (Throwable) null, this);
        }
        y(cancellationException);
    }

    public final void d0(Rm rm, Throwable th) {
        Object g = rm.g();
        C1177ig.d(g, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        V5 v5 = null;
        for (C1302oi oiVar = (C1302oi) g; !C1177ig.a(oiVar, rm); oiVar = oiVar.i()) {
            if (oiVar instanceof Lg) {
                C0610Ng ng = (C0610Ng) oiVar;
                try {
                    ng.l(th);
                } catch (Throwable th2) {
                    if (v5 != null) {
                        C1354qp.g(v5, th2);
                    } else {
                        v5 = new V5("Exception in completion handler " + ng + " for " + this, th2);
                        Unit unit = Unit.a;
                    }
                }
            }
        }
        if (v5 != null) {
            U(v5);
        }
        B(th);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.util.concurrent.CancellationException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.concurrent.CancellationException e() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.S()
            boolean r1 = r0 instanceof kotlinx.coroutines.k.c
            r2 = 0
            java.lang.String r3 = "Job is still new or active: "
            if (r1 == 0) goto L_0x004c
            kotlinx.coroutines.k$c r0 = (kotlinx.coroutines.k.c) r0
            java.lang.Throwable r0 = r0.c()
            if (r0 == 0) goto L_0x0036
            java.lang.Class r1 = r4.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r3 = " is cancelling"
            java.lang.String r1 = r1.concat(r3)
            boolean r3 = r0 instanceof java.util.concurrent.CancellationException
            if (r3 == 0) goto L_0x0028
            r2 = r0
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L_0x0028:
            if (r2 != 0) goto L_0x0080
            Kg r2 = new Kg
            if (r1 != 0) goto L_0x0032
            java.lang.String r1 = r4.D()
        L_0x0032:
            r2.<init>(r1, r0, r4)
            goto L_0x0080
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x004c:
            boolean r1 = r0 instanceof defpackage.C0449Af
            if (r1 != 0) goto L_0x0081
            boolean r1 = r0 instanceof defpackage.C0677S5
            if (r1 == 0) goto L_0x006c
            S5 r0 = (defpackage.C0677S5) r0
            java.lang.Throwable r0 = r0.f3789a
            boolean r1 = r0 instanceof java.util.concurrent.CancellationException
            if (r1 == 0) goto L_0x005f
            r2 = r0
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
        L_0x005f:
            if (r2 != 0) goto L_0x0080
            Kg r1 = new Kg
            java.lang.String r2 = r4.D()
            r1.<init>(r2, r0, r4)
            r2 = r1
            goto L_0x0080
        L_0x006c:
            Kg r0 = new Kg
            java.lang.Class r1 = r4.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r3 = " has completed normally"
            java.lang.String r1 = r1.concat(r3)
            r0.<init>(r1, r2, r4)
            r2 = r0
        L_0x0080:
            return r2
        L_0x0081:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.k.e():java.util.concurrent.CancellationException");
    }

    public final void h0(C0610Ng ng) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z;
        Rm rm = new Rm();
        ng.getClass();
        C1302oi.b.lazySet(rm, ng);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C1302oi.a;
        atomicReferenceFieldUpdater2.lazySet(rm, ng);
        while (true) {
            if (ng.g() == ng) {
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(ng, ng, rm)) {
                        if (atomicReferenceFieldUpdater2.get(ng) != ng) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
                if (z) {
                    rm.e(ng);
                    break;
                }
            } else {
                break;
            }
        }
        C1302oi i = ng.i();
        do {
            atomicReferenceFieldUpdater = a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, ng, i) || atomicReferenceFieldUpdater.get(this) != ng) {
            }
            atomicReferenceFieldUpdater = a;
            return;
        } while (atomicReferenceFieldUpdater.get(this) != ng);
    }

    public final int i0(Object obj) {
        boolean z = obj instanceof C1402ta;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        boolean z2 = false;
        if (z) {
            if (((C1402ta) obj).a) {
                return 0;
            }
            C1402ta taVar = C1354qp.b;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, taVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                } else {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                return -1;
            }
            g0();
            return 1;
        } else if (!(obj instanceof C1514zf)) {
            return 0;
        } else {
            Rm rm = ((C1514zf) obj).a;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, rm)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                } else {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                return -1;
            }
            g0();
            return 1;
        }
    }

    public boolean isActive() {
        Object S = S();
        if (!(S instanceof C0449Af) || !((C0449Af) S).isActive()) {
            return false;
        }
        return true;
    }

    public final boolean isCancelled() {
        Object S = S();
        if ((S instanceof C0677S5) || ((S instanceof c) && ((c) S).d())) {
            return true;
        }
        return false;
    }

    public final CoroutineContext j(CoroutineContext coroutineContext) {
        C1177ig.f(coroutineContext, LogCategory.CONTEXT);
        return CoroutineContext.a.a(this, coroutineContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00c1, code lost:
        if (r6 == null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00c3, code lost:
        d0(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c8, code lost:
        if ((r9 instanceof defpackage.C0796b5) == false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00ca, code lost:
        r0 = (defpackage.C0796b5) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00ce, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00cf, code lost:
        if (r0 != null) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00d1, code lost:
        r9 = r9.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d5, code lost:
        if (r9 == null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00d7, code lost:
        r4 = c0(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00dc, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00dd, code lost:
        if (r4 == null) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00e3, code lost:
        if (l0(r3, r4, r10) == false) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return K(r3, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        return defpackage.C1354qp.f6922b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k0(java.lang.Object r9, java.lang.Object r10) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof defpackage.C0449Af
            if (r0 != 0) goto L_0x0007
            zD r9 = defpackage.C1354qp.f6914a
            return r9
        L_0x0007:
            boolean r0 = r9 instanceof defpackage.C1402ta
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
            boolean r0 = r9 instanceof defpackage.C0610Ng
            if (r0 == 0) goto L_0x004c
        L_0x0011:
            boolean r0 = r9 instanceof defpackage.C0796b5
            if (r0 != 0) goto L_0x004c
            boolean r0 = r10 instanceof defpackage.C0677S5
            if (r0 != 0) goto L_0x004c
            r0 = r9
            Af r0 = (defpackage.C0449Af) r0
            boolean r9 = r10 instanceof defpackage.C0449Af
            if (r9 == 0) goto L_0x002a
            Bf r9 = new Bf
            r3 = r10
            Af r3 = (defpackage.C0449Af) r3
            r9.<init>(r3)
            r3 = r9
            goto L_0x002b
        L_0x002a:
            r3 = r10
        L_0x002b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = a
            boolean r4 = r9.compareAndSet(r8, r0, r3)
            if (r4 == 0) goto L_0x0035
            r9 = r1
            goto L_0x003c
        L_0x0035:
            java.lang.Object r9 = r9.get(r8)
            if (r9 == r0) goto L_0x002b
            r9 = r2
        L_0x003c:
            if (r9 != 0) goto L_0x0040
            r1 = r2
            goto L_0x0046
        L_0x0040:
            r8.e0(r10)
            r8.H(r0, r10)
        L_0x0046:
            if (r1 == 0) goto L_0x0049
            return r10
        L_0x0049:
            zD r9 = defpackage.C1354qp.c
            return r9
        L_0x004c:
            Af r9 = (defpackage.C0449Af) r9
            Rm r0 = r8.R(r9)
            if (r0 != 0) goto L_0x0058
            zD r9 = defpackage.C1354qp.c
            goto L_0x00ec
        L_0x0058:
            boolean r3 = r9 instanceof kotlinx.coroutines.k.c
            r4 = 0
            if (r3 == 0) goto L_0x0061
            r3 = r9
            kotlinx.coroutines.k$c r3 = (kotlinx.coroutines.k.c) r3
            goto L_0x0062
        L_0x0061:
            r3 = r4
        L_0x0062:
            if (r3 != 0) goto L_0x0069
            kotlinx.coroutines.k$c r3 = new kotlinx.coroutines.k$c
            r3.<init>(r0, r4)
        L_0x0069:
            Ks r5 = new Ks
            r5.<init>()
            monitor-enter(r3)
            boolean r6 = r3.e()     // Catch:{ all -> 0x00ed }
            if (r6 == 0) goto L_0x007a
            zD r9 = defpackage.C1354qp.f6914a     // Catch:{ all -> 0x00ed }
            monitor-exit(r3)
            goto L_0x00ec
        L_0x007a:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.k.c.a     // Catch:{ all -> 0x00ed }
            r6.set(r3, r1)     // Catch:{ all -> 0x00ed }
            if (r3 == r9) goto L_0x0097
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = a     // Catch:{ all -> 0x00ed }
        L_0x0083:
            boolean r7 = r6.compareAndSet(r8, r9, r3)     // Catch:{ all -> 0x00ed }
            if (r7 == 0) goto L_0x008b
            r2 = r1
            goto L_0x0091
        L_0x008b:
            java.lang.Object r7 = r6.get(r8)     // Catch:{ all -> 0x00ed }
            if (r7 == r9) goto L_0x0083
        L_0x0091:
            if (r2 != 0) goto L_0x0097
            zD r9 = defpackage.C1354qp.c     // Catch:{ all -> 0x00ed }
            monitor-exit(r3)
            goto L_0x00ec
        L_0x0097:
            boolean r2 = r3.d()     // Catch:{ all -> 0x00ed }
            boolean r6 = r10 instanceof defpackage.C0677S5     // Catch:{ all -> 0x00ed }
            if (r6 == 0) goto L_0x00a3
            r6 = r10
            S5 r6 = (defpackage.C0677S5) r6     // Catch:{ all -> 0x00ed }
            goto L_0x00a4
        L_0x00a3:
            r6 = r4
        L_0x00a4:
            if (r6 == 0) goto L_0x00ab
            java.lang.Throwable r6 = r6.f3789a     // Catch:{ all -> 0x00ed }
            r3.a(r6)     // Catch:{ all -> 0x00ed }
        L_0x00ab:
            java.lang.Throwable r6 = r3.c()     // Catch:{ all -> 0x00ed }
            r1 = r1 ^ r2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00ed }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ed }
            if (r1 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r6 = r4
        L_0x00bc:
            r5.a = r6     // Catch:{ all -> 0x00ed }
            kotlin.Unit r1 = kotlin.Unit.a     // Catch:{ all -> 0x00ed }
            monitor-exit(r3)
            if (r6 == 0) goto L_0x00c6
            r8.d0(r0, r6)
        L_0x00c6:
            boolean r0 = r9 instanceof defpackage.C0796b5
            if (r0 == 0) goto L_0x00ce
            r0 = r9
            b5 r0 = (defpackage.C0796b5) r0
            goto L_0x00cf
        L_0x00ce:
            r0 = r4
        L_0x00cf:
            if (r0 != 0) goto L_0x00dc
            Rm r9 = r9.b()
            if (r9 == 0) goto L_0x00dd
            b5 r4 = c0(r9)
            goto L_0x00dd
        L_0x00dc:
            r4 = r0
        L_0x00dd:
            if (r4 == 0) goto L_0x00e8
            boolean r9 = r8.l0(r3, r4, r10)
            if (r9 == 0) goto L_0x00e8
            zD r9 = defpackage.C1354qp.f6922b
            goto L_0x00ec
        L_0x00e8:
            java.lang.Object r9 = r8.K(r3, r10)
        L_0x00ec:
            return r9
        L_0x00ed:
            r9 = move-exception
            monitor-exit(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.k.k0(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final CoroutineContext l(CoroutineContext.c<?> cVar) {
        return CoroutineContext.b.a.b(this, cVar);
    }

    public final boolean l0(c cVar, C0796b5 b5Var, Object obj) {
        do {
            if (Job.a.a(b5Var.a, false, new b(this, cVar, b5Var, obj), 1) != Sm.a) {
                return true;
            }
            b5Var = c0(b5Var);
        } while (b5Var != null);
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v9, types: [zf] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C1276n9 m0(boolean r8, boolean r9, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r10) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x0014
            boolean r1 = r10 instanceof defpackage.Lg
            if (r1 == 0) goto L_0x000b
            r1 = r10
            Lg r1 = (defpackage.Lg) r1
            goto L_0x000c
        L_0x000b:
            r1 = r0
        L_0x000c:
            if (r1 != 0) goto L_0x0025
            rg r1 = new rg
            r1.<init>(r10)
            goto L_0x0025
        L_0x0014:
            boolean r1 = r10 instanceof defpackage.C0610Ng
            if (r1 == 0) goto L_0x001c
            r1 = r10
            Ng r1 = (defpackage.C0610Ng) r1
            goto L_0x001d
        L_0x001c:
            r1 = r0
        L_0x001d:
            if (r1 == 0) goto L_0x0020
            goto L_0x0025
        L_0x0020:
            sg r1 = new sg
            r1.<init>(r10)
        L_0x0025:
            r1.a = r7
        L_0x0027:
            java.lang.Object r2 = r7.S()
            boolean r3 = r2 instanceof defpackage.C1402ta
            if (r3 == 0) goto L_0x006a
            r3 = r2
            ta r3 = (defpackage.C1402ta) r3
            boolean r4 = r3.a
            if (r4 == 0) goto L_0x004a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a
        L_0x0038:
            boolean r3 = r4.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L_0x0040
            r2 = 1
            goto L_0x0047
        L_0x0040:
            java.lang.Object r3 = r4.get(r7)
            if (r3 == r2) goto L_0x0038
            r2 = 0
        L_0x0047:
            if (r2 == 0) goto L_0x0027
            return r1
        L_0x004a:
            Rm r2 = new Rm
            r2.<init>()
            boolean r4 = r3.a
            if (r4 == 0) goto L_0x0054
            goto L_0x005a
        L_0x0054:
            zf r4 = new zf
            r4.<init>(r2)
            r2 = r4
        L_0x005a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a
            boolean r5 = r4.compareAndSet(r7, r3, r2)
            if (r5 == 0) goto L_0x0063
            goto L_0x0027
        L_0x0063:
            java.lang.Object r4 = r4.get(r7)
            if (r4 == r3) goto L_0x005a
            goto L_0x0027
        L_0x006a:
            boolean r3 = r2 instanceof defpackage.C0449Af
            if (r3 == 0) goto L_0x00c6
            r3 = r2
            Af r3 = (defpackage.C0449Af) r3
            Rm r3 = r3.b()
            if (r3 != 0) goto L_0x0082
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode"
            defpackage.C1177ig.d(r2, r3)
            Ng r2 = (defpackage.C0610Ng) r2
            r7.h0(r2)
            goto L_0x0027
        L_0x0082:
            Sm r4 = defpackage.Sm.a
            if (r8 == 0) goto L_0x00b6
            boolean r5 = r2 instanceof kotlinx.coroutines.k.c
            if (r5 == 0) goto L_0x00b6
            monitor-enter(r2)
            r5 = r2
            kotlinx.coroutines.k$c r5 = (kotlinx.coroutines.k.c) r5     // Catch:{ all -> 0x00b3 }
            java.lang.Throwable r5 = r5.c()     // Catch:{ all -> 0x00b3 }
            if (r5 == 0) goto L_0x00a1
            boolean r6 = r10 instanceof defpackage.C0796b5     // Catch:{ all -> 0x00b3 }
            if (r6 == 0) goto L_0x00af
            r6 = r2
            kotlinx.coroutines.k$c r6 = (kotlinx.coroutines.k.c) r6     // Catch:{ all -> 0x00b3 }
            boolean r6 = r6.e()     // Catch:{ all -> 0x00b3 }
            if (r6 != 0) goto L_0x00af
        L_0x00a1:
            boolean r4 = r7.u(r2, r3, r1)     // Catch:{ all -> 0x00b3 }
            if (r4 != 0) goto L_0x00aa
            monitor-exit(r2)
            goto L_0x0027
        L_0x00aa:
            if (r5 != 0) goto L_0x00ae
            monitor-exit(r2)
            return r1
        L_0x00ae:
            r4 = r1
        L_0x00af:
            kotlin.Unit r6 = kotlin.Unit.a     // Catch:{ all -> 0x00b3 }
            monitor-exit(r2)
            goto L_0x00b7
        L_0x00b3:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L_0x00b6:
            r5 = r0
        L_0x00b7:
            if (r5 == 0) goto L_0x00bf
            if (r9 == 0) goto L_0x00be
            r10.invoke(r5)
        L_0x00be:
            return r4
        L_0x00bf:
            boolean r2 = r7.u(r2, r3, r1)
            if (r2 == 0) goto L_0x0027
            return r1
        L_0x00c6:
            if (r9 == 0) goto L_0x00d7
            boolean r8 = r2 instanceof defpackage.C0677S5
            if (r8 == 0) goto L_0x00cf
            S5 r2 = (defpackage.C0677S5) r2
            goto L_0x00d0
        L_0x00cf:
            r2 = r0
        L_0x00d0:
            if (r2 == 0) goto L_0x00d4
            java.lang.Throwable r0 = r2.f3789a
        L_0x00d4:
            r10.invoke(r0)
        L_0x00d7:
            Sm r8 = defpackage.Sm.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.k.m0(boolean, boolean, kotlin.jvm.functions.Function1):n9");
    }

    public final boolean start() {
        int i0;
        do {
            i0 = i0(S());
            if (i0 == 0) {
                return false;
            }
        } while (i0 != 1);
        return true;
    }

    public final void t(k kVar) {
        w(kVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(b0() + '{' + j0(S()) + '}');
        sb.append('@');
        sb.append(C1149h8.a(this));
        return sb.toString();
    }

    public final boolean u(Object obj, Rm rm, C0610Ng ng) {
        boolean z;
        boolean z2;
        d dVar = new d(ng, this, obj);
        do {
            C1302oi j = rm.j();
            C1302oi.b.lazySet(ng, j);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1302oi.a;
            atomicReferenceFieldUpdater.lazySet(ng, rm);
            dVar.b = rm;
            while (true) {
                if (!atomicReferenceFieldUpdater.compareAndSet(j, rm, dVar)) {
                    if (atomicReferenceFieldUpdater.get(j) != rm) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                z2 = false;
            } else if (dVar.a(j) == null) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (z2) {
                return true;
            }
        } while (!z2);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00fd, code lost:
        r0 = r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00cd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x003f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(java.lang.Object r10) {
        /*
            r9 = this;
            zD r0 = defpackage.C1354qp.f6914a
            boolean r1 = r9.P()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0039
        L_0x000a:
            java.lang.Object r0 = r9.S()
            boolean r1 = r0 instanceof defpackage.C0449Af
            if (r1 == 0) goto L_0x0032
            boolean r1 = r0 instanceof kotlinx.coroutines.k.c
            if (r1 == 0) goto L_0x0020
            r1 = r0
            kotlinx.coroutines.k$c r1 = (kotlinx.coroutines.k.c) r1
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0020
            goto L_0x0032
        L_0x0020:
            S5 r1 = new S5
            java.lang.Throwable r4 = r9.I(r10)
            r1.<init>(r2, r4)
            java.lang.Object r0 = r9.k0(r0, r1)
            zD r1 = defpackage.C1354qp.c
            if (r0 == r1) goto L_0x000a
            goto L_0x0034
        L_0x0032:
            zD r0 = defpackage.C1354qp.f6914a
        L_0x0034:
            zD r1 = defpackage.C1354qp.f6922b
            if (r0 != r1) goto L_0x0039
            return r3
        L_0x0039:
            zD r1 = defpackage.C1354qp.f6914a
            if (r0 != r1) goto L_0x00fe
            r0 = 0
            r1 = r0
        L_0x003f:
            java.lang.Object r4 = r9.S()
            boolean r5 = r4 instanceof kotlinx.coroutines.k.c
            if (r5 == 0) goto L_0x0093
            monitor-enter(r4)
            r5 = r4
            kotlinx.coroutines.k$c r5 = (kotlinx.coroutines.k.c) r5     // Catch:{ all -> 0x0090 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.k.c.b     // Catch:{ all -> 0x0090 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x0090 }
            zD r6 = defpackage.C1354qp.e     // Catch:{ all -> 0x0090 }
            if (r5 != r6) goto L_0x0057
            r5 = r3
            goto L_0x0058
        L_0x0057:
            r5 = r2
        L_0x0058:
            if (r5 == 0) goto L_0x005f
            zD r10 = defpackage.C1354qp.d     // Catch:{ all -> 0x0090 }
            monitor-exit(r4)
            goto L_0x00fd
        L_0x005f:
            r5 = r4
            kotlinx.coroutines.k$c r5 = (kotlinx.coroutines.k.c) r5     // Catch:{ all -> 0x0090 }
            boolean r5 = r5.d()     // Catch:{ all -> 0x0090 }
            if (r10 != 0) goto L_0x006a
            if (r5 != 0) goto L_0x0076
        L_0x006a:
            if (r1 != 0) goto L_0x0070
            java.lang.Throwable r1 = r9.I(r10)     // Catch:{ all -> 0x0090 }
        L_0x0070:
            r10 = r4
            kotlinx.coroutines.k$c r10 = (kotlinx.coroutines.k.c) r10     // Catch:{ all -> 0x0090 }
            r10.a(r1)     // Catch:{ all -> 0x0090 }
        L_0x0076:
            r10 = r4
            kotlinx.coroutines.k$c r10 = (kotlinx.coroutines.k.c) r10     // Catch:{ all -> 0x0090 }
            java.lang.Throwable r10 = r10.c()     // Catch:{ all -> 0x0090 }
            r1 = r5 ^ 1
            if (r1 == 0) goto L_0x0082
            r0 = r10
        L_0x0082:
            monitor-exit(r4)
            if (r0 == 0) goto L_0x008c
            kotlinx.coroutines.k$c r4 = (kotlinx.coroutines.k.c) r4
            Rm r10 = r4.f5568a
            r9.d0(r10, r0)
        L_0x008c:
            zD r10 = defpackage.C1354qp.f6914a
            goto L_0x00fd
        L_0x0090:
            r10 = move-exception
            monitor-exit(r4)
            throw r10
        L_0x0093:
            boolean r5 = r4 instanceof defpackage.C0449Af
            if (r5 == 0) goto L_0x00fb
            if (r1 != 0) goto L_0x009d
            java.lang.Throwable r1 = r9.I(r10)
        L_0x009d:
            r5 = r4
            Af r5 = (defpackage.C0449Af) r5
            boolean r6 = r5.isActive()
            if (r6 == 0) goto L_0x00d0
            Rm r6 = r9.R(r5)
            if (r6 != 0) goto L_0x00ad
            goto L_0x00c5
        L_0x00ad:
            kotlinx.coroutines.k$c r7 = new kotlinx.coroutines.k$c
            r7.<init>(r6, r1)
        L_0x00b2:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a
            boolean r8 = r4.compareAndSet(r9, r5, r7)
            if (r8 == 0) goto L_0x00bc
            r4 = r3
            goto L_0x00c3
        L_0x00bc:
            java.lang.Object r4 = r4.get(r9)
            if (r4 == r5) goto L_0x00b2
            r4 = r2
        L_0x00c3:
            if (r4 != 0) goto L_0x00c7
        L_0x00c5:
            r4 = r2
            goto L_0x00cb
        L_0x00c7:
            r9.d0(r6, r1)
            r4 = r3
        L_0x00cb:
            if (r4 == 0) goto L_0x003f
            zD r10 = defpackage.C1354qp.f6914a
            goto L_0x00fd
        L_0x00d0:
            S5 r5 = new S5
            r5.<init>(r2, r1)
            java.lang.Object r5 = r9.k0(r4, r5)
            zD r6 = defpackage.C1354qp.f6914a
            if (r5 == r6) goto L_0x00e3
            zD r4 = defpackage.C1354qp.c
            if (r5 == r4) goto L_0x003f
            r0 = r5
            goto L_0x00fe
        L_0x00e3:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot happen in "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00fb:
            zD r10 = defpackage.C1354qp.d
        L_0x00fd:
            r0 = r10
        L_0x00fe:
            zD r10 = defpackage.C1354qp.f6914a
            if (r0 != r10) goto L_0x0103
            goto L_0x0110
        L_0x0103:
            zD r10 = defpackage.C1354qp.f6922b
            if (r0 != r10) goto L_0x0108
            goto L_0x0110
        L_0x0108:
            zD r10 = defpackage.C1354qp.d
            if (r0 != r10) goto L_0x010d
            goto L_0x0111
        L_0x010d:
            r9.v(r0)
        L_0x0110:
            r2 = r3
        L_0x0111:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.k.w(java.lang.Object):boolean");
    }

    public void y(CancellationException cancellationException) {
        w(cancellationException);
    }

    public final C0778a5 z(k kVar) {
        C1276n9 a2 = Job.a.a(this, true, new C0796b5(kVar), 2);
        C1177ig.d(a2, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (C0778a5) a2;
    }

    public void g0() {
    }

    public void U(V5 v5) {
        throw v5;
    }

    public void e0(Object obj) {
    }

    public void v(Object obj) {
    }
}
