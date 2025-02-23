package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECPoint;

public class ECNRSigner implements DSA {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public ECKeyParameters f6274a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6275a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f6275a = z;
        if (!z) {
            this.f6274a = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.a;
            this.f6274a = (ECPrivateKeyParameters) parametersWithRandom.f6234a;
        } else {
            this.a = new SecureRandom();
            this.f6274a = (ECPrivateKeyParameters) cipherParameters;
        }
    }

    public final BigInteger[] b(byte[] bArr) {
        AsymmetricCipherKeyPair a2;
        BigInteger mod;
        if (this.f6275a) {
            BigInteger bigInteger = ((ECPrivateKeyParameters) this.f6274a).a.g;
            int bitLength = bigInteger.bitLength();
            BigInteger bigInteger2 = new BigInteger(1, bArr);
            int bitLength2 = bigInteger2.bitLength();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.f6274a;
            if (bitLength2 <= bitLength) {
                do {
                    ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                    eCKeyPairGenerator.b(new ECKeyGenerationParameters(this.a, eCPrivateKeyParameters.a));
                    a2 = eCKeyPairGenerator.a();
                    ECPoint eCPoint = ((ECPublicKeyParameters) a2.a).a;
                    eCPoint.b();
                    mod = eCPoint.f6621a.t().add(bigInteger2).mod(bigInteger);
                } while (mod.equals(ECConstants.a));
                return new BigInteger[]{mod, ((ECPrivateKeyParameters) a2.b).a.subtract(mod.multiply(eCPrivateKeyParameters.a)).mod(bigInteger)};
            }
            throw new DataLengthException("input too large for ECNR key.");
        }
        throw new IllegalStateException("not initialised for signing");
    }

    public final boolean c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        if (!this.f6275a) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) this.f6274a;
            BigInteger bigInteger3 = eCPublicKeyParameters.a.g;
            int bitLength = bigInteger3.bitLength();
            BigInteger bigInteger4 = new BigInteger(1, bArr);
            if (bigInteger4.bitLength() > bitLength) {
                throw new DataLengthException("input too large for ECNR key.");
            } else if (bigInteger.compareTo(ECConstants.b) < 0 || bigInteger.compareTo(bigInteger3) >= 0 || bigInteger2.compareTo(ECConstants.a) < 0 || bigInteger2.compareTo(bigInteger3) >= 0) {
                return false;
            } else {
                ECPoint o = ECAlgorithms.g(eCPublicKeyParameters.a.f6230a, bigInteger2, eCPublicKeyParameters.a, bigInteger).o();
                if (o.k()) {
                    return false;
                }
                o.b();
                return bigInteger.subtract(o.f6621a.t()).mod(bigInteger3).equals(bigInteger4);
            }
        } else {
            throw new IllegalStateException("not initialised for verifying");
        }
    }
}
