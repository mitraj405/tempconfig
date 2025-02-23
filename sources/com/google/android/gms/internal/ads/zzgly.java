package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzgly implements zzglz {
    public final zzgdy zza(zzgen zzgen, Integer num) {
        int i = zzgma.zza;
        zzgsz zzc = ((zzglk) zzgen).zzb().zzc();
        zzgdz zzb = zzgky.zzc().zzb(zzc.zzi());
        if (zzgky.zzc().zze(zzc.zzi())) {
            zzgsv zza = zzb.zza(zzc.zzh());
            return new zzglj(zzgnl.zza(zza.zzg(), zza.zzf(), zza.zzc(), zzc.zzg(), num), zzgdx.zza());
        }
        throw new GeneralSecurityException("Creating new keys is not allowed.");
    }
}
