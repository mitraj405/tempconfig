package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaho implements zzahr {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzaho(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzet.zzr(jArr2[jArr2.length - 1]) : j;
    }

    public static zzaho zzb(long j, zzagi zzagi, long j2) {
        int length = zzagi.zzd.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzagi.zzb + zzagi.zzd[i3]);
            j3 += (long) (zzagi.zzc + zzagi.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzaho(jArr, jArr2, j2);
    }

    private static Pair zzf(long j, long[] jArr, long[] jArr2) {
        double d;
        int zzc2 = zzet.zzc(jArr, j, true, true);
        long j2 = jArr[zzc2];
        long j3 = jArr2[zzc2];
        int i = zzc2 + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        long j5 = jArr2[i];
        if (j4 == j2) {
            d = 0.0d;
        } else {
            d = (((double) j) - ((double) j2)) / ((double) (j4 - j2));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) (d * ((double) (j5 - j3)))) + j3));
    }

    public final long zza() {
        return this.zzc;
    }

    public final int zzc() {
        return -2147483647;
    }

    public final long zzd() {
        return -1;
    }

    public final long zze(long j) {
        return zzet.zzr(((Long) zzf(j, this.zza, this.zzb).second).longValue());
    }

    public final zzadg zzg(long j) {
        Pair zzf = zzf(zzet.zzu(Math.max(0, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzadj zzadj = new zzadj(zzet.zzr(((Long) zzf.first).longValue()), ((Long) zzf.second).longValue());
        return new zzadg(zzadj, zzadj);
    }

    public final boolean zzh() {
        return true;
    }
}
