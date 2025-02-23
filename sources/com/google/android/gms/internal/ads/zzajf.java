package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzajf extends zzajo {
    private zzacv zza;
    private zzaje zzb;

    private static boolean zzd(byte[] bArr) {
        if (bArr[0] == -1) {
            return true;
        }
        return false;
    }

    public final long zza(zzek zzek) {
        if (!zzd(zzek.zzM())) {
            return -1;
        }
        int i = (zzek.zzM()[2] & UnsignedBytes.MAX_VALUE) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zza2 = zzacr.zza(zzek, i);
            zzek.zzK(0);
            return (long) zza2;
        }
        zzek.zzL(4);
        zzek.zzw();
        int zza22 = zzacr.zza(zzek, i);
        zzek.zzK(0);
        return (long) zza22;
    }

    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    public final boolean zzc(zzek zzek, long j, zzajl zzajl) {
        byte[] zzM = zzek.zzM();
        zzacv zzacv = this.zza;
        if (zzacv == null) {
            zzacv zzacv2 = new zzacv(zzM, 17);
            this.zza = zzacv2;
            zzajl.zza = zzacv2.zzc(Arrays.copyOfRange(zzM, 9, zzek.zze()), (zzbk) null);
            return true;
        } else if ((zzM[0] & Ascii.DEL) == 3) {
            zzacu zzb2 = zzacs.zzb(zzek);
            zzacv zzf = zzacv.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzaje(zzf, zzb2);
            return true;
        } else if (!zzd(zzM)) {
            return true;
        } else {
            zzaje zzaje = this.zzb;
            if (zzaje != null) {
                zzaje.zza(j);
                zzajl.zzb = this.zzb;
            }
            zzajl.zza.getClass();
            return false;
        }
    }
}
