package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzgce extends zzgcc implements ListenableFuture {
    public final void addListener(Runnable runnable, Executor executor) {
        zzc().addListener(runnable, executor);
    }

    public /* bridge */ /* synthetic */ Future zzb() {
        throw null;
    }

    public abstract ListenableFuture zzc();
}
