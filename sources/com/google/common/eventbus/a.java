package com.google.common.eventbus;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Subscriber a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2811a;

    public /* synthetic */ a(Object obj, Subscriber subscriber) {
        this.a = subscriber;
        this.f2811a = obj;
    }

    public final void run() {
        this.a.lambda$dispatchEvent$0(this.f2811a);
    }
}
