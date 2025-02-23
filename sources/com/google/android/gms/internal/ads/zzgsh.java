package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgsh extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgsh zza;
    private static volatile zzgzr zzb;

    static {
        zzgsh zzgsh = new zzgsh();
        zza = zzgsh;
        zzgxy.zzcb(zzgsh.class, zzgsh);
    }

    private zzgsh() {
    }

    public static zzgsh zzc() {
        return zza;
    }

    public static zzgsh zzd(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgsh) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0000", (Object[]) null);
            case 3:
                return new zzgsh();
            case 4:
                return new zzgsg((zzgsf) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgsh.class) {
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
