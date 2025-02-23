package org.spongycastle.crypto;

public interface StreamCipher {
    void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

    String b();

    int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

    void reset();
}
