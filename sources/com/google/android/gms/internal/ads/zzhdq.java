package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhdq extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhdq zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private long zze;
    private boolean zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;

    static {
        zzhdq zzhdq = new zzhdq();
        zza = zzhdq;
        zzgxy.zzcb(zzhdq.class, zzhdq);
    }

    private zzhdq() {
    }

    public static zzhdp zzc() {
        return (zzhdp) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhdq zzhdq, String str) {
        zzhdq.zzc |= 1;
        zzhdq.zzd = str;
    }

    public static /* synthetic */ void zzf(zzhdq zzhdq, long j) {
        zzhdq.zzc |= 2;
        zzhdq.zze = j;
    }

    public static /* synthetic */ void zzg(zzhdq zzhdq, boolean z) {
        zzhdq.zzc |= 4;
        zzhdq.zzf = z;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzhdr.zza, "zzh", "zzi", "zzj"});
            case 3:
                return new zzhdq();
            case 4:
                return new zzhdp((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhdq.class) {
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
