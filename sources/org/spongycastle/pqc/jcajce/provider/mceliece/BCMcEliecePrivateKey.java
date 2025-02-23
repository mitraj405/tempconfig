package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McEliecePrivateKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcEliecePrivateKey implements CipherParameters, PrivateKey {
    private static final long serialVersionUID = 1;
    public final McEliecePrivateKeyParameters a;

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this.a = mcEliecePrivateKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = this.a;
        int i = mcEliecePrivateKeyParameters.c;
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters2 = bCMcEliecePrivateKey.a;
        if (i != mcEliecePrivateKeyParameters2.c || mcEliecePrivateKeyParameters.d != mcEliecePrivateKeyParameters2.d || !mcEliecePrivateKeyParameters.f6699a.equals(mcEliecePrivateKeyParameters2.f6699a)) {
            return false;
        }
        PolynomialGF2mSmallM polynomialGF2mSmallM = mcEliecePrivateKeyParameters.f6701a;
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters3 = bCMcEliecePrivateKey.a;
        if (!polynomialGF2mSmallM.equals(mcEliecePrivateKeyParameters3.f6701a) || !mcEliecePrivateKeyParameters.a.equals(mcEliecePrivateKeyParameters3.a) || !mcEliecePrivateKeyParameters.f6700a.equals(mcEliecePrivateKeyParameters3.f6700a) || !mcEliecePrivateKeyParameters.f6703b.equals(mcEliecePrivateKeyParameters3.f6703b)) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "McEliece";
    }

    public final byte[] getEncoded() {
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = this.a;
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f), new McEliecePrivateKey(mcEliecePrivateKeyParameters.c, mcEliecePrivateKeyParameters.d, mcEliecePrivateKeyParameters.f6699a, mcEliecePrivateKeyParameters.f6701a, mcEliecePrivateKeyParameters.f6700a, mcEliecePrivateKeyParameters.f6703b, mcEliecePrivateKeyParameters.a)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = this.a;
        int hashCode = mcEliecePrivateKeyParameters.f6699a.hashCode();
        int hashCode2 = mcEliecePrivateKeyParameters.f6701a.hashCode();
        int hashCode3 = mcEliecePrivateKeyParameters.f6700a.hashCode();
        int hashCode4 = mcEliecePrivateKeyParameters.f6703b.hashCode();
        return mcEliecePrivateKeyParameters.a.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (((mcEliecePrivateKeyParameters.d * 37) + mcEliecePrivateKeyParameters.c) * 37)) * 37)) * 37)) * 37)) * 37);
    }
}
