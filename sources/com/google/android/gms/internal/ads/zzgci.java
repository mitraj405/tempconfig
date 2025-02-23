package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgci {
    private final boolean zza;
    private final zzfxr zzb;

    public /* synthetic */ zzgci(boolean z, zzfxr zzfxr, zzgch zzgch) {
        this.zza = z;
        this.zzb = zzfxr;
    }

    public final ListenableFuture zza(Callable callable, Executor executor) {
        return new zzgbw(this.zzb, this.zza, executor, callable);
    }
}
