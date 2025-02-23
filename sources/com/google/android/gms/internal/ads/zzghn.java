package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzghn implements zzgmv {
    public final Object zza(zzgdy zzgdy) {
        zzghx zzghx = (zzghx) zzgdy;
        int i = zzgho.zza;
        String zzd = zzghx.zzb().zzd();
        zzgex zzb = zzghx.zzb().zzb();
        zzgdo zzb2 = zzgel.zza(zzd).zzb();
        int i2 = zzghl.zza;
        try {
            return zzgkh.zzc(new zzghl(zzgsz.zzf(zzget.zzb(zzb), zzgxi.zza()), zzb2), zzghx.zzc());
        } catch (zzgyn e) {
            throw new GeneralSecurityException(e);
        }
    }
}
