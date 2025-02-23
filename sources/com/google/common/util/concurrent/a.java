package com.google.common.util.concurrent;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AggregateFuture a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ListenableFuture f2812a;
    public final /* synthetic */ int c;

    public /* synthetic */ a(AggregateFuture aggregateFuture, ListenableFuture listenableFuture, int i) {
        this.a = aggregateFuture;
        this.f2812a = listenableFuture;
        this.c = i;
    }

    public final void run() {
        this.a.lambda$init$0(this.f2812a, this.c);
    }
}
