package org.spongycastle.pqc.crypto.newhope;

import org.spongycastle.crypto.engines.ChaChaEngine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

class ChaCha20 {
    public static void a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        ChaChaEngine chaChaEngine = new ChaChaEngine(20);
        chaChaEngine.a(true, new ParametersWithIV(new KeyParameter(bArr, 0, bArr.length), bArr2, 0, bArr2.length));
        chaChaEngine.d(bArr3, 0, i, bArr3, 0);
    }
}
