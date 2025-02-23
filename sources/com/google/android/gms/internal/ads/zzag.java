package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzag {
    private final zzo zza;
    private final int zzb;
    private final int zzc;
    private float zzd = 1.0f;

    public zzag(zzo zzo, int i, int i2) {
        this.zza = zzo;
        this.zzb = i;
        this.zzc = i2;
    }

    public final zzag zza(float f) {
        this.zzd = f;
        return this;
    }

    public final zzai zzb() {
        return new zzai(this.zza, this.zzb, this.zzc, this.zzd, 0, (zzah) null);
    }
}
