package org.spongycastle.jce.provider;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KDFParameters;

public class BrokenKDF2BytesGenerator implements DerivationFunction {
    public final void a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i < 0) {
            throw new OutputLengthException("output buffer too small");
        }
        throw null;
    }
}
