package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzahs implements zzahr {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzahs(long[] jArr, long[] jArr2, long j, long j2, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
    }

    public static zzahs zzb(long j, long j2, zzadc zzadc, zzek zzek) {
        int i;
        int i2;
        long j3 = j;
        zzadc zzadc2 = zzadc;
        zzek zzek2 = zzek;
        zzek2.zzL(10);
        int zzg = zzek.zzg();
        if (zzg <= 0) {
            return null;
        }
        int i3 = zzadc2.zzd;
        if (i3 >= 32000) {
            i = 1152;
        } else {
            i = 576;
        }
        long zzt = zzet.zzt((long) zzg, ((long) i) * 1000000, (long) i3, RoundingMode.FLOOR);
        int zzq = zzek.zzq();
        int zzq2 = zzek.zzq();
        int zzq3 = zzek.zzq();
        zzek2.zzL(2);
        long j4 = j2 + ((long) zzadc2.zzc);
        long[] jArr = new long[zzq];
        long[] jArr2 = new long[zzq];
        int i4 = 0;
        long j5 = j2;
        while (i4 < zzq) {
            long j6 = zzt;
            jArr[i4] = (((long) i4) * zzt) / ((long) zzq);
            jArr2[i4] = Math.max(j5, j4);
            if (zzq3 == 1) {
                i2 = zzek.zzm();
            } else if (zzq3 == 2) {
                i2 = zzek.zzq();
            } else if (zzq3 == 3) {
                i2 = zzek.zzo();
            } else if (zzq3 != 4) {
                return null;
            } else {
                i2 = zzek.zzp();
            }
            j5 += ((long) i2) * ((long) zzq2);
            i4++;
            zzadc zzadc3 = zzadc;
            zzek zzek3 = zzek;
            zzt = j6;
        }
        long j7 = zzt;
        if (!(j3 == -1 || j3 == j5)) {
            zzea.zzf("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new zzahs(jArr, jArr2, j7, j5, zzadc.zzf);
    }

    public final long zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zze;
    }

    public final long zzd() {
        return this.zzd;
    }

    public final long zze(long j) {
        return this.zza[zzet.zzc(this.zzb, j, true, true)];
    }

    public final zzadg zzg(long j) {
        long[] jArr = this.zza;
        int zzc2 = zzet.zzc(jArr, j, true, true);
        zzadj zzadj = new zzadj(jArr[zzc2], this.zzb[zzc2]);
        if (zzadj.zzb < j) {
            long[] jArr2 = this.zza;
            if (zzc2 != jArr2.length - 1) {
                int i = zzc2 + 1;
                return new zzadg(zzadj, new zzadj(jArr2[i], this.zzb[i]));
            }
        }
        return new zzadg(zzadj, zzadj);
    }

    public final boolean zzh() {
        return true;
    }
}
