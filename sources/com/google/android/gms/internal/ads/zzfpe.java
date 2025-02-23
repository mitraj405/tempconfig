package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfpe extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzfpe zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgyg zzd = zzgxy.zzbG();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzfpe zzfpe = new zzfpe();
        zza = zzfpe;
        zzgxy.zzcb(zzfpe.class, zzfpe);
    }

    private zzfpe() {
    }

    public static zzfpd zza() {
        return (zzfpd) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzfpe zzfpe, String str) {
        str.getClass();
        zzfpe.zzc |= 1;
        zzfpe.zze = str;
    }

    public static /* synthetic */ void zze(zzfpe zzfpe, int i) {
        zzgyg zzgyg = zzfpe.zzd;
        if (!zzgyg.zzc()) {
            zzfpe.zzd = zzgxy.zzbH(zzgyg);
        }
        zzfpe.zzd.zzi(2);
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzc", "zzd", zzfpc.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzfpe();
            case 4:
                return new zzfpd((zzfpb) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzfpe.class) {
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
