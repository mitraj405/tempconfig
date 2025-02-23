package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasw extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzasw zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgyk zzd = zzgxy.zzbK();
    private zzgwm zze = zzgwm.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzasw zzasw = new zzasw();
        zza = zzasw;
        zzgxy.zzcb(zzasw.class, zzasw);
    }

    private zzasw() {
    }

    public static zzasv zza() {
        return (zzasv) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzasw zzasw, zzgwm zzgwm) {
        zzgyk zzgyk = zzasw.zzd;
        if (!zzgyk.zzc()) {
            zzasw.zzd = zzgxy.zzbL(zzgyk);
        }
        zzasw.zzd.add(zzgwm);
    }

    public static /* synthetic */ void zze(zzasw zzasw, zzgwm zzgwm) {
        zzasw.zzc |= 1;
        zzasw.zze = zzgwm;
    }

    public static /* synthetic */ void zzf(zzasw zzasw, int i) {
        zzasw.zzg = 4;
        zzasw.zzc = 4 | zzasw.zzc;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzasq.zza, "zzg", zzaso.zza});
            case 3:
                return new zzasw();
            case 4:
                return new zzasv((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzasw.class) {
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
