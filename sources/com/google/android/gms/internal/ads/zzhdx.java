package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhdx extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhdx zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";

    static {
        zzhdx zzhdx = new zzhdx();
        zza = zzhdx;
        zzgxy.zzcb(zzhdx.class, zzhdx);
    }

    private zzhdx() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", zzhdw.zza, "zze"});
            case 3:
                return new zzhdx();
            case 4:
                return new zzhdv((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhdx.class) {
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
