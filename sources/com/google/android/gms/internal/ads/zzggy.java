package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggy {
    private Integer zza = null;
    private zzggz zzb = zzggz.zzc;

    private zzggy() {
    }

    public final zzggy zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i)}));
    }

    public final zzggy zzb(zzggz zzggz) {
        this.zzb = zzggz;
        return this;
    }

    public final zzghb zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzghb(num.intValue(), this.zzb, (zzgha) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }

    public /* synthetic */ zzggy(zzggx zzggx) {
    }
}
