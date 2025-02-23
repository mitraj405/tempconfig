package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ Callable a;

    public /* synthetic */ h(Callable callable) {
        this.a = callable;
    }

    public final void run() {
        WrappingExecutorService.lambda$wrapTask$0(this.a);
    }
}
