package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements DelegatingScheduledFuture.Resolver {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ long f2821a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DelegatingScheduledExecutorService f2822a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2823a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TimeUnit f2824a;

    public /* synthetic */ b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j, TimeUnit timeUnit, int i) {
        this.a = i;
        this.f2822a = delegatingScheduledExecutorService;
        this.f2823a = obj;
        this.f2821a = j;
        this.f2824a = timeUnit;
    }

    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        int i = this.a;
        Object obj = this.f2823a;
        switch (i) {
            case 0:
                return this.f2822a.lambda$schedule$5((Callable) obj, this.f2821a, this.f2824a, completer);
            default:
                return this.f2822a.lambda$schedule$2((Runnable) obj, this.f2821a, this.f2824a, completer);
        }
    }
}
