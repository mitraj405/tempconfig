package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcrj implements zzcye, zzaxw {
    private final zzfel zza;
    private final zzcxi zzb;
    private final zzcyn zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcrj(zzfel zzfel, zzcxi zzcxi, zzcyn zzcyn) {
        this.zza = zzfel;
        this.zzb = zzcxi;
        this.zzc = zzcyn;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    public final void zzdp(zzaxv zzaxv) {
        if (this.zza.zze == 1 && zzaxv.zzj) {
            zza();
        }
        if (zzaxv.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    public final synchronized void zzs() {
        if (this.zza.zze != 1) {
            zza();
        }
    }
}
