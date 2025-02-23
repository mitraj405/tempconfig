package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class VMPCEngine implements StreamCipher {
    public byte a = 0;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6068a = null;
    public byte b = 0;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6069b;
    public byte[] c;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            CipherParameters cipherParameters2 = parametersWithIV.a;
            if (cipherParameters2 instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) cipherParameters2;
                byte[] bArr = parametersWithIV.f6233a;
                this.f6069b = bArr;
                if (bArr == null || bArr.length < 1 || bArr.length > 768) {
                    throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
                }
                byte[] bArr2 = keyParameter.a;
                this.c = bArr2;
                c(bArr2, bArr);
                return;
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    public String b() {
        return "VMPC";
    }

    public void c(byte[] bArr, byte[] bArr2) {
        this.b = 0;
        this.f6068a = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f6068a[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f6068a;
            byte b2 = this.b;
            int i3 = i2 & Constants.MAX_HOST_LENGTH;
            byte b3 = bArr3[i3];
            byte b4 = bArr3[(b2 + b3 + bArr[i2 % bArr.length]) & Constants.MAX_HOST_LENGTH];
            this.b = b4;
            bArr3[i3] = bArr3[b4 & UnsignedBytes.MAX_VALUE];
            bArr3[b4 & UnsignedBytes.MAX_VALUE] = b3;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f6068a;
            byte b5 = this.b;
            int i5 = i4 & Constants.MAX_HOST_LENGTH;
            byte b6 = bArr4[i5];
            byte b7 = bArr4[(b5 + b6 + bArr2[i4 % bArr2.length]) & Constants.MAX_HOST_LENGTH];
            this.b = b7;
            bArr4[i5] = bArr4[b7 & UnsignedBytes.MAX_VALUE];
            bArr4[b7 & UnsignedBytes.MAX_VALUE] = b6;
        }
        this.a = 0;
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr3 = this.f6068a;
                byte b2 = this.b;
                byte b3 = this.a;
                byte b4 = bArr3[(b2 + bArr3[b3 & UnsignedBytes.MAX_VALUE]) & Constants.MAX_HOST_LENGTH];
                this.b = b4;
                byte b5 = bArr3[(bArr3[bArr3[b4 & UnsignedBytes.MAX_VALUE] & UnsignedBytes.MAX_VALUE] + 1) & Constants.MAX_HOST_LENGTH];
                byte b6 = bArr3[b3 & UnsignedBytes.MAX_VALUE];
                bArr3[b3 & UnsignedBytes.MAX_VALUE] = bArr3[b4 & UnsignedBytes.MAX_VALUE];
                bArr3[b4 & UnsignedBytes.MAX_VALUE] = b6;
                this.a = (byte) ((b3 + 1) & Constants.MAX_HOST_LENGTH);
                bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ b5);
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
        c(this.c, this.f6069b);
    }
}
