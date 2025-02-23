package com.google.android.gms.internal.ads;

import com.google.firebase.perf.util.Constants;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaji {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[Constants.MAX_HOST_LENGTH];
    private final zzek zzg = new zzek((int) Constants.MAX_HOST_LENGTH);

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzacl zzacl, boolean z) throws IOException {
        zza();
        this.zzg.zzH(27);
        if (zzaco.zzc(zzacl, this.zzg.zzM(), 0, 27, z) && this.zzg.zzu() == 1332176723) {
            if (this.zzg.zzm() == 0) {
                this.zza = this.zzg.zzm();
                this.zzb = this.zzg.zzr();
                this.zzg.zzs();
                this.zzg.zzs();
                this.zzg.zzs();
                int zzm = this.zzg.zzm();
                this.zzc = zzm;
                this.zzd = zzm + 27;
                this.zzg.zzH(zzm);
                if (zzaco.zzc(zzacl, this.zzg.zzM(), 0, this.zzc, z)) {
                    for (int i = 0; i < this.zzc; i++) {
                        this.zzf[i] = this.zzg.zzm();
                        this.zze += this.zzf[i];
                    }
                    return true;
                }
            } else if (z) {
                return false;
            } else {
                throw zzbo.zzc("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean zzc(zzacl zzacl, long j) throws IOException {
        boolean z;
        int i;
        if (zzacl.zzf() == zzacl.zze()) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        this.zzg.zzH(4);
        while (true) {
            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if ((i == 0 || zzacl.zzf() + 4 < j) && zzaco.zzc(zzacl, this.zzg.zzM(), 0, 4, true)) {
                this.zzg.zzK(0);
                if (this.zzg.zzu() != 1332176723) {
                    ((zzaby) zzacl).zzo(1, false);
                } else {
                    zzacl.zzj();
                    return true;
                }
            }
        }
        do {
            if ((i != 0 && zzacl.zzf() >= j) || zzacl.zzc(1) == -1) {
                return false;
            }
            break;
        } while (zzacl.zzc(1) == -1);
        return false;
    }
}
