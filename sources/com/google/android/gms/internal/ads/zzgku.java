package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgku {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzgku() {
    }

    public final zzgku zza(Enum enumR, Object obj) {
        this.zza.put(enumR, obj);
        this.zzb.put(obj, enumR);
        return this;
    }

    public final zzgkw zzb() {
        return new zzgkw(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), (zzgkv) null);
    }

    public /* synthetic */ zzgku(zzgkt zzgkt) {
    }
}
