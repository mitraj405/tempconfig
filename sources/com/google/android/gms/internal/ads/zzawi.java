package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawi implements Callable {
    private final zzavp zza;
    private final zzaro zzb;

    public zzawi(zzavp zzavp, zzaro zzaro) {
        this.zza = zzavp;
        this.zzb = zzaro;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzasj zzc = this.zza.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                this.zzb.zzaY(zzc.zzaV(), zzgxi.zza());
            }
            return null;
        } catch (zzgyn | NullPointerException unused) {
            return null;
        }
    }
}
