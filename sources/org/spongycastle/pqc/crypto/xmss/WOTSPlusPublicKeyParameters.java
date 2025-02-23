package org.spongycastle.pqc.crypto.xmss;

final class WOTSPlusPublicKeyParameters {
    public final byte[][] a;

    public WOTSPlusPublicKeyParameters(WOTSPlusParameters wOTSPlusParameters, byte[][] bArr) {
        if (wOTSPlusParameters == null) {
            throw new NullPointerException("params == null");
        } else if (XMSSUtil.g(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        } else if (bArr.length == wOTSPlusParameters.c) {
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i].length == wOTSPlusParameters.a) {
                    i++;
                } else {
                    throw new IllegalArgumentException("wrong publicKey format");
                }
            }
            this.a = XMSSUtil.c(bArr);
        } else {
            throw new IllegalArgumentException("wrong publicKey size");
        }
    }
}
