package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzarj extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzarj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd = 2;

    static {
        zzarj zzarj = new zzarj();
        zza = zzarj;
        zzgxy.zzcb(zzarj.class, zzarj);
    }

    private zzarj() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzc", "zzd", zzark.zza});
            case 3:
                return new zzarj();
            case 4:
                return new zzari((zzarf) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzarj.class) {
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
