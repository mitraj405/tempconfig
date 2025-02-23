package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeij extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzdck zzc;
    private final zzein zzd;
    private final zzfey zze;
    private final zzeey zzf;

    public zzeij(zzcgj zzcgj, zzcvy zzcvy, zzdck zzdck, zzfey zzfey, zzein zzein, zzeey zzeey) {
        this.zza = zzcgj;
        this.zzb = zzcvy;
        this.zzc = zzdck;
        this.zze = zzfey;
        this.zzd = zzein;
        this.zzf = zzeey;
    }

    public final ListenableFuture zzc(zzffg zzffg, Bundle bundle, zzfel zzfel, zzfex zzfex) {
        zzfey zzfey;
        zzcvy zzcvy = this.zzb;
        zzcvy.zzi(zzffg);
        zzcvy.zzf(bundle);
        zzcvy.zzg(new zzcvs(zzfex, zzfel, this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdh)).booleanValue() && (zzfey = this.zze) != null) {
            this.zzb.zzh(zzfey);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcgj zzcgj = this.zza;
        zzcvy zzcvy2 = this.zzb;
        zzdot zzi = zzcgj.zzi();
        zzi.zzd(zzcvy2.zzj());
        zzi.zzc(this.zzc);
        zzctc zzb2 = zzi.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
