package org.spongycastle.crypto.engines;

import com.google.android.gms.ads.AdRequest;
import com.google.android.material.internal.ViewUtils;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class HC128Engine implements StreamCipher {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5972a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5973a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f5974a = new int[AdRequest.MAX_CONTENT_URL_LENGTH];
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5975b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f5976b = new int[AdRequest.MAX_CONTENT_URL_LENGTH];
    public final byte[] c = new byte[4];

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f5975b = parametersWithIV.f6233a;
            cipherParameters2 = parametersWithIV.a;
        } else {
            this.f5975b = new byte[0];
            cipherParameters2 = cipherParameters;
        }
        if (cipherParameters2 instanceof KeyParameter) {
            this.f5973a = ((KeyParameter) cipherParameters2).a;
            e();
            this.f5972a = true;
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "Invalid parameter passed to HC128 init - "));
    }

    public final String b() {
        return "HC-128";
    }

    public final byte c() {
        int i = this.b;
        byte[] bArr = this.c;
        if (i == 0) {
            int f = f();
            bArr[0] = (byte) (f & Constants.MAX_HOST_LENGTH);
            int i2 = f >> 8;
            bArr[1] = (byte) (i2 & Constants.MAX_HOST_LENGTH);
            int i3 = i2 >> 8;
            bArr[2] = (byte) (i3 & Constants.MAX_HOST_LENGTH);
            bArr[3] = (byte) ((i3 >> 8) & Constants.MAX_HOST_LENGTH);
        }
        int i4 = this.b;
        byte b2 = bArr[i4];
        this.b = (i4 + 1) & 3;
        return b2;
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (!this.f5972a) {
            throw new IllegalStateException("HC-128 not initialised");
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

    public final void e() {
        if (this.f5973a.length == 16) {
            this.b = 0;
            this.a = 0;
            int[] iArr = new int[1280];
            for (int i = 0; i < 16; i++) {
                int i2 = i >> 2;
                iArr[i2] = ((this.f5973a[i] & UnsignedBytes.MAX_VALUE) << ((i & 3) * 8)) | iArr[i2];
            }
            System.arraycopy(iArr, 0, iArr, 4, 4);
            int i3 = 0;
            while (true) {
                byte[] bArr = this.f5975b;
                if (i3 >= bArr.length || i3 >= 16) {
                    System.arraycopy(iArr, 8, iArr, 12, 4);
                } else {
                    int i4 = (i3 >> 2) + 8;
                    iArr[i4] = ((bArr[i3] & UnsignedBytes.MAX_VALUE) << ((i3 & 3) * 8)) | iArr[i4];
                    i3++;
                }
            }
            System.arraycopy(iArr, 8, iArr, 12, 4);
            for (int i5 = 16; i5 < 1280; i5++) {
                int i6 = iArr[i5 - 2];
                int i7 = ((i6 >>> 10) ^ (((i6 >>> 17) | (i6 << -17)) ^ ((i6 >>> 19) | (i6 << -19)))) + iArr[i5 - 7];
                int i8 = iArr[i5 - 15];
                iArr[i5] = i7 + ((i8 >>> 3) ^ (((i8 >>> 7) | (i8 << -7)) ^ ((i8 >>> 18) | (i8 << -18)))) + iArr[i5 - 16] + i5;
            }
            int[] iArr2 = this.f5974a;
            System.arraycopy(iArr, 256, iArr2, 0, AdRequest.MAX_CONTENT_URL_LENGTH);
            int[] iArr3 = this.f5976b;
            System.arraycopy(iArr, ViewUtils.EDGE_TO_EDGE_FLAGS, iArr3, 0, AdRequest.MAX_CONTENT_URL_LENGTH);
            for (int i9 = 0; i9 < 512; i9++) {
                iArr2[i9] = f();
            }
            for (int i10 = 0; i10 < 512; i10++) {
                iArr3[i10] = f();
            }
            this.a = 0;
            return;
        }
        throw new IllegalArgumentException("The key must be 128 bits long");
    }

    public final int f() {
        int i;
        int i2;
        int i3;
        int i4 = this.a;
        int i5 = i4 & 511;
        int[] iArr = this.f5974a;
        int[] iArr2 = this.f5976b;
        if (i4 < 512) {
            int i6 = iArr[i5];
            int i7 = iArr[(i5 - 3) & 511];
            int i8 = iArr[(i5 - 10) & 511];
            int i9 = iArr[(i5 - 511) & 511];
            i = (((i7 << -10) | (i7 >>> 10)) ^ ((i9 << -23) | (i9 >>> 23))) + ((i8 << -8) | (i8 >>> 8)) + i6;
            iArr[i5] = i;
            int i10 = iArr[(i5 - 12) & 511];
            i2 = iArr2[i10 & Constants.MAX_HOST_LENGTH];
            i3 = iArr2[((i10 >> 16) & Constants.MAX_HOST_LENGTH) + 256];
        } else {
            int i11 = iArr2[i5];
            int i12 = iArr2[(i5 - 3) & 511];
            int i13 = iArr2[(i5 - 10) & 511];
            int i14 = iArr2[(i5 - 511) & 511];
            i = (((i12 >>> -10) | (i12 << 10)) ^ ((i14 >>> -23) | (i14 << 23))) + ((i13 >>> -8) | (i13 << 8)) + i11;
            iArr2[i5] = i;
            int i15 = iArr2[(i5 - 12) & 511];
            i2 = iArr[i15 & Constants.MAX_HOST_LENGTH];
            i3 = iArr[((i15 >> 16) & Constants.MAX_HOST_LENGTH) + 256];
        }
        int i16 = (i2 + i3) ^ i;
        this.a = (i4 + 1) & 1023;
        return i16;
    }

    public final void reset() {
        e();
    }
}
