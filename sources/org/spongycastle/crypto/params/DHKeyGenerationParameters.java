package org.spongycastle.crypto.params;

import org.spongycastle.crypto.KeyGenerationParameters;

public class DHKeyGenerationParameters extends KeyGenerationParameters {
    public final DHParameters a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DHKeyGenerationParameters(java.security.SecureRandom r2, org.spongycastle.crypto.params.DHParameters r3) {
        /*
            r1 = this;
            int r0 = r3.d
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.params.DHKeyGenerationParameters.<init>(java.security.SecureRandom, org.spongycastle.crypto.params.DHParameters):void");
    }
}
