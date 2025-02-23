package org.spongycastle.crypto.params;

public class IESWithCipherParameters extends IESParameters {
    public final int d;

    public IESWithCipherParameters(int i, int i2, byte[] bArr, byte[] bArr2) {
        super(bArr, i, bArr2);
        this.d = i2;
    }
}
