package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdze implements zzgbp {
    public final /* synthetic */ zzdzh zza;
    public final /* synthetic */ zzbug zzb;

    public /* synthetic */ zzdze(zzdzh zzdzh, zzbug zzbug) {
        this.zza = zzdzh;
        this.zzb = zzbug;
    }

    public final ListenableFuture zza() {
        return this.zza.zza(this.zzb);
    }
}
