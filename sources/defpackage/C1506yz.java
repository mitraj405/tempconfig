package defpackage;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.c;

/* renamed from: yz  reason: default package and case insensitive filesystem */
/* compiled from: Tasks.kt */
public final class C1506yz {
    public static final <T> Object a(Task<T> task, Continuation<? super T> continuation) {
        if (task.isComplete()) {
            Exception exception = task.getException();
            if (exception != null) {
                throw exception;
            } else if (!task.isCanceled()) {
                return task.getResult();
            } else {
                throw new CancellationException("Task " + task + " was cancelled normally.");
            }
        } else {
            c cVar = new c(1, r1.B(continuation));
            cVar.s();
            task.addOnCompleteListener((Executor) C1105f9.a, (OnCompleteListener<T>) new C1490xz(cVar));
            return cVar.r();
        }
    }
}
