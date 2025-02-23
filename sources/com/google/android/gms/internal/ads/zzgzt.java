package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgzt {
    public static final /* synthetic */ int zza = 0;
    private static final zzgzt zzb = new zzgzt();
    private final zzhaf zzc = new zzgzb();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    private zzgzt() {
    }

    public static zzgzt zza() {
        return zzb;
    }

    public final zzhae zzb(Class cls) {
        zzgyl.zzc(cls, "messageType");
        zzhae zzhae = (zzhae) this.zzd.get(cls);
        if (zzhae == null) {
            zzhae = this.zzc.zza(cls);
            zzgyl.zzc(cls, "messageType");
            zzhae zzhae2 = (zzhae) this.zzd.putIfAbsent(cls, zzhae);
            if (zzhae2 == null) {
                return zzhae;
            }
            return zzhae2;
        }
        return zzhae;
    }
}
