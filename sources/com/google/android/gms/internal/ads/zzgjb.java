package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgjb {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgix(), zzgfp.class, cls);
        zzd = zzgmp.zzb(new zzgiy(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgiz(), zzgff.class, cls2);
        zzf = zzglc.zzb(new zzgja(), zzb2, cls2);
    }

    public static /* synthetic */ zzgff zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgqu zze2 = zzgqu.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zze2.zzf().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zze2.zzg().zza() == 0) {
                    zzgfl zzf2 = zzgfp.zzf();
                    zzf2.zza(zze2.zzf().zzg().zzd());
                    zzf2.zzc(zze2.zzg().zzh().zzd());
                    zzf2.zzd(zze2.zzf().zzf().zza());
                    zzf2.zze(zze2.zzg().zzg().zza());
                    zzf2.zzb(zzf(zze2.zzg().zzg().zzc()));
                    zzf2.zzf(zzg(zzgnl.zzc()));
                    zzgfp zzg = zzf2.zzg();
                    zzgfd zza2 = zzgff.zza();
                    zza2.zzd(zzg);
                    zza2.zza(zzgvs.zzb(zze2.zzf().zzg().zzA(), zzger));
                    zza2.zzb(zzgvs.zzb(zze2.zzg().zzh().zzA(), zzger));
                    zza2.zzc(zzgnl.zzf());
                    return zza2.zze();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzgyn unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgfp zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzgqx zzd2 = zzgqx.zzd(zzgnm.zzc().zzh(), zzgxi.zza());
                if (zzd2.zzf().zzc() == 0) {
                    zzgfl zzf2 = zzgfp.zzf();
                    zzf2.zza(zzd2.zze().zza());
                    zzf2.zzc(zzd2.zzf().zza());
                    zzf2.zzd(zzd2.zze().zzf().zza());
                    zzf2.zze(zzd2.zzf().zzh().zza());
                    zzf2.zzb(zzf(zzd2.zzf().zzh().zzc()));
                    zzf2.zzf(zzg(zzgnm.zzc().zzg()));
                    return zzf2.zzg();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgff zzgff, zzger zzger) {
        zzgqt zzc2 = zzgqu.zzc();
        zzgqz zzc3 = zzgra.zzc();
        zzgrf zzc4 = zzgrg.zzc();
        zzc4.zza(zzgff.zzb().zzd());
        zzc3.zzb((zzgrg) zzc4.zzbr());
        byte[] zzd2 = zzgff.zzd().zzd(zzger);
        zzc3.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        zzc2.zza((zzgra) zzc3.zzbr());
        zzgsk zzc5 = zzgsl.zzc();
        zzc5.zzb(zzh(zzgff.zzb()));
        byte[] zzd3 = zzgff.zze().zzd(zzger);
        zzc5.zza(zzgwm.zzv(zzd3, 0, zzd3.length));
        zzc2.zzb((zzgsl) zzc5.zzbr());
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgqu) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzi(zzgff.zzb().zzh()), zzgff.zzf());
    }

    public static /* synthetic */ zzgnm zzd(zzgfp zzgfp) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgqw zza3 = zzgqx.zza();
        zzgrc zzc2 = zzgrd.zzc();
        zzgrf zzc3 = zzgrg.zzc();
        zzc3.zza(zzgfp.zzd());
        zzc2.zzb((zzgrg) zzc3.zzbr());
        zzc2.zza(zzgfp.zzb());
        zza3.zza((zzgrd) zzc2.zzbr());
        zzgsn zzd2 = zzgso.zzd();
        zzd2.zzb(zzh(zzgfp));
        zzd2.zza(zzgfp.zzc());
        zza3.zzb((zzgso) zzd2.zzbr());
        zza2.zzc(((zzgqx) zza3.zzbr()).zzaN());
        zza2.zza(zzi(zzgfp.zzh()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzgfm zzf(zzgsi zzgsi) throws GeneralSecurityException {
        int ordinal = zzgsi.ordinal();
        if (ordinal == 1) {
            return zzgfm.zza;
        }
        if (ordinal == 2) {
            return zzgfm.zzd;
        }
        if (ordinal == 3) {
            return zzgfm.zzc;
        }
        if (ordinal == 4) {
            return zzgfm.zze;
        }
        if (ordinal == 5) {
            return zzgfm.zzb;
        }
        throw new GeneralSecurityException(lf.h("Unable to parse HashType: ", zzgsi.zza()));
    }

    private static zzgfn zzg(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzgfn.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgfn.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
            }
        }
        return zzgfn.zzb;
    }

    private static zzgsr zzh(zzgfp zzgfp) throws GeneralSecurityException {
        zzgsi zzgsi;
        zzgsq zzd2 = zzgsr.zzd();
        zzd2.zzb(zzgfp.zze());
        zzgfm zzg = zzgfp.zzg();
        if (zzgfm.zza.equals(zzg)) {
            zzgsi = zzgsi.SHA1;
        } else if (zzgfm.zzb.equals(zzg)) {
            zzgsi = zzgsi.SHA224;
        } else if (zzgfm.zzc.equals(zzg)) {
            zzgsi = zzgsi.SHA256;
        } else if (zzgfm.zzd.equals(zzg)) {
            zzgsi = zzgsi.SHA384;
        } else if (zzgfm.zze.equals(zzg)) {
            zzgsi = zzgsi.SHA512;
        } else {
            throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzg)));
        }
        zzd2.zza(zzgsi);
        return (zzgsr) zzd2.zzbr();
    }

    private static zzgtz zzi(zzgfn zzgfn) throws GeneralSecurityException {
        if (zzgfn.zza.equals(zzgfn)) {
            return zzgtz.TINK;
        }
        if (zzgfn.zzb.equals(zzgfn)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgfn.zzc.equals(zzgfn)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgfn)));
    }
}
