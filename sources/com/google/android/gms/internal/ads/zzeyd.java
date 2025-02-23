package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeyd implements zzevo {
    public zzeyd(zzbys zzbys, zzgcu zzgcu, String str) {
    }

    public final int zza() {
        return 47;
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzh = zzgcj.zzh((Object) null);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfi)).booleanValue()) {
            zzh = zzgcj.zzh((Object) null);
        }
        ListenableFuture zzh2 = zzgcj.zzh((Object) null);
        return zzgcj.zzc(zzh, zzh2).zza(new zzeyc(zzh, zzh2), zzbzo.zza);
    }
}
