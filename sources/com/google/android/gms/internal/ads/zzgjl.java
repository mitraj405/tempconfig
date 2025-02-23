package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgjl {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgjh(), zzggo.class, cls);
        zzd = zzgmp.zzb(new zzgji(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgjj(), zzggf.class, cls2);
        zzf = zzglc.zzb(new zzgjk(), zzb2, cls2);
    }

    public static /* synthetic */ zzggf zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgrs zze2 = zzgrs.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    zzggl zzc2 = zzggo.zzc();
                    zzc2.zzb(zze2.zzf().zzd());
                    zzc2.zza(12);
                    zzc2.zzc(16);
                    zzc2.zzd(zzf(zzgnl.zzc()));
                    zzggo zze3 = zzc2.zze();
                    zzggd zza2 = zzggf.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzgvs.zzb(zze2.zzf().zzA(), zzger));
                    zza2.zza(zzgnl.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzggo zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzgrv zzf2 = zzgrv.zzf(zzgnm.zzc().zzh(), zzgxi.zza());
                if (zzf2.zzc() == 0) {
                    zzggl zzc2 = zzggo.zzc();
                    zzc2.zzb(zzf2.zza());
                    zzc2.zza(12);
                    zzc2.zzc(16);
                    zzc2.zzd(zzf(zzgnm.zzc().zzg()));
                    return zzc2.zze();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzggf zzggf, zzger zzger) {
        zzgrr zzc2 = zzgrs.zzc();
        byte[] zzd2 = zzggf.zzd().zzd(zzger);
        zzc2.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgrs) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzggf.zzb().zzd()), zzggf.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzggo zzggo) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgru zzd2 = zzgrv.zzd();
        zzd2.zza(zzggo.zzb());
        zza2.zzc(((zzgrv) zzd2.zzbr()).zzaN());
        zza2.zza(zzg(zzggo.zzd()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzggm zzf(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzggm.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzggm.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
            }
        }
        return zzggm.zzb;
    }

    private static zzgtz zzg(zzggm zzggm) throws GeneralSecurityException {
        if (zzggm.zza.equals(zzggm)) {
            return zzgtz.TINK;
        }
        if (zzggm.zzb.equals(zzggm)) {
            return zzgtz.CRUNCHY;
        }
        if (zzggm.zzc.equals(zzggm)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzggm)));
    }
}
