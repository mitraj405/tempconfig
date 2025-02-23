package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhdj extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhdj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgwm zzf;
    private zzgwm zzg;

    static {
        zzhdj zzhdj = new zzhdj();
        zza = zzhdj;
        zzgxy.zzcb(zzhdj.class, zzhdj);
    }

    private zzhdj() {
        zzgwm zzgwm = zzgwm.zzb;
        this.zzf = zzgwm;
        this.zzg = zzgwm;
    }

    public static zzhdh zzc() {
        return (zzhdh) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhdj zzhdj, String str) {
        zzhdj.zzc |= 2;
        zzhdj.zze = "image/png";
    }

    public static /* synthetic */ void zzf(zzhdj zzhdj, zzgwm zzgwm) {
        zzgwm.getClass();
        zzhdj.zzc |= 4;
        zzhdj.zzf = zzgwm;
    }

    public static /* synthetic */ void zzg(zzhdj zzhdj, int i) {
        zzhdj.zzd = 1;
        zzhdj.zzc = 1 | zzhdj.zzc;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", zzhdi.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzhdj();
            case 4:
                return new zzhdh((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhdj.class) {
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
