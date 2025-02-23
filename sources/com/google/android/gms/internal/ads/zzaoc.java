package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaoc {
    public static Pair zza(zzacl zzacl) throws IOException {
        zzacl.zzj();
        zzaob zzd = zzd(1684108385, zzacl, new zzek(8));
        ((zzaby) zzacl).zzo(8, false);
        return Pair.create(Long.valueOf(zzacl.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzaoa zzb(zzacl zzacl) throws IOException {
        boolean z;
        byte[] bArr;
        zzek zzek = new zzek(16);
        zzaob zzd = zzd(1718449184, zzacl, zzek);
        if (zzd.zzb >= 16) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        zzaby zzaby = (zzaby) zzacl;
        zzaby.zzm(zzek.zzM(), 0, 16, false);
        zzek.zzK(0);
        int zzk = zzek.zzk();
        int zzk2 = zzek.zzk();
        int zzj = zzek.zzj();
        int zzj2 = zzek.zzj();
        int zzk3 = zzek.zzk();
        int zzk4 = zzek.zzk();
        int i = ((int) zzd.zzb) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzaby.zzm(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = zzet.zzf;
        }
        ((zzaby) zzacl).zzo((int) (zzacl.zze() - zzacl.zzf()), false);
        return new zzaoa(zzk, zzk2, zzj, zzj2, zzk3, zzk4, bArr);
    }

    public static boolean zzc(zzacl zzacl) throws IOException {
        zzek zzek = new zzek(8);
        int i = zzaob.zza(zzacl, zzek).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ((zzaby) zzacl).zzm(zzek.zzM(), 0, 4, false);
        zzek.zzK(0);
        int zzg = zzek.zzg();
        if (zzg == 1463899717) {
            return true;
        }
        zzea.zzc("WavHeaderReader", "Unsupported form type: " + zzg);
        return false;
    }

    private static zzaob zzd(int i, zzacl zzacl, zzek zzek) throws IOException {
        zzaob zza = zzaob.zza(zzacl, zzek);
        while (true) {
            int i2 = zza.zza;
            if (i2 == i) {
                return zza;
            }
            C0709Uj.t("Ignoring unknown WAV chunk: ", i2, "WavHeaderReader");
            long j = zza.zzb;
            int i3 = ((j & 1) > 0 ? 1 : ((j & 1) == 0 ? 0 : -1));
            long j2 = j + 8;
            if (i3 != 0) {
                j2++;
            }
            if (j2 <= 2147483647L) {
                ((zzaby) zzacl).zzo((int) j2, false);
                zza = zzaob.zza(zzacl, zzek);
            } else {
                int i4 = zza.zza;
                throw zzbo.zzc("Chunk is too large (~2GB+) to skip; id: " + i4);
            }
        }
    }
}
