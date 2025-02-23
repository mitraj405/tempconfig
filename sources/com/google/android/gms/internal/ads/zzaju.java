package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaju {
    public static void zza(zzajv zzajv, zzajz zzajz, zzdn zzdn) {
        for (int i = 0; i < zzajv.zza(); i++) {
            long zzb = zzajv.zzb(i);
            List zzc = zzajv.zzc(zzb);
            if (!zzc.isEmpty()) {
                if (i != zzajv.zza() - 1) {
                    long zzb2 = zzajv.zzb(i + 1) - zzajv.zzb(i);
                    if (zzb2 > 0) {
                        zzdn.zza(new zzajs(zzc, zzb, zzb2));
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }
}
