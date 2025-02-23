package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaf {
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    public final int zzG;
    private int zzH;
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final String zzj;
    public final zzbk zzk;
    public final String zzl;
    public final String zzm;
    public final int zzn;
    public final List zzo;
    public final zzy zzp;
    public final long zzq;
    public final int zzr;
    public final int zzs;
    public final float zzt;
    public final int zzu;
    public final float zzv;
    public final byte[] zzw;
    public final int zzx;
    public final zzo zzy;
    public final int zzz;

    static {
        new zzaf(new zzad());
        Integer.toString(0, 36);
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
        Integer.toString(32, 36);
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaf.class == obj.getClass()) {
            zzaf zzaf = (zzaf) obj;
            int i2 = this.zzH;
            if ((i2 == 0 || (i = zzaf.zzH) == 0 || i2 == i) && this.zze == zzaf.zze && this.zzf == zzaf.zzf && this.zzg == zzaf.zzg && this.zzh == zzaf.zzh && this.zzn == zzaf.zzn && this.zzq == zzaf.zzq && this.zzr == zzaf.zzr && this.zzs == zzaf.zzs && this.zzu == zzaf.zzu && this.zzx == zzaf.zzx && this.zzz == zzaf.zzz && this.zzA == zzaf.zzA && this.zzB == zzaf.zzB && this.zzC == zzaf.zzC && this.zzD == zzaf.zzD && this.zzE == zzaf.zzE && this.zzG == zzaf.zzG && Float.compare(this.zzt, zzaf.zzt) == 0 && Float.compare(this.zzv, zzaf.zzv) == 0 && zzet.zzG(this.zza, zzaf.zza) && zzet.zzG(this.zzb, zzaf.zzb) && this.zzc.equals(zzaf.zzc) && zzet.zzG(this.zzj, zzaf.zzj) && zzet.zzG(this.zzl, zzaf.zzl) && zzet.zzG(this.zzm, zzaf.zzm) && zzet.zzG(this.zzd, zzaf.zzd) && Arrays.equals(this.zzw, zzaf.zzw) && zzet.zzG(this.zzk, zzaf.zzk) && zzet.zzG(this.zzy, zzaf.zzy) && zzet.zzG(this.zzp, zzaf.zzp) && zzd(zzaf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzH;
        if (i7 != 0) {
            return i7;
        }
        String str = this.zza;
        int i8 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int hashCode = this.zzc.hashCode() + ((((i + 527) * 31) + i2) * 31);
        String str3 = this.zzd;
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = str3.hashCode();
        }
        int i9 = ((((((((((hashCode * 31) + i3) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31;
        String str4 = this.zzj;
        if (str4 == null) {
            i4 = 0;
        } else {
            i4 = str4.hashCode();
        }
        int i10 = (i9 + i4) * 31;
        zzbk zzbk = this.zzk;
        if (zzbk == null) {
            i5 = 0;
        } else {
            i5 = zzbk.hashCode();
        }
        int i11 = (i10 + i5) * 31;
        String str5 = this.zzl;
        if (str5 == null) {
            i6 = 0;
        } else {
            i6 = str5.hashCode();
        }
        int i12 = (i11 + i6) * 31;
        String str6 = this.zzm;
        if (str6 != null) {
            i8 = str6.hashCode();
        }
        int floatToIntBits = Float.floatToIntBits(this.zzt);
        int floatToIntBits2 = Float.floatToIntBits(this.zzv);
        int i13 = this.zzG + ((((((((((((((((((((floatToIntBits2 + ((((floatToIntBits + ((((((((((i12 + i8) * 31) + this.zzn) * 31) + ((int) this.zzq)) * 31) + this.zzr) * 31) + this.zzs) * 31)) * 31) + this.zzu) * 31)) * 31) + this.zzx) * 31) + this.zzz) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) - 1) * 31) - 1) * 31);
        this.zzH = i13;
        return i13;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzy);
        StringBuilder sb = new StringBuilder("Format(");
        sb.append(this.zza);
        sb.append(", ");
        sb.append(this.zzb);
        sb.append(", ");
        sb.append(this.zzl);
        sb.append(", ");
        sb.append(this.zzm);
        sb.append(", ");
        sb.append(this.zzj);
        sb.append(", ");
        sb.append(this.zzi);
        sb.append(", ");
        sb.append(this.zzd);
        sb.append(", [");
        sb.append(this.zzr);
        sb.append(", ");
        sb.append(this.zzs);
        sb.append(", ");
        sb.append(this.zzt);
        sb.append(", ");
        sb.append(valueOf);
        sb.append("], [");
        sb.append(this.zzz);
        sb.append(", ");
        return lf.k(sb, this.zzA, "])");
    }

    public final int zza() {
        int i;
        int i2 = this.zzr;
        if (i2 == -1 || (i = this.zzs) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final zzad zzb() {
        return new zzad(this, (zzac) null);
    }

    public final zzaf zzc(int i) {
        zzad zzad = new zzad(this, (zzac) null);
        zzad.zzC(i);
        return new zzaf(zzad);
    }

    public final boolean zzd(zzaf zzaf) {
        if (this.zzo.size() != zzaf.zzo.size()) {
            return false;
        }
        for (int i = 0; i < this.zzo.size(); i++) {
            if (!Arrays.equals((byte[]) this.zzo.get(i), (byte[]) zzaf.zzo.get(i))) {
                return false;
            }
        }
        return true;
    }

    private zzaf(zzad zzad) {
        boolean z;
        String str;
        this.zza = zzad.zza;
        String zzD2 = zzet.zzD(zzad.zzd);
        this.zzd = zzD2;
        int i = 0;
        if (zzad.zzc.isEmpty() && zzad.zzb != null) {
            this.zzc = zzfxr.zzn(new zzak(zzD2, zzad.zzb));
            this.zzb = zzad.zzb;
        } else if (zzad.zzc.isEmpty() || zzad.zzb != null) {
            if (!zzad.zzc.isEmpty() || zzad.zzb != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= zzad.zzc.size()) {
                        z = false;
                        break;
                    } else if (((zzak) zzad.zzc.get(i2)).zzb.equals(zzad.zzb)) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = true;
            zzdi.zzf(z);
            this.zzc = zzad.zzc;
            this.zzb = zzad.zzb;
        } else {
            this.zzc = zzad.zzc;
            List zzam = zzad.zzc;
            Iterator it = zzam.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzak) zzam.get(0)).zzb;
                    break;
                }
                zzak zzak = (zzak) it.next();
                if (TextUtils.equals(zzak.zza, zzD2)) {
                    str = zzak.zzb;
                    break;
                }
            }
            this.zzb = str;
        }
        this.zze = zzad.zze;
        this.zzf = zzad.zzf;
        int zzd2 = zzad.zzg;
        this.zzg = zzd2;
        int zzm2 = zzad.zzh;
        this.zzh = zzm2;
        this.zzi = zzm2 != -1 ? zzm2 : zzd2;
        this.zzj = zzad.zzi;
        this.zzk = zzad.zzj;
        this.zzl = zzad.zzk;
        this.zzm = zzad.zzl;
        this.zzn = zzad.zzm;
        this.zzo = zzad.zzn == null ? Collections.emptyList() : zzad.zzn;
        zzy zzv2 = zzad.zzo;
        this.zzp = zzv2;
        this.zzq = zzad.zzp;
        this.zzr = zzad.zzq;
        this.zzs = zzad.zzr;
        this.zzt = zzad.zzs;
        this.zzu = zzad.zzt == -1 ? 0 : zzad.zzt;
        this.zzv = zzad.zzu == -1.0f ? 1.0f : zzad.zzu;
        this.zzw = zzad.zzv;
        this.zzx = zzad.zzw;
        this.zzy = zzad.zzx;
        this.zzz = zzad.zzy;
        this.zzA = zzad.zzz;
        this.zzB = zzad.zzA;
        this.zzC = zzad.zzB == -1 ? 0 : zzad.zzB;
        this.zzD = zzad.zzC != -1 ? zzad.zzC : i;
        this.zzE = zzad.zzD;
        this.zzF = zzad.zzE;
        if (zzad.zzF != 0 || zzv2 == null) {
            this.zzG = zzad.zzF;
        } else {
            this.zzG = 1;
        }
    }
}
