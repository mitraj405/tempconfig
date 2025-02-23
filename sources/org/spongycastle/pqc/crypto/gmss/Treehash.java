package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.util.encoders.Hex;

public class Treehash {
    public final byte[][] a() {
        throw null;
    }

    public final String toString() {
        String str;
        String str2 = "Treehash    : ";
        for (int i = 0; i < 0 + 6; i++) {
            StringBuilder J = xx.J(str);
            int[] iArr = new int[(0 + 6)];
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            iArr[5] = 0;
            str2 = lf.k(J, iArr[i], " ");
        }
        for (int i2 = 0; i2 < 0 + 3; i2++) {
            if (a()[i2] != null) {
                str = C0709Uj.j(xx.J(str), new String(Hex.c(a()[i2])), " ");
            } else {
                str = C1058d.z(str, "null ");
            }
        }
        lf.n(str, "  ");
        throw null;
    }
}
