package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzczg implements Runnable {
    private final WeakReference zza;

    public /* synthetic */ zzczg(zzczj zzczj, zzczf zzczf) {
        this.zza = new WeakReference(zzczj);
    }

    public final void run() {
        zzczj zzczj = (zzczj) this.zza.get();
        if (zzczj != null) {
            zzczj.zzq(new zzczd());
        }
    }
}
