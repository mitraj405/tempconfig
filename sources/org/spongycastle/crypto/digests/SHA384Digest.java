package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.Pack;

public class SHA384Digest extends LongDigest {
    public SHA384Digest() {
    }

    public final Memoable a() {
        return new SHA384Digest(this);
    }

    public final String b() {
        return "SHA-384";
    }

    public final int c(int i, byte[] bArr) {
        m();
        Pack.j(this.c, bArr, i);
        Pack.j(this.d, bArr, i + 8);
        Pack.j(this.e, bArr, i + 16);
        Pack.j(this.f, bArr, i + 24);
        Pack.j(this.g, bArr, i + 32);
        Pack.j(this.h, bArr, i + 40);
        reset();
        return 48;
    }

    public final void e(Memoable memoable) {
        l((SHA384Digest) memoable);
    }

    public final int f() {
        return 48;
    }

    public final void reset() {
        super.reset();
        this.c = -3766243637369397544L;
        this.d = 7105036623409894663L;
        this.e = -7973340178411365097L;
        this.f = 1526699215303891257L;
        this.g = 7436329637833083697L;
        this.h = -8163818279084223215L;
        this.i = -2662702644619276377L;
        this.j = 5167115440072839076L;
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
    }
}
