package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class AEADParameters implements CipherParameters {
    public final KeyParameter a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6227a;
    public final byte[] b;
    public final int c;

    public AEADParameters() {
        throw null;
    }

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr, byte[] bArr2) {
        this.a = keyParameter;
        this.b = bArr;
        this.c = i;
        this.f6227a = bArr2;
    }
}
