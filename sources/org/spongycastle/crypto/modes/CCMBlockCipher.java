package org.spongycastle.crypto.modes;

import com.google.common.primitives.SignedBytes;
import com.google.firebase.perf.util.Constants;
import java.io.ByteArrayOutputStream;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CBCBlockCipherMac;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CCMBlockCipher implements AEADBlockCipher {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6139a;

    /* renamed from: a  reason: collision with other field name */
    public CipherParameters f6140a;

    /* renamed from: a  reason: collision with other field name */
    public final ExposedByteArrayOutputStream f6141a = new ExposedByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6142a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6143a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final ExposedByteArrayOutputStream f6144b = new ExposedByteArrayOutputStream();

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6145b;
    public final byte[] c;

    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public final byte[] a() {
            return this.buf;
        }
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.f6139a = blockCipher;
        int c2 = blockCipher.c();
        this.a = c2;
        this.c = new byte[c2];
        if (c2 != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        this.f6142a = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.f6143a = aEADParameters.b;
            this.f6145b = aEADParameters.f6227a;
            this.b = aEADParameters.c / 8;
            cipherParameters2 = aEADParameters.a;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f6143a = parametersWithIV.f6233a;
            this.f6145b = null;
            this.b = this.c.length / 2;
            cipherParameters2 = parametersWithIV.a;
        } else {
            throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameters passed to CCM: "));
        }
        if (cipherParameters2 != null) {
            this.f6140a = cipherParameters2;
        }
        byte[] bArr = this.f6143a;
        if (bArr == null || bArr.length < 7 || bArr.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        this.f6139a.reset();
        this.f6141a.reset();
        this.f6144b.reset();
    }

    public final void b(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.f6139a, this.b * 8, (ISO7816d4Padding) null);
        cBCBlockCipherMac.a(this.f6140a);
        byte[] bArr3 = new byte[16];
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = this.f6141a;
        int size = exposedByteArrayOutputStream.size();
        byte[] bArr4 = this.f6145b;
        if (bArr4 == null) {
            i3 = 0;
        } else {
            i3 = bArr4.length;
        }
        int i6 = size + i3;
        boolean z2 = true;
        if (i6 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            bArr3[0] = (byte) (bArr3[0] | SignedBytes.MAX_POWER_OF_TWO);
        }
        int i7 = 2;
        byte b2 = (byte) (bArr3[0] | ((((cBCBlockCipherMac.b - 2) / 2) & 7) << 3));
        bArr3[0] = b2;
        byte[] bArr5 = this.f6143a;
        bArr3[0] = (byte) (b2 | (((15 - bArr5.length) - 1) & 7));
        System.arraycopy(bArr5, 0, bArr3, 1, bArr5.length);
        int i8 = i2;
        int i9 = 1;
        while (i8 > 0) {
            bArr3[16 - i9] = (byte) (i8 & Constants.MAX_HOST_LENGTH);
            i8 >>>= 8;
            i9++;
        }
        cBCBlockCipherMac.update(bArr3, 0, 16);
        int size2 = exposedByteArrayOutputStream.size();
        byte[] bArr6 = this.f6145b;
        if (bArr6 == null) {
            i4 = 0;
        } else {
            i4 = bArr6.length;
        }
        if (size2 + i4 <= 0) {
            z2 = false;
        }
        if (z2) {
            int size3 = exposedByteArrayOutputStream.size();
            byte[] bArr7 = this.f6145b;
            if (bArr7 == null) {
                i5 = 0;
            } else {
                i5 = bArr7.length;
            }
            int i10 = size3 + i5;
            if (i10 < 65280) {
                cBCBlockCipherMac.d((byte) (i10 >> 8));
                cBCBlockCipherMac.d((byte) i10);
            } else {
                cBCBlockCipherMac.d((byte) -1);
                cBCBlockCipherMac.d((byte) -2);
                cBCBlockCipherMac.d((byte) (i10 >> 24));
                cBCBlockCipherMac.d((byte) (i10 >> 16));
                cBCBlockCipherMac.d((byte) (i10 >> 8));
                cBCBlockCipherMac.d((byte) i10);
                i7 = 6;
            }
            byte[] bArr8 = this.f6145b;
            if (bArr8 != null) {
                cBCBlockCipherMac.update(bArr8, 0, bArr8.length);
            }
            if (exposedByteArrayOutputStream.size() > 0) {
                cBCBlockCipherMac.update(exposedByteArrayOutputStream.a(), 0, exposedByteArrayOutputStream.size());
            }
            int i11 = (i7 + i10) % 16;
            if (i11 != 0) {
                while (i11 != 16) {
                    cBCBlockCipherMac.d((byte) 0);
                    i11++;
                }
            }
        }
        cBCBlockCipherMac.update(bArr, i, i2);
        cBCBlockCipherMac.c(0, bArr2);
    }

    public final int c(int i, byte[] bArr) throws IllegalStateException, InvalidCipherTextException {
        int i2;
        int i3;
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = this.f6144b;
        byte[] a2 = exposedByteArrayOutputStream.a();
        int size = exposedByteArrayOutputStream.size();
        if (this.f6140a != null) {
            byte[] bArr2 = this.f6143a;
            int length = 15 - bArr2.length;
            if (length >= 4 || size < (1 << (length * 8))) {
                int i4 = this.a;
                byte[] bArr3 = new byte[i4];
                bArr3[0] = (byte) ((length - 1) & 7);
                System.arraycopy(bArr2, 0, bArr3, 1, bArr2.length);
                BlockCipher blockCipher = this.f6139a;
                SICBlockCipher sICBlockCipher = new SICBlockCipher(blockCipher);
                sICBlockCipher.a(this.f6142a, new ParametersWithIV(this.f6140a, bArr3, 0, i4));
                boolean z = this.f6142a;
                byte[] bArr4 = this.c;
                if (z) {
                    i2 = this.b + size;
                    if (bArr.length >= i2 + i) {
                        b(0, size, a2, bArr4);
                        byte[] bArr5 = new byte[i4];
                        sICBlockCipher.e(0, 0, bArr4, bArr5);
                        int i5 = i;
                        int i6 = 0;
                        while (true) {
                            i3 = 0 + size;
                            if (i6 >= i3 - i4) {
                                break;
                            }
                            sICBlockCipher.e(i6, i5, a2, bArr);
                            i5 += i4;
                            i6 += i4;
                        }
                        byte[] bArr6 = new byte[i4];
                        int i7 = i3 - i6;
                        System.arraycopy(a2, i6, bArr6, 0, i7);
                        sICBlockCipher.e(0, 0, bArr6, bArr6);
                        System.arraycopy(bArr6, 0, bArr, i5, i7);
                        System.arraycopy(bArr5, 0, bArr, i + size, this.b);
                    } else {
                        throw new OutputLengthException("Output buffer too short.");
                    }
                } else {
                    int i8 = this.b;
                    if (size >= i8) {
                        int i9 = size - i8;
                        if (bArr.length >= i9 + i) {
                            int i10 = i9 + 0;
                            System.arraycopy(a2, i10, bArr4, 0, i8);
                            sICBlockCipher.e(0, 0, bArr4, bArr4);
                            for (int i11 = this.b; i11 != bArr4.length; i11++) {
                                bArr4[i11] = 0;
                            }
                            int i12 = i;
                            int i13 = 0;
                            while (i13 < i10 - i4) {
                                sICBlockCipher.e(i13, i12, a2, bArr);
                                i12 += i4;
                                i13 += i4;
                            }
                            byte[] bArr7 = new byte[i4];
                            int i14 = i9 - (i13 + 0);
                            System.arraycopy(a2, i13, bArr7, 0, i14);
                            sICBlockCipher.e(0, 0, bArr7, bArr7);
                            System.arraycopy(bArr7, 0, bArr, i12, i14);
                            byte[] bArr8 = new byte[i4];
                            b(i, i9, bArr, bArr8);
                            if (Arrays.l(bArr4, bArr8)) {
                                i2 = i9;
                            } else {
                                throw new InvalidCipherTextException("mac check in CCM failed");
                            }
                        } else {
                            throw new OutputLengthException("Output buffer too short.");
                        }
                    } else {
                        throw new InvalidCipherTextException("data too short");
                    }
                }
                blockCipher.reset();
                this.f6141a.reset();
                exposedByteArrayOutputStream.reset();
                return i2;
            }
            throw new IllegalStateException("CCM packet too large for choice of q.");
        }
        throw new IllegalStateException("CCM cipher unitialized.");
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i + i2) {
            this.f6144b.write(bArr, i, i2);
            return 0;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public final int e(int i) {
        int size = this.f6144b.size() + i;
        if (this.f6142a) {
            return size + this.b;
        }
        int i2 = this.b;
        if (size < i2) {
            return 0;
        }
        return size - i2;
    }

    public final int f(int i) {
        return 0;
    }

    public final BlockCipher g() {
        return this.f6139a;
    }

    public final byte[] h() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.c, 0, bArr, 0, i);
        return bArr;
    }

    public final void i(int i, byte[] bArr, int i2) {
        this.f6141a.write(bArr, i, i2);
    }
}
