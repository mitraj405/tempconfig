package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeis implements zzgbq {
    public final /* synthetic */ zzeiu zza;
    public final /* synthetic */ zzfel zzb;
    public final /* synthetic */ zzfex zzc;
    public final /* synthetic */ zzeet zzd;

    public /* synthetic */ zzeis(zzeiu zzeiu, zzfel zzfel, zzfex zzfex, zzeet zzeet) {
        this.zza = zzeiu;
        this.zzb = zzfel;
        this.zzc = zzfex;
        this.zzd = zzeet;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, (Throwable) obj);
    }
}
