package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgiu {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb;
    private static final zzgdz zzc;
    private static final zzgmb zzd = new zzgis();
    private static final zzglz zze = new zzgit();

    static {
        Class<zzgdo> cls = zzgdo.class;
        zzb = zzgmx.zzb(new zzgir(), zzgiq.class, cls);
        zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", cls, zzgsu.SYMMETRIC, zzguf.zzg());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            int i = zzgko.zza;
            zzgko.zze(zzgmk.zzc());
            zzgmh.zza().zze(zzb);
            zzgmg zzb2 = zzgmg.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("XCHACHA20_POLY1305", zzgiw.zzc(zzgiv.zza));
            hashMap.put("XCHACHA20_POLY1305_RAW", zzgiw.zzc(zzgiv.zzc));
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            Class<zzgiw> cls = zzgiw.class;
            zzgma.zzb().zzc(zze, cls);
            zzgmc.zza().zzb(zzd, cls);
            zzgky.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
    }
}
