package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithUKM implements CipherParameters {
    public final CipherParameters a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6236a;

    public ParametersWithUKM(CipherParameters cipherParameters, byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.f6236a = bArr2;
        this.a = cipherParameters;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }
}
