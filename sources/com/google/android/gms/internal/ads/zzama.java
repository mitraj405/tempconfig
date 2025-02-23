package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzama implements zzack {
    private final zzamb zza;
    private final zzek zzb;
    private final zzek zzc;
    private final zzej zzd;
    private zzacn zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private boolean zzi;

    public zzama() {
        throw null;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        zzdi.zzb(this.zze);
        int zza2 = zzacl.zza(this.zzb.zzM(), 0, 2048);
        if (!this.zzi) {
            this.zze.zzO(new zzadh(-9223372036854775807L, 0));
            this.zzi = true;
        }
        if (zza2 == -1) {
            return -1;
        }
        this.zzb.zzK(0);
        this.zzb.zzJ(zza2);
        if (!this.zzh) {
            this.zza.zzd(this.zzf, 4);
            this.zzh = true;
        }
        this.zza.zza(this.zzb);
        return 0;
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zze = zzacn;
        this.zza.zzb(zzacn, new zzans(Integer.MIN_VALUE, 0, 1));
        zzacn.zzD();
    }

    public final void zzi(long j, long j2) {
        this.zzh = false;
        this.zza.zze();
        this.zzf = j2;
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        int i = 0;
        while (true) {
            zzaby zzaby = (zzaby) zzacl;
            zzaby.zzm(this.zzc.zzM(), 0, 10, false);
            this.zzc.zzK(0);
            if (this.zzc.zzo() != 4801587) {
                break;
            }
            this.zzc.zzL(3);
            int zzl = this.zzc.zzl();
            i += zzl + 10;
            zzaby.zzl(zzl, false);
        }
        zzacl.zzj();
        zzaby zzaby2 = (zzaby) zzacl;
        zzaby2.zzl(i, false);
        if (this.zzg == -1) {
            this.zzg = (long) i;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        do {
            zzaby2.zzm(this.zzc.zzM(), 0, 2, false);
            this.zzc.zzK(0);
            if (!zzamb.zzf(this.zzc.zzq())) {
                i4++;
                zzacl.zzj();
                zzaby2.zzl(i4, false);
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                zzaby2.zzm(this.zzc.zzM(), 0, 4, false);
                this.zzd.zzl(14);
                int zzd2 = this.zzd.zzd(13);
                if (zzd2 <= 6) {
                    i4++;
                    zzacl.zzj();
                    zzaby2.zzl(i4, false);
                } else {
                    zzaby2.zzl(zzd2 - 6, false);
                    i3 += zzd2;
                }
            }
            i2 = 0;
            i3 = 0;
        } while (i4 - i < 8192);
        return false;
    }

    public zzama(int i) {
        this.zza = new zzamb(true, (String) null, 0);
        this.zzb = new zzek(2048);
        this.zzg = -1;
        zzek zzek = new zzek(10);
        this.zzc = zzek;
        byte[] zzM = zzek.zzM();
        this.zzd = new zzej(zzM, zzM.length);
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
