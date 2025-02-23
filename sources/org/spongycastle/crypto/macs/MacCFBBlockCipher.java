package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;

/* compiled from: CFBBlockCipherMac */
class MacCFBBlockCipher {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6121a = null;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6122a;
    public final byte[] b;
    public final byte[] c;

    public MacCFBBlockCipher(BlockCipher blockCipher) {
        this.f6121a = blockCipher;
        this.a = 1;
        this.f6122a = new byte[blockCipher.c()];
        this.b = new byte[blockCipher.c()];
        this.c = new byte[blockCipher.c()];
    }

    public final void a(int i, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        int i2 = this.a;
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (0 + i2 <= bArr2.length) {
            BlockCipher blockCipher = this.f6121a;
            byte[] bArr3 = this.b;
            byte[] bArr4 = this.c;
            blockCipher.e(0, 0, bArr3, bArr4);
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[0 + i3] = (byte) (bArr4[i3] ^ bArr[i + i3]);
            }
            System.arraycopy(bArr3, i2, bArr3, 0, bArr3.length - i2);
            System.arraycopy(bArr2, 0, bArr3, bArr3.length - i2, i2);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }
}
