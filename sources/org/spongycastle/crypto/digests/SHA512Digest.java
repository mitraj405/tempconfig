package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA512Digest extends LongDigest {
    public SHA512Digest() {
    }

    public final Memoable a() {
        return new SHA512Digest(this);
    }

    public final String b() {
        return "SHA-512";
    }

    public final int c(int i, byte[] bArr) {
        m();
        Pack.j(this.c, bArr, i);
        Pack.j(this.d, bArr, i + 8);
        Pack.j(this.e, bArr, i + 16);
        Pack.j(this.f, bArr, i + 24);
        Pack.j(this.g, bArr, i + 32);
        Pack.j(this.h, bArr, i + 40);
        Pack.j(this.i, bArr, i + 48);
        Pack.j(this.j, bArr, i + 56);
        reset();
        return 64;
    }

    public final void e(Memoable memoable) {
        l((SHA512Digest) memoable);
    }

    public final int f() {
        return 64;
    }

    public final void reset() {
        super.reset();
        this.c = 7640891576956012808L;
        this.d = -4942790177534073029L;
        this.e = 4354685564936845355L;
        this.f = -6534734903238641935L;
        this.g = 5840696475078001361L;
        this.h = -7276294671716946913L;
        this.i = 2270897969802886507L;
        this.j = 6620516959819538809L;
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }
}
