package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaee {
    protected final zzadp zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzaee(int i, int i2, long j, int i3, zzadp zzadp) {
        int i4;
        int i5;
        i2 = i2 != 1 ? 2 : i2;
        this.zzd = j;
        this.zze = i3;
        this.zza = zzadp;
        if (i2 == 2) {
            i4 = 1667497984;
        } else {
            i4 = 1651965952;
        }
        this.zzb = zzi(i, i4);
        if (i2 == 2) {
            i5 = zzi(i, 1650720768);
        } else {
            i5 = -1;
        }
        this.zzc = i5;
        this.zzk = new long[AdRequest.MAX_CONTENT_URL_LENGTH];
        this.zzl = new int[AdRequest.MAX_CONTENT_URL_LENGTH];
    }

    private static int zzi(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private final long zzj(int i) {
        return (this.zzd * ((long) i)) / ((long) this.zze);
    }

    private final zzadj zzk(int i) {
        return new zzadj(((long) this.zzl[i]) * zzj(1), this.zzk[i]);
    }

    public final zzadg zza(long j) {
        int zzj2 = (int) (j / zzj(1));
        int zzb2 = zzet.zzb(this.zzl, zzj2, true, true);
        if (this.zzl[zzb2] == zzj2) {
            zzadj zzk2 = zzk(zzb2);
            return new zzadg(zzk2, zzk2);
        }
        zzadj zzk3 = zzk(zzb2);
        int i = zzb2 + 1;
        if (i < this.zzk.length) {
            return new zzadg(zzk3, zzk(i));
        }
        return new zzadg(zzk3, zzk3);
    }

    public final void zzb(long j) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i = this.zzj;
        jArr2[i] = j;
        this.zzl[i] = this.zzi;
        this.zzj = i + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i) {
        this.zzf = i;
        this.zzg = i;
    }

    public final void zzf(long j) {
        if (this.zzj == 0) {
            this.zzh = 0;
            return;
        }
        this.zzh = this.zzl[zzet.zzc(this.zzk, j, true, true)];
    }

    public final boolean zzg(int i) {
        if (this.zzb == i || this.zzc == i) {
            return true;
        }
        return false;
    }

    public final boolean zzh(zzacl zzacl) throws IOException {
        boolean z;
        int i;
        int i2 = this.zzg;
        int zzf2 = i2 - this.zza.zzf(zzacl, i2, false);
        this.zzg = zzf2;
        if (zzf2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.zzf > 0) {
                zzadp zzadp = this.zza;
                long zzj2 = zzj(this.zzh);
                if (Arrays.binarySearch(this.zzl, this.zzh) >= 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                zzadp.zzs(zzj2, i, this.zzf, 0, (zzado) null);
            }
            this.zzh++;
        }
        return z;
    }
}
