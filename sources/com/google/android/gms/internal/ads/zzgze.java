package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgze {
    public static final boolean zza(Object obj) {
        if (!((zzgzd) obj).zze()) {
            return true;
        }
        return false;
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzgzd zzgzd = (zzgzd) obj;
        zzgzd zzgzd2 = (zzgzd) obj2;
        if (!zzgzd2.isEmpty()) {
            if (!zzgzd.zze()) {
                zzgzd = zzgzd.zzb();
            }
            zzgzd.zzd(zzgzd2);
        }
        return zzgzd;
    }
}
