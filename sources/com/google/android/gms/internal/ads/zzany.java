package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzany implements zzanx {
    private final zzacn zza;
    private final zzadp zzb;
    private final zzaoa zzc;
    private final zzaf zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzany(zzacn zzacn, zzadp zzadp, zzaoa zzaoa, String str, int i) throws zzbo {
        this.zza = zzacn;
        this.zzb = zzadp;
        this.zzc = zzaoa;
        int i2 = zzaoa.zzb * zzaoa.zze;
        int i3 = zzaoa.zzd;
        int i4 = i2 / 8;
        if (i3 == i4) {
            int i5 = zzaoa.zzc * i4;
            int i6 = i5 * 8;
            int max = Math.max(i4, i5 / 10);
            this.zze = max;
            zzad zzad = new zzad();
            zzad.zzX(str);
            zzad.zzx(i6);
            zzad.zzS(i6);
            zzad.zzP(max);
            zzad.zzy(zzaoa.zzb);
            zzad.zzY(zzaoa.zzc);
            zzad.zzR(i);
            this.zzd = zzad.zzad();
            return;
        }
        throw zzbo.zza("Expected block size: " + i4 + "; got: " + i3, (Throwable) null);
    }

    public final void zza(int i, long j) {
        this.zza.zzO(new zzaod(this.zzc, 1, (long) i, j));
        this.zzb.zzl(this.zzd);
    }

    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0;
    }

    public final boolean zzc(zzacl zzacl, long j) throws IOException {
        int i;
        int i2;
        int i3;
        long j2 = j;
        while (true) {
            i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i <= 0 || (i2 = this.zzg) >= (i3 = this.zze)) {
                zzaoa zzaoa = this.zzc;
                int i4 = this.zzg;
                int i5 = zzaoa.zzd;
                int i6 = i4 / i5;
            } else {
                int zzf2 = this.zzb.zzf(zzacl, (int) Math.min((long) (i3 - i2), j2), true);
                if (zzf2 == -1) {
                    j2 = 0;
                } else {
                    this.zzg += zzf2;
                    j2 -= (long) zzf2;
                }
            }
        }
        zzaoa zzaoa2 = this.zzc;
        int i42 = this.zzg;
        int i52 = zzaoa2.zzd;
        int i62 = i42 / i52;
        if (i62 > 0) {
            int i7 = i62 * i52;
            int i8 = this.zzg - i7;
            this.zzb.zzs(this.zzf + zzet.zzt(this.zzh, 1000000, (long) zzaoa2.zzc, RoundingMode.FLOOR), 1, i7, i8, (zzado) null);
            this.zzh += (long) i62;
            this.zzg = i8;
        }
        if (i <= 0) {
            return true;
        }
        return false;
    }
}
