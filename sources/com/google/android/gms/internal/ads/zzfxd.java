package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfxd extends zzfxg {
    public zzfxd() {
        super((zzfxf) null);
    }

    public static final zzfxg zzf(int i) {
        if (i < 0) {
            return zzfxg.zzb;
        }
        if (i > 0) {
            return zzfxg.zzc;
        }
        return zzfxg.zza;
    }

    public final int zza() {
        return 0;
    }

    public final zzfxg zzb(int i, int i2) {
        int i3;
        if (i < i2) {
            i3 = -1;
        } else if (i > i2) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return zzf(i3);
    }

    public final zzfxg zzc(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    public final zzfxg zzd(boolean z, boolean z2) {
        return zzf(zzgal.zza(z, z2));
    }

    public final zzfxg zze(boolean z, boolean z2) {
        return zzf(zzgal.zza(z2, z));
    }
}
