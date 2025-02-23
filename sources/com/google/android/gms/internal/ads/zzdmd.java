package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdmd implements zzgbq {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdmd(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        if (obj != null) {
            return this.zza;
        }
        return zzgcj.zzg(new zzeir(1, "Retrieve required value in native ad response failed."));
    }
}
