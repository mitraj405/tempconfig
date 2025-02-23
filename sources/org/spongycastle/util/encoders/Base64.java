package org.spongycastle.util.encoders;

public class Base64 {
    public static final Base64Encoder a = new Base64Encoder();

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        r4 = r11.charAt(r5);
        r5 = r11.charAt(r2 - 3);
        r7 = r11.charAt(r2 - 2);
        r11 = r11.charAt(r2 - 1);
        r0 = r0.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b1, code lost:
        if (r7 != r0) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b3, code lost:
        if (r11 != r0) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b5, code lost:
        r11 = r6[r4];
        r0 = r6[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bb, code lost:
        if ((r11 | r0) < 0) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
        r1.write((r11 << 2) | (r0 >> 4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
        throw new java.io.IOException("invalid characters encountered at end of base64 data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d1, code lost:
        throw new java.io.IOException("invalid characters encountered at end of base64 data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d2, code lost:
        if (r11 != r0) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d4, code lost:
        r11 = r6[r4];
        r0 = r6[r5];
        r3 = r6[r7];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dd, code lost:
        if (((r11 | r0) | r3) < 0) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00df, code lost:
        r1.write((r11 << 2) | (r0 >> 4));
        r1.write((r0 << 4) | (r3 >> 2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f5, code lost:
        throw new java.io.IOException("invalid characters encountered at end of base64 data");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f6, code lost:
        r0 = r6[r4];
        r3 = r6[r5];
        r4 = r6[r7];
        r11 = r6[r11];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0102, code lost:
        if ((((r0 | r3) | r4) | r11) < 0) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
        r1.write((r0 << 2) | (r3 >> 4));
        r1.write((r3 << 4) | (r4 >> 2));
        r1.write(r11 | (r4 << 6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011e, code lost:
        return r1.toByteArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0124, code lost:
        throw new java.io.IOException("invalid characters encountered at end of base64 data");
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[Catch:{ Exception -> 0x0125 }, LOOP:0: B:3:0x0016->B:18:0x0037, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0036 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r11) {
        /*
            int r0 = r11.length()
            int r0 = r0 / 4
            int r0 = r0 * 3
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>(r0)
            org.spongycastle.util.encoders.Base64Encoder r0 = a     // Catch:{ Exception -> 0x0125 }
            r0.getClass()     // Catch:{ Exception -> 0x0125 }
            int r2 = r11.length()     // Catch:{ Exception -> 0x0125 }
        L_0x0016:
            r3 = 1
            r4 = 0
            if (r2 <= 0) goto L_0x0039
            int r5 = r2 + -1
            char r6 = r11.charAt(r5)     // Catch:{ Exception -> 0x0125 }
            r7 = 10
            if (r6 == r7) goto L_0x0033
            r7 = 13
            if (r6 == r7) goto L_0x0033
            r7 = 9
            if (r6 == r7) goto L_0x0033
            r7 = 32
            if (r6 != r7) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r6 = r4
            goto L_0x0034
        L_0x0033:
            r6 = r3
        L_0x0034:
            if (r6 != 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r2 = r5
            goto L_0x0016
        L_0x0039:
            int r5 = r2 + -4
            int r4 = org.spongycastle.util.encoders.Base64Encoder.a(r4, r5, r11)     // Catch:{ Exception -> 0x0125 }
        L_0x003f:
            byte[] r6 = r0.b     // Catch:{ Exception -> 0x0125 }
            if (r4 >= r5) goto L_0x0098
            int r7 = r4 + 1
            char r4 = r11.charAt(r4)     // Catch:{ Exception -> 0x0125 }
            byte r4 = r6[r4]     // Catch:{ Exception -> 0x0125 }
            int r7 = org.spongycastle.util.encoders.Base64Encoder.a(r7, r5, r11)     // Catch:{ Exception -> 0x0125 }
            int r8 = r7 + 1
            char r7 = r11.charAt(r7)     // Catch:{ Exception -> 0x0125 }
            byte r7 = r6[r7]     // Catch:{ Exception -> 0x0125 }
            int r8 = org.spongycastle.util.encoders.Base64Encoder.a(r8, r5, r11)     // Catch:{ Exception -> 0x0125 }
            int r9 = r8 + 1
            char r8 = r11.charAt(r8)     // Catch:{ Exception -> 0x0125 }
            byte r8 = r6[r8]     // Catch:{ Exception -> 0x0125 }
            int r9 = org.spongycastle.util.encoders.Base64Encoder.a(r9, r5, r11)     // Catch:{ Exception -> 0x0125 }
            int r10 = r9 + 1
            char r9 = r11.charAt(r9)     // Catch:{ Exception -> 0x0125 }
            byte r6 = r6[r9]     // Catch:{ Exception -> 0x0125 }
            r9 = r4 | r7
            r9 = r9 | r8
            r9 = r9 | r6
            if (r9 < 0) goto L_0x0090
            int r4 = r4 << 2
            int r9 = r7 >> 4
            r4 = r4 | r9
            r1.write(r4)     // Catch:{ Exception -> 0x0125 }
            int r4 = r7 << 4
            int r7 = r8 >> 2
            r4 = r4 | r7
            r1.write(r4)     // Catch:{ Exception -> 0x0125 }
            int r4 = r8 << 6
            r4 = r4 | r6
            r1.write(r4)     // Catch:{ Exception -> 0x0125 }
            int r4 = org.spongycastle.util.encoders.Base64Encoder.a(r10, r5, r11)     // Catch:{ Exception -> 0x0125 }
            goto L_0x003f
        L_0x0090:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ Exception -> 0x0125 }
            java.lang.String r0 = "invalid characters encountered in base64 data"
            r11.<init>(r0)     // Catch:{ Exception -> 0x0125 }
            throw r11     // Catch:{ Exception -> 0x0125 }
        L_0x0098:
            char r4 = r11.charAt(r5)     // Catch:{ Exception -> 0x0125 }
            int r5 = r2 + -3
            char r5 = r11.charAt(r5)     // Catch:{ Exception -> 0x0125 }
            int r7 = r2 + -2
            char r7 = r11.charAt(r7)     // Catch:{ Exception -> 0x0125 }
            int r2 = r2 - r3
            char r11 = r11.charAt(r2)     // Catch:{ Exception -> 0x0125 }
            byte r0 = r0.a     // Catch:{ Exception -> 0x0125 }
            java.lang.String r2 = "invalid characters encountered at end of base64 data"
            if (r7 != r0) goto L_0x00d2
            if (r11 != r0) goto L_0x00cc
            byte r11 = r6[r4]     // Catch:{ Exception -> 0x0125 }
            byte r0 = r6[r5]     // Catch:{ Exception -> 0x0125 }
            r3 = r11 | r0
            if (r3 < 0) goto L_0x00c6
            int r11 = r11 << 2
            int r0 = r0 >> 4
            r11 = r11 | r0
            r1.write(r11)     // Catch:{ Exception -> 0x0125 }
            goto L_0x011a
        L_0x00c6:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ Exception -> 0x0125 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0125 }
            throw r11     // Catch:{ Exception -> 0x0125 }
        L_0x00cc:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ Exception -> 0x0125 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0125 }
            throw r11     // Catch:{ Exception -> 0x0125 }
        L_0x00d2:
            if (r11 != r0) goto L_0x00f6
            byte r11 = r6[r4]     // Catch:{ Exception -> 0x0125 }
            byte r0 = r6[r5]     // Catch:{ Exception -> 0x0125 }
            byte r3 = r6[r7]     // Catch:{ Exception -> 0x0125 }
            r4 = r11 | r0
            r4 = r4 | r3
            if (r4 < 0) goto L_0x00f0
            int r11 = r11 << 2
            int r2 = r0 >> 4
            r11 = r11 | r2
            r1.write(r11)     // Catch:{ Exception -> 0x0125 }
            int r11 = r0 << 4
            int r0 = r3 >> 2
            r11 = r11 | r0
            r1.write(r11)     // Catch:{ Exception -> 0x0125 }
            goto L_0x011a
        L_0x00f0:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ Exception -> 0x0125 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0125 }
            throw r11     // Catch:{ Exception -> 0x0125 }
        L_0x00f6:
            byte r0 = r6[r4]     // Catch:{ Exception -> 0x0125 }
            byte r3 = r6[r5]     // Catch:{ Exception -> 0x0125 }
            byte r4 = r6[r7]     // Catch:{ Exception -> 0x0125 }
            byte r11 = r6[r11]     // Catch:{ Exception -> 0x0125 }
            r5 = r0 | r3
            r5 = r5 | r4
            r5 = r5 | r11
            if (r5 < 0) goto L_0x011f
            int r0 = r0 << 2
            int r2 = r3 >> 4
            r0 = r0 | r2
            r1.write(r0)     // Catch:{ Exception -> 0x0125 }
            int r0 = r3 << 4
            int r2 = r4 >> 2
            r0 = r0 | r2
            r1.write(r0)     // Catch:{ Exception -> 0x0125 }
            int r0 = r4 << 6
            r11 = r11 | r0
            r1.write(r11)     // Catch:{ Exception -> 0x0125 }
        L_0x011a:
            byte[] r11 = r1.toByteArray()
            return r11
        L_0x011f:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ Exception -> 0x0125 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0125 }
            throw r11     // Catch:{ Exception -> 0x0125 }
        L_0x0125:
            r11 = move-exception
            org.spongycastle.util.encoders.DecoderException r0 = new org.spongycastle.util.encoders.DecoderException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "unable to decode base64 string: "
            r1.<init>(r2)
            java.lang.String r1 = defpackage.C1058d.M(r11, r1)
            r0.<init>(r1, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.encoders.Base64.a(java.lang.String):byte[]");
    }
}
