package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class KCTRBlockCipher extends StreamBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6184a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6185a;
    public final BlockCipher b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6186b;
    public final byte[] c;

    public KCTRBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.b = blockCipher;
        this.f6185a = new byte[blockCipher.c()];
        this.f6186b = new byte[blockCipher.c()];
        this.c = new byte[blockCipher.c()];
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f6184a = true;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            byte[] bArr2 = this.f6185a;
            Arrays.p(bArr2, (byte) 0);
            System.arraycopy(bArr, 0, bArr2, bArr2.length - bArr.length, bArr.length);
            CipherParameters cipherParameters2 = parametersWithIV.a;
            if (cipherParameters2 != null) {
                this.b.a(true, cipherParameters2);
            }
            reset();
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed");
    }

    public final String b() {
        return this.b.b() + "/KCTR";
    }

    public final int c() {
        return this.b.c();
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        if (bArr.length - i < c()) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr2.length - i2 >= c()) {
            d(bArr, i, c(), bArr2, i2);
            return c();
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final byte f(byte b2) {
        int i = this.a;
        byte[] bArr = this.f6186b;
        byte[] bArr2 = this.c;
        if (i == 0) {
            int i2 = 0;
            while (i2 < bArr.length) {
                int i3 = i2 + 1;
                byte b3 = (byte) (bArr[i2] + 1);
                bArr[i2] = b3;
                if (b3 != 0) {
                    break;
                }
                i2 = i3;
            }
            this.b.e(0, 0, bArr, bArr2);
            int i4 = this.a;
            this.a = i4 + 1;
            return (byte) (b2 ^ bArr2[i4]);
        }
        int i5 = i + 1;
        this.a = i5;
        byte b4 = (byte) (b2 ^ bArr2[i]);
        if (i5 == bArr.length) {
            this.a = 0;
        }
        return b4;
    }

    public final void reset() {
        boolean z = this.f6184a;
        BlockCipher blockCipher = this.b;
        if (z) {
            blockCipher.e(0, 0, this.f6185a, this.f6186b);
        }
        blockCipher.reset();
        this.a = 0;
    }
}
