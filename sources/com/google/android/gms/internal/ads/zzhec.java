package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhec extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhec zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgyg zzf = zzgxy.zzbG();
    private int zzg;
    private zzgyk zzh = zzgxy.zzbK();
    private zzgwm zzi = zzgwm.zzb;

    static {
        zzhec zzhec = new zzhec();
        zza = zzhec;
        zzgxy.zzcb(zzhec.class, zzhec);
    }

    private zzhec() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzhea.class, "zzi"});
            case 3:
                return new zzhec();
            case 4:
                return new zzheb((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhec.class) {
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
