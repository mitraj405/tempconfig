package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgqx extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgqx zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgrd zzd;
    private zzgso zze;

    static {
        zzgqx zzgqx = new zzgqx();
        zza = zzgqx;
        zzgxy.zzcb(zzgqx.class, zzgqx);
    }

    private zzgqx() {
    }

    public static zzgqw zza() {
        return (zzgqw) zza.zzaZ();
    }

    public static zzgqx zzd(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgqx) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static /* synthetic */ void zzg(zzgqx zzgqx, zzgrd zzgrd) {
        zzgrd.getClass();
        zzgqx.zzd = zzgrd;
        zzgqx.zzc |= 1;
    }

    public static /* synthetic */ void zzh(zzgqx zzgqx, zzgso zzgso) {
        zzgso.getClass();
        zzgqx.zze = zzgso;
        zzgqx.zzc |= 2;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgqx();
            case 4:
                return new zzgqw((zzgqv) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgqx.class) {
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

    public final zzgrd zze() {
        zzgrd zzgrd = this.zzd;
        if (zzgrd == null) {
            return zzgrd.zze();
        }
        return zzgrd;
    }

    public final zzgso zzf() {
        zzgso zzgso = this.zze;
        if (zzgso == null) {
            return zzgso.zzf();
        }
        return zzgso;
    }
}
