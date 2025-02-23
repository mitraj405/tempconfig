package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ DelegatingScheduledFuture.Completer a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2825a;
    public final /* synthetic */ int c;

    public /* synthetic */ c(Object obj, DelegatingScheduledFuture.Completer completer, int i) {
        this.c = i;
        this.f2825a = obj;
        this.a = completer;
    }

    public final void run() {
        int i = this.c;
        DelegatingScheduledFuture.Completer completer = this.a;
        Object obj = this.f2825a;
        switch (i) {
            case 0:
                DelegatingScheduledExecutorService.lambda$schedule$3((Callable) obj, completer);
                return;
            default:
                DelegatingScheduledExecutorService.lambda$schedule$0((Runnable) obj, completer);
                return;
        }
    }
}
