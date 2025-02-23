package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgma {
    public static final /* synthetic */ int zza = 0;
    private static final zzglz zzb = new zzgly();
    private static final zzgma zzc = zze();
    private final Map zzd = new HashMap();

    public static zzgma zzb() {
        return zzc;
    }

    private final synchronized zzgdy zzd(zzgen zzgen, Integer num) throws GeneralSecurityException {
        zzglz zzglz;
        zzglz = (zzglz) this.zzd.get(zzgen.getClass());
        if (zzglz != null) {
        } else {
            String obj = zzgen.toString();
            throw new GeneralSecurityException("Cannot create a new key for parameters " + obj + ": no key creator for this class was registered.");
        }
        return zzglz.zza(zzgen, num);
    }

    private static zzgma zze() {
        zzgma zzgma = new zzgma();
        try {
            zzgma.zzc(zzb, zzglk.class);
            return zzgma;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final zzgdy zza(zzgen zzgen, Integer num) throws GeneralSecurityException {
        return zzd(zzgen, num);
    }

    public final synchronized void zzc(zzglz zzglz, Class cls) throws GeneralSecurityException {
        zzglz zzglz2 = (zzglz) this.zzd.get(cls);
        if (zzglz2 != null) {
            if (!zzglz2.equals(zzglz)) {
                String obj = cls.toString();
                throw new GeneralSecurityException("Different key creator for parameters class " + obj + " already inserted");
            }
        }
        this.zzd.put(cls, zzglz);
    }
}
