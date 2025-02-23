package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ DelegatingScheduledExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f2827a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2828a;

    public /* synthetic */ e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        this.a = delegatingScheduledExecutorService;
        this.f2828a = runnable;
        this.f2827a = completer;
    }

    public final void run() {
        this.a.lambda$scheduleAtFixedRate$7(this.f2828a, this.f2827a);
    }
}
