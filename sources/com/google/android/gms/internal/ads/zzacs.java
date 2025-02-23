package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzacs {
    public static zzbk zza(zzacl zzacl, boolean z) throws IOException {
        zzaga zzaga;
        if (z) {
            zzaga = null;
        } else {
            zzaga = zzagc.zza;
        }
        zzbk zza = new zzada().zza(zzacl, zzaga);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }

    public static zzacu zzb(zzek zzek) {
        zzek.zzL(1);
        int zzo = zzek.zzo();
        long zzd = (long) zzek.zzd();
        long j = (long) zzo;
        int i = zzo / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzt = zzek.zzt();
            if (zzt == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = zzt;
            jArr2[i2] = zzek.zzt();
            zzek.zzL(2);
            i2++;
        }
        zzek.zzL((int) ((zzd + j) - ((long) zzek.zzd())));
        return new zzacu(jArr, jArr2);
    }
}
