package org.spongycastle.pqc.math.ntru.polynomial;

import java.math.BigInteger;
import org.spongycastle.util.Arrays;

public class BigIntPolynomial {
    public BigInteger[] a;

    static {
        Math.log10(2.0d);
    }

    public BigIntPolynomial(BigInteger[] bigIntegerArr) {
        this.a = bigIntegerArr;
    }

    public final void a(BigIntPolynomial bigIntPolynomial) {
        BigInteger[] bigIntegerArr = bigIntPolynomial.a;
        int length = bigIntegerArr.length;
        BigInteger[] bigIntegerArr2 = this.a;
        if (length > bigIntegerArr2.length) {
            int length2 = bigIntegerArr2.length;
            this.a = Arrays.m(bigIntegerArr2, bigIntegerArr.length);
            while (true) {
                BigInteger[] bigIntegerArr3 = this.a;
                if (length2 >= bigIntegerArr3.length) {
                    break;
                }
                bigIntegerArr3[length2] = Constants.a;
                length2++;
            }
        }
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr4 = bigIntPolynomial.a;
            if (i < bigIntegerArr4.length) {
                BigInteger[] bigIntegerArr5 = this.a;
                bigIntegerArr5[i] = bigIntegerArr5[i].add(bigIntegerArr4[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final Object clone() {
        return new BigIntPolynomial((BigInteger[]) this.a.clone());
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0042 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r6 != r7) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r7 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r7.getClass()
            if (r2 == r3) goto L_0x0013
            return r1
        L_0x0013:
            org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial r7 = (org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial) r7
            java.math.BigInteger[] r2 = r6.a
            java.math.BigInteger[] r7 = r7.a
            if (r2 != r7) goto L_0x001d
        L_0x001b:
            r7 = r0
            goto L_0x003f
        L_0x001d:
            if (r2 == 0) goto L_0x003e
            if (r7 != 0) goto L_0x0022
            goto L_0x003e
        L_0x0022:
            int r3 = r2.length
            int r4 = r7.length
            if (r3 == r4) goto L_0x0027
            goto L_0x003e
        L_0x0027:
            r3 = r1
        L_0x0028:
            int r4 = r2.length
            if (r3 == r4) goto L_0x001b
            r4 = r2[r3]
            r5 = r7[r3]
            if (r4 != 0) goto L_0x0034
            if (r5 == 0) goto L_0x003b
            goto L_0x003e
        L_0x0034:
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x003b
            goto L_0x003e
        L_0x003b:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x003e:
            r7 = r1
        L_0x003f:
            if (r7 != 0) goto L_0x0042
            return r1
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        BigInteger[] bigIntegerArr = this.a;
        if (bigIntegerArr == null) {
            i = 0;
        } else {
            int length = bigIntegerArr.length;
            int i2 = length + 1;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                i2 = (i2 * 257) ^ bigIntegerArr[length].hashCode();
            }
            i = i2;
        }
        return 31 + i;
    }
}
