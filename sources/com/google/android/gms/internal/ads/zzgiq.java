package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgiq extends zzgew {
    private final zzgiw zza;
    private final zzgvs zzb;
    private final zzgvr zzc;
    private final Integer zzd;

    private zzgiq(zzgiw zzgiw, zzgvs zzgvs, zzgvr zzgvr, Integer num) {
        this.zza = zzgiw;
        this.zzb = zzgvs;
        this.zzc = zzgvr;
        this.zzd = num;
    }

    public static zzgiq zza(zzgiv zzgiv, zzgvs zzgvs, Integer num) throws GeneralSecurityException {
        zzgvr zzgvr;
        zzgiv zzgiv2 = zzgiv.zzc;
        if (zzgiv != zzgiv2 && num == null) {
            throw new GeneralSecurityException(lf.j("For given Variant ", zzgiv.toString(), " the value of idRequirement must be non-null"));
        } else if (zzgiv == zzgiv2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgvs.zza() == 32) {
            zzgiw zzc2 = zzgiw.zzc(zzgiv);
            if (zzc2.zzb() == zzgiv2) {
                zzgvr = zzgml.zza;
            } else if (zzc2.zzb() == zzgiv.zzb) {
                zzgvr = zzgml.zza(num.intValue());
            } else if (zzc2.zzb() == zzgiv.zza) {
                zzgvr = zzgml.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzc2.zzb().toString()));
            }
            return new zzgiq(zzc2, zzgvs, zzgvr, num);
        } else {
            throw new GeneralSecurityException(lf.h("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not ", zzgvs.zza()));
        }
    }

    public final zzgiw zzb() {
        return this.zza;
    }

    public final zzgvr zzc() {
        return this.zzc;
    }

    public final zzgvs zzd() {
        return this.zzb;
    }

    public final Integer zze() {
        return this.zzd;
    }
}
