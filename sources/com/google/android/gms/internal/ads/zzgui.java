package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgui extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgui zza;
    private static volatile zzgzr zzb;
    private int zzc;

    static {
        zzgui zzgui = new zzgui();
        zza = zzgui;
        zzgxy.zzcb(zzgui.class, zzgui);
    }

    private zzgui() {
    }

    public static zzgui zzd() {
        return zza;
    }

    public static zzgui zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgui) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public final int zza() {
        return this.zzc;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
            case 3:
                return new zzgui();
            case 4:
                return new zzguh((zzgug) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgui.class) {
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
