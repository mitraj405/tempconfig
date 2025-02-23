package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzary extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzary zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zzd = -1;

    static {
        zzary zzary = new zzary();
        zza = zzary;
        zzgxy.zzcb(zzary.class, zzary);
    }

    private zzary() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzary();
            case 4:
                return new zzarx((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzary.class) {
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
