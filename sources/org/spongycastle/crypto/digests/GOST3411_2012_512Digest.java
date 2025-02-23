package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;

public class GOST3411_2012_512Digest extends GOST3411_2012Digest {
    public static final byte[] j = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public GOST3411_2012_512Digest() {
        super(j);
    }

    public final Memoable a() {
        return new GOST3411_2012_512Digest(this);
    }

    public final String b() {
        return "GOST3411-2012-512";
    }

    public final int f() {
        return 64;
    }

    public GOST3411_2012_512Digest(GOST3411_2012_512Digest gOST3411_2012_512Digest) {
        super(j);
        e(gOST3411_2012_512Digest);
    }
}
