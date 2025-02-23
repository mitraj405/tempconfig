package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgsv extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgsv zza;
    private static volatile zzgzr zzb;
    private String zzc = "";
    private zzgwm zzd = zzgwm.zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgsv zzgsv = new zzgsv();
        zza = zzgsv;
        zzgxy.zzcb(zzgsv.class, zzgsv);
    }

    private zzgsv() {
    }

    public static zzgst zza() {
        return (zzgst) zza.zzaZ();
    }

    public static zzgsv zze() {
        return zza;
    }

    public static /* synthetic */ void zzh(zzgsv zzgsv, String str) {
        str.getClass();
        zzgsv.zzc = str;
    }

    public static /* synthetic */ void zzi(zzgsv zzgsv, zzgwm zzgwm) {
        zzgwm.getClass();
        zzgsv.zzd = zzgwm;
    }

    public final zzgsu zzc() {
        zzgsu zzgsu;
        int i = this.zze;
        if (i == 0) {
            zzgsu = zzgsu.UNKNOWN_KEYMATERIAL;
        } else if (i == 1) {
            zzgsu = zzgsu.SYMMETRIC;
        } else if (i == 2) {
            zzgsu = zzgsu.ASYMMETRIC_PRIVATE;
        } else if (i == 3) {
            zzgsu = zzgsu.ASYMMETRIC_PUBLIC;
        } else if (i != 4) {
            zzgsu = null;
        } else {
            zzgsu = zzgsu.REMOTE;
        }
        if (zzgsu == null) {
            return zzgsu.UNRECOGNIZED;
        }
        return zzgsu;
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
                return new zzgsv();
            case 4:
                return new zzgst((zzgss) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgsv.class) {
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

    public final zzgwm zzf() {
        return this.zzd;
    }

    public final String zzg() {
        return this.zzc;
    }
}
