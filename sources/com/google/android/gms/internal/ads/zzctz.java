package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzctz implements zzdce, zzcye {
    private final Clock zza;
    private final zzcub zzb;
    private final zzffg zzc;
    private final String zzd;

    public zzctz(Clock clock, zzcub zzcub, zzffg zzffg, String str) {
        this.zza = clock;
        this.zzb = zzcub;
        this.zzc = zzffg;
        this.zzd = str;
    }

    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    public final void zzs() {
        zzffg zzffg = this.zzc;
        this.zzb.zzd(zzffg.zzf, this.zzd, this.zza.elapsedRealtime());
    }
}
