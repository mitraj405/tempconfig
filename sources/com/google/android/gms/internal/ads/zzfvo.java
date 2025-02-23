package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzfvo {
    public static zzfvk zza(zzfvk zzfvk) {
        if ((zzfvk instanceof zzfvn) || (zzfvk instanceof zzfvl)) {
            return zzfvk;
        }
        if (zzfvk instanceof Serializable) {
            return new zzfvl(zzfvk);
        }
        return new zzfvn(zzfvk);
    }
}
