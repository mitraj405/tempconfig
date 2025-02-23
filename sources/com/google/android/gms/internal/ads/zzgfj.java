package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgfj {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb;
    private static final zzgdz zzc;
    private static final zzgmb zzd = new zzgfh();
    private static final zzglz zze = new zzgfi();
    private static final int zzf = 2;

    static {
        Class<zzgdo> cls = zzgdo.class;
        zzb = zzgmx.zzb(new zzgfg(), zzgff.class, cls);
        zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", cls, zzgsu.SYMMETRIC, zzgqu.zzh());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgkr.zza(i)) {
            int i2 = zzgjb.zza;
            zzgjb.zze(zzgmk.zzc());
            zzgmh.zza().zze(zzb);
            zzgmg zzb2 = zzgmg.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_CTR_HMAC_SHA256", zzgip.zze);
            zzgfl zzgfl = new zzgfl((zzgfk) null);
            zzgfl.zza(16);
            zzgfl.zzc(32);
            zzgfl.zze(16);
            zzgfl.zzd(16);
            zzgfm zzgfm = zzgfm.zzc;
            zzgfl.zzb(zzgfm);
            zzgfn zzgfn = zzgfn.zzc;
            zzgfl.zzf(zzgfn);
            hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzgfl.zzg());
            hashMap.put("AES256_CTR_HMAC_SHA256", zzgip.zzf);
            zzgfl zzgfl2 = new zzgfl((zzgfk) null);
            zzgfl2.zza(32);
            zzgfl2.zzc(32);
            zzgfl2.zze(32);
            zzgfl2.zzd(16);
            zzgfl2.zzb(zzgfm);
            zzgfl2.zzf(zzgfn);
            hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzgfl2.zzg());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            Class<zzgfp> cls = zzgfp.class;
            zzgmc.zza().zzb(zzd, cls);
            zzgma.zzb().zzc(zze, cls);
            zzgky.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
