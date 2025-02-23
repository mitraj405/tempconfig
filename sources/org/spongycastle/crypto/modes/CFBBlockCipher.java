package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CFBBlockCipher extends StreamBlockCipher {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6146a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6147a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final BlockCipher f6148b = null;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6149b;
    public final byte[] c;
    public final byte[] d;

    public CFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.f6148b = blockCipher;
        int i2 = i / 8;
        this.a = i2;
        this.f6147a = new byte[blockCipher.c()];
        this.f6149b = new byte[blockCipher.c()];
        this.c = new byte[blockCipher.c()];
        this.d = new byte[i2];
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f6146a = z;
        boolean z2 = cipherParameters instanceof ParametersWithIV;
        BlockCipher blockCipher = this.f6148b;
        if (z2) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            int length = bArr.length;
            byte[] bArr2 = this.f6147a;
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
        return this.f6148b.b() + "/CFB" + (this.a * 8);
    }

    public final int c() {
        return this.a;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        d(bArr, i, this.a, bArr2, i2);
        return this.a;
    }

    public final byte f(byte b2) throws DataLengthException, IllegalStateException {
        byte b3;
        boolean z = this.f6146a;
        BlockCipher blockCipher = this.f6148b;
        int i = this.a;
        byte[] bArr = this.d;
        byte[] bArr2 = this.f6149b;
        byte[] bArr3 = this.c;
        if (z) {
            if (this.b == 0) {
                blockCipher.e(0, 0, bArr2, bArr3);
            }
            int i2 = this.b;
            b3 = (byte) (b2 ^ bArr3[i2]);
            int i3 = i2 + 1;
            this.b = i3;
            bArr[i2] = b3;
            if (i3 == i) {
                this.b = 0;
                System.arraycopy(bArr2, i, bArr2, 0, bArr2.length - i);
                System.arraycopy(bArr, 0, bArr2, bArr2.length - i, i);
            }
        } else {
            if (this.b == 0) {
                blockCipher.e(0, 0, bArr2, bArr3);
            }
            int i4 = this.b;
            bArr[i4] = b2;
            int i5 = i4 + 1;
            this.b = i5;
            b3 = (byte) (b2 ^ bArr3[i4]);
            if (i5 == i) {
                this.b = 0;
                System.arraycopy(bArr2, i, bArr2, 0, bArr2.length - i);
                System.arraycopy(bArr, 0, bArr2, bArr2.length - i, i);
            }
        }
        return b3;
    }

    public final void reset() {
        byte[] bArr = this.f6149b;
        byte[] bArr2 = this.f6147a;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        Arrays.p(this.d, (byte) 0);
        this.b = 0;
        this.f6148b.reset();
    }
}
