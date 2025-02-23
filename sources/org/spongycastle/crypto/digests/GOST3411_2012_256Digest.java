package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

public final class GOST3411_2012_256Digest extends GOST3411_2012Digest {
    public static final byte[] j = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public GOST3411_2012_256Digest() {
        super(j);
    }

    public final Memoable a() {
        return new GOST3411_2012_256Digest(this);
    }

    public final String b() {
        return "GOST3411-2012-256";
    }

    public final int c(int i, byte[] bArr) {
        byte[] bArr2 = new byte[64];
        super.c(0, bArr2);
        System.arraycopy(bArr2, 32, bArr, i, 32);
        return 32;
    }

    public final int f() {
        return 32;
    }

    public GOST3411_2012_256Digest(GOST3411_2012_256Digest gOST3411_2012_256Digest) {
        super(j);
        e(gOST3411_2012_256Digest);
    }
}
