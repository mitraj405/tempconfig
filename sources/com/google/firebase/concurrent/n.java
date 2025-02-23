package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class n implements Callable {
    public final /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2843a;

    public /* synthetic */ n(Runnable runnable, Object obj) {
        this.f2843a = runnable;
        this.a = obj;
    }

    public final Object call() {
        return this.f2843a.run();
    }
}
