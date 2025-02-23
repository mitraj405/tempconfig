package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgrv extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgrv zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private int zzd;

    static {
        zzgrv zzgrv = new zzgrv();
        zza = zzgrv;
        zzgxy.zzcb(zzgrv.class, zzgrv);
    }

    private zzgrv() {
    }

    public static zzgru zzd() {
        return (zzgru) zza.zzaZ();
    }

    public static zzgrv zzf(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgrv) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgrv();
            case 4:
                return new zzgru((zzgrt) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgrv.class) {
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
