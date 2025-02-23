package org.spongycastle.crypto.signers;

import com.google.firebase.perf.util.Constants;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSABlindingParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;

public class PSSSigner implements Signer {
    public final byte a;

    /* renamed from: a  reason: collision with other field name */
    public final int f6285a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6286a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f6287a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6288a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6289a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final Digest f6290b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6291b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f6292c;
    public int d;

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, ExtendedDigest extendedDigest, int i, byte b2) {
        this.f6287a = asymmetricBlockCipher;
        this.f6288a = digest;
        this.f6290b = extendedDigest;
        int f = digest.f();
        this.f6285a = f;
        this.b = extendedDigest.f();
        this.c = i;
        this.f6289a = new byte[i];
        this.f6291b = new byte[(i + 8 + f)];
        this.a = b2;
    }

    public final void a(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public final byte[] b() throws CryptoException, DataLengthException {
        byte[] bArr = this.f6291b;
        int length = bArr.length;
        int i = this.f6285a;
        int i2 = this.c;
        Digest digest = this.f6288a;
        digest.c((length - i) - i2, bArr);
        byte[] bArr2 = this.f6289a;
        if (i2 != 0) {
            this.f6286a.nextBytes(bArr2);
            System.arraycopy(bArr2, 0, bArr, bArr.length - i2, i2);
        }
        byte[] bArr3 = new byte[i];
        digest.update(bArr, 0, bArr.length);
        digest.c(0, bArr3);
        byte[] bArr4 = this.f6292c;
        bArr4[(((bArr4.length - i2) - 1) - i) - 1] = 1;
        System.arraycopy(bArr2, 0, bArr4, ((bArr4.length - i2) - i) - 1, i2);
        byte[] d2 = d(0, i, bArr3, (this.f6292c.length - i) - 1);
        for (int i3 = 0; i3 != d2.length; i3++) {
            byte[] bArr5 = this.f6292c;
            bArr5[i3] = (byte) (bArr5[i3] ^ d2[i3]);
        }
        byte[] bArr6 = this.f6292c;
        bArr6[0] = (byte) (bArr6[0] & (Constants.MAX_HOST_LENGTH >> ((bArr6.length * 8) - this.d)));
        System.arraycopy(bArr3, 0, bArr6, (bArr6.length - i) - 1, i);
        byte[] bArr7 = this.f6292c;
        bArr7[bArr7.length - 1] = this.a;
        byte[] c2 = this.f6287a.c(0, bArr7, bArr7.length);
        a(this.f6292c);
        return c2;
    }

    public final void c(boolean z, CipherParameters cipherParameters) {
        CipherParameters cipherParameters2;
        RSAKeyParameters rSAKeyParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            cipherParameters2 = parametersWithRandom.f6234a;
            this.f6286a = parametersWithRandom.a;
        } else {
            if (z) {
                this.f6286a = new SecureRandom();
            }
            cipherParameters2 = cipherParameters;
        }
        boolean z2 = cipherParameters2 instanceof RSABlindingParameters;
        AsymmetricBlockCipher asymmetricBlockCipher = this.f6287a;
        if (z2) {
            ((RSABlindingParameters) cipherParameters2).getClass();
            asymmetricBlockCipher.a(z, cipherParameters);
            rSAKeyParameters = null;
        } else {
            asymmetricBlockCipher.a(z, cipherParameters2);
            rSAKeyParameters = (RSAKeyParameters) cipherParameters2;
        }
        int bitLength = rSAKeyParameters.a.bitLength() - 1;
        this.d = bitLength;
        if (bitLength >= (this.c * 8) + (this.f6285a * 8) + 9) {
            this.f6292c = new byte[((bitLength + 7) / 8)];
            this.f6288a.reset();
            return;
        }
        throw new IllegalArgumentException("key too small for specified hash and salt lengths");
    }

    public final byte[] d(int i, int i2, byte[] bArr, int i3) {
        int i4 = i;
        int i5 = i2;
        byte[] bArr2 = bArr;
        int i6 = i3;
        byte[] bArr3 = new byte[i6];
        int i7 = this.b;
        byte[] bArr4 = new byte[i7];
        byte[] bArr5 = new byte[4];
        Digest digest = this.f6290b;
        digest.reset();
        int i8 = 0;
        while (i8 < i6 / i7) {
            bArr5[0] = (byte) (i8 >>> 24);
            bArr5[1] = (byte) (i8 >>> 16);
            bArr5[2] = (byte) (i8 >>> 8);
            bArr5[3] = (byte) (i8 >>> 0);
            digest.update(bArr2, i4, i5);
            digest.update(bArr5, 0, 4);
            digest.c(0, bArr4);
            System.arraycopy(bArr4, 0, bArr3, i8 * i7, i7);
            i8++;
        }
        int i9 = i7 * i8;
        if (i9 < i6) {
            bArr5[0] = (byte) (i8 >>> 24);
            bArr5[1] = (byte) (i8 >>> 16);
            bArr5[2] = (byte) (i8 >>> 8);
            bArr5[3] = (byte) (i8 >>> 0);
            digest.update(bArr2, i4, i5);
            digest.update(bArr5, 0, 4);
            digest.c(0, bArr4);
            System.arraycopy(bArr4, 0, bArr3, i9, i6 - i9);
        }
        return bArr3;
    }

    public final void e(byte[] bArr, int i, int i2) {
        this.f6288a.update(bArr, i, i2);
    }

    public final boolean f(byte[] bArr) {
        byte[] bArr2 = this.f6291b;
        int length = bArr2.length;
        int i = this.f6285a;
        int i2 = this.c;
        Digest digest = this.f6288a;
        digest.c((length - i) - i2, bArr2);
        try {
            byte[] c2 = this.f6287a.c(0, bArr, bArr.length);
            byte[] bArr3 = this.f6292c;
            System.arraycopy(c2, 0, bArr3, bArr3.length - c2.length, c2.length);
            byte[] bArr4 = this.f6292c;
            if (bArr4[bArr4.length - 1] != this.a) {
                a(bArr4);
                return false;
            }
            byte[] d2 = d((bArr4.length - i) - 1, i, bArr4, (bArr4.length - i) - 1);
            for (int i3 = 0; i3 != d2.length; i3++) {
                byte[] bArr5 = this.f6292c;
                bArr5[i3] = (byte) (bArr5[i3] ^ d2[i3]);
            }
            byte[] bArr6 = this.f6292c;
            bArr6[0] = (byte) (bArr6[0] & (Constants.MAX_HOST_LENGTH >> ((bArr6.length * 8) - this.d)));
            int i4 = 0;
            while (true) {
                byte[] bArr7 = this.f6292c;
                if (i4 != ((bArr7.length - i) - i2) - 2) {
                    if (bArr7[i4] != 0) {
                        a(bArr7);
                        return false;
                    }
                    i4++;
                } else if (bArr7[((bArr7.length - i) - i2) - 2] != 1) {
                    a(bArr7);
                    return false;
                } else {
                    System.arraycopy(bArr7, ((bArr7.length - i2) - i) - 1, bArr2, bArr2.length - i2, i2);
                    digest.update(bArr2, 0, bArr2.length);
                    digest.c(bArr2.length - i, bArr2);
                    int length2 = (this.f6292c.length - i) - 1;
                    for (int length3 = bArr2.length - i; length3 != bArr2.length; length3++) {
                        if ((this.f6292c[length2] ^ bArr2[length3]) != 0) {
                            a(bArr2);
                            a(this.f6292c);
                            return false;
                        }
                        length2++;
                    }
                    a(bArr2);
                    a(this.f6292c);
                    return true;
                }
            }
        } catch (Exception unused) {
            return false;
        }
    }
}
