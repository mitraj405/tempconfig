package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzalw implements zzack {
    private final zzalx zza = new zzalx((String) null, 0);
    private final zzek zzb = new zzek(2786);
    private boolean zzc;

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        int zza2 = zzacl.zza(this.zzb.zzM(), 0, 2786);
        if (zza2 == -1) {
            return -1;
        }
        this.zzb.zzK(0);
        this.zzb.zzJ(zza2);
        if (!this.zzc) {
            this.zza.zzd(0, 4);
            this.zzc = true;
        }
        this.zza.zza(this.zzb);
        return 0;
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zza.zzb(zzacn, new zzans(Integer.MIN_VALUE, 0, 1));
        zzacn.zzD();
        zzacn.zzO(new zzadh(-9223372036854775807L, 0));
    }

    public final void zzi(long j, long j2) {
        this.zzc = false;
        this.zza.zze();
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        zzek zzek = new zzek(10);
        int i = 0;
        while (true) {
            zzaby zzaby = (zzaby) zzacl;
            zzaby.zzm(zzek.zzM(), 0, 10, false);
            zzek.zzK(0);
            if (zzek.zzo() != 4801587) {
                break;
            }
            zzek.zzL(3);
            int zzl = zzek.zzl();
            i += zzl + 10;
            zzaby.zzl(zzl, false);
        }
        zzacl.zzj();
        zzaby zzaby2 = (zzaby) zzacl;
        zzaby2.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzaby2.zzm(zzek.zzM(), 0, 6, false);
            zzek.zzK(0);
            if (zzek.zzq() != 2935) {
                zzacl.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzaby2.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int zzb2 = zzabj.zzb(zzek.zzM());
                if (zzb2 == -1) {
                    return false;
                }
                zzaby2.zzl(zzb2 - 6, false);
            }
        }
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
