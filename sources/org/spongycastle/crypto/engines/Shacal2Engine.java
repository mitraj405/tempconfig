package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class Shacal2Engine implements BlockCipher {
    public static final int[] b = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public boolean a = false;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6052a = null;

    public static void d(byte[] bArr, int[] iArr, int i) {
        int i2 = 0;
        while (i2 < 8) {
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
            int i5 = i4 + 1;
            iArr[i2] = b2 | ((bArr[i4] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i5] & UnsignedBytes.MAX_VALUE);
            i2++;
            i = i5 + 1;
        }
    }

    public static void f(byte[] bArr, int[] iArr, int i) {
        for (int i2 : iArr) {
            int i3 = i + 1;
            bArr[i] = (byte) (i2 >>> 24);
            int i4 = i3 + 1;
            bArr[i3] = (byte) (i2 >>> 16);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (i2 >>> 8);
            i = i5 + 1;
            bArr[i5] = (byte) i2;
        }
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.a = z;
            int[] iArr = new int[64];
            this.f6052a = iArr;
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr.length != 0 && bArr.length <= 64) {
                if (bArr.length >= 16 && bArr.length % 8 == 0) {
                    int i = 0;
                    int i2 = 0;
                    while (i < bArr.length / 4) {
                        int i3 = i2 + 1;
                        int i4 = i3 + 1;
                        byte b2 = ((bArr[i2] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
                        int i5 = i4 + 1;
                        iArr[i] = b2 | ((bArr[i4] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i5] & UnsignedBytes.MAX_VALUE);
                        i++;
                        i2 = i5 + 1;
                    }
                    for (int i6 = 16; i6 < 64; i6++) {
                        int[] iArr2 = this.f6052a;
                        int i7 = iArr2[i6 - 2];
                        int i8 = ((i7 >>> 10) ^ (((i7 >>> 17) | (i7 << -17)) ^ ((i7 >>> 19) | (i7 << -19)))) + iArr2[i6 - 7];
                        int i9 = iArr2[i6 - 15];
                        iArr2[i6] = i8 + ((i9 >>> 3) ^ (((i9 >>> 7) | (i9 << -7)) ^ ((i9 >>> 18) | (i9 << -18)))) + iArr2[i6 - 16];
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public final String b() {
        return "Shacal2";
    }

    public final int c() {
        return 32;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        int i3 = i;
        int i4 = i2;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (this.f6052a == null) {
            throw new IllegalStateException("Shacal2 not initialised");
        } else if (i3 + 32 > bArr3.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i4 + 32 <= bArr4.length) {
            boolean z = this.a;
            int[] iArr = b;
            char c = 1;
            if (z) {
                int[] iArr2 = new int[8];
                d(bArr3, iArr2, i3);
                for (int i5 = 0; i5 < 64; i5++) {
                    int i6 = iArr2[4];
                    int i7 = iArr2[5];
                    int i8 = ~i6;
                    int i9 = iArr2[6];
                    int i10 = ((((i6 >>> 6) | (i6 << -6)) ^ ((i6 >>> 11) | (i6 << -11))) ^ ((i6 >>> 25) | (i6 << -25))) + ((i6 & i7) ^ (i8 & i9)) + iArr2[7] + iArr[i5] + this.f6052a[i5];
                    iArr2[7] = i9;
                    iArr2[6] = i7;
                    iArr2[5] = i6;
                    iArr2[4] = iArr2[3] + i10;
                    int i11 = iArr2[2];
                    iArr2[3] = i11;
                    int i12 = iArr2[1];
                    iArr2[2] = i12;
                    int i13 = iArr2[0];
                    iArr2[1] = i13;
                    iArr2[0] = i10 + ((((i13 >>> 2) | (i13 << -2)) ^ ((i13 >>> 13) | (i13 << -13))) ^ ((i13 >>> 22) | (i13 << -22))) + (((i13 & i11) ^ (i13 & i12)) ^ (i11 & i12));
                }
                f(bArr4, iArr2, i4);
                return 32;
            }
            int[] iArr3 = new int[8];
            d(bArr3, iArr3, i3);
            int i14 = 63;
            while (i14 > -1) {
                int i15 = iArr3[0];
                int i16 = iArr3[c];
                int i17 = iArr3[2];
                int i18 = iArr3[3];
                int i19 = (i15 - ((((i16 >>> 2) | (i16 << -2)) ^ ((i16 >>> 13) | (i16 << -13))) ^ ((i16 >>> 22) | (i16 << -22)))) - (((i16 & i17) ^ (i16 & i18)) ^ (i17 & i18));
                iArr3[0] = i16;
                iArr3[c] = i17;
                iArr3[2] = i18;
                iArr3[3] = iArr3[4] - i19;
                int i20 = iArr3[5];
                iArr3[4] = i20;
                int i21 = iArr3[6];
                iArr3[5] = i21;
                int i22 = iArr3[7];
                iArr3[6] = i22;
                iArr3[7] = (((i19 - iArr[i14]) - this.f6052a[i14]) - ((((i20 >>> 6) | (i20 << -6)) ^ ((i20 >>> 11) | (i20 << -11))) ^ ((i20 >>> 25) | (i20 << -25)))) - (((~i20) & i22) ^ (i20 & i21));
                i14--;
                c = 1;
            }
            f(bArr4, iArr3, i4);
            return 32;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
    }
}
