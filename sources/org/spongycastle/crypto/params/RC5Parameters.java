package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class RC5Parameters implements CipherParameters {
    public final byte[] a;
    public final int c;

    public RC5Parameters(byte[] bArr, int i) {
        if (bArr.length <= 255) {
            byte[] bArr2 = new byte[bArr.length];
            this.a = bArr2;
            this.c = i;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return;
        }
        throw new IllegalArgumentException("RC5 key length can be no greater than 255");
    }
}
