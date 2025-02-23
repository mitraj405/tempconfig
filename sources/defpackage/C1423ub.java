package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.j;

/* renamed from: ub  reason: default package and case insensitive filesystem */
/* compiled from: Executors.kt */
public final class C1423ub extends j implements C0481D8 {
    public final Executor a;

    public C1423ub(Executor executor) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        this.a = executor;
        Method method = C1453w6.a;
        try {
            if (executor instanceof ScheduledThreadPoolExecutor) {
                scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) executor;
            } else {
                scheduledThreadPoolExecutor = null;
            }
            if (scheduledThreadPoolExecutor != null) {
                Method method2 = C1453w6.a;
                if (method2 != null) {
                    method2.invoke(scheduledThreadPoolExecutor, new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void close() {
        ExecutorService executorService;
        Executor executor = this.a;
        if (executor instanceof ExecutorService) {
            executorService = (ExecutorService) executor;
        } else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1423ub) || ((C1423ub) obj).a != this.a) {
            return false;
        }
        return true;
    }

    public final void h(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            C1354qp.n(coroutineContext, cancellationException);
            C1213k9.a.h(coroutineContext, runnable);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.a);
    }

    public final String toString() {
        return this.a.toString();
    }
}
