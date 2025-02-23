package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggd {
    private zzggo zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzggd() {
    }

    public final zzggd zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggd zzb(zzgvs zzgvs) {
        this.zzb = zzgvs;
        return this;
    }

    public final zzggd zzc(zzggo zzggo) {
        this.zza = zzggo;
        return this;
    }

    public final zzggf zzd() throws GeneralSecurityException {
        zzgvs zzgvs;
        zzgvr zzb2;
        zzggo zzggo = this.zza;
        if (zzggo == null || (zzgvs = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzggo.zzb() != zzgvs.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzggo.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzggm.zzc) {
                zzb2 = zzgml.zza;
            } else if (this.zza.zzd() == zzggm.zzb) {
                zzb2 = zzgml.zza(this.zzc.intValue());
            } else if (this.zza.zzd() == zzggm.zza) {
                zzb2 = zzgml.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            return new zzggf(this.zza, this.zzb, zzb2, this.zzc, (zzgge) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }

    public /* synthetic */ zzggd(zzggc zzggc) {
    }
}
