package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

public interface DSAKCalculator {
    boolean a();

    BigInteger b();

    void c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr);

    void d(BigInteger bigInteger, SecureRandom secureRandom);
}
