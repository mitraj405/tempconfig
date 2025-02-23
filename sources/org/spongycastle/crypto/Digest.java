package org.spongycastle.crypto;

public interface Digest {
    String b();

    int c(int i, byte[] bArr);

    void d(byte b);

    int f();

    void reset();

    void update(byte[] bArr, int i, int i2);
}
