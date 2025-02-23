package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class X931Signer implements Signer {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f6299a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6300a;

    /* renamed from: a  reason: collision with other field name */
    public RSAKeyParameters f6301a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6302a;

    public X931Signer(RSABlindedEngine rSABlindedEngine, Digest digest) {
        this.f6299a = rSABlindedEngine;
        this.f6300a = digest;
        Integer num = ISOTrailers.a.get(digest.b());
        if (num != null) {
            this.a = num.intValue();
            return;
        }
        throw new IllegalArgumentException("no valid trailer for digest: " + digest.b());
    }

    public final void a() {
        int i;
        Digest digest = this.f6300a;
        int f = digest.f();
        int i2 = this.a;
        if (i2 == 188) {
            byte[] bArr = this.f6302a;
            i = (bArr.length - f) - 1;
            digest.c(i, bArr);
            byte[] bArr2 = this.f6302a;
            bArr2[bArr2.length - 1] = -68;
        } else {
            byte[] bArr3 = this.f6302a;
            int length = (bArr3.length - f) - 2;
            digest.c(length, bArr3);
            byte[] bArr4 = this.f6302a;
            bArr4[bArr4.length - 2] = (byte) (i2 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i2;
            i = length;
        }
        this.f6302a[0] = 107;
        for (int i3 = i - 2; i3 != 0; i3--) {
            this.f6302a[i3] = -69;
        }
        this.f6302a[i - 1] = -70;
    }

    public final byte[] b() throws CryptoException {
        a();
        byte[] bArr = this.f6302a;
        BigInteger bigInteger = new BigInteger(1, this.f6299a.c(0, bArr, bArr.length));
        byte[] bArr2 = this.f6302a;
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = 0;
        }
        return BigIntegers.a((this.f6301a.a.bitLength() + 7) / 8, bigInteger.min(this.f6301a.a.subtract(bigInteger)));
    }

    public final void c(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f6301a = rSAKeyParameters;
        this.f6299a.a(z, rSAKeyParameters);
        this.f6302a = new byte[((this.f6301a.a.bitLength() + 7) / 8)];
        this.f6300a.reset();
    }

    public final void d(byte[] bArr, int i, int i2) {
        this.f6300a.update(bArr, i, i2);
    }

    public final boolean e(byte[] bArr) {
        try {
            this.f6302a = this.f6299a.c(0, bArr, bArr.length);
            BigInteger bigInteger = new BigInteger(1, this.f6302a);
            if ((bigInteger.intValue() & 15) != 12) {
                bigInteger = this.f6301a.a.subtract(bigInteger);
                if ((bigInteger.intValue() & 15) != 12) {
                    return false;
                }
            }
            a();
            byte[] a2 = BigIntegers.a(this.f6302a.length, bigInteger);
            boolean l = Arrays.l(this.f6302a, a2);
            byte[] bArr2 = this.f6302a;
            for (int i = 0; i != bArr2.length; i++) {
                bArr2[i] = 0;
            }
            for (int i2 = 0; i2 != a2.length; i2++) {
                a2[i2] = 0;
            }
            return l;
        } catch (Exception unused) {
            return false;
        }
    }
}
