package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgok {
    private Integer zza = null;
    private Integer zzb = null;
    private zzgol zzc = zzgol.zzd;

    private zzgok() {
    }

    public final zzgok zza(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            this.zza = Integer.valueOf(i);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i * 8)}));
    }

    public final zzgok zzb(int i) throws GeneralSecurityException {
        if (i < 10 || i > 16) {
            throw new GeneralSecurityException(lf.h("Invalid tag size for AesCmacParameters: ", i));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzgok zzc(zzgol zzgol) {
        this.zzc = zzgol;
        return this;
    }

    public final zzgon zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        } else if (this.zzc != null) {
            return new zzgon(num.intValue(), this.zzb.intValue(), this.zzc, (zzgom) null);
        } else {
            throw new GeneralSecurityException("variant not set");
        }
    }

    public /* synthetic */ zzgok(zzgoj zzgoj) {
    }
}
