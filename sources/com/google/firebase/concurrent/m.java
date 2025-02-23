package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class m implements Callable {
    public final /* synthetic */ Runnable a;

    public /* synthetic */ m(Runnable runnable) {
        this.a = runnable;
    }

    public final Object call() {
        return this.a.run();
    }
}
