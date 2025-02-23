package org.spongycastle.pqc.math.ntru.util;

import com.google.common.primitives.UnsignedBytes;

public class ArrayEncoder {
    public static final int[] a = {0, 0, 0, 1, 1, 1, -1, -1};
    public static final int[] b = {0, 1, -1, 0, 1, -1, 0, 1};

    public static int a(int i, byte[] bArr) {
        return ((bArr[i / 8] & UnsignedBytes.MAX_VALUE) >> (i % 8)) & 1;
    }
}
