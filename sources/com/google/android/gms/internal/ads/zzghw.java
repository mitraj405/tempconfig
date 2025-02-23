package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzghw {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzghs(), zzghr.class, cls);
        zzd = zzgmp.zzb(new zzght(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzghu(), zzghp.class, cls2);
        zzf = zzglc.zzb(new zzghv(), zzb2, cls2);
    }

    public static /* synthetic */ zzghp zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzgtp zze2 = zzgtp.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    return zzghp.zza(zzghr.zzc(zze2.zzf().zzf(), zzf(zzgnl.zzc())), zzgnl.zzf());
                }
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got ".concat(String.valueOf(zze2)));
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzghr zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                return zzghr.zzc(zzgts.zze(zzgnm.zzc().zzh(), zzgxi.zza()).zzf(), zzf(zzgnm.zzc().zzg()));
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzghp zzghp, zzger zzger) {
        zzgto zzc2 = zzgtp.zzc();
        zzgtr zza2 = zzgts.zza();
        zza2.zza(zzghp.zzb().zzd());
        zzc2.zza((zzgts) zza2.zzbr());
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzgtp) zzc2.zzbr()).zzaN(), zzgsu.REMOTE, zzg(zzghp.zzb().zzb()), zzghp.zzd());
    }

    public static /* synthetic */ zzgnm zzd(zzghr zzghr) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzgtr zza3 = zzgts.zza();
        zza3.zza(zzghr.zzd());
        zza2.zzc(((zzgts) zza3.zzbr()).zzaN());
        zza2.zza(zzg(zzghr.zzb()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzghq zzf(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzghq.zza;
        }
        if (ordinal == 3) {
            return zzghq.zzb;
        }
        throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
    }

    private static zzgtz zzg(zzghq zzghq) throws GeneralSecurityException {
        if (zzghq.zza.equals(zzghq)) {
            return zzgtz.TINK;
        }
        if (zzghq.zzb.equals(zzghq)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzghq.toString()));
    }
}
