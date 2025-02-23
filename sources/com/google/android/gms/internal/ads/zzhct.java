package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhct extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhct zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzhcs zzd;
    private zzgyk zze = zzgxy.zzbK();
    private zzgwm zzf;
    private zzgwm zzg;
    private int zzh;
    private zzgwm zzi;
    private byte zzj = 2;

    static {
        zzhct zzhct = new zzhct();
        zza = zzhct;
        zzgxy.zzcb(zzhct.class, zzhct);
    }

    private zzhct() {
        zzgwm zzgwm = zzgwm.zzb;
        this.zzf = zzgwm;
        this.zzg = zzgwm;
        this.zzi = zzgwm;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        byte b = 1;
        switch (zzgxx.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzj);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzj = b;
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzc", "zzd", "zze", zzhcl.class, "zzf", "zzg", "zzh", "zzi"});
            case 3:
                return new zzhct();
            case 4:
                return new zzhcq((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhct.class) {
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
