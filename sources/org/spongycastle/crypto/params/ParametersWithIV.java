package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithIV implements CipherParameters {
    public final CipherParameters a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6233a;

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f6233a = bArr2;
        this.a = cipherParameters;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
