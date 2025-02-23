package org.spongycastle.crypto;

import java.math.BigInteger;

public interface DSA {
    void a(boolean z, CipherParameters cipherParameters);

    BigInteger[] b(byte[] bArr);

    boolean c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr);
}
