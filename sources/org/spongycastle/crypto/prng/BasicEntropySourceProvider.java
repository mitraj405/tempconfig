package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

public class BasicEntropySourceProvider implements EntropySourceProvider {
    public final SecureRandom a;

    public BasicEntropySourceProvider(SecureRandom secureRandom) {
        this.a = secureRandom;
    }

    public final EntropySource a(final int i) {
        return new EntropySource() {
            public final byte[] a() {
                SecureRandom secureRandom = BasicEntropySourceProvider.this.a;
                boolean z = secureRandom instanceof SP800SecureRandom;
                int i = i;
                if (!z && !(secureRandom instanceof X931SecureRandom)) {
                    return secureRandom.generateSeed((i + 7) / 8);
                }
                byte[] bArr = new byte[((i + 7) / 8)];
                secureRandom.nextBytes(bArr);
                return bArr;
            }

            public final int b() {
                return i;
            }
        };
    }
}
