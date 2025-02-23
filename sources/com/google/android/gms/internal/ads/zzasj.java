package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.common.primitives.Ints;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasj extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzasj zza;
    private static volatile zzgzr zzb;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private String zzF = "";
    private String zzG = "D";
    private String zzH = "";
    private long zzI;
    private long zzJ;
    private long zzK;
    private String zzL = "";
    private long zzM;
    private long zzN = -1;
    private long zzO = -1;
    private zzasl zzP;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private long zzV = -1;
    private String zzW = "D";
    private String zzX = "D";
    private long zzY = -1;
    private int zzZ = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzgyk zzaC = zzgxy.zzbK();
    private int zzaD = 1000;
    private zzgyk zzaE = zzgxy.zzbK();
    private zzase zzaF;
    private String zzaG = "";
    private long zzaH = -1;
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL;
    private long zzaM = -1;
    private String zzaN = "";
    private zzarw zzaO;
    private zzary zzaP;
    private long zzaQ = -1;
    private long zzaR = -1;
    private int zzaS;
    private long zzaT;
    private String zzaU = "";
    private int zzaV = 2;
    private boolean zzaW;
    private String zzaX = "";
    private long zzaY;
    private zzass zzaZ;
    private int zzaa = 1000;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private long zzaf = -1;
    private int zzag = 1000;
    private zzasg zzah;
    /* access modifiers changed from: private */
    public zzgyk zzai = zzgxy.zzbK();
    private zzasi zzaj;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private long zzar = -1;
    private String zzas = "D";
    private long zzat = -1;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzasu zzax;
    private long zzay = -1;
    private int zzaz = 1000;
    private long zzba = -1;
    private String zzbb = "";
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzu;
    private String zzv = "";
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzasj zzasj = new zzasj();
        zza = zzasj;
        zzgxy.zzcb(zzasj.class, zzasj);
    }

    private zzasj() {
    }

    public static /* synthetic */ void zzA(zzasj zzasj, long j) {
        zzasj.zzc |= 134217728;
        zzasj.zzK = j;
    }

    public static /* synthetic */ void zzB(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzc |= 268435456;
        zzasj.zzL = str;
    }

    public static /* synthetic */ void zzC(zzasj zzasj, long j) {
        zzasj.zzc |= 536870912;
        zzasj.zzM = j;
    }

    public static /* synthetic */ void zzD(zzasj zzasj, long j) {
        zzasj.zzc |= Ints.MAX_POWER_OF_TWO;
        zzasj.zzN = j;
    }

    public static /* synthetic */ void zzE(zzasj zzasj, long j) {
        zzasj.zzc |= Integer.MIN_VALUE;
        zzasj.zzO = j;
    }

    public static /* synthetic */ void zzF(zzasj zzasj, long j) {
        zzasj.zzd |= 2;
        zzasj.zzQ = j;
    }

    public static /* synthetic */ void zzG(zzasj zzasj, long j) {
        zzasj.zzd |= 4;
        zzasj.zzR = j;
    }

    public static /* synthetic */ void zzH(zzasj zzasj, long j) {
        zzasj.zzd |= 8;
        zzasj.zzS = j;
    }

    public static /* synthetic */ void zzI(zzasj zzasj, long j) {
        zzasj.zzd |= 16;
        zzasj.zzT = j;
    }

    public static /* synthetic */ void zzJ(zzasj zzasj, long j) {
        zzasj.zzd |= 32;
        zzasj.zzU = j;
    }

    public static /* synthetic */ void zzK(zzasj zzasj, long j) {
        zzasj.zzd |= 64;
        zzasj.zzV = j;
    }

    public static /* synthetic */ void zzL(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzd |= 128;
        zzasj.zzW = str;
    }

    public static /* synthetic */ void zzM(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzd |= 256;
        zzasj.zzX = str;
    }

    public static /* synthetic */ void zzN(zzasj zzasj, long j) {
        zzasj.zzd |= 4096;
        zzasj.zzab = j;
    }

    public static /* synthetic */ void zzO(zzasj zzasj, long j) {
        zzasj.zzd |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
        zzasj.zzac = j;
    }

    public static /* synthetic */ void zzP(zzasj zzasj, long j) {
        zzasj.zzd |= 16384;
        zzasj.zzad = j;
    }

    public static /* synthetic */ void zzQ(zzasj zzasj, zzasg zzasg) {
        zzasg.getClass();
        zzasj.zzah = zzasg;
        zzasj.zzd |= 262144;
    }

    public static /* synthetic */ void zzR(zzasj zzasj, zzasg zzasg) {
        zzasg.getClass();
        zzgyk zzgyk = zzasj.zzai;
        if (!zzgyk.zzc()) {
            zzasj.zzai = zzgxy.zzbL(zzgyk);
        }
        zzasj.zzai.add(zzasg);
    }

    public static /* synthetic */ void zzT(zzasj zzasj, zzasi zzasi) {
        zzasi.getClass();
        zzasj.zzaj = zzasi;
        zzasj.zzd |= 524288;
    }

    public static /* synthetic */ void zzU(zzasj zzasj, long j) {
        zzasj.zzd |= 2097152;
        zzasj.zzal = j;
    }

    public static /* synthetic */ void zzV(zzasj zzasj, long j) {
        zzasj.zzd |= 4194304;
        zzasj.zzam = j;
    }

    public static /* synthetic */ void zzW(zzasj zzasj, long j) {
        zzasj.zzd |= 8388608;
        zzasj.zzan = j;
    }

    public static /* synthetic */ void zzX(zzasj zzasj, long j) {
        zzasj.zzd |= 67108864;
        zzasj.zzaq = j;
    }

    public static /* synthetic */ void zzY(zzasj zzasj, long j) {
        zzasj.zzd |= 134217728;
        zzasj.zzar = j;
    }

    public static /* synthetic */ void zzZ(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzd |= 268435456;
        zzasj.zzas = str;
    }

    public static zzaro zza() {
        return (zzaro) zza.zzaZ();
    }

    public static /* synthetic */ void zzaa(zzasj zzasj, long j) {
        zzasj.zze |= AdRequest.MAX_CONTENT_URL_LENGTH;
        zzasj.zzaH = j;
    }

    public static /* synthetic */ void zzab(zzasj zzasj, long j) {
        zzasj.zze |= UserMetadata.MAX_ATTRIBUTE_SIZE;
        zzasj.zzaI = j;
    }

    public static /* synthetic */ void zzac(zzasj zzasj, long j) {
        zzasj.zze |= 2048;
        zzasj.zzaJ = j;
    }

    public static /* synthetic */ void zzad(zzasj zzasj, long j) {
        zzasj.zze |= 4096;
        zzasj.zzaK = j;
    }

    public static /* synthetic */ void zzae(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zze |= 32768;
        zzasj.zzaN = str;
    }

    public static /* synthetic */ void zzaf(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zze |= 4194304;
        zzasj.zzaU = str;
    }

    public static /* synthetic */ void zzag(zzasj zzasj, boolean z) {
        zzasj.zze |= 16777216;
        zzasj.zzaW = z;
    }

    public static /* synthetic */ void zzah(zzasj zzasj, long j) {
        zzasj.zze |= 67108864;
        zzasj.zzaY = j;
    }

    public static /* synthetic */ void zzam(zzasj zzasj, int i) {
        zzasj.zzZ = i - 1;
        zzasj.zzd |= UserMetadata.MAX_ATTRIBUTE_SIZE;
    }

    public static /* synthetic */ void zzan(zzasj zzasj, int i) {
        zzasj.zzaa = i - 1;
        zzasj.zzd |= 2048;
    }

    public static /* synthetic */ void zzao(zzasj zzasj, int i) {
        zzasj.zzag = i - 1;
        zzasj.zzd |= 131072;
    }

    public static /* synthetic */ void zzap(zzasj zzasj, int i) {
        zzasj.zzaz = i - 1;
        zzasj.zze |= 8;
    }

    public static /* synthetic */ void zzaq(zzasj zzasj, int i) {
        zzasj.zzaA = i - 1;
        zzasj.zze |= 16;
    }

    public static /* synthetic */ void zzar(zzasj zzasj, int i) {
        zzasj.zzaS = i - 1;
        zzasj.zze |= 1048576;
    }

    public static /* synthetic */ void zzas(zzasj zzasj, int i) {
        zzasj.zzaV = 5;
        zzasj.zze |= 8388608;
    }

    public static zzasj zzd() {
        return zza;
    }

    public static zzasj zze(byte[] bArr, zzgxi zzgxi) throws zzgyn {
        return (zzasj) zzgxy.zzbx(zza, bArr, zzgxi);
    }

    public static /* synthetic */ void zzi(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzc |= 1;
        zzasj.zzf = str;
    }

    public static /* synthetic */ void zzj(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzc |= 2;
        zzasj.zzg = str;
    }

    public static /* synthetic */ void zzk(zzasj zzasj, long j) {
        zzasj.zzc |= 4;
        zzasj.zzh = j;
    }

    public static /* synthetic */ void zzl(zzasj zzasj, long j) {
        zzasj.zzc |= 16;
        zzasj.zzj = j;
    }

    public static /* synthetic */ void zzm(zzasj zzasj, long j) {
        zzasj.zzc |= 32;
        zzasj.zzk = j;
    }

    public static /* synthetic */ void zzn(zzasj zzasj, long j) {
        zzasj.zzc |= UserMetadata.MAX_ATTRIBUTE_SIZE;
        zzasj.zzp = j;
    }

    public static /* synthetic */ void zzo(zzasj zzasj, long j) {
        zzasj.zzc |= 2048;
        zzasj.zzu = j;
    }

    public static /* synthetic */ void zzp(zzasj zzasj, long j) {
        zzasj.zzc |= UserMetadata.MAX_INTERNAL_KEY_SIZE;
        zzasj.zzw = j;
    }

    public static /* synthetic */ void zzq(zzasj zzasj, long j) {
        zzasj.zzc |= 16384;
        zzasj.zzx = j;
    }

    public static /* synthetic */ void zzr(zzasj zzasj, long j) {
        zzasj.zzc |= 32768;
        zzasj.zzy = j;
    }

    public static /* synthetic */ void zzs(zzasj zzasj, long j) {
        zzasj.zzc |= 65536;
        zzasj.zzz = j;
    }

    public static /* synthetic */ void zzt(zzasj zzasj, long j) {
        zzasj.zzc |= 524288;
        zzasj.zzC = j;
    }

    public static /* synthetic */ void zzu(zzasj zzasj, long j) {
        zzasj.zzc |= 1048576;
        zzasj.zzD = j;
    }

    public static /* synthetic */ void zzv(zzasj zzasj, long j) {
        zzasj.zzc |= 2097152;
        zzasj.zzE = j;
    }

    public static /* synthetic */ void zzw(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzc |= 4194304;
        zzasj.zzF = str;
    }

    public static /* synthetic */ void zzx(zzasj zzasj, String str) {
        str.getClass();
        zzasj.zzc |= 16777216;
        zzasj.zzH = str;
    }

    public static /* synthetic */ void zzy(zzasj zzasj, long j) {
        zzasj.zzc |= 33554432;
        zzasj.zzI = j;
    }

    public static /* synthetic */ void zzz(zzasj zzasj, long j) {
        zzasj.zzc |= 67108864;
        zzasj.zzJ = j;
    }

    public final boolean zzai() {
        return this.zzaW;
    }

    public final boolean zzaj() {
        if ((this.zzc & 4194304) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzak() {
        if ((this.zze & 134217728) != 0) {
            return true;
        }
        return false;
    }

    public final int zzal() {
        int zza2 = zzart.zza(this.zzaV);
        if (zza2 == 0) {
            return 3;
        }
        return zza2;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                zzgye zzgye = zzasp.zza;
                return zzgxy.zzbS(zza, "\u0001a\u0000\u0003\u0001Įa\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂU\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈV\u0019ဂZ\u001a᠌W\u001bဈ\u0016\u001cဇX\u001dဈ\u0018\u001eဈY\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌@EဉAFဂBGဂ8Hဂ9I᠌CJဂ)Kဈ\u0017L᠌DMဈEN\u001bO᠌FP\u001bQဉGRဈHSဂITဂJUဂKVဂLWဂMXဂNYဈOZဉP[ဉQ\\ဂR]ဂS^᠌TÉဉ[ĭဂ\\Įဈ]", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzaT", "zzD", "zzE", "zzaU", "zzaY", "zzaV", zzars.zza, "zzF", "zzaW", "zzH", "zzaX", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzai", zzasg.class, "zzU", "zzV", "zzW", "zzX", "zzZ", zzgye, "zzaa", zzgye, "zzah", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", zzgye, "zzaj", "zzak", "zzal", "zzam", "zzan", "zzaq", "zzar", "zzat", "zzau", zzaso.zza, "zzav", zzasq.zza, "zzas", "zzaw", zzarp.zza, "zzax", "zzay", "zzao", "zzap", "zzaz", zzgye, "zzY", "zzG", "zzaA", zzgye, "zzaB", "zzaC", zzasc.class, "zzaD", zzgye, "zzaE", zzarr.class, "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaN", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", zzarz.zza, "zzaZ", "zzba", "zzbb"});
            case 3:
                return new zzasj();
            case 4:
                return new zzaro((zzarn) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzasj.class) {
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

    public final zzass zzf() {
        zzass zzass = this.zzaZ;
        if (zzass == null) {
            return zzass.zzd();
        }
        return zzass;
    }

    public final String zzg() {
        return this.zzaU;
    }

    public final String zzh() {
        return this.zzF;
    }
}
