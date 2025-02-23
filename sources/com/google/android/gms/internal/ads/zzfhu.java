package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfhu implements zzgbq {
    public final /* synthetic */ zzfhw zza;
    public final /* synthetic */ zzfho zzb;
    public final /* synthetic */ zzfgu zzc;
    public final /* synthetic */ zzfhp zzd;

    public /* synthetic */ zzfhu(zzfhw zzfhw, zzfho zzfho, zzfgu zzfgu, zzfhp zzfhp) {
        this.zza = zzfhw;
        this.zzb = zzfho;
        this.zzc = zzfgu;
        this.zzd = zzfhp;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, (zzfhd) obj);
    }
}
