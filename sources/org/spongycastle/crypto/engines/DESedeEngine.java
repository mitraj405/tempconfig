package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;

public class DESedeEngine extends DESEngine {
    public boolean a;
    public int[] k = null;
    public int[] l = null;
    public int[] m = null;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr.length == 24 || bArr.length == 16) {
                this.a = z;
                byte[] bArr2 = new byte[8];
                System.arraycopy(bArr, 0, bArr2, 0, 8);
                this.k = f(bArr2, z);
                byte[] bArr3 = new byte[8];
                System.arraycopy(bArr, 8, bArr3, 0, 8);
                this.l = f(bArr3, !z);
                if (bArr.length == 24) {
                    byte[] bArr4 = new byte[8];
                    System.arraycopy(bArr, 16, bArr4, 0, 8);
                    this.m = f(bArr4, z);
                    return;
                }
                this.m = this.k;
                return;
            }
            throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
        }
        throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to DESede init - "));
    }

    public final String b() {
        return "DESede";
    }

    public final int c() {
        return 8;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) {
        int[] iArr = this.k;
        if (iArr == null) {
            throw new IllegalStateException("DESede engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 <= bArr2.length) {
            byte[] bArr3 = new byte[8];
            if (this.a) {
                DESEngine.d(iArr, bArr, i, bArr3, 0);
                DESEngine.d(this.l, bArr3, 0, bArr3, 0);
                DESEngine.d(this.m, bArr3, 0, bArr2, i2);
            } else {
                DESEngine.d(this.m, bArr, i, bArr3, 0);
                DESEngine.d(this.l, bArr3, 0, bArr3, 0);
                DESEngine.d(this.k, bArr3, 0, bArr2, i2);
            }
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
    }
}
