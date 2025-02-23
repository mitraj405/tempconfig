package org.spongycastle.crypto;

public abstract class StreamBlockCipher implements BlockCipher, StreamCipher {
    public final BlockCipher a;

    public StreamBlockCipher(BlockCipher blockCipher) {
        this.a = blockCipher;
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        int i4 = i + i2;
        if (i4 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        } else if (i3 + i2 <= bArr2.length) {
            while (i < i4) {
                bArr2[i3] = f(bArr[i]);
                i3++;
                i++;
            }
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public abstract byte f(byte b);
}
