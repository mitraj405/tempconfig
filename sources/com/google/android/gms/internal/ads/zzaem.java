package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaem implements zzabt {
    private final zzacv zza;
    private final int zzb;
    private final zzacq zzc = new zzacq();

    public /* synthetic */ zzaem(zzacv zzacv, int i, zzael zzael) {
        this.zza = zzacv;
        this.zzb = i;
    }

    private final long zzc(zzacl zzacl) throws IOException {
        while (zzacl.zze() < zzacl.zzd() - 6) {
            zzacv zzacv = this.zza;
            int i = this.zzb;
            zzacq zzacq = this.zzc;
            long zze = zzacl.zze();
            byte[] bArr = new byte[2];
            zzaby zzaby = (zzaby) zzacl;
            zzaby.zzm(bArr, 0, 2, false);
            if ((((bArr[0] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[1] & UnsignedBytes.MAX_VALUE)) != i) {
                zzacl.zzj();
                zzaby.zzl((int) (zze - zzacl.zzf()), false);
            } else {
                zzek zzek = new zzek(16);
                System.arraycopy(bArr, 0, zzek.zzM(), 0, 2);
                zzek.zzJ(zzaco.zza(zzacl, zzek.zzM(), 2, 14));
                zzacl.zzj();
                zzaby.zzl((int) (zze - zzacl.zzf()), false);
                if (zzacr.zzc(zzek, zzacv, i, zzacq)) {
                    break;
                }
            }
            zzaby.zzl(1, false);
        }
        if (zzacl.zze() < zzacl.zzd() - 6) {
            return this.zzc.zza;
        }
        ((zzaby) zzacl).zzl((int) (zzacl.zzd() - zzacl.zze()), false);
        return this.zza.zzj;
    }

    public final zzabs zza(zzacl zzacl, long j) throws IOException {
        int i = this.zza.zzc;
        long zzf = zzacl.zzf();
        long zzc2 = zzc(zzacl);
        long zze = zzacl.zze();
        ((zzaby) zzacl).zzl(Math.max(6, i), false);
        int i2 = (zzc2 > j ? 1 : (zzc2 == j ? 0 : -1));
        long zzc3 = zzc(zzacl);
        long zze2 = zzacl.zze();
        if (i2 <= 0 && zzc3 > j) {
            return zzabs.zze(zze);
        }
        if (zzc3 <= j) {
            return zzabs.zzf(zzc3, zze2);
        }
        return zzabs.zzd(zzc2, zzf);
    }

    public final /* synthetic */ void zzb() {
    }
}
