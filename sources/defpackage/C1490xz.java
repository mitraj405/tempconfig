package defpackage;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.c;

/* renamed from: xz  reason: default package and case insensitive filesystem */
/* compiled from: Tasks.kt */
public final class C1490xz<TResult> implements OnCompleteListener {
    public final /* synthetic */ CancellableContinuation<Object> a;

    public C1490xz(c cVar) {
        this.a = cVar;
    }

    public final void onComplete(Task<Object> task) {
        Exception exception = task.getException();
        CancellableContinuation<Object> cancellableContinuation = this.a;
        if (exception != null) {
            cancellableContinuation.resumeWith(r1.n(exception));
        } else if (task.isCanceled()) {
            cancellableContinuation.p((Throwable) null);
        } else {
            cancellableContinuation.resumeWith(task.getResult());
        }
    }
}
