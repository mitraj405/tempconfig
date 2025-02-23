package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgpy {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgpu(), zzgon.class, cls);
        zzd = zzgmp.zzb(new zzgpv(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgpw(), zzgoe.class, cls2);
        zzf = zzglc.zzb(new zzgpx(), zzb2, cls2);
    }

    public static /* synthetic */ zzgnl zza(zzgoe zzgoe, zzger zzger) {
        zzgqk zzc2 = zzgql.zzc();
        zzc2.zzb(zzg(zzgoe.zzb()));
        byte[] zzd2 = zzgoe.zzd().zzd(zzger);
        zzc2.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgql) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzh(zzgoe.zzb().zzf()), zzgoe.zze());
    }

    public static /* synthetic */ zzgnm zzb(zzgon zzgon) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgqn zzc2 = zzgqo.zzc();
        zzc2.zzb(zzg(zzgon));
        zzc2.zza(zzgon.zzc());
        zza2.zzc(((zzgqo) zzc2.zzbr()).zzaN());
        zza2.zza(zzh(zzgon.zzf()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static /* synthetic */ zzgoe zzc(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgql zze2 = zzgql.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    zzgok zze3 = zzgon.zze();
                    zze3.zza(zze2.zzg().zzd());
                    zze3.zzb(zze2.zzf().zza());
                    zze3.zzc(zzf(zzgnl.zzc()));
                    zzgon zzd2 = zze3.zzd();
                    zzgoc zza2 = zzgoe.zza();
                    zza2.zzc(zzd2);
                    zza2.zza(zzgvs.zzb(zze2.zzg().zzA(), zzger));
                    zza2.zzb(zzgnl.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgon zzd(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgqo zze2 = zzgqo.zze(zzgnm.zzc().zzh(), zzgxi.zza());
                zzgok zze3 = zzgon.zze();
                zze3.zza(zze2.zza());
                zze3.zzb(zze2.zzf().zza());
                zze3.zzc(zzf(zzgnm.zzc().zzg()));
                return zze3.zzd();
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzgol zzf(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzgol.zza;
        }
        if (ordinal == 2) {
            return zzgol.zzc;
        }
        if (ordinal == 3) {
            return zzgol.zzd;
        }
        if (ordinal == 4) {
            return zzgol.zzb;
        }
        throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
    }

    private static zzgqr zzg(zzgon zzgon) {
        zzgqq zzc2 = zzgqr.zzc();
        zzc2.zza(zzgon.zzb());
        return (zzgqr) zzc2.zzbr();
    }

    private static zzgtz zzh(zzgol zzgol) throws GeneralSecurityException {
        if (zzgol.zza.equals(zzgol)) {
            return zzgtz.TINK;
        }
        if (zzgol.zzb.equals(zzgol)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgol.zzd.equals(zzgol)) {
            return zzgtz.RAW;
        }
        if (zzgol.zzc.equals(zzgol)) {
            return zzgtz.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgol)));
    }
}
