package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasl extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzasl zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private boolean zzf;
    private zzgyg zzg = zzgxy.zzbG();
    private long zzh;

    static {
        zzasl zzasl = new zzasl();
        zza = zzasl;
        zzgxy.zzcb(zzasl.class, zzasl);
    }

    private zzasl() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 3:
                return new zzasl();
            case 4:
                return new zzask((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzasl.class) {
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
