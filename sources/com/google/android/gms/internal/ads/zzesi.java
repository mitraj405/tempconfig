package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzesi implements zzevo {
    private final Context zza;
    private final zzgcu zzb;

    public zzesi(zzgcu zzgcu, Context context) {
        this.zzb = zzgcu;
        this.zza = context;
    }

    public final int zza() {
        return 57;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzesh(this));
    }

    public final /* synthetic */ zzesj zzc() throws Exception {
        zzu.zzp();
        return new zzesj(zzt.zzs(this.zza));
    }
}
