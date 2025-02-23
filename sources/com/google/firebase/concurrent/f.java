package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class f implements DelegatingScheduledFuture.Resolver {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DelegatingScheduledExecutorService f2829a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2830a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TimeUnit f2831a;
    public final /* synthetic */ long b;

    public /* synthetic */ f(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        this.f2829a = delegatingScheduledExecutorService;
        this.f2830a = runnable;
        this.a = j;
        this.b = j2;
        this.f2831a = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        return this.f2829a.lambda$scheduleWithFixedDelay$11(this.f2830a, this.a, this.b, this.f2831a, completer);
    }
}
