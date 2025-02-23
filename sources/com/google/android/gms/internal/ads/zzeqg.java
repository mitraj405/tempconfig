package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeqg implements zzevo {
    private final AtomicReference zza = new AtomicReference();
    private final Clock zzb;
    private final zzevo zzc;
    private final long zzd;

    public zzeqg(zzevo zzevo, long j, Clock clock) {
        this.zzb = clock;
        this.zzc = zzevo;
        this.zzd = j;
    }

    public final int zza() {
        return this.zzc.zza();
    }

    public final ListenableFuture zzb() {
        zzeqf zzeqf = (zzeqf) this.zza.get();
        if (zzeqf == null || zzeqf.zza()) {
            zzevo zzevo = this.zzc;
            zzeqf zzeqf2 = new zzeqf(zzevo.zzb(), this.zzd, this.zzb);
            this.zza.set(zzeqf2);
            zzeqf = zzeqf2;
        }
        return zzeqf.zza;
    }
}
