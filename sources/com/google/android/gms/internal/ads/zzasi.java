package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasi extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzasi zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzasi zzasi = new zzasi();
        zza = zzasi;
        zzgxy.zzcb(zzasi.class, zzasi);
    }

    private zzasi() {
    }

    public static zzash zza() {
        return (zzash) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzasi zzasi, long j) {
        zzasi.zzc |= 1;
        zzasi.zzd = j;
    }

    public static /* synthetic */ void zze(zzasi zzasi, long j) {
        zzasi.zzc |= 4;
        zzasi.zzf = j;
    }

    public static /* synthetic */ void zzf(zzasi zzasi, long j) {
        zzasi.zzc |= 8;
        zzasi.zzg = j;
    }

    public static /* synthetic */ void zzg(zzasi zzasi, long j) {
        zzasi.zzc |= 16;
        zzasi.zzh = j;
    }

    public static /* synthetic */ void zzh(zzasi zzasi, long j) {
        zzasi.zzc |= 32;
        zzasi.zzi = j;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 3:
                return new zzasi();
            case 4:
                return new zzash((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzasi.class) {
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
