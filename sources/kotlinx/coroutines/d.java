package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: CoroutineScope.kt */
public final class d {
    public static final C1085e7 a(CoroutineContext coroutineContext) {
        if (coroutineContext.b(Job.b.a) == null) {
            coroutineContext = coroutineContext.j(new Mg((Job) null));
        }
        return new C1085e7(coroutineContext);
    }

    public static final void b(ProducerScope producerScope, Throwable th) {
        CancellationException cancellationException = new CancellationException("Error listening for config updates.");
        cancellationException.initCause(th);
        Job job = (Job) producerScope.r().b(Job.b.a);
        if (job != null) {
            job.c(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + producerScope).toString());
    }
}
