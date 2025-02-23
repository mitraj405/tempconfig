package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class Poly1305 implements Mac {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6125a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6126a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6127b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;

    public Poly1305() {
        this.f6126a = new byte[1];
        this.f6127b = new byte[16];
        this.n = 0;
        this.f6125a = null;
    }

    public static final long f(int i2, int i3) {
        return (((long) i2) & 4294967295L) * ((long) i3);
    }

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] bArr;
        BlockCipher blockCipher = this.f6125a;
        if (blockCipher == null) {
            bArr = null;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.f6233a;
            cipherParameters = parametersWithIV.a;
        } else {
            throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
        }
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr2 = ((KeyParameter) cipherParameters).a;
            if (bArr2.length == 32) {
                int i2 = 16;
                if (blockCipher == null || (bArr != null && bArr.length == 16)) {
                    int f2 = Pack.f(0, bArr2);
                    int f3 = Pack.f(4, bArr2);
                    int f4 = Pack.f(8, bArr2);
                    int f5 = Pack.f(12, bArr2);
                    this.a = 67108863 & f2;
                    int i3 = ((f2 >>> 26) | (f3 << 6)) & 67108611;
                    this.b = i3;
                    int i4 = ((f3 >>> 20) | (f4 << 12)) & 67092735;
                    this.c = i4;
                    int i5 = ((f4 >>> 14) | (f5 << 18)) & 66076671;
                    this.d = i5;
                    int i6 = (f5 >>> 8) & 1048575;
                    this.e = i6;
                    this.f = i3 * 5;
                    this.g = i4 * 5;
                    this.h = i5 * 5;
                    this.i = i6 * 5;
                    if (blockCipher != null) {
                        byte[] bArr3 = new byte[16];
                        blockCipher.a(true, new KeyParameter(bArr2, 16, 16));
                        blockCipher.e(0, 0, bArr, bArr3);
                        i2 = 0;
                        bArr2 = bArr3;
                    }
                    this.j = Pack.f(i2 + 0, bArr2);
                    this.k = Pack.f(i2 + 4, bArr2);
                    this.l = Pack.f(i2 + 8, bArr2);
                    this.m = Pack.f(i2 + 12, bArr2);
                    reset();
                    return;
                }
                throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
            }
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        throw new IllegalArgumentException("Poly1305 requires a key.");
    }

    public final String b() {
        BlockCipher blockCipher = this.f6125a;
        if (blockCipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + blockCipher.b();
    }

    public final int c(int i2, byte[] bArr) throws DataLengthException, IllegalStateException {
        byte[] bArr2 = bArr;
        if (16 <= bArr2.length) {
            if (this.n > 0) {
                g();
            }
            int i3 = this.p;
            int i4 = this.o;
            int i5 = i3 + (i4 >>> 26);
            int i6 = this.q + (i5 >>> 26);
            int i7 = this.r + (i6 >>> 26);
            int i8 = i6 & 67108863;
            int i9 = this.s + (i7 >>> 26);
            int i10 = i7 & 67108863;
            int i11 = ((i9 >>> 26) * 5) + (i4 & 67108863);
            int i12 = i9 & 67108863;
            int i13 = (i5 & 67108863) + (i11 >>> 26);
            int i14 = i11 & 67108863;
            int i15 = i14 + 5;
            int i16 = (i15 >>> 26) + i13;
            int i17 = (i16 >>> 26) + i8;
            int i18 = (i17 >>> 26) + i10;
            int i19 = 67108863 & i18;
            int i20 = ((i18 >>> 26) + i12) - 67108864;
            int i21 = (i20 >>> 31) - 1;
            int i22 = ~i21;
            int i23 = (i14 & i22) | (i15 & 67108863 & i21);
            this.o = i23;
            int i24 = (i13 & i22) | (i16 & 67108863 & i21);
            this.p = i24;
            int i25 = (i8 & i22) | (i17 & 67108863 & i21);
            this.q = i25;
            int i26 = (i19 & i21) | (i10 & i22);
            this.r = i26;
            int i27 = (i12 & i22) | (i20 & i21);
            this.s = i27;
            long j2 = (((long) ((i24 << 26) | i23)) & 4294967295L) + (((long) this.j) & 4294967295L);
            long j3 = (((long) ((i24 >>> 6) | (i25 << 20))) & 4294967295L) + (((long) this.k) & 4294967295L);
            long j4 = (((long) ((i25 >>> 12) | (i26 << 14))) & 4294967295L) + (((long) this.l) & 4294967295L);
            long j5 = (((long) ((i26 >>> 18) | (i27 << 8))) & 4294967295L) + (((long) this.m) & 4294967295L);
            Pack.e((int) j2, bArr2, 0);
            long j6 = j3 + (j2 >>> 32);
            Pack.e((int) j6, bArr2, 4);
            long j7 = j4 + (j6 >>> 32);
            Pack.e((int) j7, bArr2, 8);
            Pack.e((int) (j5 + (j7 >>> 32)), bArr2, 12);
            reset();
            return 16;
        }
        throw new OutputLengthException("Output buffer is too short.");
    }

    public final void d(byte b2) throws IllegalStateException {
        byte[] bArr = this.f6126a;
        bArr[0] = b2;
        update(bArr, 0, 1);
    }

    public final int e() {
        return 16;
    }

    public final void g() {
        int i2 = this.n;
        byte[] bArr = this.f6127b;
        if (i2 < 16) {
            bArr[i2] = 1;
            for (int i3 = i2 + 1; i3 < 16; i3++) {
                bArr[i3] = 0;
            }
        }
        long f2 = ((long) Pack.f(0, bArr)) & 4294967295L;
        long f3 = ((long) Pack.f(4, bArr)) & 4294967295L;
        long f4 = ((long) Pack.f(8, bArr)) & 4294967295L;
        long f5 = 4294967295L & ((long) Pack.f(12, bArr));
        int i4 = (int) (((long) this.o) + (f2 & 67108863));
        this.o = i4;
        this.p = (int) (((long) this.p) + ((((f3 << 32) | f2) >>> 26) & 67108863));
        this.q = (int) (((long) this.q) + (((f3 | (f4 << 32)) >>> 20) & 67108863));
        this.r = (int) (((long) this.r) + ((((f5 << 32) | f4) >>> 14) & 67108863));
        int i5 = (int) (((long) this.s) + (f5 >>> 8));
        this.s = i5;
        if (this.n == 16) {
            this.s = i5 + 16777216;
        }
        long f6 = f(this.s, this.f) + f(this.r, this.g) + f(this.q, this.h) + f(this.p, this.i) + f(i4, this.a);
        long f7 = f(this.s, this.g) + f(this.r, this.h) + f(this.q, this.i) + f(this.p, this.a) + f(this.o, this.b);
        long f8 = f(this.s, this.h) + f(this.r, this.i) + f(this.q, this.a) + f(this.p, this.b) + f(this.o, this.c);
        long f9 = f(this.s, this.i) + f(this.r, this.a) + f(this.q, this.b) + f(this.p, this.c) + f(this.o, this.d);
        long f10 = f(this.s, this.a) + f(this.r, this.b) + f(this.q, this.c) + f(this.p, this.d) + f(this.o, this.e);
        long j2 = f7 + (f6 >>> 26);
        long j3 = f8 + (j2 >>> 26);
        this.q = ((int) j3) & 67108863;
        long j4 = f9 + (j3 >>> 26);
        this.r = ((int) j4) & 67108863;
        long j5 = f10 + (j4 >>> 26);
        this.s = ((int) j5) & 67108863;
        int i6 = (((int) (j5 >>> 26)) * 5) + (((int) f6) & 67108863);
        this.p = (((int) j2) & 67108863) + (i6 >>> 26);
        this.o = i6 & 67108863;
    }

    public final void reset() {
        this.n = 0;
        this.s = 0;
        this.r = 0;
        this.q = 0;
        this.p = 0;
        this.o = 0;
    }

    public final void update(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalStateException {
        int i4 = 0;
        while (i3 > i4) {
            if (this.n == 16) {
                g();
                this.n = 0;
            }
            int min = Math.min(i3 - i4, 16 - this.n);
            System.arraycopy(bArr, i4 + i2, this.f6127b, this.n, min);
            i4 += min;
            this.n += min;
        }
    }

    public Poly1305(BlockCipher blockCipher) {
        this.f6126a = new byte[1];
        this.f6127b = new byte[16];
        this.n = 0;
        if (blockCipher.c() == 16) {
            this.f6125a = blockCipher;
            return;
        }
        throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
    }
}
