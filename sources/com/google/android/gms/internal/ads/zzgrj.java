package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgrj extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgrj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgrp zze;
    /* access modifiers changed from: private */
    public zzgwm zzf = zzgwm.zzb;

    static {
        zzgrj zzgrj = new zzgrj();
        zza = zzgrj;
        zzgxy.zzcb(zzgrj.class, zzgrj);
    }

    private zzgrj() {
    }

    public static zzgri zzc() {
        return (zzgri) zza.zzaZ();
    }

    public static zzgrj zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgrj) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzi(zzgrj zzgrj, zzgrp zzgrp) {
        zzgrp.getClass();
        zzgrj.zze = zzgrp;
        zzgrj.zzc |= 1;
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
                return new zzgrj();
            case 4:
                return new zzgri((zzgrh) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgrj.class) {
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

    public final zzgrp zzf() {
        zzgrp zzgrp = this.zze;
        if (zzgrp == null) {
            return zzgrp.zze();
        }
        return zzgrp;
    }

    public final zzgwm zzg() {
        return this.zzf;
    }
}
