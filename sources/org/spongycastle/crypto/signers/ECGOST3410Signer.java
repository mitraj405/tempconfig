package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;

public class ECGOST3410Signer implements DSA {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public ECKeyParameters f6272a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f6272a = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.a;
            this.f6272a = (ECPrivateKeyParameters) parametersWithRandom.f6234a;
        } else {
            this.a = new SecureRandom();
            this.f6272a = (ECPrivateKeyParameters) cipherParameters;
        }
    }

    public final BigInteger[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger = new BigInteger(1, bArr2);
        ECKeyParameters eCKeyParameters = this.f6272a;
        ECDomainParameters eCDomainParameters = eCKeyParameters.a;
        BigInteger bigInteger2 = eCDomainParameters.g;
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) eCKeyParameters;
        FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
        while (true) {
            BigInteger bigInteger3 = new BigInteger(bigInteger2.bitLength(), this.a);
            BigInteger bigInteger4 = ECConstants.a;
            if (!bigInteger3.equals(bigInteger4)) {
                ECPoint o = fixedPointCombMultiplier.a(eCDomainParameters.f6230a, bigInteger3).o();
                o.b();
                BigInteger mod = o.f6621a.t().mod(bigInteger2);
                if (!mod.equals(bigInteger4)) {
                    BigInteger mod2 = bigInteger3.multiply(bigInteger).add(eCPrivateKeyParameters.a.multiply(mod)).mod(bigInteger2);
                    if (!mod2.equals(bigInteger4)) {
                        return new BigInteger[]{mod, mod2};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final boolean c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, bArr2);
        BigInteger bigInteger4 = this.f6272a.a.g;
        BigInteger bigInteger5 = ECConstants.b;
        if (bigInteger.compareTo(bigInteger5) < 0 || bigInteger.compareTo(bigInteger4) >= 0 || bigInteger2.compareTo(bigInteger5) < 0 || bigInteger2.compareTo(bigInteger4) >= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger3.modInverse(bigInteger4);
        BigInteger mod = bigInteger2.multiply(modInverse).mod(bigInteger4);
        BigInteger mod2 = bigInteger4.subtract(bigInteger).multiply(modInverse).mod(bigInteger4);
        ECKeyParameters eCKeyParameters = this.f6272a;
        ECPoint o = ECAlgorithms.g(eCKeyParameters.a.f6230a, mod, ((ECPublicKeyParameters) eCKeyParameters).a, mod2).o();
        if (o.k()) {
            return false;
        }
        o.b();
        return o.f6621a.t().mod(bigInteger4).equals(bigInteger);
    }
}
