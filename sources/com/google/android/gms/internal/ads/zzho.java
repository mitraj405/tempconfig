package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzho {
    public final String zza;
    public final zzaf zzb;
    public final zzaf zzc;
    public final int zzd;
    public final int zze;

    public zzho(String str, zzaf zzaf, zzaf zzaf2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        zzdi.zzd(z);
        zzdi.zzc(str);
        this.zza = str;
        this.zzb = zzaf;
        zzaf2.getClass();
        this.zzc = zzaf2;
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzho.class == obj.getClass()) {
            zzho zzho = (zzho) obj;
            if (this.zzd != zzho.zzd || this.zze != zzho.zze || !this.zza.equals(zzho.zza) || !this.zzb.equals(zzho.zzb) || !this.zzc.equals(zzho.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode() + ((((this.zzd + 527) * 31) + this.zze) * 31);
        int hashCode2 = this.zzb.hashCode() + (hashCode * 31);
        return this.zzc.hashCode() + (hashCode2 * 31);
    }
}
