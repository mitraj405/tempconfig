package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgra extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgra zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgrg zze;
    /* access modifiers changed from: private */
    public zzgwm zzf = zzgwm.zzb;

    static {
        zzgra zzgra = new zzgra();
        zza = zzgra;
        zzgxy.zzcb(zzgra.class, zzgra);
    }

    private zzgra() {
    }

    public static zzgqz zzc() {
        return (zzgqz) zza.zzaZ();
    }

    public static zzgra zze() {
        return zza;
    }

    public static /* synthetic */ void zzh(zzgra zzgra, zzgrg zzgrg) {
        zzgrg.getClass();
        zzgra.zze = zzgrg;
        zzgra.zzc |= 1;
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
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgra();
            case 4:
                return new zzgqz((zzgqy) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgra.class) {
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

    public final zzgrg zzf() {
        zzgrg zzgrg = this.zze;
        if (zzgrg == null) {
            return zzgrg.zze();
        }
        return zzgrg;
    }

    public final zzgwm zzg() {
        return this.zzf;
    }
}
