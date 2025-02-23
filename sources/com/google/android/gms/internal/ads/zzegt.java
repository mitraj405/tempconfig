package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzegt implements zzgbq {
    public final /* synthetic */ zzegw zza;
    public final /* synthetic */ zzfel zzb;
    public final /* synthetic */ zzfex zzc;
    public final /* synthetic */ zzdpp zzd;

    public /* synthetic */ zzegt(zzegw zzegw, zzfel zzfel, zzfex zzfex, zzdpp zzdpp) {
        this.zza = zzegw;
        this.zzb = zzfel;
        this.zzc = zzfex;
        this.zzd = zzdpp;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, obj);
    }
}
