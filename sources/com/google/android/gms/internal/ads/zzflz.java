package com.google.android.gms.internal.ads;

import java.util.Timer;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzflz extends TimerTask {
    final /* synthetic */ Timer zza;
    final /* synthetic */ zzfmb zzb;
    final /* synthetic */ zzcey zzc;

    public zzflz(zzfmb zzfmb, zzcey zzcey, Timer timer) {
        this.zzc = zzcey;
        this.zza = timer;
        this.zzb = zzfmb;
    }

    public final void run() {
        this.zzb.zzg();
        this.zzc.zza(true);
        this.zza.cancel();
    }
}
