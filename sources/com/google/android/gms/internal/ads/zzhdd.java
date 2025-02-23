package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhdd extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhdd zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private long zze;

    static {
        zzhdd zzhdd = new zzhdd();
        zza = zzhdd;
        zzgxy.zzcb(zzhdd.class, zzhdd);
    }

    private zzhdd() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzhdd();
            case 4:
                return new zzhdc((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhdd.class) {
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
