package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzci {
    public final zzfxu zzA;
    public final zzfxw zzB;
    public final int zza = Integer.MAX_VALUE;
    public final int zzb = Integer.MAX_VALUE;
    public final int zzc = Integer.MAX_VALUE;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = 0;
    public final int zzf = 0;
    public final int zzg = 0;
    public final int zzh = 0;
    public final int zzi;
    public final int zzj;
    public final boolean zzk;
    public final zzfxr zzl;
    public final int zzm;
    public final zzfxr zzn;
    public final int zzo;
    public final int zzp;
    public final int zzq;
    public final zzfxr zzr;
    public final zzcg zzs;
    public final zzfxr zzt;
    public final int zzu;
    public final int zzv;
    public final boolean zzw;
    public final boolean zzx;
    public final boolean zzy;
    public final boolean zzz;

    static {
        new zzci(new zzch());
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
        Integer.toString(14, 36);
        Integer.toString(15, 36);
        Integer.toString(16, 36);
        Integer.toString(17, 36);
        Integer.toString(18, 36);
        Integer.toString(19, 36);
        Integer.toString(20, 36);
        Integer.toString(21, 36);
        Integer.toString(22, 36);
        Integer.toString(23, 36);
        Integer.toString(24, 36);
        Integer.toString(25, 36);
        Integer.toString(26, 36);
        Integer.toString(27, 36);
        Integer.toString(28, 36);
        Integer.toString(29, 36);
        Integer.toString(30, 36);
        Integer.toString(31, 36);
    }

    public zzci(zzch zzch) {
        this.zzi = zzch.zze;
        this.zzj = zzch.zzf;
        this.zzk = zzch.zzg;
        this.zzl = zzch.zzh;
        this.zzm = 0;
        this.zzn = zzch.zzi;
        this.zzo = 0;
        this.zzp = Integer.MAX_VALUE;
        this.zzq = Integer.MAX_VALUE;
        this.zzr = zzch.zzl;
        this.zzs = zzch.zzm;
        this.zzt = zzch.zzn;
        this.zzu = zzch.zzo;
        this.zzv = 0;
        this.zzw = false;
        this.zzx = false;
        this.zzy = false;
        this.zzz = false;
        this.zzA = zzfxu.zzc(zzch.zzp);
        this.zzB = zzfxw.zzl(zzch.zzq);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzci zzci = (zzci) obj;
            if (this.zzk != zzci.zzk || this.zzi != zzci.zzi || this.zzj != zzci.zzj || !this.zzl.equals(zzci.zzl) || !this.zzn.equals(zzci.zzn) || !this.zzr.equals(zzci.zzr) || !this.zzs.equals(zzci.zzs) || !this.zzt.equals(zzci.zzt) || this.zzu != zzci.zzu || !this.zzA.equals(zzci.zzA) || !this.zzB.equals(zzci.zzB)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.zzl.hashCode() + (((((((this.zzk ? 1 : 0) - true) * 31) + this.zzi) * 31) + this.zzj) * 31);
        int hashCode2 = this.zzn.hashCode();
        int hashCode3 = this.zzr.hashCode();
        int hashCode4 = ((this.zzt.hashCode() + ((((hashCode3 + ((((((hashCode2 + (hashCode * 961)) * 961) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31)) * 31) + 29791) * 31)) * 31) + this.zzu;
        int hashCode5 = this.zzA.hashCode() + (hashCode4 * 887503681);
        return this.zzB.hashCode() + (hashCode5 * 31);
    }
}
