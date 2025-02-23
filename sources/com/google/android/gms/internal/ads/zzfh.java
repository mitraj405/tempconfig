package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfh {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        boolean z2;
        boolean z3;
        int i3 = i2 - i;
        boolean z4 = false;
        if (i3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i - 3;
        } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzf(zArr);
            return i - 2;
        } else if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                byte b = bArr[i5];
                if ((b & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                        zzf(zArr);
                        return i6;
                    }
                    i5 = i6;
                }
                i5 += 3;
            }
            if (i3 <= 2 ? i3 != 2 ? !zArr[1] || bArr[i4] != 1 : !(zArr[2] && bArr[i2 - 2] == 0 && bArr[i4] == 1) : !(bArr[i2 - 3] == 0 && bArr[i2 - 2] == 0 && bArr[i4] == 1)) {
                z2 = false;
            } else {
                z2 = true;
            }
            zArr[0] = z2;
            if (i3 <= 1 ? !zArr[2] || bArr[i4] != 0 : !(bArr[i2 - 2] == 0 && bArr[i4] == 0)) {
                z3 = false;
            } else {
                z3 = true;
            }
            zArr[1] = z3;
            if (bArr[i4] == 0) {
                z4 = true;
            }
            zArr[2] = z4;
            return i2;
        } else {
            zzf(zArr);
            return i - 1;
        }
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    int i5 = i3 + 1;
                    if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                        break;
                    }
                    i3 = i5;
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (i6 < i4) {
                try {
                    int i9 = zzd[i6] - i7;
                    System.arraycopy(bArr, i7, bArr, i8, i9);
                    int i10 = i8 + i9;
                    int i11 = i10 + 1;
                    bArr[i10] = 0;
                    i8 = i11 + 1;
                    bArr[i11] = 0;
                    i7 += i9 + 3;
                    i6++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            System.arraycopy(bArr, i7, bArr, i8, i2 - i8);
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0347  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfe zzc(byte[] r29, int r30, int r31) {
        /*
            com.google.android.gms.internal.ads.zzfi r0 = new com.google.android.gms.internal.ads.zzfi
            r1 = r29
            r2 = r30
            r3 = r31
            r0.<init>(r1, r2, r3)
            r1 = 4
            r0.zze(r1)
            r2 = 3
            int r3 = r0.zza(r2)
            r0.zzd()
            r4 = 2
            int r6 = r0.zza(r4)
            boolean r7 = r0.zzf()
            r5 = 5
            int r8 = r0.zza(r5)
            r5 = 0
            r9 = 0
            r10 = r5
        L_0x0028:
            r5 = 32
            r11 = 1
            if (r9 >= r5) goto L_0x0039
            boolean r5 = r0.zzf()
            if (r5 == 0) goto L_0x0036
            int r5 = r11 << r9
            r10 = r10 | r5
        L_0x0036:
            int r9 = r9 + 1
            goto L_0x0028
        L_0x0039:
            r5 = 6
            int[] r13 = new int[r5]
            r9 = 0
        L_0x003d:
            r12 = 8
            if (r9 >= r5) goto L_0x004a
            int r12 = r0.zza(r12)
            r13[r9] = r12
            int r9 = r9 + 1
            goto L_0x003d
        L_0x004a:
            int r14 = r0.zza(r12)
            r9 = 0
            r15 = 0
        L_0x0050:
            if (r15 >= r3) goto L_0x0065
            boolean r16 = r0.zzf()
            if (r16 == 0) goto L_0x005a
            int r9 = r9 + 89
        L_0x005a:
            boolean r16 = r0.zzf()
            if (r16 == 0) goto L_0x0062
            int r9 = r9 + 8
        L_0x0062:
            int r15 = r15 + 1
            goto L_0x0050
        L_0x0065:
            r0.zze(r9)
            if (r3 <= 0) goto L_0x0070
            int r9 = 8 - r3
            int r9 = r9 + r9
            r0.zze(r9)
        L_0x0070:
            int r15 = r0.zzc()
            int r9 = r0.zzc()
            if (r9 != r2) goto L_0x007e
            r0.zzd()
            r9 = r2
        L_0x007e:
            int r16 = r0.zzc()
            int r17 = r0.zzc()
            boolean r18 = r0.zzf()
            if (r18 == 0) goto L_0x00bc
            int r18 = r0.zzc()
            int r19 = r0.zzc()
            int r20 = r0.zzc()
            int r21 = r0.zzc()
            if (r9 == r11) goto L_0x00a7
            if (r9 != r4) goto L_0x00a4
            r9 = r4
            r22 = r9
            goto L_0x00a9
        L_0x00a4:
            r22 = r11
            goto L_0x00a9
        L_0x00a7:
            r22 = r4
        L_0x00a9:
            if (r9 != r11) goto L_0x00ae
            r23 = r4
            goto L_0x00b0
        L_0x00ae:
            r23 = r11
        L_0x00b0:
            int r18 = r18 + r19
            int r18 = r18 * r22
            int r16 = r16 - r18
            int r20 = r20 + r21
            int r20 = r20 * r23
            int r17 = r17 - r20
        L_0x00bc:
            r28 = r16
            r16 = r9
            r9 = r17
            r17 = r28
            int r18 = r0.zzc()
            int r19 = r0.zzc()
            int r20 = r0.zzc()
            boolean r1 = r0.zzf()
            if (r11 == r1) goto L_0x00d8
            r1 = r3
            goto L_0x00d9
        L_0x00d8:
            r1 = 0
        L_0x00d9:
            if (r1 > r3) goto L_0x00e7
            r0.zzc()
            r0.zzc()
            r0.zzc()
            int r1 = r1 + 1
            goto L_0x00d9
        L_0x00e7:
            r0.zzc()
            r0.zzc()
            r0.zzc()
            r0.zzc()
            r0.zzc()
            r0.zzc()
            boolean r1 = r0.zzf()
            if (r1 == 0) goto L_0x0141
            boolean r1 = r0.zzf()
            if (r1 == 0) goto L_0x0141
            r1 = 0
            r3 = 4
        L_0x0107:
            if (r1 >= r3) goto L_0x0141
            r3 = 0
        L_0x010a:
            if (r3 >= r5) goto L_0x013a
            boolean r5 = r0.zzf()
            if (r5 != 0) goto L_0x0116
            r0.zzc()
            goto L_0x0130
        L_0x0116:
            int r5 = r1 + r1
            int r5 = r5 + 4
            int r5 = r11 << r5
            r12 = 64
            int r5 = java.lang.Math.min(r12, r5)
            if (r1 <= r11) goto L_0x0127
            r0.zzb()
        L_0x0127:
            r12 = 0
        L_0x0128:
            if (r12 >= r5) goto L_0x0130
            r0.zzb()
            int r12 = r12 + 1
            goto L_0x0128
        L_0x0130:
            if (r1 != r2) goto L_0x0134
            r5 = r2
            goto L_0x0135
        L_0x0134:
            r5 = r11
        L_0x0135:
            int r3 = r3 + r5
            r5 = 6
            r12 = 8
            goto L_0x010a
        L_0x013a:
            int r1 = r1 + 1
            r3 = 4
            r5 = 6
            r12 = 8
            goto L_0x0107
        L_0x0141:
            r0.zze(r4)
            boolean r1 = r0.zzf()
            if (r1 == 0) goto L_0x0158
            r1 = 8
            r0.zze(r1)
            r0.zzc()
            r0.zzc()
            r0.zzd()
        L_0x0158:
            int r1 = r0.zzc()
            r2 = 0
            int[] r3 = new int[r2]
            int[] r4 = new int[r2]
            r11 = -1
            r12 = -1
        L_0x0163:
            if (r2 >= r1) goto L_0x0297
            if (r2 == 0) goto L_0x023b
            boolean r21 = r0.zzf()
            if (r21 == 0) goto L_0x023b
            int r5 = r11 + r12
            boolean r21 = r0.zzf()
            int r22 = r0.zzc()
            int r22 = r22 + 1
            int r21 = r21 + r21
            int r21 = 1 - r21
            r30 = r1
            int r1 = r5 + 1
            r31 = r15
            boolean[] r15 = new boolean[r1]
            r23 = 0
            r24 = r14
            r14 = r23
        L_0x018b:
            if (r14 > r5) goto L_0x01a1
            boolean r23 = r0.zzf()
            if (r23 != 0) goto L_0x019a
            boolean r23 = r0.zzf()
            r15[r14] = r23
            goto L_0x019e
        L_0x019a:
            r23 = 1
            r15[r14] = r23
        L_0x019e:
            int r14 = r14 + 1
            goto L_0x018b
        L_0x01a1:
            int r14 = r12 + -1
            r23 = r14
            int[] r14 = new int[r1]
            int[] r1 = new int[r1]
            r25 = 0
        L_0x01ab:
            int r26 = r21 * r22
            if (r23 < 0) goto L_0x01c4
            r27 = r4[r23]
            int r27 = r27 + r26
            if (r27 >= 0) goto L_0x01c1
            int r26 = r11 + r23
            boolean r26 = r15[r26]
            if (r26 == 0) goto L_0x01c1
            int r26 = r25 + 1
            r14[r25] = r27
            r25 = r26
        L_0x01c1:
            int r23 = r23 + -1
            goto L_0x01ab
        L_0x01c4:
            if (r26 >= 0) goto L_0x01d0
            boolean r21 = r15[r5]
            if (r21 == 0) goto L_0x01d0
            int r21 = r25 + 1
            r14[r25] = r26
            r25 = r21
        L_0x01d0:
            r21 = 0
            r22 = r13
            r13 = r21
            r21 = r10
            r10 = r25
        L_0x01da:
            if (r13 >= r11) goto L_0x01ef
            r23 = r3[r13]
            int r23 = r23 + r26
            if (r23 >= 0) goto L_0x01ec
            boolean r25 = r15[r13]
            if (r25 == 0) goto L_0x01ec
            int r25 = r10 + 1
            r14[r10] = r23
            r10 = r25
        L_0x01ec:
            int r13 = r13 + 1
            goto L_0x01da
        L_0x01ef:
            int[] r13 = java.util.Arrays.copyOf(r14, r10)
            int r14 = r11 + -1
            r23 = 0
        L_0x01f7:
            if (r14 < 0) goto L_0x020c
            r25 = r3[r14]
            int r25 = r25 + r26
            if (r25 <= 0) goto L_0x0209
            boolean r27 = r15[r14]
            if (r27 == 0) goto L_0x0209
            int r27 = r23 + 1
            r1[r23] = r25
            r23 = r27
        L_0x0209:
            int r14 = r14 + -1
            goto L_0x01f7
        L_0x020c:
            if (r26 <= 0) goto L_0x0218
            boolean r3 = r15[r5]
            if (r3 == 0) goto L_0x0218
            int r3 = r23 + 1
            r1[r23] = r26
            r23 = r3
        L_0x0218:
            r3 = 0
            r5 = r23
        L_0x021b:
            if (r3 >= r12) goto L_0x0232
            r14 = r4[r3]
            int r14 = r14 + r26
            if (r14 <= 0) goto L_0x022f
            int r23 = r11 + r3
            boolean r23 = r15[r23]
            if (r23 == 0) goto L_0x022f
            int r23 = r5 + 1
            r1[r5] = r14
            r5 = r23
        L_0x022f:
            int r3 = r3 + 1
            goto L_0x021b
        L_0x0232:
            int[] r1 = java.util.Arrays.copyOf(r1, r5)
            r4 = r1
            r12 = r5
            r11 = r10
            r3 = r13
            goto L_0x0289
        L_0x023b:
            r30 = r1
            r21 = r10
            r22 = r13
            r24 = r14
            r31 = r15
            int r1 = r0.zzc()
            int r3 = r0.zzc()
            int[] r4 = new int[r1]
            r5 = 0
        L_0x0250:
            if (r5 >= r1) goto L_0x0269
            if (r5 <= 0) goto L_0x0259
            int r10 = r5 + -1
            r10 = r4[r10]
            goto L_0x025a
        L_0x0259:
            r10 = 0
        L_0x025a:
            int r11 = r0.zzc()
            int r11 = r11 + 1
            int r10 = r10 - r11
            r4[r5] = r10
            r0.zzd()
            int r5 = r5 + 1
            goto L_0x0250
        L_0x0269:
            int[] r5 = new int[r3]
            r10 = 0
        L_0x026c:
            if (r10 >= r3) goto L_0x0285
            if (r10 <= 0) goto L_0x0275
            int r11 = r10 + -1
            r11 = r5[r11]
            goto L_0x0276
        L_0x0275:
            r11 = 0
        L_0x0276:
            int r12 = r0.zzc()
            int r12 = r12 + 1
            int r12 = r12 + r11
            r5[r10] = r12
            r0.zzd()
            int r10 = r10 + 1
            goto L_0x026c
        L_0x0285:
            r11 = r1
            r12 = r3
            r3 = r4
            r4 = r5
        L_0x0289:
            int r2 = r2 + 1
            r1 = r30
            r15 = r31
            r10 = r21
            r13 = r22
            r14 = r24
            goto L_0x0163
        L_0x0297:
            r21 = r10
            r22 = r13
            r24 = r14
            r31 = r15
            boolean r1 = r0.zzf()
            if (r1 == 0) goto L_0x02b4
            int r1 = r0.zzc()
            r2 = 0
        L_0x02aa:
            if (r2 >= r1) goto L_0x02b4
            int r3 = r20 + 5
            r0.zze(r3)
            int r2 = r2 + 1
            goto L_0x02aa
        L_0x02b4:
            r1 = 2
            r0.zze(r1)
            boolean r2 = r0.zzf()
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x034d
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x02f2
            r2 = 8
            int r2 = r0.zza(r2)
            r4 = 255(0xff, float:3.57E-43)
            if (r2 != r4) goto L_0x02e2
            r2 = 16
            int r4 = r0.zza(r2)
            int r2 = r0.zza(r2)
            if (r4 == 0) goto L_0x02f2
            if (r2 == 0) goto L_0x02f2
            float r3 = (float) r4
            float r2 = (float) r2
            float r3 = r3 / r2
            goto L_0x02f2
        L_0x02e2:
            r4 = 17
            if (r2 >= r4) goto L_0x02eb
            float[] r3 = zzb
            r3 = r3[r2]
            goto L_0x02f2
        L_0x02eb:
            java.lang.String r4 = "Unexpected aspect_ratio_idc value: "
            java.lang.String r5 = "NalUnitUtil"
            defpackage.C0709Uj.t(r4, r2, r5)
        L_0x02f2:
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x02fb
            r0.zzd()
        L_0x02fb:
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x032f
            r2 = 3
            r0.zze(r2)
            boolean r2 = r0.zzf()
            r4 = 1
            if (r4 == r2) goto L_0x030d
            goto L_0x030e
        L_0x030d:
            r1 = r4
        L_0x030e:
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x0330
            r2 = 8
            int r4 = r0.zza(r2)
            int r5 = r0.zza(r2)
            r0.zze(r2)
            int r2 = com.google.android.gms.internal.ads.zzo.zza(r4)
            int r5 = com.google.android.gms.internal.ads.zzo.zzb(r5)
            r28 = r5
            r5 = r2
            r2 = r28
            goto L_0x0332
        L_0x032f:
            r1 = -1
        L_0x0330:
            r2 = -1
            r5 = -1
        L_0x0332:
            boolean r4 = r0.zzf()
            if (r4 == 0) goto L_0x033e
            r0.zzc()
            r0.zzc()
        L_0x033e:
            r0.zzd()
            boolean r0 = r0.zzf()
            if (r0 == 0) goto L_0x0348
            int r9 = r9 + r9
        L_0x0348:
            r20 = r1
            r1 = r5
            r0 = r9
            goto L_0x0352
        L_0x034d:
            r0 = r9
            r1 = -1
            r2 = -1
            r20 = -1
        L_0x0352:
            com.google.android.gms.internal.ads.zzfe r4 = new com.google.android.gms.internal.ads.zzfe
            r5 = r4
            r9 = r21
            r10 = r16
            r11 = r18
            r12 = r19
            r13 = r22
            r14 = r24
            r15 = r31
            r16 = r17
            r17 = r0
            r18 = r3
            r19 = r1
            r21 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.zzc(byte[], int, int):com.google.android.gms.internal.ads.zzfe");
    }

    public static zzff zzd(byte[] bArr, int i, int i2) {
        zzfi zzfi = new zzfi(bArr, 4, i2);
        int zzc2 = zzfi.zzc();
        int zzc3 = zzfi.zzc();
        zzfi.zzd();
        return new zzff(zzc2, zzc3, zzfi.zzf());
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfg zze(byte[] r24, int r25, int r26) {
        /*
            com.google.android.gms.internal.ads.zzfi r0 = new com.google.android.gms.internal.ads.zzfi
            r1 = r24
            r2 = r25
            r3 = r26
            r0.<init>(r1, r2, r3)
            r1 = 8
            int r2 = r0.zza(r1)
            int r5 = r0.zza(r1)
            int r6 = r0.zza(r1)
            int r7 = r0.zzc()
            r3 = 100
            r4 = 3
            r8 = 1
            if (r2 == r3) goto L_0x0052
            r3 = 110(0x6e, float:1.54E-43)
            if (r2 == r3) goto L_0x0052
            r3 = 122(0x7a, float:1.71E-43)
            if (r2 == r3) goto L_0x0052
            r3 = 244(0xf4, float:3.42E-43)
            if (r2 == r3) goto L_0x0052
            r3 = 44
            if (r2 == r3) goto L_0x0052
            r3 = 83
            if (r2 == r3) goto L_0x0052
            r3 = 86
            if (r2 == r3) goto L_0x0052
            r3 = 118(0x76, float:1.65E-43)
            if (r2 == r3) goto L_0x0052
            r3 = 128(0x80, float:1.794E-43)
            if (r2 == r3) goto L_0x0052
            r3 = 138(0x8a, float:1.93E-43)
            if (r2 != r3) goto L_0x0049
            r2 = r3
            goto L_0x0052
        L_0x0049:
            r1 = 0
            r3 = 0
            r4 = 0
            r12 = r1
            r13 = r3
            r14 = r4
            r3 = r8
            r4 = r2
            goto L_0x00a7
        L_0x0052:
            int r3 = r0.zzc()
            if (r3 != r4) goto L_0x005e
            boolean r9 = r0.zzf()
            r10 = r4
            goto L_0x0060
        L_0x005e:
            r9 = 0
            r10 = r3
        L_0x0060:
            int r11 = r0.zzc()
            int r12 = r0.zzc()
            r0.zzd()
            boolean r13 = r0.zzf()
            if (r13 == 0) goto L_0x00a3
            if (r10 == r4) goto L_0x0075
            r4 = r1
            goto L_0x0077
        L_0x0075:
            r4 = 12
        L_0x0077:
            r10 = 0
        L_0x0078:
            if (r10 >= r4) goto L_0x00a3
            boolean r13 = r0.zzf()
            if (r13 == 0) goto L_0x009e
            r13 = 6
            if (r10 >= r13) goto L_0x0086
            r13 = 16
            goto L_0x0088
        L_0x0086:
            r13 = 64
        L_0x0088:
            r14 = 0
            r15 = r14
            r14 = r1
        L_0x008b:
            if (r15 >= r13) goto L_0x009e
            if (r1 == 0) goto L_0x0098
            int r1 = r0.zzb()
            int r1 = r1 + r14
            int r1 = r1 + 256
            int r1 = r1 % 256
        L_0x0098:
            if (r1 == 0) goto L_0x009b
            r14 = r1
        L_0x009b:
            int r15 = r15 + 1
            goto L_0x008b
        L_0x009e:
            int r10 = r10 + 1
            r1 = 8
            goto L_0x0078
        L_0x00a3:
            r4 = r2
            r14 = r9
            r13 = r12
            r12 = r11
        L_0x00a7:
            int r1 = r0.zzc()
            int r16 = r1 + 4
            int r1 = r0.zzc()
            if (r1 != 0) goto L_0x00bc
            int r2 = r0.zzc()
            int r2 = r2 + 4
            r24 = r14
            goto L_0x00e6
        L_0x00bc:
            if (r1 != r8) goto L_0x00e3
            boolean r1 = r0.zzf()
            r0.zzb()
            r0.zzb()
            int r2 = r0.zzc()
            long r9 = (long) r2
            r2 = 0
            r24 = r14
        L_0x00d0:
            long r14 = (long) r2
            int r11 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x00db
            r0.zzc()
            int r2 = r2 + 1
            goto L_0x00d0
        L_0x00db:
            r2 = 0
            r19 = r1
            r18 = r2
            r17 = r8
            goto L_0x00ed
        L_0x00e3:
            r24 = r14
            r2 = 0
        L_0x00e6:
            r9 = 0
            r17 = r1
            r18 = r2
            r19 = r9
        L_0x00ed:
            int r1 = r0.zzc()
            r0.zzd()
            int r2 = r0.zzc()
            int r2 = r2 + r8
            int r9 = r0.zzc()
            int r9 = r9 + r8
            boolean r15 = r0.zzf()
            int r10 = 2 - r15
            if (r15 != 0) goto L_0x0109
            r0.zzd()
        L_0x0109:
            int r9 = r9 * r10
            r0.zzd()
            int r2 = r2 * 16
            int r9 = r9 * 16
            boolean r11 = r0.zzf()
            r14 = 2
            if (r11 == 0) goto L_0x0147
            int r11 = r0.zzc()
            int r20 = r0.zzc()
            int r21 = r0.zzc()
            int r22 = r0.zzc()
            if (r3 != 0) goto L_0x012b
            goto L_0x013d
        L_0x012b:
            r8 = 3
            if (r3 != r8) goto L_0x0132
            r8 = 1
            r23 = 1
            goto L_0x0135
        L_0x0132:
            r8 = 1
            r23 = r14
        L_0x0135:
            if (r3 != r8) goto L_0x0139
            r3 = r14
            goto L_0x013a
        L_0x0139:
            r3 = 1
        L_0x013a:
            int r10 = r10 * r3
            r8 = r23
        L_0x013d:
            int r11 = r11 + r20
            int r11 = r11 * r8
            int r2 = r2 - r11
            int r21 = r21 + r22
            int r21 = r21 * r10
            int r9 = r9 - r21
        L_0x0147:
            r10 = r9
            r9 = r2
            boolean r2 = r0.zzf()
            r3 = -1
            if (r2 == 0) goto L_0x01d0
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x0182
            r2 = 8
            int r2 = r0.zza(r2)
            r8 = 255(0xff, float:3.57E-43)
            if (r2 != r8) goto L_0x0172
            r2 = 16
            int r8 = r0.zza(r2)
            int r2 = r0.zza(r2)
            if (r8 == 0) goto L_0x0182
            if (r2 == 0) goto L_0x0182
            float r8 = (float) r8
            float r2 = (float) r2
            float r8 = r8 / r2
            goto L_0x0184
        L_0x0172:
            r8 = 17
            if (r2 >= r8) goto L_0x017b
            float[] r8 = zzb
            r8 = r8[r2]
            goto L_0x0184
        L_0x017b:
            java.lang.String r8 = "Unexpected aspect_ratio_idc value: "
            java.lang.String r11 = "NalUnitUtil"
            defpackage.C0709Uj.t(r8, r2, r11)
        L_0x0182:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0184:
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x018d
            r0.zzd()
        L_0x018d:
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x01c8
            r2 = 3
            r0.zze(r2)
            boolean r2 = r0.zzf()
            r11 = 1
            if (r11 == r2) goto L_0x019f
            goto L_0x01a0
        L_0x019f:
            r14 = r11
        L_0x01a0:
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x01c0
            r2 = 8
            int r3 = r0.zza(r2)
            int r11 = r0.zza(r2)
            r0.zze(r2)
            int r0 = com.google.android.gms.internal.ads.zzo.zza(r3)
            int r2 = com.google.android.gms.internal.ads.zzo.zzb(r11)
            r20 = r0
            r22 = r2
            goto L_0x01c4
        L_0x01c0:
            r20 = r3
            r22 = r20
        L_0x01c4:
            r11 = r8
            r21 = r14
            goto L_0x01d9
        L_0x01c8:
            r20 = r3
            r21 = r20
            r22 = r21
            r11 = r8
            goto L_0x01d9
        L_0x01d0:
            r0 = 1065353216(0x3f800000, float:1.0)
            r11 = r0
            r20 = r3
            r21 = r20
            r22 = r21
        L_0x01d9:
            com.google.android.gms.internal.ads.zzfg r0 = new com.google.android.gms.internal.ads.zzfg
            r3 = r0
            r8 = r1
            r14 = r24
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfh.zze(byte[], int, int):com.google.android.gms.internal.ads.zzfg");
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
