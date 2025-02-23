package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdlt implements zzgbq {
    public final /* synthetic */ zzdme zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdlt(zzdme zzdme, String str) {
        this.zza = zzdme;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, obj);
    }
}
