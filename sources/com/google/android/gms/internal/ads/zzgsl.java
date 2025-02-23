package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgsl extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgsl zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgsr zze;
    /* access modifiers changed from: private */
    public zzgwm zzf = zzgwm.zzb;

    static {
        zzgsl zzgsl = new zzgsl();
        zza = zzgsl;
        zzgxy.zzcb(zzgsl.class, zzgsl);
    }

    private zzgsl() {
    }

    public static zzgsk zzc() {
        return (zzgsk) zza.zzaZ();
    }

    public static zzgsl zze() {
        return zza;
    }

    public static zzgsl zzf(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgsl) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static zzgzr zzi() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzj(zzgsl zzgsl, zzgsr zzgsr) {
        zzgsr.getClass();
        zzgsl.zze = zzgsr;
        zzgsl.zzc |= 1;
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
                return new zzgsl();
            case 4:
                return new zzgsk((zzgsj) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgsl.class) {
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

    public final zzgsr zzg() {
        zzgsr zzgsr = this.zze;
        if (zzgsr == null) {
            return zzgsr.zzf();
        }
        return zzgsr;
    }

    public final zzgwm zzh() {
        return this.zzf;
    }
}
