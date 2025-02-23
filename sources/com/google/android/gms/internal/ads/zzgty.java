package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgty extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgty zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private zzgsz zze;

    static {
        zzgty zzgty = new zzgty();
        zza = zzgty;
        zzgxy.zzcb(zzgty.class, zzgty);
    }

    private zzgty() {
    }

    public static zzgtx zzc() {
        return (zzgtx) zza.zzaZ();
    }

    public static zzgty zze() {
        return zza;
    }

    public static zzgty zzf(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgty) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static /* synthetic */ void zzh(zzgty zzgty, String str) {
        str.getClass();
        zzgty.zzd = str;
    }

    public static /* synthetic */ void zzi(zzgty zzgty, zzgsz zzgsz) {
        zzgsz.getClass();
        zzgty.zze = zzgsz;
        zzgty.zzc |= 1;
    }

    public final zzgsz zza() {
        zzgsz zzgsz = this.zze;
        if (zzgsz == null) {
            return zzgsz.zze();
        }
        return zzgsz;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgty();
            case 4:
                return new zzgtx((zzgtw) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgty.class) {
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

    public final String zzg() {
        return this.zzd;
    }
}
