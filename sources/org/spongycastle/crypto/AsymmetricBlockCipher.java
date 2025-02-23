package org.spongycastle.crypto;

public interface AsymmetricBlockCipher {
    void a(boolean z, CipherParameters cipherParameters);

    int b();

    byte[] c(int i, byte[] bArr, int i2) throws InvalidCipherTextException;

    int d();
}
