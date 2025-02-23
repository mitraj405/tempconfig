package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.McEliecePublicKey;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;

public class BCMcEliecePublicKey implements PublicKey {
    private static final long serialVersionUID = 1;
    public final McEliecePublicKeyParameters a;

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this.a = mcEliecePublicKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        McEliecePublicKeyParameters mcEliecePublicKeyParameters = this.a;
        int i = mcEliecePublicKeyParameters.c;
        McEliecePublicKeyParameters mcEliecePublicKeyParameters2 = ((BCMcEliecePublicKey) obj).a;
        if (i == mcEliecePublicKeyParameters2.c && mcEliecePublicKeyParameters.d == mcEliecePublicKeyParameters2.d && mcEliecePublicKeyParameters.a.equals(mcEliecePublicKeyParameters2.a)) {
            return true;
        }
        return false;
    }

    public final String getAlgorithm() {
        return "McEliece";
    }

    public final byte[] getEncoded() {
        McEliecePublicKeyParameters mcEliecePublicKeyParameters = this.a;
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.f), (ASN1Object) new McEliecePublicKey(mcEliecePublicKeyParameters.c, mcEliecePublicKeyParameters.d, mcEliecePublicKeyParameters.a)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        McEliecePublicKeyParameters mcEliecePublicKeyParameters = this.a;
        int i = mcEliecePublicKeyParameters.c;
        return mcEliecePublicKeyParameters.a.hashCode() + (((mcEliecePublicKeyParameters.d * 37) + i) * 37);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("McEliecePublicKey:\n length of the code         : ");
        McEliecePublicKeyParameters mcEliecePublicKeyParameters = this.a;
        StringBuilder n = lf.n(lf.k(lf.n(lf.k(sb, mcEliecePublicKeyParameters.c, "\n"), " error correction capability: "), mcEliecePublicKeyParameters.d, "\n"), " generator matrix           : ");
        n.append(mcEliecePublicKeyParameters.a);
        return n.toString();
    }
}
