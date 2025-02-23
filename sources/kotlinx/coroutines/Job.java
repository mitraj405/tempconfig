package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* compiled from: Job.kt */
public interface Job extends CoroutineContext.b {
    public static final /* synthetic */ int b = 0;

    /* compiled from: Job.kt */
    public static final class a {
        public static /* synthetic */ C1276n9 a(Job job, boolean z, C0610Ng ng, int i) {
            boolean z2 = false;
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return job.m0(z, z2, ng);
        }
    }

    /* compiled from: Job.kt */
    public static final class b implements CoroutineContext.c<Job> {
        public static final /* synthetic */ b a = new b();
    }

    C1276n9 W(Function1<? super Throwable, Unit> function1);

    Job a();

    void c(CancellationException cancellationException);

    CancellationException e();

    boolean isActive();

    boolean isCancelled();

    C1276n9 m0(boolean z, boolean z2, Function1<? super Throwable, Unit> function1);

    boolean start();

    C0778a5 z(k kVar);
}
