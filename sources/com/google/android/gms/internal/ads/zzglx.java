package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzglx {
    public static final zzglo zza = new zzglw((zzglv) null);

    public static zzglu zza(zzgnj zzgnj) {
        zzgea zzgea;
        zzglq zzglq = new zzglq();
        zzglq.zzb(zzgnj.zza());
        for (List it : zzgnj.zze()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzgnh zzgnh = (zzgnh) it2.next();
                    int zzf = zzgnh.zzf() - 2;
                    if (zzf == 1) {
                        zzgea = zzgea.zza;
                    } else if (zzf == 2) {
                        zzgea = zzgea.zzb;
                    } else if (zzf == 3) {
                        zzgea = zzgea.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzgnh.zza();
                    String zze = zzgnh.zze();
                    if (zze.startsWith("type.googleapis.com/google.crypto.")) {
                        zze = zze.substring(34);
                    }
                    zzglq.zza(zzgea, zza2, zze, zzgnh.zzb().name());
                }
            }
        }
        if (zzgnj.zzc() != null) {
            zzglq.zzc(zzgnj.zzc().zza());
        }
        try {
            return zzglq.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
