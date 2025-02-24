package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");
    private static final int TIMEOUT_SEC = 4;

    private Utils() {
    }

    public static <T> T awaitEvenIfOnMainThread(Task<T> task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, new L(countDownLatch, 5));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3, TimeUnit.SECONDS);
        } else {
            countDownLatch.await(4, TimeUnit.SECONDS);
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new TimeoutException();
        }
    }

    @CanIgnoreReturnValue
    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static <T> Task<T> callTask(Executor executor, Callable<Task<T>> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new C0225ia(callable, 1, executor, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$callTask$2(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        } else if (task.getException() == null) {
            return null;
        } else {
            taskCompletionSource.setException(task.getException());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$callTask$3(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, new C0269mC(taskCompletionSource));
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$race$0(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        } else if (task.getException() == null) {
            return null;
        } else {
            taskCompletionSource.trySetException(task.getException());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$race$1(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        } else if (task.getException() == null) {
            return null;
        } else {
            taskCompletionSource.trySetException(task.getException());
            return null;
        }
    }

    @SuppressLint({"TaskMainThread"})
    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Vf vf = new Vf(taskCompletionSource, 4);
        task.continueWith(vf);
        task2.continueWith(vf);
        return taskCompletionSource.getTask();
    }

    public static <T> Task<T> race(Executor executor, Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        lC lCVar = new lC(taskCompletionSource, 7);
        task.continueWith(executor, lCVar);
        task2.continueWith(executor, lCVar);
        return taskCompletionSource.getTask();
    }
}
