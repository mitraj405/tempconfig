package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzxc extends zzxp implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzxi zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzxc(int i, zzcd zzcd, int i2, zzxi zzxi, int i3, boolean z, zzfuv zzfuv, int i4) {
        super(i, zzcd, i2);
        int i5;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        int i8;
        boolean z4;
        boolean z5;
        boolean z6;
        this.zzh = zzxi;
        int i9 = 1;
        if (true != zzxi.zzL) {
            i5 = 16;
        } else {
            i5 = 24;
        }
        this.zzg = zzxt.zzh(this.zzd.zzd);
        this.zzi = zzlf.zza(i3, false);
        int i10 = 0;
        while (true) {
            i6 = Integer.MAX_VALUE;
            if (i10 >= zzxi.zzn.size()) {
                i7 = 0;
                i10 = Integer.MAX_VALUE;
                break;
            }
            i7 = zzxt.zzc(this.zzd, (String) zzxi.zzn.get(i10), false);
            if (i7 > 0) {
                break;
            }
            i10++;
        }
        this.zzk = i10;
        this.zzj = i7;
        this.zzl = zzxt.zzb(this.zzd.zzf, 0);
        zzaf zzaf = this.zzd;
        int i11 = zzaf.zzf;
        if (i11 == 0 || (i11 & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzm = z2;
        if (1 != (zzaf.zze & 1)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.zzp = z3;
        this.zzq = zzaf.zzz;
        this.zzr = zzaf.zzA;
        this.zzs = zzaf.zzi;
        this.zzf = zzfuv.zza(zzaf);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] split = zzet.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i12 = 0; i12 < split.length; i12++) {
            split[i12] = zzet.zzD(split[i12]);
        }
        int i13 = 0;
        while (true) {
            if (i13 >= split.length) {
                i8 = 0;
                i13 = Integer.MAX_VALUE;
                break;
            }
            i8 = zzxt.zzc(this.zzd, split[i13], false);
            if (i8 > 0) {
                break;
            }
            i13++;
        }
        this.zzn = i13;
        this.zzo = i8;
        int i14 = 0;
        while (true) {
            if (i14 < zzxi.zzr.size()) {
                String str = this.zzd.zzm;
                if (str != null && str.equals(zzxi.zzr.get(i14))) {
                    i6 = i14;
                    break;
                }
                i14++;
            } else {
                break;
            }
        }
        this.zzt = i6;
        if ((i3 & 384) == 128) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzu = z4;
        if ((i3 & 64) == 64) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.zzv = z5;
        zzxi zzxi2 = this.zzh;
        if (!zzlf.zza(i3, zzxi2.zzN) || (!(z6 = this.zzf) && !zzxi2.zzG)) {
            i9 = 0;
        } else if (zzlf.zza(i3, false) && z6 && this.zzd.zzi != -1 && ((zzxi2.zzP || !z) && (i5 & i3) != 0)) {
            i9 = 2;
        }
        this.zze = i9;
    }

    /* renamed from: zza */
    public final int compareTo(zzxc zzxc) {
        zzfzc zzfzc;
        if (!this.zzf || !this.zzi) {
            zzfzc = zzxt.zzb.zza();
        } else {
            zzfzc = zzxt.zzb;
        }
        zzfxg zzc = zzfxg.zzj().zzd(this.zzi, zzxc.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzxc.zzk), zzfzc.zzc().zza()).zzb(this.zzj, zzxc.zzj).zzb(this.zzl, zzxc.zzl).zzd(this.zzp, zzxc.zzp).zzd(this.zzm, zzxc.zzm).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzxc.zzn), zzfzc.zzc().zza()).zzb(this.zzo, zzxc.zzo).zzd(this.zzf, zzxc.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzxc.zzt), zzfzc.zzc().zza());
        boolean z = this.zzh.zzy;
        zzfxg zzc2 = zzc.zzd(this.zzu, zzxc.zzu).zzd(this.zzv, zzxc.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzxc.zzq), zzfzc).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzxc.zzr), zzfzc);
        if (zzet.zzG(this.zzg, zzxc.zzg)) {
            zzc2 = zzc2.zzc(Integer.valueOf(this.zzs), Integer.valueOf(zzxc.zzs), zzfzc);
        }
        return zzc2.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzxp zzxp) {
        String str;
        zzxc zzxc = (zzxc) zzxp;
        boolean z = this.zzh.zzJ;
        zzaf zzaf = this.zzd;
        int i = zzaf.zzz;
        if (i == -1) {
            return false;
        }
        zzaf zzaf2 = zzxc.zzd;
        if (i != zzaf2.zzz || (str = zzaf.zzm) == null || !TextUtils.equals(str, zzaf2.zzm)) {
            return false;
        }
        boolean z2 = this.zzh.zzI;
        int i2 = this.zzd.zzA;
        if (i2 != -1 && i2 == zzxc.zzd.zzA && this.zzu == zzxc.zzu && this.zzv == zzxc.zzv) {
            return true;
        }
        return false;
    }
}
