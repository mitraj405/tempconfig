package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhbt extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhbt zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private long zze;
    private zzgwm zzf = zzgwm.zzb;

    static {
        zzhbt zzhbt = new zzhbt();
        zza = zzhbt;
        zzgxy.zzcb(zzhbt.class, zzhbt);
    }

    private zzhbt() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", zzhbs.zza, "zze", "zzf"});
            case 3:
                return new zzhbt();
            case 4:
                return new zzhbr((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhbt.class) {
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
