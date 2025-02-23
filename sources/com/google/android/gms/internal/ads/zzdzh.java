package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdzh {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzeac zzc;
    private final zzhew zzd;

    public zzdzh(zzgcu zzgcu, zzgcu zzgcu2, zzeac zzeac, zzhew zzhew) {
        this.zza = zzgcu;
        this.zzb = zzgcu2;
        this.zzc = zzeac;
        this.zzd = zzhew;
    }

    public final /* synthetic */ ListenableFuture zza(zzbug zzbug) throws Exception {
        return this.zzc.zza(zzbug, ((Long) zzba.zzc().zza(zzbbw.zzkH)).longValue());
    }

    public final /* synthetic */ ListenableFuture zzb(zzbug zzbug, int i, zzdyp zzdyp) throws Exception {
        return ((zzebi) this.zzd.zzb()).zzb(zzbug, i);
    }

    public final ListenableFuture zzc(zzbug zzbug) {
        ListenableFuture listenableFuture;
        String str = zzbug.zzf;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgcj.zzg(new zzdyp(1, "Ads service proxy force local"));
        } else {
            listenableFuture = zzgcj.zzf(zzgcj.zzk(new zzdze(this, zzbug), this.zza), ExecutionException.class, new zzdzf(), this.zzb);
        }
        return zzgcj.zzf(listenableFuture, zzdyp.class, new zzdzg(this, zzbug, Binder.getCallingUid()), this.zzb);
    }
}
