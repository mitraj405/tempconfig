package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzame implements zzamf {
    private final List zza;
    private final zzadp[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = -9223372036854775807L;

    public zzame(List list) {
        this.zza = list;
        this.zzb = new zzadp[list.size()];
    }

    private final boolean zzf(zzek zzek, int i) {
        if (zzek.zzb() == 0) {
            return false;
        }
        if (zzek.zzm() != i) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza(zzek zzek) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzek, 32)) {
            if (this.zzd != 1 || zzf(zzek, 0)) {
                int zzd2 = zzek.zzd();
                int zzb2 = zzek.zzb();
                zzadp[] zzadpArr = this.zzb;
                for (zzadp zzq : zzadpArr) {
                    zzek.zzK(zzd2);
                    zzq.zzq(zzek, zzb2);
                }
                this.zze += zzb2;
            }
        }
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzanp zzanp = (zzanp) this.zza.get(i);
            zzans.zzc();
            zzadp zzw = zzacn.zzw(zzans.zza(), 3);
            zzad zzad = new zzad();
            zzad.zzK(zzans.zzb());
            zzad.zzX("application/dvbsubs");
            zzad.zzL(Collections.singletonList(zzanp.zzb));
            zzad.zzO(zzanp.zza);
            zzw.zzl(zzad.zzad());
            this.zzb[i] = zzw;
        }
    }

    public final void zzc(boolean z) {
        boolean z2;
        if (this.zzc) {
            if (this.zzf != -9223372036854775807L) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzdi.zzf(z2);
            zzadp[] zzadpArr = this.zzb;
            for (zzadp zzs : zzadpArr) {
                zzs.zzs(this.zzf, 1, this.zze, 0, (zzado) null);
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzf = j;
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzf = -9223372036854775807L;
    }
}
