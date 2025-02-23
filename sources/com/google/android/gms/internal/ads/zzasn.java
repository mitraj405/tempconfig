package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasn extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzasn zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgwm zzd;
    private zzgwm zze;
    private zzgwm zzf;
    private zzgwm zzg;

    static {
        zzasn zzasn = new zzasn();
        zza = zzasn;
        zzgxy.zzcb(zzasn.class, zzasn);
    }

    private zzasn() {
        zzgwm zzgwm = zzgwm.zzb;
        this.zzd = zzgwm;
        this.zze = zzgwm;
        this.zzf = zzgwm;
        this.zzg = zzgwm;
    }

    public static zzasm zza() {
        return (zzasm) zza.zzaZ();
    }

    public static zzasn zzd(byte[] bArr, zzgxi zzgxi) throws zzgyn {
        return (zzasn) zzgxy.zzbx(zza, bArr, zzgxi);
    }

    public static /* synthetic */ void zzi(zzasn zzasn, zzgwm zzgwm) {
        zzasn.zzc |= 1;
        zzasn.zzd = zzgwm;
    }

    public static /* synthetic */ void zzj(zzasn zzasn, zzgwm zzgwm) {
        zzasn.zzc |= 2;
        zzasn.zze = zzgwm;
    }

    public static /* synthetic */ void zzk(zzasn zzasn, zzgwm zzgwm) {
        zzasn.zzc |= 4;
        zzasn.zzf = zzgwm;
    }

    public static /* synthetic */ void zzl(zzasn zzasn, zzgwm zzgwm) {
        zzasn.zzc |= 8;
        zzasn.zzg = zzgwm;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzasn();
            case 4:
                return new zzasm((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzasn.class) {
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

    public final zzgwm zze() {
        return this.zzd;
    }

    public final zzgwm zzf() {
        return this.zze;
    }

    public final zzgwm zzg() {
        return this.zzg;
    }

    public final zzgwm zzh() {
        return this.zzf;
    }
}
