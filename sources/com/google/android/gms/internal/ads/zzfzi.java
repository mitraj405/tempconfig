package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfzi extends zzfxu {
    static final zzfxu zza = new zzfzi((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzfzi(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: short[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfzi zzj(int r16, java.lang.Object[] r17, com.google.android.gms.internal.ads.zzfxt r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            if (r0 != 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzfxu r0 = zza
            com.google.android.gms.internal.ads.zzfzi r0 = (com.google.android.gms.internal.ads.zzfzi) r0
            return r0
        L_0x000d:
            r3 = 0
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L_0x0025
            r0 = r1[r4]
            java.util.Objects.requireNonNull(r0)
            r2 = r1[r5]
            java.util.Objects.requireNonNull(r2)
            com.google.android.gms.internal.ads.zzfwo.zzb(r0, r2)
            com.google.android.gms.internal.ads.zzfzi r0 = new com.google.android.gms.internal.ads.zzfzi
            r0.<init>(r3, r1, r5)
            return r0
        L_0x0025:
            int r6 = r1.length
            int r6 = r6 >> r5
            java.lang.String r7 = "index"
            com.google.android.gms.internal.ads.zzfuu.zzb(r0, r6, r7)
            int r6 = com.google.android.gms.internal.ads.zzfxw.zzh(r16)
            if (r0 != r5) goto L_0x0044
            r0 = r1[r4]
            java.util.Objects.requireNonNull(r0)
            r6 = r1[r5]
            java.util.Objects.requireNonNull(r6)
            com.google.android.gms.internal.ads.zzfwo.zzb(r0, r6)
            r0 = r5
            r7 = r0
            r5 = 2
            goto L_0x0196
        L_0x0044:
            int r8 = r6 + -1
            r9 = 128(0x80, float:1.794E-43)
            r10 = 3
            r11 = -1
            if (r6 > r9) goto L_0x00bc
            byte[] r6 = new byte[r6]
            java.util.Arrays.fill(r6, r11)
            r9 = r4
            r11 = r9
        L_0x0053:
            if (r9 >= r0) goto L_0x00a4
            int r12 = r11 + r11
            int r13 = r9 + r9
            r14 = r1[r13]
            java.util.Objects.requireNonNull(r14)
            r13 = r13 ^ r5
            r13 = r1[r13]
            java.util.Objects.requireNonNull(r13)
            com.google.android.gms.internal.ads.zzfwo.zzb(r14, r13)
            int r15 = r14.hashCode()
            int r15 = com.google.android.gms.internal.ads.zzfxj.zza(r15)
        L_0x006f:
            r15 = r15 & r8
            byte r7 = r6[r15]
            r5 = 255(0xff, float:3.57E-43)
            r7 = r7 & r5
            if (r7 != r5) goto L_0x0085
            byte r5 = (byte) r12
            r6[r15] = r5
            if (r11 >= r9) goto L_0x0082
            r1[r12] = r14
            r5 = r12 ^ 1
            r1[r5] = r13
        L_0x0082:
            int r11 = r11 + 1
            goto L_0x009c
        L_0x0085:
            r5 = r1[r7]
            boolean r5 = r14.equals(r5)
            if (r5 == 0) goto L_0x00a0
            r3 = r7 ^ 1
            com.google.android.gms.internal.ads.zzfxs r5 = new com.google.android.gms.internal.ads.zzfxs
            r7 = r1[r3]
            java.util.Objects.requireNonNull(r7)
            r5.<init>(r14, r13, r7)
            r1[r3] = r13
            r3 = r5
        L_0x009c:
            int r9 = r9 + 1
            r5 = 1
            goto L_0x0053
        L_0x00a0:
            int r15 = r15 + 1
            r5 = 1
            goto L_0x006f
        L_0x00a4:
            if (r11 != r0) goto L_0x00a9
            r3 = r6
        L_0x00a7:
            r5 = 2
            goto L_0x00b9
        L_0x00a9:
            java.lang.Object[] r5 = new java.lang.Object[r10]
            r5[r4] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)
            r7 = 1
            r5[r7] = r6
            r6 = 2
            r5[r6] = r3
            r3 = r5
            r5 = r6
        L_0x00b9:
            r7 = 1
            goto L_0x0196
        L_0x00bc:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r6 > r5) goto L_0x012c
            short[] r5 = new short[r6]
            java.util.Arrays.fill(r5, r11)
            r6 = r4
            r7 = r6
        L_0x00c8:
            if (r6 >= r0) goto L_0x0119
            int r9 = r7 + r7
            int r11 = r6 + r6
            r12 = r1[r11]
            java.util.Objects.requireNonNull(r12)
            r13 = 1
            r11 = r11 ^ r13
            r11 = r1[r11]
            java.util.Objects.requireNonNull(r11)
            com.google.android.gms.internal.ads.zzfwo.zzb(r12, r11)
            int r13 = r12.hashCode()
            int r13 = com.google.android.gms.internal.ads.zzfxj.zza(r13)
        L_0x00e5:
            r13 = r13 & r8
            short r14 = r5[r13]
            char r14 = (char) r14
            r15 = 65535(0xffff, float:9.1834E-41)
            if (r14 != r15) goto L_0x00fc
            short r14 = (short) r9
            r5[r13] = r14
            if (r7 >= r6) goto L_0x00f9
            r1[r9] = r12
            r9 = r9 ^ 1
            r1[r9] = r11
        L_0x00f9:
            int r7 = r7 + 1
            goto L_0x0113
        L_0x00fc:
            r15 = r1[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x0116
            r3 = r14 ^ 1
            com.google.android.gms.internal.ads.zzfxs r9 = new com.google.android.gms.internal.ads.zzfxs
            r13 = r1[r3]
            java.util.Objects.requireNonNull(r13)
            r9.<init>(r12, r11, r13)
            r1[r3] = r11
            r3 = r9
        L_0x0113:
            int r6 = r6 + 1
            goto L_0x00c8
        L_0x0116:
            int r13 = r13 + 1
            goto L_0x00e5
        L_0x0119:
            if (r7 != r0) goto L_0x011c
            goto L_0x0184
        L_0x011c:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r7 = 1
            r6[r7] = r5
            r5 = 2
            r6[r5] = r3
            goto L_0x0195
        L_0x012c:
            r7 = 1
            int[] r5 = new int[r6]
            java.util.Arrays.fill(r5, r11)
            r6 = r4
            r9 = r6
        L_0x0134:
            if (r6 >= r0) goto L_0x0182
            int r12 = r9 + r9
            int r13 = r6 + r6
            r14 = r1[r13]
            java.util.Objects.requireNonNull(r14)
            r13 = r13 ^ r7
            r7 = r1[r13]
            java.util.Objects.requireNonNull(r7)
            com.google.android.gms.internal.ads.zzfwo.zzb(r14, r7)
            int r13 = r14.hashCode()
            int r13 = com.google.android.gms.internal.ads.zzfxj.zza(r13)
        L_0x0150:
            r13 = r13 & r8
            r15 = r5[r13]
            if (r15 != r11) goto L_0x0162
            r5[r13] = r12
            if (r9 >= r6) goto L_0x015f
            r1[r12] = r14
            r12 = r12 ^ 1
            r1[r12] = r7
        L_0x015f:
            int r9 = r9 + 1
            goto L_0x0179
        L_0x0162:
            r11 = r1[r15]
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x017e
            r3 = r15 ^ 1
            com.google.android.gms.internal.ads.zzfxs r11 = new com.google.android.gms.internal.ads.zzfxs
            r12 = r1[r3]
            java.util.Objects.requireNonNull(r12)
            r11.<init>(r14, r7, r12)
            r1[r3] = r7
            r3 = r11
        L_0x0179:
            int r6 = r6 + 1
            r7 = 1
            r11 = -1
            goto L_0x0134
        L_0x017e:
            int r13 = r13 + 1
            r11 = -1
            goto L_0x0150
        L_0x0182:
            if (r9 != r0) goto L_0x0187
        L_0x0184:
            r3 = r5
            goto L_0x00a7
        L_0x0187:
            java.lang.Object[] r6 = new java.lang.Object[r10]
            r6[r4] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            r7 = 1
            r6[r7] = r5
            r5 = 2
            r6[r5] = r3
        L_0x0195:
            r3 = r6
        L_0x0196:
            boolean r6 = r3 instanceof java.lang.Object[]
            if (r6 == 0) goto L_0x01bd
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r0 = r3[r5]
            com.google.android.gms.internal.ads.zzfxs r0 = (com.google.android.gms.internal.ads.zzfxs) r0
            if (r2 == 0) goto L_0x01b8
            r2.zzc = r0
            r0 = r3[r4]
            r2 = r3[r7]
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r3 = r2 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)
            r3 = r0
            r0 = r2
            goto L_0x01bd
        L_0x01b8:
            java.lang.IllegalArgumentException r0 = r0.zza()
            throw r0
        L_0x01bd:
            com.google.android.gms.internal.ads.zzfzi r2 = new com.google.android.gms.internal.ads.zzfzi
            r2.<init>(r3, r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfzi.zzj(int, java.lang.Object[], com.google.android.gms.internal.ads.zzfxt):com.google.android.gms.internal.ads.zzfzi");
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.Object r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0006
        L_0x0003:
            r10 = r0
            goto L_0x009c
        L_0x0006:
            int r1 = r9.zzd
            java.lang.Object[] r2 = r9.zzb
            r3 = 1
            if (r1 != r3) goto L_0x0020
            r1 = 0
            r1 = r2[r1]
            java.util.Objects.requireNonNull(r1)
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L_0x0003
            r10 = r2[r3]
            java.util.Objects.requireNonNull(r10)
            goto L_0x009c
        L_0x0020:
            java.lang.Object r1 = r9.zzc
            if (r1 != 0) goto L_0x0025
            goto L_0x0003
        L_0x0025:
            boolean r4 = r1 instanceof byte[]
            r5 = -1
            if (r4 == 0) goto L_0x0051
            r4 = r1
            byte[] r4 = (byte[]) r4
            int r1 = r4.length
            int r6 = r1 + -1
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.ads.zzfxj.zza(r1)
        L_0x0038:
            r1 = r1 & r6
            byte r5 = r4[r1]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0041
            goto L_0x0003
        L_0x0041:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x004e
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L_0x009c
        L_0x004e:
            int r1 = r1 + 1
            goto L_0x0038
        L_0x0051:
            boolean r4 = r1 instanceof short[]
            if (r4 == 0) goto L_0x007d
            r4 = r1
            short[] r4 = (short[]) r4
            int r1 = r4.length
            int r6 = r1 + -1
            int r1 = r10.hashCode()
            int r1 = com.google.android.gms.internal.ads.zzfxj.zza(r1)
        L_0x0063:
            r1 = r1 & r6
            short r5 = r4[r1]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006d
            goto L_0x0003
        L_0x006d:
            r7 = r2[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007a
            r10 = r5 ^ 1
            r10 = r2[r10]
            goto L_0x009c
        L_0x007a:
            int r1 = r1 + 1
            goto L_0x0063
        L_0x007d:
            int[] r1 = (int[]) r1
            int r4 = r1.length
            int r4 = r4 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfxj.zza(r6)
        L_0x0089:
            r6 = r6 & r4
            r7 = r1[r6]
            if (r7 != r5) goto L_0x0090
            goto L_0x0003
        L_0x0090:
            r8 = r2[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a0
            r10 = r7 ^ 1
            r10 = r2[r10]
        L_0x009c:
            if (r10 != 0) goto L_0x009f
            return r0
        L_0x009f:
            return r10
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfzi.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    public final zzfxm zza() {
        return new zzfzh(this.zzb, 1, this.zzd);
    }

    public final zzfxw zzf() {
        return new zzfzf(this, this.zzb, 0, this.zzd);
    }

    public final zzfxw zzg() {
        return new zzfzg(this, new zzfzh(this.zzb, 0, this.zzd));
    }
}
