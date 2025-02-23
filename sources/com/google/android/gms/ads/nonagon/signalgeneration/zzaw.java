package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzdxk;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaw implements zzgbq {
    private final Executor zza;
    private final zzdxk zzb;

    public zzaw(Executor executor, zzdxk zzdxk) {
        this.zza = executor;
        this.zzb = zzdxk;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzbvb zzbvb = (zzbvb) obj;
        return zzgcj.zzn(this.zzb.zzc(zzbvb), new zzav(zzbvb), this.zza);
    }
}
