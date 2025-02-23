package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgko {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgkk(), zzgiw.class, cls);
        zzd = zzgmp.zzb(new zzgkl(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgkm(), zzgiq.class, cls2);
        zzf = zzglc.zzb(new zzgkn(), zzb2, cls2);
    }

    public static /* synthetic */ zzgiq zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzguf zze2 = zzguf.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    return zzgiq.zza(zzf(zzgnl.zzc()), zzgvs.zzb(zze2.zzf().zzA(), zzger), zzgnl.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgiw zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzgui.zze(zzgnm.zzc().zzh(), zzgxi.zza()).zza() == 0) {
                    return zzgiw.zzc(zzf(zzgnm.zzc().zzg()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzgiq zzgiq, zzger zzger) {
        zzgue zzc2 = zzguf.zzc();
        byte[] zzd2 = zzgiq.zzd().zzd(zzger);
        zzc2.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzguf) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzgiq.zzb().zzb()), zzgiq.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzgiw zzgiw) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzgui.zzd().zzaN());
        zza2.zza(zzg(zzgiw.zzb()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzgiv zzf(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzgiv.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgiv.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
            }
        }
        return zzgiv.zzb;
    }

    private static zzgtz zzg(zzgiv zzgiv) throws GeneralSecurityException {
        if (zzgiv.zza.equals(zzgiv)) {
            return zzgtz.TINK;
        }
        if (zzgiv.zzb.equals(zzgiv)) {
            return zzgtz.CRUNCHY;
        }
        if (zzgiv.zzc.equals(zzgiv)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgiv.toString()));
    }
}
