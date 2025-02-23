package com.google.android.gms.internal.ads;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhdy extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzhdy zza;
    private static volatile zzgzr zzb;
    private zzgyk zzA = zzgxy.zzbK();
    private zzgyk zzB = zzgxy.zzbK();
    private zzhdu zzC;
    private zzgyk zzD = zzgxy.zzbK();
    private zzhcf zzE;
    private String zzF = "";
    private zzhbx zzG;
    private zzgyk zzH = zzgxy.zzbK();
    private zzhcy zzI;
    private int zzJ;
    private zzgyk zzK = zzgxy.zzbK();
    private zzgyk zzL = zzgxy.zzbK();
    private long zzM;
    private zzhdx zzN;
    private zzhdd zzO;
    private byte zzP = 2;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private zzhcb zzi;
    private zzgyk zzj = zzgxy.zzbK();
    private zzgyk zzk = zzgxy.zzbK();
    private String zzl = "";
    private zzhdj zzm;
    private boolean zzn;
    private zzgyk zzo = zzgxy.zzbK();
    private String zzp = "";
    private boolean zzu;
    private boolean zzv;
    private zzgwm zzw = zzgwm.zzb;
    private zzhdq zzx;
    private boolean zzy;
    private String zzz = "";

    static {
        zzhdy zzhdy = new zzhdy();
        zza = zzhdy;
        zzgxy.zzcb(zzhdy.class, zzhdy);
    }

    private zzhdy() {
    }

    public static zzhbz zzc() {
        return (zzhbz) zza.zzaZ();
    }

    public static /* synthetic */ void zzh(zzhdy zzhdy, String str) {
        str.getClass();
        zzhdy.zzc |= 4;
        zzhdy.zzf = str;
    }

    public static /* synthetic */ void zzi(zzhdy zzhdy, String str) {
        str.getClass();
        zzhdy.zzc |= 8;
        zzhdy.zzg = str;
    }

    public static /* synthetic */ void zzj(zzhdy zzhdy, zzhcb zzhcb) {
        zzhcb.getClass();
        zzhdy.zzi = zzhcb;
        zzhdy.zzc |= 32;
    }

    public static /* synthetic */ void zzk(zzhdy zzhdy, zzhdo zzhdo) {
        zzhdo.getClass();
        zzgyk zzgyk = zzhdy.zzj;
        if (!zzgyk.zzc()) {
            zzhdy.zzj = zzgxy.zzbL(zzgyk);
        }
        zzhdy.zzj.add(zzhdo);
    }

    public static /* synthetic */ void zzl(zzhdy zzhdy, String str) {
        zzhdy.zzc |= 64;
        zzhdy.zzl = str;
    }

    public static /* synthetic */ void zzm(zzhdy zzhdy) {
        zzhdy.zzc &= -65;
        zzhdy.zzl = zza.zzl;
    }

    public static /* synthetic */ void zzn(zzhdy zzhdy, zzhdj zzhdj) {
        zzhdj.getClass();
        zzhdy.zzm = zzhdj;
        zzhdy.zzc |= 128;
    }

    public static /* synthetic */ void zzo(zzhdy zzhdy, zzhdq zzhdq) {
        zzhdq.getClass();
        zzhdy.zzx = zzhdq;
        zzhdy.zzc |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
    }

    public static /* synthetic */ void zzp(zzhdy zzhdy, Iterable iterable) {
        zzgyk zzgyk = zzhdy.zzA;
        if (!zzgyk.zzc()) {
            zzhdy.zzA = zzgxy.zzbL(zzgyk);
        }
        zzgvv.zzaQ(iterable, zzhdy.zzA);
    }

    public static /* synthetic */ void zzq(zzhdy zzhdy, Iterable iterable) {
        zzgyk zzgyk = zzhdy.zzB;
        if (!zzgyk.zzc()) {
            zzhdy.zzB = zzgxy.zzbL(zzgyk);
        }
        zzgvv.zzaQ(iterable, zzhdy.zzB);
    }

    public static /* synthetic */ void zzr(zzhdy zzhdy, int i) {
        zzhdy.zzd = i - 1;
        zzhdy.zzc |= 1;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        byte b = 1;
        switch (zzgxx.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzP);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzP = b;
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0001\"\u0000\u0001\u0001\"\"\u0000\t\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018", new Object[]{"zzc", "zzf", "zzg", "zzh", "zzj", zzhdo.class, "zzn", "zzo", "zzp", "zzu", "zzv", "zzd", zzhdk.zza, "zze", zzhby.zza, "zzi", "zzl", "zzm", "zzw", "zzk", zzhec.class, "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", zzhei.class, "zzE", "zzF", "zzG", "zzH", zzhcj.class, "zzI", "zzJ", zzhds.zza, "zzK", zzhdb.class, "zzL", zzhdg.class, "zzM", "zzN", "zzO"});
            case 3:
                return new zzhdy();
            case 4:
                return new zzhbz((zzhbp) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzhdy.class) {
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

    public final String zze() {
        return this.zzl;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final List zzg() {
        return this.zzj;
    }
}
