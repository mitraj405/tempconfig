package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgii {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvr zzb;
    private static final zzgmt zzc;
    private static final zzgmp zzd;
    private static final zzglg zze;
    private static final zzglc zzf;

    static {
        zzgvr zzb2 = zzgoa.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzb2;
        Class<zzgnm> cls = zzgnm.class;
        zzc = zzgmt.zzb(new zzgie(), zzgid.class, cls);
        zzd = zzgmp.zzb(new zzgif(), zzb2, cls);
        Class<zzgnl> cls2 = zzgnl.class;
        zze = zzglg.zzb(new zzgig(), zzghx.class, cls2);
        zzf = zzglc.zzb(new zzgih(), zzb2, cls2);
    }

    public static /* synthetic */ zzghx zza(zzgnl zzgnl, zzger zzger) {
        if (zzgnl.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                zzgtv zze2 = zzgtv.zze(zzgnl.zze(), zzgxi.zza());
                if (zze2.zza() == 0) {
                    return zzghx.zza(zzf(zze2.zzf(), zzgnl.zzc()), zzgnl.zzf());
                }
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got ".concat(String.valueOf(zze2)));
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzgid zzb(zzgnm zzgnm) {
        if (zzgnm.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return zzf(zzgty.zzf(zzgnm.zzc().zzh(), zzgxi.zza()), zzgnm.zzc().zzg());
            } catch (zzgyn e) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgnm.zzc().zzi())));
        }
    }

    public static /* synthetic */ zzgnl zzc(zzghx zzghx, zzger zzger) {
        zzgtu zzc2 = zzgtv.zzc();
        zzc2.zza(zzg(zzghx.zzb()));
        return zzgnl.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgtv) zzc2.zzbr()).zzaN(), zzgsu.REMOTE, zzh(zzghx.zzb().zzc()), zzghx.zzd());
    }

    public static /* synthetic */ zzgnm zzd(zzgid zzgid) {
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zza2.zzc(zzg(zzgid).zzaN());
        zza2.zza(zzh(zzgid.zzc()));
        return zzgnm.zzb((zzgsz) zza2.zzbr());
    }

    public static void zze(zzgmk zzgmk) throws GeneralSecurityException {
        zzgmk.zzi(zzc);
        zzgmk.zzh(zzd);
        zzgmk.zzg(zze);
        zzgmk.zzf(zzf);
    }

    private static zzgid zzf(zzgty zzgty, zzgtz zzgtz) throws GeneralSecurityException {
        zzgia zzgia;
        zzgib zzgib;
        zzgsy zza2 = zzgsz.zza();
        zza2.zzb(zzgty.zza().zzi());
        zza2.zzc(zzgty.zza().zzh());
        zza2.zza(zzgtz.RAW);
        zzgen zza3 = zzget.zza(((zzgsz) zza2.zzbr()).zzaV());
        if (zza3 instanceof zzggo) {
            zzgia = zzgia.zza;
        } else if (zza3 instanceof zzghh) {
            zzgia = zzgia.zzc;
        } else if (zza3 instanceof zzgiw) {
            zzgia = zzgia.zzb;
        } else if (zza3 instanceof zzgfp) {
            zzgia = zzgia.zzd;
        } else if (zza3 instanceof zzggb) {
            zzgia = zzgia.zze;
        } else if (zza3 instanceof zzghb) {
            zzgia = zzgia.zzf;
        } else {
            throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zza3.toString()));
        }
        zzghz zzghz = new zzghz((zzghy) null);
        int ordinal = zzgtz.ordinal();
        if (ordinal == 1) {
            zzgib = zzgib.zza;
        } else if (ordinal == 3) {
            zzgib = zzgib.zzb;
        } else {
            throw new GeneralSecurityException(lf.h("Unable to parse OutputPrefixType: ", zzgtz.zza()));
        }
        zzghz.zzd(zzgib);
        zzghz.zzc(zzgty.zzg());
        zzghz.zza((zzgex) zza3);
        zzghz.zzb(zzgia);
        return zzghz.zze();
    }

    private static zzgty zzg(zzgid zzgid) throws GeneralSecurityException {
        try {
            zzgsz zzf2 = zzgsz.zzf(zzget.zzb(zzgid.zzb()), zzgxi.zza());
            zzgtx zzc2 = zzgty.zzc();
            zzc2.zzb(zzgid.zzd());
            zzc2.zza(zzf2);
            return (zzgty) zzc2.zzbr();
        } catch (zzgyn e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzgtz zzh(zzgib zzgib) throws GeneralSecurityException {
        if (zzgib.zza.equals(zzgib)) {
            return zzgtz.TINK;
        }
        if (zzgib.zzb.equals(zzgib)) {
            return zzgtz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgib)));
    }
}
