package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzajh {
    private final zzaji zza = new zzaji();
    private final zzek zzb = new zzek(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzaji zzaji = this.zza;
            if (i5 >= zzaji.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzaji.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzek zza() {
        return this.zzb;
    }

    public final zzaji zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzH(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzek zzek = this.zzb;
        if (zzek.zzM().length != 65025) {
            zzek.zzI(Arrays.copyOf(zzek.zzM(), Math.max(65025, zzek.zze())), this.zzb.zze());
        }
    }

    public final boolean zze(zzacl zzacl) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzH(0);
        }
        while (true) {
            boolean z = true;
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                if (!this.zza.zzc(zzacl, -1) || !this.zza.zzb(zzacl, true)) {
                    return false;
                }
                zzaji zzaji = this.zza;
                int i2 = zzaji.zzd;
                if ((zzaji.zza & 1) == 1 && this.zzb.zze() == 0) {
                    i2 += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzaco.zze(zzacl, i2)) {
                    return false;
                }
                this.zzc = i;
            }
            int zzf = zzf(i);
            int i3 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzek zzek = this.zzb;
                zzek.zzE(zzek.zze() + zzf);
                zzek zzek2 = this.zzb;
                if (!zzaco.zzd(zzacl, zzek2.zzM(), zzek2.zze(), zzf)) {
                    return false;
                }
                zzek zzek3 = this.zzb;
                zzek3.zzJ(zzek3.zze() + zzf);
                if (this.zza.zzf[i3 - 1] == 255) {
                    z = false;
                }
                this.zze = z;
            }
            if (i3 == this.zza.zzc) {
                i3 = -1;
            }
            this.zzc = i3;
        }
        return false;
    }
}
