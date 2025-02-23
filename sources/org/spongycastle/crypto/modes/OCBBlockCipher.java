package org.spongycastle.crypto.modes;

import com.google.common.primitives.UnsignedBytes;
import java.util.Vector;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class OCBBlockCipher implements AEADBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f6201a;

    /* renamed from: a  reason: collision with other field name */
    public Vector f6202a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6203a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6204a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6205a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f6206b;

    /* renamed from: b  reason: collision with other field name */
    public final BlockCipher f6207b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6208b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f6209c;
    public byte[] d = null;
    public final byte[] e = new byte[24];
    public final byte[] f = new byte[16];
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public final byte[] k = new byte[16];
    public byte[] l;
    public byte[] m;

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        } else if (blockCipher.c() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        } else if (blockCipher2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        } else if (blockCipher2.c() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        } else if (blockCipher.b().equals(blockCipher2.b())) {
            this.f6203a = blockCipher;
            this.f6207b = blockCipher2;
        } else {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
    }

    public static byte[] b(byte[] bArr) {
        int i2 = 16;
        byte[] bArr2 = new byte[16];
        int i3 = 0;
        while (true) {
            i2--;
            if (i2 >= 0) {
                byte b2 = bArr[i2] & UnsignedBytes.MAX_VALUE;
                bArr2[i2] = (byte) (i3 | (b2 << 1));
                i3 = (b2 >>> 7) & 1;
            } else {
                bArr2[15] = (byte) (bArr2[15] ^ (135 >>> ((1 - i3) << 3)));
                return bArr2;
            }
        }
    }

    public static void k(byte[] bArr, byte[] bArr2) {
        for (int i2 = 15; i2 >= 0; i2--) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        byte[] bArr;
        int i2;
        boolean z2 = this.f6204a;
        this.f6204a = z;
        this.m = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.b;
            this.f6205a = aEADParameters.f6227a;
            int i3 = aEADParameters.c;
            if (i3 < 64 || i3 > 128 || i3 % 8 != 0) {
                throw new IllegalArgumentException(lf.h("Invalid value for MAC size: ", i3));
            }
            this.a = i3 / 8;
            keyParameter = aEADParameters.a;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.f6233a;
            this.f6205a = null;
            this.a = 16;
            keyParameter = (KeyParameter) parametersWithIV.a;
        } else {
            throw new IllegalArgumentException("invalid parameters passed to OCB");
        }
        this.g = new byte[16];
        if (z) {
            i2 = 16;
        } else {
            i2 = this.a + 16;
        }
        this.h = new byte[i2];
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr.length <= 15) {
            BlockCipher blockCipher = this.f6203a;
            if (keyParameter != null) {
                blockCipher.a(true, keyParameter);
                this.f6207b.a(z, keyParameter);
                this.d = null;
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
            byte[] bArr2 = new byte[16];
            this.f6208b = bArr2;
            blockCipher.e(0, 0, bArr2, bArr2);
            this.f6209c = b(this.f6208b);
            Vector vector = new Vector();
            this.f6202a = vector;
            vector.addElement(b(this.f6209c));
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, 0, bArr3, 16 - bArr.length, bArr.length);
            bArr3[0] = (byte) (this.a << 4);
            int length = 15 - bArr.length;
            bArr3[length] = (byte) (bArr3[length] | 1);
            byte b2 = bArr3[15];
            byte b3 = b2 & 63;
            bArr3[15] = (byte) (b2 & 192);
            byte[] bArr4 = this.d;
            byte[] bArr5 = this.e;
            if (bArr4 == null || !Arrays.a(bArr3, bArr4)) {
                byte[] bArr6 = new byte[16];
                this.d = bArr3;
                blockCipher.e(0, 0, bArr3, bArr6);
                System.arraycopy(bArr6, 0, bArr5, 0, 16);
                int i4 = 0;
                while (i4 < 8) {
                    int i5 = i4 + 16;
                    byte b4 = bArr6[i4];
                    i4++;
                    bArr5[i5] = (byte) (b4 ^ bArr6[i4]);
                }
            }
            int i6 = b3 % 8;
            int i7 = b3 / 8;
            byte[] bArr7 = this.f;
            if (i6 == 0) {
                System.arraycopy(bArr5, i7, bArr7, 0, 16);
            } else {
                for (int i8 = 0; i8 < 16; i8++) {
                    byte b5 = bArr5[i7] & UnsignedBytes.MAX_VALUE;
                    i7++;
                    bArr7[i8] = (byte) ((b5 << i6) | ((bArr5[i7] & UnsignedBytes.MAX_VALUE) >>> (8 - i6)));
                }
            }
            this.b = 0;
            this.c = 0;
            this.f6201a = 0;
            this.f6206b = 0;
            this.i = new byte[16];
            this.j = new byte[16];
            System.arraycopy(bArr7, 0, this.k, 0, 16);
            this.l = new byte[16];
            byte[] bArr8 = this.f6205a;
            if (bArr8 != null) {
                i(0, bArr8, bArr8.length);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("IV must be no more than 15 bytes");
    }

    public final int c(int i2, byte[] bArr) throws IllegalStateException, InvalidCipherTextException {
        byte[] bArr2;
        if (!this.f6204a) {
            int i3 = this.c;
            int i4 = this.a;
            if (i3 >= i4) {
                int i5 = i3 - i4;
                this.c = i5;
                bArr2 = new byte[i4];
                System.arraycopy(this.h, i5, bArr2, 0, i4);
            } else {
                throw new InvalidCipherTextException("data too short");
            }
        } else {
            bArr2 = null;
        }
        int i6 = this.b;
        BlockCipher blockCipher = this.f6203a;
        if (i6 > 0) {
            byte[] bArr3 = this.g;
            bArr3[i6] = UnsignedBytes.MAX_POWER_OF_TWO;
            while (true) {
                i6++;
                if (i6 >= 16) {
                    break;
                }
                bArr3[i6] = 0;
            }
            k(this.i, this.f6208b);
            k(this.g, this.i);
            byte[] bArr4 = this.g;
            blockCipher.e(0, 0, bArr4, bArr4);
            k(this.j, this.g);
        }
        int i7 = this.c;
        byte[] bArr5 = this.k;
        if (i7 > 0) {
            if (this.f6204a) {
                byte[] bArr6 = this.h;
                bArr6[i7] = UnsignedBytes.MAX_POWER_OF_TWO;
                while (true) {
                    i7++;
                    if (i7 >= 16) {
                        break;
                    }
                    bArr6[i7] = 0;
                }
                k(this.l, this.h);
            }
            k(bArr5, this.f6208b);
            byte[] bArr7 = new byte[16];
            blockCipher.e(0, 0, bArr5, bArr7);
            k(this.h, bArr7);
            int length = bArr.length;
            int i8 = this.c;
            if (length >= i2 + i8) {
                System.arraycopy(this.h, 0, bArr, i2, i8);
                if (!this.f6204a) {
                    byte[] bArr8 = this.h;
                    int i9 = this.c;
                    bArr8[i9] = UnsignedBytes.MAX_POWER_OF_TWO;
                    while (true) {
                        i9++;
                        if (i9 >= 16) {
                            break;
                        }
                        bArr8[i9] = 0;
                    }
                    k(this.l, this.h);
                }
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        }
        k(this.l, bArr5);
        k(this.l, this.f6209c);
        byte[] bArr9 = this.l;
        blockCipher.e(0, 0, bArr9, bArr9);
        k(this.l, this.j);
        int i10 = this.a;
        byte[] bArr10 = new byte[i10];
        this.m = bArr10;
        System.arraycopy(this.l, 0, bArr10, 0, i10);
        int i11 = this.c;
        if (this.f6204a) {
            int length2 = bArr.length;
            int i12 = i2 + i11;
            int i13 = this.a;
            if (length2 >= i12 + i13) {
                System.arraycopy(this.m, 0, bArr, i12, i13);
                i11 += this.a;
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (!Arrays.l(this.m, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        blockCipher.reset();
        this.f6207b.reset();
        byte[] bArr11 = this.g;
        if (bArr11 != null) {
            Arrays.p(bArr11, (byte) 0);
        }
        byte[] bArr12 = this.h;
        if (bArr12 != null) {
            Arrays.p(bArr12, (byte) 0);
        }
        this.b = 0;
        this.c = 0;
        this.f6201a = 0;
        this.f6206b = 0;
        byte[] bArr13 = this.i;
        if (bArr13 != null) {
            Arrays.p(bArr13, (byte) 0);
        }
        byte[] bArr14 = this.j;
        if (bArr14 != null) {
            Arrays.p(bArr14, (byte) 0);
        }
        System.arraycopy(this.f, 0, bArr5, 0, 16);
        byte[] bArr15 = this.l;
        if (bArr15 != null) {
            Arrays.p(bArr15, (byte) 0);
        }
        byte[] bArr16 = this.f6205a;
        if (bArr16 != null) {
            i(0, bArr16, bArr16.length);
        }
        return i11;
    }

    public final int d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws DataLengthException {
        int i5;
        byte[] bArr3 = bArr;
        int i6 = i3;
        byte[] bArr4 = bArr2;
        if (bArr3.length >= i2 + i6) {
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                byte[] bArr5 = this.h;
                int i9 = this.c;
                bArr5[i9] = bArr3[i2 + i8];
                int i10 = i9 + 1;
                this.c = i10;
                if (i10 == bArr5.length) {
                    int i11 = i4 + i7;
                    if (bArr4.length >= i11 + 16) {
                        if (this.f6204a) {
                            k(this.l, bArr5);
                            this.c = 0;
                        }
                        long j2 = this.f6206b + 1;
                        this.f6206b = j2;
                        if (j2 == 0) {
                            i5 = 64;
                        } else {
                            i5 = 0;
                            while ((j2 & 1) == 0) {
                                i5++;
                                j2 >>>= 1;
                            }
                        }
                        byte[] j3 = j(i5);
                        byte[] bArr6 = this.k;
                        k(bArr6, j3);
                        k(this.h, bArr6);
                        BlockCipher blockCipher = this.f6207b;
                        byte[] bArr7 = this.h;
                        blockCipher.e(0, 0, bArr7, bArr7);
                        k(this.h, bArr6);
                        System.arraycopy(this.h, 0, bArr4, i11, 16);
                        if (!this.f6204a) {
                            k(this.l, this.h);
                            byte[] bArr8 = this.h;
                            System.arraycopy(bArr8, 16, bArr8, 0, this.a);
                            this.c = this.a;
                        }
                        i7 += 16;
                    } else {
                        throw new OutputLengthException("Output buffer too short");
                    }
                }
            }
            return i7;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public final int e(int i2) {
        int i3 = i2 + this.c;
        if (this.f6204a) {
            return i3 + this.a;
        }
        int i4 = this.a;
        if (i3 < i4) {
            return 0;
        }
        return i3 - i4;
    }

    public final int f(int i2) {
        int i3 = i2 + this.c;
        if (!this.f6204a) {
            int i4 = this.a;
            if (i3 < i4) {
                return 0;
            }
            i3 -= i4;
        }
        return i3 - (i3 % 16);
    }

    public final BlockCipher g() {
        return this.f6207b;
    }

    public final byte[] h() {
        byte[] bArr = this.m;
        if (bArr == null) {
            return new byte[this.a];
        }
        return Arrays.c(bArr);
    }

    public final void i(int i2, byte[] bArr, int i3) {
        int i4;
        for (int i5 = 0; i5 < i3; i5++) {
            byte[] bArr2 = this.g;
            int i6 = this.b;
            bArr2[i6] = bArr[i2 + i5];
            int i7 = i6 + 1;
            this.b = i7;
            if (i7 == bArr2.length) {
                long j2 = this.f6201a + 1;
                this.f6201a = j2;
                if (j2 == 0) {
                    i4 = 64;
                } else {
                    int i8 = 0;
                    while ((j2 & 1) == 0) {
                        i8++;
                        j2 >>>= 1;
                    }
                    i4 = i8;
                }
                k(this.i, j(i4));
                k(this.g, this.i);
                byte[] bArr3 = this.g;
                this.f6203a.e(0, 0, bArr3, bArr3);
                k(this.j, this.g);
                this.b = 0;
            }
        }
    }

    public final byte[] j(int i2) {
        while (i2 >= this.f6202a.size()) {
            Vector vector = this.f6202a;
            vector.addElement(b((byte[]) vector.lastElement()));
        }
        return (byte[]) this.f6202a.elementAt(i2);
    }
}
