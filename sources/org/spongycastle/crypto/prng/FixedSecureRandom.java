package org.spongycastle.crypto.prng;

import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom {
    public int c;

    public final byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        nextBytes(bArr);
        return bArr;
    }

    public final void nextBytes(byte[] bArr) {
        System.arraycopy((Object) null, this.c, bArr, 0, bArr.length);
        this.c += bArr.length;
    }

    public final int nextInt() {
        this.c++;
        throw null;
    }

    public final long nextLong() {
        this.c++;
        throw null;
    }
}
