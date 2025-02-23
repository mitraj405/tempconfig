package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;

public class OpenPGPCFBBlockCipher implements BlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6213a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6214a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6215a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6216b;
    public final byte[] c;

    public OpenPGPCFBBlockCipher(BlockCipher blockCipher) {
        this.f6213a = blockCipher;
        int c2 = blockCipher.c();
        this.b = c2;
        this.f6215a = new byte[c2];
        this.f6216b = new byte[c2];
        this.c = new byte[c2];
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f6214a = z;
        reset();
        this.f6213a.a(true, cipherParameters);
    }

    public final String b() {
        return this.f6213a.b() + "/OpenPGPCFB";
    }

    public final int c() {
        return this.f6213a.c();
    }

    public final byte d(byte b2, int i) {
        return (byte) (b2 ^ this.c[i]);
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        boolean z = this.f6214a;
        int i3 = 0;
        byte[] bArr3 = this.f6216b;
        int i4 = 2;
        BlockCipher blockCipher = this.f6213a;
        byte[] bArr4 = this.c;
        int i5 = this.b;
        if (z) {
            if (i + i5 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i2 + i5 <= bArr2.length) {
                int i6 = this.a;
                if (i6 > i5) {
                    int i7 = i5 - 2;
                    byte d = d(bArr[i], i7);
                    bArr2[i2] = d;
                    bArr3[i7] = d;
                    int i8 = i5 - 1;
                    byte d2 = d(bArr[i + 1], i8);
                    bArr2[i2 + 1] = d2;
                    bArr3[i8] = d2;
                    blockCipher.e(0, 0, bArr3, bArr4);
                    while (i4 < i5) {
                        int i9 = i4 - 2;
                        byte d3 = d(bArr[i + i4], i9);
                        bArr2[i2 + i4] = d3;
                        bArr3[i9] = d3;
                        i4++;
                    }
                } else if (i6 == 0) {
                    blockCipher.e(0, 0, bArr3, bArr4);
                    while (i3 < i5) {
                        byte d4 = d(bArr[i + i3], i3);
                        bArr2[i2 + i3] = d4;
                        bArr3[i3] = d4;
                        i3++;
                    }
                    this.a += i5;
                } else if (i6 == i5) {
                    blockCipher.e(0, 0, bArr3, bArr4);
                    bArr2[i2] = d(bArr[i], 0);
                    bArr2[i2 + 1] = d(bArr[i + 1], 1);
                    int i10 = i5 - 2;
                    System.arraycopy(bArr3, 2, bArr3, 0, i10);
                    System.arraycopy(bArr2, i2, bArr3, i10, 2);
                    blockCipher.e(0, 0, bArr3, bArr4);
                    while (i4 < i5) {
                        int i11 = i4 - 2;
                        byte d5 = d(bArr[i + i4], i11);
                        bArr2[i2 + i4] = d5;
                        bArr3[i11] = d5;
                        i4++;
                    }
                    this.a += i5;
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else if (i + i5 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + i5 <= bArr2.length) {
            int i12 = this.a;
            if (i12 > i5) {
                byte b2 = bArr[i];
                int i13 = i5 - 2;
                bArr3[i13] = b2;
                bArr2[i2] = d(b2, i13);
                byte b3 = bArr[i + 1];
                int i14 = i5 - 1;
                bArr3[i14] = b3;
                bArr2[i2 + 1] = d(b3, i14);
                blockCipher.e(0, 0, bArr3, bArr4);
                while (i4 < i5) {
                    byte b4 = bArr[i + i4];
                    int i15 = i4 - 2;
                    bArr3[i15] = b4;
                    bArr2[i2 + i4] = d(b4, i15);
                    i4++;
                }
            } else if (i12 == 0) {
                blockCipher.e(0, 0, bArr3, bArr4);
                while (i3 < i5) {
                    int i16 = i + i3;
                    bArr3[i3] = bArr[i16];
                    bArr2[i3] = d(bArr[i16], i3);
                    i3++;
                }
                this.a += i5;
            } else if (i12 == i5) {
                blockCipher.e(0, 0, bArr3, bArr4);
                byte b5 = bArr[i];
                byte b6 = bArr[i + 1];
                bArr2[i2] = d(b5, 0);
                bArr2[i2 + 1] = d(b6, 1);
                int i17 = i5 - 2;
                System.arraycopy(bArr3, 2, bArr3, 0, i17);
                bArr3[i17] = b5;
                bArr3[i5 - 1] = b6;
                blockCipher.e(0, 0, bArr3, bArr4);
                while (i4 < i5) {
                    byte b7 = bArr[i + i4];
                    int i18 = i4 - 2;
                    bArr3[i18] = b7;
                    bArr2[i2 + i4] = d(b7, i18);
                    i4++;
                }
                this.a += i5;
            }
        } else {
            throw new OutputLengthException("output buffer too short");
        }
        return i5;
    }

    public final void reset() {
        this.a = 0;
        byte[] bArr = this.f6216b;
        System.arraycopy(this.f6215a, 0, bArr, 0, bArr.length);
        this.f6213a.reset();
    }
}
