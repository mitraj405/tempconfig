package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdhr implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;
    private final zzhfu zzf;

    public zzdhr(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
        this.zze = zzhfu5;
        this.zzf = zzhfu6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcvy zza2 = ((zzcwi) this.zzb).zza();
        zzdck zza3 = ((zzdde) this.zzc).zza();
        zzdhg zza4 = ((zzdhi) this.zzd).zza();
        zzczj zza5 = ((zzcpj) this.zze).zzb();
        zzein zzein = (zzein) this.zzf.zzb();
        zzcqk zze2 = ((zzcgj) this.zza.zzb()).zze();
        zze2.zzi(zza2.zzj());
        zze2.zzf(zza3);
        zze2.zzd(zza4);
        zze2.zze(new zzekt((zzbcr) null));
        zze2.zzg(new zzcrm(zza5, (zzdbp) null));
        zze2.zzc(new zzcph((ViewGroup) null));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdl)).booleanValue()) {
            zze2.zzj(zzeiw.zzb(zzein));
        }
        zzcrx zzc2 = zze2.zzk().zzc();
        zzhfk.zzb(zzc2);
        return zzc2;
    }
}
