package defpackage;

import in.juspay.services.HyperServices;

/* renamed from: ff  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1111ff implements Runnable {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ HyperServices f5463a;

    public /* synthetic */ C1111ff(HyperServices hyperServices, long j) {
        this.f5463a = hyperServices;
        this.a = j;
    }

    public final void run() {
        this.f5463a.lambda$terminate$7(this.a);
    }
}
