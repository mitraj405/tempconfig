package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeia extends zzeic {
    private final zzcgj zza;
    private final zzdhg zzb;
    private final zzcvy zzc;
    private final zzdck zzd;
    private final zzein zze;
    private final zzeey zzf;

    public zzeia(zzcgj zzcgj, zzdhg zzdhg, zzcvy zzcvy, zzdck zzdck, zzein zzein, zzeey zzeey) {
        this.zza = zzcgj;
        this.zzb = zzdhg;
        this.zzc = zzcvy;
        this.zzd = zzdck;
        this.zze = zzein;
        this.zzf = zzeey;
    }

    public final ListenableFuture zzc(zzffg zzffg, Bundle bundle, zzfel zzfel, zzfex zzfex) {
        zzcvy zzcvy = this.zzc;
        zzcvy.zzi(zzffg);
        zzcvy.zzf(bundle);
        zzcvy.zzg(new zzcvs(zzfex, zzfel, this.zze));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdi)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzcgj zzcgj = this.zza;
        zzcvy zzcvy2 = this.zzc;
        zzdhk zzh = zzcgj.zzh();
        zzh.zzf(zzcvy2.zzj());
        zzh.zze(this.zzd);
        zzh.zzd(this.zzb);
        zzh.zzc(new zzcph((ViewGroup) null));
        zzctc zza2 = zzh.zzg().zza();
        return zza2.zzi(zza2.zzj());
    }
}
