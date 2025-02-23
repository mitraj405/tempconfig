package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgcv implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzgax zzb;

    public zzgcv(Executor executor, zzgax zzgax) {
        this.zza = executor;
        this.zzb = zzgax;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }
}
