package org.spongycastle.pqc.crypto.xmss;

import com.google.common.primitives.UnsignedBytes;

public class XMSSUtil {
    public static long a(byte[] bArr, int i) {
        if (bArr != null) {
            long j = 0;
            for (int i2 = 0; i2 < 0 + i; i2++) {
                j = (j << 8) | ((long) (bArr[i2] & UnsignedBytes.MAX_VALUE));
            }
            return j;
        }
        throw new NullPointerException("in == null");
    }

    public static byte[] b(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = bArr[i];
            }
            return bArr2;
        }
        throw new NullPointerException("in == null");
    }

    public static byte[][] c(byte[][] bArr) {
        if (!g(bArr)) {
            byte[][] bArr2 = new byte[bArr.length][];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = new byte[bArr[i].length];
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = bArr[i];
                    if (i2 >= bArr3.length) {
                        break;
                    }
                    bArr2[i][i2] = bArr3[i2];
                    i2++;
                }
            }
            return bArr2;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static void d(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null) {
            throw new NullPointerException("src == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (bArr2.length + i <= bArr.length) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr[i + i2] = bArr2[i2];
            }
        } else {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
    }

    public static byte[] e(int i, byte[] bArr, int i2) {
        if (bArr == null) {
            throw new NullPointerException("src == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        } else if (i + i2 <= bArr.length) {
            byte[] bArr2 = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[i3] = bArr[i + i3];
            }
            return bArr2;
        } else {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
    }

    public static int f(int i, long j) {
        return (int) (j & ((1 << i) - 1));
    }

    public static boolean g(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(int i, long j) {
        if (j < 0) {
            throw new IllegalStateException("index must not be negative");
        } else if (j < (1 << i)) {
            return true;
        } else {
            return false;
        }
    }

    public static int i(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public static byte[] j(int i, long j) {
        byte[] bArr = new byte[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) j);
            j >>>= 8;
        }
        return bArr;
    }
}
