package org.spongycastle.crypto.engines;

import org.spongycastle.util.Pack;

public class OldIESEngine extends IESEngine {
    public final byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        if (bArr != null) {
            Pack.c(bArr.length * 8, bArr2, 0);
        }
        return bArr2;
    }
}
