package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgxr implements zzgzh {
    private static final zzgxr zza = new zzgxr();

    private zzgxr() {
    }

    public static zzgxr zza() {
        return zza;
    }

    public final zzgzg zzb(Class cls) {
        Class cls2 = zzgxy.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (zzgzg) zzgxy.zzbh(cls.asSubclass(cls2)).zzbO();
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
    }

    public final boolean zzc(Class cls) {
        return zzgxy.class.isAssignableFrom(cls);
    }
}
