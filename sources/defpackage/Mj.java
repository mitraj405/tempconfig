package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* renamed from: Mj  reason: default package */
/* compiled from: LottieTask */
public final class Mj<T> {
    public static final ExecutorService a = Executors.newCachedThreadPool();

    /* renamed from: a  reason: collision with other field name */
    public volatile Lj<T> f407a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f408a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashSet f409a;
    public final LinkedHashSet b;

    /* renamed from: Mj$a */
    /* compiled from: LottieTask */
    public class a extends FutureTask<Lj<T>> {
        public a(Callable<Lj<T>> callable) {
            super(callable);
        }

        public final void done() {
            Mj mj = Mj.this;
            if (!isCancelled()) {
                try {
                    mj.b((Lj) get());
                } catch (InterruptedException | ExecutionException e) {
                    mj.b(new Lj(e));
                }
            }
        }
    }

    public Mj() {
        throw null;
    }

    public Mj(Callable<Lj<T>> callable, boolean z) {
        this.f409a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.f408a = new Handler(Looper.getMainLooper());
        this.f407a = null;
        if (z) {
            try {
                b(callable.call());
            } catch (Throwable th) {
                b(new Lj(th));
            }
        } else {
            a.execute(new a(callable));
        }
    }

    public final synchronized void a(Hj hj) {
        V v;
        Lj<T> lj = this.f407a;
        if (!(lj == null || (v = lj.a) == null)) {
            hj.onResult(v);
        }
        this.f409a.add(hj);
    }

    public final void b(Lj<T> lj) {
        if (this.f407a == null) {
            this.f407a = lj;
            this.f408a.post(new C0140b6(this, 5));
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }
}
