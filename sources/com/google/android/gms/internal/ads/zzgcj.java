package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgcj extends zzgcl {
    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzgci zza(java.lang.Iterable r3) {
        /*
            com.google.android.gms.internal.ads.zzgci r0 = new com.google.android.gms.internal.ads.zzgci
            com.google.android.gms.internal.ads.zzfxr r3 = com.google.android.gms.internal.ads.zzfxr.zzk(r3)
            r1 = 0
            r2 = 0
            r0.<init>(r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcj.zza(java.lang.Iterable):com.google.android.gms.internal.ads.zzgci");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Object, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzgci zzb(java.lang.Iterable r3) {
        /*
            com.google.android.gms.internal.ads.zzgci r0 = new com.google.android.gms.internal.ads.zzgci
            int r1 = com.google.android.gms.internal.ads.zzfxr.zzd
            r3.getClass()
            com.google.android.gms.internal.ads.zzfxr r3 = com.google.android.gms.internal.ads.zzfxr.zzk(r3)
            r1 = 0
            r2 = 1
            r0.<init>(r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcj.zzb(java.lang.Iterable):com.google.android.gms.internal.ads.zzgci");
    }

    @SafeVarargs
    public static zzgci zzc(ListenableFuture... listenableFutureArr) {
        return new zzgci(true, zzfxr.zzl(listenableFutureArr), (zzgch) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.util.concurrent.ListenableFuture zzd(java.lang.Iterable r2) {
        /*
            com.google.android.gms.internal.ads.zzgbr r0 = new com.google.android.gms.internal.ads.zzgbr
            com.google.android.gms.internal.ads.zzfxr r2 = com.google.android.gms.internal.ads.zzfxr.zzk(r2)
            r1 = 1
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcj.zzd(java.lang.Iterable):com.google.common.util.concurrent.ListenableFuture");
    }

    public static ListenableFuture zze(ListenableFuture listenableFuture, Class cls, zzful zzful, Executor executor) {
        zzgau zzgau = new zzgau(listenableFuture, cls, zzful);
        listenableFuture.addListener(zzgau, zzgda.zzc(executor, zzgau));
        return zzgau;
    }

    public static ListenableFuture zzf(ListenableFuture listenableFuture, Class cls, zzgbq zzgbq, Executor executor) {
        zzgat zzgat = new zzgat(listenableFuture, cls, zzgbq);
        listenableFuture.addListener(zzgat, zzgda.zzc(executor, zzgat));
        return zzgat;
    }

    public static ListenableFuture zzg(Throwable th) {
        th.getClass();
        return new zzgcm(th);
    }

    public static ListenableFuture zzh(Object obj) {
        if (obj == null) {
            return zzgcn.zza;
        }
        return new zzgcn(obj);
    }

    public static ListenableFuture zzi() {
        return zzgcn.zza;
    }

    public static ListenableFuture zzj(Callable callable, Executor executor) {
        zzgdj zzgdj = new zzgdj(callable);
        executor.execute(zzgdj);
        return zzgdj;
    }

    public static ListenableFuture zzk(zzgbp zzgbp, Executor executor) {
        zzgdj zzgdj = new zzgdj(zzgbp);
        executor.execute(zzgdj);
        return zzgdj;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzgbr(zzfxr.zzl(listenableFutureArr), false);
    }

    public static ListenableFuture zzm(ListenableFuture listenableFuture, zzful zzful, Executor executor) {
        zzgbe zzgbe = new zzgbe(listenableFuture, zzful);
        listenableFuture.addListener(zzgbe, zzgda.zzc(executor, zzgbe));
        return zzgbe;
    }

    public static ListenableFuture zzn(ListenableFuture listenableFuture, zzgbq zzgbq, Executor executor) {
        int i = zzgbf.zzc;
        executor.getClass();
        zzgbd zzgbd = new zzgbd(listenableFuture, zzgbq);
        listenableFuture.addListener(zzgbd, zzgda.zzc(executor, zzgbd));
        return zzgbd;
    }

    public static ListenableFuture zzo(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        return zzgdg.zzf(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static Object zzp(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgdl.zza(future);
        }
        throw new IllegalStateException(zzfvj.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzq(Future future) {
        try {
            return zzgdl.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzgby((Error) cause);
            }
            throw new zzgdk(cause);
        }
    }

    public static void zzr(ListenableFuture listenableFuture, zzgcf zzgcf, Executor executor) {
        zzgcf.getClass();
        listenableFuture.addListener(new zzgcg(listenableFuture, zzgcf), executor);
    }
}
