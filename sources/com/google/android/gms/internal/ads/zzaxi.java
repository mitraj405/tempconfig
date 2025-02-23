package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaxi extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzaxi zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzaxl zzd;
    private zzgwm zze;
    private zzgwm zzf;

    static {
        zzaxi zzaxi = new zzaxi();
        zza = zzaxi;
        zzgxy.zzcb(zzaxi.class, zzaxi);
    }

    private zzaxi() {
        zzgwm zzgwm = zzgwm.zzb;
        this.zze = zzgwm;
        this.zzf = zzgwm;
    }

    public static zzaxi zzc(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzaxi) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public final zzaxl zzd() {
        zzaxl zzaxl = this.zzd;
        if (zzaxl == null) {
            return zzaxl.zzg();
        }
        return zzaxl;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzaxi();
            case 4:
                return new zzaxh((zzaxg) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzaxi.class) {
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

    public final zzgwm zze() {
        return this.zzf;
    }

    public final zzgwm zzf() {
        return this.zze;
    }
}
