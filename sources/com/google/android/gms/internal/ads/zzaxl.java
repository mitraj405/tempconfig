package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaxl extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzaxl zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzaxl zzaxl = new zzaxl();
        zza = zzaxl;
        zzgxy.zzcb(zzaxl.class, zzaxl);
    }

    private zzaxl() {
    }

    public static zzaxk zze() {
        return (zzaxk) zza.zzaZ();
    }

    public static zzaxl zzg() {
        return zza;
    }

    public static zzaxl zzh(zzgwm zzgwm) throws zzgyn {
        return (zzaxl) zzgxy.zzbm(zza, zzgwm);
    }

    public static zzaxl zzi(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        return (zzaxl) zzgxy.zzbr(zza, zzgwm, zzgxi);
    }

    public static /* synthetic */ void zzl(zzaxl zzaxl, String str) {
        str.getClass();
        zzaxl.zzc |= 1;
        zzaxl.zzd = str;
    }

    public static /* synthetic */ void zzm(zzaxl zzaxl, long j) {
        zzaxl.zzc |= 16;
        zzaxl.zzh = j;
    }

    public static /* synthetic */ void zzn(zzaxl zzaxl, String str) {
        str.getClass();
        zzaxl.zzc |= 2;
        zzaxl.zze = str;
    }

    public static /* synthetic */ void zzo(zzaxl zzaxl, long j) {
        zzaxl.zzc |= 4;
        zzaxl.zzf = j;
    }

    public static /* synthetic */ void zzp(zzaxl zzaxl, long j) {
        zzaxl.zzc |= 8;
        zzaxl.zzg = j;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 3:
                return new zzaxl();
            case 4:
                return new zzaxk((zzaxj) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzaxl.class) {
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

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
