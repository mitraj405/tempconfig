package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgfw {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb;
    private static final zzgdz zzc;
    private static final zzglz zzd = new zzgfv();

    static {
        Class<zzgdo> cls = zzgdo.class;
        zzb = zzgmx.zzb(new zzgfu(), zzgft.class, cls);
        zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.AesEaxKey", cls, zzgsu.SYMMETRIC, zzgrj.zzh());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            int i = zzgjg.zza;
            zzgjg.zze(zzgmk.zzc());
            zzgmh.zza().zze(zzb);
            zzgmg zzb2 = zzgmg.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_EAX", zzgip.zzc);
            zzgfy zzgfy = new zzgfy((zzgfx) null);
            zzgfy.zza(16);
            zzgfy.zzb(16);
            zzgfy.zzc(16);
            zzgfz zzgfz = zzgfz.zzc;
            zzgfy.zzd(zzgfz);
            hashMap.put("AES128_EAX_RAW", zzgfy.zze());
            hashMap.put("AES256_EAX", zzgip.zzd);
            zzgfy zzgfy2 = new zzgfy((zzgfx) null);
            zzgfy2.zza(16);
            zzgfy2.zzb(32);
            zzgfy2.zzc(16);
            zzgfy2.zzd(zzgfz);
            hashMap.put("AES256_EAX_RAW", zzgfy2.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgma.zzb().zzc(zzd, zzggb.class);
            zzgky.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
    }
}
