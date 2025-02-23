package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {
    /* access modifiers changed from: private */
    public ListenableFuture<V> delegateRef;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> timer;

    public static final class Fire<V> implements Runnable {
        TimeoutFuture<V> timeoutFutureRef;

        public Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        public void run() {
            ListenableFuture access$000;
            String str;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture != null && (access$000 = timeoutFuture.delegateRef) != null) {
                this.timeoutFutureRef = null;
                if (access$000.isDone()) {
                    timeoutFuture.setFuture(access$000);
                    return;
                }
                try {
                    ScheduledFuture access$100 = timeoutFuture.timer;
                    ScheduledFuture unused = timeoutFuture.timer = null;
                    str = "Timed out";
                    if (access$100 != null) {
                        long abs = Math.abs(access$100.getDelay(TimeUnit.MILLISECONDS));
                        if (abs > 10) {
                            StringBuilder sb = new StringBuilder(str.length() + 66);
                            sb.append("Timed out (timeout delayed by ");
                            sb.append(abs);
                            sb.append(" ms after scheduled time)");
                            str = sb.toString();
                        }
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(access$000);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
                    sb2.append(valueOf);
                    sb2.append(": ");
                    sb2.append(valueOf2);
                    timeoutFuture.setException(new TimeoutFutureException(sb2.toString()));
                    access$000.cancel(true);
                } catch (Throwable th) {
                    access$000.cancel(true);
                    throw th;
                }
            }
        }
    }

    public static final class TimeoutFutureException extends TimeoutException {
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        private TimeoutFutureException(String str) {
            super(str);
        }
    }

    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    public static <V> ListenableFuture<V> create(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.timer = scheduledExecutorService.schedule(fire, j, timeUnit);
        listenableFuture.addListener(fire, MoreExecutors.directExecutor());
        return timeoutFuture;
    }

    public void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }

    public String pendingToString() {
        ListenableFuture<V> listenableFuture = this.delegateRef;
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (listenableFuture == null) {
            return null;
        }
        String valueOf = String.valueOf(listenableFuture);
        String f = C0709Uj.f(valueOf.length() + 14, "inputFuture=[", valueOf, "]");
        if (scheduledFuture == null) {
            return f;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return f;
        }
        String valueOf2 = String.valueOf(f);
        StringBuilder sb = new StringBuilder(valueOf2.length() + 43);
        sb.append(valueOf2);
        sb.append(", remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }
}
