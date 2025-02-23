package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdxk {
    private final ScheduledExecutorService zza;
    private final zzgcu zzb;
    private final zzgcu zzc;
    private final zzdyc zzd;
    private final zzhew zze;

    public zzdxk(ScheduledExecutorService scheduledExecutorService, zzgcu zzgcu, zzgcu zzgcu2, zzdyc zzdyc, zzhew zzhew) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgcu;
        this.zzc = zzgcu2;
        this.zzd = zzdyc;
        this.zze = zzhew;
    }

    public final /* synthetic */ zzdyq zza(zzbvb zzbvb) throws Exception {
        return (zzdyq) this.zzd.zza(zzbvb).get((long) ((Integer) zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
    }

    public final /* synthetic */ ListenableFuture zzb(zzbvb zzbvb, int i, Throwable th) throws Exception {
        Bundle bundle;
        if (!(zzbvb == null || (bundle = zzbvb.zzm) == null)) {
            bundle.putBoolean("ls", true);
        }
        return zzgcj.zzn(((zzeay) this.zze.zzb()).zzd(zzbvb, i), new zzdxh(zzbvb), this.zzb);
    }

    public final ListenableFuture zzc(zzbvb zzbvb) {
        ListenableFuture listenableFuture;
        String str = zzbvb.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgcj.zzg(new zzdyp(1));
        } else {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzgK)).booleanValue()) {
                listenableFuture = this.zzc.zzb(new zzdxi(this, zzbvb));
            } else {
                listenableFuture = this.zzd.zza(zzbvb);
            }
        }
        int callingUid = Binder.getCallingUid();
        zzgca zzu = zzgca.zzu(listenableFuture);
        zzbbn zzbbn = zzbbw.zzeU;
        return zzgcj.zzf((zzgca) zzgcj.zzo(zzu, (long) ((Integer) zzba.zzc().zza(zzbbn)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzdxj(this, zzbvb, callingUid), this.zzb);
    }
}
