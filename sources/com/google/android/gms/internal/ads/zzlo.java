package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzlo {
    public final long zza;
    public final zzcc zzb;
    public final int zzc;
    public final zzui zzd;
    public final long zze;
    public final zzcc zzf;
    public final int zzg;
    public final zzui zzh;
    public final long zzi;
    public final long zzj;

    public zzlo(long j, zzcc zzcc, int i, zzui zzui, long j2, zzcc zzcc2, int i2, zzui zzui2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzcc;
        this.zzc = i;
        this.zzd = zzui;
        this.zze = j2;
        this.zzf = zzcc2;
        this.zzg = i2;
        this.zzh = zzui2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlo.class == obj.getClass()) {
            zzlo zzlo = (zzlo) obj;
            if (this.zza == zzlo.zza && this.zzc == zzlo.zzc && this.zze == zzlo.zze && this.zzg == zzlo.zzg && this.zzi == zzlo.zzi && this.zzj == zzlo.zzj && zzfur.zza(this.zzb, zzlo.zzb) && zzfur.zza(this.zzd, zzlo.zzd) && zzfur.zza(this.zzf, zzlo.zzf) && zzfur.zza(this.zzh, zzlo.zzh)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
