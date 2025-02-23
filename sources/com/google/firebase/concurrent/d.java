package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ DelegatingScheduledFuture.Completer a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2826a;
    public final /* synthetic */ int c;

    public /* synthetic */ d(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.c = i;
        this.f2826a = runnable;
        this.a = completer;
    }

    public final void run() {
        int i = this.c;
        DelegatingScheduledFuture.Completer completer = this.a;
        Runnable runnable = this.f2826a;
        switch (i) {
            case 0:
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(runnable, completer);
                return;
            default:
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(runnable, completer);
                return;
        }
    }
}
