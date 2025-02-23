package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzwp extends zzwr {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzwp(zzcd zzcd, int[] iArr, int i, zzyj zzyj, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzdj zzdj) {
        super(zzcd, iArr, 0);
        zzcd zzcd2 = zzcd;
        int[] iArr2 = iArr;
        zzfxr.zzk(list);
    }

    public static /* bridge */ /* synthetic */ zzfxr zzf(zzxu[] zzxuArr) {
        int i;
        int i2;
        zzfxr zzfxr;
        double d;
        long j;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 2;
            i2 = 1;
            if (i4 >= 2) {
                break;
            }
            zzxu zzxu = zzxuArr[i4];
            if (zzxu == null || zzxu.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzfxo zzfxo = new zzfxo();
                zzfxo.zzf(new zzwn(0, 0));
                arrayList.add(zzfxo);
            }
            i4++;
        }
        long[][] jArr = new long[2][];
        for (int i5 = 0; i5 < 2; i5++) {
            zzxu zzxu2 = zzxuArr[i5];
            if (zzxu2 == null) {
                jArr[i5] = new long[0];
            } else {
                jArr[i5] = new long[zzxu2.zzb.length];
                int i6 = 0;
                while (true) {
                    int[] iArr = zzxu2.zzb;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    long j2 = (long) zzxu2.zza.zzb(iArr[i6]).zzi;
                    long[] jArr2 = jArr[i5];
                    if (j2 == -1) {
                        j2 = 0;
                    }
                    jArr2[i6] = j2;
                    i6++;
                }
                Arrays.sort(jArr[i5]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            long[] jArr4 = jArr[i7];
            if (jArr4.length == 0) {
                j = 0;
            } else {
                j = jArr4[0];
            }
            jArr3[i7] = j;
        }
        zzg(arrayList, jArr3);
        zzfyc zza = zzfyx.zzc(zzfzc.zzc()).zzb(2).zza();
        int i8 = 0;
        while (i8 < i) {
            int length = jArr[i8].length;
            if (length > i2) {
                double[] dArr = new double[length];
                int i9 = i3;
                while (true) {
                    long[] jArr5 = jArr[i8];
                    double d2 = 0.0d;
                    if (i9 >= jArr5.length) {
                        break;
                    }
                    long j3 = jArr5[i9];
                    if (j3 != -1) {
                        d2 = Math.log((double) j3);
                    }
                    dArr[i9] = d2;
                    i9++;
                }
                int i10 = length - 1;
                double d3 = dArr[i10] - dArr[i3];
                int i11 = i3;
                while (i11 < i10) {
                    double d4 = dArr[i11];
                    i11++;
                    double d5 = d4 + dArr[i11];
                    if (d3 == 0.0d) {
                        d = 1.0d;
                    } else {
                        d = ((d5 * 0.5d) - dArr[i3]) / d3;
                    }
                    zza.zzq(Double.valueOf(d), Integer.valueOf(i8));
                    i3 = 0;
                }
            }
            i8++;
            i3 = 0;
            i = 2;
            i2 = 1;
        }
        zzfxr zzk = zzfxr.zzk(zza.zzr());
        for (int i12 = 0; i12 < zzk.size(); i12++) {
            int intValue = ((Integer) zzk.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr3[intValue] = jArr[intValue][i13];
            zzg(arrayList, jArr3);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j4 = jArr3[i14];
                jArr3[i14] = j4 + j4;
            }
        }
        zzg(arrayList, jArr3);
        zzfxo zzfxo2 = new zzfxo();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzfxo zzfxo3 = (zzfxo) arrayList.get(i15);
            if (zzfxo3 == null) {
                zzfxr = zzfxr.zzm();
            } else {
                zzfxr = zzfxo3.zzi();
            }
            zzfxo2.zzf(zzfxr);
        }
        return zzfxo2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfxo zzfxo = (zzfxo) list.get(i2);
            if (zzfxo != null) {
                zzfxo.zzf(new zzwn(j, jArr[i2]));
            }
        }
    }
}
