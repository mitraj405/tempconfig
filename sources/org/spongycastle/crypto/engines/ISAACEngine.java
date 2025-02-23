package org.spongycastle.crypto.engines;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class ISAACEngine implements StreamCipher {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5992a = false;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5993a = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];

    /* renamed from: a  reason: collision with other field name */
    public int[] f5994a = null;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5995b = null;

    /* renamed from: b  reason: collision with other field name */
    public int[] f5996b = null;
    public int c = 0;
    public int d = 0;

    public static void e(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = i ^ (i2 << 11);
        iArr[0] = i3;
        int i4 = iArr[3] + i3;
        iArr[3] = i4;
        int i5 = iArr[2];
        int i6 = i2 + i5;
        iArr[1] = i6;
        int i7 = i6 ^ (i5 >>> 2);
        iArr[1] = i7;
        int i8 = iArr[4] + i7;
        iArr[4] = i8;
        int i9 = i5 + i4;
        iArr[2] = i9;
        int i10 = i9 ^ (i4 << 8);
        iArr[2] = i10;
        int i11 = iArr[5] + i10;
        iArr[5] = i11;
        int i12 = i4 + i8;
        iArr[3] = i12;
        int i13 = i12 ^ (i8 >>> 16);
        iArr[3] = i13;
        int i14 = iArr[6] + i13;
        iArr[6] = i14;
        int i15 = i8 + i11;
        iArr[4] = i15;
        int i16 = (i11 << 10) ^ i15;
        iArr[4] = i16;
        int i17 = iArr[7] + i16;
        iArr[7] = i17;
        int i18 = i11 + i14;
        iArr[5] = i18;
        int i19 = (i14 >>> 4) ^ i18;
        iArr[5] = i19;
        int i20 = i3 + i19;
        iArr[0] = i20;
        int i21 = i14 + i17;
        iArr[6] = i21;
        int i22 = (i17 << 8) ^ i21;
        iArr[6] = i22;
        int i23 = i7 + i22;
        iArr[1] = i23;
        int i24 = i17 + i20;
        iArr[7] = i24;
        int i25 = (i20 >>> 9) ^ i24;
        iArr[7] = i25;
        iArr[2] = i10 + i25;
        iArr[0] = i20 + i23;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            f(((KeyParameter) cipherParameters).a);
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to ISAAC init - "));
    }

    public final String b() {
        return "ISAAC";
    }

    public final void c() {
        int i = this.b;
        int i2 = this.c + 1;
        this.c = i2;
        this.b = i + i2;
        for (int i3 = 0; i3 < 256; i3++) {
            int[] iArr = this.f5994a;
            int i4 = iArr[i3];
            int i5 = i3 & 3;
            if (i5 == 0) {
                int i6 = this.a;
                this.a = i6 ^ (i6 << 13);
            } else if (i5 == 1) {
                int i7 = this.a;
                this.a = i7 ^ (i7 >>> 6);
            } else if (i5 == 2) {
                int i8 = this.a;
                this.a = i8 ^ (i8 << 2);
            } else if (i5 == 3) {
                int i9 = this.a;
                this.a = i9 ^ (i9 >>> 16);
            }
            int i10 = this.a + iArr[(i3 + 128) & Constants.MAX_HOST_LENGTH];
            this.a = i10;
            int i11 = iArr[(i4 >>> 2) & Constants.MAX_HOST_LENGTH] + i10 + this.b;
            iArr[i3] = i11;
            int[] iArr2 = this.f5996b;
            int i12 = iArr[(i11 >>> 10) & Constants.MAX_HOST_LENGTH] + i4;
            this.b = i12;
            iArr2[i3] = i12;
        }
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.f5992a) {
            throw new IllegalStateException("ISAAC not initialised");
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (this.d == 0) {
                    c();
                    int[] iArr = this.f5996b;
                    byte[] bArr3 = new byte[(iArr.length * 4)];
                    Pack.d(bArr3, iArr);
                    this.f5993a = bArr3;
                }
                byte[] bArr4 = this.f5993a;
                int i5 = this.d;
                bArr2[i4 + i3] = (byte) (bArr4[i5] ^ bArr[i4 + i]);
                this.d = (i5 + 1) & 1023;
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void f(byte[] bArr) {
        int i;
        this.f5995b = bArr;
        if (this.f5994a == null) {
            this.f5994a = new int[256];
        }
        if (this.f5996b == null) {
            this.f5996b = new int[256];
        }
        for (int i2 = 0; i2 < 256; i2++) {
            int[] iArr = this.f5994a;
            this.f5996b[i2] = 0;
            iArr[i2] = 0;
        }
        this.c = 0;
        this.b = 0;
        this.a = 0;
        this.d = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i3 = 0; i3 < length; i3 += 4) {
            this.f5996b[i3 >>> 2] = Pack.f(i3, bArr2);
        }
        int[] iArr2 = new int[8];
        for (int i4 = 0; i4 < 8; i4++) {
            iArr2[i4] = -1640531527;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            e(iArr2);
        }
        for (int i6 = 0; i6 < 2; i6++) {
            for (int i7 = 0; i7 < 256; i7 += 8) {
                for (int i8 = 0; i8 < 8; i8++) {
                    int i9 = iArr2[i8];
                    if (i6 < 1) {
                        i = this.f5996b[i7 + i8];
                    } else {
                        i = this.f5994a[i7 + i8];
                    }
                    iArr2[i8] = i9 + i;
                }
                e(iArr2);
                for (int i10 = 0; i10 < 8; i10++) {
                    this.f5994a[i7 + i10] = iArr2[i10];
                }
            }
        }
        c();
        this.f5992a = true;
    }

    public final void reset() {
        f(this.f5995b);
    }
}
