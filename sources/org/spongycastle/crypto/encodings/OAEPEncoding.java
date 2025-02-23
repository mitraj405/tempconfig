package org.spongycastle.crypto.encodings;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class OAEPEncoding implements AsymmetricBlockCipher {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f5892a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f5893a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5894a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5895a;

    public OAEPEncoding() {
        throw null;
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, ExtendedDigest extendedDigest, ExtendedDigest extendedDigest2, byte[] bArr) {
        this.f5892a = asymmetricBlockCipher;
        this.f5893a = extendedDigest2;
        byte[] bArr2 = new byte[extendedDigest.f()];
        this.f5895a = bArr2;
        extendedDigest.reset();
        if (bArr != null) {
            extendedDigest.update(bArr, 0, bArr.length);
        }
        extendedDigest.c(0, bArr2);
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.a = ((ParametersWithRandom) cipherParameters).a;
        } else {
            this.a = new SecureRandom();
        }
        this.f5892a.a(z, cipherParameters);
        this.f5894a = z;
    }

    public final int b() {
        int b = this.f5892a.b();
        if (this.f5894a) {
            return b;
        }
        return (b - 1) - (this.f5895a.length * 2);
    }

    public final byte[] c(int i, byte[] bArr, int i2) throws InvalidCipherTextException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = this.f5894a;
        byte[] bArr2 = this.f5895a;
        AsymmetricBlockCipher asymmetricBlockCipher = this.f5892a;
        if (!z6) {
            byte[] c = asymmetricBlockCipher.c(i, bArr, i2);
            int b = asymmetricBlockCipher.b();
            byte[] bArr3 = new byte[b];
            System.arraycopy(c, 0, bArr3, b - c.length, c.length);
            if (b < (bArr2.length * 2) + 1) {
                z = true;
            } else {
                z = false;
            }
            byte[] e = e(bArr2.length, b - bArr2.length, bArr3, bArr2.length);
            for (int i3 = 0; i3 != bArr2.length; i3++) {
                bArr3[i3] = (byte) (bArr3[i3] ^ e[i3]);
            }
            byte[] e2 = e(0, bArr2.length, bArr3, b - bArr2.length);
            for (int length = bArr2.length; length != b; length++) {
                bArr3[length] = (byte) (bArr3[length] ^ e2[length - bArr2.length]);
            }
            boolean z7 = false;
            for (int i4 = 0; i4 != bArr2.length; i4++) {
                if (bArr2[i4] != bArr3[bArr2.length + i4]) {
                    z7 = true;
                }
            }
            int i5 = b;
            for (int length2 = bArr2.length * 2; length2 != b; length2++) {
                if (bArr3[length2] != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (i5 == b) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z4 && z5) {
                    i5 = length2;
                }
            }
            if (i5 > b - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bArr3[i5] != 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i6 = i5 + 1;
            if (!(z | z7) && !(z2 | z3)) {
                int i7 = b - i6;
                byte[] bArr4 = new byte[i7];
                System.arraycopy(bArr3, i6, bArr4, 0, i7);
                return bArr4;
            }
            Arrays.p(bArr3, (byte) 0);
            throw new InvalidCipherTextException("data wrong");
        } else if (i2 <= d()) {
            int length3 = (bArr2.length * 2) + d() + 1;
            byte[] bArr5 = new byte[length3];
            int i8 = length3 - i2;
            System.arraycopy(bArr, i, bArr5, i8, i2);
            bArr5[i8 - 1] = 1;
            System.arraycopy(bArr2, 0, bArr5, bArr2.length, bArr2.length);
            int length4 = bArr2.length;
            byte[] bArr6 = new byte[length4];
            this.a.nextBytes(bArr6);
            byte[] e3 = e(0, length4, bArr6, length3 - bArr2.length);
            for (int length5 = bArr2.length; length5 != length3; length5++) {
                bArr5[length5] = (byte) (bArr5[length5] ^ e3[length5 - bArr2.length]);
            }
            System.arraycopy(bArr6, 0, bArr5, 0, bArr2.length);
            byte[] e4 = e(bArr2.length, length3 - bArr2.length, bArr5, bArr2.length);
            for (int i9 = 0; i9 != bArr2.length; i9++) {
                bArr5[i9] = (byte) (bArr5[i9] ^ e4[i9]);
            }
            return asymmetricBlockCipher.c(0, bArr5, length3);
        } else {
            throw new DataLengthException("input data too long");
        }
    }

    public final int d() {
        int d = this.f5892a.d();
        if (this.f5894a) {
            return (d - 1) - (this.f5895a.length * 2);
        }
        return d;
    }

    public final byte[] e(int i, int i2, byte[] bArr, int i3) {
        int i4 = i;
        int i5 = i2;
        byte[] bArr2 = bArr;
        int i6 = i3;
        byte[] bArr3 = new byte[i6];
        Digest digest = this.f5893a;
        int f = digest.f();
        byte[] bArr4 = new byte[f];
        byte[] bArr5 = new byte[4];
        digest.reset();
        int i7 = 0;
        while (i7 < i6 / f) {
            bArr5[0] = (byte) (i7 >>> 24);
            bArr5[1] = (byte) (i7 >>> 16);
            bArr5[2] = (byte) (i7 >>> 8);
            bArr5[3] = (byte) (i7 >>> 0);
            digest.update(bArr2, i4, i5);
            digest.update(bArr5, 0, 4);
            digest.c(0, bArr4);
            System.arraycopy(bArr4, 0, bArr3, i7 * f, f);
            i7++;
        }
        int i8 = f * i7;
        if (i8 < i6) {
            bArr5[0] = (byte) (i7 >>> 24);
            bArr5[1] = (byte) (i7 >>> 16);
            bArr5[2] = (byte) (i7 >>> 8);
            bArr5[3] = (byte) (i7 >>> 0);
            digest.update(bArr2, i4, i5);
            digest.update(bArr5, 0, 4);
            digest.c(0, bArr4);
            System.arraycopy(bArr4, 0, bArr3, i8, i6 - i8);
        }
        return bArr3;
    }
}
