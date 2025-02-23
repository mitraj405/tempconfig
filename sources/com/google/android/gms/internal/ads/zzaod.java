package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaod implements zzadi {
    private final zzaoa zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaod(zzaoa zzaoa, int i, long j, long j2) {
        this.zza = zzaoa;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzaoa.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzet.zzt(j * ((long) this.zzb), 1000000, (long) this.zza.zzc, RoundingMode.FLOOR);
    }

    public final long zza() {
        return this.zze;
    }

    public final zzadg zzg(long j) {
        long max = Math.max(0, Math.min((((long) this.zza.zzc) * j) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long zzb2 = zzb(max);
        zzadj zzadj = new zzadj(zzb2, this.zzc + (((long) this.zza.zzd) * max));
        if (zzb2 >= j || max == this.zzd - 1) {
            return new zzadg(zzadj, zzadj);
        }
        long j2 = max + 1;
        return new zzadg(zzadj, new zzadj(zzb(j2), (j2 * ((long) this.zza.zzd)) + this.zzc));
    }

    public final boolean zzh() {
        return true;
    }
}
