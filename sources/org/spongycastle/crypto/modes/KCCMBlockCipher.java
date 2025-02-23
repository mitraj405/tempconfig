package org.spongycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class KCCMBlockCipher implements AEADBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6178a;

    /* renamed from: a  reason: collision with other field name */
    public final ExposedByteArrayOutputStream f6179a = new ExposedByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6180a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6181a;
    public int b = 4;

    /* renamed from: b  reason: collision with other field name */
    public final ExposedByteArrayOutputStream f6182b = new ExposedByteArrayOutputStream();

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6183b;
    public final byte[] c;
    public byte[] d;
    public final byte[] e;
    public final byte[] f;
    public final byte[] g;
    public final byte[] h;

    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public final byte[] a() {
            return this.buf;
        }
    }

    public KCCMBlockCipher(BlockCipher blockCipher) {
        this.f6178a = blockCipher;
        this.a = blockCipher.c();
        this.d = new byte[blockCipher.c()];
        this.f6181a = new byte[blockCipher.c()];
        this.f6183b = new byte[blockCipher.c()];
        this.c = new byte[blockCipher.c()];
        this.e = new byte[blockCipher.c()];
        this.f = new byte[blockCipher.c()];
        this.g = new byte[blockCipher.c()];
        this.h = new byte[blockCipher.c()];
        this.b = 4;
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        boolean z2 = cipherParameters instanceof AEADParameters;
        BlockCipher blockCipher = this.f6178a;
        if (z2) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            int i = aEADParameters.c;
            if (i > 512 || i < 64 || i % 8 != 0) {
                throw new IllegalArgumentException("Invalid mac size specified");
            }
            this.d = aEADParameters.b;
            this.a = i / 8;
            this.f6181a = aEADParameters.f6227a;
            cipherParameters2 = aEADParameters.a;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.d = parametersWithIV.f6233a;
            this.a = blockCipher.c();
            this.f6181a = null;
            cipherParameters2 = parametersWithIV.a;
        } else {
            throw new IllegalArgumentException("Invalid parameters specified");
        }
        this.f6183b = new byte[this.a];
        this.f6180a = z;
        blockCipher.a(true, cipherParameters2);
        this.h[0] = 1;
        byte[] bArr = this.f6181a;
        if (bArr != null) {
            i(0, bArr, bArr.length);
        }
    }

    public final void b(byte[] bArr, int i) {
        BlockCipher blockCipher;
        byte[] bArr2;
        int i2 = 0;
        while (i > 0) {
            int i3 = 0;
            while (true) {
                blockCipher = this.f6178a;
                int c2 = blockCipher.c();
                bArr2 = this.c;
                if (i3 >= c2) {
                    break;
                }
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[i2 + i3]);
                i3++;
            }
            blockCipher.e(0, 0, bArr2, bArr2);
            i -= blockCipher.c();
            i2 += blockCipher.c();
        }
    }

    public final int c(int i, byte[] bArr) throws IllegalStateException, InvalidCipherTextException {
        int i2;
        int i3;
        int i4;
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = this.f6182b;
        byte[] a2 = exposedByteArrayOutputStream.a();
        int size = exposedByteArrayOutputStream.size();
        if (a2.length - 0 < size) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr.length - i >= size) {
            ExposedByteArrayOutputStream exposedByteArrayOutputStream2 = this.f6179a;
            if (exposedByteArrayOutputStream2.size() > 0) {
                if (this.f6180a) {
                    k(exposedByteArrayOutputStream2.size(), exposedByteArrayOutputStream2.a(), exposedByteArrayOutputStream.size());
                } else {
                    k(exposedByteArrayOutputStream2.size(), exposedByteArrayOutputStream2.a(), exposedByteArrayOutputStream.size() - this.a);
                }
            }
            boolean z = this.f6180a;
            byte[] bArr2 = this.c;
            byte[] bArr3 = this.h;
            byte[] bArr4 = this.f;
            byte[] bArr5 = this.g;
            BlockCipher blockCipher = this.f6178a;
            if (z) {
                if (size % blockCipher.c() == 0) {
                    b(a2, size);
                    blockCipher.e(0, 0, this.d, bArr5);
                    int i5 = size;
                    int i6 = 0;
                    while (i5 > 0) {
                        j(a2, i6, bArr, i);
                        i5 -= blockCipher.c();
                        i6 += blockCipher.c();
                        i += blockCipher.c();
                    }
                    for (int i7 = 0; i7 < bArr3.length; i7++) {
                        bArr5[i7] = (byte) (bArr5[i7] + bArr3[i7]);
                    }
                    blockCipher.e(0, 0, bArr5, bArr4);
                    int i8 = 0;
                    while (true) {
                        i4 = this.a;
                        if (i8 >= i4) {
                            break;
                        }
                        bArr[i + i8] = (byte) (bArr4[i8] ^ bArr2[i8]);
                        i8++;
                    }
                    System.arraycopy(bArr2, 0, this.f6183b, 0, i4);
                    l();
                    i2 = this.a + size;
                } else {
                    throw new DataLengthException("partial blocks not supported");
                }
            } else if ((size - this.a) % blockCipher.c() == 0) {
                blockCipher.e(0, 0, this.d, bArr5);
                int c2 = size / blockCipher.c();
                int i9 = 0;
                for (int i10 = 0; i10 < c2; i10++) {
                    j(a2, i9, bArr, i);
                    i9 += blockCipher.c();
                    i += blockCipher.c();
                }
                if (size > i9) {
                    for (int i11 = 0; i11 < bArr3.length; i11++) {
                        bArr5[i11] = (byte) (bArr5[i11] + bArr3[i11]);
                    }
                    blockCipher.e(0, 0, bArr5, bArr4);
                    int i12 = 0;
                    while (true) {
                        i3 = this.a;
                        if (i12 >= i3) {
                            break;
                        }
                        bArr[i + i12] = (byte) (bArr4[i12] ^ a2[i9 + i12]);
                        i12++;
                    }
                    i += i3;
                }
                for (int i13 = 0; i13 < bArr3.length; i13++) {
                    bArr5[i13] = (byte) (bArr5[i13] + bArr3[i13]);
                }
                blockCipher.e(0, 0, bArr5, bArr4);
                int i14 = this.a;
                System.arraycopy(bArr, i - i14, bArr4, 0, i14);
                b(bArr, i - this.a);
                System.arraycopy(bArr2, 0, this.f6183b, 0, this.a);
                int i15 = this.a;
                byte[] bArr6 = new byte[i15];
                System.arraycopy(bArr4, 0, bArr6, 0, i15);
                if (Arrays.l(this.f6183b, bArr6)) {
                    l();
                    i2 = size - this.a;
                } else {
                    throw new InvalidCipherTextException("mac check failed");
                }
            } else {
                throw new DataLengthException("partial blocks not supported");
            }
            l();
            return i2;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i + i2) {
            this.f6182b.write(bArr, i, i2);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    public final int e(int i) {
        return i + this.a;
    }

    public final BlockCipher g() {
        return this.f6178a;
    }

    public final byte[] h() {
        return Arrays.c(this.f6183b);
    }

    public final void i(int i, byte[] bArr, int i2) {
        this.f6179a.write(bArr, i, i2);
    }

    public final void j(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3;
        int i3 = 0;
        while (true) {
            byte[] bArr4 = this.h;
            int length = bArr4.length;
            bArr3 = this.g;
            if (i3 >= length) {
                break;
            }
            bArr3[i3] = (byte) (bArr3[i3] + bArr4[i3]);
            i3++;
        }
        BlockCipher blockCipher = this.f6178a;
        byte[] bArr5 = this.f;
        blockCipher.e(0, 0, bArr3, bArr5);
        for (int i4 = 0; i4 < blockCipher.c(); i4++) {
            bArr2[i2 + i4] = (byte) (bArr5[i4] ^ bArr[i + i4]);
        }
    }

    public final void k(int i, byte[] bArr, int i2) {
        int i3 = i + 0;
        BlockCipher blockCipher = this.f6178a;
        if (i3 < blockCipher.c()) {
            throw new IllegalArgumentException("authText buffer too short");
        } else if (i % blockCipher.c() == 0) {
            byte[] bArr2 = this.d;
            byte[] bArr3 = this.e;
            System.arraycopy(bArr2, 0, bArr3, 0, (bArr2.length - this.b) - 1);
            byte[] bArr4 = this.f;
            bArr4[3] = (byte) (i2 >> 24);
            bArr4[2] = (byte) (i2 >> 16);
            bArr4[1] = (byte) (i2 >> 8);
            bArr4[0] = (byte) i2;
            System.arraycopy(bArr4, 0, bArr3, (this.d.length - this.b) - 1, 4);
            int length = bArr3.length - 1;
            int i4 = this.a;
            StringBuffer stringBuffer = new StringBuffer(C0515Ga.AVLBLTY_ONLY);
            if (i4 == 8) {
                stringBuffer.append("010");
            } else if (i4 == 16) {
                stringBuffer.append("011");
            } else if (i4 == 32) {
                stringBuffer.append("100");
            } else if (i4 == 48) {
                stringBuffer.append("101");
            } else if (i4 == 64) {
                stringBuffer.append("110");
            }
            String binaryString = Integer.toBinaryString(this.b - 1);
            while (binaryString.length() < 4) {
                binaryString = new StringBuffer(binaryString).insert(0, "0").toString();
            }
            stringBuffer.append(binaryString);
            bArr3[length] = (byte) Integer.parseInt(stringBuffer.toString(), 2);
            byte[] bArr5 = this.c;
            blockCipher.e(0, 0, bArr3, bArr5);
            bArr4[3] = (byte) (i >> 24);
            bArr4[2] = (byte) (i >> 16);
            bArr4[1] = (byte) (i >> 8);
            bArr4[0] = (byte) i;
            if (i <= blockCipher.c() - this.b) {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = this.b + i5;
                    bArr4[i6] = (byte) (bArr4[i6] ^ bArr[0 + i5]);
                }
                for (int i7 = 0; i7 < blockCipher.c(); i7++) {
                    bArr5[i7] = (byte) (bArr5[i7] ^ bArr4[i7]);
                }
                blockCipher.e(0, 0, bArr5, bArr5);
                return;
            }
            for (int i8 = 0; i8 < blockCipher.c(); i8++) {
                bArr5[i8] = (byte) (bArr5[i8] ^ bArr4[i8]);
            }
            blockCipher.e(0, 0, bArr5, bArr5);
            int i9 = 0;
            while (i != 0) {
                for (int i10 = 0; i10 < blockCipher.c(); i10++) {
                    bArr5[i10] = (byte) (bArr5[i10] ^ bArr[i10 + i9]);
                }
                blockCipher.e(0, 0, bArr5, bArr5);
                i9 += blockCipher.c();
                i -= blockCipher.c();
            }
        } else {
            throw new IllegalArgumentException("padding not supported");
        }
    }

    public final void l() {
        Arrays.p(this.e, (byte) 0);
        Arrays.p(this.f, (byte) 0);
        byte[] bArr = this.h;
        Arrays.p(bArr, (byte) 0);
        Arrays.p(this.c, (byte) 0);
        bArr[0] = 1;
        this.f6182b.reset();
        this.f6179a.reset();
        byte[] bArr2 = this.f6181a;
        if (bArr2 != null) {
            i(0, bArr2, bArr2.length);
        }
    }

    public final int f(int i) {
        return i;
    }
}
