package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class DHBasicAgreement implements BasicAgreement {
    public static final BigInteger a = BigInteger.valueOf(1);

    /* renamed from: a  reason: collision with other field name */
    public DHParameters f5800a;

    /* renamed from: a  reason: collision with other field name */
    public DHPrivateKeyParameters f5801a;

    public final void a(CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).f6234a;
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
            DHPrivateKeyParameters dHPrivateKeyParameters = (DHPrivateKeyParameters) asymmetricKeyParameter;
            this.f5801a = dHPrivateKeyParameters;
            this.f5800a = dHPrivateKeyParameters.a;
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }

    public final BigInteger b(CipherParameters cipherParameters) {
        DHPublicKeyParameters dHPublicKeyParameters = (DHPublicKeyParameters) cipherParameters;
        if (dHPublicKeyParameters.a.equals(this.f5800a)) {
            BigInteger bigInteger = this.f5800a.b;
            BigInteger bigInteger2 = dHPublicKeyParameters.a;
            if (bigInteger2 != null) {
                BigInteger bigInteger3 = a;
                if (bigInteger2.compareTo(bigInteger3) > 0 && bigInteger2.compareTo(bigInteger.subtract(bigInteger3)) < 0) {
                    BigInteger modPow = bigInteger2.modPow(this.f5801a.a, bigInteger);
                    if (!modPow.equals(bigInteger3)) {
                        return modPow;
                    }
                    throw new IllegalStateException("Shared key can't be 1");
                }
            }
            throw new IllegalArgumentException("Diffie-Hellman public key is weak");
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }

    public final int getFieldSize() {
        return (this.f5801a.a.b.bitLength() + 7) / 8;
    }
}
