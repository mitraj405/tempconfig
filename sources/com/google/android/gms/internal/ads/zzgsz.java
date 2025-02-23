package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgsz extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgsz zza;
    private static volatile zzgzr zzb;
    private String zzc = "";
    private zzgwm zzd = zzgwm.zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgsz zzgsz = new zzgsz();
        zza = zzgsz;
        zzgxy.zzcb(zzgsz.class, zzgsz);
    }

    private zzgsz() {
    }

    public static zzgsy zza() {
        return (zzgsy) zza.zzaZ();
    }

    public static zzgsy zzc(zzgsz zzgsz) {
        return (zzgsy) zza.zzba(zzgsz);
    }

    public static zzgsz zze() {
        return zza;
    }

    public static zzgsz zzf(byte[] bArr, zzgxi zzgxi) throws zzgyn {
        return (zzgsz) zzgxy.zzbx(zza, bArr, zzgxi);
    }

    public static /* synthetic */ void zzj(zzgsz zzgsz, String str) {
        str.getClass();
        zzgsz.zzc = str;
    }

    public static /* synthetic */ void zzk(zzgsz zzgsz, zzgwm zzgwm) {
        zzgwm.getClass();
        zzgsz.zzd = zzgwm;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgsz();
            case 4:
                return new zzgsy((zzgsx) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgsz.class) {
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

    public final zzgtz zzg() {
        zzgtz zzb2 = zzgtz.zzb(this.zze);
        if (zzb2 == null) {
            return zzgtz.UNRECOGNIZED;
        }
        return zzb2;
    }

    public final zzgwm zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzc;
    }
}
