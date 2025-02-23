package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzahu implements zzahr {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;
    private final long[] zzg;

    private zzahu(long j, int i, long j2, int i2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = i2;
        this.zze = j3;
        this.zzg = jArr;
        this.zzf = j3 != -1 ? j + j3 : -1;
    }

    public static zzahu zzb(zzaht zzaht, long j) {
        long[] jArr;
        long zza2 = zzaht.zza();
        if (zza2 == -9223372036854775807L) {
            return null;
        }
        long j2 = zzaht.zzc;
        if (j2 == -1 || (jArr = zzaht.zzf) == null) {
            zzadc zzadc = zzaht.zza;
            return new zzahu(j, zzadc.zzc, zza2, zzadc.zzf, -1, (long[]) null);
        }
        zzadc zzadc2 = zzaht.zza;
        return new zzahu(j, zzadc2.zzc, zza2, zzadc2.zzf, j2, jArr);
    }

    private final long zzf(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    public final long zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final long zze(long j) {
        long j2;
        double d;
        if (!zzh()) {
            return 0;
        }
        long j3 = j - this.zza;
        if (j3 <= ((long) this.zzb)) {
            return 0;
        }
        long[] jArr = this.zzg;
        zzdi.zzb(jArr);
        double d2 = (((double) j3) * 256.0d) / ((double) this.zze);
        int zzc2 = zzet.zzc(jArr, (long) d2, true, true);
        long zzf2 = zzf(zzc2);
        long j4 = jArr[zzc2];
        int i = zzc2 + 1;
        long zzf3 = zzf(i);
        if (zzc2 == 99) {
            j2 = 256;
        } else {
            j2 = jArr[i];
        }
        if (j4 == j2) {
            d = 0.0d;
        } else {
            d = (d2 - ((double) j4)) / ((double) (j2 - j4));
        }
        return Math.round(d * ((double) (zzf3 - zzf2))) + zzf2;
    }

    public final zzadg zzg(long j) {
        double d;
        if (!zzh()) {
            zzadj zzadj = new zzadj(0, this.zza + ((long) this.zzb));
            return new zzadg(zzadj, zzadj);
        }
        long max = Math.max(0, Math.min(j, this.zzc));
        double d2 = (((double) max) * 100.0d) / ((double) this.zzc);
        double d3 = 0.0d;
        if (d2 > 0.0d) {
            if (d2 >= 100.0d) {
                d3 = 256.0d;
            } else {
                int i = (int) d2;
                long[] jArr = this.zzg;
                zzdi.zzb(jArr);
                double d4 = (double) jArr[i];
                if (i == 99) {
                    d = 256.0d;
                } else {
                    d = (double) jArr[i + 1];
                }
                d3 = ((d - d4) * (d2 - ((double) i))) + d4;
            }
        }
        long j2 = this.zze;
        zzadj zzadj2 = new zzadj(max, this.zza + Math.max((long) this.zzb, Math.min(Math.round((d3 / 256.0d) * ((double) j2)), j2 - 1)));
        return new zzadg(zzadj2, zzadj2);
    }

    public final boolean zzh() {
        if (this.zzg != null) {
            return true;
        }
        return false;
    }
}
