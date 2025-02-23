package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ DelegatingScheduledExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f2837a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2838a;

    public /* synthetic */ i(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.a = delegatingScheduledExecutorService;
        this.f2838a = runnable;
        this.f2837a = completer;
    }

    public final void run() {
        this.a.lambda$schedule$1(this.f2838a, this.f2837a);
    }
}
