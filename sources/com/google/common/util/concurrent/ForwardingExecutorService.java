package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingObject;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService {
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return delegate().awaitTermination(j, timeUnit);
    }

    public abstract ExecutorService delegate();

    public void execute(Runnable runnable) {
        delegate().execute(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return delegate().invokeAll(collection);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return delegate().invokeAny(collection);
    }

    public boolean isShutdown() {
        return delegate().isShutdown();
    }

    public boolean isTerminated() {
        return delegate().isTerminated();
    }

    public void shutdown() {
        delegate().shutdown();
    }

    public List<Runnable> shutdownNow() {
        return delegate().shutdownNow();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return delegate().submit(callable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return delegate().invokeAll(collection, j, timeUnit);
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return delegate().invokeAny(collection, j, timeUnit);
    }

    public Future<?> submit(Runnable runnable) {
        return delegate().submit(runnable);
    }

    public <T> Future<T> submit(Runnable runnable, @ParametricNullness T t) {
        return delegate().submit(runnable, t);
    }
}
