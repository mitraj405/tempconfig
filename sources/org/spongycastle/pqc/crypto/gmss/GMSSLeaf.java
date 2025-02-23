package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.util.encoders.Hex;

public class GMSSLeaf {
    public final String toString() {
        String str = "";
        for (int i = 0; i < 4; i++) {
            str = lf.k(xx.J(str), new int[]{0, 0, 0, 0}[i], " ");
        }
        StringBuilder n = lf.n(str, " ");
        n.append(0);
        n.append(" ");
        n.append(0);
        n.append(" ");
        String k = lf.k(n, 0, " ");
        byte[][] bArr = {new byte[0], new byte[0], new byte[(0 * 0)], new byte[0]};
        bArr[0] = null;
        bArr[1] = null;
        bArr[2] = null;
        bArr[3] = null;
        for (int i2 = 0; i2 < 4; i2++) {
            if (bArr[i2] != null) {
                k = C0709Uj.j(xx.J(k), new String(Hex.c(bArr[i2])), " ");
            } else {
                k = C1058d.z(k, "null ");
            }
        }
        return k;
    }
}
