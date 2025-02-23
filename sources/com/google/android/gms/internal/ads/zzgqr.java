package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgqr extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgqr zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;

    static {
        zzgqr zzgqr = new zzgqr();
        zza = zzgqr;
        zzgxy.zzcb(zzgqr.class, zzgqr);
    }

    private zzgqr() {
    }

    public static zzgqq zzc() {
        return (zzgqq) zza.zzaZ();
    }

    public static zzgqr zze() {
        return zza;
    }

    public final int zza() {
        return this.zzc;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
            case 3:
                return new zzgqr();
            case 4:
                return new zzgqq((zzgqp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgqr.class) {
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
