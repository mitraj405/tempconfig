package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasg extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzasg zza;
    private static volatile zzgzr zzb;
    private long zzA = -1;
    private long zzB = -1;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private int zzj = 1000;
    private long zzk = -1;
    private long zzl = -1;
    private long zzm = -1;
    private int zzn = 1000;
    private long zzo = -1;
    private long zzp = -1;
    private long zzu = -1;
    private long zzv = -1;
    private long zzw;
    private long zzx;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzasg zzasg = new zzasg();
        zza = zzasg;
        zzgxy.zzcb(zzasg.class, zzasg);
    }

    private zzasg() {
    }

    public static zzasf zza() {
        return (zzasf) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzasg zzasg, long j) {
        zzasg.zzc |= 1;
        zzasg.zzd = j;
    }

    public static /* synthetic */ void zze(zzasg zzasg, long j) {
        zzasg.zzc |= 2;
        zzasg.zze = j;
    }

    public static /* synthetic */ void zzf(zzasg zzasg, long j) {
        zzasg.zzc |= 4;
        zzasg.zzf = j;
    }

    public static /* synthetic */ void zzg(zzasg zzasg, long j) {
        zzasg.zzc |= 8;
        zzasg.zzg = j;
    }

    public static /* synthetic */ void zzh(zzasg zzasg) {
        zzasg.zzc &= -9;
        zzasg.zzg = -1;
    }

    public static /* synthetic */ void zzi(zzasg zzasg, long j) {
        zzasg.zzc |= 16;
        zzasg.zzh = j;
    }

    public static /* synthetic */ void zzj(zzasg zzasg, long j) {
        zzasg.zzc |= 32;
        zzasg.zzi = j;
    }

    public static /* synthetic */ void zzk(zzasg zzasg, long j) {
        zzasg.zzc |= 128;
        zzasg.zzk = j;
    }

    public static /* synthetic */ void zzl(zzasg zzasg, long j) {
        zzasg.zzc |= 256;
        zzasg.zzl = j;
    }

    public static /* synthetic */ void zzm(zzasg zzasg, long j) {
        zzasg.zzc |= AdRequest.MAX_CONTENT_URL_LENGTH;
        zzasg.zzm = j;
    }

    public static /* synthetic */ void zzn(zzasg zzasg, long j) {
        zzasg.zzc |= 2048;
        zzasg.zzo = j;
    }

    public static /* synthetic */ void zzo(zzasg zzasg, long j) {
        zzasg.zzc |= 4096;
        zzasg.zzp = j;
    }

    public static /* synthetic */ void zzp(zzasg zzasg, long j) {
        zzasg.zzc |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
        zzasg.zzu = j;
    }

    public static /* synthetic */ void zzq(zzasg zzasg, long j) {
        zzasg.zzc |= 16384;
        zzasg.zzv = j;
    }

    public static /* synthetic */ void zzr(zzasg zzasg, long j) {
        zzasg.zzc |= 32768;
        zzasg.zzw = j;
    }

    public static /* synthetic */ void zzs(zzasg zzasg, long j) {
        zzasg.zzc |= 65536;
        zzasg.zzx = j;
    }

    public static /* synthetic */ void zzt(zzasg zzasg, long j) {
        zzasg.zzc |= 131072;
        zzasg.zzy = j;
    }

    public static /* synthetic */ void zzu(zzasg zzasg, long j) {
        zzasg.zzc |= 262144;
        zzasg.zzz = j;
    }

    public static /* synthetic */ void zzv(zzasg zzasg, int i) {
        zzasg.zzj = i - 1;
        zzasg.zzc |= 64;
    }

    public static /* synthetic */ void zzw(zzasg zzasg, int i) {
        zzasg.zzn = i - 1;
        zzasg.zzc |= UserMetadata.MAX_ATTRIBUTE_SIZE;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                zzgye zzgye = zzasp.zza;
                return zzgxy.zzbS(zza, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzgye, "zzk", "zzl", "zzm", "zzn", zzgye, "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB"});
            case 3:
                return new zzasg();
            case 4:
                return new zzasf((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzasg.class) {
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
