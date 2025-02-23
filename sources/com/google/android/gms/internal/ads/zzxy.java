package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzxy extends zzyb {
    public abstract Pair zzd(zzxx zzxx, int[][][] iArr, int[] iArr2, zzui zzui, zzcc zzcc) throws zzhw;

    public final zzyc zzo(zzlh[] zzlhArr, zzwi zzwi, zzui zzui, zzcc zzcc) throws zzhw {
        boolean z;
        boolean z2;
        zzfxr zzfxr;
        int[] iArr;
        boolean z3;
        zzwi zzwi2 = zzwi;
        int[] iArr2 = new int[3];
        zzcd[][] zzcdArr = new zzcd[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzwi2.zzb;
            zzcdArr[i] = new zzcd[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzlhArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzwi2.zzb) {
            zzcd zzb = zzwi2.zzb(i5);
            int i6 = zzb.zzc;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z4 = true;
            while (i8 < i3) {
                zzlh zzlh = zzlhArr[i8];
                int i10 = 0;
                for (int i11 = 0; i11 < zzb.zza; i11++) {
                    i10 = Math.max(i10, zzlh.zzY(zzb.zzb(i11)) & 7);
                }
                if (iArr2[i8] == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (i10 > i9) {
                    z4 = z3;
                    i7 = i8;
                    i9 = i10;
                } else if (i10 == i9 && i6 == 5 && !z4 && z3) {
                    i7 = i8;
                    i9 = i10;
                    z4 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                iArr = new int[zzb.zza];
            } else {
                zzlh zzlh2 = zzlhArr[i7];
                int[] iArr5 = new int[zzb.zza];
                for (int i12 = 0; i12 < zzb.zza; i12++) {
                    iArr5[i12] = zzlh2.zzY(zzb.zzb(i12));
                }
                iArr = iArr5;
            }
            int i13 = iArr2[i7];
            zzcdArr[i7][i13] = zzb;
            iArr3[i7][i13] = iArr;
            iArr2[i7] = i13 + 1;
            i5++;
            i3 = 2;
        }
        int i14 = i3;
        boolean z5 = true;
        zzwi[] zzwiArr = new zzwi[i14];
        String[] strArr = new String[i14];
        int[] iArr6 = new int[i14];
        int i15 = 0;
        while (i15 < i14) {
            int i16 = iArr2[i15];
            zzwiArr[i15] = new zzwi((zzcd[]) zzet.zzP(zzcdArr[i15], i16));
            iArr3[i15] = (int[][]) zzet.zzP(iArr3[i15], i16);
            strArr[i15] = zzlhArr[i15].zzU();
            iArr6[i15] = zzlhArr[i15].zzb();
            i15++;
            i14 = 2;
        }
        int i17 = i14;
        int[] iArr7 = iArr4;
        int[][][] iArr8 = iArr3;
        zzxx zzxx = new zzxx(strArr, iArr6, zzwiArr, iArr7, iArr8, new zzwi((zzcd[]) zzet.zzP(zzcdArr[i17], iArr2[i17])));
        Pair zzd = zzd(zzxx, iArr3, iArr4, zzui, zzcc);
        zzxz[] zzxzArr = (zzxz[]) zzd.second;
        List[] listArr = new List[zzxzArr.length];
        for (int i18 = 0; i18 < zzxzArr.length; i18++) {
            zzxz zzxz = zzxzArr[i18];
            if (zzxz != null) {
                zzfxr = zzfxr.zzn(zzxz);
            } else {
                zzfxr = zzfxr.zzm();
            }
            listArr[i18] = zzfxr;
        }
        zzfxo zzfxo = new zzfxo();
        int i19 = 0;
        while (i19 < 2) {
            zzwi zzd2 = zzxx.zzd(i19);
            List list = listArr[i19];
            int i20 = 0;
            while (i20 < zzd2.zzb) {
                zzcd zzb2 = zzd2.zzb(i20);
                if (zzxx.zza(i19, i20, false) != 0) {
                    z = z5;
                } else {
                    z = false;
                }
                int i21 = zzb2.zza;
                int[] iArr9 = new int[i21];
                boolean[] zArr = new boolean[i21];
                for (int i22 = 0; i22 < zzb2.zza; i22++) {
                    iArr9[i22] = zzxx.zzb(i19, i20, i22) & 7;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= list.size()) {
                            z2 = false;
                            break;
                        }
                        zzxz zzxz2 = (zzxz) list.get(i23);
                        if (zzxz2.zze().equals(zzb2) && zzxz2.zzb(i22) != -1) {
                            z2 = true;
                            break;
                        }
                        i23++;
                    }
                    zArr[i22] = z2;
                }
                zzfxo.zzf(new zzcj(zzb2, z, iArr9, zArr));
                i20++;
                z5 = true;
            }
            i19++;
            z5 = true;
        }
        zzwi zze = zzxx.zze();
        for (int i24 = 0; i24 < zze.zzb; i24++) {
            zzcd zzb3 = zze.zzb(i24);
            int[] iArr10 = new int[zzb3.zza];
            Arrays.fill(iArr10, 0);
            zzfxo.zzf(new zzcj(zzb3, false, iArr10, new boolean[zzb3.zza]));
        }
        return new zzyc((zzli[]) zzd.first, (zzxv[]) zzd.second, new zzck(zzfxo.zzi()), zzxx);
    }

    public final void zzp(Object obj) {
    }
}
