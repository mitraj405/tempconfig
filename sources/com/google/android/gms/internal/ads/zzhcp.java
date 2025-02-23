package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhcp extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhcp zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzhco zzd;
    private zzgyk zze = zzgxy.zzbK();
    private zzgwm zzf;
    private zzgwm zzg;
    private int zzh;
    private byte zzi = 2;

    static {
        zzhcp zzhcp = new zzhcp();
        zza = zzhcp;
        zzgxy.zzcb(zzhcp.class, zzhcp);
    }

    private zzhcp() {
        zzgwm zzgwm = zzgwm.zzb;
        this.zzf = zzgwm;
        this.zzg = zzgwm;
    }

    public static zzhcm zzc() {
        return (zzhcm) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhcp zzhcp, zzhcl zzhcl) {
        zzhcl.getClass();
        zzgyk zzgyk = zzhcp.zze;
        if (!zzgyk.zzc()) {
            zzhcp.zze = zzgxy.zzbL(zzgyk);
        }
        zzhcp.zze.add(zzhcl);
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        byte b = 1;
        switch (zzgxx.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzi);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzi = b;
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzhcl.class, "zzf", "zzg", "zzh"});
            case 3:
                return new zzhcp();
            case 4:
                return new zzhcm((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhcp.class) {
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
