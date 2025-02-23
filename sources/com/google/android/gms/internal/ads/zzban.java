package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzban implements Runnable {
    public final /* synthetic */ zzbzt zza;
    public final /* synthetic */ Future zzb;

    public /* synthetic */ zzban(zzbzt zzbzt, Future future) {
        this.zza = zzbzt;
        this.zzb = future;
    }

    public final void run() {
        if (this.zza.isCancelled()) {
            this.zzb.cancel(true);
        }
    }
}
