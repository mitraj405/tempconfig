package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ DelegatingScheduledExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f2832a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2833a;

    public /* synthetic */ g(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.a = delegatingScheduledExecutorService;
        this.f2833a = runnable;
        this.f2832a = completer;
    }

    public final void run() {
        this.a.lambda$scheduleWithFixedDelay$10(this.f2833a, this.f2832a);
    }
}
