package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdom implements zzbjo {
    private final zzcxx zza;
    private final zzbvz zzb;
    private final String zzc;
    private final String zzd;

    public zzdom(zzcxx zzcxx, zzfel zzfel) {
        this.zza = zzcxx;
        this.zzb = zzfel.zzl;
        this.zzc = zzfel.zzj;
        this.zzd = zzfel.zzk;
    }

    public final void zza(zzbvz zzbvz) {
        int i;
        String str;
        zzbvz zzbvz2 = this.zzb;
        if (zzbvz2 != null) {
            zzbvz = zzbvz2;
        }
        if (zzbvz != null) {
            str = zzbvz.zza;
            i = zzbvz.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbvk(str, i), this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zza.zze();
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
