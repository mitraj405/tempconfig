package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeyh implements zzevo {
    final zzgcu zza;
    final List zzb;

    public zzeyh(zzbbf zzbbf, zzgcu zzgcu, List list) {
        this.zza = zzgcu;
        this.zzb = list;
    }

    public final int zza() {
        return 48;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeyg(this));
    }
}
