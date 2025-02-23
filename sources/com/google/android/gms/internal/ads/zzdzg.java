package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdzg implements zzgbq {
    public final /* synthetic */ zzdzh zza;
    public final /* synthetic */ zzbug zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzdzg(zzdzh zzdzh, zzbug zzbug, int i) {
        this.zza = zzdzh;
        this.zzb = zzbug;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (zzdyp) obj);
    }
}
