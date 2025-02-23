package org.spongycastle.crypto;

public interface Mac {
    void a(CipherParameters cipherParameters) throws IllegalArgumentException;

    String b();

    int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException;

    void d(byte b) throws IllegalStateException;

    int e();

    void reset();

    void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException;
}
