package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghc extends zzgew {
    private final zzghh zza;
    private final zzgvs zzb;
    private final zzgvr zzc;
    private final Integer zzd;

    private zzghc(zzghh zzghh, zzgvs zzgvs, zzgvr zzgvr, Integer num) {
        this.zza = zzghh;
        this.zzb = zzgvs;
        this.zzc = zzgvr;
        this.zzd = num;
    }

    public static zzghc zza(zzghg zzghg, zzgvs zzgvs, Integer num) throws GeneralSecurityException {
        zzgvr zzgvr;
        zzghg zzghg2 = zzghg.zzc;
        if (zzghg != zzghg2 && num == null) {
            throw new GeneralSecurityException(lf.j("For given Variant ", zzghg.toString(), " the value of idRequirement must be non-null"));
        } else if (zzghg == zzghg2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzgvs.zza() == 32) {
            zzghh zzc2 = zzghh.zzc(zzghg);
            if (zzc2.zzb() == zzghg2) {
                zzgvr = zzgml.zza;
            } else if (zzc2.zzb() == zzghg.zzb) {
                zzgvr = zzgml.zza(num.intValue());
            } else if (zzc2.zzb() == zzghg.zza) {
                zzgvr = zzgml.zzb(num.intValue());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzc2.zzb().toString()));
            }
            return new zzghc(zzc2, zzgvs, zzgvr, num);
        } else {
            throw new GeneralSecurityException(lf.h("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not ", zzgvs.zza()));
        }
    }

    public final zzghh zzb() {
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
