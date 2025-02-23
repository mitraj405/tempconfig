package org.spongycastle.math.ec;

import java.math.BigInteger;

class SimpleBigDecimal {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final BigInteger f6630a;

    public SimpleBigDecimal(int i, BigInteger bigInteger) {
        if (i >= 0) {
            this.f6630a = bigInteger;
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public final SimpleBigDecimal a(SimpleBigDecimal simpleBigDecimal) {
        int i = simpleBigDecimal.a;
        int i2 = this.a;
        if (i2 == i) {
            return new SimpleBigDecimal(i2, this.f6630a.add(simpleBigDecimal.f6630a));
        }
        throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
    }

    public final int b(BigInteger bigInteger) {
        return this.f6630a.compareTo(bigInteger.shiftLeft(this.a));
    }

    public final BigInteger c() {
        BigInteger bigInteger = ECConstants.b;
        SimpleBigDecimal simpleBigDecimal = new SimpleBigDecimal(1, bigInteger);
        int i = this.a;
        if (i >= 0) {
            if (i != 1) {
                simpleBigDecimal = new SimpleBigDecimal(i, bigInteger.shiftLeft(i - 1));
            }
            SimpleBigDecimal a2 = a(simpleBigDecimal);
            return a2.f6630a.shiftRight(a2.a);
        }
        throw new IllegalArgumentException("scale may not be negative");
    }

    public final SimpleBigDecimal d(SimpleBigDecimal simpleBigDecimal) {
        return a(new SimpleBigDecimal(simpleBigDecimal.a, simpleBigDecimal.f6630a.negate()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleBigDecimal)) {
            return false;
        }
        SimpleBigDecimal simpleBigDecimal = (SimpleBigDecimal) obj;
        if (!this.f6630a.equals(simpleBigDecimal.f6630a) || this.a != simpleBigDecimal.a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f6630a.hashCode() ^ this.a;
    }

    public final String toString() {
        BigInteger bigInteger = this.f6630a;
        int i = this.a;
        if (i == 0) {
            return bigInteger.toString();
        }
        BigInteger shiftRight = bigInteger.shiftRight(i);
        BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(i));
        if (bigInteger.signum() == -1) {
            subtract = ECConstants.b.shiftLeft(i).subtract(subtract);
        }
        if (shiftRight.signum() == -1 && !subtract.equals(ECConstants.a)) {
            shiftRight = shiftRight.add(ECConstants.b);
        }
        String bigInteger2 = shiftRight.toString();
        char[] cArr = new char[i];
        String bigInteger3 = subtract.toString(2);
        int length = bigInteger3.length();
        int i2 = i - length;
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = '0';
        }
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i2 + i4] = bigInteger3.charAt(i4);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(bigInteger2);
        stringBuffer.append(".");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
