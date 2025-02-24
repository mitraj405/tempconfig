package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
        super(immutableCollection.size());
        this.futures = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
        this.allMustSucceed = z;
        this.collectsValues = z2;
    }

    private static boolean addCausalChain(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    private void collectValueFromNonCancelledFuture(int i, Future<? extends InputT> future) {
        try {
            collectOneValue(i, Futures.getDone(future));
        } catch (ExecutionException e) {
            handleException(e.getCause());
        } catch (Throwable th) {
            handleException(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: decrementCountAndMaybeComplete */
    public void lambda$init$1(ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        boolean z;
        int decrementRemainingAndGet = decrementRemainingAndGet();
        if (decrementRemainingAndGet >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Less than 0 remaining futures");
        if (decrementRemainingAndGet == 0) {
            processCompleted(immutableCollection);
        }
    }

    private void handleException(Throwable th) {
        Preconditions.checkNotNull(th);
        if (this.allMustSucceed && !setException(th) && addCausalChain(getOrInitSeenExceptions(), th)) {
            log(th);
        } else if (th instanceof Error) {
            log(th);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ListenableFuture listenableFuture, int i) {
        try {
            if (listenableFuture.isCancelled()) {
                this.futures = null;
                cancel(false);
            } else {
                collectValueFromNonCancelledFuture(i, listenableFuture);
            }
        } finally {
            lambda$init$1((ImmutableCollection) null);
        }
    }

    private static void log(Throwable th) {
        String str;
        if (th instanceof Error) {
            str = "Input Future failed with Error";
        } else {
            str = "Got more than one input Future failure. Logging failures after the first";
        }
        logger.log(Level.SEVERE, str, th);
    }

    private void processCompleted(ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        if (immutableCollection != null) {
            UnmodifiableIterator<? extends Future<? extends InputT>> it = immutableCollection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Future future = (Future) it.next();
                if (!future.isCancelled()) {
                    collectValueFromNonCancelledFuture(i, future);
                }
                i++;
            }
        }
        clearSeenExceptions();
        handleAllCompleted();
        releaseResources(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    public final void addInitialException(Set<Throwable> set) {
        Preconditions.checkNotNull(set);
        if (!isCancelled()) {
            Throwable tryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
            Objects.requireNonNull(tryInternalFastPathGetFailure);
            addCausalChain(set, tryInternalFastPathGetFailure);
        }
    }

    public final void afterDone() {
        boolean z;
        super.afterDone();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        releaseResources(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        boolean isCancelled = isCancelled();
        if (immutableCollection != null) {
            z = true;
        } else {
            z = false;
        }
        if (isCancelled && z) {
            boolean wasInterrupted = wasInterrupted();
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(wasInterrupted);
            }
        }
    }

    public abstract void collectOneValue(int i, @ParametricNullness InputT inputt);

    public abstract void handleAllCompleted();

    public final void init() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection;
        Objects.requireNonNull(this.futures);
        if (this.futures.isEmpty()) {
            handleAllCompleted();
        } else if (this.allMustSucceed) {
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
            int i = 0;
            while (it.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) it.next();
                listenableFuture.addListener(new a(this, listenableFuture, i), MoreExecutors.directExecutor());
                i++;
            }
        } else {
            if (this.collectsValues) {
                immutableCollection = this.futures;
            } else {
                immutableCollection = null;
            }
            b bVar = new b(this, immutableCollection);
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
            while (it2.hasNext()) {
                ((ListenableFuture) it2.next()).addListener(bVar, MoreExecutors.directExecutor());
            }
        }
    }

    public final String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        if (immutableCollection == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(immutableCollection);
        return C1058d.v(valueOf.length() + 8, "futures=", valueOf);
    }

    @ForOverride
    @OverridingMethodsMustInvokeSuper
    public void releaseResources(ReleaseResourcesReason releaseResourcesReason) {
        Preconditions.checkNotNull(releaseResourcesReason);
        this.futures = null;
    }
}
