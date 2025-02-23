package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgpa {
    private static final zzgmx zza;
    private static final zzgmx zzb;
    private static final zzgdz zzc;
    private static final zzgmb zzd = new zzgoy();
    private static final zzglz zze = new zzgoz();
    private static final int zzf = 2;

    static {
        Class<zzgov> cls = zzgov.class;
        zza = zzgmx.zzb(new zzgow(), cls, zzgoo.class);
        Class<zzgem> cls2 = zzgem.class;
        zzb = zzgmx.zzb(new zzgox(), cls, cls2);
        zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.HmacKey", cls2, zzgsu.SYMMETRIC, zzgsl.zzi());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgkr.zza(i)) {
            int i2 = zzgqg.zza;
            zzgqg.zze(zzgmk.zzc());
            zzgmh.zza().zze(zza);
            zzgmh.zza().zze(zzb);
            zzgmg zzb2 = zzgmg.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("HMAC_SHA256_128BITTAG", zzgpt.zza);
            zzgpc zzgpc = new zzgpc((zzgpb) null);
            zzgpc.zzb(32);
            zzgpc.zzc(16);
            zzgpe zzgpe = zzgpe.zzd;
            zzgpc.zzd(zzgpe);
            zzgpd zzgpd = zzgpd.zzc;
            zzgpc.zza(zzgpd);
            hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzgpc.zze());
            zzgpc zzgpc2 = new zzgpc((zzgpb) null);
            zzgpc2.zzb(32);
            zzgpc2.zzc(32);
            zzgpe zzgpe2 = zzgpe.zza;
            zzgpc2.zzd(zzgpe2);
            zzgpc2.zza(zzgpd);
            hashMap.put("HMAC_SHA256_256BITTAG", zzgpc2.zze());
            zzgpc zzgpc3 = new zzgpc((zzgpb) null);
            zzgpc3.zzb(32);
            zzgpc3.zzc(32);
            zzgpc3.zzd(zzgpe);
            zzgpc3.zza(zzgpd);
            hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzgpc3.zze());
            zzgpc zzgpc4 = new zzgpc((zzgpb) null);
            zzgpc4.zzb(64);
            zzgpc4.zzc(16);
            zzgpc4.zzd(zzgpe2);
            zzgpd zzgpd2 = zzgpd.zze;
            zzgpc4.zza(zzgpd2);
            hashMap.put("HMAC_SHA512_128BITTAG", zzgpc4.zze());
            zzgpc zzgpc5 = new zzgpc((zzgpb) null);
            zzgpc5.zzb(64);
            zzgpc5.zzc(16);
            zzgpc5.zzd(zzgpe);
            zzgpc5.zza(zzgpd2);
            hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzgpc5.zze());
            zzgpc zzgpc6 = new zzgpc((zzgpb) null);
            zzgpc6.zzb(64);
            zzgpc6.zzc(32);
            zzgpc6.zzd(zzgpe2);
            zzgpc6.zza(zzgpd2);
            hashMap.put("HMAC_SHA512_256BITTAG", zzgpc6.zze());
            zzgpc zzgpc7 = new zzgpc((zzgpb) null);
            zzgpc7.zzb(64);
            zzgpc7.zzc(32);
            zzgpc7.zzd(zzgpe);
            zzgpc7.zza(zzgpd2);
            hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzgpc7.zze());
            hashMap.put("HMAC_SHA512_512BITTAG", zzgpt.zzb);
            zzgpc zzgpc8 = new zzgpc((zzgpb) null);
            zzgpc8.zzb(64);
            zzgpc8.zzc(64);
            zzgpc8.zzd(zzgpe);
            zzgpc8.zza(zzgpd2);
            hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzgpc8.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            Class<zzgpg> cls = zzgpg.class;
            zzgma.zzb().zzc(zze, cls);
            zzgmc.zza().zzb(zzd, cls);
            zzgky.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
