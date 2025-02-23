package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgsr extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgsr zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzgsr zzgsr = new zzgsr();
        zza = zzgsr;
        zzgxy.zzcb(zzgsr.class, zzgsr);
    }

    private zzgsr() {
    }

    public static zzgsq zzd() {
        return (zzgsq) zza.zzaZ();
    }

    public static zzgsr zzf() {
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzgsi zzc() {
        zzgsi zzgsi;
        int i = this.zzc;
        if (i == 0) {
            zzgsi = zzgsi.UNKNOWN_HASH;
        } else if (i == 1) {
            zzgsi = zzgsi.SHA1;
        } else if (i == 2) {
            zzgsi = zzgsi.SHA384;
        } else if (i == 3) {
            zzgsi = zzgsi.SHA256;
        } else if (i == 4) {
            zzgsi = zzgsi.SHA512;
        } else if (i != 5) {
            zzgsi = null;
        } else {
            zzgsi = zzgsi.SHA224;
        }
        if (zzgsi == null) {
            return zzgsi.UNRECOGNIZED;
        }
        return zzgsi;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgsr();
            case 4:
                return new zzgsq((zzgsp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgsr.class) {
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
