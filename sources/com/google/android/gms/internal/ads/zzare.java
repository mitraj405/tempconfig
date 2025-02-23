package com.google.android.gms.internal.ads;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzare extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzare zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private long zzj;
    private String zzk = "";
    private long zzl;
    private String zzm = "";
    private String zzn = "";
    private zzgyk zzo = zzgxy.zzbK();
    private int zzp;

    static {
        zzare zzare = new zzare();
        zza = zzare;
        zzgxy.zzcb(zzare.class, zzare);
    }

    private zzare() {
    }

    public static zzara zza() {
        return (zzara) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzare zzare, long j) {
        zzare.zzc |= 2;
        zzare.zze = j;
    }

    public static /* synthetic */ void zze(zzare zzare, String str) {
        str.getClass();
        zzare.zzc |= 4;
        zzare.zzf = str;
    }

    public static /* synthetic */ void zzf(zzare zzare, String str) {
        str.getClass();
        zzare.zzc |= 8;
        zzare.zzg = str;
    }

    public static /* synthetic */ void zzg(zzare zzare, String str) {
        zzare.zzc |= 16;
        zzare.zzh = str;
    }

    public static /* synthetic */ void zzh(zzare zzare, String str) {
        zzare.zzc |= UserMetadata.MAX_ATTRIBUTE_SIZE;
        zzare.zzn = str;
    }

    public static /* synthetic */ void zzi(zzare zzare, String str) {
        str.getClass();
        zzare.zzc |= 1;
        zzare.zzd = str;
    }

    public static /* synthetic */ void zzj(zzare zzare, int i) {
        zzare.zzp = i - 1;
        zzare.zzc |= 2048;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzarc.class, "zzp", zzard.zza});
            case 3:
                return new zzare();
            case 4:
                return new zzara((zzaqz) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzare.class) {
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
