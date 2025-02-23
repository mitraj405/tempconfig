package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhbx extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhbx zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private zzgyk zzg = zzgxy.zzbK();
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private String zzl = "";
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private zzgyk zzu = zzgxy.zzbK();
    private boolean zzv;
    private long zzw;
    private zzgyg zzx = zzgxy.zzbG();
    private boolean zzy;
    private zzgyg zzz = zzgxy.zzbG();

    static {
        zzhbx zzhbx = new zzhbx();
        zza = zzhbx;
        zzgxy.zzcb(zzhbx.class, zzhbx);
    }

    private zzhbx() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005᠌\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006\tဈ\u0007\nင\b\u000bင\t\fင\n\rဇ\u000b\u000e\u001b\u000fဇ\f\u0010ဂ\r\u0011ࠬ\u0012ဇ\u000e\u0013ࠬ", new Object[]{"zzc", "zzd", zzhbw.zza, "zze", "zzf", "zzg", "zzh", zzhbu.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", zzhbt.class, "zzv", "zzw", "zzx", zzhbj.zza(), "zzy", "zzz", zzhbv.zza});
            case 3:
                return new zzhbx();
            case 4:
                return new zzhbq((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhbx.class) {
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
