package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzebz {
    private final zzebv zza;
    private final zzgcu zzb;

    public zzebz(zzebv zzebv, zzgcu zzgcu) {
        this.zza = zzebv;
        this.zzb = zzgcu;
    }

    public final void zza(zzfio zzfio) {
        zzebv zzebv = this.zza;
        Objects.requireNonNull(zzebv);
        zzgcj.zzr(this.zzb.zzb(new zzebx(zzebv)), new zzeby(this, zzfio), this.zzb);
    }
}
