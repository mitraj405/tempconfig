package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgrs extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgrs zza;
    private static volatile zzgzr zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public zzgwm zzd = zzgwm.zzb;

    static {
        zzgrs zzgrs = new zzgrs();
        zza = zzgrs;
        zzgxy.zzcb(zzgrs.class, zzgrs);
    }

    private zzgrs() {
    }

    public static zzgrr zzc() {
        return (zzgrr) zza.zzaZ();
    }

    public static zzgrs zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgrs) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static zzgzr zzg() {
        return zza.zzbN();
    }

    public final int zza() {
        return this.zzc;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgrs();
            case 4:
                return new zzgrr((zzgrq) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgrs.class) {
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

    public final zzgwm zzf() {
        return this.zzd;
    }
}
