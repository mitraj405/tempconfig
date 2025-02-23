package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class KeyDerivationFunc extends ASN1Object {
    public final AlgorithmIdentifier a;

    public KeyDerivationFunc(ASN1ObjectIdentifier aSN1ObjectIdentifier, PBKDF2Params pBKDF2Params) {
        this.a = new AlgorithmIdentifier(aSN1ObjectIdentifier, pBKDF2Params);
    }

    public final ASN1Primitive b() {
        return this.a.b();
    }

    public KeyDerivationFunc(ASN1Sequence aSN1Sequence) {
        this.a = AlgorithmIdentifier.g(aSN1Sequence);
    }
}
