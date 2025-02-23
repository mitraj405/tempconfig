package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmx zzb;
    private static final zzgdz zzc;
    private static final zzglz zzd = new zzghj();

    static {
        Class<zzgdo> cls = zzgdo.class;
        zzb = zzgmx.zzb(new zzghi(), zzghp.class, cls);
        zzc = zzglh.zzd("type.googleapis.com/google.crypto.tink.KmsAeadKey", cls, zzgsu.REMOTE, zzgtp.zzg());
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            int i = zzghw.zza;
            zzghw.zze(zzgmk.zzc());
            zzgmh.zza().zze(zzb);
            zzgma.zzb().zzc(zzd, zzghr.class);
            zzgky.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
    }
}
