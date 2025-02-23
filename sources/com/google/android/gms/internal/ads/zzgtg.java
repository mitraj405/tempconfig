package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgtg extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgtg zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgsv zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzgtg zzgtg = new zzgtg();
        zza = zzgtg;
        zzgxy.zzcb(zzgtg.class, zzgtg);
    }

    private zzgtg() {
    }

    public static zzgtf zzd() {
        return (zzgtf) zza.zzaZ();
    }

    public static /* synthetic */ void zzg(zzgtg zzgtg, zzgsv zzgsv) {
        zzgsv.getClass();
        zzgtg.zzd = zzgsv;
        zzgtg.zzc |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgsv zzc() {
        zzgsv zzgsv = this.zzd;
        if (zzgsv == null) {
            return zzgsv.zze();
        }
        return zzgsv;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzgtg();
            case 4:
                return new zzgtf((zzgtd) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgtg.class) {
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

    public final zzgtz zzf() {
        zzgtz zzb2 = zzgtz.zzb(this.zzg);
        if (zzb2 == null) {
            return zzgtz.UNRECOGNIZED;
        }
        return zzb2;
    }

    public final boolean zzj() {
        if ((this.zzc & 1) != 0) {
            return true;
        }
        return false;
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                i2 = 3;
            } else if (i == 2) {
                i2 = 4;
            } else if (i != 3) {
                i2 = 0;
            } else {
                i2 = 5;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
