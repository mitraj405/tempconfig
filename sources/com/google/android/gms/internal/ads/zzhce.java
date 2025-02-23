package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhce extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhce zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgwm zzd = zzgwm.zzb;

    static {
        zzhce zzhce = new zzhce();
        zza = zzhce;
        zzgxy.zzcb(zzhce.class, zzhce);
    }

    private zzhce() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ည\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzhce();
            case 4:
                return new zzhcd((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhce.class) {
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
