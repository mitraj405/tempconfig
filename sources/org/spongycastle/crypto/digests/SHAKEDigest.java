package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.Xof;

public class SHAKEDigest extends KeccakDigest implements Xof {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SHAKEDigest(int i) {
        super(i);
        if (i == 128 || i == 256) {
            return;
        }
        throw new IllegalArgumentException(C1058d.y("'bitLength' ", i, " not supported for SHAKE"));
    }

    public final String b() {
        return "SHAKE" + this.c;
    }

    public final int c(int i, byte[] bArr) {
        int i2 = this.c / 8;
        g(i, bArr, i2);
        return i2;
    }

    public final int g(int i, byte[] bArr, int i2) {
        if (!this.f5845a) {
            j(15, 4);
        }
        m(((long) i2) * 8, bArr, i);
        reset();
        return i2;
    }

    public SHAKEDigest() {
        this(128);
    }
}
