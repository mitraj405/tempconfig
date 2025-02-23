package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ImmutableCollection a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AggregateFuture f2813a;

    public /* synthetic */ b(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        this.f2813a = aggregateFuture;
        this.a = immutableCollection;
    }

    public final void run() {
        this.f2813a.lambda$init$1(this.a);
    }
}
