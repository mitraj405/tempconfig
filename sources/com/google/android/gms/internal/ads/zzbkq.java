package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbkq implements zzgbq {
    final /* synthetic */ zzbki zza;

    public zzbkq(zzbku zzbku, zzbki zzbki) {
        this.zza = zzbki;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzbzt zzbzt = new zzbzt();
        ((zzbko) obj).zze(this.zza, new zzbkp(this, zzbzt));
        return zzbzt;
    }
}
