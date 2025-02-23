package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcrm {
    private final zzczj zza;
    private final zzdbp zzb;

    public zzcrm(zzczj zzczj, zzdbp zzdbp) {
        this.zza = zzczj;
        this.zzb = zzdbp;
    }

    public final zzczj zza() {
        return this.zza;
    }

    public final zzdbp zzb() {
        return this.zzb;
    }

    public final zzdei zzc() {
        zzdbp zzdbp = this.zzb;
        if (zzdbp != null) {
            return new zzdei(zzdbp, zzbzo.zzf);
        }
        return new zzdei(new zzcrl(this), zzbzo.zzf);
    }
}
