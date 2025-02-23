package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;

public class OFBBlockCipher extends StreamBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6210a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final BlockCipher f6211b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6212b;
    public final byte[] c;

    public OFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.f6211b = blockCipher;
        this.b = i / 8;
        this.f6210a = new byte[blockCipher.c()];
        this.f6212b = new byte[blockCipher.c()];
        this.c = new byte[blockCipher.c()];
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        boolean z2 = cipherParameters instanceof ParametersWithIV;
        BlockCipher blockCipher = this.f6211b;
        if (z2) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            int length = bArr.length;
            byte[] bArr2 = this.f6210a;
            if (length < bArr2.length) {
                System.arraycopy(bArr, 0, bArr2, bArr2.length - bArr.length, bArr.length);
                for (int i = 0; i < bArr2.length - bArr.length; i++) {
                    bArr2[i] = 0;
                }
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            }
            reset();
            CipherParameters cipherParameters2 = parametersWithIV.a;
            if (cipherParameters2 != null) {
                blockCipher.a(true, cipherParameters2);
                return;
            }
            return;
        }
        reset();
        if (cipherParameters != null) {
            blockCipher.a(true, cipherParameters);
        }
    }

    public final String b() {
        return this.f6211b.b() + "/OFB" + (this.b * 8);
    }

    public final int c() {
        return this.b;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        d(bArr, i, this.b, bArr2, i2);
        return this.b;
    }

    public final byte f(byte b2) throws DataLengthException, IllegalStateException {
        int i = this.a;
        byte[] bArr = this.f6212b;
        byte[] bArr2 = this.c;
        if (i == 0) {
            this.f6211b.e(0, 0, bArr, bArr2);
        }
        int i2 = this.a;
        int i3 = i2 + 1;
        this.a = i3;
        byte b3 = (byte) (b2 ^ bArr2[i2]);
        int i4 = this.b;
        if (i3 == i4) {
            this.a = 0;
            System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
            System.arraycopy(bArr2, 0, bArr, bArr.length - i4, i4);
        }
        return b3;
    }

    public final void reset() {
        byte[] bArr = this.f6212b;
        byte[] bArr2 = this.f6210a;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.a = 0;
        this.f6211b.reset();
    }
}
