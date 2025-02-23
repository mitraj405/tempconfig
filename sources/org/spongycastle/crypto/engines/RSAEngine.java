package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;

public class RSAEngine implements AsymmetricBlockCipher {
    public RSACoreEngine a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (this.a == null) {
            this.a = new RSACoreEngine();
        }
        this.a.e(z, cipherParameters);
    }

    public final int b() {
        return this.a.d();
    }

    public final byte[] c(int i, byte[] bArr, int i2) {
        RSACoreEngine rSACoreEngine = this.a;
        if (rSACoreEngine != null) {
            return rSACoreEngine.b(rSACoreEngine.f(rSACoreEngine.a(i, bArr, i2)));
        }
        throw new IllegalStateException("RSA engine not initialised");
    }

    public final int d() {
        return this.a.c();
    }
}
