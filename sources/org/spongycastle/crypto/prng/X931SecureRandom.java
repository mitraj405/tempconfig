package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

public class X931SecureRandom extends SecureRandom {
    public final byte[] generateSeed(int i) {
        throw null;
    }

    public final void nextBytes(byte[] bArr) {
        synchronized (this) {
            throw null;
        }
    }

    public final void setSeed(byte[] bArr) {
        synchronized (this) {
        }
    }

    public final void setSeed(long j) {
        synchronized (this) {
        }
    }
}
