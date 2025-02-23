package defpackage;

import com.google.common.primitives.Longs;
import defpackage.V4;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* renamed from: o3  reason: default package and case insensitive filesystem */
/* compiled from: BufferedChannel.kt */
public class C1296o3<E> implements N4<E> {
    public static final AtomicLongFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f5610a;
    public static final AtomicLongFieldUpdater b;

    /* renamed from: b  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f5611b;
    public static final AtomicLongFieldUpdater c;

    /* renamed from: c  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f5612c;
    public static final AtomicLongFieldUpdater d;

    /* renamed from: d  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f5613d;
    public static final AtomicReferenceFieldUpdater e;
    private volatile Object _closeCause;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<E, Unit> f5614a;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* renamed from: c  reason: collision with other field name */
    public final int f5615c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* renamed from: o3$a */
    /* compiled from: BufferedChannel.kt */
    public final class a implements C0689T4<E>, C1256mD {
        public Object a = C1361r3.m;

        /* renamed from: a  reason: collision with other field name */
        public kotlinx.coroutines.c<? super Boolean> f5616a;

        public a() {
        }

        public final Object a(C0552Jc jc) {
            W4<E> w4;
            Boolean bool;
            W4<E> w42;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1296o3.f5611b;
            C1296o3<E> o3Var = C1296o3.this;
            W4<E> w43 = (W4) atomicReferenceFieldUpdater.get(o3Var);
            while (!o3Var.x()) {
                long andIncrement = C1296o3.b.getAndIncrement(o3Var);
                long j = (long) C1361r3.a;
                long j2 = andIncrement / j;
                int i = (int) (andIncrement % j);
                if (w43.f3758a != j2) {
                    W4<E> l = o3Var.l(j2, w43);
                    if (l == null) {
                        continue;
                    } else {
                        w4 = l;
                    }
                } else {
                    w4 = w43;
                }
                Object H = o3Var.H(w4, i, andIncrement, (Object) null);
                C0422zD zDVar = C1361r3.j;
                if (H != zDVar) {
                    C0422zD zDVar2 = C1361r3.l;
                    if (H == zDVar2) {
                        if (andIncrement < o3Var.u()) {
                            w4.a();
                        }
                        w43 = w4;
                    } else if (H == C1361r3.k) {
                        C1296o3<E> o3Var2 = C1296o3.this;
                        kotlinx.coroutines.c<? super Boolean> z = r1.z(r1.B(jc));
                        try {
                            this.f5616a = z;
                            Object H2 = o3Var2.H(w4, i, andIncrement, this);
                            if (H2 == zDVar) {
                                b(w4, i);
                            } else {
                                Cdo doVar = null;
                                CoroutineContext coroutineContext = z.f5563a;
                                Function1<E, Unit> function1 = o3Var2.f5614a;
                                if (H2 == zDVar2) {
                                    if (andIncrement < o3Var2.u()) {
                                        w4.a();
                                    }
                                    W4<E> w44 = (W4) C1296o3.f5611b.get(o3Var2);
                                    while (true) {
                                        if (o3Var2.x()) {
                                            kotlinx.coroutines.c<? super Boolean> cVar = this.f5616a;
                                            C1177ig.c(cVar);
                                            this.f5616a = null;
                                            this.a = C1361r3.i;
                                            Throwable n = o3Var.n();
                                            if (n == null) {
                                                cVar.resumeWith(Boolean.FALSE);
                                            } else {
                                                cVar.resumeWith(r1.n(n));
                                            }
                                        } else {
                                            long andIncrement2 = C1296o3.b.getAndIncrement(o3Var2);
                                            long j3 = (long) C1361r3.a;
                                            long j4 = andIncrement2 / j3;
                                            int i2 = (int) (andIncrement2 % j3);
                                            if (w44.f3758a != j4) {
                                                W4<E> l2 = o3Var2.l(j4, w44);
                                                if (l2 != null) {
                                                    w42 = l2;
                                                }
                                            } else {
                                                w42 = w44;
                                            }
                                            Function1<E, Unit> function12 = function1;
                                            Object H3 = o3Var2.H(w42, i2, andIncrement2, this);
                                            if (H3 == C1361r3.j) {
                                                b(w42, i2);
                                                break;
                                            } else if (H3 == C1361r3.l) {
                                                if (andIncrement2 < o3Var2.u()) {
                                                    w42.a();
                                                }
                                                w44 = w42;
                                                function1 = function12;
                                            } else if (H3 != C1361r3.k) {
                                                w42.a();
                                                this.a = H3;
                                                this.f5616a = null;
                                                bool = Boolean.TRUE;
                                                Function1<E, Unit> function13 = function12;
                                                if (function13 != null) {
                                                    doVar = new Cdo(function13, H3, coroutineContext);
                                                }
                                            } else {
                                                throw new IllegalStateException("unexpected".toString());
                                            }
                                        }
                                    }
                                } else {
                                    Function1<E, Unit> function14 = function1;
                                    w4.a();
                                    this.a = H2;
                                    this.f5616a = null;
                                    bool = Boolean.TRUE;
                                    if (function14 != null) {
                                        doVar = new Cdo(function14, H2, coroutineContext);
                                    }
                                }
                                z.x(bool, doVar);
                            }
                            return z.r();
                        } catch (Throwable th) {
                            z.z();
                            throw th;
                        }
                    } else {
                        w4.a();
                        this.a = H;
                        return Boolean.TRUE;
                    }
                } else {
                    throw new IllegalStateException("unreachable".toString());
                }
            }
            this.a = C1361r3.i;
            Throwable n2 = o3Var.n();
            if (n2 == null) {
                return Boolean.FALSE;
            }
            int i3 = Mx.a;
            throw n2;
        }

        public final void b(Pv<?> pv, int i) {
            kotlinx.coroutines.c<? super Boolean> cVar = this.f5616a;
            if (cVar != null) {
                cVar.b(pv, i);
            }
        }

        public final E next() {
            boolean z;
            E e = this.a;
            E e2 = C1361r3.m;
            if (e != e2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.a = e2;
                if (e != C1361r3.i) {
                    return e;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = C1296o3.a;
                Throwable p = C1296o3.this.p();
                int i = Mx.a;
                throw p;
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    /* renamed from: o3$b */
    /* compiled from: BufferedChannel.kt */
    public static final class b implements C1256mD {
        public final void b(Pv<?> pv, int i) {
            throw null;
        }
    }

    /* renamed from: o3$c */
    /* compiled from: BufferedChannel.kt */
    public static final class c extends C0595Mh implements C0694Td<Tv<?>, Object, Object, Function1<? super Throwable, ? extends Unit>> {
        public final /* synthetic */ C1296o3<E> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(C1296o3<E> o3Var) {
            super(3);
            this.a = o3Var;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return new C1316p3(obj3, this.a, (Tv) obj);
        }
    }

    static {
        Class<C1296o3> cls = C1296o3.class;
        a = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus");
        b = AtomicLongFieldUpdater.newUpdater(cls, "receivers");
        c = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd");
        d = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag");
        Class<Object> cls2 = Object.class;
        f5610a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "sendSegment");
        f5611b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "receiveSegment");
        f5612c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "bufferEndSegment");
        f5613d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closeCause");
        e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "closeHandler");
    }

    public C1296o3(int i, Function1<? super E, Unit> function1) {
        boolean z;
        long j;
        this.f5615c = i;
        this.f5614a = function1;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            W4<Object> w4 = C1361r3.f6939a;
            if (i == 0) {
                j = 0;
            } else if (i != Integer.MAX_VALUE) {
                j = (long) i;
            } else {
                j = Long.MAX_VALUE;
            }
            this.bufferEnd = j;
            this.completedExpandBuffersAndPauseFlag = m();
            W4<Object> w42 = new W4<>(0, (W4) null, this, 3);
            this.sendSegment = w42;
            this.receiveSegment = w42;
            if (z()) {
                w42 = C1361r3.f6939a;
                C1177ig.d(w42, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = w42;
            if (function1 != null) {
                new c(this);
            }
            this._closeCause = C1361r3.p;
            return;
        }
        throw new IllegalArgumentException(C1058d.y("Invalid channel capacity: ", i, ", should be >=0").toString());
    }

    public static final W4 a(C1296o3 o3Var, long j, W4 w4) {
        Object q;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        long j3;
        boolean z;
        o3Var.getClass();
        W4<Object> w42 = C1361r3.f6939a;
        C1341q3 q3Var = C1341q3.a;
        do {
            q = r1.q(w4, j, q3Var);
            if (C1354qp.Z(q)) {
                break;
            }
            Pv T = C1354qp.T(q);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5610a;
                Pv pv = (Pv) atomicReferenceFieldUpdater.get(o3Var);
                z = true;
                if (pv.f3758a >= T.f3758a) {
                    break;
                }
                boolean z2 = false;
                if (!T.i()) {
                    z = false;
                    continue;
                    break;
                }
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(o3Var, pv, T)) {
                        if (atomicReferenceFieldUpdater.get(o3Var) != pv) {
                            break;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    if (pv.e()) {
                        pv.d();
                        continue;
                    } else {
                        continue;
                    }
                } else if (T.e()) {
                    T.d();
                }
            }
        } while (!z);
        if (C1354qp.Z(q)) {
            o3Var.o();
            if (w4.f3758a * ((long) C1361r3.a) < o3Var.r()) {
                w4.a();
            }
        } else {
            W4 w43 = (W4) C1354qp.T(q);
            long j4 = w43.f3758a;
            if (j4 <= j) {
                return w43;
            }
            long j5 = j4 * ((long) C1361r3.a);
            do {
                atomicLongFieldUpdater = a;
                j2 = atomicLongFieldUpdater.get(o3Var);
                j3 = 1152921504606846975L & j2;
                if (j3 >= j5) {
                    break;
                }
                W4<Object> w44 = C1361r3.f6939a;
            } while (!atomicLongFieldUpdater.compareAndSet(o3Var, j2, (((long) ((int) (j2 >> 60))) << 60) + j3));
            if (w43.f3758a * ((long) C1361r3.a) < o3Var.r()) {
                w43.a();
            }
        }
        return null;
    }

    public static final int b(C1296o3 o3Var, W4 w4, int i, Object obj, long j, Object obj2, boolean z) {
        o3Var.getClass();
        w4.m(i, obj);
        if (z) {
            return o3Var.I(w4, i, obj, j, obj2, z);
        }
        Object k = w4.k(i);
        if (k == null) {
            if (o3Var.e(j)) {
                if (w4.j(i, (Object) null, C1361r3.f6940a)) {
                    return 1;
                }
            } else if (obj2 == null) {
                return 3;
            } else {
                if (w4.j(i, (Object) null, obj2)) {
                    return 2;
                }
            }
        } else if (k instanceof C1256mD) {
            w4.m(i, (Object) null);
            if (o3Var.F(k, obj)) {
                w4.n(i, C1361r3.f);
                return 0;
            }
            C0422zD zDVar = C1361r3.h;
            if (w4.a.getAndSet((i * 2) + 1, zDVar) != zDVar) {
                w4.l(i, true);
            }
            return 5;
        }
        return o3Var.I(w4, i, obj, j, obj2, z);
    }

    public final void A(long j, W4<E> w4) {
        boolean z;
        W4<E> w42;
        W4<E> w43;
        while (w4.f3758a < j && (w43 = (W4) w4.b()) != null) {
            w4 = w43;
        }
        while (true) {
            if (!w4.c() || (w42 = (W4) w4.b()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5612c;
                    Pv pv = (Pv) atomicReferenceFieldUpdater.get(this);
                    z = true;
                    if (pv.f3758a >= w4.f3758a) {
                        break;
                    }
                    boolean z2 = false;
                    if (!w4.i()) {
                        z = false;
                        break;
                    }
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, pv, w4)) {
                            if (atomicReferenceFieldUpdater.get(this) != pv) {
                                break;
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        if (pv.e()) {
                            pv.d();
                        }
                    } else if (w4.e()) {
                        w4.d();
                    }
                }
                if (z) {
                    return;
                }
            } else {
                w4 = w42;
            }
        }
    }

    public final Object B(E e2, Continuation<? super Unit> continuation) {
        C0155cA i;
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(1, r1.B(continuation));
        cVar.s();
        Function1<E, Unit> function1 = this.f5614a;
        if (function1 == null || (i = r1.i(function1, e2, (C0155cA) null)) == null) {
            cVar.resumeWith(r1.n(t()));
        } else {
            C1354qp.g(i, t());
            cVar.resumeWith(r1.n(i));
        }
        Object r = cVar.r();
        if (r == C1438v7.COROUTINE_SUSPENDED) {
            return r;
        }
        return Unit.a;
    }

    public final Object C(Continuation<? super E> continuation) {
        W4 w4;
        kotlinx.coroutines.c cVar;
        Cdo doVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5611b;
        W4 w42 = (W4) atomicReferenceFieldUpdater.get(this);
        while (!x()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j = (long) C1361r3.a;
            long j2 = andIncrement / j;
            int i = (int) (andIncrement % j);
            if (w42.f3758a != j2) {
                W4 l = l(j2, w42);
                if (l == null) {
                    continue;
                } else {
                    w4 = l;
                }
            } else {
                w4 = w42;
            }
            Object H = H(w4, i, andIncrement, (Object) null);
            C0422zD zDVar = C1361r3.j;
            if (H != zDVar) {
                C0422zD zDVar2 = C1361r3.l;
                if (H == zDVar2) {
                    if (andIncrement < u()) {
                        w4.a();
                    }
                    w42 = w4;
                } else if (H == C1361r3.k) {
                    W4 w43 = w4;
                    int i2 = i;
                    kotlinx.coroutines.c z = r1.z(r1.B(continuation));
                    C0422zD zDVar3 = zDVar2;
                    try {
                        Object H2 = H(w43, i2, andIncrement, z);
                        if (H2 == zDVar) {
                            cVar = z;
                            try {
                                cVar.b(w4, i);
                            } catch (Throwable th) {
                                th = th;
                            }
                        } else {
                            cVar = z;
                            Function1<E, Unit> function1 = this.f5614a;
                            CoroutineContext coroutineContext = cVar.f5563a;
                            if (H2 == zDVar3) {
                                if (andIncrement < u()) {
                                    w4.a();
                                }
                                W4 w44 = (W4) atomicReferenceFieldUpdater.get(this);
                                while (true) {
                                    if (x()) {
                                        cVar.resumeWith(r1.n(p()));
                                        break;
                                    }
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j3 = (long) C1361r3.a;
                                    long j4 = andIncrement2 / j3;
                                    int i3 = (int) (andIncrement2 % j3);
                                    if (w44.f3758a != j4) {
                                        W4 l2 = l(j4, w44);
                                        if (l2 != null) {
                                            w44 = l2;
                                        }
                                    }
                                    CoroutineContext coroutineContext2 = coroutineContext;
                                    H2 = H(w44, i3, andIncrement2, cVar);
                                    if (H2 == C1361r3.j) {
                                        cVar.b(w44, i3);
                                        break;
                                    } else if (H2 == C1361r3.l) {
                                        if (andIncrement2 < u()) {
                                            w44.a();
                                        }
                                        coroutineContext = coroutineContext2;
                                    } else if (H2 != C1361r3.k) {
                                        w44.a();
                                        if (function1 != null) {
                                            doVar = new Cdo(function1, H2, coroutineContext2);
                                        }
                                    } else {
                                        throw new IllegalStateException("unexpected".toString());
                                    }
                                }
                            } else {
                                CoroutineContext coroutineContext3 = coroutineContext;
                                w4.a();
                                if (function1 != null) {
                                    doVar = new Cdo(function1, H2, coroutineContext3);
                                    cVar.x(H2, doVar);
                                }
                            }
                            doVar = null;
                            cVar.x(H2, doVar);
                        }
                        return cVar.r();
                    } catch (Throwable th2) {
                        th = th2;
                        cVar = z;
                        cVar.z();
                        throw th;
                    }
                } else {
                    w4.a();
                    return H;
                }
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        Throwable p = p();
        int i4 = Mx.a;
        throw p;
    }

    public final void D(C1256mD mDVar, boolean z) {
        Throwable th;
        if (mDVar instanceof b) {
            ((b) mDVar).getClass();
            throw null;
        } else if (mDVar instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) mDVar;
            if (z) {
                th = p();
            } else {
                th = t();
            }
            continuation.resumeWith(r1.n(th));
        } else if (mDVar instanceof C0463Bs) {
            ((C0463Bs) mDVar).getClass();
            n();
            throw null;
        } else if (mDVar instanceof a) {
            a aVar = (a) mDVar;
            kotlinx.coroutines.c<? super Boolean> cVar = aVar.f5616a;
            C1177ig.c(cVar);
            aVar.f5616a = null;
            aVar.a = C1361r3.i;
            Throwable n = C1296o3.this.n();
            if (n == null) {
                cVar.resumeWith(Boolean.FALSE);
            } else {
                cVar.resumeWith(r1.n(n));
            }
        } else if (mDVar instanceof Tv) {
            ((Tv) mDVar).a(this, C1361r3.i);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + mDVar).toString());
        }
    }

    public final Object E() {
        W4 w4;
        C1256mD mDVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b;
        long j = atomicLongFieldUpdater.get(this);
        long j2 = a.get(this);
        if (w(j2, true)) {
            return new V4.a(n());
        }
        int i = (j > (j2 & 1152921504606846975L) ? 1 : (j == (j2 & 1152921504606846975L) ? 0 : -1));
        Object obj = V4.a;
        if (i >= 0) {
            return obj;
        }
        C0422zD zDVar = C1361r3.h;
        W4 w42 = (W4) f5611b.get(this);
        while (!x()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j3 = (long) C1361r3.a;
            long j4 = andIncrement / j3;
            int i2 = (int) (andIncrement % j3);
            if (w42.f3758a != j4) {
                W4 l = l(j4, w42);
                if (l == null) {
                    continue;
                } else {
                    w4 = l;
                }
            } else {
                w4 = w42;
            }
            Object H = H(w4, i2, andIncrement, zDVar);
            if (H == C1361r3.j) {
                if (zDVar instanceof C1256mD) {
                    mDVar = (C1256mD) zDVar;
                } else {
                    mDVar = null;
                }
                if (mDVar != null) {
                    mDVar.b(w4, i2);
                }
                J(andIncrement);
                w4.h();
            } else if (H == C1361r3.l) {
                if (andIncrement < u()) {
                    w4.a();
                }
                w42 = w4;
            } else if (H != C1361r3.k) {
                w4.a();
                obj = H;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
            return obj;
        }
        return new V4.a(n());
    }

    public final boolean F(Object obj, E e2) {
        if (obj instanceof Tv) {
            return ((Tv) obj).a(this, e2);
        }
        boolean z = obj instanceof C0463Bs;
        Function1<E, Unit> function1 = this.f5614a;
        Cdo doVar = null;
        if (z) {
            C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            C0463Bs bs = (C0463Bs) obj;
            V4 v4 = new V4(e2);
            if (function1 != null) {
                throw null;
            }
            C1361r3.a((CancellableContinuation) null, v4, (Function1<? super Throwable, Unit>) null);
            throw null;
        } else if (obj instanceof a) {
            C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            a aVar = (a) obj;
            kotlinx.coroutines.c<? super Boolean> cVar = aVar.f5616a;
            C1177ig.c(cVar);
            aVar.f5616a = null;
            aVar.a = e2;
            Boolean bool = Boolean.TRUE;
            Function1<E, Unit> function12 = C1296o3.this.f5614a;
            if (function12 != null) {
                doVar = new Cdo(function12, e2, cVar.f5563a);
            }
            return C1361r3.a(cVar, bool, doVar);
        } else if (obj instanceof CancellableContinuation) {
            C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            if (function1 != null) {
                doVar = new Cdo(function1, e2, cancellableContinuation.getContext());
            }
            return C1361r3.a(cancellableContinuation, e2, doVar);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    public final boolean G(Object obj, W4<E> w4, int i) {
        char c2;
        if (obj instanceof CancellableContinuation) {
            C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return C1361r3.a((CancellableContinuation) obj, Unit.a, (Function1<? super Throwable, Unit>) null);
        } else if (obj instanceof Tv) {
            C1177ig.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            Unit unit = Unit.a;
            int e2 = ((Sv) obj).e(this);
            if (e2 == 0) {
                c2 = 1;
            } else if (e2 != 1) {
                c2 = 3;
                if (e2 != 2) {
                    if (e2 == 3) {
                        c2 = 4;
                    } else {
                        throw new IllegalStateException(("Unexpected internal result: " + e2).toString());
                    }
                }
            } else {
                c2 = 2;
            }
            if (c2 == 2) {
                w4.m(i, (Object) null);
            }
            if (c2 == 1) {
                return true;
            }
            return false;
        } else if (obj instanceof b) {
            ((b) obj).getClass();
            C1361r3.a((CancellableContinuation) null, Boolean.TRUE, (Function1<? super Throwable, Unit>) null);
            throw null;
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    public final Object H(W4<E> w4, int i, long j, Object obj) {
        Object k = w4.k(i);
        AtomicReferenceArray atomicReferenceArray = w4.a;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a;
        if (k == null) {
            if (j >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return C1361r3.k;
                }
                if (w4.j(i, k, obj)) {
                    k();
                    return C1361r3.j;
                }
            }
        } else if (k == C1361r3.f6940a && w4.j(i, k, C1361r3.f)) {
            k();
            Object obj2 = atomicReferenceArray.get(i * 2);
            w4.m(i, (Object) null);
            return obj2;
        }
        while (true) {
            Object k2 = w4.k(i);
            if (k2 == null || k2 == C1361r3.f6941b) {
                if (j < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (w4.j(i, k2, C1361r3.e)) {
                        k();
                        return C1361r3.l;
                    }
                } else if (obj == null) {
                    return C1361r3.k;
                } else {
                    if (w4.j(i, k2, obj)) {
                        k();
                        return C1361r3.j;
                    }
                }
            } else if (k2 != C1361r3.f6940a) {
                C0422zD zDVar = C1361r3.g;
                if (k2 == zDVar) {
                    return C1361r3.l;
                }
                if (k2 == C1361r3.e) {
                    return C1361r3.l;
                }
                if (k2 == C1361r3.i) {
                    k();
                    return C1361r3.l;
                } else if (k2 != C1361r3.d && w4.j(i, k2, C1361r3.c)) {
                    boolean z = k2 instanceof C1278nD;
                    if (z) {
                        k2 = ((C1278nD) k2).a;
                    }
                    if (G(k2, w4, i)) {
                        w4.n(i, C1361r3.f);
                        k();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        w4.m(i, (Object) null);
                        return obj3;
                    }
                    w4.n(i, zDVar);
                    w4.l(i, false);
                    if (z) {
                        k();
                    }
                    return C1361r3.l;
                }
            } else if (w4.j(i, k2, C1361r3.f)) {
                k();
                Object obj4 = atomicReferenceArray.get(i * 2);
                w4.m(i, (Object) null);
                return obj4;
            }
        }
    }

    public final int I(W4<E> w4, int i, E e2, long j, Object obj, boolean z) {
        while (true) {
            Object k = w4.k(i);
            if (k == null) {
                if (!e(j) || z) {
                    if (z) {
                        if (w4.j(i, (Object) null, C1361r3.g)) {
                            w4.l(i, false);
                            return 4;
                        }
                    } else if (obj == null) {
                        return 3;
                    } else {
                        if (w4.j(i, (Object) null, obj)) {
                            return 2;
                        }
                    }
                } else if (w4.j(i, (Object) null, C1361r3.f6940a)) {
                    return 1;
                }
            } else if (k != C1361r3.f6941b) {
                C0422zD zDVar = C1361r3.h;
                if (k == zDVar) {
                    w4.m(i, (Object) null);
                    return 5;
                } else if (k == C1361r3.e) {
                    w4.m(i, (Object) null);
                    return 5;
                } else if (k == C1361r3.i) {
                    w4.m(i, (Object) null);
                    o();
                    return 4;
                } else {
                    w4.m(i, (Object) null);
                    if (k instanceof C1278nD) {
                        k = ((C1278nD) k).a;
                    }
                    if (F(k, e2)) {
                        w4.n(i, C1361r3.f);
                        return 0;
                    }
                    if (w4.a.getAndSet((i * 2) + 1, zDVar) != zDVar) {
                        w4.l(i, true);
                    }
                    return 5;
                }
            } else if (w4.j(i, k, C1361r3.f6940a)) {
                return 1;
            }
        }
    }

    public final void J(long j) {
        long j2;
        boolean z;
        long j3;
        if (!z()) {
            do {
            } while (m() <= j);
            int i = C1361r3.b;
            int i2 = 0;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = d;
                if (i2 < i) {
                    long m = m();
                    if (m != (atomicLongFieldUpdater.get(this) & 4611686018427387903L) || m != m()) {
                        i2++;
                    } else {
                        return;
                    }
                } else {
                    do {
                        j2 = atomicLongFieldUpdater.get(this);
                    } while (!atomicLongFieldUpdater.compareAndSet(this, j2, Longs.MAX_POWER_OF_TWO + (j2 & 4611686018427387903L)));
                    while (true) {
                        long m2 = m();
                        long j4 = atomicLongFieldUpdater.get(this);
                        long j5 = j4 & 4611686018427387903L;
                        if ((j4 & Longs.MAX_POWER_OF_TWO) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (m2 == j5 && m2 == m()) {
                            break;
                        } else if (!z) {
                            atomicLongFieldUpdater.compareAndSet(this, j4, j5 + Longs.MAX_POWER_OF_TWO);
                        }
                    }
                    do {
                        j3 = atomicLongFieldUpdater.get(this);
                    } while (!atomicLongFieldUpdater.compareAndSet(this, j3, 0 + (j3 & 4611686018427387903L)));
                    return;
                }
            }
        }
    }

    public final void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        g(true, cancellationException);
    }

    public Object d(E e2) {
        boolean z;
        W4 w4;
        C1256mD mDVar;
        W4 w42;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a;
        long j = atomicLongFieldUpdater.get(this);
        if (w(j, false)) {
            z = false;
        } else {
            z = !e(j & 1152921504606846975L);
        }
        V4.b bVar = V4.a;
        if (z) {
            return bVar;
        }
        C0422zD zDVar = C1361r3.g;
        W4 w43 = (W4) f5610a.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j2 = andIncrement & 1152921504606846975L;
            boolean w = w(andIncrement, false);
            int i = C1361r3.a;
            long j3 = (long) i;
            long j4 = j2 / j3;
            int i2 = (int) (j2 % j3);
            if (w43.f3758a != j4) {
                W4 a2 = a(this, j4, w43);
                if (a2 != null) {
                    w4 = a2;
                } else if (w) {
                    return new V4.a(t());
                }
            } else {
                w4 = w43;
            }
            W4 w44 = w4;
            int i3 = i2;
            int i4 = i;
            int b2 = b(this, w4, i2, e2, j2, zDVar, w);
            if (b2 != 0) {
                if (b2 == 1) {
                    break;
                } else if (b2 != 2) {
                    if (b2 == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (b2 != 4) {
                        if (b2 == 5) {
                            w44.a();
                        }
                        w43 = w44;
                    } else {
                        if (j2 < r()) {
                            w44.a();
                        }
                        return new V4.a(t());
                    }
                } else if (w) {
                    w44.h();
                    return new V4.a(t());
                } else {
                    if (zDVar instanceof C1256mD) {
                        mDVar = (C1256mD) zDVar;
                    } else {
                        mDVar = null;
                    }
                    if (mDVar != null) {
                        w42 = w44;
                        mDVar.b(w42, i3 + i4);
                    } else {
                        w42 = w44;
                    }
                    w42.h();
                    return bVar;
                }
            } else {
                w44.a();
                break;
            }
        }
        return Unit.a;
    }

    public final boolean e(long j) {
        if (j < m() || j < r() + ((long) this.f5615c)) {
            return true;
        }
        return false;
    }

    public final C0689T4<E> f() {
        return new a();
    }

    public final boolean g(boolean z, Throwable th) {
        boolean z2;
        Object obj;
        C0422zD zDVar;
        boolean z3;
        long j;
        int i;
        long j2;
        long j3;
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = a;
        if (z) {
            do {
                j4 = atomicLongFieldUpdater.get(this);
                if (((int) (j4 >> 60)) != 0) {
                    break;
                }
                W4<Object> w4 = C1361r3.f6939a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j4, (((long) 1) << 60) + (j4 & 1152921504606846975L)));
        }
        C0422zD zDVar2 = C1361r3.p;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5613d;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, zDVar2, th)) {
                if (atomicReferenceFieldUpdater.get(this) != zDVar2) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        if (z) {
            do {
                j3 = atomicLongFieldUpdater.get(this);
                W4<Object> w42 = C1361r3.f6939a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j3, (((long) 3) << 60) + (j3 & 1152921504606846975L)));
        } else {
            do {
                j = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j >> 60);
                if (i2 == 0) {
                    j2 = j & 1152921504606846975L;
                    W4<Object> w43 = C1361r3.f6939a;
                    i = 2;
                } else if (i2 != 1) {
                    break;
                } else {
                    j2 = j & 1152921504606846975L;
                    W4<Object> w44 = C1361r3.f6939a;
                    i = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j, (((long) i) << 60) + j2));
        }
        o();
        if (z2) {
            do {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = e;
                obj = atomicReferenceFieldUpdater2.get(this);
                if (obj == null) {
                    zDVar = C1361r3.n;
                } else {
                    zDVar = C1361r3.o;
                }
                while (true) {
                    if (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, zDVar)) {
                        if (atomicReferenceFieldUpdater2.get(this) != obj) {
                            z3 = false;
                            continue;
                            break;
                        }
                    } else {
                        z3 = true;
                        continue;
                        break;
                    }
                }
            } while (!z3);
            if (obj != null) {
                C0648QA.a(1, obj);
                ((Function1) obj).invoke(n());
            }
        }
        return z2;
    }

    public final boolean h(Throwable th) {
        return g(false, th);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0097, code lost:
        r1 = (defpackage.W4) ((defpackage.C1473x6) defpackage.C1473x6.b.get(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.W4<E> i(long r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f5612c
            java.lang.Object r0 = r0.get(r12)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f5610a
            java.lang.Object r1 = r1.get(r12)
            W4 r1 = (defpackage.W4) r1
            long r2 = r1.f3758a
            r4 = r0
            W4 r4 = (defpackage.W4) r4
            long r4 = r4.f3758a
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
            r0 = r1
        L_0x001a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f5611b
            java.lang.Object r1 = r1.get(r12)
            W4 r1 = (defpackage.W4) r1
            long r2 = r1.f3758a
            r4 = r0
            W4 r4 = (defpackage.W4) r4
            long r4 = r4.f3758a
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x002e
            r0 = r1
        L_0x002e:
            x6 r0 = (defpackage.C1473x6) r0
        L_0x0030:
            r0.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = defpackage.C1473x6.a
            java.lang.Object r1 = r1.get(r0)
            zD r2 = defpackage.r1.f3215c
            r3 = 1
            r4 = 0
            if (r1 != r2) goto L_0x0040
            goto L_0x0057
        L_0x0040:
            x6 r1 = (defpackage.C1473x6) r1
            if (r1 != 0) goto L_0x0131
        L_0x0044:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = defpackage.C1473x6.a
            boolean r5 = r1.compareAndSet(r0, r4, r2)
            if (r5 == 0) goto L_0x004e
            r1 = r3
            goto L_0x0055
        L_0x004e:
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x0044
            r1 = 0
        L_0x0055:
            if (r1 == 0) goto L_0x0030
        L_0x0057:
            W4 r0 = (defpackage.W4) r0
            boolean r1 = r12.y()
            r2 = -1
            if (r1 == 0) goto L_0x00ab
            r1 = r0
        L_0x0061:
            int r5 = defpackage.C1361r3.a
            int r5 = r5 + r2
        L_0x0064:
            r6 = -1
            if (r2 >= r5) goto L_0x0097
            int r8 = defpackage.C1361r3.a
            long r8 = (long) r8
            long r10 = r1.f3758a
            long r10 = r10 * r8
            long r8 = (long) r5
            long r10 = r10 + r8
            long r8 = r12.r()
            int r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0079
            goto L_0x00a3
        L_0x0079:
            java.lang.Object r8 = r1.k(r5)
            if (r8 == 0) goto L_0x0089
            zD r9 = defpackage.C1361r3.f6941b
            if (r8 != r9) goto L_0x0084
            goto L_0x0089
        L_0x0084:
            zD r9 = defpackage.C1361r3.f6940a
            if (r8 != r9) goto L_0x0094
            goto L_0x00a4
        L_0x0089:
            zD r9 = defpackage.C1361r3.i
            boolean r8 = r1.j(r5, r8, r9)
            if (r8 == 0) goto L_0x0079
            r1.h()
        L_0x0094:
            int r5 = r5 + -1
            goto L_0x0064
        L_0x0097:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = defpackage.C1473x6.b
            java.lang.Object r1 = r5.get(r1)
            x6 r1 = (defpackage.C1473x6) r1
            W4 r1 = (defpackage.W4) r1
            if (r1 != 0) goto L_0x0061
        L_0x00a3:
            r10 = r6
        L_0x00a4:
            int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00ab
            r12.j(r10)
        L_0x00ab:
            r1 = r0
        L_0x00ac:
            if (r1 == 0) goto L_0x010f
            int r5 = defpackage.C1361r3.a
            int r5 = r5 - r3
        L_0x00b1:
            if (r2 >= r5) goto L_0x0104
            int r6 = defpackage.C1361r3.a
            long r6 = (long) r6
            long r8 = r1.f3758a
            long r8 = r8 * r6
            long r6 = (long) r5
            long r8 = r8 + r6
            int r6 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x010f
        L_0x00bf:
            java.lang.Object r6 = r1.k(r5)
            if (r6 == 0) goto L_0x00f6
            zD r7 = defpackage.C1361r3.f6941b
            if (r6 != r7) goto L_0x00ca
            goto L_0x00f6
        L_0x00ca:
            boolean r7 = r6 instanceof defpackage.C1278nD
            if (r7 == 0) goto L_0x00e2
            zD r7 = defpackage.C1361r3.i
            boolean r7 = r1.j(r5, r6, r7)
            if (r7 == 0) goto L_0x00bf
            nD r6 = (defpackage.C1278nD) r6
            mD r6 = r6.a
            java.lang.Object r4 = defpackage.r1.K(r4, r6)
            r1.l(r5, r3)
            goto L_0x0101
        L_0x00e2:
            boolean r7 = r6 instanceof defpackage.C1256mD
            if (r7 == 0) goto L_0x0101
            zD r7 = defpackage.C1361r3.i
            boolean r7 = r1.j(r5, r6, r7)
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r4 = defpackage.r1.K(r4, r6)
            r1.l(r5, r3)
            goto L_0x0101
        L_0x00f6:
            zD r7 = defpackage.C1361r3.i
            boolean r6 = r1.j(r5, r6, r7)
            if (r6 == 0) goto L_0x00bf
            r1.h()
        L_0x0101:
            int r5 = r5 + -1
            goto L_0x00b1
        L_0x0104:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = defpackage.C1473x6.b
            java.lang.Object r1 = r5.get(r1)
            x6 r1 = (defpackage.C1473x6) r1
            W4 r1 = (defpackage.W4) r1
            goto L_0x00ac
        L_0x010f:
            if (r4 == 0) goto L_0x0130
            boolean r13 = r4 instanceof java.util.ArrayList
            if (r13 != 0) goto L_0x011b
            mD r4 = (defpackage.C1256mD) r4
            r12.D(r4, r3)
            goto L_0x0130
        L_0x011b:
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r13 = r4.size()
            int r13 = r13 - r3
        L_0x0122:
            if (r2 >= r13) goto L_0x0130
            java.lang.Object r14 = r4.get(r13)
            mD r14 = (defpackage.C1256mD) r14
            r12.D(r14, r3)
            int r13 = r13 + -1
            goto L_0x0122
        L_0x0130:
            return r0
        L_0x0131:
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1296o3.i(long):W4");
    }

    public final void j(long j) {
        C0155cA i;
        W4 w4 = (W4) f5611b.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b;
            long j2 = atomicLongFieldUpdater.get(this);
            if (j >= Math.max(((long) this.f5615c) + j2, m())) {
                if (atomicLongFieldUpdater.compareAndSet(this, j2, j2 + 1)) {
                    long j3 = (long) C1361r3.a;
                    long j4 = j2 / j3;
                    int i2 = (int) (j2 % j3);
                    if (w4.f3758a != j4) {
                        W4 l = l(j4, w4);
                        if (l == null) {
                            continue;
                        } else {
                            w4 = l;
                        }
                    }
                    Object H = H(w4, i2, j2, (Object) null);
                    if (H != C1361r3.l) {
                        w4.a();
                        Function1<E, Unit> function1 = this.f5614a;
                        if (!(function1 == null || (i = r1.i(function1, H, (C0155cA) null)) == null)) {
                            throw i;
                        }
                    } else if (j2 < u()) {
                        w4.a();
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v22, types: [Pv] */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0158, code lost:
        r13 = r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x019c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0012 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k() {
        /*
            r17 = this;
            r6 = r17
            boolean r0 = r17.z()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = f5612c
            java.lang.Object r0 = r7.get(r6)
            W4 r0 = (defpackage.W4) r0
            r8 = r0
        L_0x0012:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = c
            long r9 = r0.getAndIncrement(r6)
            int r0 = defpackage.C1361r3.a
            long r0 = (long) r0
            long r0 = r9 / r0
            long r2 = r17.u()
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            r11 = 1
            if (r2 > 0) goto L_0x003a
            long r2 = r8.f3758a
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0036
            x6 r2 = r8.b()
            if (r2 == 0) goto L_0x0036
            r6.A(r0, r8)
        L_0x0036:
            r6.v(r11)
            return
        L_0x003a:
            long r2 = r8.f3758a
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x00dc
            q3 r2 = defpackage.C1341q3.a
        L_0x0042:
            java.lang.Object r3 = defpackage.r1.q(r8, r0, r2)
            boolean r4 = defpackage.C1354qp.Z(r3)
            if (r4 != 0) goto L_0x0094
            Pv r4 = defpackage.C1354qp.T(r3)
        L_0x0050:
            java.lang.Object r5 = r7.get(r6)
            Pv r5 = (defpackage.Pv) r5
            long r13 = r5.f3758a
            long r11 = r4.f3758a
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 < 0) goto L_0x005f
            goto L_0x0081
        L_0x005f:
            boolean r11 = r4.i()
            if (r11 != 0) goto L_0x0067
            r4 = 0
            goto L_0x0082
        L_0x0067:
            boolean r11 = r7.compareAndSet(r6, r5, r4)
            if (r11 == 0) goto L_0x006f
            r11 = 1
            goto L_0x0076
        L_0x006f:
            java.lang.Object r11 = r7.get(r6)
            if (r11 == r5) goto L_0x0067
            r11 = 0
        L_0x0076:
            if (r11 == 0) goto L_0x0088
            boolean r4 = r5.e()
            if (r4 == 0) goto L_0x0081
            r5.d()
        L_0x0081:
            r4 = 1
        L_0x0082:
            if (r4 == 0) goto L_0x0085
            goto L_0x0094
        L_0x0085:
            r11 = 1
            goto L_0x0042
        L_0x0088:
            boolean r5 = r4.e()
            if (r5 == 0) goto L_0x0091
            r4.d()
        L_0x0091:
            r11 = 1
            goto L_0x0050
        L_0x0094:
            boolean r2 = defpackage.C1354qp.Z(r3)
            if (r2 == 0) goto L_0x00a6
            r17.o()
            r6.A(r0, r8)
            r4 = 1
            r6.v(r4)
            goto L_0x00d6
        L_0x00a6:
            r4 = 1
            Pv r2 = defpackage.C1354qp.T(r3)
            r11 = r2
            W4 r11 = (defpackage.W4) r11
            long r2 = r11.f3758a
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = c
            long r12 = r9 + r4
            int r1 = defpackage.C1361r3.a
            long r4 = (long) r1
            long r15 = r4 * r2
            r1 = r17
            r2 = r12
            r12 = r4
            r4 = r15
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L_0x00d1
            long r0 = r11.f3758a
            long r0 = r0 * r12
            long r0 = r0 - r9
            r6.v(r0)
            goto L_0x00d6
        L_0x00d1:
            r0 = 1
            r6.v(r0)
        L_0x00d6:
            r11 = 0
        L_0x00d7:
            if (r11 != 0) goto L_0x00db
            goto L_0x0012
        L_0x00db:
            r8 = r11
        L_0x00dc:
            int r0 = defpackage.C1361r3.a
            long r0 = (long) r0
            long r0 = r9 % r0
            int r0 = (int) r0
            java.lang.Object r1 = r8.k(r0)
            boolean r2 = r1 instanceof defpackage.C1256mD
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = b
            if (r2 == 0) goto L_0x0115
            long r4 = r3.get(r6)
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0115
            zD r2 = defpackage.C1361r3.d
            boolean r2 = r8.j(r0, r1, r2)
            if (r2 == 0) goto L_0x0115
            boolean r1 = r6.G(r1, r8, r0)
            if (r1 == 0) goto L_0x0109
            zD r1 = defpackage.C1361r3.f6940a
            r8.n(r0, r1)
            goto L_0x0199
        L_0x0109:
            zD r1 = defpackage.C1361r3.g
            r8.n(r0, r1)
            r1 = 0
            r8.l(r0, r1)
            r13 = 0
            goto L_0x019a
        L_0x0115:
            java.lang.Object r1 = r8.k(r0)
            boolean r2 = r1 instanceof defpackage.C1256mD
            if (r2 == 0) goto L_0x0153
            long r4 = r3.get(r6)
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x0135
            nD r2 = new nD
            r4 = r1
            mD r4 = (defpackage.C1256mD) r4
            r2.<init>(r4)
            boolean r1 = r8.j(r0, r1, r2)
            if (r1 == 0) goto L_0x0115
            goto L_0x0199
        L_0x0135:
            zD r2 = defpackage.C1361r3.d
            boolean r2 = r8.j(r0, r1, r2)
            if (r2 == 0) goto L_0x0115
            boolean r1 = r6.G(r1, r8, r0)
            if (r1 == 0) goto L_0x0149
            zD r1 = defpackage.C1361r3.f6940a
            r8.n(r0, r1)
            goto L_0x0199
        L_0x0149:
            zD r1 = defpackage.C1361r3.g
            r8.n(r0, r1)
            r2 = 0
            r8.l(r0, r2)
            goto L_0x0158
        L_0x0153:
            r2 = 0
            zD r4 = defpackage.C1361r3.g
            if (r1 != r4) goto L_0x015a
        L_0x0158:
            r13 = r2
            goto L_0x019a
        L_0x015a:
            if (r1 != 0) goto L_0x0165
            zD r4 = defpackage.C1361r3.f6941b
            boolean r1 = r8.j(r0, r1, r4)
            if (r1 == 0) goto L_0x0115
            goto L_0x0199
        L_0x0165:
            zD r4 = defpackage.C1361r3.f6940a
            if (r1 != r4) goto L_0x016a
            goto L_0x0199
        L_0x016a:
            zD r4 = defpackage.C1361r3.e
            if (r1 == r4) goto L_0x0199
            zD r4 = defpackage.C1361r3.f
            if (r1 == r4) goto L_0x0199
            zD r4 = defpackage.C1361r3.h
            if (r1 != r4) goto L_0x0177
            goto L_0x0199
        L_0x0177:
            zD r4 = defpackage.C1361r3.i
            if (r1 != r4) goto L_0x017c
            goto L_0x0199
        L_0x017c:
            zD r4 = defpackage.C1361r3.c
            if (r1 != r4) goto L_0x0181
            goto L_0x0115
        L_0x0181:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected cell state: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0199:
            r13 = 1
        L_0x019a:
            if (r13 == 0) goto L_0x01a2
            r0 = 1
            r6.v(r0)
            return
        L_0x01a2:
            r0 = 1
            r6.v(r0)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1296o3.k():void");
    }

    public final W4<E> l(long j, W4<E> w4) {
        Object q;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        W4<Object> w42 = C1361r3.f6939a;
        C1341q3 q3Var = C1341q3.a;
        do {
            q = r1.q(w4, j, q3Var);
            if (C1354qp.Z(q)) {
                break;
            }
            Pv T = C1354qp.T(q);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5611b;
                Pv pv = (Pv) atomicReferenceFieldUpdater.get(this);
                if (pv.f3758a >= T.f3758a) {
                    break;
                } else if (!T.i()) {
                    z2 = false;
                    continue;
                    break;
                } else {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, pv, T)) {
                            if (atomicReferenceFieldUpdater.get(this) != pv) {
                                z3 = false;
                                break;
                            }
                        } else {
                            z3 = true;
                            break;
                        }
                    }
                    if (z3) {
                        if (pv.e()) {
                            pv.d();
                        }
                    } else if (T.e()) {
                        T.d();
                    }
                }
            }
            z2 = true;
            continue;
        } while (!z2);
        if (C1354qp.Z(q)) {
            o();
            if (w4.f3758a * ((long) C1361r3.a) < u()) {
                w4.a();
            }
        } else {
            W4<E> w43 = (W4) C1354qp.T(q);
            boolean z4 = z();
            long j3 = w43.f3758a;
            if (!z4 && j <= m() / ((long) C1361r3.a)) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5612c;
                    Pv pv2 = (Pv) atomicReferenceFieldUpdater2.get(this);
                    if (pv2.f3758a >= j3 || !w43.i()) {
                        break;
                    }
                    while (true) {
                        if (!atomicReferenceFieldUpdater2.compareAndSet(this, pv2, w43)) {
                            if (atomicReferenceFieldUpdater2.get(this) != pv2) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        if (pv2.e()) {
                            pv2.d();
                        }
                    } else if (w43.e()) {
                        w43.d();
                    }
                }
            }
            if (j3 <= j) {
                return w43;
            }
            long j4 = j3 * ((long) C1361r3.a);
            do {
                atomicLongFieldUpdater = b;
                j2 = atomicLongFieldUpdater.get(this);
                if (j2 >= j4 || atomicLongFieldUpdater.compareAndSet(this, j2, j4)) {
                }
                atomicLongFieldUpdater = b;
                j2 = atomicLongFieldUpdater.get(this);
                break;
            } while (atomicLongFieldUpdater.compareAndSet(this, j2, j4));
            if (w43.f3758a * ((long) C1361r3.a) < u()) {
                w43.a();
            }
        }
        return null;
    }

    public final long m() {
        return c.get(this);
    }

    public final Throwable n() {
        return (Throwable) f5613d.get(this);
    }

    public final boolean o() {
        return w(a.get(this), false);
    }

    public final Throwable p() {
        Throwable n = n();
        if (n == null) {
            return new C1342q5();
        }
        return n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(defpackage.C1484xq.b r7) {
        /*
            r6 = this;
        L_0x0000:
            r0 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = e
            boolean r0 = r1.compareAndSet(r6, r0, r7)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x000d
            r0 = r3
            goto L_0x0014
        L_0x000d:
            java.lang.Object r0 = r1.get(r6)
            if (r0 == 0) goto L_0x0000
            r0 = r2
        L_0x0014:
            if (r0 == 0) goto L_0x0017
            return
        L_0x0017:
            java.lang.Object r0 = r1.get(r6)
            zD r4 = defpackage.C1361r3.n
            if (r0 != r4) goto L_0x003a
            zD r5 = defpackage.C1361r3.o
        L_0x0021:
            boolean r0 = r1.compareAndSet(r6, r4, r5)
            if (r0 == 0) goto L_0x0029
            r0 = r3
            goto L_0x0030
        L_0x0029:
            java.lang.Object r0 = r1.get(r6)
            if (r0 == r4) goto L_0x0021
            r0 = r2
        L_0x0030:
            if (r0 == 0) goto L_0x0017
            java.lang.Throwable r0 = r6.n()
            r7.invoke(r0)
            return
        L_0x003a:
            zD r7 = defpackage.C1361r3.o
            if (r0 != r7) goto L_0x004a
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Another handler was already registered and successfully invoked"
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x004a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Another handler is already registered: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1296o3.q(xq$b):void");
    }

    public final long r() {
        return b.get(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011e, code lost:
        if (r16 == false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0120, code lost:
        r0.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0126, code lost:
        r1 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r1.b(r0, r17 + r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object s(E r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            r23 = this;
            r9 = r23
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f5610a
            java.lang.Object r1 = r0.get(r9)
            W4 r1 = (defpackage.W4) r1
        L_0x000a:
            r7 = 0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = a
            long r2 = r10.getAndIncrement(r9)
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r13 = r2 & r11
            r15 = 0
            boolean r16 = r9.w(r2, r15)
            int r8 = defpackage.C1361r3.a
            long r2 = (long) r8
            long r4 = r13 / r2
            long r2 = r13 % r2
            int r6 = (int) r2
            long r2 = r1.f3758a
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            v7 r3 = defpackage.C1438v7.COROUTINE_SUSPENDED
            if (r2 == 0) goto L_0x003f
            W4 r2 = a(r9, r4, r1)
            if (r2 != 0) goto L_0x003d
            if (r16 == 0) goto L_0x000a
            java.lang.Object r0 = r23.B(r24, r25)
            if (r0 != r3) goto L_0x01a7
            goto L_0x01a9
        L_0x003d:
            r5 = r2
            goto L_0x0040
        L_0x003f:
            r5 = r1
        L_0x0040:
            r1 = r23
            r2 = r5
            r4 = r3
            r3 = r6
            r15 = r4
            r4 = r24
            r19 = r5
            r18 = r6
            r5 = r13
            r20 = r8
            r8 = r16
            int r1 = b(r1, r2, r3, r4, r5, r7, r8)
            if (r1 == 0) goto L_0x01a2
            r8 = 1
            if (r1 == r8) goto L_0x01a7
            r7 = 2
            if (r1 == r7) goto L_0x0192
            r5 = 3
            r6 = 5
            r4 = 4
            if (r1 == r5) goto L_0x0080
            if (r1 == r4) goto L_0x006d
            if (r1 == r6) goto L_0x0067
            goto L_0x006a
        L_0x0067:
            r19.a()
        L_0x006a:
            r1 = r19
            goto L_0x000a
        L_0x006d:
            long r0 = r23.r()
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0078
            r19.a()
        L_0x0078:
            java.lang.Object r0 = r23.B(r24, r25)
            if (r0 != r15) goto L_0x01a7
            goto L_0x01a9
        L_0x0080:
            kotlin.coroutines.Continuation r1 = defpackage.r1.B(r25)
            kotlinx.coroutines.c r3 = defpackage.r1.z(r1)
            r16 = 0
            r1 = r23
            r2 = r19
            r25 = r3
            r3 = r18
            r11 = r4
            r4 = r24
            r12 = r6
            r5 = r13
            r12 = r7
            r7 = r25
            r11 = r8
            r8 = r16
            int r1 = b(r1, r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x0173
            if (r1 == r11) goto L_0x0170
            if (r1 == r12) goto L_0x0166
            r2 = 4
            if (r1 == r2) goto L_0x0142
            java.lang.String r13 = "unexpected"
            r2 = 5
            if (r1 != r2) goto L_0x0136
            r19.a()     // Catch:{ all -> 0x018b }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x018b }
            W4 r0 = (defpackage.W4) r0     // Catch:{ all -> 0x018b }
        L_0x00b8:
            long r1 = r10.getAndIncrement(r9)     // Catch:{ all -> 0x018b }
            r18 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r20 = r1 & r18
            r14 = 0
            boolean r16 = r9.w(r1, r14)     // Catch:{ all -> 0x018b }
            int r8 = defpackage.C1361r3.a     // Catch:{ all -> 0x018b }
            long r1 = (long) r8     // Catch:{ all -> 0x018b }
            long r3 = r20 / r1
            long r1 = r20 % r1
            int r7 = (int) r1     // Catch:{ all -> 0x018b }
            long r1 = r0.f3758a     // Catch:{ all -> 0x018b }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00e0
            W4 r1 = a(r9, r3, r0)     // Catch:{ all -> 0x018b }
            if (r1 != 0) goto L_0x00df
            if (r16 == 0) goto L_0x00b8
            goto L_0x0123
        L_0x00df:
            r0 = r1
        L_0x00e0:
            r1 = r23
            r2 = r0
            r3 = r7
            r4 = r24
            r5 = r20
            r17 = r7
            r7 = r25
            r22 = r8
            r8 = r16
            int r1 = b(r1, r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x0130
            if (r1 == r11) goto L_0x0170
            if (r1 == r12) goto L_0x011e
            r2 = 3
            if (r1 == r2) goto L_0x0114
            r3 = 4
            if (r1 == r3) goto L_0x0108
            r4 = 5
            if (r1 == r4) goto L_0x0104
            goto L_0x00b8
        L_0x0104:
            r0.a()     // Catch:{ all -> 0x018b }
            goto L_0x00b8
        L_0x0108:
            long r1 = r23.r()     // Catch:{ all -> 0x018b }
            int r1 = (r20 > r1 ? 1 : (r20 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0123
            r0.a()     // Catch:{ all -> 0x018b }
            goto L_0x0123
        L_0x0114:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x018b }
            java.lang.String r1 = r13.toString()     // Catch:{ all -> 0x018b }
            r0.<init>(r1)     // Catch:{ all -> 0x018b }
            throw r0     // Catch:{ all -> 0x018b }
        L_0x011e:
            if (r16 == 0) goto L_0x0126
            r0.h()     // Catch:{ all -> 0x018b }
        L_0x0123:
            r1 = r25
            goto L_0x014f
        L_0x0126:
            int r7 = r17 + r22
            r1 = r25
            r1.b(r0, r7)     // Catch:{ all -> 0x012e }
            goto L_0x017f
        L_0x012e:
            r0 = move-exception
            goto L_0x018e
        L_0x0130:
            r1 = r25
            r0.a()     // Catch:{ all -> 0x012e }
            goto L_0x017a
        L_0x0136:
            r1 = r25
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x012e }
            java.lang.String r2 = r13.toString()     // Catch:{ all -> 0x012e }
            r0.<init>(r2)     // Catch:{ all -> 0x012e }
            throw r0     // Catch:{ all -> 0x012e }
        L_0x0142:
            r1 = r25
            long r2 = r23.r()     // Catch:{ all -> 0x012e }
            int r0 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x014f
            r19.a()     // Catch:{ all -> 0x012e }
        L_0x014f:
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r9.f5614a     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x015a
            kotlin.coroutines.CoroutineContext r2 = r1.f5563a     // Catch:{ all -> 0x012e }
            r3 = r24
            defpackage.r1.h(r0, r3, r2)     // Catch:{ all -> 0x012e }
        L_0x015a:
            java.lang.Throwable r0 = r23.t()     // Catch:{ all -> 0x012e }
            Tt$a r0 = defpackage.r1.n(r0)     // Catch:{ all -> 0x012e }
            r1.resumeWith(r0)     // Catch:{ all -> 0x012e }
            goto L_0x017f
        L_0x0166:
            r1 = r25
            int r6 = r18 + r20
            r2 = r19
            r1.b(r2, r6)     // Catch:{ all -> 0x012e }
            goto L_0x017f
        L_0x0170:
            r1 = r25
            goto L_0x017a
        L_0x0173:
            r1 = r25
            r2 = r19
            r2.a()     // Catch:{ all -> 0x012e }
        L_0x017a:
            kotlin.Unit r0 = kotlin.Unit.a     // Catch:{ all -> 0x012e }
            r1.resumeWith(r0)     // Catch:{ all -> 0x012e }
        L_0x017f:
            java.lang.Object r0 = r1.r()
            if (r0 != r15) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            kotlin.Unit r0 = kotlin.Unit.a
        L_0x0188:
            if (r0 != r15) goto L_0x01a7
            goto L_0x01a9
        L_0x018b:
            r0 = move-exception
            r1 = r25
        L_0x018e:
            r1.z()
            throw r0
        L_0x0192:
            r3 = r24
            r2 = r19
            if (r16 == 0) goto L_0x01a7
            r2.h()
            java.lang.Object r0 = r23.B(r24, r25)
            if (r0 != r15) goto L_0x01a7
            goto L_0x01a9
        L_0x01a2:
            r2 = r19
            r2.a()
        L_0x01a7:
            kotlin.Unit r0 = kotlin.Unit.a
        L_0x01a9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1296o3.s(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Throwable t() {
        Throwable n = n();
        if (n == null) {
            return new C1362r5("Channel was closed");
        }
        return n;
    }

    /* JADX WARNING: type inference failed for: r2v13, types: [x6] */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c9, code lost:
        r3 = r3.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d0, code lost:
        if (r3 != null) goto L_0x0208;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = a
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x001e
            if (r2 == r3) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0023
        L_0x001e:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0023:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "capacity="
            r2.<init>(r5)
            int r5 = r0.f5615c
            r2.append(r5)
            r5 = 44
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            W4[] r2 = new defpackage.W4[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f5611b
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f5610a
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f5612c
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = defpackage.r1.F(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x006b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r2.next()
            r8 = r4
            W4 r8 = (defpackage.W4) r8
            W4<java.lang.Object> r9 = defpackage.C1361r3.f6939a
            if (r8 == r9) goto L_0x007e
            r8 = r7
            goto L_0x007f
        L_0x007e:
            r8 = r6
        L_0x007f:
            if (r8 == 0) goto L_0x006b
            r3.add(r4)
            goto L_0x006b
        L_0x0085:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x020c
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009a
            goto L_0x00b4
        L_0x009a:
            r4 = r3
            W4 r4 = (defpackage.W4) r4
            long r8 = r4.f3758a
        L_0x009f:
            java.lang.Object r4 = r2.next()
            r10 = r4
            W4 r10 = (defpackage.W4) r10
            long r10 = r10.f3758a
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ae
            r3 = r4
            r8 = r10
        L_0x00ae:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009f
        L_0x00b4:
            W4 r3 = (defpackage.W4) r3
            long r10 = r16.r()
            long r12 = r16.u()
        L_0x00be:
            int r2 = defpackage.C1361r3.a
            r4 = r6
        L_0x00c1:
            if (r4 >= r2) goto L_0x01c9
            long r8 = r3.f3758a
            int r14 = defpackage.C1361r3.a
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00d3
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x01d2
        L_0x00d3:
            java.lang.Object r15 = r3.k(r4)
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r3.a
            int r7 = r4 * 2
            java.lang.Object r6 = r6.get(r7)
            boolean r7 = r15 instanceof kotlinx.coroutines.CancellableContinuation
            if (r7 == 0) goto L_0x00f9
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ed
            if (r14 < 0) goto L_0x00ed
            java.lang.String r7 = "receive"
            goto L_0x0192
        L_0x00ed:
            if (r14 >= 0) goto L_0x00f5
            if (r7 < 0) goto L_0x00f5
            java.lang.String r7 = "send"
            goto L_0x0192
        L_0x00f5:
            java.lang.String r7 = "cont"
            goto L_0x0192
        L_0x00f9:
            boolean r7 = r15 instanceof defpackage.Tv
            if (r7 == 0) goto L_0x0113
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0107
            if (r14 < 0) goto L_0x0107
            java.lang.String r7 = "onReceive"
            goto L_0x0192
        L_0x0107:
            if (r14 >= 0) goto L_0x010f
            if (r7 < 0) goto L_0x010f
            java.lang.String r7 = "onSend"
            goto L_0x0192
        L_0x010f:
            java.lang.String r7 = "select"
            goto L_0x0192
        L_0x0113:
            boolean r7 = r15 instanceof defpackage.C0463Bs
            if (r7 == 0) goto L_0x011b
            java.lang.String r7 = "receiveCatching"
            goto L_0x0192
        L_0x011b:
            boolean r7 = r15 instanceof defpackage.C1296o3.b
            if (r7 == 0) goto L_0x0123
            java.lang.String r7 = "sendBroadcast"
            goto L_0x0192
        L_0x0123:
            boolean r7 = r15 instanceof defpackage.C1278nD
            if (r7 == 0) goto L_0x013b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "EB("
            r7.<init>(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x0192
        L_0x013b:
            zD r7 = defpackage.C1361r3.c
            boolean r7 = defpackage.C1177ig.a(r15, r7)
            if (r7 == 0) goto L_0x0145
            r7 = 1
            goto L_0x014b
        L_0x0145:
            zD r7 = defpackage.C1361r3.d
            boolean r7 = defpackage.C1177ig.a(r15, r7)
        L_0x014b:
            if (r7 == 0) goto L_0x0150
            java.lang.String r7 = "resuming_sender"
            goto L_0x0192
        L_0x0150:
            if (r15 != 0) goto L_0x0154
            r7 = 1
            goto L_0x015a
        L_0x0154:
            zD r7 = defpackage.C1361r3.f6941b
            boolean r7 = defpackage.C1177ig.a(r15, r7)
        L_0x015a:
            if (r7 == 0) goto L_0x015e
            r7 = 1
            goto L_0x0164
        L_0x015e:
            zD r7 = defpackage.C1361r3.f
            boolean r7 = defpackage.C1177ig.a(r15, r7)
        L_0x0164:
            if (r7 == 0) goto L_0x0168
            r7 = 1
            goto L_0x016e
        L_0x0168:
            zD r7 = defpackage.C1361r3.e
            boolean r7 = defpackage.C1177ig.a(r15, r7)
        L_0x016e:
            if (r7 == 0) goto L_0x0172
            r7 = 1
            goto L_0x0178
        L_0x0172:
            zD r7 = defpackage.C1361r3.h
            boolean r7 = defpackage.C1177ig.a(r15, r7)
        L_0x0178:
            if (r7 == 0) goto L_0x017c
            r7 = 1
            goto L_0x0182
        L_0x017c:
            zD r7 = defpackage.C1361r3.g
            boolean r7 = defpackage.C1177ig.a(r15, r7)
        L_0x0182:
            if (r7 == 0) goto L_0x0186
            r7 = 1
            goto L_0x018c
        L_0x0186:
            zD r7 = defpackage.C1361r3.i
            boolean r7 = defpackage.C1177ig.a(r15, r7)
        L_0x018c:
            if (r7 != 0) goto L_0x01c3
            java.lang.String r7 = r15.toString()
        L_0x0192:
            if (r6 == 0) goto L_0x01b1
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "("
            r8.<init>(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r1.append(r6)
            goto L_0x01c3
        L_0x01b1:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01c3:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00c1
        L_0x01c9:
            x6 r2 = r3.b()
            r3 = r2
            W4 r3 = (defpackage.W4) r3
            if (r3 != 0) goto L_0x0208
        L_0x01d2:
            int r2 = r1.length()
            if (r2 != 0) goto L_0x01da
            r6 = 1
            goto L_0x01db
        L_0x01da:
            r6 = 0
        L_0x01db:
            if (r6 != 0) goto L_0x0200
            int r2 = defpackage.C1337py.U0(r1)
            char r2 = r1.charAt(r2)
            if (r2 != r5) goto L_0x01f6
            int r2 = r1.length()
            r4 = 1
            int r2 = r2 - r4
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "this.deleteCharAt(index)"
            defpackage.C1177ig.e(r2, r3)
        L_0x01f6:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0200:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            java.lang.String r2 = "Char sequence is empty."
            r1.<init>(r2)
            throw r1
        L_0x0208:
            r6 = 0
            r7 = 1
            goto L_0x00be
        L_0x020c:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1296o3.toString():java.lang.String");
    }

    public final long u() {
        return a.get(this) & 1152921504606846975L;
    }

    public final void v(long j) {
        boolean z;
        boolean z2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        if ((atomicLongFieldUpdater.addAndGet(this, j) & Longs.MAX_POWER_OF_TWO) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            do {
                if ((atomicLongFieldUpdater.get(this) & Longs.MAX_POWER_OF_TWO) != 0) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
            } while (z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c1, code lost:
        r0 = (defpackage.W4) ((defpackage.C1473x6) defpackage.C1473x6.b.get(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0187, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(long r18, boolean r20) {
        /*
            r17 = this;
            r6 = r17
            r0 = 60
            long r0 = r18 >> r0
            int r0 = (int) r0
            r7 = 0
            if (r0 == 0) goto L_0x019b
            r8 = 1
            if (r0 == r8) goto L_0x019b
            r1 = 2
            r2 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r0 == r1) goto L_0x0103
            r1 = 3
            if (r0 != r1) goto L_0x00f3
            long r0 = r18 & r2
            W4 r0 = r6.i(r0)
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0021:
            int r4 = defpackage.C1361r3.a
            r5 = -1
            int r4 = r4 + r5
        L_0x0025:
            if (r5 >= r4) goto L_0x00c1
            int r9 = defpackage.C1361r3.a
            long r9 = (long) r9
            long r11 = r0.f3758a
            long r11 = r11 * r9
            long r9 = (long) r4
            long r11 = r11 + r9
        L_0x002f:
            java.lang.Object r9 = r0.k(r4)
            zD r10 = defpackage.C1361r3.f
            if (r9 == r10) goto L_0x00cd
            zD r10 = defpackage.C1361r3.f6940a
            java.util.concurrent.atomic.AtomicReferenceArray r13 = r0.a
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r14 = r6.f5614a
            if (r9 != r10) goto L_0x0062
            long r15 = r17.r()
            int r10 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r10 < 0) goto L_0x00cd
            zD r10 = defpackage.C1361r3.i
            boolean r9 = r0.j(r4, r9, r10)
            if (r9 == 0) goto L_0x002f
            if (r14 == 0) goto L_0x005b
            int r9 = r4 * 2
            java.lang.Object r9 = r13.get(r9)
            cA r3 = defpackage.r1.i(r14, r9, r3)
        L_0x005b:
            r0.m(r4, r1)
            r0.h()
            goto L_0x00bd
        L_0x0062:
            zD r10 = defpackage.C1361r3.f6941b
            if (r9 == r10) goto L_0x00b2
            if (r9 != 0) goto L_0x0069
            goto L_0x00b2
        L_0x0069:
            boolean r10 = r9 instanceof defpackage.C1256mD
            if (r10 != 0) goto L_0x007e
            boolean r10 = r9 instanceof defpackage.C1278nD
            if (r10 == 0) goto L_0x0072
            goto L_0x007e
        L_0x0072:
            zD r10 = defpackage.C1361r3.d
            if (r9 == r10) goto L_0x00cd
            zD r13 = defpackage.C1361r3.c
            if (r9 != r13) goto L_0x007b
            goto L_0x00cd
        L_0x007b:
            if (r9 == r10) goto L_0x002f
            goto L_0x00bd
        L_0x007e:
            long r15 = r17.r()
            int r10 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r10 < 0) goto L_0x00cd
            boolean r10 = r9 instanceof defpackage.C1278nD
            if (r10 == 0) goto L_0x0090
            r10 = r9
            nD r10 = (defpackage.C1278nD) r10
            mD r10 = r10.a
            goto L_0x0093
        L_0x0090:
            r10 = r9
            mD r10 = (defpackage.C1256mD) r10
        L_0x0093:
            zD r15 = defpackage.C1361r3.i
            boolean r9 = r0.j(r4, r9, r15)
            if (r9 == 0) goto L_0x002f
            if (r14 == 0) goto L_0x00a7
            int r9 = r4 * 2
            java.lang.Object r9 = r13.get(r9)
            cA r3 = defpackage.r1.i(r14, r9, r3)
        L_0x00a7:
            java.lang.Object r2 = defpackage.r1.K(r2, r10)
            r0.m(r4, r1)
            r0.h()
            goto L_0x00bd
        L_0x00b2:
            zD r10 = defpackage.C1361r3.i
            boolean r9 = r0.j(r4, r9, r10)
            if (r9 == 0) goto L_0x002f
            r0.h()
        L_0x00bd:
            int r4 = r4 + -1
            goto L_0x0025
        L_0x00c1:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = defpackage.C1473x6.b
            java.lang.Object r0 = r4.get(r0)
            x6 r0 = (defpackage.C1473x6) r0
            W4 r0 = (defpackage.W4) r0
            if (r0 != 0) goto L_0x0021
        L_0x00cd:
            if (r2 == 0) goto L_0x00ee
            boolean r0 = r2 instanceof java.util.ArrayList
            if (r0 != 0) goto L_0x00d9
            mD r2 = (defpackage.C1256mD) r2
            r6.D(r2, r7)
            goto L_0x00ee
        L_0x00d9:
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r0 = r2.size()
            int r0 = r0 + r5
        L_0x00e0:
            if (r5 >= r0) goto L_0x00ee
            java.lang.Object r1 = r2.get(r0)
            mD r1 = (defpackage.C1256mD) r1
            r6.D(r1, r7)
            int r0 = r0 + -1
            goto L_0x00e0
        L_0x00ee:
            if (r3 != 0) goto L_0x00f2
            goto L_0x019a
        L_0x00f2:
            throw r3
        L_0x00f3:
            java.lang.String r1 = "unexpected close status: "
            java.lang.String r0 = defpackage.lf.h(r1, r0)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0103:
            long r0 = r18 & r2
            r6.i(r0)
            if (r20 == 0) goto L_0x019a
        L_0x010a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f5611b
            java.lang.Object r1 = r0.get(r6)
            W4 r1 = (defpackage.W4) r1
            long r2 = r17.r()
            long r4 = r17.u()
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x011f
            goto L_0x013c
        L_0x011f:
            int r4 = defpackage.C1361r3.a
            long r4 = (long) r4
            long r9 = r2 / r4
            long r11 = r1.f3758a
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x013e
            W4 r1 = r6.l(r9, r1)
            if (r1 != 0) goto L_0x013e
            java.lang.Object r0 = r0.get(r6)
            W4 r0 = (defpackage.W4) r0
            long r0 = r0.f3758a
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x010a
        L_0x013c:
            r0 = r7
            goto L_0x018b
        L_0x013e:
            r1.a()
            long r4 = r2 % r4
            int r0 = (int) r4
        L_0x0144:
            java.lang.Object r4 = r1.k(r0)
            if (r4 == 0) goto L_0x017c
            zD r5 = defpackage.C1361r3.f6941b
            if (r4 != r5) goto L_0x014f
            goto L_0x017c
        L_0x014f:
            zD r0 = defpackage.C1361r3.f6940a
            if (r4 != r0) goto L_0x0154
            goto L_0x017a
        L_0x0154:
            zD r0 = defpackage.C1361r3.g
            if (r4 != r0) goto L_0x0159
            goto L_0x0187
        L_0x0159:
            zD r0 = defpackage.C1361r3.i
            if (r4 != r0) goto L_0x015e
            goto L_0x0187
        L_0x015e:
            zD r0 = defpackage.C1361r3.f
            if (r4 != r0) goto L_0x0163
            goto L_0x0187
        L_0x0163:
            zD r0 = defpackage.C1361r3.e
            if (r4 != r0) goto L_0x0168
            goto L_0x0187
        L_0x0168:
            zD r0 = defpackage.C1361r3.d
            if (r4 != r0) goto L_0x016d
            goto L_0x017a
        L_0x016d:
            zD r0 = defpackage.C1361r3.c
            if (r4 != r0) goto L_0x0172
            goto L_0x0187
        L_0x0172:
            long r0 = r17.r()
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0187
        L_0x017a:
            r0 = r8
            goto L_0x0188
        L_0x017c:
            zD r5 = defpackage.C1361r3.e
            boolean r4 = r1.j(r0, r4, r5)
            if (r4 == 0) goto L_0x0144
            r17.k()
        L_0x0187:
            r0 = r7
        L_0x0188:
            if (r0 == 0) goto L_0x018e
            r0 = r8
        L_0x018b:
            if (r0 != 0) goto L_0x019b
            goto L_0x019a
        L_0x018e:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = b
            r4 = 1
            long r4 = r4 + r2
            r1 = r17
            r0.compareAndSet(r1, r2, r4)
            goto L_0x010a
        L_0x019a:
            r7 = r8
        L_0x019b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1296o3.w(long, boolean):boolean");
    }

    public final boolean x() {
        return w(a.get(this), true);
    }

    public boolean y() {
        return false;
    }

    public final boolean z() {
        long m = m();
        if (m == 0 || m == Long.MAX_VALUE) {
            return true;
        }
        return false;
    }
}
