package org.spongycastle.pqc.math.linearalgebra;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

public final class LittleEndianConversions {
    private LittleEndianConversions() {
    }

    public static void a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 8);
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static int b(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) << Ascii.CAN);
    }
}
