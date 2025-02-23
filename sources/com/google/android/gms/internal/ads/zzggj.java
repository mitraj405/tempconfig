package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggj {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb;
    private static final zzgdz zzc;
    private static final zzgmb zzd = new zzggh();
    private static final zzglz zze = new zzggi();
    private static final int zzf = 2;

    static {
        Class<zzgdo> cls = zzgdo.class;
        zzb = zzgmx.zzb(new zzggg(), zzggf.class, cls);
        zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesGcmKey", cls, zzgsu.SYMMETRIC, zzgrs.zzg());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgkr.zza(i)) {
            int i2 = zzgjl.zza;
            zzgjl.zze(zzgmk.zzc());
            zzgmh.zza().zze(zzb);
            zzgmg zzb2 = zzgmg.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_GCM", zzgip.zza);
            zzggl zzggl = new zzggl((zzggk) null);
            zzggl.zza(12);
            zzggl.zzb(16);
            zzggl.zzc(16);
            zzggm zzggm = zzggm.zzc;
            zzggl.zzd(zzggm);
            hashMap.put("AES128_GCM_RAW", zzggl.zze());
            hashMap.put("AES256_GCM", zzgip.zzb);
            zzggl zzggl2 = new zzggl((zzggk) null);
            zzggl2.zza(12);
            zzggl2.zzb(32);
            zzggl2.zzc(16);
            zzggl2.zzd(zzggm);
            hashMap.put("AES256_GCM_RAW", zzggl2.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            Class<zzggo> cls = zzggo.class;
            zzgmc.zza().zzb(zzd, cls);
            zzgma.zzb().zzc(zze, cls);
            zzgky.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }
}
