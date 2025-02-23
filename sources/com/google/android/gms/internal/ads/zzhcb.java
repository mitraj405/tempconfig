package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhcb extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhcb zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzhcb zzhcb = new zzhcb();
        zza = zzhcb;
        zzgxy.zzcb(zzhcb.class, zzhcb);
    }

    private zzhcb() {
    }

    public static zzhca zzc() {
        return (zzhca) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhcb zzhcb, String str) {
        zzhcb.zzc |= 1;
        zzhcb.zzd = str;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzhcb();
            case 4:
                return new zzhca((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhcb.class) {
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
