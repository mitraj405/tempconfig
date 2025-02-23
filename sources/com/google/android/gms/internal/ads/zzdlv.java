package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdlv implements zzgbq {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdlv(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        zzcej zzcej = (zzcej) obj;
        if (zzcej != null && zzcej.zzq() != null) {
            return this.zza;
        }
        throw new zzeir(1, "Retrieve video view in html5 ad response failed.");
    }
}
