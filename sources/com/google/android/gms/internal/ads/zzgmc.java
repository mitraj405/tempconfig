package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgmc {
    private static final zzgmc zza = new zzgmc();
    private final Map zzb = new HashMap();

    public static zzgmc zza() {
        return zza;
    }

    public final synchronized void zzb(zzgmb zzgmb, Class cls) throws GeneralSecurityException {
        zzgmb zzgmb2 = (zzgmb) this.zzb.get(cls);
        if (zzgmb2 != null) {
            if (!zzgmb2.equals(zzgmb)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
        }
        this.zzb.put(cls, zzgmb);
    }
}
