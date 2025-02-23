package org.spongycastle.pqc.crypto.rainbow.util;

import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Array;

public class RainbowUtil {
    public static byte[] a(short[] sArr) {
        byte[] bArr = new byte[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            bArr[i] = (byte) sArr[i];
        }
        return bArr;
    }

    public static short[] b(byte[] bArr) {
        short[] sArr = new short[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            sArr[i] = (short) (bArr[i] & UnsignedBytes.MAX_VALUE);
        }
        return sArr;
    }

    public static byte[][] c(short[][] sArr) {
        int length = sArr.length;
        int[] iArr = new int[2];
        iArr[1] = sArr[0].length;
        iArr[0] = length;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        for (int i = 0; i < sArr.length; i++) {
            for (int i2 = 0; i2 < sArr[0].length; i2++) {
                bArr[i][i2] = (byte) sArr[i][i2];
            }
        }
        return bArr;
    }

    public static short[][] d(byte[][] bArr) {
        int length = bArr.length;
        int[] iArr = new int[2];
        iArr[1] = bArr[0].length;
        iArr[0] = length;
        short[][] sArr = (short[][]) Array.newInstance(Short.TYPE, iArr);
        for (int i = 0; i < bArr.length; i++) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                sArr[i][i2] = (short) (bArr[i][i2] & UnsignedBytes.MAX_VALUE);
            }
        }
        return sArr;
    }

    public static byte[][][] e(short[][][] sArr) {
        int length = sArr.length;
        short[][] sArr2 = sArr[0];
        int length2 = sArr2.length;
        int[] iArr = new int[3];
        iArr[2] = sArr2[0].length;
        iArr[1] = length2;
        iArr[0] = length;
        byte[][][] bArr = (byte[][][]) Array.newInstance(Byte.TYPE, iArr);
        for (int i = 0; i < sArr.length; i++) {
            for (int i2 = 0; i2 < sArr[0].length; i2++) {
                for (int i3 = 0; i3 < sArr[0][0].length; i3++) {
                    bArr[i][i2][i3] = (byte) sArr[i][i2][i3];
                }
            }
        }
        return bArr;
    }

    public static short[][][] f(byte[][][] bArr) {
        int length = bArr.length;
        byte[][] bArr2 = bArr[0];
        int length2 = bArr2.length;
        int[] iArr = new int[3];
        iArr[2] = bArr2[0].length;
        iArr[1] = length2;
        iArr[0] = length;
        short[][][] sArr = (short[][][]) Array.newInstance(Short.TYPE, iArr);
        for (int i = 0; i < bArr.length; i++) {
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                for (int i3 = 0; i3 < bArr[0][0].length; i3++) {
                    sArr[i][i2][i3] = (short) (bArr[i][i2][i3] & UnsignedBytes.MAX_VALUE);
                }
            }
        }
        return sArr;
    }

    public static boolean g(short[] sArr, short[] sArr2) {
        boolean z;
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z2 = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            if (sArr[length] == sArr2[length]) {
                z = true;
            } else {
                z = false;
            }
            z2 &= z;
        }
        return z2;
    }

    public static boolean h(short[][] sArr, short[][] sArr2) {
        if (sArr.length != sArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = sArr.length - 1; length >= 0; length--) {
            z &= g(sArr[length], sArr2[length]);
        }
        return z;
    }
}
