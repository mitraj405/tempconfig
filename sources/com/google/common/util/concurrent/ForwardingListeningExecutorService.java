package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@CanIgnoreReturnValue
public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService {
    public abstract ListeningExecutorService delegate();

    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return delegate().submit(callable);
    }

    public ListenableFuture<?> submit(Runnable runnable) {
        return delegate().submit(runnable);
    }

    public <T> ListenableFuture<T> submit(Runnable runnable, @ParametricNullness T t) {
        return delegate().submit(runnable, t);
    }
}
