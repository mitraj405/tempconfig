package org.spongycastle.crypto.engines;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class DESedeWrapEngine implements Wrapper {
    public static final byte[] c = {74, -35, -94, 44, 121, -24, 33, 5};
    public final SHA1Digest a = new SHA1Digest();

    /* renamed from: a  reason: collision with other field name */
    public CBCBlockCipher f5937a;

    /* renamed from: a  reason: collision with other field name */
    public KeyParameter f5938a;

    /* renamed from: a  reason: collision with other field name */
    public ParametersWithIV f5939a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5940a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5941a;
    public final byte[] b = new byte[20];

    public final void a(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        this.f5940a = z;
        this.f5937a = new CBCBlockCipher(new DESedeEngine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            CipherParameters cipherParameters2 = parametersWithRandom.f6234a;
            SecureRandom secureRandom2 = parametersWithRandom.a;
            cipherParameters = cipherParameters2;
            secureRandom = secureRandom2;
        } else {
            secureRandom = new SecureRandom();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.f5938a = (KeyParameter) cipherParameters;
            if (this.f5940a) {
                byte[] bArr = new byte[8];
                this.f5941a = bArr;
                secureRandom.nextBytes(bArr);
                this.f5939a = new ParametersWithIV(this.f5938a, this.f5941a);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f5939a = parametersWithIV;
            byte[] bArr2 = parametersWithIV.f6233a;
            this.f5941a = bArr2;
            this.f5938a = (KeyParameter) parametersWithIV.a;
            if (!this.f5940a) {
                throw new IllegalArgumentException("You should not supply an IV for unwrapping");
            } else if (bArr2 == null || bArr2.length != 8) {
                throw new IllegalArgumentException("IV is not 8 octets");
            }
        }
    }

    public final String b() {
        return "DESede";
    }

    public final byte[] c(byte[] bArr, int i) throws InvalidCipherTextException {
        if (this.f5940a) {
            throw new IllegalStateException("Not set for unwrapping");
        } else if (bArr != null) {
            int c2 = this.f5937a.c();
            if (i % c2 == 0) {
                this.f5937a.a(false, new ParametersWithIV(this.f5938a, c, 0, 8));
                byte[] bArr2 = new byte[i];
                for (int i2 = 0; i2 != i; i2 += c2) {
                    this.f5937a.e(0 + i2, i2, bArr, bArr2);
                }
                byte[] bArr3 = new byte[i];
                int i3 = 0;
                while (i3 < i) {
                    int i4 = i3 + 1;
                    bArr3[i3] = bArr2[i - i4];
                    i3 = i4;
                }
                byte[] bArr4 = new byte[8];
                this.f5941a = bArr4;
                int i5 = i - 8;
                byte[] bArr5 = new byte[i5];
                System.arraycopy(bArr3, 0, bArr4, 0, 8);
                System.arraycopy(bArr3, 8, bArr5, 0, i5);
                ParametersWithIV parametersWithIV = new ParametersWithIV(this.f5938a, this.f5941a);
                this.f5939a = parametersWithIV;
                this.f5937a.a(false, parametersWithIV);
                byte[] bArr6 = new byte[i5];
                for (int i6 = 0; i6 != i5; i6 += c2) {
                    this.f5937a.e(i6, i6, bArr5, bArr6);
                }
                int i7 = i5 - 8;
                byte[] bArr7 = new byte[i7];
                byte[] bArr8 = new byte[8];
                System.arraycopy(bArr6, 0, bArr7, 0, i7);
                System.arraycopy(bArr6, i7, bArr8, 0, 8);
                byte[] bArr9 = new byte[8];
                SHA1Digest sHA1Digest = this.a;
                sHA1Digest.update(bArr7, 0, i7);
                byte[] bArr10 = this.b;
                sHA1Digest.c(0, bArr10);
                System.arraycopy(bArr10, 0, bArr9, 0, 8);
                if (Arrays.l(bArr9, bArr8)) {
                    return bArr7;
                }
                throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
            }
            throw new InvalidCipherTextException(lf.h("Ciphertext not multiple of ", c2));
        } else {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
    }

    public final byte[] d(byte[] bArr, int i) {
        if (this.f5940a) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            byte[] bArr3 = new byte[8];
            SHA1Digest sHA1Digest = this.a;
            sHA1Digest.update(bArr2, 0, i);
            byte[] bArr4 = this.b;
            sHA1Digest.c(0, bArr4);
            System.arraycopy(bArr4, 0, bArr3, 0, 8);
            int i2 = i + 8;
            byte[] bArr5 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr5, 0, i);
            System.arraycopy(bArr3, 0, bArr5, i, 8);
            int c2 = this.f5937a.c();
            if (i2 % c2 == 0) {
                this.f5937a.a(true, this.f5939a);
                byte[] bArr6 = new byte[i2];
                for (int i3 = 0; i3 != i2; i3 += c2) {
                    this.f5937a.e(i3, i3, bArr5, bArr6);
                }
                byte[] bArr7 = this.f5941a;
                int length = bArr7.length + i2;
                byte[] bArr8 = new byte[length];
                System.arraycopy(bArr7, 0, bArr8, 0, bArr7.length);
                System.arraycopy(bArr6, 0, bArr8, this.f5941a.length, i2);
                byte[] bArr9 = new byte[length];
                int i4 = 0;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    bArr9[i4] = bArr8[length - i5];
                    i4 = i5;
                }
                this.f5937a.a(true, new ParametersWithIV(this.f5938a, c, 0, 8));
                for (int i6 = 0; i6 != length; i6 += c2) {
                    this.f5937a.e(i6, i6, bArr9, bArr9);
                }
                return bArr9;
            }
            throw new IllegalStateException("Not multiple of block length");
        }
        throw new IllegalStateException("Not initialized for wrapping");
    }
}
