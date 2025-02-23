package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;

public class RSABlindingEngine implements AsymmetricBlockCipher {
    public final RSACoreEngine a = new RSACoreEngine();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6028a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        RSABlindingParameters rSABlindingParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            rSABlindingParameters = (RSABlindingParameters) ((ParametersWithRandom) cipherParameters).f6234a;
        } else {
            rSABlindingParameters = (RSABlindingParameters) cipherParameters;
        }
        rSABlindingParameters.getClass();
        this.a.e(z, (CipherParameters) null);
        this.f6028a = z;
    }

    public final int b() {
        return this.a.d();
    }

    public final byte[] c(int i, byte[] bArr, int i2) {
        this.a.a(i, bArr, i2);
        if (this.f6028a) {
            throw null;
        }
        throw null;
    }

    public final int d() {
        return this.a.c();
    }
}
