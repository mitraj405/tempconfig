package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgoc {
    private zzgon zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzgoc() {
    }

    public final zzgoc zza(zzgvs zzgvs) throws GeneralSecurityException {
        this.zzb = zzgvs;
        return this;
    }

    public final zzgoc zzb(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgoc zzc(zzgon zzgon) {
        this.zza = zzgon;
        return this;
    }

    public final zzgoe zzd() throws GeneralSecurityException {
        zzgvs zzgvs;
        zzgvr zza2;
        zzgon zzgon = this.zza;
        if (zzgon == null || (zzgvs = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgon.zzc() != zzgvs.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgon.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzf() == zzgol.zzd) {
                zza2 = zzgml.zza;
            } else if (this.zza.zzf() == zzgol.zzc || this.zza.zzf() == zzgol.zzb) {
                zza2 = zzgml.zza(this.zzc.intValue());
            } else if (this.zza.zzf() == zzgol.zza) {
                zza2 = zzgml.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
            }
            return new zzgoe(this.zza, this.zzb, zza2, this.zzc, (zzgod) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }

    public /* synthetic */ zzgoc(zzgob zzgob) {
    }
}
