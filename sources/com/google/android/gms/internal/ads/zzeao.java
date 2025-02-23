package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeao implements Callable {
    public final /* synthetic */ zzeay zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzbvb zzd;
    public final /* synthetic */ zzfju zze;

    public /* synthetic */ zzeao(zzeay zzeay, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbvb zzbvb, zzfju zzfju) {
        this.zza = zzeay;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzbvb;
        this.zze = zzfju;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
