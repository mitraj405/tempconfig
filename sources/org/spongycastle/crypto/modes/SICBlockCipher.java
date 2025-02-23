package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.SkippingStreamCipher;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6222a;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public final BlockCipher f6223b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6224b;
    public final byte[] c;

    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f6223b = blockCipher;
        int c2 = blockCipher.c();
        this.a = c2;
        this.f6222a = new byte[c2];
        this.f6224b = new byte[c2];
        this.c = new byte[c2];
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] c2 = Arrays.c(parametersWithIV.f6233a);
            this.f6222a = c2;
            int length = c2.length;
            int i = this.a;
            if (i >= length) {
                int i2 = 8;
                if (8 > i / 2) {
                    i2 = i / 2;
                }
                if (i - c2.length <= i2) {
                    CipherParameters cipherParameters2 = parametersWithIV.a;
                    if (cipherParameters2 != null) {
                        this.f6223b.a(true, cipherParameters2);
                    }
                    reset();
                    return;
                }
                throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (i - i2) + " bytes.");
            }
            throw new IllegalArgumentException(C1058d.y("CTR/SIC mode requires IV no greater than: ", i, " bytes."));
        }
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    public final String b() {
        return this.f6223b.b() + "/SIC";
    }

    public final int c() {
        return this.f6223b.c();
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        d(bArr, i, this.a, bArr2, i2);
        return this.a;
    }

    public final byte f(byte b2) throws DataLengthException, IllegalStateException {
        int i = this.b;
        byte[] bArr = this.f6224b;
        byte[] bArr2 = this.c;
        if (i == 0) {
            this.f6223b.e(0, 0, bArr, bArr2);
            int i2 = this.b;
            this.b = i2 + 1;
            return (byte) (b2 ^ bArr2[i2]);
        }
        int i3 = i + 1;
        this.b = i3;
        byte b3 = (byte) (b2 ^ bArr2[i]);
        if (i3 == bArr.length) {
            this.b = 0;
            h(0);
            g();
        }
        return b3;
    }

    public final void g() {
        if (this.f6222a.length < this.a) {
            int i = 0;
            while (true) {
                byte[] bArr = this.f6222a;
                if (i == bArr.length) {
                    return;
                }
                if (this.f6224b[i] == bArr[i]) {
                    i++;
                } else {
                    throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                }
            }
        }
    }

    public final void h(int i) {
        byte b2;
        byte[] bArr = this.f6224b;
        int length = bArr.length - i;
        do {
            length--;
            if (length >= 0) {
                b2 = (byte) (bArr[length] + 1);
                bArr[length] = b2;
            } else {
                return;
            }
        } while (b2 == 0);
    }

    public final void reset() {
        byte[] bArr = this.f6224b;
        Arrays.p(bArr, (byte) 0);
        byte[] bArr2 = this.f6222a;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.f6223b.reset();
        this.b = 0;
    }
}
