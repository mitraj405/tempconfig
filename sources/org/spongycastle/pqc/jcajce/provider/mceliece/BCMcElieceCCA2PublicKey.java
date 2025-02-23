package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;

public class BCMcElieceCCA2PublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    public final McElieceCCA2PublicKeyParameters a;

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this.a = mcElieceCCA2PublicKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey)) {
            return false;
        }
        McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = this.a;
        int i = mcElieceCCA2PublicKeyParameters.c;
        McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters2 = ((BCMcElieceCCA2PublicKey) obj).a;
        if (i == mcElieceCCA2PublicKeyParameters2.c && mcElieceCCA2PublicKeyParameters.d == mcElieceCCA2PublicKeyParameters2.d && mcElieceCCA2PublicKeyParameters.a.equals(mcElieceCCA2PublicKeyParameters2.a)) {
            return true;
        }
        return false;
    }

    public final String getAlgorithm() {
        return "McEliece-CCA2";
    }

    public final byte[] getEncoded() {
        McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = this.a;
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.g), (ASN1Object) new McElieceCCA2PublicKey(mcElieceCCA2PublicKeyParameters.c, mcElieceCCA2PublicKeyParameters.d, mcElieceCCA2PublicKeyParameters.a, Utils.a(mcElieceCCA2PublicKeyParameters.c))).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = this.a;
        int i = mcElieceCCA2PublicKeyParameters.c;
        return mcElieceCCA2PublicKeyParameters.a.hashCode() + (((mcElieceCCA2PublicKeyParameters.d * 37) + i) * 37);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("McEliecePublicKey:\n length of the code         : ");
        McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters = this.a;
        StringBuilder n = lf.n(lf.k(lf.n(lf.k(sb, mcElieceCCA2PublicKeyParameters.c, "\n"), " error correction capability: "), mcElieceCCA2PublicKeyParameters.d, "\n"), " generator matrix           : ");
        n.append(mcElieceCCA2PublicKeyParameters.a.toString());
        return n.toString();
    }
}
