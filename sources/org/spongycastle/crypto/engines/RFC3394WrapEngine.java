package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class RFC3394WrapEngine implements Wrapper {
    public final BlockCipher a;

    /* renamed from: a  reason: collision with other field name */
    public KeyParameter f6019a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6020a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6021a = {-90, -90, -90, -90, -90, -90, -90, -90};
    public boolean b;

    public RFC3394WrapEngine(BlockCipher blockCipher) {
        this.a = blockCipher;
        this.f6020a = true;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.b = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).f6234a;
        }
        if (cipherParameters instanceof KeyParameter) {
            this.f6019a = (KeyParameter) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            this.f6021a = bArr;
            this.f6019a = (KeyParameter) parametersWithIV.a;
            if (bArr.length != 8) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
        }
    }

    public final String b() {
        return this.a.b();
    }

    public final byte[] c(byte[] bArr, int i) throws InvalidCipherTextException {
        byte[] bArr2 = bArr;
        int i2 = i;
        if (!this.b) {
            int i3 = i2 / 8;
            if (i3 * 8 == i2) {
                byte[] bArr3 = this.f6021a;
                byte[] bArr4 = new byte[(i2 - bArr3.length)];
                byte[] bArr5 = new byte[bArr3.length];
                byte[] bArr6 = new byte[(bArr3.length + 8)];
                System.arraycopy(bArr2, 0, bArr5, 0, bArr3.length);
                byte[] bArr7 = this.f6021a;
                System.arraycopy(bArr2, bArr7.length + 0, bArr4, 0, i2 - bArr7.length);
                KeyParameter keyParameter = this.f6019a;
                BlockCipher blockCipher = this.a;
                blockCipher.a(!this.f6020a, keyParameter);
                int i4 = i3 - 1;
                for (int i5 = 5; i5 >= 0; i5--) {
                    int i6 = i4;
                    while (i6 >= 1) {
                        System.arraycopy(bArr5, 0, bArr6, 0, this.f6021a.length);
                        int i7 = i6 - 1;
                        int i8 = i7 * 8;
                        System.arraycopy(bArr4, i8, bArr6, this.f6021a.length, 8);
                        int i9 = (i4 * i5) + i6;
                        int i10 = 1;
                        while (i9 != 0) {
                            int length = this.f6021a.length - i10;
                            bArr6[length] = (byte) (bArr6[length] ^ ((byte) i9));
                            i9 >>>= 8;
                            i10++;
                        }
                        blockCipher.e(0, 0, bArr6, bArr6);
                        System.arraycopy(bArr6, 0, bArr5, 0, 8);
                        System.arraycopy(bArr6, 8, bArr4, i8, 8);
                        i6 = i7;
                    }
                }
                if (Arrays.l(bArr5, this.f6021a)) {
                    return bArr4;
                }
                throw new InvalidCipherTextException("checksum failed");
            }
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    public final byte[] d(byte[] bArr, int i) {
        if (this.b) {
            int i2 = i / 8;
            if (i2 * 8 == i) {
                byte[] bArr2 = this.f6021a;
                byte[] bArr3 = new byte[(bArr2.length + i)];
                byte[] bArr4 = new byte[(bArr2.length + 8)];
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                System.arraycopy(bArr, 0, bArr3, this.f6021a.length, i);
                KeyParameter keyParameter = this.f6019a;
                BlockCipher blockCipher = this.a;
                blockCipher.a(this.f6020a, keyParameter);
                for (int i3 = 0; i3 != 6; i3++) {
                    for (int i4 = 1; i4 <= i2; i4++) {
                        System.arraycopy(bArr3, 0, bArr4, 0, this.f6021a.length);
                        int i5 = i4 * 8;
                        System.arraycopy(bArr3, i5, bArr4, this.f6021a.length, 8);
                        blockCipher.e(0, 0, bArr4, bArr4);
                        int i6 = (i2 * i3) + i4;
                        int i7 = 1;
                        while (i6 != 0) {
                            int length = this.f6021a.length - i7;
                            bArr4[length] = (byte) (((byte) i6) ^ bArr4[length]);
                            i6 >>>= 8;
                            i7++;
                        }
                        System.arraycopy(bArr4, 0, bArr3, 0, 8);
                        System.arraycopy(bArr4, 8, bArr3, i5, 8);
                    }
                }
                return bArr3;
            }
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for wrapping");
    }
}
