package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

public class DSTU7624Mac implements Mac {
    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            throw null;
        }
        throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
    }

    public final String b() {
        return "DSTU7624Mac";
    }

    public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
        throw null;
    }

    public final void d(byte b) {
        throw null;
    }

    public final int e() {
        return 0;
    }

    public final void reset() {
        Arrays.p((byte[]) null, (byte) 0);
        throw null;
    }

    public final void update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("can't have a negative input length!");
        }
        throw null;
    }
}
