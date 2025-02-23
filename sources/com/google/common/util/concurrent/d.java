package com.google.common.util.concurrent;

import com.google.common.util.concurrent.JdkFutureAdapters;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ JdkFutureAdapters.ListenableFutureAdapter a;

    public /* synthetic */ d(JdkFutureAdapters.ListenableFutureAdapter listenableFutureAdapter) {
        this.a = listenableFutureAdapter;
    }

    public final void run() {
        this.a.lambda$addListener$0();
    }
}
