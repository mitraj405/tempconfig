package org.spongycastle.crypto.params;

import org.spongycastle.crypto.KeyGenerationParameters;

public class ElGamalKeyGenerationParameters extends KeyGenerationParameters {
    public final ElGamalParameters a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ElGamalKeyGenerationParameters(java.security.SecureRandom r2, org.spongycastle.crypto.params.ElGamalParameters r3) {
        /*
            r1 = this;
            int r0 = r3.c
            if (r0 == 0) goto L_0x0005
            goto L_0x000b
        L_0x0005:
            java.math.BigInteger r0 = r3.b
            int r0 = r0.bitLength()
        L_0x000b:
            r1.<init>(r0, r2)
            r1.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.params.ElGamalKeyGenerationParameters.<init>(java.security.SecureRandom, org.spongycastle.crypto.params.ElGamalParameters):void");
    }
}
