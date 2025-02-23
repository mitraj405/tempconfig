package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.macs.CMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class EAXBlockCipher implements AEADBlockCipher {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final CMac f6150a;

    /* renamed from: a  reason: collision with other field name */
    public final SICBlockCipher f6151a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6152a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6153a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f6154b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6155b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[] f6156c;
    public byte[] d;
    public byte[] e;

    public EAXBlockCipher(BlockCipher blockCipher) {
        int c2 = blockCipher.c();
        this.a = c2;
        CMac cMac = new CMac(blockCipher);
        this.f6150a = cMac;
        this.f6156c = new byte[c2];
        int i = cMac.b;
        this.f6155b = new byte[i];
        this.f6153a = new byte[i];
        this.f6151a = new SICBlockCipher(blockCipher);
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        byte[] bArr;
        int i;
        this.f6152a = z;
        boolean z2 = cipherParameters instanceof AEADParameters;
        CMac cMac = this.f6150a;
        if (z2) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.b;
            this.e = aEADParameters.f6227a;
            this.b = aEADParameters.c / 8;
            cipherParameters2 = aEADParameters.a;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.f6233a;
            this.e = null;
            this.b = cMac.b / 2;
            cipherParameters2 = parametersWithIV.a;
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        int i2 = this.a;
        if (z) {
            i = i2;
        } else {
            i = this.b + i2;
        }
        this.d = new byte[i];
        byte[] bArr2 = new byte[i2];
        cMac.a(cipherParameters2);
        bArr2[i2 - 1] = 0;
        cMac.update(bArr2, 0, i2);
        cMac.update(bArr, 0, bArr.length);
        byte[] bArr3 = this.f6153a;
        cMac.c(0, bArr3);
        this.f6151a.a(true, new ParametersWithIV((CipherParameters) null, bArr3));
        k(true);
    }

    public final void b() {
        byte[] bArr = new byte[this.a];
        int i = 0;
        this.f6150a.c(0, bArr);
        while (true) {
            byte[] bArr2 = this.f6156c;
            if (i < bArr2.length) {
                bArr2[i] = (byte) ((this.f6153a[i] ^ this.f6155b[i]) ^ bArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final int c(int i, byte[] bArr) throws IllegalStateException, InvalidCipherTextException {
        boolean z;
        j();
        int i2 = this.c;
        byte[] bArr2 = this.d;
        byte[] bArr3 = new byte[bArr2.length];
        this.c = 0;
        boolean z2 = this.f6152a;
        CMac cMac = this.f6150a;
        byte[] bArr4 = this.f6156c;
        SICBlockCipher sICBlockCipher = this.f6151a;
        if (z2) {
            int i3 = i + i2;
            if (bArr.length >= this.b + i3) {
                sICBlockCipher.e(0, 0, bArr2, bArr3);
                System.arraycopy(bArr3, 0, bArr, i, i2);
                cMac.update(bArr3, 0, i2);
                b();
                System.arraycopy(bArr4, 0, bArr, i3, this.b);
                k(false);
                return i2 + this.b;
            }
            throw new OutputLengthException("Output buffer too short");
        }
        int i4 = this.b;
        if (i2 < i4) {
            throw new InvalidCipherTextException("data too short");
        } else if (bArr.length >= (i + i2) - i4) {
            if (i2 > i4) {
                cMac.update(bArr2, 0, i2 - i4);
                sICBlockCipher.e(0, 0, this.d, bArr3);
                System.arraycopy(bArr3, 0, bArr, i, i2 - this.b);
            }
            b();
            byte[] bArr5 = this.d;
            int i5 = i2 - this.b;
            byte b2 = 0;
            for (int i6 = 0; i6 < this.b; i6++) {
                b2 |= bArr4[i6] ^ bArr5[i5 + i6];
            }
            if (b2 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                k(false);
                return i2 - this.b;
            }
            throw new InvalidCipherTextException("mac check in EAX failed");
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        int i4;
        j();
        if (bArr.length >= i + i2) {
            int i5 = 0;
            for (int i6 = 0; i6 != i2; i6++) {
                byte b2 = bArr[i + i6];
                int i7 = i3 + i5;
                byte[] bArr3 = this.d;
                int i8 = this.c;
                int i9 = i8 + 1;
                this.c = i9;
                bArr3[i8] = b2;
                if (i9 == bArr3.length) {
                    int length = bArr2.length;
                    int i10 = this.a;
                    if (length >= i7 + i10) {
                        boolean z = this.f6152a;
                        CMac cMac = this.f6150a;
                        SICBlockCipher sICBlockCipher = this.f6151a;
                        if (z) {
                            i4 = sICBlockCipher.e(0, i7, bArr3, bArr2);
                            cMac.update(bArr2, i7, i10);
                        } else {
                            cMac.update(bArr3, 0, i10);
                            i4 = sICBlockCipher.e(0, i7, this.d, bArr2);
                        }
                        this.c = 0;
                        if (!this.f6152a) {
                            byte[] bArr4 = this.d;
                            System.arraycopy(bArr4, i10, bArr4, 0, this.b);
                            this.c = this.b;
                        }
                    } else {
                        throw new OutputLengthException("Output buffer is too short");
                    }
                } else {
                    i4 = 0;
                }
                i5 += i4;
            }
            return i5;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public final int e(int i) {
        int i2 = i + this.c;
        if (this.f6152a) {
            return i2 + this.b;
        }
        int i3 = this.b;
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    public final int f(int i) {
        int i2 = i + this.c;
        if (!this.f6152a) {
            int i3 = this.b;
            if (i2 < i3) {
                return 0;
            }
            i2 -= i3;
        }
        return i2 - (i2 % this.a);
    }

    public final BlockCipher g() {
        return this.f6151a.a;
    }

    public final byte[] h() {
        int i = this.b;
        byte[] bArr = new byte[i];
        System.arraycopy(this.f6156c, 0, bArr, 0, i);
        return bArr;
    }

    public final void i(int i, byte[] bArr, int i2) {
        if (!this.f6154b) {
            this.f6150a.update(bArr, i, i2);
            return;
        }
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    public final void j() {
        if (!this.f6154b) {
            this.f6154b = true;
            CMac cMac = this.f6150a;
            cMac.c(0, this.f6155b);
            int i = this.a;
            byte[] bArr = new byte[i];
            bArr[i - 1] = 2;
            cMac.update(bArr, 0, i);
        }
    }

    public final void k(boolean z) {
        this.f6151a.reset();
        CMac cMac = this.f6150a;
        cMac.reset();
        this.c = 0;
        Arrays.p(this.d, (byte) 0);
        if (z) {
            Arrays.p(this.f6156c, (byte) 0);
        }
        int i = this.a;
        byte[] bArr = new byte[i];
        bArr[i - 1] = 1;
        cMac.update(bArr, 0, i);
        this.f6154b = false;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            i(0, bArr2, bArr2.length);
        }
    }
}
