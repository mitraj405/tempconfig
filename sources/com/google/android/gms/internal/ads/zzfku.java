package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfku extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzfku zza;
    private static volatile zzgzr zzb;
    private String zzc = "";

    static {
        zzfku zzfku = new zzfku();
        zza = zzfku;
        zzgxy.zzcb(zzfku.class, zzfku);
    }

    private zzfku() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
            case 3:
                return new zzfku();
            case 4:
                return new zzfkt((zzfks) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzfku.class) {
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
