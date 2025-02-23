package org.spongycastle.pqc.jcajce.provider.gmss;

import java.security.PublicKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.util.encoders.Hex;

public class BCGMSSPublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;

    public final String getAlgorithm() {
        return "GMSS";
    }

    public final byte[] getEncoded() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.a;
        throw null;
    }

    public final String getFormat() {
        return "X.509";
    }

    public final String toString() {
        Hex.c((byte[]) null);
        throw null;
    }
}
