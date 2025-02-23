package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import org.spongycastle.util.encoders.Hex;

public class GMSSRootSig {
    public final String toString() {
        String l = lf.l(new StringBuilder(""), 0, "  ");
        int[] iArr = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] iArr2 = new int[2];
        iArr2[1] = 0;
        iArr2[0] = 5;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr2);
        int[] iArr3 = new int[2];
        iArr3[1] = 0;
        iArr3[0] = 5;
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, iArr3);
        bArr2[0] = null;
        bArr2[1] = null;
        bArr2[2] = null;
        bArr2[3] = null;
        bArr2[4] = new byte[]{(byte) ((int) (0 & 255)), (byte) ((int) ((0 >> 8) & 255)), (byte) ((int) ((0 >> 16) & 255)), (byte) ((int) ((0 >> 24) & 255)), (byte) ((int) ((0 >> 32) & 255)), (byte) ((int) ((0 >> 40) & 255)), (byte) ((int) ((0 >> 48) & 255)), (byte) ((int) ((0 >> 56) & 255)), (byte) ((int) (0 & 255)), (byte) ((int) ((0 >> 8) & 255)), (byte) ((int) ((0 >> 16) & 255)), (byte) ((int) ((0 >> 24) & 255)), (byte) ((int) ((0 >> 32) & 255)), (byte) ((int) ((0 >> 40) & 255)), (byte) ((int) ((0 >> 48) & 255)), (byte) ((int) ((0 >> 56) & 255))};
        for (int i = 0; i < 9; i++) {
            l = lf.k(xx.J(l), iArr[i], " ");
        }
        for (int i2 = 0; i2 < 5; i2++) {
            l = C0709Uj.j(xx.J(l), new String(Hex.c(bArr2[i2])), " ");
        }
        return l;
    }
}
