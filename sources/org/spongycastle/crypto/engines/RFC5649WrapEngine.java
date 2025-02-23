package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class RFC5649WrapEngine implements Wrapper {
    public final BlockCipher a;

    /* renamed from: a  reason: collision with other field name */
    public KeyParameter f6022a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6023a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6024a;
    public byte[] b;
    public byte[] c = null;

    public RFC5649WrapEngine(BlockCipher blockCipher) {
        byte[] bArr = {-90, 89, 89, -90};
        this.f6024a = bArr;
        this.b = bArr;
        this.a = blockCipher;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6023a = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).f6234a;
        }
        if (cipherParameters instanceof KeyParameter) {
            this.f6022a = (KeyParameter) cipherParameters;
            this.b = this.f6024a;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            this.b = bArr;
            this.f6022a = (KeyParameter) parametersWithIV.a;
            if (bArr.length != 4) {
                throw new IllegalArgumentException("IV length not equal to 4");
            }
        }
    }

    public final String b() {
        return this.a.b();
    }

    public final byte[] c(byte[] bArr, int i) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3 = bArr;
        int i2 = i;
        if (!this.f6023a) {
            int i3 = i2 / 8;
            if (i3 * 8 != i2) {
                throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
            } else if (i3 != 1) {
                byte[] bArr4 = new byte[i2];
                System.arraycopy(bArr3, 0, bArr4, 0, i2);
                byte[] bArr5 = new byte[i2];
                BlockCipher blockCipher = this.a;
                if (i3 == 2) {
                    blockCipher.a(false, this.f6022a);
                    for (int i4 = 0; i4 < i2; i4 += blockCipher.c()) {
                        blockCipher.e(i4, i4, bArr4, bArr5);
                    }
                    byte[] bArr6 = new byte[8];
                    this.c = bArr6;
                    System.arraycopy(bArr5, 0, bArr6, 0, 8);
                    byte[] bArr7 = this.c;
                    int length = i2 - bArr7.length;
                    bArr2 = new byte[length];
                    System.arraycopy(bArr5, bArr7.length, bArr2, 0, length);
                } else {
                    int i5 = i2 - 8;
                    byte[] bArr8 = new byte[i5];
                    byte[] bArr9 = new byte[8];
                    byte[] bArr10 = new byte[16];
                    System.arraycopy(bArr3, 0, bArr9, 0, 8);
                    System.arraycopy(bArr3, 8, bArr8, 0, i5);
                    blockCipher.a(false, this.f6022a);
                    int i6 = i3 - 1;
                    for (int i7 = 5; i7 >= 0; i7--) {
                        int i8 = i6;
                        while (i8 >= 1) {
                            System.arraycopy(bArr9, 0, bArr10, 0, 8);
                            int i9 = i8 - 1;
                            int i10 = i9 * 8;
                            System.arraycopy(bArr8, i10, bArr10, 8, 8);
                            int i11 = (i6 * i7) + i8;
                            int i12 = 1;
                            while (i11 != 0) {
                                int i13 = 8 - i12;
                                bArr10[i13] = (byte) (bArr10[i13] ^ ((byte) i11));
                                i11 >>>= 8;
                                i12++;
                            }
                            blockCipher.e(0, 0, bArr10, bArr10);
                            System.arraycopy(bArr10, 0, bArr9, 0, 8);
                            System.arraycopy(bArr10, 8, bArr8, i10, 8);
                            i8 = i9;
                        }
                    }
                    this.c = bArr9;
                    bArr2 = bArr8;
                }
                byte[] bArr11 = new byte[4];
                byte[] bArr12 = new byte[4];
                System.arraycopy(this.c, 0, bArr11, 0, 4);
                System.arraycopy(this.c, 4, bArr12, 0, 4);
                int a2 = Pack.a(0, bArr12);
                boolean l = Arrays.l(bArr11, this.b);
                int length2 = bArr2.length;
                if (a2 <= length2 - 8) {
                    l = false;
                }
                if (a2 > length2) {
                    l = false;
                }
                int i14 = length2 - a2;
                if (i14 >= bArr2.length) {
                    i14 = bArr2.length;
                    l = false;
                }
                byte[] bArr13 = new byte[i14];
                System.arraycopy(bArr2, bArr2.length - i14, bArr13, 0, i14);
                if (!Arrays.l(bArr13, new byte[i14])) {
                    l = false;
                }
                if (l) {
                    byte[] bArr14 = new byte[a2];
                    System.arraycopy(bArr2, 0, bArr14, 0, a2);
                    return bArr14;
                }
                throw new InvalidCipherTextException("checksum failed");
            } else {
                throw new InvalidCipherTextException("unwrap data must be at least 16 bytes");
            }
        } else {
            throw new IllegalStateException("not set for unwrapping");
        }
    }

    public final byte[] d(byte[] bArr, int i) {
        if (this.f6023a) {
            byte[] bArr2 = new byte[8];
            byte[] bArr3 = new byte[4];
            Pack.c(i, bArr3, 0);
            byte[] bArr4 = this.b;
            System.arraycopy(bArr4, 0, bArr2, 0, bArr4.length);
            System.arraycopy(bArr3, 0, bArr2, this.b.length, 4);
            byte[] bArr5 = new byte[i];
            System.arraycopy(bArr, 0, bArr5, 0, i);
            int i2 = (8 - (i % 8)) % 8;
            int i3 = i + i2;
            byte[] bArr6 = new byte[i3];
            System.arraycopy(bArr5, 0, bArr6, 0, i);
            if (i2 != 0) {
                System.arraycopy(new byte[i2], 0, bArr6, i, i2);
            }
            BlockCipher blockCipher = this.a;
            if (i3 == 8) {
                int i4 = i3 + 8;
                byte[] bArr7 = new byte[i4];
                System.arraycopy(bArr2, 0, bArr7, 0, 8);
                System.arraycopy(bArr6, 0, bArr7, 8, i3);
                blockCipher.a(true, this.f6022a);
                for (int i5 = 0; i5 < i4; i5 += blockCipher.c()) {
                    blockCipher.e(i5, i5, bArr7, bArr7);
                }
                return bArr7;
            }
            RFC3394WrapEngine rFC3394WrapEngine = new RFC3394WrapEngine(blockCipher);
            rFC3394WrapEngine.a(true, new ParametersWithIV(this.f6022a, bArr2, 0, 8));
            return rFC3394WrapEngine.d(bArr6, i3);
        }
        throw new IllegalStateException("not set for wrapping");
    }
}
