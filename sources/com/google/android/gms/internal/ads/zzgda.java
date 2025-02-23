package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgda {
    public static zzgcu zza(ExecutorService executorService) {
        zzgcu zzgcu;
        if (executorService instanceof zzgcu) {
            return (zzgcu) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzgcu = new zzgcz((ScheduledExecutorService) executorService);
        } else {
            zzgcu = new zzgcw(executorService);
        }
        return zzgcu;
    }

    public static Executor zzb() {
        return zzgbx.INSTANCE;
    }

    public static Executor zzc(Executor executor, zzgax zzgax) {
        executor.getClass();
        if (executor == zzgbx.INSTANCE) {
            return executor;
        }
        return new zzgcv(executor, zzgax);
    }
}
