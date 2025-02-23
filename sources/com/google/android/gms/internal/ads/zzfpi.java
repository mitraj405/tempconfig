package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfpi extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzfpi zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfpe zzg;

    static {
        zzfpi zzfpi = new zzfpi();
        zza = zzfpi;
        zzgxy.zzcb(zzfpi.class, zzfpi);
    }

    private zzfpi() {
    }

    public static zzfpg zza() {
        return (zzfpg) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzfpi zzfpi, String str) {
        str.getClass();
        zzfpi.zzc |= 2;
        zzfpi.zze = str;
    }

    public static /* synthetic */ void zze(zzfpi zzfpi, zzfpe zzfpe) {
        zzfpe.getClass();
        zzfpi.zzg = zzfpe;
        zzfpi.zzc |= 8;
    }

    public static /* synthetic */ void zzf(zzfpi zzfpi, int i) {
        zzfpi.zzd = 1;
        zzfpi.zzc = 1 | zzfpi.zzc;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzfph.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzfpi();
            case 4:
                return new zzfpg((zzfpf) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzfpi.class) {
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
