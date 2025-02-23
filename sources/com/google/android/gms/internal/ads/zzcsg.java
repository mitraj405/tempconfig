package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcsg implements zzgbq {
    public final /* synthetic */ zzcsj zza;
    public final /* synthetic */ zzgcf zzb;
    public final /* synthetic */ ListenableFuture zzc;

    public /* synthetic */ zzcsg(zzcsj zzcsj, zzgcf zzgcf, ListenableFuture listenableFuture) {
        this.zza = zzcsj;
        this.zzb = zzgcf;
        this.zzc = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zza(this.zzb, this.zzc, (zzcru) obj);
    }
}
