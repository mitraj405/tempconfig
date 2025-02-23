package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzadh implements zzadi {
    private final long zza;
    private final zzadg zzb;

    public zzadh(long j, long j2) {
        zzadj zzadj;
        this.zza = j;
        if (j2 == 0) {
            zzadj = zzadj.zza;
        } else {
            zzadj = new zzadj(0, j2);
        }
        this.zzb = new zzadg(zzadj, zzadj);
    }

    public final long zza() {
        return this.zza;
    }

    public final zzadg zzg(long j) {
        return this.zzb;
    }

    public final boolean zzh() {
        return false;
    }
}
