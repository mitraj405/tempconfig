package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdlx implements zzgbq {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdlx(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        if (((zzcej) obj) != null) {
            return this.zza;
        }
        throw new zzeir(1, "Retrieve Web View from image ad response failed.");
    }
}
