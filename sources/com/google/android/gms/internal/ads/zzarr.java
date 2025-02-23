package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzarr extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzarr zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;

    static {
        zzarr zzarr = new zzarr();
        zza = zzarr;
        zzgxy.zzcb(zzarr.class, zzarr);
    }

    private zzarr() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzc", "zzd", zzaru.zza});
            case 3:
                return new zzarr();
            case 4:
                return new zzarq((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzarr.class) {
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
