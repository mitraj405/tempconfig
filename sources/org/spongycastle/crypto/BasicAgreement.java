package org.spongycastle.crypto;

import java.math.BigInteger;

public interface BasicAgreement {
    void a(CipherParameters cipherParameters);

    BigInteger b(CipherParameters cipherParameters);

    int getFieldSize();
}
