package org.spongycastle.pqc.crypto.xmss;

final class WOTSPlusSignature {
    public final byte[][] a;

    public WOTSPlusSignature(WOTSPlusParameters wOTSPlusParameters, byte[][] bArr) {
        if (wOTSPlusParameters == null) {
            throw new NullPointerException("params == null");
        } else if (bArr == null) {
            throw new NullPointerException("signature == null");
        } else if (XMSSUtil.g(bArr)) {
            throw new NullPointerException("signature byte array == null");
        } else if (bArr.length == wOTSPlusParameters.c) {
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i].length == wOTSPlusParameters.a) {
                    i++;
                } else {
                    throw new IllegalArgumentException("wrong signature format");
                }
            }
            this.a = XMSSUtil.c(bArr);
        } else {
            throw new IllegalArgumentException("wrong signature size");
        }
    }
}
