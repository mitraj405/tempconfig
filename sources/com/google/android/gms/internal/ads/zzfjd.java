package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfjd {
    /* access modifiers changed from: private */
    public static final ListenableFuture zza = zzgcj.zzh((Object) null);
    /* access modifiers changed from: private */
    public final zzgcu zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzfje zzd;

    public zzfjd(zzgcu zzgcu, ScheduledExecutorService scheduledExecutorService, zzfje zzfje) {
        this.zzb = zzgcu;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfje;
    }

    public final zzfit zza(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfit(this, obj, Arrays.asList(listenableFutureArr), (zzfis) null);
    }

    public final zzfjc zzb(Object obj, ListenableFuture listenableFuture) {
        return new zzfjc(this, obj, (String) null, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture, (zzfjb) null);
    }

    public abstract String zzf(Object obj);
}
