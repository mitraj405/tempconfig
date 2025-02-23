package kotlinx.coroutines;

import defpackage.C1171i7;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* compiled from: CoroutineDispatcher.kt */
public abstract class CoroutineDispatcher extends C1232l implements C1171i7 {
    public static final a a = new a();

    /* compiled from: CoroutineDispatcher.kt */
    public static final class a extends C1250m<C1171i7, CoroutineDispatcher> {

        /* renamed from: kotlinx.coroutines.CoroutineDispatcher$a$a  reason: collision with other inner class name */
        /* compiled from: CoroutineDispatcher.kt */
        public static final class C0076a extends C0595Mh implements Function1<CoroutineContext.b, CoroutineDispatcher> {
            public static final C0076a a = new C0076a();

            public C0076a() {
                super(1);
            }

            public final Object invoke(Object obj) {
                CoroutineContext.b bVar = (CoroutineContext.b) obj;
                if (bVar instanceof CoroutineDispatcher) {
                    return (CoroutineDispatcher) bVar;
                }
                return null;
            }
        }

        public a() {
            super(C1171i7.a.a, C0076a.a);
        }
    }

    public CoroutineDispatcher() {
        super(C1171i7.a.a);
    }

    public final C1173i9 A(Continuation continuation) {
        return new C1173i9(this, continuation);
    }

    public final void Q(Continuation<?> continuation) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        c cVar;
        C1173i9 i9Var = (C1173i9) continuation;
        do {
            atomicReferenceFieldUpdater = C1173i9.a;
        } while (atomicReferenceFieldUpdater.get(i9Var) == r1.e);
        Object obj = atomicReferenceFieldUpdater.get(i9Var);
        if (obj instanceof c) {
            cVar = (c) obj;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.n();
        }
    }

    public final <E extends CoroutineContext.b> E b(CoroutineContext.c<E> cVar) {
        boolean z;
        C1177ig.f(cVar, "key");
        if (cVar instanceof C1250m) {
            C1250m mVar = (C1250m) cVar;
            CoroutineContext.c<?> cVar2 = this.a;
            C1177ig.f(cVar2, "key");
            if (cVar2 == mVar || mVar.a == cVar2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                E e = (CoroutineContext.b) mVar.f5594a.invoke(this);
                if (e instanceof CoroutineContext.b) {
                    return e;
                }
            }
        } else if (C1171i7.a.a == cVar) {
            return this;
        }
        return null;
    }

    public abstract void h(CoroutineContext coroutineContext, Runnable runnable);

    public final CoroutineContext l(CoroutineContext.c<?> cVar) {
        boolean z;
        C1177ig.f(cVar, "key");
        boolean z2 = cVar instanceof C1250m;
        C1440va vaVar = C1440va.a;
        if (z2) {
            C1250m mVar = (C1250m) cVar;
            CoroutineContext.c<?> cVar2 = this.a;
            C1177ig.f(cVar2, "key");
            if (cVar2 == mVar || mVar.a == cVar2) {
                z = true;
            } else {
                z = false;
            }
            if (z && ((CoroutineContext.b) mVar.f5594a.invoke(this)) != null) {
                return vaVar;
            }
        } else if (C1171i7.a.a == cVar) {
            return vaVar;
        }
        return this;
    }

    public boolean q() {
        return !(this instanceof l);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + C1149h8.a(this);
    }
}
