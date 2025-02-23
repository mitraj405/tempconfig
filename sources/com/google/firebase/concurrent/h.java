package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class h implements DelegatingScheduledFuture.Resolver {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DelegatingScheduledExecutorService f2834a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2835a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TimeUnit f2836a;
    public final /* synthetic */ long b;

    public /* synthetic */ h(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        this.f2834a = delegatingScheduledExecutorService;
        this.f2835a = runnable;
        this.a = j;
        this.b = j2;
        this.f2836a = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f2834a.lambda$scheduleAtFixedRate$8(this.f2835a, this.a, this.b, this.f2836a, completer);
    }
}
