package com.google.zxing.client.android;

import com.google.zxing.client.android.InactivityTimer;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ InactivityTimer.PowerStatusReceiver a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3938a;

    public /* synthetic */ a(InactivityTimer.PowerStatusReceiver powerStatusReceiver, boolean z) {
        this.a = powerStatusReceiver;
        this.f3938a = z;
    }

    public final void run() {
        this.a.lambda$onReceive$0(this.f3938a);
    }
}
