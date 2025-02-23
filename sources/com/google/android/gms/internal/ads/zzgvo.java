package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgvo implements zzgem {
    private static final byte[] zza = {0};
    private final zzgqi zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzgvo(zzgoe zzgoe) throws GeneralSecurityException {
        this.zzb = new zzgvl(zzgoe.zzd().zzd(zzgdx.zza()));
        this.zzc = zzgoe.zzb().zzb();
        this.zzd = zzgoe.zzc().zzc();
        if (zzgoe.zzb().zzf().equals(zzgol.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzgem zza(zzgoe zzgoe) throws GeneralSecurityException {
        return new zzgvo(zzgoe);
    }

    public static zzgem zzb(zzgov zzgov) throws GeneralSecurityException {
        return new zzgvo(zzgov);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        if (bArr2.length > 0) {
            return zzgup.zzb(this.zzd, this.zzb.zza(zzgup.zzb(bArr, bArr2), this.zzc));
        }
        return zzgup.zzb(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzgvo(zzgov zzgov) throws GeneralSecurityException {
        String valueOf = String.valueOf(zzgov.zzb().zzf());
        this.zzb = new zzgvn("HMAC".concat(valueOf), new SecretKeySpec(zzgov.zzd().zzd(zzgdx.zza()), "HMAC"));
        this.zzc = zzgov.zzb().zzb();
        this.zzd = zzgov.zzc().zzc();
        if (zzgov.zzb().zzg().equals(zzgpe.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzgvo(zzgqi zzgqi, int i) throws GeneralSecurityException {
        this.zzb = zzgqi;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzgqi.zza(new byte[0], i);
    }
}
