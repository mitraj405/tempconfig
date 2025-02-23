package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzarc extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzarc zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    static {
        zzarc zzarc = new zzarc();
        zza = zzarc;
        zzgxy.zzcb(zzarc.class, zzarc);
    }

    private zzarc() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzarc();
            case 4:
                return new zzarb((zzaqz) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzarc.class) {
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
