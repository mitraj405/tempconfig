package defpackage;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: H3  reason: default package */
/* compiled from: CallbackToFutureAdapter */
public final class H3<T> implements ListenableFuture<T> {
    public final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final WeakReference<F3<T>> f243a;

    /* renamed from: H3$a */
    /* compiled from: CallbackToFutureAdapter */
    public class a extends AbstractResolvableFuture<T> {
        public a() {
        }

        public final String pendingToString() {
            F3 f3 = H3.this.f243a.get();
            if (f3 == null) {
                return "Completer object has been garbage collected, future will fail soon";
            }
            return "tag=[" + f3.f188a + "]";
        }
    }

    public H3(F3<T> f3) {
        this.f243a = new WeakReference<>(f3);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.a.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        F3 f3 = this.f243a.get();
        boolean cancel = this.a.cancel(z);
        if (cancel && f3 != null) {
            f3.f188a = null;
            f3.f187a = null;
            f3.a.set(null);
        }
        return cancel;
    }

    public final T get() throws InterruptedException, ExecutionException {
        return this.a.get();
    }

    public final boolean isCancelled() {
        return this.a.isCancelled();
    }

    public final boolean isDone() {
        return this.a.isDone();
    }

    public final String toString() {
        return this.a.toString();
    }

    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.a.get(j, timeUnit);
    }
}
