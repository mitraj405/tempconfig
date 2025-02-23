package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

/* compiled from: CancellableContinuationImpl.kt */
public class c<T> extends g<T> implements CancellableContinuation<T>, CoroutineStackFrame, C1256mD {
    public static final AtomicIntegerFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f5561a;
    public static final AtomicReferenceFieldUpdater b;
    private volatile int _decisionAndIndex = 536870911;
    private volatile Object _parentHandle;
    private volatile Object _state = H.a;

    /* renamed from: a  reason: collision with other field name */
    public final Continuation<T> f5562a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineContext f5563a;

    static {
        Class<c> cls = c.class;
        a = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex");
        Class<Object> cls2 = Object.class;
        f5561a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public c(int i, Continuation continuation) {
        super(i);
        this.f5562a = continuation;
        this.f5563a = continuation.getContext();
    }

    public static Object B(C0696Tm tm, Object obj, int i, Function1 function1) {
        C0688T3 t3;
        if (obj instanceof C0677S5) {
            return obj;
        }
        boolean z = true;
        if (!(i == 1 || i == 2)) {
            z = false;
        }
        if (!z) {
            return obj;
        }
        if (function1 == null && !(tm instanceof C0688T3)) {
            return obj;
        }
        if (tm instanceof C0688T3) {
            t3 = (C0688T3) tm;
        } else {
            t3 = null;
        }
        return new Q5(obj, t3, function1, (CancellationException) null, 16);
    }

    public static void w(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public final void A(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5561a;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            z = false;
            if (obj2 instanceof C0696Tm) {
                Object B = B((C0696Tm) obj2, obj, i, function1);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, B)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                if (obj2 instanceof C4) {
                    C4 c4 = (C4) obj2;
                    c4.getClass();
                    if (C4.b.compareAndSet(c4, 0, 1)) {
                        if (function1 != null) {
                            l(function1, c4.f3789a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
        } while (!z);
        if (!v()) {
            n();
        }
        o(i);
    }

    public final void a(Object obj, CancellationException cancellationException) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5561a;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof C0696Tm) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof C0677S5)) {
                boolean z2 = true;
                if (obj2 instanceof Q5) {
                    Q5 q5 = (Q5) obj2;
                    if (q5.f3762a != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Q5 a2 = Q5.a(q5, (C0688T3) null, cancellationException, 15);
                        while (true) {
                            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, a2)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                    z2 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (z2) {
                            C0688T3 t3 = q5.a;
                            if (t3 != null) {
                                j(t3, cancellationException);
                            }
                            Function1<Throwable, Unit> function1 = q5.f3763a;
                            if (function1 != null) {
                                l(function1, cancellationException);
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else {
                    Q5 q52 = new Q5(obj2, (C0688T3) null, (Function1) null, cancellationException, 14);
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, q52)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                z2 = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z2) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public final void b(Pv<?> pv, int i) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        boolean z;
        do {
            atomicIntegerFieldUpdater = a;
            i2 = atomicIntegerFieldUpdater.get(this);
            if ((i2 & 536870911) == 536870911) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, ((i2 >> 29) << 29) + i));
        u(pv);
    }

    public final Continuation<T> c() {
        return this.f5562a;
    }

    public final Throwable d(Object obj) {
        Throwable d = super.d(obj);
        if (d != null) {
            return d;
        }
        return null;
    }

    public final <T> T e(Object obj) {
        if (obj instanceof Q5) {
            return ((Q5) obj).f3761a;
        }
        return obj;
    }

    public final C0422zD g(Object obj, Function1 function1) {
        C0422zD zDVar;
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5561a;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z2 = obj2 instanceof C0696Tm;
            zDVar = r1.f3212b;
            if (z2) {
                Object B = B((C0696Tm) obj2, obj, this.c, function1);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, B)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
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
            } else {
                boolean z3 = obj2 instanceof Q5;
                return null;
            }
        } while (!z);
        if (v()) {
            return zDVar;
        }
        n();
        return zDVar;
    }

    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f5562a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final CoroutineContext getContext() {
        return this.f5563a;
    }

    public final Object h() {
        return f5561a.get(this);
    }

    public final void i(Function1<? super Throwable, Unit> function1) {
        C0688T3 t3;
        if (function1 instanceof C0688T3) {
            t3 = (C0688T3) function1;
        } else {
            t3 = new C1349qg(function1);
        }
        u(t3);
    }

    public final void j(C0688T3 t3, Throwable th) {
        try {
            t3.d(th);
        } catch (Throwable th2) {
            C1399t7.a(this.f5563a, new V5("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(Object obj) {
        o(this.c);
    }

    public final void l(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            C1399t7.a(this.f5563a, new V5("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void m(Pv<?> pv, Throwable th) {
        boolean z;
        CoroutineContext coroutineContext = this.f5563a;
        int i = a.get(this) & 536870911;
        if (i != 536870911) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            try {
                pv.g(i, coroutineContext);
            } catch (Throwable th2) {
                C1399t7.a(coroutineContext, new V5("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
    }

    public final void n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
        C1276n9 n9Var = (C1276n9) atomicReferenceFieldUpdater.get(this);
        if (n9Var != null) {
            n9Var.h();
            atomicReferenceFieldUpdater.set(this, Sm.a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(int r10) {
        /*
            r9 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a
            int r1 = r0.get(r9)
            int r2 = r1 >> 29
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x001c
            if (r2 != r3) goto L_0x0010
            r0 = r4
            goto L_0x002a
        L_0x0010:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Already resumed"
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x001c:
            r2 = 536870911(0x1fffffff, float:1.0842021E-19)
            r2 = r2 & r1
            r5 = 1073741824(0x40000000, float:2.0)
            int r2 = r2 + r5
            boolean r0 = r0.compareAndSet(r9, r1, r2)
            if (r0 == 0) goto L_0x0000
            r0 = r3
        L_0x002a:
            if (r0 == 0) goto L_0x002d
            return
        L_0x002d:
            r0 = 4
            if (r10 != r0) goto L_0x0032
            r0 = r3
            goto L_0x0033
        L_0x0032:
            r0 = r4
        L_0x0033:
            kotlin.coroutines.Continuation<T> r1 = r9.f5562a
            if (r0 != 0) goto L_0x009f
            boolean r2 = r1 instanceof defpackage.C1173i9
            if (r2 == 0) goto L_0x009f
            r2 = 2
            if (r10 == r3) goto L_0x0043
            if (r10 != r2) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r10 = r4
            goto L_0x0044
        L_0x0043:
            r10 = r3
        L_0x0044:
            int r5 = r9.c
            if (r5 == r3) goto L_0x004d
            if (r5 != r2) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r4
            goto L_0x004e
        L_0x004d:
            r2 = r3
        L_0x004e:
            if (r10 != r2) goto L_0x009f
            r10 = r1
            i9 r10 = (defpackage.C1173i9) r10
            kotlinx.coroutines.CoroutineDispatcher r10 = r10.f5487a
            kotlin.coroutines.CoroutineContext r0 = r1.getContext()
            boolean r2 = r10.q()
            if (r2 == 0) goto L_0x0063
            r10.h(r0, r9)
            goto L_0x00a2
        L_0x0063:
            Za r10 = defpackage.C0686Sz.a()
            long r5 = r10.a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0073
            r4 = r3
        L_0x0073:
            if (r4 == 0) goto L_0x0084
            I1<kotlinx.coroutines.g<?>> r0 = r10.f3880a
            if (r0 != 0) goto L_0x0080
            I1 r0 = new I1
            r0.<init>()
            r10.f3880a = r0
        L_0x0080:
            r0.addLast(r9)
            goto L_0x00a2
        L_0x0084:
            r10.s(r3)
            defpackage.C1354qp.s0(r9, r1, r3)     // Catch:{ all -> 0x0091 }
        L_0x008a:
            boolean r0 = r10.v()     // Catch:{ all -> 0x0091 }
            if (r0 != 0) goto L_0x008a
            goto L_0x0096
        L_0x0091:
            r0 = move-exception
            r1 = 0
            r9.f(r0, r1)     // Catch:{ all -> 0x009a }
        L_0x0096:
            r10.r(r3)
            goto L_0x00a2
        L_0x009a:
            r0 = move-exception
            r10.r(r3)
            throw r0
        L_0x009f:
            defpackage.C1354qp.s0(r9, r1, r0)
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.c.o(int):void");
    }

    public final boolean p(Throwable th) {
        Object obj;
        boolean z;
        boolean z2;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5561a;
            obj = atomicReferenceFieldUpdater.get(this);
            z = false;
            if (obj instanceof C0696Tm) {
                if ((obj instanceof C0688T3) || (obj instanceof Pv)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C4 c4 = new C4(this, th, z2);
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c4)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        C0696Tm tm = (C0696Tm) obj;
        if (tm instanceof C0688T3) {
            j((C0688T3) obj, th);
        } else if (tm instanceof Pv) {
            m((Pv) obj, th);
        }
        if (!v()) {
            n();
        }
        o(this.c);
        return true;
    }

    public Throwable q(k kVar) {
        return kVar.e();
    }

    public final Object r() {
        boolean z;
        boolean z2;
        boolean v = v();
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
            int i = atomicIntegerFieldUpdater.get(this);
            int i2 = i >> 29;
            z = false;
            if (i2 == 0) {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, (536870911 & i) + 536870912)) {
                    z2 = true;
                    break;
                }
            } else if (i2 == 2) {
                z2 = false;
            } else {
                throw new IllegalStateException("Already suspended".toString());
            }
        }
        if (z2) {
            if (((C1276n9) b.get(this)) == null) {
                t();
            }
            if (v) {
                z();
            }
            return C1438v7.COROUTINE_SUSPENDED;
        }
        if (v) {
            z();
        }
        Object obj = f5561a.get(this);
        if (!(obj instanceof C0677S5)) {
            int i3 = this.c;
            if (i3 == 1 || i3 == 2) {
                z = true;
            }
            if (z) {
                Job job = (Job) this.f5563a.b(Job.b.a);
                if (job != null && !job.isActive()) {
                    CancellationException e = job.e();
                    a(obj, e);
                    throw e;
                }
            }
            return e(obj);
        }
        throw ((C0677S5) obj).f3789a;
    }

    public final void resumeWith(Object obj) {
        Throwable a2 = C0698Tt.a(obj);
        if (a2 != null) {
            obj = new C0677S5(false, a2);
        }
        A(obj, this.c, (Function1<? super Throwable, Unit>) null);
    }

    public final void s() {
        C1276n9 t = t();
        if (t != null && (!(f5561a.get(this) instanceof C0696Tm))) {
            t.h();
            b.set(this, Sm.a);
        }
    }

    public final C1276n9 t() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) this.f5563a.b(Job.b.a);
        if (job == null) {
            return null;
        }
        C1276n9 a2 = Job.a.a(job, true, new Z4(this), 2);
        do {
            atomicReferenceFieldUpdater = b;
            if (atomicReferenceFieldUpdater.compareAndSet(this, (Object) null, a2) || atomicReferenceFieldUpdater.get(this) != null) {
                return a2;
            }
            atomicReferenceFieldUpdater = b;
            break;
        } while (atomicReferenceFieldUpdater.get(this) != null);
        return a2;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(y());
        sb.append('(');
        sb.append(C1149h8.b(this.f5562a));
        sb.append("){");
        Object obj = f5561a.get(this);
        if (obj instanceof C0696Tm) {
            str = "Active";
        } else if (obj instanceof C4) {
            str = "Cancelled";
        } else {
            str = "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(C1149h8.a(this));
        return sb.toString();
    }

    public final void u(Object obj) {
        boolean z;
        boolean z2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5561a;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z3 = true;
            if (obj2 instanceof H) {
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            z3 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z3) {
                    return;
                }
            } else {
                if (obj2 instanceof C0688T3) {
                    z = true;
                } else {
                    z = obj2 instanceof Pv;
                }
                Throwable th = null;
                if (!z) {
                    boolean z4 = obj2 instanceof C0677S5;
                    if (z4) {
                        C0677S5 s5 = (C0677S5) obj2;
                        s5.getClass();
                        if (!C0677S5.a.compareAndSet(s5, 0, 1)) {
                            w(obj, obj2);
                            throw null;
                        } else if (obj2 instanceof C4) {
                            if (!z4) {
                                s5 = null;
                            }
                            if (s5 != null) {
                                th = s5.f3789a;
                            }
                            if (obj instanceof C0688T3) {
                                j((C0688T3) obj, th);
                                return;
                            }
                            C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            m((Pv) obj, th);
                            return;
                        } else {
                            return;
                        }
                    } else if (obj2 instanceof Q5) {
                        Q5 q5 = (Q5) obj2;
                        if (q5.a != null) {
                            w(obj, obj2);
                            throw null;
                        } else if (!(obj instanceof Pv)) {
                            C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                            C0688T3 t3 = (C0688T3) obj;
                            Throwable th2 = q5.f3762a;
                            if (th2 != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                j(t3, th2);
                                return;
                            }
                            Q5 a2 = Q5.a(q5, t3, (CancellationException) null, 29);
                            while (true) {
                                if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, a2)) {
                                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                        z3 = false;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (z3) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!(obj instanceof Pv)) {
                        C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        Q5 q52 = new Q5(obj2, (C0688T3) obj, (Function1) null, (CancellationException) null, 28);
                        while (true) {
                            if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, q52)) {
                                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                    z3 = false;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (z3) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    w(obj, obj2);
                    throw null;
                }
            }
        }
    }

    public final boolean v() {
        boolean z;
        boolean z2;
        if (this.c == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Continuation<T> continuation = this.f5562a;
            C1177ig.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (C1173i9.a.get((C1173i9) continuation) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final void x(T t, Function1<? super Throwable, Unit> function1) {
        A(t, this.c, function1);
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z() {
        C1173i9 i9Var;
        Continuation<T> continuation = this.f5562a;
        Throwable th = null;
        if (continuation instanceof C1173i9) {
            i9Var = (C1173i9) continuation;
        } else {
            i9Var = null;
        }
        if (i9Var != null) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1173i9.a;
                Object obj = atomicReferenceFieldUpdater.get(i9Var);
                C0422zD zDVar = r1.e;
                boolean z = false;
                if (obj == zDVar) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(i9Var, zDVar, this)) {
                            if (atomicReferenceFieldUpdater.get(i9Var) != zDVar) {
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
                        break;
                    }
                } else if (obj instanceof Throwable) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(i9Var, obj, (Object) null)) {
                            if (atomicReferenceFieldUpdater.get(i9Var) != obj) {
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        th = obj;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                }
            }
            if (th != null) {
                n();
                p(th);
            }
        }
    }
}
