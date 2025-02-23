package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzce extends zzcj {
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final zzcc zze;
    private final zzcb zzf;
    private final zzcl zzg;

    public /* synthetic */ zzce(String str, boolean z, boolean z2, zzcc zzcc, zzcb zzcb, zzcl zzcl, zzcg zzcg) {
        this(str, false, false, (zzcc) null, (zzcb) null, zzcl);
    }

    public final boolean equals(Object obj) {
        zzcc zzcc;
        zzcb zzcb;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzcj) {
            zzcj zzcj = (zzcj) obj;
            if (!this.zzb.equals(zzcj.zzd()) || this.zzc != zzcj.zze() || this.zzd != zzcj.zzf() || ((zzcc = this.zze) != null ? !zzcc.equals(zzcj.zza()) : zzcj.zza() != null) || ((zzcb = this.zzf) != null ? !zzcb.equals(zzcj.zzb()) : zzcj.zzb() != null) || !this.zzg.equals(zzcj.zzc())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = (this.zzb.hashCode() ^ 1000003) * 1000003;
        int i3 = 1231;
        if (this.zzc) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i4 = (hashCode ^ i) * 1000003;
        if (!this.zzd) {
            i3 = 1237;
        }
        int i5 = (i4 ^ i3) * 1000003;
        zzcc zzcc = this.zze;
        int i6 = 0;
        if (zzcc == null) {
            i2 = 0;
        } else {
            i2 = zzcc.hashCode();
        }
        int i7 = (i5 ^ i2) * 1000003;
        zzcb zzcb = this.zzf;
        if (zzcb != null) {
            i6 = zzcb.hashCode();
        }
        return ((i7 ^ i6) * 1000003) ^ this.zzg.hashCode();
    }

    public final String toString() {
        String str = this.zzb;
        boolean z = this.zzc;
        boolean z2 = this.zzd;
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        String valueOf3 = String.valueOf(this.zzg);
        return "FileComplianceOptions{fileOwner=" + str + ", hasDifferentDmaOwner=" + z + ", skipChecks=" + z2 + ", dataForwardingNotAllowedResolver=" + valueOf + ", multipleProductIdGroupsResolver=" + valueOf2 + ", filePurpose=" + valueOf3 + "}";
    }

    public final zzcc zza() {
        return this.zze;
    }

    public final zzcb zzb() {
        return this.zzf;
    }

    public final zzcl zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    private zzce(String str, boolean z, boolean z2, zzcc zzcc, zzcb zzcb, zzcl zzcl) {
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = null;
        this.zzf = null;
        this.zzg = zzcl;
    }
}
