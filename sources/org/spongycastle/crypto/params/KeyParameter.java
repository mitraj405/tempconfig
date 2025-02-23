package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class KeyParameter implements CipherParameters {
    public final byte[] a;

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.a = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
