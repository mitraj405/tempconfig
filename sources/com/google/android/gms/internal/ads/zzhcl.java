package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhcl extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhcl zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgwm zzd;
    private zzgwm zze;
    private byte zzf = 2;

    static {
        zzhcl zzhcl = new zzhcl();
        zza = zzhcl;
        zzgxy.zzcb(zzhcl.class, zzhcl);
    }

    private zzhcl() {
        zzgwm zzgwm = zzgwm.zzb;
        this.zzd = zzgwm;
        this.zze = zzgwm;
    }

    public static zzhck zzc() {
        return (zzhck) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhcl zzhcl, zzgwm zzgwm) {
        zzhcl.zzc |= 1;
        zzhcl.zzd = zzgwm;
    }

    public static /* synthetic */ void zzf(zzhcl zzhcl, zzgwm zzgwm) {
        zzhcl.zzc |= 2;
        zzhcl.zze = zzgwm;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        byte b = 1;
        switch (zzgxx.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzf);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzf = b;
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzhcl();
            case 4:
                return new zzhck((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhcl.class) {
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
