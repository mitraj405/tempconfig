package org.spongycastle.crypto.engines;

import com.google.android.gms.ads.AdRequest;
import com.google.android.material.internal.ViewUtils;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class HC256Engine implements StreamCipher {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5977a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5978a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f5979a = new int[UserMetadata.MAX_ATTRIBUTE_SIZE];
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5980b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f5981b = new int[UserMetadata.MAX_ATTRIBUTE_SIZE];
    public final byte[] c = new byte[4];

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f5980b = parametersWithIV.f6233a;
            cipherParameters2 = parametersWithIV.a;
        } else {
            this.f5980b = new byte[0];
            cipherParameters2 = cipherParameters;
        }
        if (cipherParameters2 instanceof KeyParameter) {
            this.f5978a = ((KeyParameter) cipherParameters2).a;
            e();
            this.f5977a = true;
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "Invalid parameter passed to HC256 init - "));
    }

    public final String b() {
        return "HC-256";
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
        if (!this.f5977a) {
            throw new IllegalStateException("HC-256 not initialised");
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
        byte[] bArr = this.f5978a;
        if (bArr.length != 32 && bArr.length != 16) {
            throw new IllegalArgumentException("The key must be 128/256 bits long");
        } else if (this.f5980b.length >= 16) {
            if (bArr.length != 32) {
                byte[] bArr2 = new byte[32];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                byte[] bArr3 = this.f5978a;
                System.arraycopy(bArr3, 0, bArr2, 16, bArr3.length);
                this.f5978a = bArr2;
            }
            byte[] bArr4 = this.f5980b;
            if (bArr4.length < 32) {
                byte[] bArr5 = new byte[32];
                System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
                byte[] bArr6 = this.f5980b;
                System.arraycopy(bArr6, 0, bArr5, bArr6.length, 32 - bArr6.length);
                this.f5980b = bArr5;
            }
            this.b = 0;
            this.a = 0;
            int[] iArr = new int[2560];
            for (int i = 0; i < 32; i++) {
                int i2 = i >> 2;
                iArr[i2] = iArr[i2] | ((this.f5978a[i] & UnsignedBytes.MAX_VALUE) << ((i & 3) * 8));
            }
            for (int i3 = 0; i3 < 32; i3++) {
                int i4 = (i3 >> 2) + 8;
                iArr[i4] = iArr[i4] | ((this.f5980b[i3] & UnsignedBytes.MAX_VALUE) << ((i3 & 3) * 8));
            }
            for (int i5 = 16; i5 < 2560; i5++) {
                int i6 = iArr[i5 - 2];
                int i7 = iArr[i5 - 15];
                iArr[i5] = ((i6 >>> 10) ^ (((i6 >>> 17) | (i6 << -17)) ^ ((i6 >>> 19) | (i6 << -19)))) + iArr[i5 - 7] + ((i7 >>> 3) ^ (((i7 >>> 7) | (i7 << -7)) ^ ((i7 >>> 18) | (i7 << -18)))) + iArr[i5 - 16] + i5;
            }
            System.arraycopy(iArr, AdRequest.MAX_CONTENT_URL_LENGTH, this.f5979a, 0, UserMetadata.MAX_ATTRIBUTE_SIZE);
            System.arraycopy(iArr, 1536, this.f5981b, 0, UserMetadata.MAX_ATTRIBUTE_SIZE);
            for (int i8 = 0; i8 < 4096; i8++) {
                f();
            }
            this.a = 0;
        } else {
            throw new IllegalArgumentException("The IV must be at least 128 bits long");
        }
    }

    public final int f() {
        int i;
        int i2;
        int i3;
        int i4 = this.a;
        int i5 = i4 & 1023;
        int[] iArr = this.f5979a;
        int[] iArr2 = this.f5981b;
        if (i4 < 1024) {
            int i6 = iArr[(i5 - 3) & 1023];
            int i7 = iArr[(i5 - 1023) & 1023];
            i = iArr[(i5 - 10) & 1023] + (((i6 >>> 10) | (i6 << -10)) ^ ((i7 >>> 23) | (i7 << -23))) + iArr2[(i6 ^ i7) & 1023] + iArr[i5];
            iArr[i5] = i;
            int i8 = iArr[(i5 - 12) & 1023];
            i2 = iArr2[i8 & Constants.MAX_HOST_LENGTH] + iArr2[((i8 >> 8) & Constants.MAX_HOST_LENGTH) + 256] + iArr2[((i8 >> 16) & Constants.MAX_HOST_LENGTH) + AdRequest.MAX_CONTENT_URL_LENGTH];
            i3 = iArr2[((i8 >> 24) & Constants.MAX_HOST_LENGTH) + ViewUtils.EDGE_TO_EDGE_FLAGS];
        } else {
            int i9 = iArr2[(i5 - 3) & 1023];
            int i10 = iArr2[(i5 - 1023) & 1023];
            i = iArr2[(i5 - 10) & 1023] + (((i9 >>> 10) | (i9 << -10)) ^ ((i10 >>> 23) | (i10 << -23))) + iArr[(i9 ^ i10) & 1023] + iArr2[i5];
            iArr2[i5] = i;
            int i11 = iArr2[(i5 - 12) & 1023];
            i2 = iArr[i11 & Constants.MAX_HOST_LENGTH] + iArr[((i11 >> 8) & Constants.MAX_HOST_LENGTH) + 256] + iArr[((i11 >> 16) & Constants.MAX_HOST_LENGTH) + AdRequest.MAX_CONTENT_URL_LENGTH];
            i3 = iArr[((i11 >> 24) & Constants.MAX_HOST_LENGTH) + ViewUtils.EDGE_TO_EDGE_FLAGS];
        }
        int i12 = (i2 + i3) ^ i;
        this.a = (i4 + 1) & 2047;
        return i12;
    }

    public final void reset() {
        e();
    }
}
