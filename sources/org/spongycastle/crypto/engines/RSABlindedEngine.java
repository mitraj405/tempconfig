package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.spongycastle.util.BigIntegers;

public class RSABlindedEngine implements AsymmetricBlockCipher {
    public static final BigInteger a = BigInteger.valueOf(1);

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6025a;

    /* renamed from: a  reason: collision with other field name */
    public final RSACoreEngine f6026a = new RSACoreEngine();

    /* renamed from: a  reason: collision with other field name */
    public RSAKeyParameters f6027a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6026a.e(z, cipherParameters);
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f6027a = (RSAKeyParameters) parametersWithRandom.f6234a;
            this.f6025a = parametersWithRandom.a;
            return;
        }
        this.f6027a = (RSAKeyParameters) cipherParameters;
        this.f6025a = new SecureRandom();
    }

    public final int b() {
        return this.f6026a.d();
    }

    public final byte[] c(int i, byte[] bArr, int i2) {
        BigInteger bigInteger;
        if (this.f6027a != null) {
            RSACoreEngine rSACoreEngine = this.f6026a;
            BigInteger a2 = rSACoreEngine.a(i, bArr, i2);
            RSAKeyParameters rSAKeyParameters = this.f6027a;
            if (rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) {
                RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters;
                BigInteger bigInteger2 = rSAPrivateCrtKeyParameters.d;
                if (bigInteger2 != null) {
                    BigInteger bigInteger3 = rSAPrivateCrtKeyParameters.a;
                    BigInteger bigInteger4 = a;
                    BigInteger c = BigIntegers.c(bigInteger4, bigInteger3.subtract(bigInteger4), this.f6025a);
                    bigInteger = rSACoreEngine.f(c.modPow(bigInteger2, bigInteger3).multiply(a2).mod(bigInteger3)).multiply(c.modInverse(bigInteger3)).mod(bigInteger3);
                    if (!a2.equals(bigInteger.modPow(bigInteger2, bigInteger3))) {
                        throw new IllegalStateException("RSA engine faulty decryption/signing detected");
                    }
                } else {
                    bigInteger = rSACoreEngine.f(a2);
                }
            } else {
                bigInteger = rSACoreEngine.f(a2);
            }
            return rSACoreEngine.b(bigInteger);
        }
        throw new IllegalStateException("RSA engine not initialised");
    }

    public final int d() {
        return this.f6026a.c();
    }
}
