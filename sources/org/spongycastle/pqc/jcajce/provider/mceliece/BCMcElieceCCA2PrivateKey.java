package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcElieceCCA2PrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    public final McElieceCCA2PrivateKeyParameters a;

    public BCMcElieceCCA2PrivateKey(McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters) {
        this.a = mcElieceCCA2PrivateKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PrivateKey)) {
            return false;
        }
        BCMcElieceCCA2PrivateKey bCMcElieceCCA2PrivateKey = (BCMcElieceCCA2PrivateKey) obj;
        McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = this.a;
        int i = mcElieceCCA2PrivateKeyParameters.c;
        McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters2 = bCMcElieceCCA2PrivateKey.a;
        if (i != mcElieceCCA2PrivateKeyParameters2.c || mcElieceCCA2PrivateKeyParameters.d != mcElieceCCA2PrivateKeyParameters2.d || !mcElieceCCA2PrivateKeyParameters.f6676a.equals(mcElieceCCA2PrivateKeyParameters2.f6676a)) {
            return false;
        }
        PolynomialGF2mSmallM polynomialGF2mSmallM = mcElieceCCA2PrivateKeyParameters.f6678a;
        McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters3 = bCMcElieceCCA2PrivateKey.a;
        if (!polynomialGF2mSmallM.equals(mcElieceCCA2PrivateKeyParameters3.f6678a) || !mcElieceCCA2PrivateKeyParameters.f6677a.equals(mcElieceCCA2PrivateKeyParameters3.f6677a) || !mcElieceCCA2PrivateKeyParameters.a.equals(mcElieceCCA2PrivateKeyParameters3.a)) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public final byte[] getEncoded() {
        try {
            McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = this.a;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.g), new McElieceCCA2PrivateKey(mcElieceCCA2PrivateKeyParameters.c, mcElieceCCA2PrivateKeyParameters.d, mcElieceCCA2PrivateKeyParameters.f6676a, mcElieceCCA2PrivateKeyParameters.f6678a, mcElieceCCA2PrivateKeyParameters.f6677a, Utils.a(mcElieceCCA2PrivateKeyParameters.c))).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        McElieceCCA2PrivateKeyParameters mcElieceCCA2PrivateKeyParameters = this.a;
        int hashCode = mcElieceCCA2PrivateKeyParameters.f6676a.hashCode();
        int hashCode2 = mcElieceCCA2PrivateKeyParameters.f6678a.hashCode();
        int hashCode3 = mcElieceCCA2PrivateKeyParameters.f6677a.hashCode();
        return mcElieceCCA2PrivateKeyParameters.a.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (((mcElieceCCA2PrivateKeyParameters.d * 37) + mcElieceCCA2PrivateKeyParameters.c) * 37)) * 37)) * 37)) * 37);
    }
}
