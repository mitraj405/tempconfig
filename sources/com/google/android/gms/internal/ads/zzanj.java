package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzanj implements zzabt {
    private final zzer zza;
    private final zzek zzb = new zzek();
    private final int zzc;

    public zzanj(int i, zzer zzer, int i2) {
        this.zzc = i;
        this.zza = zzer;
    }

    public final zzabs zza(zzacl zzacl, long j) throws IOException {
        int zza2;
        int i;
        long zzf = zzacl.zzf();
        int min = (int) Math.min(112800, zzacl.zzd() - zzf);
        this.zzb.zzH(min);
        ((zzaby) zzacl).zzm(this.zzb.zzM(), 0, min, false);
        zzek zzek = this.zzb;
        int zze = zzek.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzek.zzb() >= 188 && (i = zza2 + 188) <= zze) {
            long zzb2 = zzanu.zzb(zzek, (zza2 = zzanu.zza(zzek.zzM(), zzek.zzd(), zze)), this.zzc);
            if (zzb2 != -9223372036854775807L) {
                long zzb3 = this.zza.zzb(zzb2);
                if (zzb3 <= j) {
                    j4 = (long) zza2;
                    if (100000 + zzb3 <= j) {
                        j3 = zzb3;
                    }
                } else if (j3 == -9223372036854775807L) {
                    return zzabs.zzd(zzb3, zzf);
                }
                return zzabs.zze(zzf + j4);
            }
            zzek.zzK(i);
            j2 = (long) i;
        }
        if (j3 != -9223372036854775807L) {
            return zzabs.zzf(j3, zzf + j2);
        }
        return zzabs.zza;
    }

    public final void zzb() {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
