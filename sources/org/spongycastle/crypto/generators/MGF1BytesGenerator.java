package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.MGFParameters;

public class MGF1BytesGenerator implements DerivationFunction {
    public final void a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof MGFParameters) {
            MGFParameters mGFParameters = (MGFParameters) derivationParameters;
            return;
        }
        throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i < 0) {
            throw new OutputLengthException("output buffer too small");
        }
        throw null;
    }
}
