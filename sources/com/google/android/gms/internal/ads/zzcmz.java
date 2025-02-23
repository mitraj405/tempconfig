package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcmz implements zzgbq {
    public final /* synthetic */ zzcni zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzcmz(zzcni zzcni, String str) {
        this.zza = zzcni;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (Throwable) obj);
    }
}
