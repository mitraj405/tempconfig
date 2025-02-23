package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RandomDSAKCalculator implements DSAKCalculator {
    public static final BigInteger b = BigInteger.valueOf(0);
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6293a;

    public final boolean a() {
        return false;
    }

    public final BigInteger b() {
        int bitLength = this.a.bitLength();
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.f6293a);
            if (!bigInteger.equals(b) && bigInteger.compareTo(this.a) < 0) {
                return bigInteger;
            }
        }
    }

    public final void c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        throw new IllegalStateException("Operation not supported");
    }

    public final void d(BigInteger bigInteger, SecureRandom secureRandom) {
        this.a = bigInteger;
        this.f6293a = secureRandom;
    }
}
