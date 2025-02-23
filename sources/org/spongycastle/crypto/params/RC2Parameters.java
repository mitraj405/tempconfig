package org.spongycastle.crypto.params;

public class RC2Parameters extends KeyParameter {
    public final int c;

    public RC2Parameters(byte[] bArr, int i) {
        super(bArr, 0, bArr.length);
        this.c = i;
    }
}
