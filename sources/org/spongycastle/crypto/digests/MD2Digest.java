package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public class MD2Digest implements ExtendedDigest, Memoable {
    public static final byte[] d = {41, 46, 67, -55, -94, -40, 124, 1, 61, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, -64, -57, 115, -116, -104, -109, 43, -39, -68, 76, -126, -54, Ascii.RS, -101, 87, 60, -3, -44, -32, Ascii.SYN, 103, 66, 111, Ascii.CAN, -118, Ascii.ETB, -27, Ascii.DC2, -66, 78, -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, Ascii.NAK, -78, 7, 63, -108, -62, Ascii.DLE, -119, Ascii.VT, 34, 95, 33, UnsignedBytes.MAX_POWER_OF_TWO, Ascii.DEL, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, Ascii.EM, 48, -77, 72, -91, -75, -47, -41, 94, -110, 42, -84, 86, -86, -58, 79, -72, 56, -46, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, -49, 101, -26, 45, -88, 2, Ascii.ESC, 96, 37, -83, -82, -80, -71, -10, Ascii.FS, 70, 97, 105, 52, SignedBytes.MAX_POWER_OF_TWO, 126, Ascii.SI, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, 44, 83, Ascii.CR, 110, -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 77, 82, 106, -36, 55, -56, 108, -63, -85, -6, 36, -31, 123, 8, Ascii.FF, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, -53, -43, -2, 59, 0, Ascii.GS, 57, -14, -17, -73, Ascii.SO, 102, 88, -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, Ascii.US, Ascii.SUB, -37, -103, -115, 51, -97, 17, -125, Ascii.DC4};
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5854a = new byte[48];
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f5855b = new byte[16];
    public final byte[] c = new byte[16];

    public MD2Digest() {
        reset();
    }

    public final Memoable a() {
        return new MD2Digest(this);
    }

    public final String b() {
        return "MD2";
    }

    public final int c(int i, byte[] bArr) {
        byte[] bArr2 = this.f5855b;
        int length = bArr2.length;
        int i2 = this.b;
        byte b2 = (byte) (length - i2);
        while (i2 < bArr2.length) {
            bArr2[i2] = b2;
            i2++;
        }
        k(bArr2);
        j(bArr2);
        j(this.c);
        System.arraycopy(this.f5854a, this.a, bArr, i, 16);
        reset();
        return 16;
    }

    public final void d(byte b2) {
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte[] bArr = this.f5855b;
        bArr[i] = b2;
        if (i2 == 16) {
            k(bArr);
            j(bArr);
            this.b = 0;
        }
    }

    public final void e(Memoable memoable) {
        i((MD2Digest) memoable);
    }

    public final int f() {
        return 16;
    }

    public final int h() {
        return 16;
    }

    public final void i(MD2Digest mD2Digest) {
        byte[] bArr = mD2Digest.f5854a;
        System.arraycopy(bArr, 0, this.f5854a, 0, bArr.length);
        this.a = mD2Digest.a;
        byte[] bArr2 = mD2Digest.f5855b;
        System.arraycopy(bArr2, 0, this.f5855b, 0, bArr2.length);
        this.b = mD2Digest.b;
        byte[] bArr3 = mD2Digest.c;
        System.arraycopy(bArr3, 0, this.c, 0, bArr3.length);
    }

    public final void j(byte[] bArr) {
        byte[] bArr2;
        int i = 0;
        while (true) {
            bArr2 = this.f5854a;
            if (i >= 16) {
                break;
            }
            bArr2[i + 16] = bArr[i];
            bArr2[i + 32] = (byte) (bArr[i] ^ bArr2[i]);
            i++;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 18; i3++) {
            for (int i4 = 0; i4 < 48; i4++) {
                byte b2 = (byte) (d[i2] ^ bArr2[i4]);
                bArr2[i4] = b2;
                i2 = b2 & UnsignedBytes.MAX_VALUE;
            }
            i2 = (i2 + i3) % 256;
        }
    }

    public final void k(byte[] bArr) {
        byte[] bArr2 = this.c;
        byte b2 = bArr2[15];
        for (int i = 0; i < 16; i++) {
            b2 = (byte) (d[(b2 ^ bArr[i]) & UnsignedBytes.MAX_VALUE] ^ bArr2[i]);
            bArr2[i] = b2;
        }
    }

    public final void reset() {
        this.a = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f5854a;
            if (i == bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        this.b = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f5855b;
            if (i2 == bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.c;
            if (i3 != bArr3.length) {
                bArr3[i3] = 0;
                i3++;
            } else {
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        while (this.b != 0 && i2 > 0) {
            d(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > 16) {
            byte[] bArr2 = this.f5855b;
            System.arraycopy(bArr, i, bArr2, 0, 16);
            k(bArr2);
            j(bArr2);
            i2 -= 16;
            i += 16;
        }
        while (i2 > 0) {
            d(bArr[i]);
            i++;
            i2--;
        }
    }

    public MD2Digest(MD2Digest mD2Digest) {
        i(mD2Digest);
    }
}
