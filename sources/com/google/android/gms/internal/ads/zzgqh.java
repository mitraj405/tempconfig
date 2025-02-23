package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgqh implements zzgem {
    private zzgqh(zzgem zzgem, zzgtz zzgtz, byte[] bArr) {
    }

    public static zzgem zza(zzglj zzglj) throws GeneralSecurityException {
        byte[] bArr;
        zzgnl zza = zzglj.zza(zzgdx.zza());
        zzgst zza2 = zzgsv.zza();
        zza2.zzb(zza.zzg());
        zza2.zzc(zza.zze());
        zza2.zza(zza.zzb());
        zzgem zzgem = (zzgem) zzgeq.zzb((zzgsv) zza2.zzbr(), zzgem.class);
        zzgtz zzc = zza.zzc();
        int ordinal = zzc.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    bArr = zzgml.zza.zzc();
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
            }
            bArr = zzgml.zza(zzglj.zzb().intValue()).zzc();
        } else {
            bArr = zzgml.zzb(zzglj.zzb().intValue()).zzc();
        }
        return new zzgqh(zzgem, zzc, bArr);
    }
}
