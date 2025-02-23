package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgfd {
    private zzgfp zza = null;
    private zzgvs zzb = null;
    private zzgvs zzc = null;
    private Integer zzd = null;

    private zzgfd() {
    }

    public final zzgfd zza(zzgvs zzgvs) {
        this.zzb = zzgvs;
        return this;
    }

    public final zzgfd zzb(zzgvs zzgvs) {
        this.zzc = zzgvs;
        return this;
    }

    public final zzgfd zzc(Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzgfd zzd(zzgfp zzgfp) {
        this.zza = zzgfp;
        return this;
    }

    public final zzgff zze() throws GeneralSecurityException {
        zzgvr zzb2;
        zzgfp zzgfp = this.zza;
        if (zzgfp != null) {
            zzgvs zzgvs = this.zzb;
            if (zzgvs == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzgfp.zzb() != zzgvs.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (zzgfp.zzc() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zza() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zza() || this.zzd == null) {
                if (this.zza.zzh() == zzgfn.zzc) {
                    zzb2 = zzgml.zza;
                } else if (this.zza.zzh() == zzgfn.zzb) {
                    zzb2 = zzgml.zza(this.zzd.intValue());
                } else if (this.zza.zzh() == zzgfn.zza) {
                    zzb2 = zzgml.zzb(this.zzd.intValue());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzh())));
                }
                return new zzgff(this.zza, this.zzb, this.zzc, zzb2, this.zzd, (zzgfe) null);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        } else {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }

    public /* synthetic */ zzgfd(zzgfc zzgfc) {
    }
}
