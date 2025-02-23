package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;

public class RC4Engine implements StreamCipher {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6009a = null;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6010b = null;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            this.f6010b = bArr;
            c(bArr);
            return;
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to RC4 init - "));
    }

    public final String b() {
        return "RC4";
    }

    public final void c(byte[] bArr) {
        this.f6010b = bArr;
        this.a = 0;
        this.b = 0;
        if (this.f6009a == null) {
            this.f6009a = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.f6009a[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
            byte[] bArr2 = this.f6009a;
            byte b3 = bArr2[i4];
            i3 = (b2 + b3 + i3) & Constants.MAX_HOST_LENGTH;
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b3;
            i2 = (i2 + 1) % bArr.length;
        }
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = (this.a + 1) & Constants.MAX_HOST_LENGTH;
                this.a = i5;
                byte[] bArr3 = this.f6009a;
                byte b2 = bArr3[i5];
                int i6 = (this.b + b2) & Constants.MAX_HOST_LENGTH;
                this.b = i6;
                bArr3[i5] = bArr3[i6];
                bArr3[i6] = b2;
                bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + b2) & Constants.MAX_HOST_LENGTH] ^ bArr[i4 + i]);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
        c(this.f6010b);
    }
}
