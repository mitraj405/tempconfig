package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

/* compiled from: AbstractCoroutine.kt */
public abstract class a<T> extends k implements Continuation<T>, CoroutineScope {
    public final CoroutineContext a;

    public a(CoroutineContext coroutineContext, boolean z) {
        super(z);
        V((Job) coroutineContext.b(Job.b.a));
        this.a = coroutineContext.j(this);
    }

    public final String D() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public final void U(V5 v5) {
        C1399t7.a(this.a, v5);
    }

    public final String b0() {
        return super.b0();
    }

    public final void e0(Object obj) {
        boolean z;
        if (obj instanceof C0677S5) {
            C0677S5 s5 = (C0677S5) obj;
            Throwable th = s5.f3789a;
            s5.getClass();
            if (C0677S5.a.get(s5) != 0) {
                z = true;
            } else {
                z = false;
            }
            o0(z, th);
            return;
        }
        p0(obj);
    }

    public final CoroutineContext getContext() {
        return this.a;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public void n0(Object obj) {
        v(obj);
    }

    public final void q0(int i, a aVar, Function2 function2) {
        CoroutineContext coroutineContext;
        Object b;
        if (i != 0) {
            int i2 = i - 1;
            if (i2 == 0) {
                try {
                    r1.M(r1.B(r1.m(aVar, this, function2)), Unit.a, (Function1) null);
                } catch (Throwable th) {
                    resumeWith(r1.n(th));
                    throw th;
                }
            } else if (i2 == 1) {
            } else {
                if (i2 == 2) {
                    C1177ig.f(function2, "<this>");
                    r1.B(r1.m(aVar, this, function2)).resumeWith(Unit.a);
                } else if (i2 == 3) {
                    try {
                        coroutineContext = this.a;
                        b = C0673Rz.b(coroutineContext, (Object) null);
                        C0648QA.a(2, function2);
                        Object invoke = function2.invoke(aVar, this);
                        C0673Rz.a(coroutineContext, b);
                        if (invoke != C1438v7.COROUTINE_SUSPENDED) {
                            resumeWith(invoke);
                        }
                    } catch (Throwable th2) {
                        resumeWith(r1.n(th2));
                    }
                } else {
                    throw new V5();
                }
            }
        } else {
            throw null;
        }
    }

    public final CoroutineContext r() {
        return this.a;
    }

    public final void resumeWith(Object obj) {
        Throwable a2 = C0698Tt.a(obj);
        if (a2 != null) {
            obj = new C0677S5(false, a2);
        }
        Object a0 = a0(obj);
        if (a0 != C1354qp.f6922b) {
            n0(a0);
        }
    }

    public void p0(T t) {
    }

    public void o0(boolean z, Throwable th) {
    }
}
