package org.spongycastle.util.test;

import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.crypto.prng.EntropySourceProvider;

public class TestRandomEntropySourceProvider implements EntropySourceProvider {
    public final EntropySource a(final int i) {
        return new EntropySource() {
            public final byte[] a() {
                byte[] bArr = new byte[((i + 7) / 8)];
                TestRandomEntropySourceProvider.this.getClass();
                throw null;
            }

            public final int b() {
                return i;
            }
        };
    }
}
