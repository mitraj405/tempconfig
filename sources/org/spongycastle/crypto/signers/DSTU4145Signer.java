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
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.Arrays;

public class DSTU4145Signer implements DSA {
    public static final BigInteger g = BigInteger.valueOf(1);
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public ECKeyParameters f6269a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.a = parametersWithRandom.a;
                cipherParameters = parametersWithRandom.f6234a;
            } else {
                this.a = new SecureRandom();
            }
            this.f6269a = (ECPrivateKeyParameters) cipherParameters;
            return;
        }
        this.f6269a = (ECPublicKeyParameters) cipherParameters;
    }

    public final BigInteger[] b(byte[] bArr) {
        ECDomainParameters eCDomainParameters = this.f6269a.a;
        ECCurve eCCurve = eCDomainParameters.a;
        BigInteger bigInteger = new BigInteger(1, Arrays.y(bArr));
        int k = eCCurve.k();
        int bitLength = bigInteger.bitLength();
        BigInteger bigInteger2 = g;
        if (bitLength > k) {
            bigInteger = bigInteger.mod(bigInteger2.shiftLeft(k));
        }
        ECFieldElement j = eCCurve.j(bigInteger);
        if (j.i()) {
            j = eCCurve.j(bigInteger2);
        }
        BigInteger bigInteger3 = ((ECPrivateKeyParameters) this.f6269a).a;
        FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
        while (true) {
            SecureRandom secureRandom = this.a;
            BigInteger bigInteger4 = eCDomainParameters.g;
            BigInteger bigInteger5 = new BigInteger(bigInteger4.bitLength() - 1, secureRandom);
            ECPoint o = fixedPointCombMultiplier.a(eCDomainParameters.f6230a, bigInteger5).o();
            o.b();
            ECFieldElement eCFieldElement = o.f6621a;
            if (!eCFieldElement.i()) {
                BigInteger t = j.j(eCFieldElement).t();
                int bitLength2 = bigInteger4.bitLength() - 1;
                if (t.bitLength() > bitLength2) {
                    t = t.mod(bigInteger2.shiftLeft(bitLength2));
                }
                if (t.signum() != 0) {
                    BigInteger mod = t.multiply(bigInteger3).add(bigInteger5).mod(bigInteger4);
                    if (mod.signum() != 0) {
                        return new BigInteger[]{t, mod};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final boolean c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        if (bigInteger.signum() <= 0 || bigInteger2.signum() <= 0) {
            return false;
        }
        ECDomainParameters eCDomainParameters = this.f6269a.a;
        BigInteger bigInteger3 = eCDomainParameters.g;
        if (bigInteger.compareTo(bigInteger3) >= 0 || bigInteger2.compareTo(bigInteger3) >= 0) {
            return false;
        }
        BigInteger bigInteger4 = new BigInteger(1, Arrays.y(bArr));
        ECCurve eCCurve = eCDomainParameters.a;
        int k = eCCurve.k();
        int bitLength = bigInteger4.bitLength();
        BigInteger bigInteger5 = g;
        if (bitLength > k) {
            bigInteger4 = bigInteger4.mod(bigInteger5.shiftLeft(k));
        }
        ECFieldElement j = eCCurve.j(bigInteger4);
        if (j.i()) {
            j = eCCurve.j(bigInteger5);
        }
        ECPoint o = ECAlgorithms.g(eCDomainParameters.f6230a, bigInteger2, ((ECPublicKeyParameters) this.f6269a).a, bigInteger).o();
        if (o.k()) {
            return false;
        }
        o.b();
        BigInteger t = j.j(o.f6621a).t();
        int bitLength2 = bigInteger3.bitLength() - 1;
        if (t.bitLength() > bitLength2) {
            t = t.mod(bigInteger5.shiftLeft(bitLength2));
        }
        if (t.compareTo(bigInteger) == 0) {
            return true;
        }
        return false;
    }
}
