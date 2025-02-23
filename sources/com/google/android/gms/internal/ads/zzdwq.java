package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdwq {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final zzdxx zzc;
    private final zzhew zzd;

    public zzdwq(zzgcu zzgcu, zzgcu zzgcu2, zzdxx zzdxx, zzhew zzhew) {
        this.zza = zzgcu;
        this.zzb = zzgcu2;
        this.zzc = zzdxx;
        this.zzd = zzhew;
    }

    public final /* synthetic */ zzdyq zza(zzbvb zzbvb) throws Exception {
        return (zzdyq) this.zzc.zza(zzbvb).get((long) ((Integer) zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
    }

    public final /* synthetic */ ListenableFuture zzb(zzbvb zzbvb, int i, zzdyp zzdyp) throws Exception {
        Bundle bundle;
        if (!(zzbvb == null || (bundle = zzbvb.zzm) == null)) {
            bundle.putBoolean("ls", true);
        }
        return zzgcj.zzn(((zzeay) this.zzd.zzb()).zzc(zzbvb, i), new zzdwm(zzbvb), this.zzb);
    }

    public final ListenableFuture zzc(zzbvb zzbvb) {
        ListenableFuture listenableFuture;
        String str = zzbvb.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgcj.zzg(new zzdyp(1));
        } else {
            listenableFuture = zzgcj.zzf(this.zza.zzb(new zzdwn(this, zzbvb)), ExecutionException.class, new zzdwo(), this.zzb);
        }
        return zzgcj.zzf(listenableFuture, zzdyp.class, new zzdwp(this, zzbvb, Binder.getCallingUid()), this.zzb);
    }
}
