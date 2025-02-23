package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;

class Tnaf {
    public static final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public static final ZTauElement[] f6631a;

    /* renamed from: a  reason: collision with other field name */
    public static final byte[][] f6632a = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
    public static final BigInteger b = ECConstants.c.negate();

    /* renamed from: b  reason: collision with other field name */
    public static final ZTauElement[] f6633b;

    /* renamed from: b  reason: collision with other field name */
    public static final byte[][] f6634b = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};

    static {
        BigInteger bigInteger = ECConstants.b;
        BigInteger negate = bigInteger.negate();
        a = negate;
        BigInteger negate2 = ECConstants.d.negate();
        BigInteger bigInteger2 = ECConstants.a;
        f6631a = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, negate), null, new ZTauElement(negate, negate), null, new ZTauElement(bigInteger, negate), null};
        f6633b = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, bigInteger), null, new ZTauElement(negate, bigInteger), null, new ZTauElement(bigInteger, bigInteger), null};
    }

    public static SimpleBigDecimal a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b2, int i) {
        int i2 = ((i + 5) / 2) + 10;
        BigInteger multiply = bigInteger2.multiply(bigInteger.shiftRight(((i - i2) - 2) + b2));
        BigInteger add = multiply.add(bigInteger3.multiply(multiply.shiftRight(i)));
        int i3 = i2 - 10;
        BigInteger shiftRight = add.shiftRight(i3);
        if (add.testBit(i3 - 1)) {
            shiftRight = shiftRight.add(ECConstants.b);
        }
        return new SimpleBigDecimal(10, shiftRight);
    }

    public static BigInteger[] b(byte b2, int i, boolean z) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        if (b2 == 1 || b2 == -1) {
            if (z) {
                bigInteger = ECConstants.c;
                bigInteger2 = BigInteger.valueOf((long) b2);
            } else {
                bigInteger = ECConstants.a;
                bigInteger2 = ECConstants.b;
            }
            int i2 = 1;
            while (i2 < i) {
                if (b2 == 1) {
                    bigInteger3 = bigInteger2;
                } else {
                    bigInteger3 = bigInteger2.negate();
                }
                i2++;
                BigInteger bigInteger4 = bigInteger2;
                bigInteger2 = bigInteger3.subtract(bigInteger.shiftLeft(1));
                bigInteger = bigInteger4;
            }
            return new BigInteger[]{bigInteger, bigInteger2};
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static BigInteger[] c(ECCurve.AbstractF2m abstractF2m) {
        int i;
        int i2;
        if (abstractF2m.t()) {
            int k = abstractF2m.k();
            int intValue = abstractF2m.f6610a.t().intValue();
            if (intValue == 0) {
                i = -1;
            } else {
                i = 1;
            }
            byte b2 = (byte) i;
            BigInteger bigInteger = abstractF2m.b;
            if (bigInteger != null) {
                if (bigInteger.equals(ECConstants.c)) {
                    i2 = 1;
                } else if (bigInteger.equals(ECConstants.e)) {
                    i2 = 2;
                }
                BigInteger[] b3 = b(b2, (k + 3) - intValue, false);
                if (b2 == 1) {
                    b3[0] = b3[0].negate();
                    b3[1] = b3[1].negate();
                }
                BigInteger bigInteger2 = ECConstants.b;
                return new BigInteger[]{bigInteger2.add(b3[1]).shiftRight(i2), bigInteger2.add(b3[0]).shiftRight(i2).negate()};
            }
            throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }
}
