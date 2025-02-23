package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzhex {
    final LinkedHashMap zza;

    public zzhex(int i) {
        this.zza = zzhez.zzb(i);
    }

    public final zzhex zza(Object obj, zzhfl zzhfl) {
        zzhfk.zza(obj, "key");
        zzhfk.zza(zzhfl, "provider");
        this.zza.put(obj, zzhfl);
        return this;
    }
}
