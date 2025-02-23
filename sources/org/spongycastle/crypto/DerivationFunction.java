package org.spongycastle.crypto;

public interface DerivationFunction {
    void a(DerivationParameters derivationParameters);

    int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException;
}
