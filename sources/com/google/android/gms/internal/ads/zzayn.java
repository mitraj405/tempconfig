package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzayn implements Runnable {
    final /* synthetic */ zzayo zza;

    public zzayn(zzayo zzayo) {
        this.zza = zzayo;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            zzayo zzayo = this.zza;
            if (!zzayo.zzd || !zzayo.zze) {
                zzm.zze("App is still foreground");
            } else {
                zzayo.zzd = false;
                zzm.zze("App went background");
                for (zzayp zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e) {
                        zzm.zzh("", e);
                    }
                }
            }
        }
    }
}
