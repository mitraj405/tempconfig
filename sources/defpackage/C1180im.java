package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.c;
import kotlinx.coroutines.sync.Mutex;

/* renamed from: im  reason: default package and case insensitive filesystem */
/* compiled from: Mutex.kt */
public final class C1180im extends Xv implements Mutex {
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(C1180im.class, Object.class, "owner");
    private volatile Object owner;

    /* renamed from: im$a */
    /* compiled from: Mutex.kt */
    public final class a implements CancellableContinuation<Unit>, C1256mD {

        /* renamed from: a  reason: collision with other field name */
        public final Object f5489a = null;

        /* renamed from: a  reason: collision with other field name */
        public final c<Unit> f5490a;

        public a(c cVar) {
            this.f5490a = cVar;
        }

        public final void b(Pv<?> pv, int i) {
            this.f5490a.b(pv, i);
        }

        public final C0422zD g(Object obj, Function1 function1) {
            C1180im imVar = C1180im.this;
            C1159hm hmVar = new C1159hm(imVar, this);
            C0422zD g = this.f5490a.g((Unit) obj, hmVar);
            if (g != null) {
                C1180im.c.set(imVar, this.f5489a);
            }
            return g;
        }

        public final CoroutineContext getContext() {
            return this.f5490a.f5563a;
        }

        public final void i(Function1<? super Throwable, Unit> function1) {
            this.f5490a.i(function1);
        }

        public final void k(Object obj) {
            this.f5490a.k(obj);
        }

        public final boolean p(Throwable th) {
            return this.f5490a.p(th);
        }

        public final void resumeWith(Object obj) {
            this.f5490a.resumeWith(obj);
        }

        public final void x(Object obj, Function1 function1) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1180im.c;
            Object obj2 = this.f5489a;
            C1180im imVar = C1180im.this;
            atomicReferenceFieldUpdater.set(imVar, obj2);
            C1136gm gmVar = new C1136gm(imVar, this);
            this.f5490a.x((Unit) obj, gmVar);
        }
    }

    /* renamed from: im$b */
    /* compiled from: Mutex.kt */
    public static final class b extends C0595Mh implements C0694Td<Tv<?>, Object, Object, Function1<? super Throwable, ? extends Unit>> {
        public final /* synthetic */ C1180im a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(C1180im imVar) {
            super(3);
            this.a = imVar;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Tv tv = (Tv) obj;
            return new C1200jm(this.a, obj2);
        }
    }

    public C1180im(boolean z) {
        super(z ? 1 : 0);
        C0422zD zDVar;
        if (z) {
            zDVar = null;
        } else {
            zDVar = C1354qp.g;
        }
        this.owner = zDVar;
        new b(this);
    }

    public final boolean a() {
        if (Math.max(Xv.a.get(this), 0) == 0) {
            return true;
        }
        return false;
    }

    public final void b(Object obj) {
        boolean z;
        while (a()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            C0422zD zDVar = C1354qp.g;
            if (obj2 != zDVar) {
                boolean z2 = false;
                if (obj2 == obj || obj == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, zDVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                break;
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        e();
                        return;
                    }
                } else {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public final Object c(C1148h7 h7Var) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Xv.a;
            int i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = this.f3840a;
            if (i2 > i3) {
                do {
                    i = atomicIntegerFieldUpdater.get(this);
                    if (i <= i3) {
                        break;
                    }
                } while (atomicIntegerFieldUpdater.compareAndSet(this, i, i3));
            } else {
                z = false;
                if (i2 <= 0) {
                    z2 = false;
                    break;
                } else if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 - 1)) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            c.set(this, (Object) null);
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            z = true;
        } else if (!z3) {
            if (!z3) {
                throw new IllegalStateException("unexpected".toString());
            }
            throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
        }
        if (z) {
            return Unit.a;
        }
        c z4 = r1.z(r1.B(h7Var));
        try {
            d(new a(z4));
            Object r = z4.r();
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            if (r != v7Var) {
                r = Unit.a;
            }
            if (r == v7Var) {
                return r;
            }
            return Unit.a;
        } catch (Throwable th) {
            z4.z();
            throw th;
        }
    }

    public final String toString() {
        return "Mutex@" + C1149h8.a(this) + "[isLocked=" + a() + ",owner=" + c.get(this) + ']';
    }
}
