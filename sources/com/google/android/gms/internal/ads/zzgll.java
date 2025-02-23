package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgll {
    private HashMap zza = new HashMap();

    public final zzgln zza() {
        if (this.zza != null) {
            zzgln zzgln = new zzgln(Collections.unmodifiableMap(this.zza), (zzglm) null);
            this.zza = null;
            return zzgln;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
