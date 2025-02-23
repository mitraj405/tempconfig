package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFDoublePipelineIterationParameters;
import org.spongycastle.crypto.params.KeyParameter;

public class KDFDoublePipelineIterationBytesGenerator implements MacDerivationFunction {
    public int a;

    static {
        BigInteger.valueOf(2147483647L);
        BigInteger.valueOf(2);
    }

    public final void a(DerivationParameters derivationParameters) {
        if (!(derivationParameters instanceof KDFDoublePipelineIterationParameters)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        KDFDoublePipelineIterationParameters kDFDoublePipelineIterationParameters = (KDFDoublePipelineIterationParameters) derivationParameters;
        new KeyParameter((byte[]) null);
        throw null;
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        int i2 = this.a;
        int i3 = i2 + i;
        if (i3 < 0 || i3 >= 0) {
            throw new DataLengthException("Current KDFCTR may only be used for 0 bytes");
        }
        int i4 = i2 % 0;
        if (i4 != 0) {
            int min = Math.min(0 - i4, i);
            System.arraycopy((Object) null, i4, bArr, 0, min);
            int i5 = this.a + min;
            this.a = i5;
            if (i - min <= 0) {
                return i;
            }
            if (i5 == 0) {
                throw null;
            }
            throw null;
        } else if (i2 == 0) {
            throw null;
        } else {
            throw null;
        }
    }
}
