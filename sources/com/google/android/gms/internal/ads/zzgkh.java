package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgkh implements zzgdo {
    private final zzgdo zza;
    private final byte[] zzb;

    private zzgkh(zzgdo zzgdo, byte[] bArr) {
        this.zza = zzgdo;
        int length = bArr.length;
        if (length == 0 || length == 5) {
            this.zzb = bArr;
            return;
        }
        throw new IllegalArgumentException("identifier has an invalid length");
    }

    public static zzgdo zzb(zzglj zzglj) throws GeneralSecurityException {
        byte[] bArr;
        zzgnl zza2 = zzglj.zza(zzgdx.zza());
        zzgst zza3 = zzgsv.zza();
        zza3.zzb(zza2.zzg());
        zza3.zzc(zza2.zze());
        zza3.zza(zza2.zzb());
        zzgdo zzgdo = (zzgdo) zzgeq.zzb((zzgsv) zza3.zzbr(), zzgdo.class);
        zzgtz zzc = zza2.zzc();
        int ordinal = zzc.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    bArr = zzgml.zza.zzc();
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(zzc)));
                }
            }
            bArr = zzgml.zza(zzglj.zzb().intValue()).zzc();
        } else {
            bArr = zzgml.zzb(zzglj.zzb().intValue()).zzc();
        }
        return new zzgkh(zzgdo, bArr);
    }

    public static zzgdo zzc(zzgdo zzgdo, zzgvr zzgvr) {
        return new zzgkh(zzgdo, zzgvr.zzc());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzgoa.zzc(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
