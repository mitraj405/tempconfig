package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaht {
    public final zzadc zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzaht(zzadc zzadc, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = new zzadc(zzadc);
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzaht zzb(zzadc zzadc, zzek zzek) {
        int i;
        long j;
        long[] jArr;
        int i2;
        int i3;
        int zzg = zzek.zzg();
        if ((zzg & 1) != 0) {
            i = zzek.zzp();
        } else {
            i = -1;
        }
        if ((zzg & 2) != 0) {
            j = zzek.zzu();
        } else {
            j = -1;
        }
        long j2 = j;
        if ((zzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i4 = 0; i4 < 100; i4++) {
                jArr2[i4] = (long) zzek.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((zzg & 8) != 0) {
            zzek.zzL(4);
        }
        if (zzek.zzb() >= 24) {
            zzek.zzL(21);
            int zzo = zzek.zzo();
            i2 = zzo & 4095;
            i3 = zzo >> 12;
        } else {
            i3 = -1;
            i2 = -1;
        }
        return new zzaht(zzadc, (long) i, j2, jArr, i3, i2);
    }

    public final long zza() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        zzadc zzadc = this.zza;
        return zzet.zzs((j * ((long) zzadc.zzg)) - 1, zzadc.zzd);
    }
}
