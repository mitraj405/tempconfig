package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggq {
    private zzghb zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzggq() {
    }

    public final zzggq zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggq zzb(zzgvs zzgvs) {
        this.zzb = zzgvs;
        return this;
    }

    public final zzggq zzc(zzghb zzghb) {
        this.zza = zzghb;
        return this;
    }

    public final zzggs zzd() throws GeneralSecurityException {
        zzgvs zzgvs;
        zzgvr zzb2;
        zzghb zzghb = this.zza;
        if (zzghb == null || (zzgvs = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzghb.zzb() != zzgvs.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzghb.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzd() == zzggz.zzc) {
                zzb2 = zzgml.zza;
            } else if (this.zza.zzd() == zzggz.zzb) {
                zzb2 = zzgml.zza(this.zzc.intValue());
            } else if (this.zza.zzd() == zzggz.zza) {
                zzb2 = zzgml.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            return new zzggs(this.zza, this.zzb, zzb2, this.zzc, (zzggr) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }

    public /* synthetic */ zzggq(zzggp zzggp) {
    }
}
