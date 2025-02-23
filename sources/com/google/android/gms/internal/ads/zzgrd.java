package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgrd extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgrd zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgrg zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgrd zzgrd = new zzgrd();
        zza = zzgrd;
        zzgxy.zzcb(zzgrd.class, zzgrd);
    }

    private zzgrd() {
    }

    public static zzgrc zzc() {
        return (zzgrc) zza.zzaZ();
    }

    public static zzgrd zze() {
        return zza;
    }

    public static /* synthetic */ void zzg(zzgrd zzgrd, zzgrg zzgrg) {
        zzgrg.getClass();
        zzgrd.zzd = zzgrg;
        zzgrd.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgrd();
            case 4:
                return new zzgrc((zzgrb) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgrd.class) {
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

    public final zzgrg zzf() {
        zzgrg zzgrg = this.zzd;
        if (zzgrg == null) {
            return zzgrg.zze();
        }
        return zzgrg;
    }
}
