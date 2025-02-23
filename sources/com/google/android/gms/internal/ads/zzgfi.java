package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzgfi implements zzglz {
    public final zzgdy zza(zzgen zzgen, Integer num) {
        zzgfp zzgfp = (zzgfp) zzgen;
        int i = zzgfj.zza;
        if (zzgfp.zzb() == 16 || zzgfp.zzb() == 32) {
            zzgfd zzgfd = new zzgfd((zzgfc) null);
            zzgfd.zzd(zzgfp);
            zzgfd.zzc(num);
            zzgfd.zza(zzgvs.zzc(zzgfp.zzb()));
            zzgfd.zzb(zzgvs.zzc(zzgfp.zzc()));
            return zzgfd.zze();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }
}
