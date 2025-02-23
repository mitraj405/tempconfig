package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgtv extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgtv zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgty zze;

    static {
        zzgtv zzgtv = new zzgtv();
        zza = zzgtv;
        zzgxy.zzcb(zzgtv.class, zzgtv);
    }

    private zzgtv() {
    }

    public static zzgtu zzc() {
        return (zzgtu) zza.zzaZ();
    }

    public static zzgtv zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgtv) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static zzgzr zzg() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzh(zzgtv zzgtv, zzgty zzgty) {
        zzgty.getClass();
        zzgtv.zze = zzgty;
        zzgtv.zzc |= 1;
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
                return new zzgtv();
            case 4:
                return new zzgtu((zzgtt) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgtv.class) {
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

    public final zzgty zzf() {
        zzgty zzgty = this.zze;
        if (zzgty == null) {
            return zzgty.zze();
        }
        return zzgty;
    }
}
