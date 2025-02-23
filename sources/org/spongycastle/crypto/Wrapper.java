package org.spongycastle.crypto;

public interface Wrapper {
    void a(boolean z, CipherParameters cipherParameters);

    String b();

    byte[] c(byte[] bArr, int i) throws InvalidCipherTextException;

    byte[] d(byte[] bArr, int i);
}
