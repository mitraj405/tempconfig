package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdwp implements zzgbq {
    public final /* synthetic */ zzdwq zza;
    public final /* synthetic */ zzbvb zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzdwp(zzdwq zzdwq, zzbvb zzbvb, int i) {
        this.zza = zzdwq;
        this.zzb = zzbvb;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (zzdyp) obj);
    }
}
