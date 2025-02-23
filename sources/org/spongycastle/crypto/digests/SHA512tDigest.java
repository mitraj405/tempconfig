package org.spongycastle.crypto.digests;

import org.spongycastle.util.Memoable;
import org.spongycastle.util.MemoableResetException;

public class SHA512tDigest extends LongDigest {
    public final int c;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;

    public SHA512tDigest(int i) {
        if (i >= 512) {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        } else if (i % 8 != 0) {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        } else if (i != 384) {
            int i2 = i / 8;
            this.c = i2;
            int i3 = i2 * 8;
            this.c = -3482333909917012819L;
            this.d = 2216346199247487646L;
            this.e = -7364697282686394994L;
            this.f = 65953792586715988L;
            this.g = -816286391624063116L;
            this.h = 4512832404995164602L;
            this.i = -5033199132376557362L;
            this.j = -124578254951840548L;
            d((byte) 83);
            d((byte) 72);
            d((byte) 65);
            d((byte) 45);
            d((byte) 53);
            d((byte) 49);
            d((byte) 50);
            d((byte) 47);
            if (i3 > 100) {
                d((byte) ((i3 / 100) + 48));
                int i4 = i3 % 100;
                d((byte) ((i4 / 10) + 48));
                d((byte) ((i4 % 10) + 48));
            } else if (i3 > 10) {
                d((byte) ((i3 / 10) + 48));
                d((byte) ((i3 % 10) + 48));
            } else {
                d((byte) (i3 + 48));
            }
            m();
            this.k = this.c;
            this.l = this.d;
            this.m = this.e;
            this.n = this.f;
            this.o = this.g;
            this.p = this.h;
            this.q = this.i;
            this.r = this.j;
            reset();
        } else {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
    }

    public static void o(byte[] bArr, int i, int i2, long j) {
        if (i2 > 0) {
            int i3 = (int) (j >>> 32);
            int min = Math.min(4, i2);
            while (true) {
                min--;
                if (min < 0) {
                    break;
                }
                bArr[i + min] = (byte) (i3 >>> ((3 - min) * 8));
            }
            if (i2 > 4) {
                int i4 = (int) (j & 4294967295L);
                int i5 = i + 4;
                int min2 = Math.min(4, i2 - 4);
                while (true) {
                    min2--;
                    if (min2 >= 0) {
                        bArr[i5 + min2] = (byte) (i4 >>> ((3 - min2) * 8));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final Memoable a() {
        return new SHA512tDigest(this);
    }

    public final String b() {
        return "SHA-512/" + Integer.toString(this.c * 8);
    }

    public final int c(int i, byte[] bArr) {
        m();
        long j = this.c;
        int i2 = this.c;
        o(bArr, i, i2, j);
        o(bArr, i + 8, i2 - 8, this.d);
        o(bArr, i + 16, i2 - 16, this.e);
        o(bArr, i + 24, i2 - 24, this.f);
        o(bArr, i + 32, i2 - 32, this.g);
        o(bArr, i + 40, i2 - 40, this.h);
        o(bArr, i + 48, i2 - 48, this.i);
        o(bArr, i + 56, i2 - 56, this.j);
        reset();
        return i2;
    }

    public final void e(Memoable memoable) {
        SHA512tDigest sHA512tDigest = (SHA512tDigest) memoable;
        if (this.c == sHA512tDigest.c) {
            l(sHA512tDigest);
            this.k = sHA512tDigest.k;
            this.l = sHA512tDigest.l;
            this.m = sHA512tDigest.m;
            this.n = sHA512tDigest.n;
            this.o = sHA512tDigest.o;
            this.p = sHA512tDigest.p;
            this.q = sHA512tDigest.q;
            this.r = sHA512tDigest.r;
            return;
        }
        throw new MemoableResetException();
    }

    public final int f() {
        return this.c;
    }

    public final void reset() {
        super.reset();
        this.c = this.k;
        this.d = this.l;
        this.e = this.m;
        this.f = this.n;
        this.g = this.o;
        this.h = this.p;
        this.i = this.q;
        this.j = this.r;
    }

    public SHA512tDigest(SHA512tDigest sHA512tDigest) {
        super(sHA512tDigest);
        this.c = sHA512tDigest.c;
        e(sHA512tDigest);
    }
}
