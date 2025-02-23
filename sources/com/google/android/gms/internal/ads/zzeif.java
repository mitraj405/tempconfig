package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeif extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzekt zzc;
    private final zzdck zzd;
    private final zzdhg zze;
    private final zzczj zzf;
    private final ViewGroup zzg;
    private final zzdbp zzh;
    private final zzein zzi;
    private final zzeey zzj;

    public zzeif(zzcgj zzcgj, zzcvy zzcvy, zzekt zzekt, zzdck zzdck, zzdhg zzdhg, zzczj zzczj, ViewGroup viewGroup, zzdbp zzdbp, zzein zzein, zzeey zzeey) {
        this.zza = zzcgj;
        this.zzb = zzcvy;
        this.zzc = zzekt;
        this.zzd = zzdck;
        this.zze = zzdhg;
        this.zzf = zzczj;
        this.zzg = viewGroup;
        this.zzh = zzdbp;
        this.zzi = zzein;
        this.zzj = zzeey;
    }

    public final ListenableFuture zzc(zzffg zzffg, Bundle bundle, zzfel zzfel, zzfex zzfex) {
        zzcvy zzcvy = this.zzb;
        zzcvy.zzi(zzffg);
        zzcvy.zzf(bundle);
        zzcvy.zzg(new zzcvs(zzfex, zzfel, this.zzi));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzcgj zzcgj = this.zza;
        zzcvy zzcvy2 = this.zzb;
        zzcqk zze2 = zzcgj.zze();
        zze2.zzi(zzcvy2.zzj());
        zze2.zzf(this.zzd);
        zze2.zze(this.zzc);
        zze2.zzd(this.zze);
        zze2.zzg(new zzcrm(this.zzf, this.zzh));
        zze2.zzc(new zzcph(this.zzg));
        zzctc zzd2 = zze2.zzk().zzd();
        return zzd2.zzi(zzd2.zzj());
    }
}
