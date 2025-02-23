package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfiv {
    public static final zzfjc zza(Callable callable, Object obj, zzfjd zzfjd) {
        return zzb(callable, zzfjd.zzb, obj, zzfjd);
    }

    public static final zzfjc zzb(Callable callable, zzgcu zzgcu, Object obj, zzfjd zzfjd) {
        return new zzfjc(zzfjd, obj, (String) null, zzfjd.zza, Collections.emptyList(), zzgcu.zzb(callable), (zzfjb) null);
    }

    public static final zzfjc zzc(ListenableFuture listenableFuture, Object obj, zzfjd zzfjd) {
        return new zzfjc(zzfjd, obj, (String) null, zzfjd.zza, Collections.emptyList(), listenableFuture, (zzfjb) null);
    }

    public static final zzfjc zzd(zzfip zzfip, zzgcu zzgcu, Object obj, zzfjd zzfjd) {
        return zzb(new zzfiu(zzfip), zzgcu, obj, zzfjd);
    }
}
