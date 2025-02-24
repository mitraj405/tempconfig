package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class DelegatingScheduledExecutorService implements ScheduledExecutorService {
    private final ExecutorService delegate;
    private final ScheduledExecutorService scheduler;

    public DelegatingScheduledExecutorService(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.delegate = executorService;
        this.scheduler = scheduledExecutorService;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$schedule$0(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
            completer.set(null);
        } catch (Exception e) {
            completer.setException(e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$schedule$1(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new c(runnable, completer, 1));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture lambda$schedule$2(Runnable runnable, long j, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.schedule(new i(this, runnable, completer), j, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$schedule$3(Callable callable, DelegatingScheduledFuture.Completer completer) {
        try {
            completer.set(callable.call());
        } catch (Exception e) {
            completer.setException(e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Future lambda$schedule$4(Callable callable, DelegatingScheduledFuture.Completer completer) throws Exception {
        return this.delegate.submit(new c(callable, completer, 0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture lambda$schedule$5(Callable callable, long j, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.schedule(new j(this, callable, completer), j, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$scheduleAtFixedRate$6(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e) {
            completer.setException(e);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleAtFixedRate$7(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new d(runnable, completer, 0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture lambda$scheduleAtFixedRate$8(Runnable runnable, long j, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.scheduleAtFixedRate(new e(this, runnable, completer), j, j2, timeUnit);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleWithFixedDelay$10(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.delegate.execute(new d(runnable, completer, 1));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture lambda$scheduleWithFixedDelay$11(Runnable runnable, long j, long j2, TimeUnit timeUnit, DelegatingScheduledFuture.Completer completer) {
        return this.scheduler.scheduleWithFixedDelay(new g(this, runnable, completer), j, j2, timeUnit);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$scheduleWithFixedDelay$9(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e) {
            completer.setException(e);
        }
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return this.delegate.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new b(this, runnable, j, timeUnit, 1));
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new h(this, runnable, j, j2, timeUnit));
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new f(this, runnable, j, j2, timeUnit));
    }

    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.delegate.invokeAny(collection, j, timeUnit);
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new b(this, callable, j, timeUnit, 0));
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    public Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }
}
