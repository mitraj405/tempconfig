package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgjq {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgjm(), zzghb.class, cls);
        zzd = zzgmp.zzb(new zzgjn(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgjo(), zzggs.class, cls2);
        zzf = zzglc.zzb(new zzgjp(), zzb2, cls2);
    }

    public static /* synthetic */ zzggs zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgry zze2 = zzgry.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    zzggy zzc2 = zzghb.zzc();
                    zzc2.zza(zze2.zzf().zzd());
                    zzc2.zzb(zzf(zzgnl.zzc()));
                    zzghb zzc3 = zzc2.zzc();
                    zzggq zza2 = zzggs.zza();
                    zza2.zzc(zzc3);
                    zza2.zzb(zzgvs.zzb(zze2.zzf().zzA(), zzger));
                    zza2.zza(zzgnl.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzghb zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzgsb zzf2 = zzgsb.zzf(zzgnm.zzc().zzh(), zzgxi.zza());
                if (zzf2.zzc() == 0) {
                    zzggy zzc2 = zzghb.zzc();
                    zzc2.zza(zzf2.zza());
                    zzc2.zzb(zzf(zzgnm.zzc().zzg()));
                    return zzc2.zzc();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzggs zzggs, zzger zzger) {
        zzgrx zzc2 = zzgry.zzc();
        byte[] zzd2 = zzggs.zzd().zzd(zzger);
        zzc2.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgry) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzggs.zzb().zzd()), zzggs.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzghb zzghb) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgsa zzd2 = zzgsb.zzd();
        zzd2.zza(zzghb.zzb());
        zza2.zzc(((zzgsb) zzd2.zzbr()).zzaN());
        zza2.zza(zzg(zzghb.zzd()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzggz zzf(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzggz.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzggz.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
            }
        }
        return zzggz.zzb;
    }

    private static zzgtz zzg(zzggz zzggz) throws GeneralSecurityException {
        if (zzggz.zza.equals(zzggz)) {
            return zzgtz.TINK;
        }
        if (zzggz.zzb.equals(zzggz)) {
            return zzgtz.CRUNCHY;
        }
        if (zzggz.zzc.equals(zzggz)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzggz)));
    }
}
