package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdzn {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzeaf zzc;

    public zzdzn(zzgcu zzgcu, zzgcu zzgcu2, zzeaf zzeaf) {
        this.zza = zzgcu;
        this.zzb = zzgcu2;
        this.zzc = zzeaf;
    }

    public final /* synthetic */ ListenableFuture zza(zzbuc zzbuc) throws Exception {
        return this.zzc.zza(zzbuc, ((Long) zzba.zzc().zza(zzbbw.zzkG)).longValue());
    }

    public final ListenableFuture zzb(zzbuc zzbuc) {
        ListenableFuture listenableFuture;
        String str = zzbuc.zzb;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgcj.zzg(new zzdyp(1, "Ads signal service force local"));
        } else {
            listenableFuture = zzgcj.zzf(zzgcj.zzk(new zzdzj(this, zzbuc), this.zza), ExecutionException.class, new zzdzk(), this.zzb);
        }
        return zzgcj.zzn(zzgcj.zzf(zzgca.zzu(listenableFuture), zzdyp.class, new zzdzl(), this.zzb), new zzdzm(), this.zzb);
    }
}
