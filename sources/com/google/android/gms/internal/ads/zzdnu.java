package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdnu implements zzgcf {
    final /* synthetic */ zzfel zza;
    final /* synthetic */ zzfeo zzb;
    final /* synthetic */ zzcni zzc;
    final /* synthetic */ zzdoa zzd;

    public zzdnu(zzdoa zzdoa, zzfel zzfel, zzfeo zzfeo, zzcni zzcni) {
        this.zza = zzfel;
        this.zzb = zzfeo;
        this.zzc = zzcni;
        this.zzd = zzdoa;
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcej zzcej = (zzcej) obj;
        zzcej.zzW(this.zza, this.zzb);
        zzcgb zzN = zzcej.zzN();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjk)).booleanValue() && zzN != null) {
            zzcni zzcni = this.zzc;
            zzdoa zzdoa = this.zzd;
            zzN.zzI(zzcni, zzdoa.zzi, zzdoa.zzj);
            zzcni zzcni2 = this.zzc;
            zzdoa zzdoa2 = this.zzd;
            zzN.zzK(zzcni2, zzdoa2.zzi, zzdoa2.zzd);
        }
    }

    public final void zza(Throwable th) {
    }
}
