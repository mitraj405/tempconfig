package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Pack;

public class KXTSBlockCipher extends BufferedBlockCipher {
    public int b;

    public final int a(int i, byte[] bArr) {
        g();
        throw null;
    }

    public final void e(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            CipherParameters cipherParameters2 = parametersWithIV.a;
            byte[] bArr = parametersWithIV.f6233a;
            if (bArr.length != 0) {
                throw new IllegalArgumentException("Currently only support IVs of exactly one block");
            }
            byte[] bArr2 = new byte[0];
            System.arraycopy(bArr, 0, bArr2, 0, 0);
            this.f5794a.a(true, cipherParameters2);
            this.f5794a.e(0, 0, bArr2, bArr2);
            this.f5794a.a(z, cipherParameters2);
            Pack.i(0, bArr2, (long[]) null);
            throw null;
        }
        throw new IllegalArgumentException("Invalid parameters passed");
    }

    public final int f(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        } else if (bArr2.length - i < i2) {
            throw new OutputLengthException("Output buffer too short");
        } else if (i2 % 0 != 0) {
            throw new IllegalArgumentException("Partial blocks not supported");
        } else if (i2 <= 0) {
            return i2;
        } else {
            int i4 = this.b;
            if (i4 == -1) {
                throw new IllegalStateException("Attempt to process too many blocks");
            }
            this.b = i4 + 1;
            throw null;
        }
    }

    public final void g() {
        this.f5794a.reset();
        throw null;
    }

    public final int c(int i) {
        return i;
    }

    public final int d(int i) {
        return i;
    }
}
