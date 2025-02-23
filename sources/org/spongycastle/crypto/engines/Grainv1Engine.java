package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class Grainv1Engine implements StreamCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5967a = false;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5968a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f5969a;
    public int b = 2;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5970b;

    /* renamed from: b  reason: collision with other field name */
    public int[] f5971b;
    public byte[] c;

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            if (bArr == null || bArr.length != 8) {
                throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
            }
            CipherParameters cipherParameters2 = parametersWithIV.a;
            if (cipherParameters2 instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) cipherParameters2;
                byte[] bArr2 = keyParameter.a;
                byte[] bArr3 = new byte[bArr2.length];
                this.f5970b = bArr3;
                this.f5968a = new byte[bArr2.length];
                this.f5969a = new int[5];
                this.f5971b = new int[5];
                this.c = new byte[2];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                byte[] bArr4 = this.f5968a;
                byte[] bArr5 = keyParameter.a;
                System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
                reset();
                return;
            }
            throw new IllegalArgumentException("Grain v1 Init parameters must include a key");
        }
        throw new IllegalArgumentException("Grain v1 Init parameters must include an IV");
    }

    public final String b() {
        return "Grain v1";
    }

    public final byte c() {
        if (this.b > 1) {
            int e = e();
            this.a = e;
            byte[] bArr = this.c;
            bArr[0] = (byte) e;
            bArr[1] = (byte) (e >> 8);
            int[] iArr = this.f5971b;
            h(g() ^ this.f5969a[0], iArr);
            this.f5971b = iArr;
            int[] iArr2 = this.f5969a;
            h(f(), iArr2);
            this.f5969a = iArr2;
            this.b = 0;
        }
        byte[] bArr2 = this.c;
        int i = this.b;
        this.b = i + 1;
        return bArr2[i];
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (!this.f5967a) {
            throw new IllegalStateException("Grain v1 not initialised");
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
        int[] iArr = this.f5971b;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 1) | (i2 << 15);
        int i4 = (i >>> 2) | (i2 << 14);
        int i5 = (i >>> 4) | (i2 << 12);
        int i6 = (i >>> 10) | (i2 << 6);
        int i7 = iArr[2];
        int i8 = (i2 >>> 15) | (i7 << 1);
        int i9 = iArr[3];
        int i10 = (i7 >>> 11) | (i9 << 5);
        int i11 = iArr[4];
        int i12 = (i9 >>> 8) | (i11 << 8);
        int i13 = (i11 << 1) | (i9 >>> 15);
        int[] iArr2 = this.f5969a;
        int i14 = iArr2[1];
        int i15 = (iArr2[0] >>> 3) | (i14 << 13);
        int i16 = iArr2[2];
        int i17 = (i14 >>> 9) | (i16 << 7);
        int i18 = (iArr2[3] << 2) | (i16 >>> 14);
        int i19 = iArr2[4];
        int i20 = (i17 ^ i13) ^ (i15 & i19);
        int i21 = i18 & i19;
        int i22 = i15 & i18;
        int i23 = i19 & i22;
        int i24 = i22 & i13;
        return (((((((((i13 & i21) ^ ((i24 ^ (i23 ^ (((i20 ^ i21) ^ (i19 & i13)) ^ ((i15 & i17) & i18)))) ^ ((i17 & i18) & i13))) ^ i3) ^ i4) ^ i5) ^ i6) ^ i8) ^ i10) ^ i12) & 65535;
    }

    public final int f() {
        int[] iArr = this.f5969a;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = (i2 >>> 7) | (i3 << 9);
        int i5 = iArr[3];
        int i6 = iArr[4];
        return (((i6 << 2) | (i5 >>> 14)) ^ ((((i ^ ((i >>> 13) | (i2 << 3))) ^ i4) ^ ((i3 >>> 6) | (i5 << 10))) ^ ((i5 >>> 3) | (i6 << 13)))) & 65535;
    }

    public final int g() {
        int[] iArr = this.f5971b;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 9) | (i2 << 7);
        int i4 = (i >>> 14) | (i2 << 2);
        int i5 = (i >>> 15) | (i2 << 1);
        int i6 = iArr[2];
        int i7 = (i2 >>> 5) | (i6 << 11);
        int i8 = (i2 >>> 12) | (i6 << 4);
        int i9 = iArr[3];
        int i10 = (i6 >>> 1) | (i9 << 15);
        int i11 = (i6 >>> 5) | (i9 << 11);
        int i12 = (i6 >>> 13) | (i9 << 3);
        int i13 = iArr[4];
        int i14 = (i9 >>> 4) | (i13 << 12);
        int i15 = (i9 >>> 12) | (i13 << 4);
        int i16 = (i13 << 1) | (i9 >>> 15);
        int i17 = i16 & i15;
        int i18 = i15 & i14;
        int i19 = ((((i ^ (((((((((((i9 >>> 14) | (i13 << 2)) ^ i15) ^ i14) ^ i12) ^ i11) ^ i10) ^ i8) ^ i7) ^ i4) ^ i3)) ^ i17) ^ (i11 & i10)) ^ (i5 & i3)) ^ (i18 & i12);
        int i20 = i10 & i8 & i7;
        return (((((((((i16 & i12) & i8) & i3) ^ (i19 ^ i20)) ^ ((i18 & i11) & i10)) ^ ((i17 & i7) & i5)) ^ (((i17 & i14) & i12) & i11)) ^ ((i20 & i5) & i3)) ^ (((((i14 & i12) & i11) & i10) & i8) & i7)) & 65535;
    }

    public final void h(int i, int[] iArr) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = i;
    }

    public final void reset() {
        this.b = 2;
        byte[] bArr = this.f5968a;
        byte[] bArr2 = this.f5970b;
        bArr2[8] = -1;
        bArr2[9] = -1;
        this.f5968a = bArr;
        this.f5970b = bArr2;
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f5971b;
            if (i >= iArr.length) {
                break;
            }
            byte[] bArr3 = this.f5968a;
            int i3 = i2 + 1;
            iArr[i] = ((bArr3[i2] & UnsignedBytes.MAX_VALUE) | (bArr3[i3] << 8)) & UnsignedBytes.MAX_VALUE;
            int[] iArr2 = this.f5969a;
            byte[] bArr4 = this.f5970b;
            iArr2[i] = ((bArr4[i2] & UnsignedBytes.MAX_VALUE) | (bArr4[i3] << 8)) & UnsignedBytes.MAX_VALUE;
            i2 += 2;
            i++;
        }
        for (int i4 = 0; i4 < 10; i4++) {
            this.a = e();
            int[] iArr3 = this.f5971b;
            h((g() ^ this.f5969a[0]) ^ this.a, iArr3);
            this.f5971b = iArr3;
            int[] iArr4 = this.f5969a;
            h(f() ^ this.a, iArr4);
            this.f5969a = iArr4;
        }
        this.f5967a = true;
    }
}
