package org.spongycastle.crypto;

public interface BlockCipher {
    void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

    String b();

    int c();

    int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException;

    void reset();
}
