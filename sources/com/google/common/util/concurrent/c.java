package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionSequencer;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ ExecutionSequencer.TaskNonReentrantExecutor a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ListenableFuture f2814a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SettableFuture f2815a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TrustedListenableFutureTask f2816a;
    public final /* synthetic */ ListenableFuture b;

    public /* synthetic */ c(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor) {
        this.f2816a = trustedListenableFutureTask;
        this.f2815a = settableFuture;
        this.f2814a = listenableFuture;
        this.b = listenableFuture2;
        this.a = taskNonReentrantExecutor;
    }

    public final void run() {
        ExecutionSequencer.lambda$submitAsync$0(this.f2816a, this.f2815a, this.f2814a, this.b, this.a);
    }
}
