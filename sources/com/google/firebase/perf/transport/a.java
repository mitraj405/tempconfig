package com.google.firebase.perf.transport;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ PendingPerfEvent a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TransportManager f2860a;

    public /* synthetic */ a(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        this.f2860a = transportManager;
        this.a = pendingPerfEvent;
    }

    public final void run() {
        this.f2860a.lambda$finishInitialization$0(this.a);
    }
}
