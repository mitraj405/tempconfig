package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public class zzfru extends Handler {
    public zzfru() {
        Looper.getMainLooper();
    }

    public final void dispatchMessage(Message message) {
        zza(message);
    }

    public void zza(Message message) {
        super.dispatchMessage(message);
    }

    public zzfru(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }
}
