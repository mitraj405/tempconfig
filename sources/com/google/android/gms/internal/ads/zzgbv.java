package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzgbv extends zzgcs {
    private final Executor zza;
    final /* synthetic */ zzgbw zzb;

    public zzgbv(zzgbw zzgbw, Executor executor) {
        this.zzb = zzgbw;
        executor.getClass();
        this.zza = executor;
    }

    public abstract void zzc(Object obj);

    public final void zzd(Throwable th) {
        this.zzb.zza = null;
        if (th instanceof ExecutionException) {
            this.zzb.zzd(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zzd(th);
        }
    }

    public final void zze(Object obj) {
        this.zzb.zza = null;
        zzc(obj);
    }

    public final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }

    public final boolean zzg() {
        return this.zzb.isDone();
    }
}
