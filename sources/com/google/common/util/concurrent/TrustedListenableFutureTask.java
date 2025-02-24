package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {
    private volatile InterruptibleTask<?> task;

    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        public TrustedFutureInterruptibleAsyncTask(AsyncCallable<V> asyncCallable) {
            this.callable = (AsyncCallable) Preconditions.checkNotNull(asyncCallable);
        }

        public void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        public String toPendingString() {
            return this.callable.toString();
        }

        public void afterRanInterruptiblySuccess(ListenableFuture<V> listenableFuture) {
            TrustedListenableFutureTask.this.setFuture(listenableFuture);
        }

        public ListenableFuture<V> runInterruptibly() throws Exception {
            return (ListenableFuture) Preconditions.checkNotNull(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) this.callable);
        }
    }

    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;

        public TrustedFutureInterruptibleTask(Callable<V> callable2) {
            this.callable = (Callable) Preconditions.checkNotNull(callable2);
        }

        public void afterRanInterruptiblyFailure(Throwable th) {
            TrustedListenableFutureTask.this.setException(th);
        }

        public void afterRanInterruptiblySuccess(@ParametricNullness V v) {
            TrustedListenableFutureTask.this.set(v);
        }

        public final boolean isDone() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public TrustedListenableFutureTask(Callable<V> callable) {
        this.task = new TrustedFutureInterruptibleTask(callable);
    }

    public static <V> TrustedListenableFutureTask<V> create(AsyncCallable<V> asyncCallable) {
        return new TrustedListenableFutureTask<>(asyncCallable);
    }

    public void afterDone() {
        InterruptibleTask<?> interruptibleTask;
        super.afterDone();
        if (wasInterrupted() && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    public String pendingToString() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(interruptibleTask);
        return C0709Uj.f(valueOf.length() + 7, "task=[", valueOf, "]");
    }

    public void run() {
        InterruptibleTask<?> interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }

    public static <V> TrustedListenableFutureTask<V> create(Callable<V> callable) {
        return new TrustedListenableFutureTask<>(callable);
    }

    public TrustedListenableFutureTask(AsyncCallable<V> asyncCallable) {
        this.task = new TrustedFutureInterruptibleAsyncTask(asyncCallable);
    }

    public static <V> TrustedListenableFutureTask<V> create(Runnable runnable, @ParametricNullness V v) {
        return new TrustedListenableFutureTask<>(Executors.callable(runnable, v));
    }
}
