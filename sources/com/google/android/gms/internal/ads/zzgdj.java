package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgdj extends zzgbz implements RunnableFuture {
    private volatile zzgcs zza;

    public zzgdj(zzgbp zzgbp) {
        this.zza = new zzgdh(this, zzgbp);
    }

    public static zzgdj zze(Runnable runnable, Object obj) {
        return new zzgdj(Executors.callable(runnable, obj));
    }

    public final void run() {
        zzgcs zzgcs = this.zza;
        if (zzgcs != null) {
            zzgcs.run();
        }
        this.zza = null;
    }

    public final String zza() {
        zzgcs zzgcs = this.zza;
        if (zzgcs != null) {
            return lf.j("task=[", zzgcs.toString(), "]");
        }
        return super.zza();
    }

    public final void zzb() {
        zzgcs zzgcs;
        if (zzt() && (zzgcs = this.zza) != null) {
            zzgcs.zzh();
        }
        this.zza = null;
    }

    public zzgdj(Callable callable) {
        this.zza = new zzgdi(this, callable);
    }
}
