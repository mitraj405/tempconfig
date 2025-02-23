package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgoi {
    private static final zzglz zza = new zzgof();
    private static final zzgmx zzb;
    private static final zzgmx zzc;
    private static final zzgdz zzd;

    static {
        Class<zzgoe> cls = zzgoe.class;
        zzb = zzgmx.zzb(new zzgog(), cls, zzgoo.class);
        Class<zzgem> cls2 = zzgem.class;
        zzc = zzgmx.zzb(new zzgoh(), cls, cls2);
        zzd = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesCmacKey", cls2, zzgsu.SYMMETRIC, zzgql.zzh());
    }

    public static /* synthetic */ zzgoe zzb(zzgon zzgon, Integer num) {
        zze(zzgon);
        zzgoc zzgoc = new zzgoc((zzgob) null);
        zzgoc.zzc(zzgon);
        zzgoc.zza(zzgvs.zzc(zzgon.zzc()));
        zzgoc.zzb(num);
        return zzgoc.zzd();
    }

    public static void zzd(boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            int i = zzgpy.zza;
            zzgpy.zze(zzgmk.zzc());
            zzgma.zzb().zzc(zza, zzgon.class);
            zzgmh.zza().zze(zzb);
            zzgmh.zza().zze(zzc);
            zzgmg zzb2 = zzgmg.zzb();
            HashMap hashMap = new HashMap();
            zzgon zzgon = zzgpt.zzc;
            hashMap.put("AES_CMAC", zzgon);
            hashMap.put("AES256_CMAC", zzgon);
            zzgok zzgok = new zzgok((zzgoj) null);
            zzgok.zza(32);
            zzgok.zzb(16);
            zzgok.zzc(zzgol.zzd);
            hashMap.put("AES256_CMAC_RAW", zzgok.zzd());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgky.zzc().zzd(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
    }

    /* access modifiers changed from: private */
    public static void zze(zzgon zzgon) throws GeneralSecurityException {
        if (zzgon.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
