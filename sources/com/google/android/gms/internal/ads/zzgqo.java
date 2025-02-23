package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgqo extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgqo zza;
    private static volatile zzgzr zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgqr zze;

    static {
        zzgqo zzgqo = new zzgqo();
        zza = zzgqo;
        zzgxy.zzcb(zzgqo.class, zzgqo);
    }

    private zzgqo() {
    }

    public static zzgqn zzc() {
        return (zzgqn) zza.zzaZ();
    }

    public static zzgqo zze(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzgqo) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static /* synthetic */ void zzh(zzgqo zzgqo, zzgqr zzgqr) {
        zzgqr.getClass();
        zzgqo.zze = zzgqr;
        zzgqo.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgqo();
            case 4:
                return new zzgqn((zzgqm) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgqo.class) {
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

    public final zzgqr zzf() {
        zzgqr zzgqr = this.zze;
        if (zzgqr == null) {
            return zzgqr.zze();
        }
        return zzgqr;
    }
}
