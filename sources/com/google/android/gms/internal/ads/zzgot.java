package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgot {
    private zzgpg zza = null;
    private zzgvs zzb = null;
    private Integer zzc = null;

    private zzgot() {
    }

    public final zzgot zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgot zzb(zzgvs zzgvs) {
        this.zzb = zzgvs;
        return this;
    }

    public final zzgot zzc(zzgpg zzgpg) {
        this.zza = zzgpg;
        return this;
    }

    public final zzgov zzd() throws GeneralSecurityException {
        zzgvs zzgvs;
        zzgvr zza2;
        zzgpg zzgpg = this.zza;
        if (zzgpg == null || (zzgvs = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgpg.zzc() != zzgvs.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgpg.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zza() || this.zzc == null) {
            if (this.zza.zzg() == zzgpe.zzd) {
                zza2 = zzgml.zza;
            } else if (this.zza.zzg() == zzgpe.zzc || this.zza.zzg() == zzgpe.zzb) {
                zza2 = zzgml.zza(this.zzc.intValue());
            } else if (this.zza.zzg() == zzgpe.zza) {
                zza2 = zzgml.zzb(this.zzc.intValue());
            } else {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zzg())));
            }
            return new zzgov(this.zza, this.zzb, zza2, this.zzc, (zzgou) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }

    public /* synthetic */ zzgot(zzgos zzgos) {
    }
}
