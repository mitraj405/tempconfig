package com.google.firebase.concurrent;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ LimitedConcurrencyExecutor a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2841a;

    public /* synthetic */ k(LimitedConcurrencyExecutor limitedConcurrencyExecutor, Runnable runnable) {
        this.a = limitedConcurrencyExecutor;
        this.f2841a = runnable;
    }

    public final void run() {
        this.a.lambda$decorate$0(this.f2841a);
    }
}
