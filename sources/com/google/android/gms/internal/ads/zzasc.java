package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasc extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzasc zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private long zze = -1;

    static {
        zzasc zzasc = new zzasc();
        zza = zzasc;
        zzgxy.zzcb(zzasc.class, zzasc);
    }

    private zzasc() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", zzars.zza, "zze"});
            case 3:
                return new zzasc();
            case 4:
                return new zzasb((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzasc.class) {
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
