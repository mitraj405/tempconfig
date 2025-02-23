package org.spongycastle.crypto.digests;

public class SHA3Digest extends KeccakDigest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SHA3Digest(int i) {
        super(i);
        if (i == 224 || i == 256 || i == 384 || i == 512) {
            return;
        }
        throw new IllegalArgumentException(C1058d.y("'bitLength' ", i, " not supported for SHA-3"));
    }

    public final String b() {
        return "SHA3-" + this.c;
    }

    public final int c(int i, byte[] bArr) {
        j(2, 2);
        return super.c(i, bArr);
    }

    public SHA3Digest() {
        this(256);
    }

    public SHA3Digest(SHA3Digest sHA3Digest) {
        super((KeccakDigest) sHA3Digest);
    }
}
