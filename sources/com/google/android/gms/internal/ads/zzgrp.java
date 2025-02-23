package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgrp extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgrp zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;

    static {
        zzgrp zzgrp = new zzgrp();
        zza = zzgrp;
        zzgxy.zzcb(zzgrp.class, zzgrp);
    }

    private zzgrp() {
    }

    public static zzgro zzc() {
        return (zzgro) zza.zzaZ();
    }

    public static zzgrp zze() {
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
                return new zzgrp();
            case 4:
                return new zzgro((zzgrn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgrp.class) {
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
