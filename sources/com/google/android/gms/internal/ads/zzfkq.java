package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfkq extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzfkq zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzfkm zzd;

    static {
        zzfkq zzfkq = new zzfkq();
        zza = zzfkq;
        zzgxy.zzcb(zzfkq.class, zzfkq);
    }

    private zzfkq() {
    }

    public static zzfkp zza() {
        return (zzfkp) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzfkq zzfkq, zzfkm zzfkm) {
        zzfkm.getClass();
        zzfkq.zzd = zzfkm;
        zzfkq.zzc |= 1;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzfkq();
            case 4:
                return new zzfkp((zzfkn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzfkq.class) {
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
