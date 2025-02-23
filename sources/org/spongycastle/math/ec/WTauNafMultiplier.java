package org.spongycastle.math.ec;

public class WTauNafMultiplier extends AbstractECMultiplier {
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fe, code lost:
        if (r5.b(org.spongycastle.math.ec.Tnaf.b) < 0) goto L_0x0100;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.spongycastle.math.ec.ECPoint b(org.spongycastle.math.ec.ECPoint r20, java.math.BigInteger r21) {
        /*
            r19 = this;
            r0 = r20
            r1 = r21
            boolean r2 = r0 instanceof org.spongycastle.math.ec.ECPoint.AbstractF2m
            if (r2 == 0) goto L_0x031c
            org.spongycastle.math.ec.ECPoint$AbstractF2m r0 = (org.spongycastle.math.ec.ECPoint.AbstractF2m) r0
            org.spongycastle.math.ec.ECCurve r2 = r0.f6620a
            org.spongycastle.math.ec.ECCurve$AbstractF2m r2 = (org.spongycastle.math.ec.ECCurve.AbstractF2m) r2
            int r3 = r2.k()
            org.spongycastle.math.ec.ECFieldElement r4 = r2.f6610a
            java.math.BigInteger r4 = r4.t()
            byte r4 = r4.byteValue()
            java.math.BigInteger r5 = org.spongycastle.math.ec.Tnaf.a
            r5 = -1
            r6 = 1
            if (r4 != 0) goto L_0x0024
            r7 = r5
            goto L_0x0025
        L_0x0024:
            r7 = r6
        L_0x0025:
            byte r7 = (byte) r7
            monitor-enter(r2)
            java.math.BigInteger[] r8 = r2.a     // Catch:{ all -> 0x0319 }
            if (r8 != 0) goto L_0x0031
            java.math.BigInteger[] r8 = org.spongycastle.math.ec.Tnaf.c(r2)     // Catch:{ all -> 0x0319 }
            r2.a = r8     // Catch:{ all -> 0x0319 }
        L_0x0031:
            java.math.BigInteger[] r8 = r2.a     // Catch:{ all -> 0x0319 }
            monitor-exit(r2)
            r9 = 0
            if (r7 != r6) goto L_0x0040
            r10 = r8[r9]
            r11 = r8[r6]
            java.math.BigInteger r10 = r10.add(r11)
            goto L_0x0048
        L_0x0040:
            r10 = r8[r9]
            r11 = r8[r6]
            java.math.BigInteger r10 = r10.subtract(r11)
        L_0x0048:
            java.math.BigInteger[] r11 = org.spongycastle.math.ec.Tnaf.b(r7, r3, r6)
            r11 = r11[r6]
            r12 = r8[r9]
            org.spongycastle.math.ec.SimpleBigDecimal r12 = org.spongycastle.math.ec.Tnaf.a(r1, r12, r11, r4, r3)
            r13 = r8[r6]
            org.spongycastle.math.ec.SimpleBigDecimal r3 = org.spongycastle.math.ec.Tnaf.a(r1, r13, r11, r4, r3)
            int r11 = r12.a
            int r13 = r3.a
            if (r13 != r11) goto L_0x0311
            if (r7 == r6) goto L_0x006d
            if (r7 != r5) goto L_0x0065
            goto L_0x006d
        L_0x0065:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "mu must be 1 or -1"
            r0.<init>(r1)
            throw r0
        L_0x006d:
            java.math.BigInteger r11 = r12.c()
            java.math.BigInteger r13 = r3.c()
            org.spongycastle.math.ec.SimpleBigDecimal r14 = new org.spongycastle.math.ec.SimpleBigDecimal
            int r15 = r12.a
            java.math.BigInteger r5 = r11.shiftLeft(r15)
            java.math.BigInteger r12 = r12.f6630a
            java.math.BigInteger r5 = r12.subtract(r5)
            r14.<init>(r15, r5)
            org.spongycastle.math.ec.SimpleBigDecimal r5 = new org.spongycastle.math.ec.SimpleBigDecimal
            int r12 = r3.a
            java.math.BigInteger r15 = r13.shiftLeft(r12)
            java.math.BigInteger r3 = r3.f6630a
            java.math.BigInteger r3 = r3.subtract(r15)
            r5.<init>(r12, r3)
            org.spongycastle.math.ec.SimpleBigDecimal r3 = r14.a(r14)
            if (r7 != r6) goto L_0x00a2
            org.spongycastle.math.ec.SimpleBigDecimal r3 = r3.a(r5)
            goto L_0x00a6
        L_0x00a2:
            org.spongycastle.math.ec.SimpleBigDecimal r3 = r3.d(r5)
        L_0x00a6:
            org.spongycastle.math.ec.SimpleBigDecimal r12 = r5.a(r5)
            org.spongycastle.math.ec.SimpleBigDecimal r12 = r12.a(r5)
            org.spongycastle.math.ec.SimpleBigDecimal r5 = r12.a(r5)
            if (r7 != r6) goto L_0x00bd
            org.spongycastle.math.ec.SimpleBigDecimal r12 = r14.d(r12)
            org.spongycastle.math.ec.SimpleBigDecimal r5 = r14.a(r5)
            goto L_0x00c5
        L_0x00bd:
            org.spongycastle.math.ec.SimpleBigDecimal r12 = r14.a(r12)
            org.spongycastle.math.ec.SimpleBigDecimal r5 = r14.d(r5)
        L_0x00c5:
            java.math.BigInteger r14 = org.spongycastle.math.ec.ECConstants.b
            int r15 = r3.b(r14)
            java.math.BigInteger r9 = org.spongycastle.math.ec.Tnaf.a
            if (r15 < 0) goto L_0x00d8
            int r15 = r12.b(r9)
            if (r15 >= 0) goto L_0x00d6
            goto L_0x00e0
        L_0x00d6:
            r15 = r6
            goto L_0x00e5
        L_0x00d8:
            java.math.BigInteger r15 = org.spongycastle.math.ec.ECConstants.c
            int r15 = r5.b(r15)
            if (r15 < 0) goto L_0x00e4
        L_0x00e0:
            r16 = r7
            r15 = 0
            goto L_0x00e7
        L_0x00e4:
            r15 = 0
        L_0x00e5:
            r16 = 0
        L_0x00e7:
            int r3 = r3.b(r9)
            if (r3 >= 0) goto L_0x00f8
            int r3 = r12.b(r14)
            if (r3 < 0) goto L_0x00f4
            goto L_0x0100
        L_0x00f4:
            r3 = r16
            r15 = -1
            goto L_0x0106
        L_0x00f8:
            java.math.BigInteger r3 = org.spongycastle.math.ec.Tnaf.b
            int r3 = r5.b(r3)
            if (r3 >= 0) goto L_0x0104
        L_0x0100:
            int r3 = -r7
            byte r3 = (byte) r3
            r16 = r3
        L_0x0104:
            r3 = r16
        L_0x0106:
            long r14 = (long) r15
            java.math.BigInteger r5 = java.math.BigInteger.valueOf(r14)
            java.math.BigInteger r5 = r11.add(r5)
            long r11 = (long) r3
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r11)
            java.math.BigInteger r3 = r13.add(r3)
            java.math.BigInteger r9 = r10.multiply(r5)
            java.math.BigInteger r1 = r1.subtract(r9)
            r9 = 2
            java.math.BigInteger r9 = java.math.BigInteger.valueOf(r9)
            r10 = r8[r6]
            java.math.BigInteger r9 = r9.multiply(r10)
            java.math.BigInteger r9 = r9.multiply(r3)
            java.math.BigInteger r1 = r1.subtract(r9)
            r9 = r8[r6]
            java.math.BigInteger r5 = r9.multiply(r5)
            r9 = 0
            r8 = r8[r9]
            java.math.BigInteger r3 = r8.multiply(r3)
            java.math.BigInteger r3 = r5.subtract(r3)
            java.lang.String r5 = "bc_wtnaf"
            org.spongycastle.math.ec.PreCompInfo r2 = r2.m(r0, r5)
            if (r4 != 0) goto L_0x0150
            org.spongycastle.math.ec.ZTauElement[] r4 = org.spongycastle.math.ec.Tnaf.f6631a
            goto L_0x0152
        L_0x0150:
            org.spongycastle.math.ec.ZTauElement[] r4 = org.spongycastle.math.ec.Tnaf.f6633b
        L_0x0152:
            if (r7 != r6) goto L_0x015b
            r8 = 6
            java.math.BigInteger r5 = java.math.BigInteger.valueOf(r8)
            goto L_0x0161
        L_0x015b:
            r8 = 10
            java.math.BigInteger r5 = java.math.BigInteger.valueOf(r8)
        L_0x0161:
            r8 = 16
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r8)
            java.lang.String r9 = "mu must be 1 or -1"
            if (r7 == r6) goto L_0x0175
            r10 = -1
            if (r7 != r10) goto L_0x016f
            goto L_0x0175
        L_0x016f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r9)
            throw r0
        L_0x0175:
            java.math.BigInteger r10 = r1.multiply(r1)
            java.math.BigInteger r11 = r1.multiply(r3)
            java.math.BigInteger r12 = r3.multiply(r3)
            java.math.BigInteger r12 = r12.shiftLeft(r6)
            if (r7 != r6) goto L_0x0190
            java.math.BigInteger r9 = r10.add(r11)
            java.math.BigInteger r9 = r9.add(r12)
            goto L_0x019b
        L_0x0190:
            r13 = -1
            if (r7 != r13) goto L_0x030b
            java.math.BigInteger r9 = r10.subtract(r11)
            java.math.BigInteger r9 = r9.add(r12)
        L_0x019b:
            int r9 = r9.bitLength()
            r10 = 30
            if (r9 <= r10) goto L_0x01a8
            int r9 = r9 + 4
            int r9 = r9 + 4
            goto L_0x01aa
        L_0x01a8:
            r9 = 38
        L_0x01aa:
            r10 = r9
            byte[] r11 = new byte[r10]
            java.math.BigInteger r12 = r8.shiftRight(r6)
            r9 = 0
        L_0x01b2:
            java.math.BigInteger r13 = org.spongycastle.math.ec.ECConstants.a
            boolean r14 = r1.equals(r13)
            if (r14 == 0) goto L_0x028a
            boolean r13 = r3.equals(r13)
            if (r13 != 0) goto L_0x01c2
            goto L_0x028a
        L_0x01c2:
            org.spongycastle.math.ec.ECCurve r1 = r0.f6620a
            org.spongycastle.math.ec.ECCurve$AbstractF2m r1 = (org.spongycastle.math.ec.ECCurve.AbstractF2m) r1
            org.spongycastle.math.ec.ECFieldElement r3 = r1.f6610a
            java.math.BigInteger r3 = r3.t()
            byte r3 = r3.byteValue()
            org.spongycastle.math.ec.ECCurve r4 = r0.f6620a
            if (r2 == 0) goto L_0x01de
            boolean r5 = r2 instanceof org.spongycastle.math.ec.WTauNafPreCompInfo
            if (r5 != 0) goto L_0x01d9
            goto L_0x01de
        L_0x01d9:
            org.spongycastle.math.ec.WTauNafPreCompInfo r2 = (org.spongycastle.math.ec.WTauNafPreCompInfo) r2
            org.spongycastle.math.ec.ECPoint$AbstractF2m[] r0 = r2.a
            goto L_0x0244
        L_0x01de:
            if (r3 != 0) goto L_0x01e3
            byte[][] r2 = org.spongycastle.math.ec.Tnaf.f6632a
            goto L_0x01e5
        L_0x01e3:
            byte[][] r2 = org.spongycastle.math.ec.Tnaf.f6634b
        L_0x01e5:
            int r3 = r2.length
            int r3 = r3 + r6
            int r3 = r3 >>> r6
            org.spongycastle.math.ec.ECPoint$AbstractF2m[] r5 = new org.spongycastle.math.ec.ECPoint.AbstractF2m[r3]
            r7 = 0
            r5[r7] = r0
            int r7 = r2.length
            r8 = 3
        L_0x01ef:
            if (r8 >= r7) goto L_0x022f
            int r9 = r8 >>> 1
            r12 = r2[r8]
            org.spongycastle.math.ec.ECPoint r13 = r4.l()
            org.spongycastle.math.ec.ECPoint$AbstractF2m r13 = (org.spongycastle.math.ec.ECPoint.AbstractF2m) r13
            org.spongycastle.math.ec.ECPoint r14 = r0.n()
            org.spongycastle.math.ec.ECPoint$AbstractF2m r14 = (org.spongycastle.math.ec.ECPoint.AbstractF2m) r14
            int r15 = r12.length
            r16 = -1
            int r15 = r15 + -1
            r6 = 0
        L_0x0207:
            if (r15 < 0) goto L_0x0223
            int r6 = r6 + 1
            byte r17 = r12[r15]
            if (r17 == 0) goto L_0x0220
            org.spongycastle.math.ec.ECPoint$AbstractF2m r6 = r13.z(r6)
            if (r17 <= 0) goto L_0x0217
            r13 = r0
            goto L_0x0218
        L_0x0217:
            r13 = r14
        L_0x0218:
            org.spongycastle.math.ec.ECPoint r6 = r6.a(r13)
            org.spongycastle.math.ec.ECPoint$AbstractF2m r6 = (org.spongycastle.math.ec.ECPoint.AbstractF2m) r6
            r13 = r6
            r6 = 0
        L_0x0220:
            int r15 = r15 + -1
            goto L_0x0207
        L_0x0223:
            if (r6 <= 0) goto L_0x0229
            org.spongycastle.math.ec.ECPoint$AbstractF2m r13 = r13.z(r6)
        L_0x0229:
            r5[r9] = r13
            int r8 = r8 + 2
            r6 = 1
            goto L_0x01ef
        L_0x022f:
            r4.getClass()
            r2 = 0
            r6 = 0
            r4.p(r5, r6, r3, r2)
            org.spongycastle.math.ec.WTauNafPreCompInfo r2 = new org.spongycastle.math.ec.WTauNafPreCompInfo
            r2.<init>()
            r2.a = r5
            java.lang.String r3 = "bc_wtnaf"
            r1.q(r0, r3, r2)
            r0 = r5
        L_0x0244:
            int r1 = r0.length
            org.spongycastle.math.ec.ECPoint$AbstractF2m[] r1 = new org.spongycastle.math.ec.ECPoint.AbstractF2m[r1]
            r2 = 0
        L_0x0248:
            int r3 = r0.length
            if (r2 >= r3) goto L_0x0258
            r3 = r0[r2]
            org.spongycastle.math.ec.ECPoint r3 = r3.n()
            org.spongycastle.math.ec.ECPoint$AbstractF2m r3 = (org.spongycastle.math.ec.ECPoint.AbstractF2m) r3
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x0248
        L_0x0258:
            org.spongycastle.math.ec.ECPoint r2 = r4.l()
            org.spongycastle.math.ec.ECPoint$AbstractF2m r2 = (org.spongycastle.math.ec.ECPoint.AbstractF2m) r2
            r6 = -1
            int r10 = r10 + r6
            r3 = 0
        L_0x0261:
            if (r10 < 0) goto L_0x0283
            int r3 = r3 + 1
            byte r4 = r11[r10]
            if (r4 == 0) goto L_0x0280
            org.spongycastle.math.ec.ECPoint$AbstractF2m r2 = r2.z(r3)
            if (r4 <= 0) goto L_0x0274
            int r3 = r4 >>> 1
            r3 = r0[r3]
            goto L_0x0279
        L_0x0274:
            int r3 = -r4
            r4 = 1
            int r3 = r3 >>> r4
            r3 = r1[r3]
        L_0x0279:
            org.spongycastle.math.ec.ECPoint r2 = r2.a(r3)
            org.spongycastle.math.ec.ECPoint$AbstractF2m r2 = (org.spongycastle.math.ec.ECPoint.AbstractF2m) r2
            r3 = 0
        L_0x0280:
            int r10 = r10 + -1
            goto L_0x0261
        L_0x0283:
            if (r3 <= 0) goto L_0x0289
            org.spongycastle.math.ec.ECPoint$AbstractF2m r2 = r2.z(r3)
        L_0x0289:
            return r2
        L_0x028a:
            r6 = -1
            r13 = 0
            boolean r14 = r1.testBit(r13)
            if (r14 == 0) goto L_0x02e2
            java.math.BigInteger r13 = r3.multiply(r5)
            java.math.BigInteger r13 = r1.add(r13)
            java.math.BigInteger r13 = r13.mod(r8)
            int r14 = r13.compareTo(r12)
            if (r14 < 0) goto L_0x02ad
            java.math.BigInteger r13 = r13.subtract(r8)
            int r13 = r13.intValue()
            goto L_0x02b1
        L_0x02ad:
            int r13 = r13.intValue()
        L_0x02b1:
            byte r13 = (byte) r13
            r11[r9] = r13
            if (r13 >= 0) goto L_0x02bb
            int r13 = -r13
            byte r13 = (byte) r13
            r14 = r13
            r13 = 0
            goto L_0x02bd
        L_0x02bb:
            r14 = r13
            r13 = 1
        L_0x02bd:
            if (r13 == 0) goto L_0x02d0
            r13 = r4[r14]
            java.math.BigInteger r13 = r13.a
            java.math.BigInteger r1 = r1.subtract(r13)
            r13 = r4[r14]
            java.math.BigInteger r13 = r13.b
            java.math.BigInteger r3 = r3.subtract(r13)
            goto L_0x02e0
        L_0x02d0:
            r13 = r4[r14]
            java.math.BigInteger r13 = r13.a
            java.math.BigInteger r1 = r1.add(r13)
            r13 = r4[r14]
            java.math.BigInteger r13 = r13.b
            java.math.BigInteger r3 = r3.add(r13)
        L_0x02e0:
            r13 = 0
            goto L_0x02e5
        L_0x02e2:
            r13 = 0
            r11[r9] = r13
        L_0x02e5:
            r14 = 1
            if (r7 != r14) goto L_0x02f1
            java.math.BigInteger r15 = r1.shiftRight(r14)
            java.math.BigInteger r3 = r3.add(r15)
            goto L_0x02f9
        L_0x02f1:
            java.math.BigInteger r15 = r1.shiftRight(r14)
            java.math.BigInteger r3 = r3.subtract(r15)
        L_0x02f9:
            java.math.BigInteger r1 = r1.shiftRight(r14)
            java.math.BigInteger r1 = r1.negate()
            int r9 = r9 + 1
            r6 = r14
            r18 = r3
            r3 = r1
            r1 = r18
            goto L_0x01b2
        L_0x030b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r9)
            throw r0
        L_0x0311:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "lambda0 and lambda1 do not have same scale"
            r0.<init>(r1)
            throw r0
        L_0x0319:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x031c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Only ECPoint.AbstractF2m can be used in WTauNafMultiplier"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.WTauNafMultiplier.b(org.spongycastle.math.ec.ECPoint, java.math.BigInteger):org.spongycastle.math.ec.ECPoint");
    }
}
