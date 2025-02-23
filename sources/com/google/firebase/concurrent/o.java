package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class o implements Callable {
    public final /* synthetic */ Runnable a;

    public /* synthetic */ o(Runnable runnable) {
        this.a = runnable;
    }

    public final Object call() {
        return this.a.run();
    }
}
