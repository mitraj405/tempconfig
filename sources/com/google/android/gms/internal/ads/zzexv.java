package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzexv implements zzevo {
    final zzgcu zza;

    public zzexv(zzbak zzbak, zzgcu zzgcu, Context context) {
        this.zza = zzgcu;
    }

    public final int zza() {
        return 45;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzexu(this));
    }
}
