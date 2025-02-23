package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgqg {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgkw zzc;
    private static final zzgkw zzd;
    private static final zzgmt zze;
    private static final zzgmp zzf;
    private static final zzglg zzg;
    private static final zzglc zzh;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzb2;
        zzgku zza2 = zzgkw.zza();
        zza2.zza(zzgtz.RAW, zzgpe.zzd);
        zza2.zza(zzgtz.TINK, zzgpe.zza);
        zza2.zza(zzgtz.LEGACY, zzgpe.zzc);
        zza2.zza(zzgtz.CRUNCHY, zzgpe.zzb);
        zzc = zza2.zzb();
        zzgku zza3 = zzgkw.zza();
        zza3.zza(zzgsi.SHA1, zzgpd.zza);
        zza3.zza(zzgsi.SHA224, zzgpd.zzb);
        zza3.zza(zzgsi.SHA256, zzgpd.zzc);
        zza3.zza(zzgsi.SHA384, zzgpd.zzd);
        zza3.zza(zzgsi.SHA512, zzgpd.zze);
        zzd = zza3.zzb();
        Class<zzgnm> cls = zzgnm.class;
        zze = zzgmt.zzb(new zzgqc(), zzgpg.class, cls);
        zzf = zzgmp.zzb(new zzgqd(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zzg = zzglg.zzb(new zzgqe(), zzgov.class, cls2);
        zzh = zzglc.zzb(new zzgqf(), zzb2, cls2);
    }

    public static /* synthetic */ zzgnl zza(zzgov zzgov, zzger zzger) {
        zzgsk zzc2 = zzgsl.zzc();
        zzc2.zzb(zzf(zzgov.zzb()));
        byte[] zzd2 = zzgov.zzd().zzd(zzger);
        zzc2.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgsl) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, (zzgtz) zzc.zzb(zzgov.zzb().zzg()), zzgov.zze());
    }

    public static /* synthetic */ zzgnm zzb(zzgpg zzgpg) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgsn zzd2 = zzgso.zzd();
        zzd2.zzb(zzf(zzgpg));
        zzd2.zza(zzgpg.zzc());
        zza2.zzc(((zzgso) zzd2.zzbr()).zzaN());
        zza2.zza((zzgtz) zzc.zzb(zzgpg.zzg()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static /* synthetic */ zzgov zzc(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzgsl zzf2 = zzgsl.zzf(zzgnl.zze(), zzgxi.zza());
                if (zzf2.zza() == 0) {
                    zzgpc zze2 = zzgpg.zze();
                    zze2.zzb(zzf2.zzh().zzd());
                    zze2.zzc(zzf2.zzg().zza());
                    zze2.zza((zzgpd) zzd.zzc(zzf2.zzg().zzc()));
                    zze2.zzd((zzgpe) zzc.zzc(zzgnl.zzc()));
                    zzgpg zze3 = zze2.zze();
                    zzgot zza2 = zzgov.zza();
                    zza2.zzc(zze3);
                    zza2.zzb(zzgvs.zzb(zzf2.zzh().zzA(), zzger));
                    zza2.zza(zzgnl.zzf());
                    return zza2.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgpg zzd(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzgso zzg2 = zzgso.zzg(zzgnm.zzc().zzh(), zzgxi.zza());
                if (zzg2.zzc() == 0) {
                    zzgpc zze2 = zzgpg.zze();
                    zze2.zzb(zzg2.zza());
                    zze2.zzc(zzg2.zzh().zza());
                    zze2.zza((zzgpd) zzd.zzc(zzg2.zzh().zzc()));
                    zze2.zzd((zzgpe) zzc.zzc(zzgnm.zzc().zzg()));
                    return zze2.zze();
                }
                throw new GeneralSecurityException(lf.h("Parsing HmacParameters failed: unknown Version ", zzg2.zzc()));
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zze);
        zzgmk.zzh(zzf);
        zzgmk.zzg(zzg);
        zzgmk.zzf(zzh);
    }

    private static zzgsr zzf(zzgpg zzgpg) throws GeneralSecurityException {
        zzgsq zzd2 = zzgsr.zzd();
        zzd2.zzb(zzgpg.zzb());
        zzd2.zza((zzgsi) zzd.zzb(zzgpg.zzf()));
        return (zzgsr) zzd2.zzbr();
    }
}
