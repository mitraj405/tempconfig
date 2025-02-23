package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb;
    private static final zzglz zzc = new zzghe();
    private static final zzgdz zzd;

    static {
        Class<zzgdo> cls = zzgdo.class;
        zzb = zzgmx.zzb(new zzghd(), zzghc.class, cls);
        zzd = zzglh.zzd("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", cls, zzgsu.SYMMETRIC, zzgse.zzg());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            int i = zzgjx.zza;
            zzgjx.zze(zzgmk.zzc());
            zzgmh.zza().zze(zzb);
            zzgma.zzb().zzc(zzc, zzghh.class);
            zzgmg zzb2 = zzgmg.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("CHACHA20_POLY1305", zzghh.zzc(zzghg.zza));
            hashMap.put("CHACHA20_POLY1305_RAW", zzghh.zzc(zzghg.zzc));
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgky.zzc().zzd(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
    }
}
