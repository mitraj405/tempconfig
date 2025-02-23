package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzxn extends zzxp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzxn(int i, zzcd zzcd, int i2, zzxi zzxi, int i3, String str) {
        super(i, zzcd, i2);
        boolean z;
        boolean z2;
        zzfxr zzfxr;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5 = 0;
        this.zzf = zzlf.zza(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzxi.zzv;
        if (1 != (i6 & 1)) {
            z = false;
        } else {
            z = true;
        }
        this.zzg = z;
        if ((i6 & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzh = z2;
        if (zzxi.zzt.isEmpty()) {
            zzfxr = zzfxr.zzn("");
        } else {
            zzfxr = zzxi.zzt;
        }
        int i8 = 0;
        while (true) {
            if (i8 >= zzfxr.size()) {
                i8 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
            i4 = zzxt.zzc(this.zzd, (String) zzfxr.get(i8), false);
            if (i4 > 0) {
                break;
            }
            i8++;
        }
        this.zzi = i8;
        this.zzj = i4;
        int zzb = zzxt.zzb(this.zzd.zzf, zzxi.zzu);
        this.zzk = zzb;
        if ((this.zzd.zzf & 1088) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzm = z3;
        if (zzxt.zzh(str) == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        int zzc = zzxt.zzc(this.zzd, str, z4);
        this.zzl = zzc;
        if (i4 > 0 || ((zzxi.zzt.isEmpty() && zzb > 0) || this.zzg || (this.zzh && zzc > 0))) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (zzlf.zza(i3, zzxi.zzN) && z5) {
            i5 = 1;
        }
        this.zze = i5;
    }

    /* renamed from: zza */
    public final int compareTo(zzxn zzxn) {
        zzfzc zzfzc;
        zzfxg zzd = zzfxg.zzj().zzd(this.zzf, zzxn.zzf).zzc(Integer.valueOf(this.zzi), Integer.valueOf(zzxn.zzi), zzfzc.zzc().zza()).zzb(this.zzj, zzxn.zzj).zzb(this.zzk, zzxn.zzk).zzd(this.zzg, zzxn.zzg);
        Boolean valueOf = Boolean.valueOf(this.zzh);
        Boolean valueOf2 = Boolean.valueOf(zzxn.zzh);
        if (this.zzj == 0) {
            zzfzc = zzfzc.zzc();
        } else {
            zzfzc = zzfzc.zzc().zza();
        }
        zzfxg zzb = zzd.zzc(valueOf, valueOf2, zzfzc).zzb(this.zzl, zzxn.zzl);
        if (this.zzk == 0) {
            zzb = zzb.zze(this.zzm, zzxn.zzm);
        }
        return zzb.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxp) {
        zzxn zzxn = (zzxn) zzxp;
        return false;
    }
}
