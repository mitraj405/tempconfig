package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggw {
    private static final zzgmx zza;
    private static final zzglz zzb = new zzggu();
    private static final zzgmb zzc = new zzggv();
    private static final zzgdz zzd;

    static {
        Class<zzgdo> cls = zzgdo.class;
        zza = zzgmx.zzb(new zzggt(), zzggs.class, cls);
        zzd = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesGcmSivKey", cls, zzgsu.SYMMETRIC, zzgry.zzg());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            int i = zzgjq.zza;
            zzgjq.zze(zzgmk.zzc());
            if (zzb()) {
                zzgmh.zza().zze(zza);
                zzgmg zzb2 = zzgmg.zzb();
                HashMap hashMap = new HashMap();
                zzggy zzggy = new zzggy((zzggx) null);
                zzggy.zza(16);
                zzggz zzggz = zzggz.zza;
                zzggy.zzb(zzggz);
                hashMap.put("AES128_GCM_SIV", zzggy.zzc());
                zzggy zzggy2 = new zzggy((zzggx) null);
                zzggy2.zza(16);
                zzggz zzggz2 = zzggz.zzc;
                zzggy2.zzb(zzggz2);
                hashMap.put("AES128_GCM_SIV_RAW", zzggy2.zzc());
                zzggy zzggy3 = new zzggy((zzggx) null);
                zzggy3.zza(32);
                zzggy3.zzb(zzggz);
                hashMap.put("AES256_GCM_SIV", zzggy3.zzc());
                zzggy zzggy4 = new zzggy((zzggx) null);
                zzggy4.zza(32);
                zzggy4.zzb(zzggz2);
                hashMap.put("AES256_GCM_SIV_RAW", zzggy4.zzc());
                zzb2.zzd(Collections.unmodifiableMap(hashMap));
                Class<zzghb> cls = zzghb.class;
                zzgmc.zza().zzb(zzc, cls);
                zzgma.zzb().zzc(zzb, cls);
                zzgky.zzc().zzd(zzd, true);
                return;
            }
            return;
        }
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }

    private static boolean zzb() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}
