package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgbu extends zzgbv {
    final /* synthetic */ zzgbw zza;
    private final Callable zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgbu(zzgbw zzgbw, Callable callable, Executor executor) {
        super(zzgbw, executor);
        this.zza = zzgbw;
        this.zzc = callable;
    }

    public final Object zza() throws Exception {
        return this.zzc.call();
    }

    public final String zzb() {
        return this.zzc.toString();
    }

    public final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}
