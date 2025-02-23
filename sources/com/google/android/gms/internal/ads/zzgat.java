package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgat extends zzgav {
    public zzgat(ListenableFuture listenableFuture, Class cls, zzgbq zzgbq) {
        super(listenableFuture, cls, zzgbq);
    }

    public final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        zzgbq zzgbq = (zzgbq) obj;
        ListenableFuture zza = zzgbq.zza(th);
        zzfuu.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbq);
        return zza;
    }

    public final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
