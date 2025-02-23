package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfkr extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzfkr zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public zzgyk zzc = zzgxy.zzbK();

    static {
        zzfkr zzfkr = new zzfkr();
        zza = zzfkr;
        zzgxy.zzcb(zzfkr.class, zzfkr);
    }

    private zzfkr() {
    }

    public static zzfko zzc() {
        return (zzfko) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzfkr zzfkr, zzfkq zzfkq) {
        zzfkq.getClass();
        zzgyk zzgyk = zzfkr.zzc;
        if (!zzgyk.zzc()) {
            zzfkr.zzc = zzgxy.zzbL(zzgyk);
        }
        zzfkr.zzc.add(zzfkq);
    }

    public final int zza() {
        return this.zzc.size();
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfkq.class});
            case 3:
                return new zzfkr();
            case 4:
                return new zzfko((zzfkn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzfkr.class) {
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
