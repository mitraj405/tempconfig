package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DESParameters;

public class DESKeyGenerator extends CipherKeyGenerator {
    public byte[] a() {
        byte[] bArr = new byte[8];
        do {
            this.f5797a.nextBytes(bArr);
            DESParameters.b(bArr);
        } while (DESParameters.a(0, bArr));
        return bArr;
    }

    public void b(KeyGenerationParameters keyGenerationParameters) {
        super.b(keyGenerationParameters);
        int i = this.a;
        if (i == 0 || i == 7) {
            this.a = 8;
        } else if (i != 8) {
            throw new IllegalArgumentException("DES key must be 64 bits long.");
        }
    }
}
