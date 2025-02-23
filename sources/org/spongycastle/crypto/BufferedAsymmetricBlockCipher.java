package org.spongycastle.crypto;

public class BufferedAsymmetricBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f5792a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5793a;

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f5792a = asymmetricBlockCipher;
    }

    public final void a(int i, byte[] bArr, int i2) {
        if (i2 != 0) {
            if (i2 >= 0) {
                int i3 = this.a;
                int i4 = i3 + i2;
                byte[] bArr2 = this.f5793a;
                if (i4 <= bArr2.length) {
                    System.arraycopy(bArr, i, bArr2, i3, i2);
                    this.a += i2;
                    return;
                }
                throw new DataLengthException("attempt to process message too long for cipher");
            }
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
    }
}
