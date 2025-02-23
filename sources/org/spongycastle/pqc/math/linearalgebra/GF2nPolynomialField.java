package org.spongycastle.pqc.math.linearalgebra;

public class GF2nPolynomialField extends GF2nField {
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b8, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01bb, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r18 = this;
            r0 = r18
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r1.<init>()
            r0.a = r1
            r1.e()
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = r0.a
            r1.e()
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r1.<init>()
            r0.a = r1
            r1.e()
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = r0.a
            r1.e()
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r1.<init>()
            r0.a = r1
        L_0x0027:
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = r0.a
            r3 = 0
        L_0x002a:
            int r4 = r1.f6848b
            if (r3 >= r4) goto L_0x003b
            int[] r4 = r1.f6847a
            java.util.Random r5 = org.spongycastle.pqc.math.linearalgebra.GF2Polynomial.a
            int r5 = r5.nextInt()
            r4[r3] = r5
            int r3 = r3 + 1
            goto L_0x002a
        L_0x003b:
            r1.g()
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = r0.a
            r1.e()
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = r0.a
            r1.e()
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r1 = r0.a
            boolean r3 = r1.b()
            if (r3 == 0) goto L_0x0053
            r2 = 0
            goto L_0x01bb
        L_0x0053:
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r3 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r3.<init>((org.spongycastle.pqc.math.linearalgebra.GF2Polynomial) r1)
            r3.c()
            int r1 = r3.f6846a
            int r4 = r1 + -1
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r5 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r5.<init>((int) r1)
            r1 = 1
            r6 = r1
        L_0x0066:
            int r7 = r4 >> 1
            if (r6 > r7) goto L_0x01ba
            boolean r7 = r5.b()
            if (r7 == 0) goto L_0x0072
            goto L_0x00fd
        L_0x0072:
            int[] r7 = r5.f6847a
            int r7 = r7.length
            int r8 = r5.f6848b
            int r9 = r8 << 1
            short[] r10 = org.spongycastle.pqc.math.linearalgebra.GF2Polynomial.f6845a
            r11 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r12 = 16711680(0xff0000, float:2.3418052E-38)
            r13 = 65280(0xff00, float:9.1477E-41)
            if (r7 < r9) goto L_0x00bf
        L_0x0084:
            int r8 = r8 + -1
            if (r8 < 0) goto L_0x00b2
            int[] r7 = r5.f6847a
            int r9 = r8 << 1
            int r14 = r9 + 1
            r15 = r7[r8]
            r16 = r15 & r12
            int r16 = r16 >>> 16
            short r16 = r10[r16]
            r15 = r15 & r11
            int r15 = r15 >>> 24
            short r15 = r10[r15]
            int r15 = r15 << 16
            r15 = r15 | r16
            r7[r14] = r15
            r14 = r7[r8]
            r15 = r14 & 255(0xff, float:3.57E-43)
            short r15 = r10[r15]
            r14 = r14 & r13
            int r14 = r14 >>> 8
            short r14 = r10[r14]
            int r14 = r14 << 16
            r14 = r14 | r15
            r7[r9] = r14
            goto L_0x0084
        L_0x00b2:
            int r7 = r5.f6848b
            int r7 = r7 << r1
            r5.f6848b = r7
            int r7 = r5.f6846a
            int r7 = r7 << r1
            int r7 = r7 + -1
            r5.f6846a = r7
            goto L_0x00fd
        L_0x00bf:
            int[] r7 = new int[r9]
            r8 = 0
        L_0x00c2:
            int r9 = r5.f6848b
            if (r8 >= r9) goto L_0x00f0
            int r9 = r8 << 1
            int[] r14 = r5.f6847a
            r15 = r14[r8]
            r2 = r15 & 255(0xff, float:3.57E-43)
            short r2 = r10[r2]
            r15 = r15 & r13
            int r15 = r15 >>> 8
            short r15 = r10[r15]
            int r15 = r15 << 16
            r2 = r2 | r15
            r7[r9] = r2
            int r9 = r9 + r1
            r2 = r14[r8]
            r14 = r2 & r12
            int r14 = r14 >>> 16
            short r14 = r10[r14]
            r2 = r2 & r11
            int r2 = r2 >>> 24
            short r2 = r10[r2]
            int r2 = r2 << 16
            r2 = r2 | r14
            r7[r9] = r2
            int r8 = r8 + 1
            goto L_0x00c2
        L_0x00f0:
            r5.f6847a = r7
            int r2 = r9 << 1
            r5.f6848b = r2
            int r2 = r5.f6846a
            int r2 = r2 << r1
            int r2 = r2 + -1
            r5.f6846a = r2
        L_0x00fd:
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r5 = r5.d(r3)
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r2 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r7 = 32
            r2.<init>((int) r7)
            int r7 = r5.f6848b
            int r8 = r2.f6848b
            int r7 = java.lang.Math.min(r7, r8)
            int r8 = r5.f6846a
            int r9 = r2.f6846a
            if (r8 < r9) goto L_0x012c
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r8 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r8.<init>((org.spongycastle.pqc.math.linearalgebra.GF2Polynomial) r5)
            r9 = 0
        L_0x011c:
            if (r9 >= r7) goto L_0x0142
            int[] r10 = r8.f6847a
            r11 = r10[r9]
            int[] r12 = r2.f6847a
            r12 = r12[r9]
            r11 = r11 ^ r12
            r10[r9] = r11
            int r9 = r9 + 1
            goto L_0x011c
        L_0x012c:
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r8 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r8.<init>((org.spongycastle.pqc.math.linearalgebra.GF2Polynomial) r2)
            r2 = 0
        L_0x0132:
            if (r2 >= r7) goto L_0x0142
            int[] r9 = r8.f6847a
            r10 = r9[r2]
            int[] r11 = r5.f6847a
            r11 = r11[r2]
            r10 = r10 ^ r11
            r9[r2] = r10
            int r2 = r2 + 1
            goto L_0x0132
        L_0x0142:
            r8.g()
            boolean r2 = r8.b()
            if (r2 != 0) goto L_0x01b7
            boolean r2 = r3.b()
            if (r2 == 0) goto L_0x0160
            boolean r2 = r8.b()
            if (r2 != 0) goto L_0x0158
            goto L_0x0160
        L_0x0158:
            java.lang.ArithmeticException r1 = new java.lang.ArithmeticException
            java.lang.String r2 = "Both operands of gcd equal zero."
            r1.<init>(r2)
            throw r1
        L_0x0160:
            boolean r2 = r3.b()
            if (r2 == 0) goto L_0x016c
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r2 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r2.<init>((org.spongycastle.pqc.math.linearalgebra.GF2Polynomial) r8)
            goto L_0x0192
        L_0x016c:
            boolean r2 = r8.b()
            if (r2 == 0) goto L_0x0178
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r2 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r2.<init>((org.spongycastle.pqc.math.linearalgebra.GF2Polynomial) r3)
            goto L_0x0192
        L_0x0178:
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r2 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r2.<init>((org.spongycastle.pqc.math.linearalgebra.GF2Polynomial) r3)
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r7 = new org.spongycastle.pqc.math.linearalgebra.GF2Polynomial
            r7.<init>((org.spongycastle.pqc.math.linearalgebra.GF2Polynomial) r8)
        L_0x0182:
            boolean r8 = r7.b()
            if (r8 != 0) goto L_0x0192
            org.spongycastle.pqc.math.linearalgebra.GF2Polynomial r2 = r2.d(r7)
            r17 = r7
            r7 = r2
            r2 = r17
            goto L_0x0182
        L_0x0192:
            r7 = r1
        L_0x0193:
            int r8 = r2.f6848b
            if (r7 >= r8) goto L_0x01a4
            int[] r8 = r2.f6847a
            r8 = r8[r7]
            if (r8 == 0) goto L_0x01a1
            r7 = 0
            r16 = 0
            goto L_0x01b0
        L_0x01a1:
            int r7 = r7 + 1
            goto L_0x0193
        L_0x01a4:
            int[] r2 = r2.f6847a
            r7 = 0
            r2 = r2[r7]
            if (r2 == r1) goto L_0x01ae
            r16 = r7
            goto L_0x01b0
        L_0x01ae:
            r16 = r1
        L_0x01b0:
            if (r16 != 0) goto L_0x01b3
            goto L_0x01b8
        L_0x01b3:
            int r6 = r6 + 1
            goto L_0x0066
        L_0x01b7:
            r7 = 0
        L_0x01b8:
            r2 = r7
            goto L_0x01bb
        L_0x01ba:
            r2 = r1
        L_0x01bb:
            if (r2 == 0) goto L_0x0027
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.math.linearalgebra.GF2nPolynomialField.a():void");
    }
}
