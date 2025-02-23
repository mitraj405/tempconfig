package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgrg extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgrg zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;

    static {
        zzgrg zzgrg = new zzgrg();
        zza = zzgrg;
        zzgxy.zzcb(zzgrg.class, zzgrg);
    }

    private zzgrg() {
    }

    public static zzgrf zzc() {
        return (zzgrf) zza.zzaZ();
    }

    public static zzgrg zze() {
        return zza;
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
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
            case 3:
                return new zzgrg();
            case 4:
                return new zzgrf((zzgre) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgrg.class) {
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
