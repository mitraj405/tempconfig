package org.spongycastle.crypto.macs;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class VMPCMac implements Mac {
    public byte a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6132a = null;
    public byte b = 0;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6133b;
    public byte c = 0;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f6134c;
    public byte d;

    /* renamed from: d  reason: collision with other field name */
    public byte[] f6135d;
    public byte e;
    public byte f;
    public byte g;

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            CipherParameters cipherParameters2 = parametersWithIV.a;
            KeyParameter keyParameter = (KeyParameter) cipherParameters2;
            if (cipherParameters2 instanceof KeyParameter) {
                byte[] bArr = parametersWithIV.f6233a;
                this.f6134c = bArr;
                if (bArr == null || bArr.length < 1 || bArr.length > 768) {
                    throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
                }
                this.f6135d = keyParameter.a;
                reset();
                return;
            }
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
    }

    public final String b() {
        return "VMPC-MAC";
    }

    public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
        for (int i2 = 1; i2 < 25; i2++) {
            byte[] bArr2 = this.f6132a;
            byte b2 = this.c;
            byte b3 = this.b;
            byte b4 = b3 & UnsignedBytes.MAX_VALUE;
            byte b5 = bArr2[(b2 + bArr2[b4]) & Constants.MAX_HOST_LENGTH];
            this.c = b5;
            byte b6 = this.g;
            byte b7 = this.f;
            byte b8 = bArr2[(b6 + b7 + i2) & Constants.MAX_HOST_LENGTH];
            this.g = b8;
            byte b9 = this.e;
            byte b10 = bArr2[(b7 + b9 + i2) & Constants.MAX_HOST_LENGTH];
            this.f = b10;
            byte b11 = this.d;
            byte b12 = bArr2[(b9 + b11 + i2) & Constants.MAX_HOST_LENGTH];
            this.e = b12;
            byte b13 = bArr2[(b11 + b5 + i2) & Constants.MAX_HOST_LENGTH];
            this.d = b13;
            byte[] bArr3 = this.f6133b;
            byte b14 = this.a;
            byte b15 = b14 & Ascii.US;
            bArr3[b15] = (byte) (b13 ^ bArr3[b15]);
            int i3 = (b14 + 1) & 31;
            bArr3[i3] = (byte) (b12 ^ bArr3[i3]);
            int i4 = (b14 + 2) & 31;
            bArr3[i4] = (byte) (b10 ^ bArr3[i4]);
            int i5 = (b14 + 3) & 31;
            bArr3[i5] = (byte) (b8 ^ bArr3[i5]);
            this.a = (byte) ((b14 + 4) & 31);
            byte b16 = bArr2[b4];
            byte b17 = b5 & UnsignedBytes.MAX_VALUE;
            bArr2[b4] = bArr2[b17];
            bArr2[b17] = b16;
            this.b = (byte) ((b3 + 1) & Constants.MAX_HOST_LENGTH);
        }
        for (int i6 = 0; i6 < 768; i6++) {
            byte[] bArr4 = this.f6132a;
            byte b18 = this.c;
            int i7 = i6 & Constants.MAX_HOST_LENGTH;
            byte b19 = bArr4[i7];
            byte b20 = bArr4[(b18 + b19 + this.f6133b[i6 & 31]) & Constants.MAX_HOST_LENGTH];
            this.c = b20;
            byte b21 = b20 & UnsignedBytes.MAX_VALUE;
            bArr4[i7] = bArr4[b21];
            bArr4[b21] = b19;
        }
        byte[] bArr5 = new byte[20];
        for (int i8 = 0; i8 < 20; i8++) {
            byte[] bArr6 = this.f6132a;
            byte b22 = this.c;
            int i9 = i8 & Constants.MAX_HOST_LENGTH;
            byte b23 = bArr6[(b22 + bArr6[i9]) & Constants.MAX_HOST_LENGTH];
            this.c = b23;
            byte b24 = b23 & UnsignedBytes.MAX_VALUE;
            bArr5[i8] = bArr6[(bArr6[bArr6[b24] & UnsignedBytes.MAX_VALUE] + 1) & Constants.MAX_HOST_LENGTH];
            byte b25 = bArr6[i9];
            bArr6[i9] = bArr6[b24];
            bArr6[b24] = b25;
        }
        System.arraycopy(bArr5, 0, bArr, 0, 20);
        reset();
        return 20;
    }

    public final void d(byte b2) throws IllegalStateException {
        byte[] bArr = this.f6132a;
        byte b3 = this.c;
        byte b4 = this.b;
        byte b5 = bArr[(b3 + bArr[b4 & UnsignedBytes.MAX_VALUE]) & Constants.MAX_HOST_LENGTH];
        this.c = b5;
        byte b6 = this.g;
        byte b7 = this.f;
        byte b8 = bArr[(b6 + b7) & Constants.MAX_HOST_LENGTH];
        this.g = b8;
        byte b9 = this.e;
        byte b10 = bArr[(b7 + b9) & Constants.MAX_HOST_LENGTH];
        this.f = b10;
        byte b11 = this.d;
        byte b12 = bArr[(b9 + b11) & Constants.MAX_HOST_LENGTH];
        this.e = b12;
        byte b13 = bArr[(b11 + b5 + ((byte) (b2 ^ bArr[(bArr[bArr[b5 & UnsignedBytes.MAX_VALUE] & UnsignedBytes.MAX_VALUE] + 1) & Constants.MAX_HOST_LENGTH]))) & Constants.MAX_HOST_LENGTH];
        this.d = b13;
        byte[] bArr2 = this.f6133b;
        byte b14 = this.a;
        bArr2[b14 & Ascii.US] = (byte) (b13 ^ bArr2[b14 & Ascii.US]);
        bArr2[(b14 + 1) & 31] = (byte) (b12 ^ bArr2[(b14 + 1) & 31]);
        bArr2[(b14 + 2) & 31] = (byte) (b10 ^ bArr2[(b14 + 2) & 31]);
        bArr2[(b14 + 3) & 31] = (byte) (b8 ^ bArr2[(b14 + 3) & 31]);
        this.a = (byte) ((b14 + 4) & 31);
        byte b15 = bArr[b4 & UnsignedBytes.MAX_VALUE];
        bArr[b4 & UnsignedBytes.MAX_VALUE] = bArr[b5 & UnsignedBytes.MAX_VALUE];
        bArr[b5 & UnsignedBytes.MAX_VALUE] = b15;
        this.b = (byte) ((b4 + 1) & Constants.MAX_HOST_LENGTH);
    }

    public final int e() {
        return 20;
    }

    public final void reset() {
        byte[] bArr = this.f6135d;
        byte[] bArr2 = this.f6134c;
        this.c = 0;
        this.f6132a = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f6132a[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f6132a;
            byte b2 = this.c;
            int i3 = i2 & Constants.MAX_HOST_LENGTH;
            byte b3 = bArr3[i3];
            byte b4 = bArr3[(b2 + b3 + bArr[i2 % bArr.length]) & Constants.MAX_HOST_LENGTH];
            this.c = b4;
            byte b5 = b4 & UnsignedBytes.MAX_VALUE;
            bArr3[i3] = bArr3[b5];
            bArr3[b5] = b3;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f6132a;
            byte b6 = this.c;
            int i5 = i4 & Constants.MAX_HOST_LENGTH;
            byte b7 = bArr4[i5];
            byte b8 = bArr4[(b6 + b7 + bArr2[i4 % bArr2.length]) & Constants.MAX_HOST_LENGTH];
            this.c = b8;
            byte b9 = b8 & UnsignedBytes.MAX_VALUE;
            bArr4[i5] = bArr4[b9];
            bArr4[b9] = b7;
        }
        this.b = 0;
        this.g = 0;
        this.f = 0;
        this.e = 0;
        this.d = 0;
        this.a = 0;
        this.f6133b = new byte[32];
        for (int i6 = 0; i6 < 32; i6++) {
            this.f6133b[i6] = 0;
        }
    }

    public final void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        if (i + i2 <= bArr.length) {
            for (int i3 = 0; i3 < i2; i3++) {
                d(bArr[i + i3]);
            }
            return;
        }
        throw new DataLengthException("input buffer too short");
    }
}
