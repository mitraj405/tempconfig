package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;

public class NullEngine implements BlockCipher {
    public final int a = 1;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6000a;

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f6000a = true;
    }

    public final String b() {
        return "Null";
    }

    public final int c() {
        return this.a;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        if (this.f6000a) {
            int i3 = this.a;
            if (i + i3 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i2 + i3 <= bArr2.length) {
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr2[i2 + i4] = bArr[i + i4];
                }
                return i3;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Null engine not initialised");
        }
    }

    public final void reset() {
    }
}
