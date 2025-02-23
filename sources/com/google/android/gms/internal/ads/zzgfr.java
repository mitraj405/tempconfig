package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgfr {
    private zzggb zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzgfr() {
    }

    public final zzgfr zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgfr zzb(zzgvs zzgvs) {
        this.zzb = zzgvs;
        return this;
    }

    public final zzgfr zzc(zzggb zzggb) {
        this.zza = zzggb;
        return this;
    }

    public final zzgft zzd() throws GeneralSecurityException {
        zzgvs zzgvs;
        zzgvr zzb2;
        zzggb zzggb = this.zza;
        if (zzggb == null || (zzgvs = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzggb.zzc() != zzgvs.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzggb.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zze() == zzgfz.zzc) {
                zzb2 = zzgml.zza;
            } else if (this.zza.zze() == zzgfz.zzb) {
                zzb2 = zzgml.zza(this.zzc.intValue());
            } else if (this.zza.zze() == zzgfz.zza) {
                zzb2 = zzgml.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
            }
            return new zzgft(this.zza, this.zzb, zzb2, this.zzc, (zzgfs) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }

    public /* synthetic */ zzgfr(zzgfq zzgfq) {
    }
}
