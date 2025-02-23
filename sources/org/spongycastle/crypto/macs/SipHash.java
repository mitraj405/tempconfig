package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class SipHash implements Mac {
    public final int a = 2;

    /* renamed from: a  reason: collision with other field name */
    public long f6128a;
    public final int b = 4;

    /* renamed from: b  reason: collision with other field name */
    public long f6129b;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public long f6130c;
    public int d = 0;

    /* renamed from: d  reason: collision with other field name */
    public long f6131d;
    public long e;
    public long f;
    public long g = 0;

    public SipHash() {
    }

    public static long h(int i, long j) {
        return (j >>> (-i)) | (j << i);
    }

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr.length == 16) {
                this.f6128a = Pack.h(0, bArr);
                this.f6129b = Pack.h(8, bArr);
                reset();
                return;
            }
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
    }

    public final String b() {
        return "SipHash-" + this.a + "-" + this.b;
    }

    public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
        long j = this.g;
        int i2 = this.c;
        this.g = ((j >>> ((7 - i2) << 3)) >>> 8) | ((((long) ((this.d << 3) + i2)) & 255) << 56);
        g();
        this.e ^= 255;
        f(this.b);
        reset();
        Pack.l(((this.f6130c ^ this.f6131d) ^ this.e) ^ this.f, bArr, 0);
        return 8;
    }

    public final void d(byte b2) throws IllegalStateException {
        this.g = (this.g >>> 8) | ((((long) b2) & 255) << 56);
        int i = this.c + 1;
        this.c = i;
        if (i == 8) {
            g();
            this.c = 0;
        }
    }

    public final int e() {
        return 8;
    }

    public final void f(int i) {
        long j = this.f6130c;
        long j2 = this.f6131d;
        long j3 = this.e;
        long j4 = this.f;
        for (int i2 = 0; i2 < i; i2++) {
            long j5 = j + j2;
            long j6 = j3 + j4;
            long h = h(13, j2) ^ j5;
            long h2 = h(16, j4) ^ j6;
            long j7 = j6 + h;
            j = h(32, j5) + h2;
            j2 = h(17, h) ^ j7;
            j4 = h(21, h2) ^ j;
            j3 = h(32, j7);
        }
        this.f6130c = j;
        this.f6131d = j2;
        this.e = j3;
        this.f = j4;
    }

    public final void g() {
        this.d++;
        this.f ^= this.g;
        f(this.a);
        this.f6130c ^= this.g;
    }

    public final void reset() {
        long j = this.f6128a;
        this.f6130c = 8317987319222330741L ^ j;
        long j2 = this.f6129b;
        this.f6131d = 7237128888997146477L ^ j2;
        this.e = j ^ 7816392313619706465L;
        this.f = 8387220255154660723L ^ j2;
        this.g = 0;
        this.c = 0;
        this.d = 0;
    }

    public final void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        byte[] bArr2 = bArr;
        int i3 = i2;
        int i4 = i3 & -8;
        int i5 = this.c;
        int i6 = 0;
        if (i5 == 0) {
            while (i6 < i4) {
                this.g = Pack.h(i + i6, bArr2);
                g();
                i6 += 8;
            }
            while (i6 < i3) {
                this.g = (this.g >>> 8) | ((((long) bArr2[i + i6]) & 255) << 56);
                i6++;
            }
            this.c = i3 - i4;
            return;
        }
        int i7 = i5 << 3;
        int i8 = 0;
        while (i8 < i4) {
            long h = Pack.h(i + i8, bArr2);
            this.g = (this.g >>> (-i7)) | (h << i7);
            g();
            this.g = h;
            i8 += 8;
        }
        while (i8 < i3) {
            this.g = (this.g >>> 8) | ((((long) bArr2[i + i8]) & 255) << 56);
            int i9 = this.c + 1;
            this.c = i9;
            if (i9 == 8) {
                g();
                this.c = 0;
            }
            i8++;
        }
    }

    public SipHash(int i) {
    }
}
