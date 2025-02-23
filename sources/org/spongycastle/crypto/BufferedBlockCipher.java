package org.spongycastle.crypto;

public class BufferedBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public BlockCipher f5794a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5795a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5796a;
    public final boolean b;
    public final boolean c;

    public BufferedBlockCipher() {
    }

    public int a(int i, byte[] bArr) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        try {
            int i2 = this.a;
            if (i + i2 <= bArr.length) {
                int i3 = 0;
                if (i2 != 0) {
                    if (this.b) {
                        BlockCipher blockCipher = this.f5794a;
                        byte[] bArr2 = this.f5796a;
                        blockCipher.e(0, 0, bArr2, bArr2);
                        int i4 = this.a;
                        this.a = 0;
                        System.arraycopy(this.f5796a, 0, bArr, i, i4);
                        i3 = i4;
                    } else {
                        throw new DataLengthException("data not block size aligned");
                    }
                }
                return i3;
            }
            throw new OutputLengthException("output buffer too short for doFinal()");
        } finally {
            g();
        }
    }

    public final int b() {
        return this.f5794a.c();
    }

    public int c(int i) {
        return i + this.a;
    }

    public int d(int i) {
        int i2;
        int i3 = i + this.a;
        if (!this.c) {
            i2 = i3 % this.f5796a.length;
        } else if (this.f5795a) {
            i2 = (i3 % this.f5796a.length) - (this.f5794a.c() + 2);
        } else {
            i2 = i3 % this.f5796a.length;
        }
        return i3 - i2;
    }

    public void e(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f5795a = z;
        g();
        this.f5794a.a(z, cipherParameters);
    }

    public int f(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        int i4;
        if (i2 >= 0) {
            int b2 = b();
            int d = d(i2);
            if (d <= 0 || d + i3 <= bArr2.length) {
                byte[] bArr3 = this.f5796a;
                int length = bArr3.length;
                int i5 = this.a;
                int i6 = length - i5;
                if (i2 > i6) {
                    System.arraycopy(bArr, i, bArr3, i5, i6);
                    i4 = this.f5794a.e(0, i3, this.f5796a, bArr2) + 0;
                    this.a = 0;
                    i2 -= i6;
                    i += i6;
                    while (i2 > this.f5796a.length) {
                        i4 += this.f5794a.e(i, i3 + i4, bArr, bArr2);
                        i2 -= b2;
                        i += b2;
                    }
                } else {
                    i4 = 0;
                }
                System.arraycopy(bArr, i, this.f5796a, this.a, i2);
                int i7 = this.a + i2;
                this.a = i7;
                byte[] bArr4 = this.f5796a;
                if (i7 != bArr4.length) {
                    return i4;
                }
                int e = i4 + this.f5794a.e(0, i3 + i4, bArr4, bArr2);
                this.a = 0;
                return e;
            }
            throw new OutputLengthException("output buffer too short");
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public void g() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f5796a;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.a = 0;
                this.f5794a.reset();
                return;
            }
        }
    }

    public BufferedBlockCipher(BlockCipher blockCipher) {
        this.f5794a = blockCipher;
        this.f5796a = new byte[blockCipher.c()];
        boolean z = false;
        this.a = 0;
        String b2 = blockCipher.b();
        int indexOf = b2.indexOf(47) + 1;
        boolean z2 = indexOf > 0 && b2.startsWith("PGP", indexOf);
        this.c = z2;
        if (z2 || (blockCipher instanceof StreamCipher)) {
            this.b = true;
            return;
        }
        if (indexOf > 0 && b2.startsWith("OpenPGP", indexOf)) {
            z = true;
        }
        this.b = z;
    }
}
