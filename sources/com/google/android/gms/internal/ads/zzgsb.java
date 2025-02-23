package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgsb extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgsb zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private int zzd;

    static {
        zzgsb zzgsb = new zzgsb();
        zza = zzgsb;
        zzgxy.zzcb(zzgsb.class, zzgsb);
    }

    private zzgsb() {
    }

    public static zzgsa zzd() {
        return (zzgsa) zza.zzaZ();
    }

    public static zzgsb zzf(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgsb) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzd", "zzc"});
            case 3:
                return new zzgsb();
            case 4:
                return new zzgsa((zzgrz) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgsb.class) {
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
}
