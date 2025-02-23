package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgjx {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgjt(), zzghh.class, cls);
        zzd = zzgmp.zzb(new zzgju(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgjv(), zzghc.class, cls2);
        zzf = zzglc.zzb(new zzgjw(), zzb2, cls2);
    }

    public static /* synthetic */ zzghc zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgse zze2 = zzgse.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    return zzghc.zza(zzf(zzgnl.zzc()), zzgvs.zzb(zze2.zzf().zzA(), zzger), zzgnl.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgyn unused) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzghh zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            try {
                zzgsh.zzd(zzgnm.zzc().zzh(), zzgxi.zza());
                return zzghh.zzc(zzf(zzgnm.zzc().zzg()));
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzghc zzghc, zzger zzger) {
        zzgsd zzc2 = zzgse.zzc();
        byte[] zzd2 = zzghc.zzd().zzd(zzger);
        zzc2.zza(zzgwm.zzv(zzd2, 0, zzd2.length));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzgse) zzc2.zzbr()).zzaN(), zzgsu.SYMMETRIC, zzg(zzghc.zzb().zzb()), zzghc.zze());
    }

    public static /* synthetic */ zzgnm zzd(zzghh zzghh) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzgsh.zzc().zzaN());
        zza2.zza(zzg(zzghh.zzb()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzghg zzf(zzgtz zzgtz) throws GeneralSecurityException {
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            return zzghg.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzghg.zzc;
            }
            if (ordinal != 4) {
                throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
            }
        }
        return zzghg.zzb;
    }

    private static zzgtz zzg(zzghg zzghg) throws GeneralSecurityException {
        if (zzghg.zza.equals(zzghg)) {
            return zzgtz.TINK;
        }
        if (zzghg.zzb.equals(zzghg)) {
            return zzgtz.CRUNCHY;
        }
        if (zzghg.zzc.equals(zzghg)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzghg.toString()));
    }
}
