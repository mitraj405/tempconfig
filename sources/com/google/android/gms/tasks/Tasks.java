package com.google.android.gms.tasks;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.tasks.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
public final class Tasks {
    private Tasks() {
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzad = new zzad((zzac) null);
        zzb(task, zzad);
        zzad.zza();
        return zza(task);
    }

    @Deprecated
    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> forCanceled() {
        zzw zzw = new zzw();
        zzw.zzc();
        return zzw;
    }

    public static <TResult> Task<TResult> forException(Exception exc) {
        zzw zzw = new zzw();
        zzw.zza(exc);
        return zzw;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzw zzw = new zzw();
        zzw.zzb(tresult);
        return zzw;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzw zzw = new zzw();
        zzaf zzaf = new zzaf(collection.size(), zzw);
        for (Task zzb : collection) {
            zzb(zzb, zzaf);
        }
        return zzw;
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> collection) {
        return whenAllComplete(TaskExecutors.MAIN_THREAD, collection);
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task> collection) {
        return whenAllSuccess(TaskExecutors.MAIN_THREAD, collection);
    }

    public static <T> Task<T> withTimeout(Task<T> task, long j, TimeUnit timeUnit) {
        boolean z;
        Preconditions.checkNotNull(task, "Task must not be null");
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Timeout must be positive");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        zzb zzb = new zzb();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(zzb);
        zza zza = new zza(Looper.getMainLooper());
        zza.postDelayed(new zzx(taskCompletionSource), timeUnit.toMillis(j));
        task.addOnCompleteListener(new zzy(zza, taskCompletionSource, zzb));
        return taskCompletionSource.getTask();
    }

    private static Object zza(Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static void zzb(Task task, zzae zzae) {
        Executor executor = TaskExecutors.zza;
        task.addOnSuccessListener(executor, zzae);
        task.addOnFailureListener(executor, (OnFailureListener) zzae);
        task.addOnCanceledListener(executor, (OnCanceledListener) zzae);
    }

    @Deprecated
    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzw zzw = new zzw();
        executor.execute(new zzz(zzw, callable));
        return zzw;
    }

    public static Task<List<Task<?>>> whenAllComplete(Executor executor, Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWithTask(executor, new zzab(collection));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Executor executor, Collection<? extends Task> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll((Collection<? extends Task<?>>) collection).continueWith(executor, new zzaa(collection));
    }

    public static Task<List<Task<?>>> whenAllComplete(Executor executor, Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete(executor, (Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Executor executor, Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess(executor, (Collection<? extends Task>) Arrays.asList(taskArr));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess((Collection<? extends Task>) Arrays.asList(taskArr));
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult((Object) null);
        }
        return whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzad = new zzad((zzac) null);
        zzb(task, zzad);
        if (zzad.zzb(j, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
