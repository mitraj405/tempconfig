package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g;

/* renamed from: i9  reason: default package and case insensitive filesystem */
/* compiled from: DispatchedContinuation.kt */
public final class C1173i9<T> extends g<T> implements CoroutineStackFrame, Continuation<T> {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C1173i9.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: a  reason: collision with other field name */
    public Object f5485a = r1.d;

    /* renamed from: a  reason: collision with other field name */
    public final Continuation<T> f5486a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineDispatcher f5487a;
    public final Object b;

    public C1173i9(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.f5487a = coroutineDispatcher;
        this.f5486a = continuation;
        Object C = getContext().C(0, C0673Rz.a);
        C1177ig.c(C);
        this.b = C;
    }

    public final void a(Object obj, CancellationException cancellationException) {
        if (obj instanceof C0690T5) {
            ((C0690T5) obj).f3797a.invoke(cancellationException);
        }
    }

    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f5486a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final CoroutineContext getContext() {
        return this.f5486a.getContext();
    }

    public final Object h() {
        Object obj = this.f5485a;
        this.f5485a = r1.d;
        return obj;
    }

    public final void resumeWith(Object obj) {
        Object obj2;
        boolean z;
        CoroutineContext context;
        Object b2;
        Continuation<T> continuation = this.f5486a;
        CoroutineContext context2 = continuation.getContext();
        Throwable a2 = C0698Tt.a(obj);
        if (a2 == null) {
            obj2 = obj;
        } else {
            obj2 = new C0677S5(false, a2);
        }
        CoroutineDispatcher coroutineDispatcher = this.f5487a;
        if (coroutineDispatcher.q()) {
            this.f5485a = obj2;
            this.c = 0;
            coroutineDispatcher.h(context2, this);
            return;
        }
        C0765Za a3 = C0686Sz.a();
        if (a3.a >= 4294967296L) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f5485a = obj2;
            this.c = 0;
            C0534I1<g<?>> i1 = a3.f3880a;
            if (i1 == null) {
                i1 = new C0534I1<>();
                a3.f3880a = i1;
            }
            i1.addLast(this);
            return;
        }
        a3.s(true);
        try {
            context = getContext();
            b2 = C0673Rz.b(context, this.b);
            continuation.resumeWith(obj);
            Unit unit = Unit.a;
            C0673Rz.a(context, b2);
            do {
            } while (a3.v());
        } catch (Throwable th) {
            try {
                f(th, (Throwable) null);
            } catch (Throwable th2) {
                a3.r(true);
                throw th2;
            }
        }
        a3.r(true);
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f5487a + ", " + C1149h8.b(this.f5486a) + ']';
    }

    public final Continuation<T> c() {
        return this;
    }
}
