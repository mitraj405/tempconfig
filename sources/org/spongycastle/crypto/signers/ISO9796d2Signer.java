package org.spongycastle.crypto.signers;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.SignerWithRecovery;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class ISO9796d2Signer implements SignerWithRecovery {
    public final int a = 188;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f6280a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6281a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6282a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6283b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f6284c;

    public ISO9796d2Signer(RSABlindedEngine rSABlindedEngine, Digest digest) {
        this.f6280a = rSABlindedEngine;
        this.f6281a = digest;
    }

    public final void a(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public final byte[] b() throws CryptoException {
        int i;
        int i2;
        int i3;
        int i4;
        Digest digest = this.f6281a;
        int f = digest.f();
        int i5 = this.a;
        if (i5 == 188) {
            byte[] bArr = this.f6282a;
            i = (bArr.length - f) - 1;
            digest.c(i, bArr);
            byte[] bArr2 = this.f6282a;
            bArr2[bArr2.length - 1] = -68;
            i2 = 8;
        } else {
            byte[] bArr3 = this.f6282a;
            int length = (bArr3.length - f) - 2;
            digest.c(length, bArr3);
            byte[] bArr4 = this.f6282a;
            bArr4[bArr4.length - 2] = (byte) (i5 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i5;
            i2 = 16;
            i = length;
        }
        int i6 = this.c;
        int i7 = ((((f + i6) * 8) + i2) + 4) - this.b;
        if (i7 > 0) {
            int i8 = i6 - ((i7 + 7) / 8);
            i3 = i - i8;
            System.arraycopy(this.f6283b, 0, this.f6282a, i3, i8);
            this.f6284c = new byte[i8];
            i4 = 96;
        } else {
            i3 = i - i6;
            System.arraycopy(this.f6283b, 0, this.f6282a, i3, i6);
            this.f6284c = new byte[this.c];
            i4 = 64;
        }
        int i9 = i3 - 1;
        if (i9 > 0) {
            for (int i10 = i9; i10 != 0; i10--) {
                this.f6282a[i10] = -69;
            }
            byte[] bArr5 = this.f6282a;
            bArr5[i9] = (byte) (bArr5[i9] ^ 1);
            bArr5[0] = Ascii.VT;
            bArr5[0] = (byte) (i4 | 11);
        } else {
            byte[] bArr6 = this.f6282a;
            bArr6[0] = 10;
            bArr6[0] = (byte) (i4 | 10);
        }
        byte[] bArr7 = this.f6282a;
        byte[] c2 = this.f6280a.c(0, bArr7, bArr7.length);
        byte[] bArr8 = this.f6283b;
        byte[] bArr9 = this.f6284c;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.c = 0;
        a(this.f6283b);
        a(this.f6282a);
        return c2;
    }

    public final void c(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f6280a.a(z, rSAKeyParameters);
        int bitLength = rSAKeyParameters.a.bitLength();
        this.b = bitLength;
        int i = (bitLength + 7) / 8;
        this.f6282a = new byte[i];
        int i2 = this.a;
        Digest digest = this.f6281a;
        if (i2 == 188) {
            this.f6283b = new byte[((i - digest.f()) - 2)];
        } else {
            this.f6283b = new byte[((i - digest.f()) - 3)];
        }
        digest.reset();
        this.c = 0;
        a(this.f6283b);
        byte[] bArr = this.f6284c;
        if (bArr != null) {
            a(bArr);
        }
        this.f6284c = null;
    }

    public final void d(byte[] bArr) {
        this.c = 0;
        a(this.f6283b);
        a(bArr);
    }

    public final void e(byte[] bArr, int i, int i2) {
        Digest digest;
        while (true) {
            digest = this.f6281a;
            if (i2 <= 0 || this.c >= this.f6283b.length) {
                digest.update(bArr, i, i2);
                this.c += i2;
            } else {
                byte b2 = bArr[i];
                digest.d(b2);
                int i3 = this.c;
                byte[] bArr2 = this.f6283b;
                if (i3 < bArr2.length) {
                    bArr2[i3] = b2;
                }
                this.c = i3 + 1;
                i++;
                i2--;
            }
        }
        digest.update(bArr, i, i2);
        this.c += i2;
    }

    public final boolean f(byte[] bArr) {
        int i;
        boolean z;
        boolean z2;
        try {
            byte[] c2 = this.f6280a.c(0, bArr, bArr.length);
            if (((c2[0] & 192) ^ SignedBytes.MAX_POWER_OF_TWO) != 0) {
                d(c2);
                return false;
            } else if (((c2[c2.length - 1] & Ascii.SI) ^ Ascii.FF) != 0) {
                d(c2);
                return false;
            } else {
                byte b2 = (c2[c2.length - 1] & UnsignedBytes.MAX_VALUE) ^ 188;
                Digest digest = this.f6281a;
                if (b2 == 0) {
                    i = 1;
                } else {
                    i = 2;
                    byte b3 = ((c2[c2.length - 2] & UnsignedBytes.MAX_VALUE) << 8) | (c2[c2.length - 1] & UnsignedBytes.MAX_VALUE);
                    Integer num = ISOTrailers.a.get(digest.b());
                    if (num == null) {
                        throw new IllegalArgumentException("unrecognised hash in signature");
                    } else if (b3 != num.intValue()) {
                        throw new IllegalStateException(lf.h("signer initialised with wrong digest for trailer ", b3));
                    }
                }
                int i2 = 0;
                while (i2 != c2.length && ((c2[i2] & Ascii.SI) ^ 10) != 0) {
                    i2++;
                }
                int i3 = i2 + 1;
                int f = digest.f();
                byte[] bArr2 = new byte[f];
                int length = (c2.length - i) - f;
                int i4 = length - i3;
                if (i4 <= 0) {
                    d(c2);
                    return false;
                }
                if ((c2[0] & 32) != 0) {
                    digest.c(0, bArr2);
                    boolean z3 = true;
                    for (int i5 = 0; i5 != f; i5++) {
                        int i6 = length + i5;
                        byte b4 = (byte) (c2[i6] ^ bArr2[i5]);
                        c2[i6] = b4;
                        if (b4 != 0) {
                            z3 = false;
                        }
                    }
                    if (!z3) {
                        d(c2);
                        return false;
                    }
                    byte[] bArr3 = new byte[i4];
                    this.f6284c = bArr3;
                    System.arraycopy(c2, i3, bArr3, 0, i4);
                } else if (this.c > i4) {
                    d(c2);
                    return false;
                } else {
                    digest.reset();
                    digest.update(c2, i3, i4);
                    digest.c(0, bArr2);
                    boolean z4 = true;
                    for (int i7 = 0; i7 != f; i7++) {
                        int i8 = length + i7;
                        byte b5 = (byte) (c2[i8] ^ bArr2[i7]);
                        c2[i8] = b5;
                        if (b5 != 0) {
                            z4 = false;
                        }
                    }
                    if (!z4) {
                        d(c2);
                        return false;
                    }
                    byte[] bArr4 = new byte[i4];
                    this.f6284c = bArr4;
                    System.arraycopy(c2, i3, bArr4, 0, i4);
                }
                int i9 = this.c;
                if (i9 != 0) {
                    byte[] bArr5 = this.f6283b;
                    byte[] bArr6 = this.f6284c;
                    if (i9 > bArr5.length) {
                        if (bArr5.length > bArr6.length) {
                            z = false;
                        } else {
                            z = true;
                        }
                        for (int i10 = 0; i10 != this.f6283b.length; i10++) {
                            if (bArr5[i10] != bArr6[i10]) {
                                z = false;
                            }
                        }
                    } else {
                        if (i9 != bArr6.length) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        for (int i11 = 0; i11 != bArr6.length; i11++) {
                            if (bArr5[i11] != bArr6[i11]) {
                                z = false;
                            }
                        }
                    }
                    if (!z) {
                        d(c2);
                        return false;
                    }
                }
                a(this.f6283b);
                a(c2);
                this.c = 0;
                return true;
            }
        } catch (Exception unused) {
            return false;
        }
    }
}
