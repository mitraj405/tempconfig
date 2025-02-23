package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbnw implements zzgbq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzbix zzb;

    public /* synthetic */ zzbnw(String str, zzbix zzbix) {
        this.zza = str;
        this.zzb = zzbix;
    }

    public final ListenableFuture zza(Object obj) {
        zzbnb zzbnb = (zzbnb) obj;
        zzbnb.zzq(this.zza, this.zzb);
        return zzgcj.zzh(zzbnb);
    }
}
