package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PGPCFBBlockCipher implements BlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6217a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6218a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6219a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f6220b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6221b;
    public final byte[] c;
    public final byte[] d;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z) {
        this.f6217a = blockCipher;
        this.f6220b = z;
        int c2 = blockCipher.c();
        this.b = c2;
        this.f6219a = new byte[c2];
        this.f6221b = new byte[c2];
        this.c = new byte[c2];
        this.d = new byte[c2];
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f6218a = z;
        boolean z2 = cipherParameters instanceof ParametersWithIV;
        BlockCipher blockCipher = this.f6217a;
        if (z2) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            int length = bArr.length;
            byte[] bArr2 = this.f6219a;
            if (length < bArr2.length) {
                System.arraycopy(bArr, 0, bArr2, bArr2.length - bArr.length, bArr.length);
                for (int i = 0; i < bArr2.length - bArr.length; i++) {
                    bArr2[i] = 0;
                }
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            }
            reset();
            blockCipher.a(true, parametersWithIV.a);
            return;
        }
        reset();
        blockCipher.a(true, cipherParameters);
    }

    public final String b() {
        boolean z = this.f6220b;
        BlockCipher blockCipher = this.f6217a;
        if (z) {
            return blockCipher.b() + "/PGPCFBwithIV";
        }
        return blockCipher.b() + "/PGPCFB";
    }

    public final int c() {
        return this.f6217a.c();
    }

    public final byte d(byte b2, int i) {
        return (byte) (b2 ^ this.c[i]);
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        byte[] bArr3;
        int i3 = i;
        int i4 = i2;
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        boolean z = this.f6220b;
        byte[] bArr6 = this.f6221b;
        byte[] bArr7 = this.c;
        BlockCipher blockCipher = this.f6217a;
        int i5 = this.b;
        int i6 = 0;
        if (!z) {
            if (this.f6218a) {
                if (i3 + i5 > bArr4.length) {
                    throw new DataLengthException("input buffer too short");
                } else if (i4 + i5 <= bArr5.length) {
                    blockCipher.e(0, 0, bArr6, bArr7);
                    for (int i7 = 0; i7 < i5; i7++) {
                        bArr5[i4 + i7] = d(bArr4[i3 + i7], i7);
                    }
                    while (i6 < i5) {
                        bArr6[i6] = bArr5[i4 + i6];
                        i6++;
                    }
                } else {
                    throw new OutputLengthException("output buffer too short");
                }
            } else if (i3 + i5 > bArr4.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i4 + i5 <= bArr5.length) {
                blockCipher.e(0, 0, bArr6, bArr7);
                for (int i8 = 0; i8 < i5; i8++) {
                    bArr5[i4 + i8] = d(bArr4[i3 + i8], i8);
                }
                while (i6 < i5) {
                    bArr6[i6] = bArr4[i3 + i6];
                    i6++;
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
            return i5;
        } else if (this.f6218a) {
            if (i3 + i5 <= bArr4.length) {
                int i9 = this.a;
                if (i9 == 0) {
                    int i10 = i5 * 2;
                    if (i10 + i4 + 2 <= bArr5.length) {
                        blockCipher.e(0, 0, bArr6, bArr7);
                        int i11 = 0;
                        while (true) {
                            bArr3 = this.f6219a;
                            if (i11 >= i5) {
                                break;
                            }
                            bArr5[i4 + i11] = d(bArr3[i11], i11);
                            i11++;
                        }
                        System.arraycopy(bArr5, i4, bArr6, 0, i5);
                        blockCipher.e(0, 0, bArr6, bArr7);
                        int i12 = i4 + i5;
                        bArr5[i12] = d(bArr3[i5 - 2], 0);
                        bArr5[i12 + 1] = d(bArr3[i5 - 1], 1);
                        System.arraycopy(bArr5, i4 + 2, bArr6, 0, i5);
                        blockCipher.e(0, 0, bArr6, bArr7);
                        for (int i13 = 0; i13 < i5; i13++) {
                            bArr5[i12 + 2 + i13] = d(bArr4[i3 + i13], i13);
                        }
                        System.arraycopy(bArr5, i12 + 2, bArr6, 0, i5);
                        int i14 = i10 + 2;
                        this.a += i14;
                        return i14;
                    }
                    throw new OutputLengthException("output buffer too short");
                } else if (i9 < i5 + 2) {
                    return i5;
                } else {
                    if (i4 + i5 <= bArr5.length) {
                        blockCipher.e(0, 0, bArr6, bArr7);
                        for (int i15 = 0; i15 < i5; i15++) {
                            bArr5[i4 + i15] = d(bArr4[i3 + i15], i15);
                        }
                        System.arraycopy(bArr5, i4, bArr6, 0, i5);
                        return i5;
                    }
                    throw new OutputLengthException("output buffer too short");
                }
            } else {
                throw new DataLengthException("input buffer too short");
            }
        } else if (i3 + i5 > bArr4.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i4 + i5 <= bArr5.length) {
            int i16 = this.a;
            if (i16 == 0) {
                for (int i17 = 0; i17 < i5; i17++) {
                    bArr6[i17] = bArr4[i3 + i17];
                }
                blockCipher.e(0, 0, bArr6, bArr7);
                this.a += i5;
                return 0;
            }
            byte[] bArr8 = this.d;
            if (i16 == i5) {
                System.arraycopy(bArr4, i3, bArr8, 0, i5);
                int i18 = i5 - 2;
                System.arraycopy(bArr6, 2, bArr6, 0, i18);
                bArr6[i18] = bArr8[0];
                bArr6[i5 - 1] = bArr8[1];
                blockCipher.e(0, 0, bArr6, bArr7);
                for (int i19 = 0; i19 < i18; i19++) {
                    bArr5[i4 + i19] = d(bArr8[i19 + 2], i19);
                }
                System.arraycopy(bArr8, 2, bArr6, 0, i18);
                this.a += 2;
                return i5 - 2;
            } else if (i16 < i5 + 2) {
                return i5;
            } else {
                System.arraycopy(bArr4, i3, bArr8, 0, i5);
                int i20 = i5 - 2;
                bArr5[i4 + 0] = d(bArr8[0], i20);
                bArr5[i4 + 1] = d(bArr8[1], i5 - 1);
                System.arraycopy(bArr8, 0, bArr6, i20, 2);
                blockCipher.e(0, 0, bArr6, bArr7);
                for (int i21 = 0; i21 < i20; i21++) {
                    bArr5[i4 + i21 + 2] = d(bArr8[i21 + 2], i21);
                }
                System.arraycopy(bArr8, 2, bArr6, 0, i20);
                return i5;
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final void reset() {
        this.a = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f6221b;
            if (i != bArr.length) {
                if (this.f6220b) {
                    bArr[i] = 0;
                } else {
                    bArr[i] = this.f6219a[i];
                }
                i++;
            } else {
                this.f6217a.reset();
                return;
            }
        }
    }
}
