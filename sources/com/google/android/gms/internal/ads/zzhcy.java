package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhcy extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhcy zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzhcx zze;
    private zzhcx zzf;

    static {
        zzhcy zzhcy = new zzhcy();
        zza = zzhcy;
        zzgxy.zzcb(zzhcy.class, zzhcy);
    }

    private zzhcy() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzhcv.zza, "zze", "zzf"});
            case 3:
                return new zzhcy();
            case 4:
                return new zzhcu((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhcy.class) {
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
