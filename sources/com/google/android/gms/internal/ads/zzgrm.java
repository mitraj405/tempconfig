package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgrm extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgrm zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgrp zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgrm zzgrm = new zzgrm();
        zza = zzgrm;
        zzgxy.zzcb(zzgrm.class, zzgrm);
    }

    private zzgrm() {
    }

    public static zzgrl zzc() {
        return (zzgrl) zza.zzaZ();
    }

    public static zzgrm zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgrm) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static /* synthetic */ void zzg(zzgrm zzgrm, zzgrp zzgrp) {
        zzgrp.getClass();
        zzgrm.zzd = zzgrp;
        zzgrm.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgrm();
            case 4:
                return new zzgrl((zzgrk) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgrm.class) {
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
        zzgrp zzgrp = this.zzd;
        if (zzgrp == null) {
            return zzgrp.zze();
        }
        return zzgrp;
    }
}
