package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdzj implements zzgbp {
    public final /* synthetic */ zzdzn zza;
    public final /* synthetic */ zzbuc zzb;

    public /* synthetic */ zzdzj(zzdzn zzdzn, zzbuc zzbuc) {
        this.zza = zzdzn;
        this.zzb = zzbuc;
    }

    public final ListenableFuture zza() {
        return this.zza.zza(this.zzb);
    }
}
