package com.google.firebase.concurrent;

import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class l implements Callable {
    public final /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2842a;

    public /* synthetic */ l(Runnable runnable, Object obj) {
        this.f2842a = runnable;
        this.a = obj;
    }

    public final Object call() {
        return this.f2842a.run();
    }
}
