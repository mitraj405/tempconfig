package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgxe implements zzhbh {
    private final zzgxd zza;

    private zzgxe(zzgxd zzgxd) {
        zzgyl.zzc(zzgxd, "output");
        this.zza = zzgxd;
        zzgxd.zze = this;
    }

    public static zzgxe zza(zzgxd zzgxd) {
        zzgxe zzgxe = zzgxd.zze;
        if (zzgxe != null) {
            return zzgxe;
        }
        return new zzgxe(zzgxd);
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    zzgyy.zza(i4);
                    i3 += 8;
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzk(zzgyy.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzj(i, zzgyy.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzB(int i, int i2) throws IOException {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxz.size(); i4++) {
                    int zzd = zzgxz.zzd(i4);
                    i3 += zzgxd.zzD((zzd >> 31) ^ (zzd + zzd));
                }
                this.zza.zzu(i3);
                while (i2 < zzgxz.size()) {
                    zzgxd zzgxd = this.zza;
                    int zzd2 = zzgxz.zzd(i2);
                    zzgxd.zzu((zzd2 >> 31) ^ (zzd2 + zzd2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxz.size()) {
                zzgxd zzgxd2 = this.zza;
                int zzd3 = zzgxz.zzd(i2);
                zzgxd2.zzt(i, (zzd3 >> 31) ^ (zzd3 + zzd3));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                int intValue = ((Integer) list.get(i6)).intValue();
                i5 += zzgxd.zzD((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                zzgxd zzgxd3 = this.zza;
                int intValue2 = ((Integer) list.get(i2)).intValue();
                zzgxd3.zzu((intValue2 >> 31) ^ (intValue2 + intValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzgxd zzgxd4 = this.zza;
                int intValue3 = ((Integer) list.get(i2)).intValue();
                zzgxd4.zzt(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                i2++;
            }
        }
    }

    public final void zzD(int i, long j) throws IOException {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    long zza2 = zzgyy.zza(i4);
                    i3 += zzgxd.zzE((zza2 >> 63) ^ (zza2 + zza2));
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    zzgxd zzgxd = this.zza;
                    long zza3 = zzgyy.zza(i2);
                    zzgxd.zzw((zza3 >> 63) ^ (zza3 + zza3));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                zzgxd zzgxd2 = this.zza;
                long zza4 = zzgyy.zza(i2);
                zzgxd2.zzv(i, (zza4 >> 63) ^ (zza4 + zza4));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                long longValue = ((Long) list.get(i6)).longValue();
                i5 += zzgxd.zzE((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                zzgxd zzgxd3 = this.zza;
                long longValue2 = ((Long) list.get(i2)).longValue();
                zzgxd3.zzw((longValue2 >> 63) ^ (longValue2 + longValue2));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                zzgxd zzgxd4 = this.zza;
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzgxd4.zzv(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    @Deprecated
    public final void zzF(int i) throws IOException {
        this.zza.zzs(i, 3);
    }

    public final void zzG(int i, String str) throws IOException {
        this.zza.zzq(i, str);
    }

    public final void zzH(int i, List list) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyv) {
            zzgyv zzgyv = (zzgyv) list;
            while (i2 < list.size()) {
                Object zzc = zzgyv.zzc();
                if (zzc instanceof String) {
                    this.zza.zzq(i, (String) zzc);
                } else {
                    this.zza.zzO(i, (zzgwm) zzc);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzq(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzI(int i, int i2) throws IOException {
        this.zza.zzt(i, i2);
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxz.size(); i4++) {
                    i3 += zzgxd.zzD(zzgxz.zzd(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgxz.size()) {
                    this.zza.zzu(zzgxz.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxz.size()) {
                this.zza.zzt(i, zzgxz.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgxd.zzD(((Integer) list.get(i6)).intValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzK(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    i3 += zzgxd.zzE(zzgyy.zza(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzw(zzgyy.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzv(i, zzgyy.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgxd.zzE(((Long) list.get(i6)).longValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zza.zzN(i, z);
    }

    public final void zzc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgwc) {
            zzgwc zzgwc = (zzgwc) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgwc.size(); i4++) {
                    zzgwc.zzh(i4);
                    i3++;
                }
                this.zza.zzu(i3);
                while (i2 < zzgwc.size()) {
                    this.zza.zzM(zzgwc.zzh(i2) ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < zzgwc.size()) {
                this.zza.zzN(i, zzgwc.zzh(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Boolean) list.get(i6)).booleanValue();
                i5++;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzM(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : 0);
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzN(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
        }
    }

    public final void zzd(int i, zzgwm zzgwm) throws IOException {
        this.zza.zzO(i, zzgwm);
    }

    public final void zze(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzO(i, (zzgwm) list.get(i2));
        }
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxf) {
            zzgxf zzgxf = (zzgxf) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxf.size(); i4++) {
                    zzgxf.zzd(i4);
                    i3 += 8;
                }
                this.zza.zzu(i3);
                while (i2 < zzgxf.size()) {
                    this.zza.zzk(Double.doubleToRawLongBits(zzgxf.zzd(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxf.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(zzgxf.zzd(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Double) list.get(i6)).doubleValue();
                i5 += 8;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    @Deprecated
    public final void zzh(int i) throws IOException {
        this.zza.zzs(i, 4);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxz.size(); i4++) {
                    i3 += zzgxd.zzE((long) zzgxz.zzd(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgxz.size()) {
                    this.zza.zzm(zzgxz.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxz.size()) {
                this.zza.zzl(i, zzgxz.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgxd.zzE((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxz.size(); i4++) {
                    zzgxz.zzd(i4);
                    i3 += 4;
                }
                this.zza.zzu(i3);
                while (i2 < zzgxz.size()) {
                    this.zza.zzi(zzgxz.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxz.size()) {
                this.zza.zzh(i, zzgxz.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzm(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }

    public final void zzn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    zzgyy.zza(i4);
                    i3 += 8;
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzk(zzgyy.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzj(i, zzgyy.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Long) list.get(i6)).longValue();
                i5 += 8;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzk(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzo(int i, float f) throws IOException {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zzp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxp) {
            zzgxp zzgxp = (zzgxp) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxp.size(); i4++) {
                    zzgxp.zzd(i4);
                    i3 += 4;
                }
                this.zza.zzu(i3);
                while (i2 < zzgxp.size()) {
                    this.zza.zzi(Float.floatToRawIntBits(zzgxp.zzd(i2)));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxp.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(zzgxp.zzd(i2)));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Float) list.get(i6)).floatValue();
                i5 += 4;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    public final void zzq(int i, Object obj, zzhae zzhae) throws IOException {
        zzgxd zzgxd = this.zza;
        zzgxd.zzs(i, 3);
        zzhae.zzj((zzgzj) obj, zzgxd.zze);
        zzgxd.zzs(i, 4);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zza.zzl(i, i2);
    }

    public final void zzs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxz.size(); i4++) {
                    i3 += zzgxd.zzE((long) zzgxz.zzd(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgxz.size()) {
                    this.zza.zzm(zzgxz.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxz.size()) {
                this.zza.zzl(i, zzgxz.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgxd.zzE((long) ((Integer) list.get(i6)).intValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzt(int i, long j) throws IOException {
        this.zza.zzv(i, j);
    }

    public final void zzu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgyy) {
            zzgyy zzgyy = (zzgyy) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgyy.size(); i4++) {
                    i3 += zzgxd.zzE(zzgyy.zza(i4));
                }
                this.zza.zzu(i3);
                while (i2 < zzgyy.size()) {
                    this.zza.zzw(zzgyy.zza(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgyy.size()) {
                this.zza.zzv(i, zzgyy.zza(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                i5 += zzgxd.zzE(((Long) list.get(i6)).longValue());
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzw(((Long) list.get(i2)).longValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public final void zzv(int i, Object obj, zzhae zzhae) throws IOException {
        this.zza.zzn(i, (zzgzj) obj, zzhae);
    }

    public final void zzw(int i, Object obj) throws IOException {
        if (obj instanceof zzgwm) {
            this.zza.zzp(i, (zzgwm) obj);
        } else {
            this.zza.zzo(i, (zzgzj) obj);
        }
    }

    public final void zzx(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (list instanceof zzgxz) {
            zzgxz zzgxz = (zzgxz) list;
            if (z) {
                this.zza.zzs(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < zzgxz.size(); i4++) {
                    zzgxz.zzd(i4);
                    i3 += 4;
                }
                this.zza.zzu(i3);
                while (i2 < zzgxz.size()) {
                    this.zza.zzi(zzgxz.zzd(i2));
                    i2++;
                }
                return;
            }
            while (i2 < zzgxz.size()) {
                this.zza.zzh(i, zzgxz.zzd(i2));
                i2++;
            }
        } else if (z) {
            this.zza.zzs(i, 2);
            int i5 = 0;
            for (int i6 = 0; i6 < list.size(); i6++) {
                ((Integer) list.get(i6)).intValue();
                i5 += 4;
            }
            this.zza.zzu(i5);
            while (i2 < list.size()) {
                this.zza.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
        } else {
            while (i2 < list.size()) {
                this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
    }

    public final void zzz(int i, long j) throws IOException {
        this.zza.zzj(i, j);
    }
}
