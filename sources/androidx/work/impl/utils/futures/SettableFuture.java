package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;
import defpackage.C0283o;

public final class SettableFuture<V> extends C0283o<V> {
    public final boolean h(V v) {
        if (v == null) {
            v = C0283o.b;
        }
        if (!C0283o.f3122a.b(this, (Object) null, v)) {
            return false;
        }
        C0283o.b(this);
        return true;
    }

    public final boolean i(Throwable th) {
        th.getClass();
        if (!C0283o.f3122a.b(this, (Object) null, new C0283o.c(th))) {
            return false;
        }
        C0283o.b(this);
        return true;
    }

    public final boolean j(ListenableFuture<? extends V> listenableFuture) {
        C0283o.f fVar;
        C0283o.c cVar;
        listenableFuture.getClass();
        Object obj = this.f3124a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!C0283o.f3122a.b(this, (Object) null, C0283o.e(listenableFuture))) {
                    return false;
                }
                C0283o.b(this);
            } else {
                fVar = new C0283o.f(this, listenableFuture);
                if (C0283o.f3122a.b(this, (Object) null, fVar)) {
                    try {
                        listenableFuture.addListener(fVar, e9.a);
                    } catch (Throwable unused) {
                        cVar = C0283o.c.a;
                    }
                } else {
                    obj = this.f3124a;
                }
            }
            return true;
        }
        if (!(obj instanceof C0283o.b)) {
            return false;
        }
        listenableFuture.cancel(((C0283o.b) obj).f3128a);
        return false;
        C0283o.f3122a.b(this, fVar, cVar);
        return true;
    }
}
