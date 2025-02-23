package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeid extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzdck zzc;
    private final zzein zzd;
    private final zzeey zze;

    public zzeid(zzcgj zzcgj, zzcvy zzcvy, zzdck zzdck, zzein zzein, zzeey zzeey) {
        this.zza = zzcgj;
        this.zzb = zzcvy;
        this.zzc = zzdck;
        this.zzd = zzein;
        this.zze = zzeey;
    }

    public final ListenableFuture zzc(zzffg zzffg, Bundle bundle, zzfel zzfel, zzfex zzfex) {
        zzcvy zzcvy = this.zzb;
        zzcvy.zzi(zzffg);
        zzcvy.zzf(bundle);
        zzcvy.zzg(new zzcvs(zzfex, zzfel, this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzcgj zzcgj = this.zza;
        zzcvy zzcvy2 = this.zzb;
        zzcox zzd2 = zzcgj.zzd();
        zzd2.zzd(zzcvy2.zzj());
        zzd2.zzc(this.zzc);
        zzctc zzb2 = zzd2.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
