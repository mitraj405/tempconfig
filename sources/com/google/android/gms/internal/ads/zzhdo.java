package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhdo extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhdo zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzhcp zzf;
    private zzhct zzg;
    private int zzh;
    private zzgyg zzi = zzgxy.zzbG();
    private String zzj = "";
    private int zzk;
    private zzgyk zzl = zzgxy.zzbK();
    private byte zzm = 2;

    static {
        zzhdo zzhdo = new zzhdo();
        zza = zzhdo;
        zzgxy.zzcb(zzhdo.class, zzhdo);
    }

    private zzhdo() {
    }

    public static zzhdn zzd() {
        return (zzhdn) zza.zzaZ();
    }

    public static /* synthetic */ void zzg(zzhdo zzhdo, int i) {
        zzhdo.zzc |= 1;
        zzhdo.zzd = i;
    }

    public static /* synthetic */ void zzh(zzhdo zzhdo, String str) {
        str.getClass();
        zzhdo.zzc |= 2;
        zzhdo.zze = str;
    }

    public static /* synthetic */ void zzi(zzhdo zzhdo, zzhcp zzhcp) {
        zzhcp.getClass();
        zzhdo.zzf = zzhcp;
        zzhdo.zzc |= 4;
    }

    public static /* synthetic */ void zzj(zzhdo zzhdo, String str) {
        str.getClass();
        zzgyk zzgyk = zzhdo.zzl;
        if (!zzgyk.zzc()) {
            zzhdo.zzl = zzgxy.zzbL(zzgyk);
        }
        zzhdo.zzl.add(str);
    }

    public static /* synthetic */ void zzk(zzhdo zzhdo, int i) {
        zzhdo.zzk = i - 1;
        zzhdo.zzc |= 64;
    }

    public final int zzc() {
        return this.zzl.size();
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        byte b = 1;
        switch (zzgxx.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzm);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzm = b;
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzhdl.zza, "zzl"});
            case 3:
                return new zzhdo();
            case 4:
                return new zzhdn((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhdo.class) {
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

    public final String zzf() {
        return this.zze;
    }
}
