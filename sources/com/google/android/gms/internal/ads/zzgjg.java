package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgjg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgjc(), zzggb.class, cls);
        zzd = zzgmp.zzb(new zzgjd(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgje(), zzgft.class, cls2);
        zzf = zzglc.zzb(new zzgjf(), zzb2, cls2);
    }

    public static /* synthetic */ zzgft zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgrj zze2 = zzgrj.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    zzgfy zzd2 = zzggb.zzd();
                    zzd2.zzb(zze2.zzg().zzd());
                    zzd2.zza(zze2.zzf().zza());
                    zzd2.zzc(16);
                    zzd2.zzd(zzf(zzgnl.zzc()));
                    zzggb zze3 = zzd2.zze();
                    zzgfr zza2 = zzgft.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzgvs.zzb(zze2.zzg().zzA(), zzger));
                    zza2.zza(zzgnl.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzggb zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzgrm zze2 = zzgrm.zze(zzgnm.zzc().zzh(), zzgxi.zza());
                zzgfy zzd2 = zzggb.zzd();
                zzd2.zzb(zze2.zza());
                zzd2.zza(zze2.zzf().zza());
                zzd2.zzc(16);
                zzd2.zzd(zzf(zzgnm.zzc().zzg()));
                return zzd2.zze();
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgft zzgft, zzger zzger) {
        zzgri zzc2 = zzgrj.zzc();
        zzc2.zzb(zzg(zzgft.zzb()));
        byte[] zzd2 = zzgft.zzd().zzd(zzger);
        zzc2.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgrj) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzh(zzgft.zzb().zze()), zzgft.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzggb zzggb) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgrl zzc2 = zzgrm.zzc();
        zzc2.zzb(zzg(zzggb));
        zzc2.zza(zzggb.zzc());
        zza2.zzc(((zzgrm) zzc2.zzbr()).zzaN());
        zza2.zza(zzh(zzggb.zze()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzgfz zzf(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzgfz.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgfz.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
            }
        }
        return zzgfz.zzb;
    }

    private static zzgrp zzg(zzggb zzggb) throws GeneralSecurityException {
        zzgro zzc2 = zzgrp.zzc();
        zzc2.zza(zzggb.zzb());
        return (zzgrp) zzc2.zzbr();
    }

    private static zzgtz zzh(zzgfz zzgfz) throws GeneralSecurityException {
        if (zzgfz.zza.equals(zzgfz)) {
            return zzgtz.TINK;
        }
        if (zzgfz.zzb.equals(zzgfz)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgfz.zzc.equals(zzgfz)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgfz)));
    }
}
