package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class IESParameters implements CipherParameters {
    public final byte[] a;
    public final byte[] b;
    public final int c;

    public IESParameters(byte[] bArr, int i, byte[] bArr2) {
        this.a = bArr;
        this.b = bArr2;
        this.c = i;
    }
}
