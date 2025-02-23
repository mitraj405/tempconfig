package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgeb {
    public static final zzgen zza(zzgen zzgen) throws GeneralSecurityException {
        if (zzgen != null) {
            return zzgen;
        }
        return zzget.zza(zzb((zzgen) null).zzaV());
    }

    public static final zzgsz zzb(zzgen zzgen) {
        try {
            return ((zzgnm) zzgmk.zzc().zze((zzgen) null, zzgnm.class)).zzc();
        } catch (GeneralSecurityException e) {
            throw new zzgnz("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e);
        }
    }
}
