package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhbo extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhbo zza;
    private static volatile zzgzr zzb;
    private zzgyk zzc = zzgxy.zzbK();

    static {
        zzhbo zzhbo = new zzhbo();
        zza = zzhbo;
        zzgxy.zzcb(zzhbo.class, zzhbo);
    }

    private zzhbo() {
    }

    public static zzhbn zzc() {
        return (zzhbn) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhbo zzhbo, zzhbm zzhbm) {
        zzhbm.getClass();
        zzgyk zzgyk = zzhbo.zzc;
        if (!zzgyk.zzc()) {
            zzhbo.zzc = zzgxy.zzbL(zzgyk);
        }
        zzhbo.zzc.add(zzhbm);
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzhbm.class});
            case 3:
                return new zzhbo();
            case 4:
                return new zzhbn((zzhbk) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhbo.class) {
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
