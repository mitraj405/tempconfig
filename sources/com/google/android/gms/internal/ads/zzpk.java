package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzpk extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzaf zzc;

    public zzpk(int i, zzaf zzaf, boolean z) {
        super(lf.h("AudioTrack write failed: ", i));
        this.zzb = z;
        this.zza = i;
        this.zzc = zzaf;
    }
}
