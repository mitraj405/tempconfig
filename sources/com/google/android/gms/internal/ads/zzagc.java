package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzagc {
    public static final zzaga zza = new zzaga();

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.gms.internal.ads.zzbk zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzaga r13, com.google.android.gms.internal.ads.zzafe r14) {
        /*
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.ads.zzek r0 = new com.google.android.gms.internal.ads.zzek
            r0.<init>(r11, r12)
            int r11 = r0.zzb()
            r12 = 2
            r1 = 4
            r2 = 0
            r3 = 1
            java.lang.String r4 = "Id3Decoder"
            r5 = 0
            r6 = 10
            if (r11 >= r6) goto L_0x0020
            java.lang.String r11 = "Data too short to be an ID3 tag"
            com.google.android.gms.internal.ads.zzea.zzf(r4, r11)
            goto L_0x009b
        L_0x0020:
            int r11 = r0.zzo()
            r7 = 4801587(0x494433, float:6.728456E-39)
            if (r11 == r7) goto L_0x0045
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7[r2] = r11
            java.lang.String r11 = "%06X"
            java.lang.String r11 = java.lang.String.format(r11, r7)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r7 = "Unexpected first three bytes of ID3 tag header: 0x"
            java.lang.String r11 = r7.concat(r11)
            com.google.android.gms.internal.ads.zzea.zzf(r4, r11)
            goto L_0x009b
        L_0x0045:
            int r11 = r0.zzm()
            r0.zzL(r3)
            int r7 = r0.zzm()
            int r8 = r0.zzl()
            if (r11 != r12) goto L_0x0060
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0087
            java.lang.String r11 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            com.google.android.gms.internal.ads.zzea.zzf(r4, r11)
            goto L_0x009b
        L_0x0060:
            r9 = 3
            if (r11 != r9) goto L_0x0071
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0087
            int r9 = r0.zzg()
            r0.zzL(r9)
            int r9 = r9 + r1
            int r8 = r8 - r9
            goto L_0x0087
        L_0x0071:
            if (r11 != r1) goto L_0x0096
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0081
            int r9 = r0.zzl()
            int r10 = r9 + -4
            r0.zzL(r10)
            int r8 = r8 - r9
        L_0x0081:
            r9 = r7 & 16
            if (r9 == 0) goto L_0x0087
            int r8 = r8 + -10
        L_0x0087:
            if (r11 >= r1) goto L_0x008f
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x008f
            r7 = r3
            goto L_0x0090
        L_0x008f:
            r7 = r2
        L_0x0090:
            com.google.android.gms.internal.ads.zzagb r9 = new com.google.android.gms.internal.ads.zzagb
            r9.<init>(r11, r7, r8)
            goto L_0x009c
        L_0x0096:
            java.lang.String r7 = "Skipped ID3 tag with unsupported majorVersion="
            defpackage.C0709Uj.t(r7, r11, r4)
        L_0x009b:
            r9 = r5
        L_0x009c:
            if (r9 != 0) goto L_0x009f
            return r5
        L_0x009f:
            int r11 = r0.zzd()
            int r7 = r9.zza
            if (r7 != r12) goto L_0x00aa
            r6 = 6
        L_0x00aa:
            int r12 = r9.zzc
            boolean r7 = r9.zzb
            if (r7 == 0) goto L_0x00bc
            int r12 = r9.zzc
            int r12 = zze(r0, r12)
        L_0x00bc:
            int r11 = r11 + r12
            r0.zzJ(r11)
            int r11 = r9.zza
            boolean r11 = zzj(r0, r11, r6, r2)
            if (r11 != 0) goto L_0x00e2
            int r11 = r9.zza
            if (r11 != r1) goto L_0x00d8
            boolean r11 = zzj(r0, r1, r6, r3)
            if (r11 == 0) goto L_0x00d8
            r2 = r3
            goto L_0x00e2
        L_0x00d8:
            int r11 = r9.zza
            java.lang.String r12 = "Failed to validate ID3 tag with majorVersion="
            defpackage.C0709Uj.t(r12, r11, r4)
            return r5
        L_0x00e2:
            int r11 = r0.zzb()
            if (r11 < r6) goto L_0x00f6
            int r11 = r9.zza
            com.google.android.gms.internal.ads.zzagd r11 = zzl(r11, r0, r2, r6, r13)
            if (r11 == 0) goto L_0x00e2
            r14.add(r11)
            goto L_0x00e2
        L_0x00f6:
            com.google.android.gms.internal.ads.zzbk r11 = new com.google.android.gms.internal.ads.zzbk
            r11.<init>((java.util.List) r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagc.zza(byte[], int, com.google.android.gms.internal.ads.zzaga, com.google.android.gms.internal.ads.zzafe):com.google.android.gms.internal.ads.zzbk");
    }

    private static int zzb(int i) {
        if (i == 0 || i == 3) {
            return 1;
        }
        return 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int zzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            int i3 = zzd + 1;
            if ((zzd - i) % 2 == 0 && bArr[i3] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzek zzek, int i) {
        byte[] zzM = zzek.zzM();
        int zzd = zzek.zzd();
        int i2 = zzd;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= zzd + i) {
                return i;
            }
            if ((zzM[i2] & UnsignedBytes.MAX_VALUE) == 255 && zzM[i3] == 0) {
                System.arraycopy(zzM, i2 + 2, zzM, i3, (i - (i2 - zzd)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static zzfxr zzf(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzfxr.zzn("");
        }
        zzfxo zzfxo = new zzfxo();
        int zzc = zzc(bArr, i2, i);
        while (i2 < zzc) {
            zzfxo.zzf(new String(bArr, i2, zzc - i2, zzi(i)));
            i2 = zzb(i) + zzc;
            zzc = zzc(bArr, i2, i);
        }
        zzfxr zzi = zzfxo.zzi();
        if (zzi.isEmpty()) {
            return zzfxr.zzn("");
        }
        return zzi;
    }

    private static String zzg(byte[] bArr, int i, int i2, Charset charset) {
        if (i2 <= i || i2 > bArr.length) {
            return "";
        }
        return new String(bArr, i, i2 - i, charset);
    }

    private static String zzh(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static Charset zzi(int i) {
        if (i == 1) {
            return zzfuj.zzf;
        }
        if (i == 2) {
            return zzfuj.zzd;
        }
        if (i != 3) {
            return zzfuj.zzb;
        }
        return zzfuj.zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzj(com.google.android.gms.internal.ads.zzek r21, int r22, int r23, boolean r24) {
        /*
            r1 = r21
            r0 = r22
            int r2 = r21.zzd()
        L_0x0008:
            int r3 = r21.zzb()     // Catch:{ all -> 0x00a8 }
            r4 = 1
            r5 = r23
            if (r3 < r5) goto L_0x00a4
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r21.zzg()     // Catch:{ all -> 0x00a8 }
            long r8 = r21.zzu()     // Catch:{ all -> 0x00a8 }
            int r10 = r21.zzq()     // Catch:{ all -> 0x00a8 }
            goto L_0x002c
        L_0x0022:
            int r7 = r21.zzo()     // Catch:{ all -> 0x00a8 }
            int r8 = r21.zzo()     // Catch:{ all -> 0x00a8 }
            long r8 = (long) r8     // Catch:{ all -> 0x00a8 }
            r10 = r6
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x0038
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0038
            if (r10 != 0) goto L_0x0038
            goto L_0x00a4
        L_0x0038:
            r7 = 4
            if (r0 != r7) goto L_0x0068
            if (r24 != 0) goto L_0x0068
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0048
        L_0x0045:
            r4 = r6
            goto L_0x00a4
        L_0x0048:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            r17 = 16
            long r17 = r8 >> r17
            r19 = 24
            long r8 = r8 >> r19
            long r15 = r15 & r11
            long r11 = r17 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 14
            long r11 = r11 << r15
            long r11 = r11 | r13
            r13 = 21
            long r8 = r8 << r13
            long r8 = r8 | r11
        L_0x0068:
            if (r0 != r7) goto L_0x0078
            r3 = r10 & 64
            if (r3 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = r6
        L_0x0070:
            r3 = r10 & 1
            r20 = r4
            r4 = r3
            r3 = r20
            goto L_0x008a
        L_0x0078:
            if (r0 != r3) goto L_0x0088
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0080
            r3 = r4
            goto L_0x0081
        L_0x0080:
            r3 = r6
        L_0x0081:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0086
            goto L_0x008a
        L_0x0086:
            r4 = r6
            goto L_0x008a
        L_0x0088:
            r3 = r6
            r4 = r3
        L_0x008a:
            if (r4 == 0) goto L_0x008e
            int r3 = r3 + 4
        L_0x008e:
            long r3 = (long) r3     // Catch:{ all -> 0x00a8 }
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0094
            goto L_0x0045
        L_0x0094:
            int r3 = r21.zzb()     // Catch:{ all -> 0x00a8 }
            long r3 = (long) r3     // Catch:{ all -> 0x00a8 }
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x009e
            goto L_0x0045
        L_0x009e:
            int r3 = (int) r8     // Catch:{ all -> 0x00a8 }
            r1.zzL(r3)     // Catch:{ all -> 0x00a8 }
            goto L_0x0008
        L_0x00a4:
            r1.zzK(r2)
            return r4
        L_0x00a8:
            r0 = move-exception
            r1.zzK(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagc.zzj(com.google.android.gms.internal.ads.zzek, int, int, boolean):boolean");
    }

    private static byte[] zzk(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return zzet.zzf;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.ads.zzaft} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: com.google.android.gms.internal.ads.zzaft} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.google.android.gms.internal.ads.zzafr} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: com.google.android.gms.internal.ads.zzagi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: com.google.android.gms.internal.ads.zzafv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: com.google.android.gms.internal.ads.zzagi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: com.google.android.gms.internal.ads.zzagi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v73, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v77, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v80, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v81, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v83, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: com.google.android.gms.internal.ads.zzagi} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v4, resolved type: com.google.android.gms.internal.ads.zzaft} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v87, resolved type: com.google.android.gms.internal.ads.zzek} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v90, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v91, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v92, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v23, types: [com.google.android.gms.internal.ads.zzafx] */
    /* JADX WARNING: type inference failed for: r3v27, types: [com.google.android.gms.internal.ads.zzafp] */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x027a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x027d, code lost:
        r23 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0280, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0283, code lost:
        r23 = r5;
        r22 = "Id3Decoder";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0287, code lost:
        r8 = r2;
        r3 = r6;
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0429, code lost:
        r0 = th;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x04b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x04b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x04b6, code lost:
        r2 = r0;
        r3 = r6;
        r10 = r18;
        r4 = r20;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x04be, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x04c0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x04c1, code lost:
        r2 = r0;
        r3 = r6;
        r4 = r7;
        r10 = r18;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x050e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x0511, code lost:
        r2 = r0;
        r10 = r18;
        r4 = r20;
        r3 = r21;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0579, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x057c, code lost:
        r2 = r0;
        r8 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x016c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x016d, code lost:
        r1 = r0;
        r8 = r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:199:0x036b, B:250:0x048c] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:199:0x036b, B:253:0x0490] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:199:0x036b, B:256:0x049a] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:199:0x036b, B:288:0x0534] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:79:0x010c, B:127:0x022d] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:79:0x010c, B:130:0x0245] */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:79:0x010c, B:133:0x024a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02c5 A[SYNTHETIC, Splitter:B:159:0x02c5] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0429 A[Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }, ExcHandler: all (th java.lang.Throwable), PHI: r8 r24 
      PHI: (r8v17 com.google.android.gms.internal.ads.zzek) = (r8v73 com.google.android.gms.internal.ads.zzek), (r8v77 com.google.android.gms.internal.ads.zzek), (r8v80 com.google.android.gms.internal.ads.zzek), (r8v81 com.google.android.gms.internal.ads.zzek), (r8v83 com.google.android.gms.internal.ads.zzek), (r8v87 com.google.android.gms.internal.ads.zzek), (r8v92 java.lang.String) binds: [B:288:0x0534, B:250:0x048c, B:251:?, B:253:0x0490, B:256:0x049a, B:199:0x036b, B:177:0x0318] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v6 int) = (r24v9 int), (r24v9 int), (r24v9 int), (r24v9 int), (r24v9 int), (r24v9 int), (r24v14 int) binds: [B:288:0x0534, B:250:0x048c, B:251:?, B:253:0x0490, B:256:0x049a, B:199:0x036b, B:177:0x0318] A[DONT_GENERATE, DONT_INLINE], Splitter:B:199:0x036b] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0522  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x05b8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016c A[Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }, ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }]), Splitter:B:79:0x010c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzagd zzl(int r35, com.google.android.gms.internal.ads.zzek r36, boolean r37, int r38, com.google.android.gms.internal.ads.zzaga r39) {
        /*
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            int r5 = r36.zzm()
            int r6 = r36.zzm()
            int r7 = r36.zzm()
            r9 = 3
            if (r1 < r9) goto L_0x001c
            int r10 = r36.zzm()
            goto L_0x001d
        L_0x001c:
            r10 = 0
        L_0x001d:
            r11 = 4
            if (r1 != r11) goto L_0x003c
            int r12 = r36.zzp()
            if (r3 != 0) goto L_0x0047
            r13 = r12 & 255(0xff, float:3.57E-43)
            int r14 = r12 >> 8
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r15 = r12 >> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r12 = r12 >> 24
            int r14 = r14 << 7
            r13 = r13 | r14
            int r14 = r15 << 14
            r13 = r13 | r14
            int r12 = r12 << 21
            r12 = r12 | r13
            goto L_0x0047
        L_0x003c:
            if (r1 != r9) goto L_0x0043
            int r12 = r36.zzp()
            goto L_0x0047
        L_0x0043:
            int r12 = r36.zzo()
        L_0x0047:
            if (r1 < r9) goto L_0x004e
            int r13 = r36.zzq()
            goto L_0x004f
        L_0x004e:
            r13 = 0
        L_0x004f:
            r14 = 0
            if (r5 != 0) goto L_0x0065
            if (r6 != 0) goto L_0x0065
            if (r7 != 0) goto L_0x0065
            if (r10 != 0) goto L_0x0065
            if (r12 != 0) goto L_0x0065
            if (r13 == 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            int r1 = r36.zze()
            r2.zzK(r1)
            return r14
        L_0x0065:
            int r15 = r36.zzd()
            int r15 = r15 + r12
            int r8 = r36.zze()
            java.lang.String r11 = "Id3Decoder"
            if (r15 <= r8) goto L_0x007f
            java.lang.String r1 = "Frame size exceeds remaining tag data"
            com.google.android.gms.internal.ads.zzea.zzf(r11, r1)
            int r1 = r36.zze()
            r2.zzK(r1)
            return r14
        L_0x007f:
            if (r39 != 0) goto L_0x05e6
            r8 = 1
            if (r1 != r9) goto L_0x00a2
            r17 = r13 & 64
            r9 = r13 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x008c
            r9 = r8
            goto L_0x008d
        L_0x008c:
            r9 = 0
        L_0x008d:
            if (r17 == 0) goto L_0x0092
            r17 = r8
            goto L_0x0094
        L_0x0092:
            r17 = 0
        L_0x0094:
            r13 = r13 & 32
            if (r13 == 0) goto L_0x009a
            r13 = r8
            goto L_0x009b
        L_0x009a:
            r13 = 0
        L_0x009b:
            r19 = r17
            r20 = 0
            r17 = r9
            goto L_0x00d6
        L_0x00a2:
            r9 = 4
            if (r1 != r9) goto L_0x00ce
            r9 = r13 & 64
            if (r9 == 0) goto L_0x00ab
            r9 = r8
            goto L_0x00ac
        L_0x00ab:
            r9 = 0
        L_0x00ac:
            r17 = r13 & 8
            if (r17 == 0) goto L_0x00b3
            r17 = r8
            goto L_0x00b5
        L_0x00b3:
            r17 = 0
        L_0x00b5:
            r19 = r13 & 4
            if (r19 == 0) goto L_0x00bc
            r19 = r8
            goto L_0x00be
        L_0x00bc:
            r19 = 0
        L_0x00be:
            r20 = r13 & 2
            if (r20 == 0) goto L_0x00c5
            r20 = r8
            goto L_0x00c7
        L_0x00c5:
            r20 = 0
        L_0x00c7:
            r13 = r13 & r8
            r34 = r13
            r13 = r9
            r9 = r34
            goto L_0x00d6
        L_0x00ce:
            r9 = 0
            r13 = 0
            r17 = 0
            r19 = 0
            r20 = 0
        L_0x00d6:
            if (r17 != 0) goto L_0x05da
            if (r19 == 0) goto L_0x00dc
            goto L_0x05da
        L_0x00dc:
            if (r13 == 0) goto L_0x00e3
            r2.zzL(r8)
            int r12 = r12 + -1
        L_0x00e3:
            if (r9 == 0) goto L_0x00eb
            r9 = 4
            r2.zzL(r9)
            int r12 = r12 + -4
        L_0x00eb:
            if (r20 == 0) goto L_0x00f1
            int r12 = zze(r2, r12)
        L_0x00f1:
            r9 = 84
            r13 = 88
            r8 = 2
            if (r5 != r9) goto L_0x0137
            if (r6 != r13) goto L_0x0137
            if (r7 != r13) goto L_0x0137
            if (r1 == r8) goto L_0x0100
            if (r10 != r13) goto L_0x0137
        L_0x0100:
            if (r12 > 0) goto L_0x010c
            r8 = r2
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            r2 = r14
            goto L_0x059c
        L_0x010c:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r4 = r12 + -1
            byte[] r8 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r9 = 0
            r2.zzG(r8, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r4 = zzc(r8, r9, r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.nio.charset.Charset r14 = zzi(r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r13.<init>(r8, r9, r4, r14)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r9 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r4 = r4 + r9
            com.google.android.gms.internal.ads.zzfxr r3 = zzf(r8, r3, r4)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            com.google.android.gms.internal.ads.zzagm r4 = new com.google.android.gms.internal.ads.zzagm     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.lang.String r8 = "TXXX"
            r4.<init>(r8, r13, r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            goto L_0x01dd
        L_0x0137:
            if (r5 != r9) goto L_0x017e
            java.lang.String r3 = zzh(r1, r9, r6, r7, r10)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            if (r12 > 0) goto L_0x0149
        L_0x013f:
            r8 = r2
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
        L_0x0146:
            r2 = 0
            goto L_0x059c
        L_0x0149:
            int r4 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r8 = r12 + -1
            byte[] r9 = new byte[r8]     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r13 = 0
            r2.zzG(r9, r13, r8)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            com.google.android.gms.internal.ads.zzfxr r4 = zzf(r9, r4, r13)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            com.google.android.gms.internal.ads.zzagm r8 = new com.google.android.gms.internal.ads.zzagm     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r9 = 0
            r8.<init>(r3, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
        L_0x0165:
            r34 = r8
            r8 = r2
            r2 = r34
            goto L_0x059c
        L_0x016c:
            r0 = move-exception
            r1 = r0
            r8 = r2
            goto L_0x05a7
        L_0x0171:
            r0 = move-exception
            goto L_0x0174
        L_0x0173:
            r0 = move-exception
        L_0x0174:
            r8 = r2
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
        L_0x017b:
            r2 = r0
            goto L_0x05b2
        L_0x017e:
            r14 = 87
            if (r5 != r14) goto L_0x01bf
            if (r6 != r13) goto L_0x01bd
            if (r7 != r13) goto L_0x01bd
            if (r1 == r8) goto L_0x018a
            if (r10 != r13) goto L_0x01bd
        L_0x018a:
            if (r12 > 0) goto L_0x018d
            goto L_0x013f
        L_0x018d:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r4 = r12 + -1
            byte[] r8 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r9 = 0
            r2.zzG(r8, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r4 = zzc(r8, r9, r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.nio.charset.Charset r14 = zzi(r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r13.<init>(r8, r9, r4, r14)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r3 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r4 = r4 + r3
            int r3 = zzd(r8, r4)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.lang.String r3 = zzg(r8, r4, r3, r9)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            com.google.android.gms.internal.ads.zzago r4 = new com.google.android.gms.internal.ads.zzago     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.lang.String r8 = "WXXX"
            r4.<init>(r8, r13, r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            goto L_0x01dd
        L_0x01bd:
            r13 = r14
            goto L_0x01c0
        L_0x01bf:
            r13 = r5
        L_0x01c0:
            if (r13 != r14) goto L_0x01e7
            java.lang.String r3 = zzh(r1, r14, r6, r7, r10)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            byte[] r4 = new byte[r12]     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r8 = 0
            r2.zzG(r4, r8, r12)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r9 = zzd(r4, r8)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r13.<init>(r4, r8, r9, r14)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            com.google.android.gms.internal.ads.zzago r4 = new com.google.android.gms.internal.ads.zzago     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r8 = 0
            r4.<init>(r3, r8, r13)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
        L_0x01dd:
            r8 = r2
            r2 = r4
            r23 = r5
            r3 = r6
            r4 = r7
            r22 = r11
            goto L_0x059c
        L_0x01e7:
            r14 = 73
            r9 = 80
            if (r13 != r9) goto L_0x0215
            r13 = 82
            if (r6 != r13) goto L_0x0214
            if (r7 != r14) goto L_0x0214
            r13 = 86
            if (r10 != r13) goto L_0x0214
            byte[] r3 = new byte[r12]     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r4 = 0
            r2.zzG(r3, r4, r12)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            int r8 = zzd(r3, r4)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.lang.String r9 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            java.nio.charset.Charset r13 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r9.<init>(r3, r4, r8, r13)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r4 = 1
            int r8 = r8 + r4
            byte[] r3 = zzk(r3, r8, r12)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            com.google.android.gms.internal.ads.zzagk r4 = new com.google.android.gms.internal.ads.zzagk     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            r4.<init>(r9, r3)     // Catch:{ OutOfMemoryError -> 0x0173, Exception -> 0x0171, all -> 0x016c }
            goto L_0x01dd
        L_0x0214:
            r13 = r9
        L_0x0215:
            r14 = 79
            r9 = 71
            if (r13 != r9) goto L_0x0292
            r13 = 69
            if (r6 != r13) goto L_0x028c
            if (r7 != r14) goto L_0x028c
            r13 = 66
            if (r10 == r13) goto L_0x022d
            if (r1 != r8) goto L_0x0228
            goto L_0x022d
        L_0x0228:
            r23 = r5
            r13 = r9
            goto L_0x0294
        L_0x022d:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0282, Exception -> 0x0280, all -> 0x016c }
            java.nio.charset.Charset r4 = zzi(r3)     // Catch:{ OutOfMemoryError -> 0x0282, Exception -> 0x0280, all -> 0x016c }
            int r8 = r12 + -1
            byte[] r9 = new byte[r8]     // Catch:{ OutOfMemoryError -> 0x0282, Exception -> 0x0280, all -> 0x016c }
            r13 = 0
            r2.zzG(r9, r13, r8)     // Catch:{ OutOfMemoryError -> 0x0282, Exception -> 0x0280, all -> 0x016c }
            int r14 = zzd(r9, r13)     // Catch:{ OutOfMemoryError -> 0x0282, Exception -> 0x0280, all -> 0x016c }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0282, Exception -> 0x0280, all -> 0x016c }
            r22 = r11
            java.nio.charset.Charset r11 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x027c, Exception -> 0x027a, all -> 0x016c }
            r23 = r5
            r5 = 0
            r13.<init>(r9, r5, r14, r11)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.lang.String r5 = com.google.android.gms.internal.ads.zzbn.zze(r13)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            r11 = 1
            int r14 = r14 + r11
            int r11 = zzc(r9, r14, r3)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.lang.String r13 = zzg(r9, r14, r11, r4)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            int r14 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            int r11 = r11 + r14
            int r14 = zzc(r9, r11, r3)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.lang.String r4 = zzg(r9, r11, r14, r4)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            int r3 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            int r14 = r14 + r3
            byte[] r3 = zzk(r9, r14, r8)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            com.google.android.gms.internal.ads.zzafz r8 = new com.google.android.gms.internal.ads.zzafz     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            r8.<init>(r5, r13, r4, r3)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            r3 = r6
            r4 = r7
            goto L_0x0165
        L_0x027a:
            r0 = move-exception
            goto L_0x027d
        L_0x027c:
            r0 = move-exception
        L_0x027d:
            r23 = r5
            goto L_0x0287
        L_0x0280:
            r0 = move-exception
            goto L_0x0283
        L_0x0282:
            r0 = move-exception
        L_0x0283:
            r23 = r5
            r22 = r11
        L_0x0287:
            r8 = r2
            r3 = r6
            r4 = r7
            goto L_0x017b
        L_0x028c:
            r23 = r5
            r22 = r11
            r13 = r9
            goto L_0x0296
        L_0x0292:
            r23 = r5
        L_0x0294:
            r22 = r11
        L_0x0296:
            r5 = 65
            r9 = 67
            if (r1 != r8) goto L_0x02a7
            r11 = 80
            if (r13 != r11) goto L_0x0341
            r14 = 73
            if (r6 != r14) goto L_0x0341
            if (r7 != r9) goto L_0x0341
            goto L_0x02b3
        L_0x02a7:
            r11 = 80
            r14 = 73
            if (r13 != r5) goto L_0x0341
            if (r6 != r11) goto L_0x0341
            if (r7 != r14) goto L_0x0341
            if (r10 != r9) goto L_0x0341
        L_0x02b3:
            int r3 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            java.nio.charset.Charset r4 = zzi(r3)     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            int r5 = r12 + -1
            byte[] r9 = new byte[r5]     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            r11 = 0
            r2.zzG(r9, r11, r5)     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            if (r1 != r8) goto L_0x02eb
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            r8 = 3
            r13.<init>(r9, r11, r8, r14)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfuf.zza(r13)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.lang.String r11 = "image/"
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.lang.String r8 = r11.concat(r8)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            java.lang.String r11 = "image/jpg"
            boolean r11 = r11.equals(r8)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
            if (r11 == 0) goto L_0x02e5
            java.lang.String r8 = "image/jpeg"
        L_0x02e5:
            r11 = 2
            goto L_0x030a
        L_0x02e7:
            r0 = move-exception
            goto L_0x0287
        L_0x02e9:
            r0 = move-exception
            goto L_0x0287
        L_0x02eb:
            r8 = r11
            int r11 = zzd(r9, r8)     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            r13.<init>(r9, r8, r11, r14)     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfuf.zza(r13)     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            r13 = 47
            int r13 = r8.indexOf(r13)     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            r14 = -1
            if (r13 != r14) goto L_0x030a
            java.lang.String r13 = "image/"
            java.lang.String r8 = r13.concat(r8)     // Catch:{ OutOfMemoryError -> 0x02e9, Exception -> 0x02e7, all -> 0x016c }
        L_0x030a:
            int r13 = r11 + 1
            byte r13 = r9[r13]     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r14 = 2
            int r11 = r11 + r14
            int r14 = zzc(r9, r11, r3)     // Catch:{ OutOfMemoryError -> 0x0339, Exception -> 0x0337, all -> 0x0331 }
            r24 = r15
            java.lang.String r15 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            int r2 = r14 - r11
            r15.<init>(r9, r11, r2, r4)     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            int r2 = zzb(r3)     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            int r14 = r14 + r2
            byte[] r2 = zzk(r9, r14, r5)     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            com.google.android.gms.internal.ads.zzafp r3 = new com.google.android.gms.internal.ads.zzafp     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            r3.<init>(r8, r15, r13, r2)     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            r8 = r36
            goto L_0x0395
        L_0x0331:
            r0 = move-exception
            r8 = r36
        L_0x0334:
            r1 = r0
            goto L_0x05a7
        L_0x0337:
            r0 = move-exception
            goto L_0x033a
        L_0x0339:
            r0 = move-exception
        L_0x033a:
            r8 = r36
            r2 = r0
            r3 = r6
            r4 = r7
            goto L_0x05b2
        L_0x0341:
            r24 = r15
            r2 = 77
            if (r13 != r9) goto L_0x03a6
            r8 = 79
            if (r6 != r8) goto L_0x03a6
            if (r7 != r2) goto L_0x03a6
            if (r10 == r2) goto L_0x0352
            r8 = 2
            if (r1 != r8) goto L_0x03a6
        L_0x0352:
            r2 = 4
            if (r12 >= r2) goto L_0x035d
            r8 = r36
            r3 = r6
            r4 = r7
            r15 = r24
            goto L_0x0146
        L_0x035d:
            int r2 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            java.nio.charset.Charset r3 = zzi(r2)     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            r4 = 3
            byte[] r5 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x03a1, Exception -> 0x039f, all -> 0x039a }
            r8 = r36
            r9 = 0
            r8.zzG(r5, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            java.lang.String r11 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r11.<init>(r5, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r4 = r12 + -4
            byte[] r5 = new byte[r4]     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r8.zzG(r5, r9, r4)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r4 = zzc(r5, r9, r2)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            java.lang.String r13 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r13.<init>(r5, r9, r4, r3)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r9 = zzb(r2)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r4 = r4 + r9
            int r2 = zzc(r5, r4, r2)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            java.lang.String r2 = zzg(r5, r4, r2, r3)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            com.google.android.gms.internal.ads.zzafx r3 = new com.google.android.gms.internal.ads.zzafx     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r3.<init>(r11, r13, r2)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
        L_0x0395:
            r2 = r3
        L_0x0396:
            r3 = r6
            r4 = r7
            goto L_0x059a
        L_0x039a:
            r0 = move-exception
            r8 = r36
            goto L_0x042a
        L_0x039f:
            r0 = move-exception
            goto L_0x03a2
        L_0x03a1:
            r0 = move-exception
        L_0x03a2:
            r8 = r36
            goto L_0x0432
        L_0x03a6:
            r8 = r36
            if (r13 != r9) goto L_0x0439
            r11 = 72
            if (r6 != r11) goto L_0x0439
            if (r7 != r5) goto L_0x0439
            r5 = 80
            if (r10 != r5) goto L_0x0439
            int r2 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            byte[] r5 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r5 = zzd(r5, r2)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            java.lang.String r9 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            byte[] r11 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r13 = r5 - r2
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r9.<init>(r11, r2, r13, r14)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r11 = 1
            int r5 = r5 + r11
            r8.zzK(r5)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r27 = r36.zzg()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r28 = r36.zzg()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            long r13 = r36.zzu()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r18 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r5 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r5 != 0) goto L_0x03e9
            r13 = -1
        L_0x03e9:
            r29 = r13
            long r13 = r36.zzu()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r18 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r5 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r5 != 0) goto L_0x03fa
            r13 = -1
        L_0x03fa:
            r31 = r13
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r5.<init>()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r2 = r2 + r12
        L_0x0402:
            int r11 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            if (r11 >= r2) goto L_0x0413
            r11 = 0
            com.google.android.gms.internal.ads.zzagd r13 = zzl(r1, r8, r3, r4, r11)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            if (r13 == 0) goto L_0x0402
            r5.add(r13)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            goto L_0x0402
        L_0x0413:
            r2 = 0
            com.google.android.gms.internal.ads.zzagd[] r2 = new com.google.android.gms.internal.ads.zzagd[r2]     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            java.lang.Object[] r2 = r5.toArray(r2)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r33 = r2
            com.google.android.gms.internal.ads.zzagd[] r33 = (com.google.android.gms.internal.ads.zzagd[]) r33     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            com.google.android.gms.internal.ads.zzaft r2 = new com.google.android.gms.internal.ads.zzaft     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r25 = r2
            r26 = r9
            r25.<init>(r26, r27, r28, r29, r31, r33)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            goto L_0x0396
        L_0x0429:
            r0 = move-exception
        L_0x042a:
            r1 = r0
            r15 = r24
            goto L_0x05a7
        L_0x042f:
            r0 = move-exception
            goto L_0x0432
        L_0x0431:
            r0 = move-exception
        L_0x0432:
            r2 = r0
            r3 = r6
            r4 = r7
        L_0x0435:
            r15 = r24
            goto L_0x05b2
        L_0x0439:
            if (r13 != r9) goto L_0x051a
            r5 = 84
            if (r6 != r5) goto L_0x051a
            r5 = 79
            if (r7 != r5) goto L_0x051a
            if (r10 != r9) goto L_0x051a
            int r2 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            byte[] r5 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r5 = zzd(r5, r2)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            java.lang.String r9 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            byte[] r11 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r13 = r5 - r2
            java.nio.charset.Charset r14 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r9.<init>(r11, r2, r13, r14)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r11 = 1
            int r5 = r5 + r11
            r8.zzK(r5)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r5 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r11 = r5 & 2
            if (r11 == 0) goto L_0x046f
            r11 = 1
            r27 = 1
            goto L_0x0472
        L_0x046f:
            r11 = 1
            r27 = 0
        L_0x0472:
            r5 = r5 & r11
            int r11 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r14 = 0
        L_0x047a:
            if (r14 >= r11) goto L_0x04c8
            int r15 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r16 = r11
            byte[] r11 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            int r11 = zzd(r11, r15)     // Catch:{ OutOfMemoryError -> 0x0431, Exception -> 0x042f, all -> 0x0429 }
            r18 = r10
            java.lang.String r10 = new java.lang.String     // Catch:{ OutOfMemoryError -> 0x04c0, Exception -> 0x04be, all -> 0x0429 }
            r20 = r7
            byte[] r7 = r36.zzM()     // Catch:{ OutOfMemoryError -> 0x04b5, Exception -> 0x04b3, all -> 0x0429 }
            r21 = r6
            int r6 = r11 - r15
            r19 = r9
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzfuj.zzb     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            r10.<init>(r7, r15, r6, r9)     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            r13[r14] = r10     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            int r11 = r11 + 1
            r8.zzK(r11)     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            int r14 = r14 + 1
            r11 = r16
            r10 = r18
            r9 = r19
            r7 = r20
            r6 = r21
            goto L_0x047a
        L_0x04b3:
            r0 = move-exception
            goto L_0x04b6
        L_0x04b5:
            r0 = move-exception
        L_0x04b6:
            r2 = r0
            r3 = r6
            r10 = r18
            r4 = r20
            goto L_0x0435
        L_0x04be:
            r0 = move-exception
            goto L_0x04c1
        L_0x04c0:
            r0 = move-exception
        L_0x04c1:
            r2 = r0
            r3 = r6
            r4 = r7
            r10 = r18
            goto L_0x0435
        L_0x04c8:
            r21 = r6
            r20 = r7
            r19 = r9
            r18 = r10
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            r6.<init>()     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            int r2 = r2 + r12
        L_0x04d6:
            int r7 = r36.zzd()     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            if (r7 >= r2) goto L_0x04e7
            r7 = 0
            com.google.android.gms.internal.ads.zzagd r9 = zzl(r1, r8, r3, r4, r7)     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            if (r9 == 0) goto L_0x04d6
            r6.add(r9)     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            goto L_0x04d6
        L_0x04e7:
            r2 = 0
            com.google.android.gms.internal.ads.zzagd[] r3 = new com.google.android.gms.internal.ads.zzagd[r2]     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            java.lang.Object[] r2 = r6.toArray(r3)     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            r30 = r2
            com.google.android.gms.internal.ads.zzagd[] r30 = (com.google.android.gms.internal.ads.zzagd[]) r30     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            com.google.android.gms.internal.ads.zzafv r4 = new com.google.android.gms.internal.ads.zzafv     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            r2 = 1
            if (r2 == r5) goto L_0x04fa
            r28 = 0
            goto L_0x04fc
        L_0x04fa:
            r28 = r2
        L_0x04fc:
            r25 = r4
            r26 = r19
            r29 = r13
            r25.<init>(r26, r27, r28, r29, r30)     // Catch:{ OutOfMemoryError -> 0x0510, Exception -> 0x050e, all -> 0x0429 }
            r2 = r4
            r10 = r18
            r4 = r20
            r3 = r21
            goto L_0x059a
        L_0x050e:
            r0 = move-exception
            goto L_0x0511
        L_0x0510:
            r0 = move-exception
        L_0x0511:
            r2 = r0
            r10 = r18
            r4 = r20
            r3 = r21
            goto L_0x0435
        L_0x051a:
            r21 = r6
            r20 = r7
            r18 = r10
            if (r13 != r2) goto L_0x0584
            r2 = 76
            r3 = r21
            if (r3 != r2) goto L_0x057f
            r2 = 76
            r4 = r20
            r10 = r18
            if (r4 != r2) goto L_0x058a
            r2 = 84
            if (r10 != r2) goto L_0x058a
            int r26 = r36.zzq()     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int r27 = r36.zzo()     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int r28 = r36.zzo()     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int r2 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int r5 = r36.zzm()     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            com.google.android.gms.internal.ads.zzej r6 = new com.google.android.gms.internal.ads.zzej     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            r6.<init>()     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            r6.zzj(r8)     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int r7 = r12 + -10
            int r7 = r7 * 8
            int r9 = r2 + r5
            int r7 = r7 / r9
            int[] r9 = new int[r7]     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int[] r11 = new int[r7]     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            r13 = 0
        L_0x055c:
            if (r13 >= r7) goto L_0x056d
            int r14 = r6.zzd(r2)     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int r15 = r6.zzd(r5)     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            r9[r13] = r14     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            r11[r13] = r15     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            int r13 = r13 + 1
            goto L_0x055c
        L_0x056d:
            com.google.android.gms.internal.ads.zzagi r2 = new com.google.android.gms.internal.ads.zzagi     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            r25 = r2
            r29 = r9
            r30 = r11
            r25.<init>(r26, r27, r28, r29, r30)     // Catch:{ OutOfMemoryError -> 0x057b, Exception -> 0x0579, all -> 0x0429 }
            goto L_0x059a
        L_0x0579:
            r0 = move-exception
            goto L_0x057c
        L_0x057b:
            r0 = move-exception
        L_0x057c:
            r2 = r0
            goto L_0x0435
        L_0x057f:
            r10 = r18
            r4 = r20
            goto L_0x058a
        L_0x0584:
            r10 = r18
            r4 = r20
            r3 = r21
        L_0x058a:
            java.lang.String r2 = zzh(r1, r13, r3, r4, r10)     // Catch:{ OutOfMemoryError -> 0x05ad, Exception -> 0x05ab, all -> 0x05a2 }
            byte[] r5 = new byte[r12]     // Catch:{ OutOfMemoryError -> 0x05ad, Exception -> 0x05ab, all -> 0x05a2 }
            r6 = 0
            r8.zzG(r5, r6, r12)     // Catch:{ OutOfMemoryError -> 0x05ad, Exception -> 0x05ab, all -> 0x05a2 }
            com.google.android.gms.internal.ads.zzafr r6 = new com.google.android.gms.internal.ads.zzafr     // Catch:{ OutOfMemoryError -> 0x05ad, Exception -> 0x05ab, all -> 0x05a2 }
            r6.<init>(r2, r5)     // Catch:{ OutOfMemoryError -> 0x05ad, Exception -> 0x05ab, all -> 0x05a2 }
            r2 = r6
        L_0x059a:
            r15 = r24
        L_0x059c:
            r8.zzK(r15)
            r14 = r2
            r2 = 0
            goto L_0x05b6
        L_0x05a2:
            r0 = move-exception
            r15 = r24
            goto L_0x0334
        L_0x05a7:
            r8.zzK(r15)
            throw r1
        L_0x05ab:
            r0 = move-exception
            goto L_0x05ae
        L_0x05ad:
            r0 = move-exception
        L_0x05ae:
            r15 = r24
            goto L_0x017b
        L_0x05b2:
            r8.zzK(r15)
            r14 = 0
        L_0x05b6:
            if (r14 != 0) goto L_0x05d9
            r5 = r23
            java.lang.String r1 = zzh(r1, r5, r3, r4, r10)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to decode frame: id="
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = ", frameSize="
            r3.append(r1)
            r3.append(r12)
            java.lang.String r1 = r3.toString()
            r3 = r22
            com.google.android.gms.internal.ads.zzea.zzg(r3, r1, r2)
        L_0x05d9:
            return r14
        L_0x05da:
            r8 = r2
            r3 = r11
            java.lang.String r1 = "Skipping unsupported compressed or encrypted frame"
            com.google.android.gms.internal.ads.zzea.zzf(r3, r1)
            r8.zzK(r15)
            r1 = 0
            return r1
        L_0x05e6:
            r8 = r2
            r1 = r14
            r8.zzK(r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagc.zzl(int, com.google.android.gms.internal.ads.zzek, boolean, int, com.google.android.gms.internal.ads.zzaga):com.google.android.gms.internal.ads.zzagd");
    }
}
