package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfit {
    final /* synthetic */ zzfjd zza;
    private final Object zzb;
    private final List zzc;

    public /* synthetic */ zzfit(zzfjd zzfjd, Object obj, List list, zzfis zzfis) {
        this.zza = zzfjd;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfjc zza(Callable callable) {
        zzgci zzb2 = zzgcj.zzb(this.zzc);
        ListenableFuture zza2 = zzb2.zza(new zzfir(), zzbzo.zzf);
        ListenableFuture zza3 = zzb2.zza(callable, this.zza.zzb);
        return new zzfjc(this.zza, this.zzb, (String) null, zza2, this.zzc, zza3, (zzfjb) null);
    }
}
