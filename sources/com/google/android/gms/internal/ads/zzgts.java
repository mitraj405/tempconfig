package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgts extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgts zza;
    private static volatile zzgzr zzb;
    private String zzc = "";

    static {
        zzgts zzgts = new zzgts();
        zza = zzgts;
        zzgxy.zzcb(zzgts.class, zzgts);
    }

    private zzgts() {
    }

    public static zzgtr zza() {
        return (zzgtr) zza.zzaZ();
    }

    public static zzgts zzd() {
        return zza;
    }

    public static zzgts zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgts) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static /* synthetic */ void zzg(zzgts zzgts, String str) {
        str.getClass();
        zzgts.zzc = str;
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
                return new zzgts();
            case 4:
                return new zzgtr((zzgtq) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgts.class) {
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

    public final String zzf() {
        return this.zzc;
    }
}
