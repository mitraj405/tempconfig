package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgho {
    public static final /* synthetic */ int zza = 0;
    private static final zzgdz zzb;
    private static final zzglz zzc = new zzghm();
    private static final zzgmx zzd;

    static {
        Class<zzgdo> cls = zzgdo.class;
        zzb = zzglh.zzd("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", cls, zzgsu.SYMMETRIC, zzgtv.zzg());
        zzd = zzgmx.zzb(new zzghn(), zzghx.class, cls);
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            int i = zzgii.zza;
            zzgii.zze(zzgmk.zzc());
            zzgma.zzb().zzc(zzc, zzgid.class);
            zzgmh.zza().zze(zzd);
            zzgky.zzc().zzd(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
    }
}
