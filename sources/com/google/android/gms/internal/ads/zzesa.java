package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzesa implements zzevo {
    private final zzgcu zza;

    public zzesa(Context context, zzgcu zzgcu) {
        this.zza = zzgcu;
    }

    public final int zza() {
        return 19;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzerz(this));
    }
}
