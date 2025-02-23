package org.spongycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.spongycastle.pqc.jcajce.interfaces.NHPublicKey;
import org.spongycastle.util.Arrays;

public class BCNHPublicKey implements NHPublicKey {
    private static final long serialVersionUID = 1;
    public final NHPublicKeyParameters a;

    public BCNHPublicKey(NHPublicKeyParameters nHPublicKeyParameters) {
        this.a = nHPublicKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCNHPublicKey)) {
            return false;
        }
        return Arrays.a(Arrays.c(this.a.a), Arrays.c(((BCNHPublicKey) obj).a.a));
    }

    public final String getAlgorithm() {
        return "NH";
    }

    public final byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.k), Arrays.c(this.a.a)).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        return Arrays.t(Arrays.c(this.a.a));
    }

    public BCNHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.a = new NHPublicKeyParameters(subjectPublicKeyInfo.a.r());
    }
}
