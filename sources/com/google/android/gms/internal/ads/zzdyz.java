package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdyz implements zzgbq {
    public final /* synthetic */ zzdzc zza;
    public final /* synthetic */ zzdzb zzb;
    public final /* synthetic */ zzbvb zzc;
    public final /* synthetic */ zzgbq zzd;

    public /* synthetic */ zzdyz(zzdzc zzdzc, zzdzb zzdzb, zzbvb zzbvb, zzgbq zzgbq) {
        this.zza = zzdzc;
        this.zzb = zzdzb;
        this.zzc = zzbvb;
        this.zzd = zzgbq;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, (zzdyp) obj);
    }
}
