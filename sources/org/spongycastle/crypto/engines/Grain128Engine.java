package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class Grain128Engine implements StreamCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5962a = false;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5963a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f5964a;
    public int b = 4;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5965b;

    /* renamed from: b  reason: collision with other field name */
    public int[] f5966b;
    public byte[] c;

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            if (bArr == null || bArr.length != 12) {
                throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
            }
            CipherParameters cipherParameters2 = parametersWithIV.a;
            if (cipherParameters2 instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) cipherParameters2;
                byte[] bArr2 = keyParameter.a;
                byte[] bArr3 = new byte[bArr2.length];
                this.f5965b = bArr3;
                this.f5963a = new byte[bArr2.length];
                this.f5964a = new int[4];
                this.f5966b = new int[4];
                this.c = new byte[4];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                byte[] bArr4 = this.f5963a;
                byte[] bArr5 = keyParameter.a;
                System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
                reset();
                return;
            }
            throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
        }
        throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
    }

    public final String b() {
        return "Grain-128";
    }

    public final byte c() {
        if (this.b > 3) {
            int e = e();
            this.a = e;
            byte[] bArr = this.c;
            bArr[0] = (byte) e;
            bArr[1] = (byte) (e >> 8);
            bArr[2] = (byte) (e >> 16);
            bArr[3] = (byte) (e >> 24);
            int[] iArr = this.f5966b;
            h(g() ^ this.f5964a[0], iArr);
            this.f5966b = iArr;
            int[] iArr2 = this.f5964a;
            h(f(), iArr2);
            this.f5964a = iArr2;
            this.b = 0;
        }
        byte[] bArr2 = this.c;
        int i = this.b;
        this.b = i + 1;
        return bArr2[i];
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (!this.f5962a) {
            throw new IllegalStateException("Grain-128 not initialised");
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ c());
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final int e() {
        int[] iArr = this.f5966b;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 2) | (i2 << 30);
        int i4 = (i >>> 12) | (i2 << 20);
        int i5 = (i >>> 15) | (i2 << 17);
        int i6 = iArr[2];
        int i7 = (i2 >>> 4) | (i6 << 28);
        int i8 = (i2 >>> 13) | (i6 << 19);
        int i9 = iArr[3];
        int i10 = (i6 >>> 9) | (i9 << 23);
        int i11 = (i6 >>> 25) | (i9 << 7);
        int i12 = (i9 << 1) | (i6 >>> 31);
        int[] iArr2 = this.f5964a;
        int i13 = iArr2[0];
        int i14 = iArr2[1];
        int i15 = (i13 >>> 8) | (i14 << 24);
        int i16 = (i13 >>> 13) | (i14 << 19);
        int i17 = (i13 >>> 20) | (i14 << 12);
        int i18 = iArr2[2];
        int i19 = iArr2[3];
        int i20 = i16 & i17;
        int i21 = i12 & i4 & ((i19 << 1) | (i18 >>> 31));
        return ((((((((i21 ^ (((i20 ^ (i4 & i15)) ^ (i12 & ((i14 >>> 10) | (i18 << 22)))) ^ (((i14 >>> 28) | (i18 << 4)) & ((i18 >>> 15) | (i19 << 17))))) ^ ((i18 >>> 29) | (i19 << 3))) ^ i3) ^ i5) ^ i7) ^ i8) ^ i6) ^ i10) ^ i11;
    }

    public final int f() {
        int[] iArr = this.f5964a;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 7) | (i2 << 25);
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = (i4 >>> 6) | (i5 << 26);
        return i5 ^ ((((i ^ i3) ^ ((i2 >>> 6) | (i4 << 26))) ^ i6) ^ ((i4 >>> 17) | (i5 << 15)));
    }

    public final int g() {
        int[] iArr = this.f5966b;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 3) | (i2 << 29);
        int i4 = (i >>> 11) | (i2 << 21);
        int i5 = (i >>> 13) | (i2 << 19);
        int i6 = (i >>> 17) | (i2 << 15);
        int i7 = (i >>> 18) | (i2 << 14);
        int i8 = (i >>> 26) | (i2 << 6);
        int i9 = (i >>> 27) | (i2 << 5);
        int i10 = iArr[2];
        int i11 = (i2 >>> 8) | (i10 << 24);
        int i12 = (i2 >>> 16) | (i10 << 16);
        int i13 = (i2 >>> 24) | (i10 << 8);
        int i14 = (i2 >>> 27) | (i10 << 5);
        int i15 = (i2 >>> 29) | (i10 << 3);
        int i16 = iArr[3];
        return (((((((i16 ^ (((i ^ i8) ^ i13) ^ ((i10 >>> 27) | (i16 << 5)))) ^ (i3 & ((i10 >>> 3) | (i16 << 29)))) ^ (i4 & i5)) ^ (i6 & i7)) ^ (i9 & i14)) ^ (i11 & i12)) ^ (i15 & ((i10 >>> 1) | (i16 << 31)))) ^ (((i10 >>> 4) | (i16 << 28)) & ((i10 >>> 20) | (i16 << 12)));
    }

    public final void h(int i, int[] iArr) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = i;
    }

    public final void reset() {
        this.b = 4;
        byte[] bArr = this.f5963a;
        byte[] bArr2 = this.f5965b;
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        this.f5963a = bArr;
        this.f5965b = bArr2;
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f5966b;
            if (i >= iArr.length) {
                break;
            }
            byte[] bArr3 = this.f5963a;
            int i3 = i2 + 3;
            int i4 = i2 + 2;
            int i5 = i2 + 1;
            iArr[i] = (bArr3[i2] & UnsignedBytes.MAX_VALUE) | (bArr3[i3] << Ascii.CAN) | ((bArr3[i4] << Ascii.DLE) & Ascii.NUL) | ((bArr3[i5] << 8) & Ascii.NUL);
            int[] iArr2 = this.f5964a;
            byte[] bArr4 = this.f5965b;
            iArr2[i] = (bArr4[i2] & UnsignedBytes.MAX_VALUE) | ((bArr4[i5] << 8) & Ascii.NUL) | (bArr4[i3] << Ascii.CAN) | ((bArr4[i4] << Ascii.DLE) & Ascii.NUL);
            i2 += 4;
            i++;
        }
        for (int i6 = 0; i6 < 8; i6++) {
            this.a = e();
            int[] iArr3 = this.f5966b;
            h((g() ^ this.f5964a[0]) ^ this.a, iArr3);
            this.f5966b = iArr3;
            int[] iArr4 = this.f5964a;
            h(f() ^ this.a, iArr4);
            this.f5964a = iArr4;
        }
        this.f5962a = true;
    }
}
