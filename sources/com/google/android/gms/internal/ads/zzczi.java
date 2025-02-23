package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzczi implements Runnable {
    private final WeakReference zza;

    public /* synthetic */ zzczi(zzczj zzczj, zzczh zzczh) {
        this.zza = new WeakReference(zzczj);
    }

    public final void run() {
        zzczj zzczj = (zzczj) this.zza.get();
        if (zzczj != null) {
            zzczj.zzq(new zzcze());
        }
    }
}
