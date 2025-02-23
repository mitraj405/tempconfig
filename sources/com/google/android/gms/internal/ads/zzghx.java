package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghx extends zzgew {
    private final zzgid zza;
    private final zzgvr zzb;
    private final Integer zzc;

    private zzghx(zzgid zzgid, zzgvr zzgvr, Integer num) {
        this.zza = zzgid;
        this.zzb = zzgvr;
        this.zzc = num;
    }

    public static zzghx zza(zzgid zzgid, Integer num) throws GeneralSecurityException {
        zzgvr zzgvr;
        if (zzgid.zzc() == zzgib.zzb) {
            if (num == null) {
                zzgvr = zzgml.zza;
            } else {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
        } else if (zzgid.zzc() != zzgib.zza) {
            throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(zzgid.zzc())));
        } else if (num != null) {
            zzgvr = zzgml.zzb(num.intValue());
        } else {
            throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
        }
        return new zzghx(zzgid, zzgvr, num);
    }

    public final zzgid zzb() {
        return this.zza;
    }

    public final zzgvr zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zzc;
    }
}
