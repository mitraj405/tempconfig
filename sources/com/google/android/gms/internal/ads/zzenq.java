package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzenq implements zzevo {
    private final Clock zza;
    private final zzffg zzb;

    public zzenq(Clock clock, zzffg zzffg) {
        this.zza = clock;
        this.zzb = zzffg;
    }

    public final int zza() {
        return 4;
    }

    public final ListenableFuture zzb() {
        return zzgcj.zzh(new zzenr(this.zzb, this.zza.currentTimeMillis()));
    }
}
