package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgso extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgso zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgsr zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzgso zzgso = new zzgso();
        zza = zzgso;
        zzgxy.zzcb(zzgso.class, zzgso);
    }

    private zzgso() {
    }

    public static zzgsn zzd() {
        return (zzgsn) zza.zzaZ();
    }

    public static zzgso zzf() {
        return zza;
    }

    public static zzgso zzg(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgso) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static /* synthetic */ void zzi(zzgso zzgso, zzgsr zzgsr) {
        zzgsr.getClass();
        zzgso.zzd = zzgsr;
        zzgso.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzf;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgso();
            case 4:
                return new zzgsn((zzgsm) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgso.class) {
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

    public final zzgsr zzh() {
        zzgsr zzgsr = this.zzd;
        if (zzgsr == null) {
            return zzgsr.zzf();
        }
        return zzgsr;
    }
}
