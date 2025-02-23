package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgdd implements Runnable {
    zzgdg zza;

    public zzgdd(zzgdg zzgdg) {
        this.zza = zzgdg;
    }

    public final void run() {
        ListenableFuture zze;
        String str;
        zzgdg zzgdg = this.zza;
        if (zzgdg != null && (zze = zzgdg.zza) != null) {
            this.zza = null;
            if (zze.isDone()) {
                zzgdg.zzs(zze);
                return;
            }
            try {
                ScheduledFuture zzv = zzgdg.zzb;
                zzgdg.zzb = null;
                str = "Timed out";
                if (zzv != null) {
                    long abs = Math.abs(zzv.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                zzgdg.zzd(new zzgdf(str + ": " + zze.toString(), (zzgde) null));
                zze.cancel(true);
            } catch (Throwable th) {
                zze.cancel(true);
                throw th;
            }
        }
    }
}
