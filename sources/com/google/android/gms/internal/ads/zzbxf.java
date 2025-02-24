package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbxf implements zzgcf {
    final /* synthetic */ ListenableFuture zza;

    public zzbxf(zzbxg zzbxg, ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final void zza(Throwable th) {
        zzbxg.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzbxg.zzc.remove(this.zza);
    }
}
