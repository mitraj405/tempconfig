package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class j implements Callable {
    public final /* synthetic */ DelegatingScheduledExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f2839a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Callable f2840a;

    public /* synthetic */ j(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Callable callable, DelegatingScheduledFuture.Completer completer) {
        this.a = delegatingScheduledExecutorService;
        this.f2840a = callable;
        this.f2839a = completer;
    }

    public final Object call() {
        return this.a.lambda$schedule$4(this.f2840a, this.f2839a);
    }
}
