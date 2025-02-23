package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class ParametersWithSBox implements CipherParameters {
    public final CipherParameters a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6235a;

    public ParametersWithSBox(CipherParameters cipherParameters, byte[] bArr) {
        this.a = cipherParameters;
        this.f6235a = bArr;
    }
}
