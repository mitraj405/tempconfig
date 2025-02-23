package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzgfv implements zzglz {
    public final zzgdy zza(zzgen zzgen, Integer num) {
        zzggb zzggb = (zzggb) zzgen;
        int i = zzgfw.zza;
        if (zzggb.zzc() != 24) {
            zzgfr zzgfr = new zzgfr((zzgfq) null);
            zzgfr.zzc(zzggb);
            zzgfr.zza(num);
            zzgfr.zzb(zzgvs.zzc(zzggb.zzc()));
            return zzgfr.zzd();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }
}
