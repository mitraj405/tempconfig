package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzggi implements zzglz {
    public final zzgdy zza(zzgen zzgen, Integer num) {
        zzggo zzggo = (zzggo) zzgen;
        int i = zzggj.zza;
        if (zzggo.zzb() != 24) {
            zzggd zzggd = new zzggd((zzggc) null);
            zzggd.zzc(zzggo);
            zzggd.zza(num);
            zzggd.zzb(zzgvs.zzc(zzggo.zzb()));
            return zzggd.zzd();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }
}
