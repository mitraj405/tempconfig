package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Properties;

public class ECMQVBasicAgreement implements BasicAgreement {
    public MQVPrivateParameters a;

    public final void a(CipherParameters cipherParameters) {
        this.a = (MQVPrivateParameters) cipherParameters;
    }

    public final BigInteger b(CipherParameters cipherParameters) {
        if (!Properties.b("org.spongycastle.ec.disable_mqv")) {
            MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
            ECPrivateKeyParameters eCPrivateKeyParameters = this.a.a;
            ECDomainParameters eCDomainParameters = eCPrivateKeyParameters.a;
            if (eCDomainParameters.equals(mQVPublicParameters.a.a)) {
                MQVPrivateParameters mQVPrivateParameters = this.a;
                ECPrivateKeyParameters eCPrivateKeyParameters2 = mQVPrivateParameters.b;
                BigInteger bigInteger = eCDomainParameters.g;
                int bitLength = (bigInteger.bitLength() + 1) / 2;
                BigInteger shiftLeft = ECConstants.b.shiftLeft(bitLength);
                ECPoint eCPoint = mQVPrivateParameters.f6232a.a;
                ECCurve eCCurve = eCDomainParameters.a;
                ECPoint[] eCPointArr = {ECAlgorithms.d(eCCurve, eCPoint), ECAlgorithms.d(eCCurve, mQVPublicParameters.a.a), ECAlgorithms.d(eCCurve, mQVPublicParameters.b.a)};
                eCCurve.p(eCPointArr, 0, 3, (ECFieldElement) null);
                ECPoint eCPoint2 = eCPointArr[0];
                ECPoint eCPoint3 = eCPointArr[1];
                ECPoint eCPoint4 = eCPointArr[2];
                eCPoint2.b();
                BigInteger mod = eCPrivateKeyParameters.a.multiply(eCPoint2.f6621a.t().mod(shiftLeft).setBit(bitLength)).add(eCPrivateKeyParameters2.a).mod(bigInteger);
                eCPoint4.b();
                BigInteger bit = eCPoint4.f6621a.t().mod(shiftLeft).setBit(bitLength);
                BigInteger mod2 = eCDomainParameters.h.multiply(mod).mod(bigInteger);
                ECPoint o = ECAlgorithms.g(eCPoint3, bit.multiply(mod2).mod(bigInteger), eCPoint4, mod2).o();
                if (!o.k()) {
                    o.b();
                    return o.f6621a.t();
                }
                throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
            }
            throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
        }
        throw new IllegalStateException("ECMQV explicitly disabled");
    }

    public final int getFieldSize() {
        return (this.a.a.a.a.k() + 7) / 8;
    }
}
