package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgtp extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgtp zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgts zze;

    static {
        zzgtp zzgtp = new zzgtp();
        zza = zzgtp;
        zzgxy.zzcb(zzgtp.class, zzgtp);
    }

    private zzgtp() {
    }

    public static zzgto zzc() {
        return (zzgto) zza.zzaZ();
    }

    public static zzgtp zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgtp) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static zzgzr zzg() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzh(zzgtp zzgtp, zzgts zzgts) {
        zzgts.getClass();
        zzgtp.zze = zzgts;
        zzgtp.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgtp();
            case 4:
                return new zzgto((zzgtn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgtp.class) {
                        zzgzr = zzb;
                        if (zzgzr == null) {
                            zzgzr = new zzgxt(zza);
                            zzb = zzgzr;
                        }
                    }
                }
                return zzgzr;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzgts zzf() {
        zzgts zzgts = this.zze;
        if (zzgts == null) {
            return zzgts.zzd();
        }
        return zzgts;
    }
}
