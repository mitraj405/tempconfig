package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzxp {
    public final int zza;
    public final zzcd zzb;
    public final int zzc;
    public final zzaf zzd;

    public zzxp(int i, zzcd zzcd, int i2) {
        this.zza = i;
        this.zzb = zzcd;
        this.zzc = i2;
        this.zzd = zzcd.zzb(i2);
    }

    public abstract int zzb();

    public abstract boolean zzc(zzxp zzxp);
}
