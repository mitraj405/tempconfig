package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgqu extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgqu zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgra zze;
    private zzgsl zzf;

    static {
        zzgqu zzgqu = new zzgqu();
        zza = zzgqu;
        zzgxy.zzcb(zzgqu.class, zzgqu);
    }

    private zzgqu() {
    }

    public static zzgqt zzc() {
        return (zzgqt) zza.zzaZ();
    }

    public static zzgqu zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgqu) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzi(zzgqu zzgqu, zzgra zzgra) {
        zzgra.getClass();
        zzgqu.zze = zzgra;
        zzgqu.zzc |= 1;
    }

    public static /* synthetic */ void zzj(zzgqu zzgqu, zzgsl zzgsl) {
        zzgsl.getClass();
        zzgqu.zzf = zzgsl;
        zzgqu.zzc |= 2;
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
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgqu();
            case 4:
                return new zzgqt((zzgqs) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgqu.class) {
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

    public final zzgra zzf() {
        zzgra zzgra = this.zze;
        if (zzgra == null) {
            return zzgra.zze();
        }
        return zzgra;
    }

    public final zzgsl zzg() {
        zzgsl zzgsl = this.zzf;
        if (zzgsl == null) {
            return zzgsl.zze();
        }
        return zzgsl;
    }
}
