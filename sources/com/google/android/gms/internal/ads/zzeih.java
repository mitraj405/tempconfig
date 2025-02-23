package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeih extends zzeic {
    private final zzcgj zza;
    private final zzcvy zzb;
    private final zzekt zzc;
    private final zzdck zzd;
    private final zzein zze;
    private final zzeey zzf;

    public zzeih(zzcgj zzcgj, zzcvy zzcvy, zzekt zzekt, zzdck zzdck, zzein zzein, zzeey zzeey) {
        this.zza = zzcgj;
        this.zzb = zzcvy;
        this.zzc = zzekt;
        this.zzd = zzdck;
        this.zze = zzein;
        this.zzf = zzeey;
    }

    public final ListenableFuture zzc(zzffg zzffg, Bundle bundle, zzfel zzfel, zzfex zzfex) {
        zzcvy zzcvy = this.zzb;
        zzcvy.zzi(zzffg);
        zzcvy.zzf(bundle);
        zzcvy.zzg(new zzcvs(zzfex, zzfel, this.zze));
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdi)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcgj zzcgj = this.zza;
        zzcvy zzcvy2 = this.zzb;
        zzdgo zzg = zzcgj.zzg();
        zzg.zze(zzcvy2.zzj());
        zzg.zzd(this.zzd);
        zzg.zzc(this.zzc);
        zzctc zza2 = zzg.zzf().zza();
        return zza2.zzi(zza2.zzj());
    }
}
