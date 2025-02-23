package org.spongycastle.pqc.math.linearalgebra;

public final class ByteUtils {
    private ByteUtils() {
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[][] b(int i, byte[] bArr) throws ArrayIndexOutOfBoundsException {
        if (i <= bArr.length) {
            byte[] bArr2 = new byte[i];
            byte[][] bArr3 = {bArr2, new byte[(bArr.length - i)]};
            System.arraycopy(bArr, 0, bArr2, 0, i);
            System.arraycopy(bArr, i, bArr3[1], 0, bArr.length - i);
            return bArr3;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
