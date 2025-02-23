package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaly implements zzack {
    private final zzalz zza = new zzalz((String) null, 0);
    private final zzek zzb = new zzek(16384);
    private boolean zzc;

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        int zza2 = zzacl.zza(this.zzb.zzM(), 0, 16384);
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
        int i;
        zzek zzek = new zzek(10);
        int i2 = 0;
        while (true) {
            zzaby zzaby = (zzaby) zzacl;
            zzaby.zzm(zzek.zzM(), 0, 10, false);
            zzek.zzK(0);
            if (zzek.zzo() != 4801587) {
                break;
            }
            zzek.zzL(3);
            int zzl = zzek.zzl();
            i2 += zzl + 10;
            zzaby.zzl(zzl, false);
        }
        zzacl.zzj();
        zzaby zzaby2 = (zzaby) zzacl;
        zzaby2.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzaby2.zzm(zzek.zzM(), 0, 7, false);
            zzek.zzK(0);
            int zzq = zzek.zzq();
            if (zzq == 44096 || zzq == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] zzM = zzek.zzM();
                if (zzM.length < 7) {
                    i = -1;
                } else {
                    byte b = ((zzM[2] & UnsignedBytes.MAX_VALUE) << 8) | (zzM[3] & UnsignedBytes.MAX_VALUE);
                    if (b == 65535) {
                        b = ((zzM[4] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((zzM[5] & UnsignedBytes.MAX_VALUE) << 8) | (zzM[6] & UnsignedBytes.MAX_VALUE);
                    } else {
                        i5 = 4;
                    }
                    if (zzq == 44097) {
                        i5 += 2;
                    }
                    i = b + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzaby2.zzl(i - 7, false);
            } else {
                zzacl.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzaby2.zzl(i4, false);
                i3 = 0;
            }
        }
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
