package org.spongycastle.crypto.encodings;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class ISO9796d1Encoding implements AsymmetricBlockCipher {
    public static final byte[] a = {Ascii.SO, 3, 5, 8, 9, 4, 2, Ascii.SI, 0, Ascii.CR, Ascii.VT, 6, 7, 10, Ascii.FF, 1};
    public static final BigInteger b = BigInteger.valueOf(16);

    /* renamed from: b  reason: collision with other field name */
    public static final byte[] f5886b = {8, Ascii.SI, 6, 1, 5, 2, Ascii.VT, Ascii.FF, 3, 4, Ascii.CR, 10, Ascii.SO, 9, 0, 7};
    public static final BigInteger c = BigInteger.valueOf(6);

    /* renamed from: a  reason: collision with other field name */
    public int f5887a;

    /* renamed from: a  reason: collision with other field name */
    public BigInteger f5888a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f5889a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5890a;

    /* renamed from: b  reason: collision with other field name */
    public int f5891b = 0;

    public ISO9796d1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f5889a = asymmetricBlockCipher;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            rSAKeyParameters = (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).f6234a;
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        }
        this.f5889a.a(z, cipherParameters);
        BigInteger bigInteger = rSAKeyParameters.a;
        this.f5888a = bigInteger;
        this.f5887a = bigInteger.bitLength();
        this.f5890a = z;
    }

    public final int b() {
        int b2 = this.f5889a.b();
        if (this.f5890a) {
            return b2;
        }
        return (b2 + 1) / 2;
    }

    public final byte[] c(int i, byte[] bArr, int i2) throws InvalidCipherTextException {
        int i3;
        int i4 = i;
        byte[] bArr2 = bArr;
        int i5 = i2;
        boolean z = this.f5890a;
        byte[] bArr3 = a;
        AsymmetricBlockCipher asymmetricBlockCipher = this.f5889a;
        if (z) {
            int i6 = this.f5887a;
            int i7 = (i6 + 7) / 8;
            byte[] bArr4 = new byte[i7];
            int i8 = this.f5891b + 1;
            int i9 = (i6 + 13) / 16;
            for (int i10 = 0; i10 < i9; i10 += i5) {
                if (i10 > i9 - i5) {
                    int i11 = i9 - i10;
                    System.arraycopy(bArr2, (i4 + i5) - i11, bArr4, i7 - i9, i11);
                } else {
                    System.arraycopy(bArr2, i4, bArr4, i7 - (i10 + i5), i5);
                }
            }
            for (int i12 = i7 - (i9 * 2); i12 != i7; i12 += 2) {
                byte b2 = bArr4[(i12 / 2) + (i7 - i9)];
                bArr4[i12] = (byte) ((bArr3[(b2 & UnsignedBytes.MAX_VALUE) >>> 4] << 4) | bArr3[b2 & Ascii.SI]);
                bArr4[i12 + 1] = b2;
            }
            int i13 = i7 - (i5 * 2);
            bArr4[i13] = (byte) (bArr4[i13] ^ i8);
            int i14 = i7 - 1;
            bArr4[i14] = (byte) ((bArr4[i14] << 4) | 6);
            int i15 = 8 - ((this.f5887a - 1) % 8);
            if (i15 != 8) {
                byte b3 = (byte) (bArr4[0] & (Constants.MAX_HOST_LENGTH >>> i15));
                bArr4[0] = b3;
                bArr4[0] = (byte) ((128 >>> i15) | b3);
                i3 = 0;
            } else {
                bArr4[0] = 0;
                bArr4[1] = (byte) (128 | bArr4[1]);
                i3 = 1;
            }
            return asymmetricBlockCipher.c(i3, bArr4, i7 - i3);
        }
        byte[] c2 = asymmetricBlockCipher.c(i4, bArr2, i5);
        int i16 = (this.f5887a + 13) / 16;
        BigInteger bigInteger = new BigInteger(1, c2);
        BigInteger bigInteger2 = b;
        BigInteger mod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = c;
        if (!mod.equals(bigInteger3)) {
            if (this.f5888a.subtract(bigInteger).mod(bigInteger2).equals(bigInteger3)) {
                bigInteger = this.f5888a.subtract(bigInteger);
            } else {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr5 = new byte[length];
            System.arraycopy(byteArray, 1, bArr5, 0, length);
            byteArray = bArr5;
        }
        if ((byteArray[byteArray.length - 1] & Ascii.SI) == 6) {
            byteArray[byteArray.length - 1] = (byte) (((byteArray[byteArray.length - 1] & UnsignedBytes.MAX_VALUE) >>> 4) | (f5886b[(byteArray[byteArray.length - 2] & UnsignedBytes.MAX_VALUE) >> 4] << 4));
            byte b4 = byteArray[1];
            byteArray[0] = (byte) (bArr3[b4 & Ascii.SI] | (bArr3[(b4 & UnsignedBytes.MAX_VALUE) >>> 4] << 4));
            byte b5 = 1;
            int i17 = 0;
            boolean z2 = false;
            for (int length2 = byteArray.length - 1; length2 >= byteArray.length - (i16 * 2); length2 -= 2) {
                byte b6 = byteArray[length2];
                int i18 = length2 - 1;
                byte b7 = ((bArr3[b6 & Ascii.SI] | (bArr3[(b6 & UnsignedBytes.MAX_VALUE) >>> 4] << 4)) ^ byteArray[i18]) & UnsignedBytes.MAX_VALUE;
                if (b7 != 0) {
                    if (!z2) {
                        b5 = b7;
                        z2 = true;
                        i17 = i18;
                    } else {
                        throw new InvalidCipherTextException("invalid tsums in block");
                    }
                }
            }
            byteArray[i17] = 0;
            int length3 = (byteArray.length - i17) / 2;
            byte[] bArr6 = new byte[length3];
            for (int i19 = 0; i19 < length3; i19++) {
                bArr6[i19] = byteArray[(i19 * 2) + i17 + 1];
            }
            this.f5891b = b5 - 1;
            return bArr6;
        }
        throw new InvalidCipherTextException("invalid forcing byte in block");
    }

    public final int d() {
        int d = this.f5889a.d();
        if (this.f5890a) {
            return (d + 1) / 2;
        }
        return d;
    }
}
