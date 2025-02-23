package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzevl implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzevl(zzgcu zzgcu, Context context) {
        this.zza = zzgcu;
        this.zzb = context;
    }

    public final int zza() {
        return 37;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzevj(this));
    }

    public final /* synthetic */ zzevn zzc() throws Exception {
        zzbbn zzbbn = zzbbw.zzfx;
        Bundle zzb2 = zzad.zzb(this.zzb, (String) zzba.zzc().zza(zzbbn));
        if (zzb2.isEmpty()) {
            return null;
        }
        return new zzevk(zzb2);
    }
}
