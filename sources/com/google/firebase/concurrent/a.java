package com.google.firebase.concurrent;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CustomThreadFactory a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f2820a;

    public /* synthetic */ a(CustomThreadFactory customThreadFactory, Runnable runnable) {
        this.a = customThreadFactory;
        this.f2820a = runnable;
    }

    public final void run() {
        this.a.lambda$newThread$0(this.f2820a);
    }
}
