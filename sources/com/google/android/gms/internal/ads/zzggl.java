package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggl {
    private Integer zza = null;
    private Integer zzb = null;
    private Integer zzc = null;
    private zzggm zzd = zzggm.zzc;

    private zzggl() {
    }

    public final zzggl zza(int i) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzggl zzb(int i) throws GeneralSecurityException {
        if (i == 16 || i == 24 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }

    public final zzggl zzc(int i) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzggl zzd(zzggm zzggm) {
        this.zzd = zzggm;
        return this;
    }

    public final zzggo zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            this.zzb.intValue();
            this.zzc.intValue();
            return new zzggo(intValue, 12, 16, this.zzd, (zzggn) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }

    public /* synthetic */ zzggl(zzggk zzggk) {
    }
}
