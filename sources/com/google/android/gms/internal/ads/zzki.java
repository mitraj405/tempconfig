package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzki {
    public final zzui zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    public zzki(zzui zzui, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        boolean z6 = true;
        if (!z4 || z2) {
            z5 = true;
        } else {
            z5 = false;
        }
        zzdi.zzd(z5);
        if (z3 && !z2) {
            z6 = false;
        }
        zzdi.zzd(z6);
        this.zza = zzui;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = false;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzki.class == obj.getClass()) {
            zzki zzki = (zzki) obj;
            if (this.zzb == zzki.zzb && this.zzc == zzki.zzc && this.zzd == zzki.zzd && this.zze == zzki.zze && this.zzg == zzki.zzg && this.zzh == zzki.zzh && this.zzi == zzki.zzi && zzet.zzG(this.zza, zzki.zza)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zze;
        long j2 = this.zzd;
        return ((((((((((((((this.zza.hashCode() + 527) * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) j2)) * 31) + ((int) j)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzki zza(long j) {
        if (j == this.zzc) {
            return this;
        }
        return new zzki(this.zza, this.zzb, j, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzki zzb(long j) {
        if (j == this.zzb) {
            return this;
        }
        return new zzki(this.zza, j, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
