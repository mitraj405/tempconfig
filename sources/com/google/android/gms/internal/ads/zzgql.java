package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgql extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgql zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    /* access modifiers changed from: private */
    public zzgwm zze = zzgwm.zzb;
    private zzgqr zzf;

    static {
        zzgql zzgql = new zzgql();
        zza = zzgql;
        zzgxy.zzcb(zzgql.class, zzgql);
    }

    private zzgql() {
    }

    public static zzgqk zzc() {
        return (zzgqk) zza.zzaZ();
    }

    public static zzgql zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgql) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzj(zzgql zzgql, zzgqr zzgqr) {
        zzgqr.getClass();
        zzgql.zzf = zzgqr;
        zzgql.zzc |= 1;
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
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgql();
            case 4:
                return new zzgqk((zzgqj) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgql.class) {
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

    public final zzgqr zzf() {
        zzgqr zzgqr = this.zzf;
        if (zzgqr == null) {
            return zzgqr.zze();
        }
        return zzgqr;
    }

    public final zzgwm zzg() {
        return this.zze;
    }
}
