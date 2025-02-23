package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.params.HKDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class HKDFBytesGenerator implements DerivationFunction {
    public int a;

    public final void a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof HKDFParameters) {
            HKDFParameters hKDFParameters = (HKDFParameters) derivationParameters;
            byte[] c = Arrays.c((byte[]) null);
            Arrays.c((byte[]) null);
            if (c == null) {
                new KeyParameter(new byte[0], 0, 0);
                throw null;
            } else {
                new KeyParameter(c, 0, c.length);
                throw null;
            }
        } else {
            throw new IllegalArgumentException("HKDF parameters required for HKDFBytesGenerator");
        }
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        int i2 = this.a;
        if (i2 + i <= 0) {
            int i3 = i2 % 0;
            if (i3 != 0) {
                int min = Math.min(0 - i3, i);
                System.arraycopy((Object) null, i3, bArr, 0, min);
                int i4 = this.a + min;
                this.a = i4;
                if (i - min <= 0) {
                    return i;
                }
                if ((i4 / 0) + 1 >= 256) {
                    throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
                } else if (i4 != 0) {
                    throw null;
                } else {
                    throw null;
                }
            } else if ((i2 / 0) + 1 >= 256) {
                throw new DataLengthException("HKDF cannot generate more than 255 blocks of HashLen size");
            } else if (i2 != 0) {
                throw null;
            } else {
                throw null;
            }
        } else {
            throw new DataLengthException("HKDF may only be used for 255 * HashLen bytes of output");
        }
    }
}
