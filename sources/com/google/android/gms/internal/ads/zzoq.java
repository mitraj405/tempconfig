package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzoq {
    public static final zzoq zza = new zzoo().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public /* synthetic */ zzoq(zzoo zzoo, zzop zzop) {
        this.zzb = zzoo.zza;
        this.zzc = zzoo.zzb;
        this.zzd = zzoo.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzoq.class == obj.getClass()) {
            zzoq zzoq = (zzoq) obj;
            if (this.zzb == zzoq.zzb && this.zzc == zzoq.zzc && this.zzd == zzoq.zzd) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return (z2 ? 1 : 0) + z2 + ((z ? 1 : 0) << true) + (this.zzd ? 1 : 0);
    }
}
