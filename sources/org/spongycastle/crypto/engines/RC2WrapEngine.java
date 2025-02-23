package org.spongycastle.crypto.engines;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class RC2WrapEngine implements Wrapper {
    public static final byte[] c = {74, -35, -94, 44, 121, -24, 33, 5};
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public CipherParameters f6003a;

    /* renamed from: a  reason: collision with other field name */
    public final SHA1Digest f6004a = new SHA1Digest();

    /* renamed from: a  reason: collision with other field name */
    public CBCBlockCipher f6005a;

    /* renamed from: a  reason: collision with other field name */
    public ParametersWithIV f6006a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6007a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6008a;
    public final byte[] b = new byte[20];

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6007a = z;
        this.f6005a = new CBCBlockCipher(new RC2Engine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.a;
            cipherParameters = parametersWithRandom.f6234a;
        } else {
            this.a = new SecureRandom();
        }
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f6006a = parametersWithIV;
            byte[] bArr = parametersWithIV.f6233a;
            this.f6008a = bArr;
            this.f6003a = parametersWithIV.a;
            if (!this.f6007a) {
                throw new IllegalArgumentException("You should not supply an IV for unwrapping");
            } else if (bArr == null || bArr.length != 8) {
                throw new IllegalArgumentException("IV is not 8 octets");
            }
        } else {
            this.f6003a = cipherParameters;
            if (this.f6007a) {
                byte[] bArr2 = new byte[8];
                this.f6008a = bArr2;
                this.a.nextBytes(bArr2);
                this.f6006a = new ParametersWithIV(this.f6003a, this.f6008a);
            }
        }
    }

    public final String b() {
        return "RC2";
    }

    public final byte[] c(byte[] bArr, int i) throws InvalidCipherTextException {
        if (this.f6007a) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        } else if (i % this.f6005a.c() == 0) {
            this.f6005a.a(false, new ParametersWithIV(this.f6003a, c, 0, 8));
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            for (int i2 = 0; i2 < i / this.f6005a.c(); i2++) {
                int c2 = this.f6005a.c() * i2;
                this.f6005a.e(c2, c2, bArr2, bArr2);
            }
            byte[] bArr3 = new byte[i];
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                bArr3[i3] = bArr2[i - i4];
                i3 = i4;
            }
            byte[] bArr4 = new byte[8];
            this.f6008a = bArr4;
            int i5 = i - 8;
            byte[] bArr5 = new byte[i5];
            System.arraycopy(bArr3, 0, bArr4, 0, 8);
            System.arraycopy(bArr3, 8, bArr5, 0, i5);
            ParametersWithIV parametersWithIV = new ParametersWithIV(this.f6003a, this.f6008a);
            this.f6006a = parametersWithIV;
            this.f6005a.a(false, parametersWithIV);
            byte[] bArr6 = new byte[i5];
            System.arraycopy(bArr5, 0, bArr6, 0, i5);
            for (int i6 = 0; i6 < i5 / this.f6005a.c(); i6++) {
                int c3 = this.f6005a.c() * i6;
                this.f6005a.e(c3, c3, bArr6, bArr6);
            }
            int i7 = i5 - 8;
            byte[] bArr7 = new byte[i7];
            byte[] bArr8 = new byte[8];
            System.arraycopy(bArr6, 0, bArr7, 0, i7);
            System.arraycopy(bArr6, i7, bArr8, 0, 8);
            byte[] bArr9 = new byte[8];
            SHA1Digest sHA1Digest = this.f6004a;
            sHA1Digest.update(bArr7, 0, i7);
            byte[] bArr10 = this.b;
            sHA1Digest.c(0, bArr10);
            System.arraycopy(bArr10, 0, bArr9, 0, 8);
            if (Arrays.l(bArr9, bArr8)) {
                byte b2 = bArr7[0];
                if (i7 - ((b2 & UnsignedBytes.MAX_VALUE) + 1) <= 7) {
                    byte[] bArr11 = new byte[b2];
                    System.arraycopy(bArr7, 1, bArr11, 0, b2);
                    return bArr11;
                }
                throw new InvalidCipherTextException("too many pad bytes (" + (i7 - ((bArr7[0] & UnsignedBytes.MAX_VALUE) + 1)) + ")");
            }
            throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
        } else {
            throw new InvalidCipherTextException("Ciphertext not multiple of " + this.f6005a.c());
        }
    }

    public final byte[] d(byte[] bArr, int i) {
        int i2;
        if (this.f6007a) {
            int i3 = i + 1;
            int i4 = i3 % 8;
            if (i4 != 0) {
                i2 = (8 - i4) + i3;
            } else {
                i2 = i3;
            }
            byte[] bArr2 = new byte[i2];
            bArr2[0] = (byte) i;
            System.arraycopy(bArr, 0, bArr2, 1, i);
            int i5 = (i2 - i) - 1;
            byte[] bArr3 = new byte[i5];
            if (i5 > 0) {
                this.a.nextBytes(bArr3);
                System.arraycopy(bArr3, 0, bArr2, i3, i5);
            }
            byte[] bArr4 = new byte[8];
            SHA1Digest sHA1Digest = this.f6004a;
            sHA1Digest.update(bArr2, 0, i2);
            byte[] bArr5 = this.b;
            sHA1Digest.c(0, bArr5);
            System.arraycopy(bArr5, 0, bArr4, 0, 8);
            int i6 = i2 + 8;
            byte[] bArr6 = new byte[i6];
            System.arraycopy(bArr2, 0, bArr6, 0, i2);
            System.arraycopy(bArr4, 0, bArr6, i2, 8);
            byte[] bArr7 = new byte[i6];
            System.arraycopy(bArr6, 0, bArr7, 0, i6);
            int c2 = i6 / this.f6005a.c();
            if (i6 % this.f6005a.c() == 0) {
                this.f6005a.a(true, this.f6006a);
                for (int i7 = 0; i7 < c2; i7++) {
                    int c3 = this.f6005a.c() * i7;
                    this.f6005a.e(c3, c3, bArr7, bArr7);
                }
                byte[] bArr8 = this.f6008a;
                int length = bArr8.length + i6;
                byte[] bArr9 = new byte[length];
                System.arraycopy(bArr8, 0, bArr9, 0, bArr8.length);
                System.arraycopy(bArr7, 0, bArr9, this.f6008a.length, i6);
                byte[] bArr10 = new byte[length];
                int i8 = 0;
                while (i8 < length) {
                    int i9 = i8 + 1;
                    bArr10[i8] = bArr9[length - i9];
                    i8 = i9;
                }
                this.f6005a.a(true, new ParametersWithIV(this.f6003a, c, 0, 8));
                for (int i10 = 0; i10 < c2 + 1; i10++) {
                    int c4 = this.f6005a.c() * i10;
                    this.f6005a.e(c4, c4, bArr10, bArr10);
                }
                return bArr10;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
