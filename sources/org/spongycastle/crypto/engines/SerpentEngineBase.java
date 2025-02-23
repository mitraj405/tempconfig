package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public abstract class SerpentEngineBase implements BlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6050a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6051a;
    public int b;
    public int c;
    public int d;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.f6050a = z;
            this.f6051a = q(((KeyParameter) cipherParameters).a);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to " + b() + " init - " + cipherParameters.getClass().getName());
    }

    public String b() {
        return "Serpent";
    }

    public final int c() {
        return 16;
    }

    public final void d() {
        int i = this.a;
        int i2 = (i >>> -13) | (i << 13);
        int i3 = this.c;
        int i4 = (i3 >>> -3) | (i3 << 3);
        int i5 = (this.b ^ i2) ^ i4;
        int i6 = (this.d ^ i4) ^ (i2 << 3);
        int i7 = (i5 >>> -1) | (i5 << 1);
        this.b = i7;
        int i8 = (i6 >>> -7) | (i6 << 7);
        this.d = i8;
        int i9 = (i2 ^ i7) ^ i8;
        this.a = (i9 >>> -5) | (i9 << 5);
        int i10 = (i4 ^ i8) ^ (i7 << 7);
        this.c = (i10 >>> -22) | (i10 << 22);
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        if (this.f6051a == null) {
            throw new IllegalStateException(b() + " not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.f6050a) {
            g(i, i2, bArr, bArr2);
            return 16;
        } else {
            f(i, i2, bArr, bArr2);
            return 16;
        }
    }

    public abstract void f(int i, int i2, byte[] bArr, byte[] bArr2);

    public abstract void g(int i, int i2, byte[] bArr, byte[] bArr2);

    public final void h(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i2 ^ i;
        int i7 = (i5 | i6) ^ i4;
        int i8 = i3 ^ i7;
        int i9 = i6 ^ i8;
        this.c = i9;
        int i10 = (i6 & i4) ^ i5;
        int i11 = (i9 & i10) ^ i7;
        this.b = i11;
        int i12 = (i & i7) ^ (i11 | i8);
        this.d = i12;
        this.a = i12 ^ (i10 ^ i8);
    }

    public final void i(int i, int i2, int i3, int i4) {
        int i5 = i4 ^ i2;
        int i6 = i ^ (i2 & i5);
        int i7 = i5 ^ i6;
        int i8 = i3 ^ i7;
        this.d = i8;
        int i9 = i2 ^ (i5 & i6);
        int i10 = i6 ^ (i8 | i9);
        this.b = i10;
        int i11 = ~i10;
        int i12 = i9 ^ i8;
        this.a = i11 ^ i12;
        this.c = (i11 | i12) ^ i7;
    }

    public final void j(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i4;
        int i6 = ~i5;
        int i7 = i ^ i3;
        int i8 = i3 ^ i5;
        int i9 = (i2 & i8) ^ i7;
        this.a = i9;
        int i10 = (((i | i6) ^ i4) | i7) ^ i5;
        this.d = i10;
        int i11 = ~i8;
        int i12 = i10 | i9;
        this.b = i11 ^ i12;
        this.c = (i12 ^ i7) ^ (i4 & i11);
    }

    public final void k(int i, int i2, int i3, int i4) {
        int i5 = i | i2;
        int i6 = i2 ^ i3;
        int i7 = i ^ (i2 & i6);
        int i8 = i3 ^ i7;
        int i9 = i4 | i7;
        int i10 = i6 ^ i9;
        this.a = i10;
        int i11 = (i9 | i6) ^ i4;
        this.c = i8 ^ i11;
        int i12 = i5 ^ i11;
        int i13 = i7 ^ (i10 & i12);
        this.d = i13;
        this.b = i13 ^ (i12 ^ i10);
    }

    public final void l(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ ((i3 | i4) & i);
        int i6 = i3 ^ (i & i5);
        int i7 = i4 ^ i6;
        this.b = i7;
        int i8 = ~i;
        int i9 = (i6 & i7) ^ i5;
        this.d = i9;
        int i10 = i4 ^ (i7 | i8);
        this.a = i9 ^ i10;
        this.c = (i8 ^ i7) ^ (i5 & i10);
    }

    public final void m(int i, int i2, int i3, int i4) {
        int i5 = ~i3;
        int i6 = (i2 & i5) ^ i4;
        int i7 = i & i6;
        int i8 = (i2 ^ i5) ^ i7;
        this.d = i8;
        int i9 = i8 | i2;
        this.b = i6 ^ (i & i9);
        int i10 = i4 | i;
        this.a = (i5 ^ i9) ^ i10;
        this.c = ((i ^ i3) | i7) ^ (i2 & i10);
    }

    public final void n(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i2;
        int i7 = i3 ^ i6;
        int i8 = (i3 | i5) ^ i4;
        this.b = i7 ^ i8;
        int i9 = i6 ^ (i7 & i8);
        int i10 = i8 ^ (i2 | i9);
        this.d = i10;
        int i11 = i2 | i10;
        this.a = i9 ^ i11;
        this.c = (i4 & i5) ^ (i11 ^ i7);
    }

    public final void o(int i, int i2, int i3, int i4) {
        int i5 = (i & i2) | i3;
        int i6 = (i | i2) & i4;
        int i7 = i5 ^ i6;
        this.d = i7;
        int i8 = i2 ^ i6;
        int i9 = ((i7 ^ (~i4)) | i8) ^ i;
        this.b = i9;
        int i10 = (i8 ^ i3) ^ (i4 | i9);
        this.a = i10;
        this.c = ((i & i7) ^ i10) ^ (i5 ^ i9);
    }

    public final void p() {
        int i = this.c;
        int i2 = (i << -22) | (i >>> 22);
        int i3 = this.d;
        int i4 = this.b;
        int i5 = (i2 ^ i3) ^ (i4 << 7);
        int i6 = this.a;
        int i7 = (((i6 << -5) | (i6 >>> 5)) ^ i4) ^ i3;
        int i8 = (i3 << -7) | (i3 >>> 7);
        this.d = (i8 ^ i5) ^ (i7 << 3);
        this.b = (((i4 << -1) | (i4 >>> 1)) ^ i7) ^ i5;
        this.c = (i5 << -3) | (i5 >>> 3);
        this.a = (i7 >>> 13) | (i7 << -13);
    }

    public abstract int[] q(byte[] bArr);

    public final void r(int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        int i6 = i3 ^ i5;
        int i7 = i2 ^ i6;
        int i8 = (i4 & i) ^ i7;
        this.d = i8;
        int i9 = i ^ (i2 & i5);
        this.c = (i3 | i9) ^ i7;
        int i10 = (i6 ^ i9) & i8;
        this.b = (~i6) ^ i10;
        this.a = (~i9) ^ i10;
    }

    public final void s(int i, int i2, int i3, int i4) {
        int i5 = (~i) ^ i2;
        int i6 = (i | i5) ^ i3;
        int i7 = i4 ^ i6;
        this.c = i7;
        int i8 = i2 ^ (i4 | i5);
        int i9 = i7 ^ i5;
        int i10 = (i6 & i8) ^ i9;
        this.d = i10;
        int i11 = i8 ^ i6;
        this.b = i10 ^ i11;
        this.a = i6 ^ (i11 & i9);
    }

    public final void t(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i2 ^ i4;
        int i7 = (i3 & i5) ^ i6;
        this.a = i7;
        int i8 = i3 ^ i5;
        int i9 = i2 & (i3 ^ i7);
        int i10 = i8 ^ i9;
        this.d = i10;
        int i11 = i ^ ((i9 | i4) & (i7 | i8));
        this.c = i11;
        this.b = (i11 ^ (i4 | i5)) ^ (i6 ^ i10);
    }

    public final void u(int i, int i2, int i3, int i4) {
        int i5 = i ^ i2;
        int i6 = i & i3;
        int i7 = i | i4;
        int i8 = i3 ^ i4;
        int i9 = i6 | (i5 & i7);
        int i10 = i8 ^ i9;
        this.c = i10;
        int i11 = (i7 ^ i2) ^ i9;
        int i12 = i5 ^ (i8 & i11);
        this.a = i12;
        int i13 = i12 & i10;
        this.b = i11 ^ i13;
        this.d = (i2 | i4) ^ (i8 ^ i13);
    }

    public final void v(int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        int i6 = i3 ^ (i4 & i5);
        int i7 = i2 | i6;
        this.d = i5 ^ i7;
        int i8 = ~i2;
        int i9 = (i5 | i8) ^ i6;
        this.a = i9;
        int i10 = i8 ^ i5;
        int i11 = (i7 & i10) ^ (i9 & i);
        this.c = i11;
        this.b = (i ^ i6) ^ (i10 & i11);
    }

    public final void w(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i2;
        int i7 = i ^ i4;
        int i8 = (i3 ^ i5) ^ (i6 | i7);
        this.a = i8;
        int i9 = i4 & i8;
        int i10 = (i6 ^ i8) ^ i9;
        this.b = i10;
        int i11 = i7 ^ (i8 | i5);
        this.c = (i6 | i9) ^ i11;
        this.d = (i11 & i10) ^ (i2 ^ i9);
    }

    public final void x(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i4;
        int i7 = i2 ^ i6;
        int i8 = i3 ^ (i5 | i6);
        int i9 = i2 ^ i8;
        this.b = i9;
        int i10 = (i6 | i9) ^ i4;
        int i11 = (i8 & i10) ^ i7;
        this.c = i11;
        int i12 = i10 ^ i8;
        this.a = i11 ^ i12;
        this.d = (i12 & i7) ^ (~i8);
    }

    public final void y(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i3;
        int i6 = (i3 & i5) ^ i4;
        int i7 = i ^ i6;
        int i8 = i2 ^ ((i4 | i5) & i7);
        this.b = i8;
        int i9 = (i & i7) ^ i5;
        this.d = i9;
        int i10 = (i8 | i6) ^ i7;
        int i11 = i6 ^ (i9 & i10);
        this.c = i11;
        this.a = (i9 & i11) ^ (~i10);
    }

    public final void reset() {
    }
}
